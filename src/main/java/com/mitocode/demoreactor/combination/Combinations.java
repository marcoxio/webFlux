package com.mitocode.demoreactor.combination;

import com.mitocode.demoreactor.DemoReactorApplication;
import com.mitocode.demoreactor.model.Person;
import com.mitocode.demoreactor.model.Sell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void merge() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        List<Person> persons2 = new ArrayList<>();
        persons.add(new Person(4,"Harry",27));
        persons.add(new Person(5,"Ron",28));
        persons.add(new Person(6,"Hermione",29));

        List<Sell> sells = new ArrayList<>();
        sells.add(new Sell(1, LocalDateTime.now()));

        Flux<Person> fx1 = Flux.fromIterable(persons);
        Flux<Person> fx2 = Flux.fromIterable(persons2);
        Flux<Sell> fx3 = Flux.fromIterable(sells);

        Flux.merge(fx1, fx2, fx3)
                .subscribe(person -> log.info(person.toString()));
    }

    public void zip() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        List<Person> persons2 = new ArrayList<>();
        persons.add(new Person(4,"Harry",27));
        persons.add(new Person(5,"Ron",28));
        persons.add(new Person(6,"Hermione",29));

        List<Sell> sells = new ArrayList<>();
        sells.add(new Sell(1, LocalDateTime.now()));

        Flux<Person> fx1 = Flux.fromIterable(persons);
        Flux<Person> fx2 = Flux.fromIterable(persons2);
        Flux<Sell> fx3 = Flux.fromIterable(sells);

//        Flux.zip(fx1, fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
//                .subscribe(x -> log.info(x));

        Flux.zip(fx1,fx2,fx3)
                .subscribe(person -> log.info(person.toString()));
    }

    public void zipWith() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        List<Person> persons2 = new ArrayList<>();
        persons.add(new Person(4,"Harry",27));
        persons.add(new Person(5,"Ron",28));
        persons.add(new Person(6,"Hermione",29));

        List<Sell> sells = new ArrayList<>();
        sells.add(new Sell(1, LocalDateTime.now()));

        Flux<Person> fx1 = Flux.fromIterable(persons);
        Flux<Person> fx2 = Flux.fromIterable(persons2);
        Flux<Sell> fx3 = Flux.fromIterable(sells);


        fx1.zipWith(fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
                .subscribe(person -> log.info(person.toString()));
    }
}
