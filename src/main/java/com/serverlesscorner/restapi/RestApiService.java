package com.serverlesscorner.restapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class RestApiService {

    private static final Logger LOG = LoggerFactory.getLogger(RestApiService.class);

    public Object getSomething(Integer anId) {
        return new String();
    }

}
