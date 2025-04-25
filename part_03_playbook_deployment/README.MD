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


rescaling
--------
```shell
docker compose up -d --scale helloservice=5
```
add to ngnx config line to restart
```
    server {
        resolver 127.0.0.11 valid=5s;
        ...
```
ISSUE!!! when upscaling, ngnx is not picking up additional instances,
if dockercompoose has 3 instances, when rescaling to 5, only 3 are used until restarting ngnx
