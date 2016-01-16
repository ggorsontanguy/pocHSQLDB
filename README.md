# Prove of concept of using HSQLDB

This project follow the tutorial found here [Unit testing and integration testing using JUnit, Liquibase, HSQLDB, Hibernate, Maven and Spring Framework] (https://tillias.wordpress.com/2012/11/10/unit-testing-and-integration-testing-using-junit-liquibase-hsqldb-hibernate-maven-and-spring-framework/)

Thanks to tillias

## maven command for liquidbase => Unit Test

### test liquid base conf
    mvn liquibase:update -Dliquibase.dropFirst=true

### setup liquid base for dev
    mvn liquibase:update -Dliquibase.dropFirst=true -Dliquibase.contexts="dev"

## others commands to run the database

### Run server
    java -cp ../lib/hsqldb.jar org.hsqldb.server.Server –database.0 file:sandboxDb –dbname.0 sandboxDb

### Run database manager
    java -classpath .;../lib/hsqldb.jar org.hsqldb.util.DatabaseManager  -user sa -url jdbc:hsqldb:database/sandboxDb

### HSQLDB Database Server plugin for Eclipse Database Development Perspective
https://marketplace.eclipse.org/content/hsqldb-database-server-plugin

## Problem for add HSQLDB Connection?
[Database connection HSQLDB in Eclipe (Youtube)] (https://www.youtube.com/watch?v=GHfF9h0-GYY)

### Repository
https://github.com/ggorsontanguy/pocHSQLDB
