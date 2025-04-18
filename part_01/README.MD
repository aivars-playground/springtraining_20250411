APP
===

start
===
start database
```shell
docker compose up -d
```

populate test data:
===
Use spring profile `testdata` ([application-testdata.yml](events-service/src/main/resources/application-testdata.yml)) to initialize database DDL and add sample data

sample commands
===
```http request
POST http://localhost:9001/registrations
Content-Type: application/json

{
  "productId": 801,
  "attendeeName": "abc"
}
```

health (Actuator)
===
```http request
GET http://localhost:9001/actuator/health
Accept: application/vnd.spring-boot.actuator.v3+json
```

metrics
===
* all
```http request
GET http://localhost:9001/actuator/metrics
```
* filter by endpoint
```http request
GET http://localhost:9001/actuator/metrics/http.server.requests?tag=uri:/registrations
```

docker
===
* build target jars
```shell
cd ./events-service
docker build -t events-service:0.0.1-SNAPSHOT .
```
```shell
cd ./registration-service
docker build -t registration-service:0.0.1-SNAPSHOT .
```