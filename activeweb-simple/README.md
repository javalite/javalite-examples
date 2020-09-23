# ActiveWeb simple example

Follow these simple steps to run this app:


* AdjustJDBC connection parameters in [database.properties](src/main/resources/database.properties)

* Create two empty schemas in MySQL DB

```
mvn db-migrator:create
```

* Run the application with a console logger

```
mvn jetty:run
```

* Starting with a file logger:

```
mvn jetty:run -Dapp.home=. -Pfile_log
```

* Navigate with browser

    to: [http://localhost:8080/](http://localhost:8080/)
  

