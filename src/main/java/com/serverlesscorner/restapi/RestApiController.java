package com.serverlesscorner.restapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@RestController
@EnableWebMvc
@RequestMapping(value = "/someResource")
@Import(RestApiService.class)
public class RestApiController {

    private final RestApiService service;

    private static final Logger LOG = LoggerFactory.getLogger(RestApiController.class);

    public RestApiController(RestApiService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> getBookByIsbn(@PathVariable("id") Integer id) {
        Object something = service.getSomething(id);

        if (something != null) {
            return new ResponseEntity<>(something, HttpStatus.OK);
        } else {
            LOG.info(" something not found");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
