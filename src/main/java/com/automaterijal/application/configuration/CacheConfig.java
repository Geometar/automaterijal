package com.automaterijal.application.configuration;

import javax.cache.Caching;
import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

  @Bean
  public CacheManager cacheManager() {
    javax.cache.configuration.Configuration<Object, Object> cacheConfiguration =
        Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(
                    Object.class, Object.class, ResourcePoolsBuilder.heap(100000))
                .build());

    javax.cache.CacheManager jCacheManager = Caching.getCachingProvider().getCacheManager();
    jCacheManager.createCache("robaCache", cacheConfiguration);

    return new JCacheCacheManager(jCacheManager); // Use JCacheCacheManager
  }
}
