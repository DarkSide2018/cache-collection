package org.springframework.samples.petclinic.system;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
class CacheConfiguration {
	@Bean
	public CacheManager cacheManager() {
		CaffeineCacheManager cacheManager = new CaffeineCacheManager("owner");
		cacheManager.setCaffeine(caffeineCacheBuilder());
		return cacheManager;
	}

	private Caffeine< Object, Object > caffeineCacheBuilder() {
		return Caffeine.newBuilder()
			.initialCapacity(10)
			.maximumSize(10);
	}
}
