# Dockerized Java Service
This repository is using CS6310 A6 starter code and it contains two Docker separate service to demonstrate how we may deploy a separate service for an application server and a front end service. 
It is using Java backend that uses [Spring Boot](https://spring.io/projects/spring-boot) as our web service framework, and an [nginx](https://www.nginx.com/) web server that serves our html file.
For your convenience we have defined a [docker-compose](https://docs.docker.com/compose/) file to help define our application and orchestrate the deployment locally, as well as a [Makefile](https://www.gnu.org/software/make/manual/make.html) that effectively wraps some build commands for you.

# Quickstart
We can simply run `make && make up` to start our service. For those that do not have `make` installed, we can effectively do the same thing by running the following:
```
docker build -t gatech/backend -f ./images/Dockerfile.backend ./backend
docker build -t gatech/frontend -f ./images/Dockerfile.frontend ./frontend
docker-compose -p gatech -f docker-compose.yml up -d
```
The first two commands are building the backend and frontend images defined by our dockerfiles, and the third is using docker-compose to deploy the service locally.
To break down the first command we can read it as "build an imageusing the `./images/Dockerfile.backend` file from the `./backend` directory and tag it as `gatech/backend`"
To break down the third command, we can read it as "deploy a service called `gatech` as defined in file `docker-compose.yml`

# docker-compose.yml
This file is well commented for additional details, and we recommend reading over this file to understand what is happening.

# Frontend
The frontend source code is located in ./frontend-source-code folder using Vue.JS framework. The pre-build file is already setup and 
you should be able to navigate to [http://localhost:3001](http://localhost:3001) to view the page.

If you want to modify the source code and build your own version, then you can do the following commands.

####  Frontend
```
copy all build files in dist folder and paste into frontend folder of main repo
build the docker file as described in Main repo reademe file.
access at http://localhost:3001/
```
####  Frontend source code is in frontend-source-code folder and can be run and build as follows
####  Project setup
```
npm install
```
####  Compiles and hot-reloads for development
```
npm run serve
```
####  Compiles and minifies for production
```
npm run build
```
####  Lints and fixes files
```
npm run lint
```
####  Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).

# Backend
Our backend is using Java Spring and this service (as defined in our docker-compose file) is exposed on port 8080.

In StreamingWarsApplication controller there are a bunch of different API endpoints that you can check out for more details. You can navigate to [http://localhost:8080/"your end points"](http://localhost:8080/XXXXXX) to view the returned JSON object.

Most of the backend service uses the [Spring Boot](https://spring.io/projects/spring-boot) framework. Take a look at the documentation to familiarize yourself with it.

# Database
The database is postgres 9.6.12. 

# Maven 
This project uses [Apache Maven](https://maven.apache.org/) to manage itself. 
You will see the dependencies defined in `/backend/pom.xml`, and the maven commands called by the backend's Dockerfile.


