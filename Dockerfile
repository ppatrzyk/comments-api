FROM amazoncorretto:21.0.2-alpine
COPY . /app
WORKDIR /app
RUN apk add maven \
    && mvn clean package
CMD ["java", "-jar", "/app/target/comments-0.0.1-SNAPSHOT.jar"]
