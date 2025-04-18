FROM openjdk:24
ADD target/events-service-0.0.1-SNAPSHOT.jar events-service.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "events-service.jar"]
