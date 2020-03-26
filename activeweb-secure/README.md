ActiveWeb with Login/Logout Security
===================

Provided barebones startup app with basic login/logout security built in. This app has a private page protected by a login and a public page that is not protected.

### Usage

You must have maven available in order to build and run the ActiveWeb application. 

The easiest way to install and run is to clone this repository, and then run maven to download, and start the server.

```
$ git clone git@github.com:javalite/activeweb-secure.git
$ cd activeweb-secure
$ mvn jetty:run
```

After the dependencies are downloaded, and the application is built the jetty server will be started.
Once the server is running you can hit it in your browser using this URL
[http://localhost:8080/](http://localhost:8080/)

For the next step I suggest you checkout the [ActiveWeb](http://javalite.io) documentation and samples.
