package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.dto.SerieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "serie-service")
public interface SerieRepository {

    @GetMapping("/series/{genre}")
    ResponseEntity<List<SerieWS>> getSerieByGenre(@PathVariable("genre") String genre);

    @PostMapping("/series")
    ResponseEntity<String> saveMovie(@RequestBody SerieWS serie);
}
