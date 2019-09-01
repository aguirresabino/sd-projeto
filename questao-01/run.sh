cd async-share
mvn clean package
mvn install:install-file -Dfile=./target/async-share-0.0.1-SNAPSHOT.jar -DgroupId=async-share -DartifactId=async-share -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true
cd ..

cd async-clientapp
mvn clean compile assembly:single
cd ..

cd async-sender-pull
mvn clean compile assembly:single
cd ..

cd async-receiver-pull
mvn clean compile assembly:single
cd ..

cd  async-serverapp
mvn clean compile assembly:single
cd ..

docker-compose up --build