package com.dh.catalogservice.domain.model.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.List;

@Builder
public class CatalogWS {

	@Id
	private String id;
	private String genre;
	private List<MovieWS> movies;
	private List<SerieWS> series;

	public CatalogWS(){

	}

	public CatalogWS(String genre, List<MovieWS> movies, List<SerieWS> series) {
		this.genre = genre;
		this.movies = movies;
		this.series=series;
	}
	public CatalogWS(String _id, String genre, List<MovieWS> movies, List<SerieWS> series) {
		this.id=id;
		this.genre = genre;
		this.movies = movies;
		this.series=series;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<MovieWS> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieWS> movies) {
		this.movies = movies;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<SerieWS> getSeries() {
		return series;
	}

	public void setSeries(List<SerieWS> series) {
		this.series = series;
	}
}
