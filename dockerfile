# build: docker build -t mybootapp .
# run: docker run -p 8080:5000 mybootapp

#openjdk:17-jdk 이미지 사용 시, xargs 없어서 gradlew -x test 시 에러 발생
FROM openjdk:17-jdk-alpine AS builder

WORKDIR /app

COPY . .
# RUN chmod +x ./gradlew
RUN pwd
RUN ls

# RUN ./gradlew clean build -x test
RUN ./gradlew bootJar

COPY build/libs/sampleapp-for-docker-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
CMD ["-parameters", "-Dspring.profiles.active=local"]
