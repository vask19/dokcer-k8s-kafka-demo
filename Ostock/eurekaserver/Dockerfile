FROM openjdk:17-jdk-slim
MAINTAINER baeldung.com
COPY target/eurekaserver-0.0.1-SNAPSHOT.jar eurekaserver-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","/eurekaserver-0.0.1-SNAPSHOT.jar"]
