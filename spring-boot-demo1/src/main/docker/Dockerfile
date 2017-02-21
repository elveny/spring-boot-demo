FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /mnt/docker/apps
ADD spring-boot-demo1-1.0-SNAPSHOT.jar spring-boot-demo1.jar
RUN sh -c 'touch /spring-boot-demo1.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot-demo1.jar"]