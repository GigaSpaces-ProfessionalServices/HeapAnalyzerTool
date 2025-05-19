## Space Heap Analyzer

This tool let you run heap analyze on the cluster backups containers

and get a nice report in an Excel file in addition to json file.

The cluster could be run on your local machine or remotely.

It can also be a secured or non-secured Grid

#### Prerequisite

This tool is written in Python and in order to run it you need to have Python installed + modules like pandas and more, 
so please start by downloading Python.

In case you will encounter missing modules while execute, you can download it afterwords. 

#### Configuration
The tool can be run in 2 modes:
* interactive
* pre define configuration (app.config file)

##### app.config
In order to use this file you first need to configure the path for its location (without the file name).

For example, if the file location is /Users/david/app.config set ENV_CONFIG env variable as follows:


    export ENV_CONFIG=/Users/david/

#### Here is the app.config content example:

app.spaceheapanalyzer.managerip=localhost

app.spaceheapanalyzer.managerusername=username

app.spaceheapanalyzer.managerpassword=password
    
app.spaceheapanalyzer.jmappath=/Users/david/output
    
app.spaceheapanalyzer.javajarpath=/Users/david/SpaceHeapAnalyzer-1.0-SNAPSHOT-jar-with-dependencies.jar

#### How to run?
    python SpaceHeapAnalyzer.py

#### For Partition selection

For single partition selection just enter specific number

For Multiple partitions range selection enter '0-2' this with select 0, 1 and 2

For Multiple partitions selection enter '0,2,4' this with select 0, 2 and 4

Note if you select the Select ALL menu number in the Multiple partitions selection so report will be generated for ALL partitions


#### For Running Java Code 
There are 2 action paramaters to run this code
* HOW_MANY_OBJECTS_WE_CAN_HAVE
* SUGGEST_HEAP_SIZE

### For HOW_MANY_OBJECTS_WE_CAN_HAVE
### Steps to run
* Deploy Space with below pu file
<prop key="space-config.engine.cache_policy">1</prop>

<prop key="space-config.engine.memory_usage.high_watermark_percentage">98</prop>

<prop key="space-config.engine.memory_usage.write_only_block_percentage">97</prop>

<prop key="space-config.engine.memory_usage.write_only_check_percentage">96</prop>

<prop key="space-config.engine.memory_usage.low_watermark_percentage">95</prop>

<prop key="space-config.engine.memory_usage.gc-before-shortage">false</prop>

* Run Feeder
* Download Heap dump 
* Report Path and Verbose is Optional.  By Default ReportPath will be null and Verbose will be false
* Command to run - java -jar <SpaceHeapAnalyzer.Jar> <DumpPath> HOW_MANY_OBJECTS_WE_CAN_HAVE <TotalHeapSize> <DesiredFreePercentage> <ReportPath> <Verbose>
* Like Example - java -jar SpaceHeapAnalyzer-1.0-SNAPSHOT-jar-with-dependencies.jar heap.hprof HOW_MANY_OBJECTS_WE_CAN_HAVE 2g 40 report.json false
* From this you will get the max count of records for per partition
* Deploy Space with below Pu 

<prop key="space-config.engine.cache_policy">0</prop>

<prop key="space-config.engine.cache_size">Max_Records_Count</prop>

<prop key="space-config.engine.memory_usage.enabled">false</prop>

* Run Feeder and test it

### For SUGGEST_HEAP_SIZE
* This will suggest Heap Size for per partition data
* Command to run - java -jar <SpaceHeapAnalyzer.Jar> <DumpPath> SUGGEST_HEAP_SIZE <TotalHeapSize> <DesiredFreePercentage> <ReportPath> <Verbose> <DesiredTotalObjects>
* Like Example - java -jar SpaceHeapAnalyzer-1.0-SNAPSHOT-jar-with-dependencies.jar heap.hprof SUGGEST_HEAP_SIZE 2g 40 report.json false 10000
* You will get the size of GSC start GSC with that size
* Deploy Space with below PU

<prop key="space-config.engine.cache_policy">0</prop>

<prop key="space-config.engine.cache_size">Max_Records_Count</prop>

<prop key="space-config.engine.memory_usage.enabled">false</prop>

* Run feeder and test it