# ActiveWeb Kitchensink

ActiveWeb + ActiveJDBC example project showing some basic capabilities

## Running 

### Database connection parameters

Open the file and adjust 'development' and 'test' database connection properties
according to your configuration:

```
 src/main/resources/database.properties
```

### Create development and test databases

Execute the following: 

```
mvn db-migrator:create
```

### Start Jetty

```
mvn jetty:run
```

then access the app at [http://localhost:8080](http://localhost:8080), explore code, see what makes it tick. 