package com.dh.catalogservice.domain.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SerieWS {

    private String id;
    private String name;
    private String genre;
    private List <Season> seasons;

    public SerieWS(){}

    public SerieWS(String id, String name, String genre, List<Season> seasons) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.seasons = seasons;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Season> getSeason() {
        return seasons;
    }

    public void setSeason(List<Season> seasons) {
        this.seasons = seasons;
    }
}
