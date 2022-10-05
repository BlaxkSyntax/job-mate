FROM ubuntu

RUN apt-get update
RUN apt-get install -y openjdk-11-jre curl make

ADD target/web-0.0.1-jar-with-dependencies.jar /srv/web-0.0.1.jar

WORKDIR /srv
EXPOSE 5000
CMD ["java", "-jar", "web-0.0.1.jar"]
