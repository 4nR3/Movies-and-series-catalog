package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.model.dto.SerieWS;
import com.dh.catalogservice.domain.repository.CatalogRepository;
import com.dh.catalogservice.domain.repository.MovieRepository;
import com.dh.catalogservice.domain.repository.SerieRepository;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
	private MovieRepository movieRepository;
	private SerieRepository serieRepository;
	private CatalogRepository catalogRepository;

	private static final Logger log = LoggerFactory.getLogger(CatalogServiceImpl.class);


	@Autowired
	public CatalogServiceImpl(MovieRepository movieRepository, SerieRepository serieRepository, CatalogRepository catalogRepository) {
		this.movieRepository = movieRepository;
		this.serieRepository=serieRepository;
		this.catalogRepository=catalogRepository;
	}

	@Override
	public CatalogWS findCatalogByGenre(String genre, Boolean throwError) throws RuntimeException{

		if(throwError)
			throw new RuntimeException();

		ResponseEntity <List <MovieWS> > movies = movieRepository.getMovieByGenre(genre);
		ResponseEntity <List <SerieWS> > series = serieRepository.getSerieByGenre(genre);

		if(movies.getStatusCode().is2xxSuccessful() && series.getStatusCode().is2xxSuccessful()) {
			CatalogWS catalogWS = new CatalogWS(genre, movies.getBody(), series.getBody());
			save(catalogWS);
			return catalogWS;
		}
		return null;
	}

	@Override
	public CatalogWS save(CatalogWS catalogWS){
		catalogRepository.deleteByGenre(catalogWS.getGenre());
		return catalogRepository.save(catalogWS);
	}

	@Override
	public List <CatalogWS> findAll(){
		return (List<CatalogWS>) catalogRepository.findAll();
	}



}
