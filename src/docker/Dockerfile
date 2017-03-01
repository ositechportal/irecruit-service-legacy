FROM openjdk:8-jdk
MAINTAINER shandesh reddy

EXPOSE 8080
EXPOSE 27017
EXPOSE 9200
EXPOSE 9300


#ADD ${project.build.finalName}.jar irecruit-service.jar
ADD irecruit-service.jar irecruit-service.jar
RUN sh -c 'touch /irecruit-service.jar'
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://irecruit-mongo/osirpdb","-Djava.security.egd=file:/dev/./urandom","-jar","/irecruit-service.jar"]
