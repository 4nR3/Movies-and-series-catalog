package com.dh.movieservice.api.service.impl;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import com.dh.movieservice.domain.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
	private MovieRepository movieRepository;

	@Value("${queue.movie.name}")
	private String movieQueue;

	private static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);
	private RabbitTemplate rabbitTemplate;

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository, RabbitTemplate rabbitTemplate) {
		this.movieRepository = movieRepository;
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public List<Movie> getListByGenre(String genre, Boolean throwError) {
		log.info("Buscando peliculas por genero");
		if(throwError){
			log.error("Hubo un error al buscar las peliculas");
			throw new RuntimeException();
		}
		return movieRepository.findAllByGenre(genre);
	}

	@Override
	@RabbitListener(queues = "${queue.movie.name}")
	public Movie save(Movie movie) {
		log.info("Se creo una nueva movie");
		rabbitTemplate.convertAndSend(movieQueue,movie);
		return movieRepository.save(movie);
	}
}
