package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.api.service.impl.MovieServiceImpl;
import com.dh.movieservice.domain.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
	private MovieServiceImpl movieService;

	private static final Logger log = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	public MovieController(MovieServiceImpl movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/{genre}")
	public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
		return ResponseEntity.ok().body(movieService.getListByGenre(genre,false));
	}

	@PostMapping
	public ResponseEntity<String> saveMovie(@RequestBody Movie movie) {
		log.info("Agregada una nueva pelicula");
		movieService.save(movie);
		return ResponseEntity.ok().body("Pelicula enviada a la cola");
	}
}
