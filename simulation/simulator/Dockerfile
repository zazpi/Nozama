FROM java:openjdk-8-alpine
COPY . /usr/src/app
VOLUME /root/.m2
WORKDIR /usr/src/app
EXPOSE 4567
CMD ["java", \
     "-XshowSettings:vm", \
     "-XX:+UnlockExperimentalVMOptions", \
     "-XX:MaxRAMFraction=2", \
     "-server", \
     "-jar", "target/simulator-jar-with-dependencies.jar"]