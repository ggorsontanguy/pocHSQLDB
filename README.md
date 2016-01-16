# Prove of concept of using HSQLDB

This project follow the tutorial found here [Unit testing and integration testing using JUnit, Liquibase, HSQLDB, Hibernate, Maven and Spring Framework] (https://tillias.wordpress.com/2012/11/10/unit-testing-and-integration-testing-using-junit-liquibase-hsqldb-hibernate-maven-and-spring-framework/)

Thanks to tillias

## Run server
java -cp ../lib/hsqldb.jar org.hsqldb.server.Server –database.0 file:sandboxDb –dbname.0 sandboxDb

## Run database manager
java -classpath .;../lib/hsqldb.jar org.hsqldb.util.DatabaseManager  -user sa -url jdbc:hsqldb:database/sandboxDb

## test liquid base conf
java -classpath .;../lib/hsqldb.jar org.hsqldb.util.DatabaseManager  -user sa -url jdbc:hsqldb:database/sandboxDb