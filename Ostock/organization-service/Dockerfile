FROM openjdk:11-ea-11-jdk
MAINTAINER baeldung.com
COPY target/organization-service-0.0.1-SNAPSHOT.jar organization-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","/organization-service-0.0.1-SNAPSHOT.jar"]
