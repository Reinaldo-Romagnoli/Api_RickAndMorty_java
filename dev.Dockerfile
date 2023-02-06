FROM maven:3.5.4-jdk-11

COPY . /project
RUN cd /project && mvn package
