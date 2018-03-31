FROM airhacks/java
COPY target/mongoguru.jar /opt/mongoguru.jar
ENTRYPOINT ["java","-Xmx256m", "-jar","/opt/mongoguru.jar"]
EXPOSE 5008
