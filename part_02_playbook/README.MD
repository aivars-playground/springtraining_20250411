Spring Playbook
===============
https://app.pluralsight.com/library/courses/spring-boot-3-playbook

multi data source
=================
each source need separate config
* org.example.base.config.DatasourceOneConfig
* org.example.base.config.DatasourceTwoConfig

rest
=================
this dependency:
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-rest</artifactId>
        </dependency>
```
automatically adds a bunch of endpoints (see Mappings), i.e.
it even supports paging, "/api" - base path can be configured in yml
```
/{repository_name}/{id}   [GET]
```
```http request
GET http://localhost:8080/api/contacts/1
Accept: application/hal+json
```

messaging
=========
ActiveMQ Artemis l/p: artemis/artemis
* sending message
```http request
###
GET http://localhost:8080/sendJmsMessage
```
* receiving
`org.example.base.jms.SampleListener`

actuators
=========
```http request
GET http://localhost:8080/actuator/customactuator
```

testing
=======
* run `docker compose` before executing integration test

test might need different setup, 
`[DbTestPreloadConfig.java](src/test/java/org/example/base/config/DbTestPreloadConfig.java)` 
is overwriting a prod ready 
`[DbPreloadConfig.java](src/main/java/org/example/base/config/DbPreloadConfig.java)` 
different profiles should be used!!!
workaround `allow-bean-definition-overriding: true` for demo purposes only... not for prod
put "allow-bean-definition-overriding: true" in test profile
