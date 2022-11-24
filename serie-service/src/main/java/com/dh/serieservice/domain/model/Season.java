package com.dh.serieservice.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
public class Season {

    @Id
    private String id;
    private Integer seasonNumber;
    private List<Chapter> chapters;

    public Season(Integer seasonNumber, List<Chapter> chapters) {
        this.seasonNumber = seasonNumber;
        this.chapters = chapters;
    }

    public Season(){

    }
}
