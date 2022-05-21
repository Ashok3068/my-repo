package com.springboot.demo.demo.service;

import com.couchbase.client.java.AsyncBucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.error.DocumentDoesNotExistException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.demo.model.Institute;
import com.springboot.demo.demo.repository.CBRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rx.Observable;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;


@Component
public class CBRepositoryImpl implements CBRepository {
    static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
   // @Autowired
    private AsyncBucket asyncBucket;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> Object save(T t, String id) throws IOException {
        CompletableFuture<JsonObject> documentCompletableFuture = new CompletableFuture<>();
        Observable<JsonDocument> doc = asyncBucket.upsert(JsonDocument.create(id, JsonObject.fromJson(objectMapper.writeValueAsString(t))));
        doc.subscribe(a -> documentCompletableFuture.complete(a.content()));

        return objectMapper.readValue(documentCompletableFuture.join().toString(), t.getClass());

    }

    @Override
    public <K> Optional<Object> getById(K k) throws IOException {

        CompletableFuture<Boolean> documentCompletableFuture = new CompletableFuture<>();
        CompletableFuture<JsonObject> documentCompletableFuture1 = new CompletableFuture<>();
        asyncBucket.exists(String.valueOf(k)).subscribe(documentCompletableFuture::complete);
        documentCompletableFuture.thenAccept(result -> {
            if (result)

                asyncBucket.get(String.valueOf(k)).subscribe(a -> documentCompletableFuture1.complete(a.content()));
            else {
                documentCompletableFuture1.exceptionally(throwable -> JsonObject.fromJson(throwable.getMessage()));

            }


        });
        if (documentCompletableFuture.join())
            return Optional.of(objectMapper.readValue(documentCompletableFuture1.join().toString(), Institute.class));
        else return Optional.empty();
    }

    @Override
    public <K> String deleteBy(K k) {
        CompletableFuture<String> future = new CompletableFuture<>();


        asyncBucket.remove(String.valueOf(k)).doOnError(throwable -> {
            if (throwable instanceof DocumentDoesNotExistException)


                future.complete("");

            else
                future.complete("complete");

        }).subscribe(a -> a.content());
        if (future.join().isEmpty())
            return "document doesn't exist";
        else
            return "document deleted successfully";

    }


}
