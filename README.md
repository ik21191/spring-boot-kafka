# spring-boot-kafka

- Go to `/script/kafka` folder and then Start `Zookeeper` server using below command

```
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

**Note:** If you see below error while running above command then copy the `kafka` folder to `/home` or `d:/` drive then try above command abain

```
The input line is too long.
The syntax of the command is incorrect.
```

- Then Start `Kafka` server using below command

```
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

- Finally run `SpringBootKafkaApplication` application