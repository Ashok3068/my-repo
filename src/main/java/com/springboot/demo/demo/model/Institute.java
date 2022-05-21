package com.springboot.demo.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Institute {
    public Institute(){}
    private List<Book> books;
    private String instituteId;

    public void setInstituteId(String instituteId) {
        this.instituteId = instituteId;
    }

    public String getInstituteId() {
        return instituteId;
    }

    public void setBook(List<Book> book) {
        this.books = book;
    }

    public List<Book> getBooks() {
        return books;
    }
}
