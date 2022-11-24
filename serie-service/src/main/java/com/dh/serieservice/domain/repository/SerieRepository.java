package com.dh.serieservice.domain.repository;

import com.dh.serieservice.domain.model.Serie;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends PagingAndSortingRepository<Serie,Integer> {
	List<Serie> findByGenre(String genre);
}
