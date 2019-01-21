FROM openjdk:8-jre-slim

WORKDIR /opt

COPY target/simulator-jar-with-dependencies.jar simulator-jar-with-dependencies.jar

CMD ["java", \
     "-XshowSettings:vm", \
     "-XX:+UnlockExperimentalVMOptions", \
     "-XX:+UseCGroupMemoryLimitForHeap", \
     "-XX:MaxRAMFraction=2", \
     "-server", \
     "-jar", "simulator-jar-with-dependencies.jar"]

EXPOSE 4567