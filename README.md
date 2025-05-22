## Space Heap Analyzer
### This has 2 tools

### 1 - For Python Tool 
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


### 2 - For Java Code 

This tool is working for XAP Version 16.4.0 and Java 8

There are 2 action paramaters to run this code
* HOW_MANY_OBJECTS_WE_CAN_HAVE
* SUGGEST_HEAP_SIZE

### For HOW_MANY_OBJECTS_WE_CAN_HAVE
## Steps to run
* Download Xap - https://gs-releases-us-east-1.s3.amazonaws.com/smart-cache/16.4.0/gigaspaces-smart-cache-enterprise-16.4.0.zip
* Extract zip and run this command inside bin folder "./gs.sh host run-agent --auto --gsc=2"
* Deploy space_policy1 Space with "./gs.sh pu deploy space --partitions=2 space_policy1/target/space_policy1-0.1.jar"
* Run Feeder with "java -jar feeder/target/feeder-0.1-jar-with-dependencies.jar"  (In feeder code AAMultithreadedFeeder file put DEFAULT_NUM_OBJECTS like 1k)
* Go to WEBUI http://localhost:8099/ 
* Select processing units tab 
* Select particular partition for which you want to generate report
* Then select JVM Heap Dump and Generate it
* Now Extract the generated zip and go to maanger pid folder and copy the path of heap.hprof
* Command to run - java -jar <SpaceHeapAnalyzer.Jar> <DumpPath> HOW_MANY_OBJECTS_WE_CAN_HAVE <TotalHeapSize> <DesiredFreePercentage> <ReportPath> <Verbose> (Report Path and Verbose is Optional.  By Default ReportPath will be null and Verbose will be false)
* Like Example - java -jar SpaceHeapAnalyzer-1.0-SNAPSHOT-jar-with-dependencies.jar heap.hprof HOW_MANY_OBJECTS_WE_CAN_HAVE 2g 40 report.json false
* From this you will get the max count of records for per partition open pu.xml for space_policy0 and put that max count value in space-config.engine.cache_size
* Run mvn clean install under space_policy0
* Deploy space_policy0 Space with "./gs.sh pu deploy space --partitions=2 space_policy1/target/space_policy0-0.1.jar"
* Go to Feeder code open AAMultithreadedFeeder file 
* Put some random amount which is greater than max count in DEFAULT_NUM_OBJECTS 
* Run feeder and test it

### For SUGGEST_HEAP_SIZE
#### Single partitions test
* This will suggest Heap Size for per partition data
* Assuming you have heap.hrof file which you have downloaded from WEBUI
* Command to run - java -jar <SpaceHeapAnalyzer.Jar> <DumpPath> SUGGEST_HEAP_SIZE <TotalHeapSize> <DesiredFreePercentage> <ReportPath> <Verbose> <DesiredTotalObjects>
* Like Example - java -jar SpaceHeapAnalyzer-1.0-SNAPSHOT-jar-with-dependencies.jar heap.hprof SUGGEST_HEAP_SIZE 2g 40 report.json false 10000
* You will get Suggested Heap Size of GSC start GSC with that size
* Deploy space_policy0 Space with the number of records which you have got from SUGGEST_HEAP_SIZE command
* Run Feeder and test it

#### Multiple partitions test
* For multiple Partitions test deploy Space accordingly 
* Just increase the feeder DEFAULT_NUM_OBJECTS count run it and test it  