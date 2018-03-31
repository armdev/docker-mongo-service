package io.project.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableReactiveMongoRepositories("io.project.mongo.repositories")
@ComponentScan("io.project")
public class MongoGuruApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoGuruApplication.class, args);
	}
}
