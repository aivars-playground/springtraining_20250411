APP
===

start
----

* start database
```shell
docker compose up -d
```
* populate test data:
Use spring profile `testdata` ([application-testdata.yml](events-service/src/main/resources/application-testdata.yml)) to initialize database DDL and add sample data

* sample commands
```http request
POST http://localhost:9001/registrations
Content-Type: application/json

{
  "productId": 801,
  "attendeeName": "abc"
}
```

* health (Actuator)
```http request
GET http://localhost:9001/actuator/health
Accept: application/vnd.spring-boot.actuator.v3+json
```