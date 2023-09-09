FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY target/kubernetes-consumer.jar /app/kubernetes-consumer.jar

CMD ["java", "-jar", "/app/kubernetes-consumer.jar"]