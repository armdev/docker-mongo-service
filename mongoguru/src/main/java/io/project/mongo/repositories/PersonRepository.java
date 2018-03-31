/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.mongo.repositories;

import io.project.mongo.domain.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 *
 * @author armena
 */
public interface PersonRepository extends ReactiveMongoRepository<Person, String> {

    Flux<Person> findByLastname(String lastname);

    Flux<Person> findByAgeOrderByAgeDesc(Integer age);

}
