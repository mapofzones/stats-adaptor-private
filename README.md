# stats-adaptor

Status of Last Deployment:<br>
<img src="https://github.com/mapofzones/stats-adaptor/workflows/Java%20CI%20with%20Maven/badge.svg"><br>

## Requirements

Running directly:
* java 11
* maven

Running in a container:
* Docker

## Usage

Running directly:
* `mvn package -DskipTests` or `mvn package`
* `java -jar /opt/app.jar --spring.profiles.active=prod`

Running in a container:
* `docker build -t stats-adaptor:v1 .`
* `docker run --env DB_URL=jdbc:postgresql://<ip>:<port>/<db> --env DB_USER=<db_user> --env DB_PASS=<db_user_pass> -it -d --network="host" stats-adaptor:v1`
