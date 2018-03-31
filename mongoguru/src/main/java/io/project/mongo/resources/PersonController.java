package io.project.mongo.resources;

import io.project.mongo.dao.PersonDAO;
import io.project.mongo.domain.Person;
import io.project.mongo.repositories.PersonRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 *
 * @author armena
 */
@RestController
@RequestMapping(path = "/api/v2/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonDAO personDAO;
    
    // http://192.168.99.100:5008/api/v2/person/find/age?age=18
    // http://192.168.99.100:5008/api/v2/person/find/age/range?startAge=11&endAge=100

    @GetMapping
    public long findAll() {
        System.out.println("PersonController: Joke call");
        return System.currentTimeMillis();
    }
    
    
    @GetMapping("/find/age/range")
    public List<Person> findPersonsByAge(@RequestParam Integer startAge, @RequestParam Integer endAge) {
        System.out.println("PersonController: findPersonsByAge");
        return personDAO.findByAgeRange(startAge, endAge);
    }

    @GetMapping("/find/age")
    public Flux<Person> findPersonsByAge(@RequestParam Integer age) {
        System.out.println("PersonController: Called Find ALL");
        return personRepository.findByAgeOrderByAgeDesc(age);
    }

    @GetMapping("/findall")
    public Flux<Person> findAllPerons() {
        System.out.println("PersonController: Called Find ALL");
        return personRepository.findAll();
    }

    @GetMapping("/save")//@RequestBody Person person
    public Flux<Person> savePerson() {
        Long name = null;
        List<Person> personList = new ArrayList<>();
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String userName = null;
        Person person = null;
        int minimum = 12;
        int maximum = 120;
        Random rand = new Random();

        for (int i = 0; i < 10000; i++) {
            int randomNum = minimum + rand.nextInt((maximum - minimum) + 1);
            person = new Person();
            name = System.currentTimeMillis();
            userName = RandomStringUtils.random(length, useLetters, useNumbers);
            person.setFirstname(userName);
            userName = RandomStringUtils.random(length, useLetters, useNumbers);
            person.setLastname(userName);
            person.setAge(randomNum);
            personList.add(person);
        }
        System.out.println("Person list size " + personList.size());
        return personRepository.saveAll(personList);

    }

}
