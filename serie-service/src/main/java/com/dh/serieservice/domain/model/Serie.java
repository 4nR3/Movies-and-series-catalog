package com.dh.serieservice.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
public class Serie {
	@Id
	private String id;
	private String name;
	private String genre;
	private List<Season> seasons;

	public Serie(String name, String genre, List <Season> seasons) {
		this.name = name;
		this.genre = genre;
		this.seasons = seasons;
	}

	public Serie(){

	}

}
