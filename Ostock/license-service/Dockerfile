FROM openjdk:11-ea-11-jdk
COPY target/license-service-0.0.1-SNAPSHOT.jar license-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","/license-service-0.0.1-SNAPSHOT.jar"]
