FROM maven:3-jdk-8

COPY ./ ./source
WORKDIR /source
RUN mvn install:install-file -Dfile=lib/async-share-0.0.1-SNAPSHOT.jar -DgroupId=async-share -DartifactId=async-share -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true && \
    mkdir /app && \
    mvn clean compile assembly:single && \
    cp target/async-clientapp*.jar /app/async-clientapp.jar

EXPOSE 8081
CMD ["java", "-jar", "/app/async-clientapp.jar"]
