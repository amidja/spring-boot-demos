package org.amidja.home.demo.coffee.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.TestConfiguration;

import lombok.extern.slf4j.Slf4j;
import redis.embedded.RedisServer;

@TestConfiguration
@Slf4j
public class RedisServerConfiguration {

	private RedisServer redisServer;

	public RedisServerConfiguration(RedisProperties redisProperties) {
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
