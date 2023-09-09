# FROM alpine:3.18.3
# FROM maven:3.9.4-eclipse-temurin-17-alpine AS build-env

# WORKDIR /app

# COPY . ./project/

# RUN mvn clean package -Dmaven.test.skip=true -f "/app/project/kubernetes-provider/pom.xml"

FROM eclipse-temurin:17-jre-alpine

# COPY --from=build-env /app/project/kubernetes-provider/target/ /app/

WORKDIR /app

COPY target/kubernetes-provider.jar /app/kubernetes-provider.jar

CMD ["java", "-jar", "/app/kubernetes-provider.jar"]