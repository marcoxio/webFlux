package com.mitocode.demoreactor.filtering;

import com.mitocode.demoreactor.DemoReactorApplication;
import com.mitocode.demoreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filtering {
    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void filter() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .filter(person -> person.getAge() > 28)
                .subscribe(person -> log.info(person.toString()));
    }

    public void distinct() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .distinct()
                .subscribe(person -> log.info(person.toString()));
    }

    public void take() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .take(1)
                .subscribe(person -> log.info(person.toString()));
    }

    public void takeLast() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .takeLast(2)
                .subscribe(person -> log.info(person.toString()));
    }

    public void skip() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .skip(1)
                .subscribe(person -> log.info(person.toString()));
    }

    public void skipLast() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .skipLast(1)
                .subscribe(person -> log.info(person.toString()));
    }

    public static void main(String[] args) {
        Filtering filter = new Filtering();
        filter.skipLast();
    }
}
