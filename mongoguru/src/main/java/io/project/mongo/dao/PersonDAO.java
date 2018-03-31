package io.project.mongo.dao;

import io.project.mongo.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


@Service
@Scope("singleton")
@Component
public class PersonDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonDAO.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Person> findByAgeRange(Integer startAge, Integer endAge) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gt(startAge).lt(endAge));
        List<Person> users = mongoTemplate.find(query, Person.class);
        return users;
    }

}
