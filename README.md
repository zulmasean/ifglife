## 📌 Overview

This project demonstrates end-to-end **QA Automation Testing** covering:

- ✅ RESTful API Testing (Producer & Consumer simulation)
- ✅ Apache Kafka Message Validation
- ✅ API ↔ Kafka Integration Testing

The automation framework ensures API reliability, message integrity, and integration stability.

---

## 🎯 Objectives

- Validate REST API endpoints (status code, response body, schema)
- Verify Kafka producer successfully publishes messages
- Verify Kafka consumer receives and validates messages

---

## 🛠 Tech Stack

| Technology        | Purpose                         |
|-------------------|---------------------------------|
| Katalon Studio    | API Automation Testing          |
| Apache Kafka      | Message Broker                  |
| Docker            | Containerized Kafka Environment |
| Gradle            | Dependency Management           |
| Postman           | Manual API Validation           |

---

## 📂 Project Structure
```text
IFGLife Project
│
├── Data Files
│   └── api_test_data.xlsx
│
├── Object Repository
│   └── API
│       ├── POST_User
│       └── GET_User
│
├── Test Cases
│   ├── TC_API_Producer
│   ├── TC_API_Consumer
│   └── TC_Kafka_Consumer
│
├── Keywords
│   └── kafka/
│       └── KafkaConsumerUtil.groovy
│
├── Test Suites
│   └── TS_EndToEnd
│
└── Include
```

---

## ⚙️ Setup & Installation

### 1️⃣ Clone Repository

```bash
git clone https://github.com/zulmasean/ifglife.git
cd ifglife
```
### 2️⃣ Setup and Start Kafka via Docker

```bash
create docker-compose.yml
```

```bash
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:7.4.0
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181

  kafka:
    image: confluentinc/cp-kafka:7.4.0
    depends_on:
      - zookeeper
    ports:
      - "9092:9092"
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
```

```bash
docker-compose up -d
```

Kafka will run at:

localhost:9092

To check running containers:

```bash
docker ps
```

### 3️⃣ Build Project

```bash
gradle clean build
```

### 4️⃣ Open in Katalon Studio

Open Katalon Studio
Import existing project
Ensure Kafka dependency is added in build.gradle
Reload Gradle

### 🧪 Test Scenarios
✅ API Test Cases

Test Case	Description

- ✅ TC_API_Consumer	Validate GET endpoint response
- ✅ TC_API_Producer	Validate POST request & response
- ✅ TC_Kafka_Consumer	To Consume and validate message Kafka

### ✅ Kafka Test Cases Manual
Run:
```bash
docker exec -it <container_id> kafka-console-producer --broker-list localhost:9092 --topic user-topic
```

Send:
```json
{
  "event":"user_created",
  "name":"zulma"
}
```
