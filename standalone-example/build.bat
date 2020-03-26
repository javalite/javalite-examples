
@echo off
del /S /F /Q classes

set CLASSPATH=lib\activejdbc-2.1-SNAPSHOT.jar
set CLASSPATH=%CLASSPATH%;lib\jackson-annotations-2.9.0.jar
set CLASSPATH=%CLASSPATH%;lib\jackson-core-2.9.4.jar
set CLASSPATH=%CLASSPATH%;lib\jackson-databind-2.9.4.jar
set CLASSPATH=%CLASSPATH%;lib\javalite-common-2.1-SNAPSHOT.jar
set CLASSPATH=%CLASSPATH%;lib\mysql-connector-java-5.1.27.jar
set CLASSPATH=%CLASSPATH%;lib\slf4j-api-1.7.1.jar
set CLASSPATH=%CLASSPATH%;lib\slf4j-simple-1.7.1.jar

javac -cp %CLASSPATH% -d classes src/activejdbc/examples/simple/*.java  
