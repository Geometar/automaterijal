package com.automaterijal.application.configuration;

import java.time.Duration;
import javax.cache.Caching;
import javax.cache.configuration.Configuration;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
@EnableCaching
public class CacheConfig {

  @Bean
  public CacheManager cacheManager() {
    javax.cache.CacheManager jCache = Caching.getCachingProvider().getCacheManager();

    registerCache(
        jCache,
        "showcaseBucket",
        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Object.class, Object.class, ResourcePoolsBuilder.heap(50_000))
            .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofHours(48)))
            .build());

    registerCache(
        jCache,
        "showcaseSections",
        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Object.class, Object.class, ResourcePoolsBuilder.heap(10_000))
            .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofHours(48)))
            .build());

    registerCache(
        jCache,
        "robaCache",
        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Object.class, Object.class, ResourcePoolsBuilder.heap(100_000))
            .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofMinutes(30)))
            .build());

    registerCache(
        jCache,
        "showcaseGroupNames",
        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Object.class, Object.class, ResourcePoolsBuilder.heap(10))
            .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofHours(6)))
            .build());

    registerCache(
        jCache,
        "showcaseSubGroupNames",
        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Object.class, Object.class, ResourcePoolsBuilder.heap(10))
            .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofHours(6)))
            .build());

    registerCache(
        jCache,
        "showcaseManufacturerNames",
        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Object.class, Object.class, ResourcePoolsBuilder.heap(10))
            .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofHours(6)))
            .build());

    registerCache(
        jCache,
        "imageCache",
        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Object.class, Object.class, ResourcePoolsBuilder.heap(1_000))
            .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofHours(3)))
            .build());

    registerCache(
        jCache,
        "blogPostList",
        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Object.class, Object.class, ResourcePoolsBuilder.heap(2_000))
            .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofMinutes(15)))
            .build());

    registerCache(
        jCache,
        "blogPostDetail",
        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Object.class, Object.class, ResourcePoolsBuilder.heap(2_000))
            .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofMinutes(30)))
            .build());

    return new JCacheCacheManager(jCache);
  }

  private void registerCache(
      javax.cache.CacheManager cacheManager, String cacheName, CacheConfiguration<?, ?> cfg) {
    if (cacheManager.getCache(cacheName) == null) {
      Configuration<?, ?> configuration = Eh107Configuration.fromEhcacheCacheConfiguration(cfg);
      cacheManager.createCache(cacheName, configuration);
    }
  }
}
