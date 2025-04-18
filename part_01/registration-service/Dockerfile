FROM openjdk:24
ADD target/registration-service-0.0.1-SNAPSHOT.jar registration-service.jar
EXPOSE 9001
ENTRYPOINT ["java", "-jar", "registration-service.jar"]
