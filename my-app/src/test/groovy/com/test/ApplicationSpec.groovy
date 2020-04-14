package com.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.context.WebApplicationContext
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import spock.lang.Specification

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class ApplicationSpec extends Specification {

    @LocalServerPort
    int port;
    @Autowired
    WebApplicationContext applicationContext

    @Autowired
    private TestRestTemplate restTemplate;

    void 'test application startup'() {
        expect: 'web application context exist'
        applicationContext
    }

    void "should return Greetings from Spring Boot!"() {
        when: 'Invoke greetings endpoint'
        ResponseEntity entity = restTemplate.getForEntity("http://localhost:"+port, String.class)

        then: 'expect hello messages'
        entity.statusCode == HttpStatus.OK
        entity.body == 'Hello'
    }
}
