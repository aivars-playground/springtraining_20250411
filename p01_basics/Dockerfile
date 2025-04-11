FROM eclipse-temurin:24 AS builder
RUN --mount=type=cache,target=/root/.m2,rw
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install

FROM eclipse-temurin:24 AS jre-builder
RUN $JAVA_HOME/bin/jlink \
         --add-modules java.desktop \
         --strip-debug \
         --no-man-pages \
         --no-header-files \
         --compress=2 \
         --output /javaruntime

FROM debian:buster-slim
ENV JAVA_HOME=/opt/java/openjdk
ENV PATH="${JAVA_HOME}/bin:${PATH}"
COPY --from=jre-builder /javaruntime $JAVA_HOME
COPY --from=builder /opt/app/target/*.jar /opt/app/app.jar
WORKDIR /opt/app
ENTRYPOINT ["java", "-jar", "app.jar"]