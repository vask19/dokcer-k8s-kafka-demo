FROM openjdk:17-jdk-slim
COPY target/licence-service-0.0.1-SNAPSHOT.jar licence-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","/licence-service-0.0.1-SNAPSHOT.jar"]
