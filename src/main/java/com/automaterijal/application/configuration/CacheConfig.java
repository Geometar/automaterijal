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
    // showcaseBucket: per (group:subgroup) buckets used for warmup
    CacheConfiguration<Object, Object> showcaseBucketEh =
        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Object.class, Object.class, ResourcePoolsBuilder.heap(50_000))
            .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofHours(48)))
            .build();

    // showcaseSections: final sections (maziva, alati, pribor) written by scheduler
    CacheConfiguration<Object, Object> showcaseSectionsEh =
        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Object.class, Object.class, ResourcePoolsBuilder.heap(10_000))
            .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofHours(48)))
            .build();

    // robaCache: existing cache you already use elsewhere
    CacheConfiguration<Object, Object> robaEh =
        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Object.class, Object.class, ResourcePoolsBuilder.heap(100_000))
            .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofMinutes(30)))
            .build();

    Configuration<Object, Object> showcaseBucketCfg =
        Eh107Configuration.fromEhcacheCacheConfiguration(showcaseBucketEh);
    Configuration<Object, Object> showcaseSectionsCfg =
        Eh107Configuration.fromEhcacheCacheConfiguration(showcaseSectionsEh);
    Configuration<Object, Object> robaCfg =
        Eh107Configuration.fromEhcacheCacheConfiguration(robaEh);

    javax.cache.CacheManager jCache = Caching.getCachingProvider().getCacheManager();

    if (jCache.getCache("showcaseBucket") == null) {
      jCache.createCache("showcaseBucket", showcaseBucketCfg);
    }
    if (jCache.getCache("showcaseSections") == null) {
      jCache.createCache("showcaseSections", showcaseSectionsCfg);
    }
    if (jCache.getCache("robaCache") == null) {
      jCache.createCache("robaCache", robaCfg);
    }

    return new JCacheCacheManager(jCache);
  }
}
