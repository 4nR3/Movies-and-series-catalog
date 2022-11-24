package com.dh.serieservice.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Chapter {

    @Id
    private String id;
    private String name;
    private Integer number;
    private String urlStream;

    public Chapter(String name, Integer number, String urlStream) {
        this.name = name;
        this.number = number;
        this.urlStream = urlStream;
    }

    public Chapter(){}
}
