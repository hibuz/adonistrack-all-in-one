# Adonistrack Usecase Demo Project

## Pre requisites
```
./mvnw install -N && ./mvnw -pl adonistrack-versions install
```

## Run the application

```
./mvnw -pl adonistrack-usecase spring-boot:run

```
## Building for production

### Packaging as jar

To build the final jar and optimize the example application for production, run:

```
./mvnw package -DskipTests
```

To ensure everything worked, run:

```
java -jar adonistrack-usecase/target/*.jar
```

Then navigate to followings below in your browser.
- http://localhost:8080/h2-console
- http://localhost:8080/swagger-ui/index.html
- http://localhost:8080/webjars/adonistrack-ui/html/invocations.html


## References
- https://github.com/woozoo73/adonistrack-spring-demo