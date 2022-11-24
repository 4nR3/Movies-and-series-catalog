package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface CatalogService {

    CatalogWS findCatalogByGenre(String genre, Boolean throwError);
    CatalogWS save(CatalogWS catalogWS);
    List <CatalogWS> findAll();

}
