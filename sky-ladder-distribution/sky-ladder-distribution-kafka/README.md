# kafka 环境搭建

## 一. 环境搭建

###  1. Docker zookeeper

```shell script
docker run -d --name zookeeper -p 2181:2181 -t zookeeper
```


###  2. Docker Kafka 创建

```shell script
docker run -d --name kafka --publish 9092:9092 \
--link zookeeper \
--env KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 \
--env KAFKA_ADVERTISED_HOST_NAME=127.0.0.1 \
--env KAFKA_ADVERTISED_PORT=9092 \
wurstmeister/kafka
```

## 3. Kafka manager

```shell script
docker run -d --name kafka-manager \
--link zookeeper:zookeeper \
--link kafka:kafka -p 9001:9000 \
--restart=always \
--env ZK_HOSTS=zookeeper:2181 \
sheepkiller/kafka-manager
```
