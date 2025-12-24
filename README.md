# spring-boot-kafka

JDK version **21.0.9**

Maven version **3.9.9**

## Start `Zookeeper (Gateway)` 
- Go to `/script/kafka` folder and then Start `Zookeeper` server using below command

```
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

**Note:** If you see below error while running above command then copy the `kafka` folder to `/home` or `d:/` drive then try above command again.

```
The input line is too long.
The syntax of the command is incorrect.
```

## Start `Kafka Server` 
- Use below command to run `Kafka` server

```
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

## Finally run `SpringBootKafkaApplication` application