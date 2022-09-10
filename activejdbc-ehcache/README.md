# Example of ActiveJDBC using EHCache 3


> Note: All scripts are to be executed from the project directory. If you are using Windows, 
> just execute commands found inside these script files.

## Step 1 Start MySQL Docker container

Start the MySQL Docker container

```
docker-compose up
```

## Step 2 Create a table 

Execute: 

```
./scripts/insert.sh
```
## Step 3 Run Tests

```
mvn clean install -Dactivejdbc.log=".*"
```

This will execute the test that will ensure that a Person model instances are coming from
a cache for the same queries.

> The `activejdbc.log=".*"` option will ensure that you will see the HIT or MISS statements 
coming out of the cache system.




