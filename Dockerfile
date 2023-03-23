FROM amazoncorretto:11
MAINTAINER quirogatdf
COPY target/portfolio-web-backend-0.0.1-SNAPSHOT.jar portfolio-web-backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/portfolio-web-backend-0.0.1-SNAPSHOT.jar"]