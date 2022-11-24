package com.dh.catalogservice.domain.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

public class Chapter {

    private String id;
    private String name;
    private Integer number;
    private String urlStream;

    public Chapter(){}

    public Chapter(String id, String name, Integer number, String urlStream) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.urlStream = urlStream;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUrlStream() {
        return urlStream;
    }

    public void setUrlStream(String urlStream) {
        this.urlStream = urlStream;
    }
}
