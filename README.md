## Documentation
### Swagger:
http://localhost:8080/swagger-ui/index.html

### JSON:
http://localhost:8080/api/v1/api-docs

### How to run application:

####  1 variant:

1. Copy project on your device.
2. Open terminal in docker folder.
3. Enter in terminal `docker-compose up -d` - we start app db.
4. Run application.
5. Application ready to use on localhost:8080

#### 2 variant:

1. Copy project on your device.
2. Run mvn package -DskipTests.
3. Open terminal in project folder.
4. Run `docker-compose --env-file docker/.my-env up -d` command.
5. Application ready to use on localhost:8080