package org.amidja.home.demo.coffee.config;

import javax.annotation.PreDestroy;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ActiveProfiles;

import lombok.extern.slf4j.Slf4j;
import redis.embedded.RedisServer;

@TestConfiguration
@ActiveProfiles("local")
@Slf4j
class RedisServerLocalConfiguration {

	private RedisServer redisServer;

	public RedisServerLocalConfiguration(RedisProperties redisProperties) {
		log.debug("... starting RedisServerLocalConfiguration");
		this.redisServer = new RedisServer(redisProperties.getPort());
	}

	public void postConstruct() {
		redisServer.start();
	}

	@PreDestroy
	public void preDestroy() {
		redisServer.stop();
	}

}
