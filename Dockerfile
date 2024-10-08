FROM maven:3-eclipse-temurin-17-alpine AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip

FROM eclipse-temurin:17-jre-alpine
COPY --from=build /home/app/target/voting-api.jar /usr/local/lib/voting-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/voting-api.jar"]