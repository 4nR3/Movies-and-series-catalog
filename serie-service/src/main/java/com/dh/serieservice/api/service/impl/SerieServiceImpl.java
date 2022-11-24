package com.dh.serieservice.api.service.impl;

import com.dh.serieservice.api.service.SerieService;
import com.dh.serieservice.domain.model.Serie;
import com.dh.serieservice.domain.repository.SerieRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements SerieService {
	private SerieRepository serieRepository;

	private static final Logger log = LoggerFactory.getLogger(SerieServiceImpl.class);
	private RabbitTemplate rabbitTemplate;

	@Value("${queue.movie.name}")
	private String serieQueue;

	@Autowired
	public SerieServiceImpl(SerieRepository serieRepository, RabbitTemplate rabbitTemplate) {
		this.serieRepository = serieRepository;
		this.rabbitTemplate=rabbitTemplate;
	}

	@Override
	public List<Serie> getListByGenre(String genre) {
		return serieRepository.findByGenre(genre);
	}

	@Override
	@RabbitListener(queues = "${queue.movie.name}")
	public Serie save(Serie serie) {
		log.info("Se creo una nueva serie");
		rabbitTemplate.convertAndSend(serieQueue,serie);
		return serieRepository.save(serie);
	}
}
