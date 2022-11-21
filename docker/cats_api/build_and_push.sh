./gradlew clean build
docker build . -t vask191/cats-api:1.0.0
docker push vask191/cats-api:1.0.0
#chmod +x build_and_push.sh
#docker run -ti --rm -e DATASOURCE_HOST=172.20.10.2 -p 8081:8080 vask191/cats-api:1.0.0
#ifconfig
