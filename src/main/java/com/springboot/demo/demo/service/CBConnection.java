package com.springboot.demo.demo.service;

import com.couchbase.client.java.AsyncBucket;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CBConnection {
   // @Bean
    public AsyncBucket asyncBucket(){
        Cluster cluster = CouchbaseCluster.create("localhost");
        cluster.authenticate("achin18", "ashok123");
        Bucket bucket = cluster.openBucket("sample");
        return bucket.async();

    }
}
