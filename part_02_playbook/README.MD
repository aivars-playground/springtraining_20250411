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