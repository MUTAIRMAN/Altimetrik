FROM java:8
EXPOSE 8080
ADD /target/com.muthuAltimetrik-0.0.1-SNAPSHOT.jar com.muthuAltimetrik-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","com.muthuAltimetrik-0.0.1-SNAPSHOT.jar"]