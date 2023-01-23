FROM maven:3.8.3-openjdk-11-slim AS builder
COPY pom.xml /prueba2/
COPY src /prueba2/src
RUN --mount=type=cache,target=/root/.m2 mvn -f /prueba2/pom.xml clean install -Dmaven.test.skip=true

FROM openjdk:11-jre-slim
COPY --from=builder /prueba2/target/prueba2-1.0.0.jar prueba2-1.0.0.jar.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "prueba2-1.0.0.jar.jar"]