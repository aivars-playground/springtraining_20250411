NGINX and docker compose
========================

create jar
```shell
mvn install
```

```shell
docker compose up -d
```

```
http://localhost:9090/
http://localhost:9090/actuator/info
```

how to add host name
--------------------
```
management:
  endpoints:
    web:
      exposure:
        include: health,info,env
  endpoint:
    env:
      show-values: always
  info:
    env:
      enabled: true

/// custom env variables are added here  HOSTNAME is host env variable, might not be set    
info:
  app:
    hostname: ${HOSTNAME:-"unknown"}

```

how to start multiple instances
--------------------
do not expose ports when running multiple apps
```
  helloservice:
     scale: 3
```

configure nginx
```
    location / {
        proxy_pass http://helloservice:8080;
    }
```
see [nginx.conf](nginx.conf)