FROM maven:3.6-jdk-8-alpine
COPY . /usr/src/app
VOLUME /root/.m2
WORKDIR /usr/src/app
ENTRYPOINT ["mvn", "spring-boot:run"]
