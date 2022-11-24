package com.dh.catalogservice.domain.repository;

import com.dh.catalogservice.domain.model.dto.CatalogWS;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CatalogRepository extends PagingAndSortingRepository<CatalogWS,Integer> {

    public CatalogWS deleteByGenre (String genre);

}
