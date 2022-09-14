## REDIS and Project REACTOR

This demo application is created using a spring boot guide (https://spring.io/guides/gs/spring-data-reactive-redis/ ). 
The key objective of creating this application following the guide is to learn how to use Redis with non-blocking Lettuce driver.

### Try Redis
 - Interactive Redis - https://try.redis.io/


###
#### Running Application locally profile 
 - Make sure you have local instance of redis running on 127.0.0.1:6379
 - Build the project: mvn install
 - Start the application: mvn spring-boot:run -Dspring-boot.run.profile=local  

#### Running Application in Docker
 - Build the project: mvn package
 - Build docker image >> docker build -t demo-redis-img .
 	(This command builds an image and tags it.)

### Testing the application
- curl http://localhost:8080/coffees

### Reference
- Project Reactor: https://projectreactor.io/
- Redis: https://redis.io/  
- Redis Lettuce: https://lettuce.io/
- Spring Data and Redis: https://docs.spring.io/spring-data/redis/docs/2.5.5/reference/html/#reference


### Markdown 

https://www.markdownguide.org/basic-syntax/

RedisProperties
RedisReactiveAutoConfiguration
MongoReactiveDataAutoConfiguration

### Redis in Docker

https://redis.io/docs/stack/get-started/install/docker/

```
docker run -d --name redis-stack -p 6379:6379 -p 8001:8001 redis/redis-stack:latest
```

The docker run command above also exposes RedisInsight on port 8001. You can use RedisInsight by pointing your browser to localhost:8001.
#### Connect with redis-cli
If you don’t have redis-cli installed locally, you can run it from the Docker container:

```
docker exec -it redis-stack redis-cli
```