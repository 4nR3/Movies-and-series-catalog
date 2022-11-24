package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "movie-service")
public interface MovieRepository {

    @GetMapping("/movies/{genre}")
    ResponseEntity <List<MovieWS> > getMovieByGenre(@PathVariable("genre") String genre);

    @PostMapping("/movies")
    ResponseEntity<String> saveMovie(@RequestBody MovieWS movie);
}
