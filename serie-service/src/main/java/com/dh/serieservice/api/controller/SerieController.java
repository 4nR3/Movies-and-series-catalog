package com.dh.serieservice.api.controller;

import com.dh.serieservice.api.service.SerieService;
import com.dh.serieservice.domain.model.Serie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {
	private SerieService serieService;
	private static final Logger log = LoggerFactory.getLogger(SerieController.class);


	@Autowired
	public SerieController(SerieService serieService, RabbitTemplate rabbitTemplate) {
		this.serieService = serieService;
	}

	@GetMapping("/{genre}")
	public ResponseEntity<List<Serie>> getSeriesByGenre(@PathVariable String genre) {
		return ResponseEntity.ok().body(serieService.getListByGenre(genre));
	}

	@PostMapping
	public ResponseEntity<String> saveMovie(@RequestBody Serie serie) {
		serieService.save(serie);
		return ResponseEntity.ok().body("La serie fue enviada a la cola");
	}
}
