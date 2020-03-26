# ActiveWeb REST API Example APP

Provides an example CRUD REST service using [JavaLite](http://javalite.io) technologies. 

## Running

### Adjust database connection values

* [database.properties](src/main/resources/database.properties)

### create databases:

You need to do this only once. Foe more information see [Database migrations](http://javalite.io/database_migrations). 

```
mvn db-migrator:create
```

### Start the app

Running is the same as any other Java app:

```
mvn jetty:run
```

and then navigating to [http://localhost:8080/people](http://localhost:8080/people).

### Posting new JSON document

is easy by executing this command (from root of this project):

```
curl -X POST -H "Content-Type: octet/stream" --data-binary @src/test/resources/people.json http://localhost:8080/people

```

Navigate to [http://localhost:8080/people](http://localhost:8080/people) again and see new people created (and note their IDs).

Explore an individual person:
[http://localhost:8080/people/1](http://localhost:8080/people/1), where "1" is an ID of a single person


## Features

* **Models are simple**: [src/main/java/app/models](src/main/java/app/models). Only the Person model
has a method `getAddresses()`, otherwise no methods
* **RESTful controller uses automatic routes**: [PeopleController.java](src/main/java/app/controllers/PeopleController.java)
* **Exceptional conditions handled outside business logic**: [CatchAllFilter.java](src/main/java/app/controllers/CatchAllFilter.java)
* **JSON is generated using powerful templating**: with partials and children - [people views](src/main/webapp/WEB-INF/views/people/)
* **Tests expect certain JSON structure and data**: [PeopleControllerSpec.java](src/test/java/app/controllers/PeopleControllerSpec.java)
