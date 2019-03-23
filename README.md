# Spring Data Elastic serach 

[![N|Solid](http://www.mkyong.com/wp-content/uploads/2017/03/spring-data-elasticsearch-logo.png)](https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/)

### This project helps you to use the Elastic Search functionality with Spring Data Elastic Search.

## Description
#### This Project initialy loads all the list of Users data into Elastic and Searches. Then Using the following endpoints, different type of operations can be performed:
  - ` /api/users/` - This returns the list of all Users.
  - `/api/users/name/{name}` - This returns the list of Users with name.
  - `/api/users/salary/{salary}` - This returns the list of Users having equal salary.
  - `/api/users/salary/range/{salary}` - This returns the list of Users having salary greater than salary.

## Libraries used
 - Spring Boot
 - Spring REST Controller
 - Spring Data Elastic Search

## Docker - Run Elastic serach using docker image
```sh
docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:6.4.3
```

## Git 2.10.0
 - IntelliJ IDEA 2019.2.4
## Compilation Command
```sh
  mvn clean install - Plain maven clean and install
```
