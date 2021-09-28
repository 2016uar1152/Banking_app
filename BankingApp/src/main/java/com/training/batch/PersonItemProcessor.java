package com.training.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import com.training.bean.Person;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

  private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

  @Override
  public Person process(final Person person) throws Exception {
	  
	  log.info("Started processing the csv file..");
//    final String firstName = person.getCustId().toUpperCase();
//    final String lastName = person.getMobileNo().toUpperCase();
//
//    final Person transformedPerson = new Person(firstName, lastName);
//
//    log.info("Converting (" + person + ") into (" + transformedPerson + ")");

    return person;
  }

}