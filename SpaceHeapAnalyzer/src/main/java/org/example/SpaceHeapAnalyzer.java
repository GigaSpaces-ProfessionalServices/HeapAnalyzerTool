package org.example;

import com.gigaspaces.heap.HeapUtils;
import com.gigaspaces.heap.formatters.HeapReportFormatter;
import com.gigaspaces.heap.formatters.JSonHeapReportFormatter;
import com.gigaspaces.heap.formatters.TextHeapReportFormatter;
import com.gigaspaces.heap.space.*;
import com.gigaspaces.internal.jvm.HeapUsageEstimator;
import org.netbeans.lib.profiler.heap.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;
import com.gigaspaces.heap.space.GigaSpacesClasses;

public class SpaceHeapAnalyzer {
    // Class to hold object type information.
    public static class ObjectTypeInfo {
        private long count;
        private double avgSize;

        public ObjectTypeInfo(long count, double avgSize) {
            this.count = count;
            this.avgSize = avgSize;
        }

        public long getCount() {
            return count;
        }

        public double getAvgSize() {
            return avgSize;
        }

        @Override
        public String toString() {
            return "Count: " + count + ", AvgSize: " + avgSize;
        }
    }

    public static void main(String[] args) {
        boolean RunWithJar = true;

        List ValidActionParamsList = new ArrayList<>();
        Collections.addAll(ValidActionParamsList, "HOW_MANY_OBJECTS_WE_CAN_HAVE", "SUGGEST_HEAP_SIZE");
        Map<String, ObjectTypeInfo> objectTypeReport = new HashMap<>();
        int desiredTotalObjects = 0;
        Long UserTotalHeapSize = 0l;
        int desiredFreePercentage = 0;
        Path dumpPath = null;
        String actionParam = "";
        Long desiredFreeHeapSize = 0l;
        String reportPath = null;
        boolean verbose = false;

        if (RunWithJar) {
            if (args.length == 0) {
                System.out.println("Dump path was not specified");
                System.exit(1);
            }
            dumpPath = Paths.get(args[0]);
            actionParam = args[1];
            if (!ValidActionParamsList.contains(actionParam)) {
                System.out.println("Choose an Valid Action. Options are - " + ValidActionParamsList);
            }
            if (actionParam.equals("HOW_MANY_OBJECTS_WE_CAN_HAVE")) {
                if (args.length > 3) {
                    UserTotalHeapSize = getHardLimitMemoryInBytes(args[2]);
                    desiredFreePercentage = Integer.parseInt(args[3]);
                } else {
                    System.out.println("Report Path and Verbose is Optional.  By Default ReportPath will be null and Verbose will be false");
                    System.out.println("For HOW_MANY_OBJECTS_WE_CAN_HAVE use - java -jar <SpaceHeapAnalyzer.Jar> <DumpPath> SUGGEST_HEAP_SIZE <TotalHeapSize> <DesiredFreePercentage> <ReportPath> <Verbose>");
                    System.out.println("For Example - java -jar SpaceHeapAnalyzer-1.0-SNAPSHOT-jar-with-dependencies.jar heap.hprof HOW_MANY_OBJECTS_WE_CAN_HAVE 2g 40");
                    System.exit(1);
                }
            } else if (actionParam.equals("SUGGEST_HEAP_SIZE")) {
                if (args.length > 6) {
                    desiredTotalObjects = Integer.parseInt(args[6]);
                } else {
                    System.out.println("For SUGGEST_HEAP_SIZE use - java -jar <SpaceHeapAnalyzer.Jar> <DumpPath> SUGGEST_HEAP_SIZE <TotalHeapSize> <DesiredFreePercentage> <ReportPath> <Verbose> <DesiredTotalObjects>");
                    System.out.println("For Example - java -jar SpaceHeapAnalyzer-1.0-SNAPSHOT-jar-with-dependencies.jar heap.hprof SUGGEST_HEAP_SIZE 2g 40 null false 10000");
                    System.exit(1);
                }
            }
            desiredFreeHeapSize = UserTotalHeapSize - (long) ((UserTotalHeapSize / 100.0) * desiredFreePercentage);
            reportPath = args.length >= 5 ? args[4] : null;
            verbose = args.length >= 6 ? Boolean.parseBoolean(args[5]) : false;

        } else {
            dumpPath = Paths.get("/home/sushil/Downloads/space-zipkin-01 [1]  gsc-5[318931]/gsc-sushil-laptop-pid-318931/heap.hprof");
            actionParam = "HOW_MANY_OBJECTS_WE_CAN_HAVE";
//            actionParam = "SUGGEST_HEAP_SIZE";
//            UserTotalHeapSize = args.length >= 3 ? getHardLimitMemoryInBytes(args[2]) : 2147483648l; // 2g = 2147483648
            UserTotalHeapSize = args.length >= 3 ? getHardLimitMemoryInBytes(args[2]) : 2752000000l; // 2g = 2147483648
            desiredFreePercentage = args.length >= 4 ? Integer.parseInt(args[3]) : 40;
            desiredFreeHeapSize = UserTotalHeapSize - (long) ((UserTotalHeapSize / 100.0) * desiredFreePercentage);
            reportPath = args.length >= 5 ? args[4] : null;
//        reportPath = args.length >= 5 ? args[4] : "/home/sushil/Sushil/Projects/git/CSM/text.json";
            verbose = args.length >= 6 ? Boolean.parseBoolean(args[5]) : false;
            desiredTotalObjects = args.length >= 7 ? Integer.parseInt(args[6]) : 100000;
        }

        if (!Files.exists(dumpPath)) {
            System.out.println("File not found: " + dumpPath);
            System.exit(1);
        }

        if (desiredFreePercentage < 0 || desiredFreePercentage > 100) {
            System.err.println("Error: Desired free percentage must be between 0 and 100.");
            System.exit(1);
        }


        System.out.println("Analyzing " + dumpPath + " - this may take a while...");
        try {
            int DataTypesize = 0;
            int Metadatasize = 0;
            int TotalNumOfEntriesPresentInSpace = 0;
            GigaSpacesHeapReport report = SpaceHeapAnalyzer.analyze(dumpPath, verbose);
            String spaceName = report.getSpaceReportMap().keySet().stream().iterator().next();
            Map<String, SpaceTypeReport> spaceDataTypes = report.getSpaceReportMap().get(spaceName).getTypeReportMap();
            Set<String> dataTypesKeyList = spaceDataTypes.keySet();
            for (String s : dataTypesKeyList) {
                DataTypesize = DataTypesize + Integer.parseInt(String.valueOf(spaceDataTypes.get(s).getTotalSize()));
                Metadatasize = Metadatasize + Integer.parseInt(String.valueOf(spaceDataTypes.get(s).getMetadataSizeCounter()));
                TotalNumOfEntriesPresentInSpace = TotalNumOfEntriesPresentInSpace + Integer.parseInt(String.valueOf(spaceDataTypes.get(s).getNumOfEntries()));
                int _TotalUsedHeapSize = Integer.parseInt(String.valueOf(spaceDataTypes.get(s).getTotalSize())) + Integer.parseInt(String.valueOf(spaceDataTypes.get(s).getMetadataSizeCounter()));
                int _AverageEntrySize = 0;
                if (Integer.parseInt(String.valueOf(spaceDataTypes.get(s).getNumOfEntries())) != 0) {
                    _AverageEntrySize = _TotalUsedHeapSize / Integer.parseInt(String.valueOf(spaceDataTypes.get(s).getNumOfEntries()));
                }
                objectTypeReport.put(s, new ObjectTypeInfo(spaceDataTypes.get(s).getNumOfEntries(), _AverageEntrySize));
            }


            int TotalUsedHeapSize = DataTypesize + Metadatasize;
            int AverageEntrySize = TotalUsedHeapSize / TotalNumOfEntriesPresentInSpace;
            Long TotalBytes = report.getSummary().getTotalBytes();
            Long LiveInstances = report.getSummary().getLiveInstances();
            Long LiveBytes = report.getSummary().getLiveBytes();

            if (actionParam.equals("HOW_MANY_OBJECTS_WE_CAN_HAVE")) {
                Heap heap = HeapFactory.createHeap(dumpPath.toFile());
//        // Calculate the maximum object counts.
                Map<String, Long> maxObjectsByType = calculateMaxCacheObjects(heap, objectTypeReport, UserTotalHeapSize, desiredFreeHeapSize);

                // Print the results.
                if (maxObjectsByType != null && !maxObjectsByType.isEmpty()) {
                    System.out.println("Maximum allowed cache objects (maintaining proportions):");
                    for (Map.Entry<String, Long> entry : maxObjectsByType.entrySet()) {
                        System.out.println("Type: " + entry.getKey() + ", Max Count: " + entry.getValue());
                    }

                    // Calculate and print the total maximum number of objects.
                    long totalMaxObjects = calculateTotalMaxObjects(maxObjectsByType);
                    if (totalMaxObjects != -1) {
                        System.out.println("Total maximum number of objects: " + totalMaxObjects);
                    }
                } else {
                    System.out.println("Could not calculate maximum object counts.");
                }
            } // Example of using suggestHeapSize
            else if (actionParam.equals("SUGGEST_HEAP_SIZE")) {
                long suggestedHeapSize = suggestHeapSize(objectTypeReport, desiredTotalObjects, desiredFreePercentage);
                if (suggestedHeapSize != -1) {
                    System.out.println("Suggested Heap Size: " + suggestedHeapSize);
                }
            }

            System.out.println("\n\n");
            System.out.println("Total no of Entries : " + TotalNumOfEntriesPresentInSpace);
            System.out.println("Total Used Heap Size : " + TotalUsedHeapSize);
            System.out.println("Average Entry Size : " + AverageEntrySize);
            System.out.println("Total Bytes : " + TotalBytes);
            System.out.println("Live Instances : " + LiveInstances);
            System.out.println("Live Bytes : " + LiveBytes);
            System.out.println("Desired Free Percentage : " + desiredFreePercentage);
            System.out.println("Total Heap Size : " + UserTotalHeapSize);
            System.out.println("Required Total No Of Objects : " + desiredTotalObjects);

            System.out.println("\n\n");
            if (reportPath == null || reportPath.equals("null")) {
                System.out.println(report);
            } else {
                System.out.println("Analysis completed - saving report at " + reportPath);
                HeapReportFormatter formatter = reportPath.endsWith(".json")
                        ? new JSonHeapReportFormatter()
                        : new TextHeapReportFormatter();
                try (Writer writer = new FileWriter(reportPath)) {
                    writer.write(formatter.format(report));
                    writer.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static Long getHardLimitMemoryInBytes(String memoryCheck) {
        long value = Long.parseLong(memoryCheck.replaceAll("[^0-9]", ""));
        char unit = memoryCheck.charAt(memoryCheck.length() - 1);
        long totalBytesValue = Long.parseLong(memoryCheck.replaceAll("[^0-9]", ""));

        if (unit == 'g') {
            totalBytesValue = value * 1024L * 1024L * 1024L;
        } else if (unit == 'm') {
            totalBytesValue = value * 1024L * 1024L;
        } else {
            throw new IllegalArgumentException("Unsupported unit: " + unit);
        }
        return totalBytesValue;
    }

    public static GigaSpacesHeapReport analyze(Path path, boolean verbose) throws IOException {
        GigaSpacesHeapReport.Builder builder = GigaSpacesHeapReport.builder()
                .dumpPath(path);
        Heap heap = HeapFactory.createHeap(path.toFile());

        long totalHeapSize = heap.getSummary().getTotalLiveBytes(); // Changed to getUsedHeapSize()//
        builder.dumpedOn(Instant.ofEpochMilli(heap.getSummary().getTime()));
        builder.summary(GigaSpacesHeapSummary.analyze(heap));
        JavaClass spaceEngineClass = heap.getJavaClassByName(GigaSpacesClasses.SpaceEngine);
        if (spaceEngineClass != null) {
            HeapUtils.forEachInstance(spaceEngineClass,
                    instance -> builder.add(analyzeSpace(instance, verbose)));
        }
        return builder.build();
    }

    private static SpaceReport analyzeSpace(Instance spaceInstance, boolean verbose) {
        SpaceTypeAnalyzer.Builder builder = SpaceTypeAnalyzer.builder();
        builder.verbose(verbose);
        String spaceName = HeapUtils.getStringValue(HeapUtils.getNestedValue(spaceInstance, "_spaceName"));
        String instanceId = HeapUtils.getStringValue(HeapUtils.getNestedValue(spaceInstance, "_spaceImpl", "_instanceId"));
        HeapUsageEstimator heapUsageEstimator = initHeapUsageEstimator(HeapUtils.getNestedValue(spaceInstance, "_spaceImpl", "_heapUsageEstimator"));
        builder.heapUsageEstimator(heapUsageEstimator);
        SpaceReportA report = new SpaceReportA(spaceName, instanceId, heapUsageEstimator != null ? heapUsageEstimator.getDesc() : "None");
        List<Instance> types = ((ObjectArrayInstance) HeapUtils.getNestedValue(spaceInstance, "_cacheManager", "_typeDataMap", "elementData")).getValues();
        for (Instance typeInstance : types) {
            if (typeInstance != null) {
                //System.out.printf("Analyzing instance #%s (class %s) %n", typeInstance.getInstanceId(), typeInstance.getJavaClass().getName());
                String typeName = HeapUtils.getStringValue((Instance) typeInstance.getValueOfField("_className"));
                SpaceTypeAnalyzer typeDataAnalyzer = builder.typeName(typeName).build();
                HeapUtils.walk(typeInstance, typeDataAnalyzer);
                report.add(typeDataAnalyzer.getReport());
            }
        }
        SpaceReport spaceReport = report;
        return spaceReport;
    }

    private static HeapUsageEstimator initHeapUsageEstimator(Instance instance) {
        if (instance == null)
            return null;
        return new HeapUsageEstimator.Builder()
                .desc(HeapUtils.getStringValue(HeapUtils.getNestedValue(instance, "desc")))
                .arrayHeaderSize((Integer) instance.getValueOfField("arrayHeaderSize"))
                .objectHeaderSize((Integer) instance.getValueOfField("objectHeaderSize"))
                .objectPadding((Integer) instance.getValueOfField("objectPadding"))
                .referenceSize((Integer) instance.getValueOfField("referenceSize"))
                .superclassFieldPadding((Integer) instance.getValueOfField("superclassFieldPadding"))
                .build();
    }

    public static Map<String, Long> calculateMaxCacheObjects(Heap heap, Map<String, ObjectTypeInfo> objectTypeReport,
                                                             Long UserTotalHeapSize, Long desiredFreeHeapSize) {
        // Input validation: Check for null report and percentage.
        if (objectTypeReport == null || objectTypeReport.isEmpty()) {
            System.err.println("Error: Object type report is null or empty.");
            return new HashMap<>(); // Return empty map for error case
        }
        if (heap == null) {
            System.err.println("Error: Heap object is null.");
            return new HashMap<>();
        }

        // Calculate total used heap from objectTypeReport
        double totalUsedHeapFromReport = calculateTotalUsedHeap(objectTypeReport);

        // Get total heap size from the Heap object.

        long totalHeapSize = heap.getSummary().getTotalLiveBytes(); // Changed to getUsedHeapSize()
        if (totalHeapSize <= 0) {
            System.err.println("Error: Invalid total heap size from Heap object: " + totalHeapSize);
            return new HashMap<>();
        }

        // Calculate maximum allowed cache size.
        double maxCacheSize = desiredFreeHeapSize - totalHeapSize;

        // Calculate current cache size
        double currentCacheSize = 0;
        for (ObjectTypeInfo typeInfo : objectTypeReport.values()) {
            currentCacheSize += typeInfo.getCount() * typeInfo.getAvgSize();
        }

        // Calculate the scaling factor to apply to each object count.
        double scaleFactor = maxCacheSize / currentCacheSize;

        // Calculate maximum object counts for each type, maintaining proportions.
        Map<String, Long> maxObjectsByType = new HashMap<>();
        for (Map.Entry<String, ObjectTypeInfo> entry : objectTypeReport.entrySet()) {
            String type = entry.getKey();
            ObjectTypeInfo typeInfo = entry.getValue();
            // Scale the count, and round *down* to the nearest whole number.  We don't want to exceed the limit.
            long maxCount = (long) (typeInfo.getCount() * scaleFactor);
            maxObjectsByType.put(type, maxCount);
        }

        return maxObjectsByType;
    }

    public static double calculateTotalUsedHeap(Map<String, ObjectTypeInfo> objectTypeReport) {
        if (objectTypeReport == null || objectTypeReport.isEmpty()) {
            System.err.println("Error: Object type report is null or empty.");
            return -1; // Return -1 to indicate an error
        }

        double totalUsedHeap = 0;
        for (ObjectTypeInfo typeInfo : objectTypeReport.values()) {
            totalUsedHeap += typeInfo.getCount() * typeInfo.getAvgSize();
        }
        return totalUsedHeap;
    }

    public static long calculateTotalMaxObjects(Map<String, Long> maxObjectsByType) {
        if (maxObjectsByType == null || maxObjectsByType.isEmpty()) {
            System.err.println("Error: Maximum objects map is null or empty.");
            return -1; // Return -1 to indicate an error
        }

        long totalMaxObjects = 0;
        for (long count : maxObjectsByType.values()) {
            totalMaxObjects += count;
        }
        return totalMaxObjects;
    }


    public static long suggestHeapSize(Map<String, ObjectTypeInfo> objectTypeReport, long desiredTotalObjects, double desiredFreePercentage) {
        if (objectTypeReport == null || objectTypeReport.isEmpty()) {
            System.err.println("Error: Object type report is null or empty.");
            return -1;
        }
        if (desiredTotalObjects <= 0) {
            System.err.println("Error: Desired total objects must be greater than zero.");
            return -1;
        }
        if (desiredFreePercentage < 0 || desiredFreePercentage > 100) {
            System.err.println("Error: Desired free percentage must be between 0 and 100.");
            return -1;
        }

        // Calculate the current total number of objects.
        long currentTotalObjects = 0;
        for (ObjectTypeInfo typeInfo : objectTypeReport.values()) {
            currentTotalObjects += typeInfo.getCount();
        }

        if (currentTotalObjects == 0) {
            System.err.println("Error: Current total objects is zero. Cannot calculate heap size.");
            return -1;
        }
        // Calculate the scaling factor.
        double scaleFactor = (double) desiredTotalObjects / currentTotalObjects;

        // Calculate the desired cache size.
        double desiredCacheSize = 0;
        for (ObjectTypeInfo typeInfo : objectTypeReport.values()) {
            desiredCacheSize += (typeInfo.getCount() * scaleFactor) * typeInfo.getAvgSize();
        }

        // Calculate the suggested total heap size.
        long suggestedHeapSize = (long) (desiredCacheSize / (1 - (desiredFreePercentage / 100)));

        return suggestedHeapSize;
    }


}
