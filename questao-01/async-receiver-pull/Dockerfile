FROM openjdk:11

COPY ./target/async-receiver-0.0.1-SNAPSHOT-jar-with-dependencies.jar .
COPY wait-for-it.sh .

RUN chmod +x wait-for-it.sh

EXPOSE 8082

CMD ["java", "-jar", "async-receiver-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]
