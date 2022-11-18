# **USING KAFKA IN MICROSERVICES** 

![](https://cdn.confluent.io/wp-content/uploads/incompatible-serializers-and-deserializers-2048x637.png)


## Cài Đặt Và Chạy

### **1. RUN KAKFA & ZOOKEEPER BY DOCKER 🐳**

```Docker
version: "3"
services:
  zookeeper:
    container_name: zookeeper
    image: 'bitnami/zookeeper:latest'
    ports:
      - '2181:2181'
    environment:
      - ALLOW_ANONYMOUS_LOGIN=yes
  kafka:
    container_name: kafka 
    image: 'bitnami/kafka:latest'
    ports:
      - '9092:9092'
    environment:
      - KAFKA_ENABLE_KRAFT=yes
      - KAFKA_CFG_PROCESS_ROLES=broker,controller
      - KAFKA_CFG_CONTROLLER_LISTENER_NAMES=CONTROLLER
      - KAFKA_CFG_LISTENERS=PLAINTEXT://:9092
      - KAFKA_CFG_LISTENERS=PLAINTEXT://:9092,CONTROLLER://:9093
      - KAFKA_CFG_LISTENER_SECURITY_PROTOCOL_MAP=CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT
      - KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://127.0.0.1:9092
      - KAFKA_BROKER_ID=1
      - KAFKA_CFG_CONTROLLER_QUORUM_VOTERS=1@127.0.0.1:9093
      - KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper:2181
      - ALLOW_PLAINTEXT_LISTENER=yes
    depends_on:
      - zookeeper
```

*Nguồn: [Apache Kafka packaged by Bitnami](https://hub.docker.com/r/bitnami/kafka)*

### **2. DOWNLOAD KAFKA MAZIC**


> **[Kafka Mazic](https://www.kafkamagic.com/)** là **GUI Tool** dùng để làm việc với **Apache Kafka**. Chúng ta có thể tạo và quản lý các **topic**, ngoài ra có thể xem, tìm kiếm, gửi và nhận **message** giữa các topic.

Link Tải [Download Kafka Mazic](https://www.kafkamagic.com/download/)

Sau khi tải, giải nén Zip, chạy file **KafkMazic** và truy cập vào [localhost:5000](http://localhost:5000)

### **3. DOWNLOAD SOURCE CODE AND RUN**


