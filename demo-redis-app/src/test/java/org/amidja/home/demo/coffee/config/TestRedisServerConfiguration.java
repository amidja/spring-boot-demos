package org.amidja.home.demo.coffee.config;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Profile;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import redis.embedded.RedisServer;

@TestConfiguration
@Slf4j
@Profile("local")
public class TestRedisServerConfiguration {

	private RedisServer redisServer;

	public TestRedisServerConfiguration(RedisProperties redisProperties) {
		log.debug("... starting RedisServerConfiguration");
		this.redisServer = new RedisServer(redisProperties.getPort());
	}

	@PostConstruct
	public void postConstruct() {
		redisServer.start();
	}

	@PreDestroy
	public void preDestroy() {
		redisServer.stop();
	}

}