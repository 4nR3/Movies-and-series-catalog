package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.api.service.impl.CatalogServiceImpl;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	private CatalogServiceImpl catalogService;
	private static final Logger log = LoggerFactory.getLogger(CatalogController.class);
	@Autowired
	public CatalogController(CatalogServiceImpl catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping("/{genre}")
	ResponseEntity<CatalogWS> getCatalogByGenre(@PathVariable String genre, @RequestParam(defaultValue = "false") Boolean throwError, HttpServletResponse response) {
		CatalogWS catalog = catalogService.findCatalogByGenre(genre,throwError);
		return Objects.isNull(catalog)
				? new ResponseEntity<>(HttpStatus.BAD_REQUEST)
				: new ResponseEntity<>(catalog,HttpStatus.OK);
	}

	@GetMapping()
	ResponseEntity<List<CatalogWS>> listCatalog() {
		List <CatalogWS> catalog = catalogService.findAll();
		return Objects.isNull(catalog)
				? new ResponseEntity<>(HttpStatus.BAD_REQUEST)
				: new ResponseEntity<>(catalog,HttpStatus.OK);
	}

}
