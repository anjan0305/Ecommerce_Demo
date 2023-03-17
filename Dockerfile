FROM openjdk:19-jdk-alpine3.15
WORKDIR /usr/share/codebase
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD Environments/F-tier.properties Environments/F-tier.properties
ADD Environments/Global.properties Environments/Global.properties
ADD target/libs libs
ADD src/test/java/Runner/RegistrationRunner.xml RegistrationRunner.xml
ADD src/test/java/Runner/LoginRunner.xml LoginRunner.xml
ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DHOST_NAME=$HOST_NAME org.testng.TestNG $MODULE

