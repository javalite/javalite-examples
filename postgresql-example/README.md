# ActiveJDBC example testing working with PostgreSQL 

This example is a response to SO question:

https://stackoverflow.com/questions/68520767/activejdbc-migrator-force-to-create-schema-version-table-if-it-exits 

##  Start/Stop PostgreSQL:

If you are running the PostgreSQL in docker for the first time execute: 

    docker run --name postgresql-container -p 5432:5432 -e POSTGRES_PASSWORD=somePassword -d postgre

If you want to restart the container: 

    docker  container start postgresql-container

In order to connect to the DB from a command line, execute this:

    psql -h localhost -p 5432 -U postgres -W

## Running the example
 

```
 mvn clean package
 mvn dependency:unpack-dependencies
# Linux:
 java -classpath target/dependency:target/classes activejdbc.examples.simple.Main
# Windows:
 java -classpath target\dependency;target\classes activejdbc.examples.simple.Main 
```

## Logging  into PostgreSQL 

Execute this  on the copmmand line and provide the same passwords as above: 

    psql -h localhost -p 5432 -U postgres -W




