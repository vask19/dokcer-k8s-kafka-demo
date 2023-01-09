FROM openjdk:17-jdk-slim
COPY target/gatewayservice-0.0.1-SNAPSHOT.jar gatewayservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","/gatewayservice-0.0.1-SNAPSHOT.jar"]
