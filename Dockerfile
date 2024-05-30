FROM openjdk:17-jdk-slim-bullseye
RUN addgroup -system devopsc && useradd -G devopsc javams 
USER javams:devopsc
ENV JAVA_OPTS="-Xms256M -Xmx256M"
ADD target/ManageTicket-1.0.0.jar app.jar
VOLUME /tmp
EXPOSE 7088
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]