FROM openjdk:8

COPY ./target/async-sender-0.0.1-SNAPSHOT-jar-with-dependencies.jar .
COPY wait-for-it.sh .

RUN chmod +x wait-for-it.sh

EXPOSE 8083

CMD ["java", "-jar", "async-sender-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]
