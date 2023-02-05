FROM maven:3.5.4-jdk-11

COPY . /project
RUN cd /project && mvn package

#this part for debug is moved into compose file, into "command":
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/project/target/rick-and-morty-api-0.0.1-SNAPSHOT.jar"]