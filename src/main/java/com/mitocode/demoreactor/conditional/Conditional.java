package com.mitocode.demoreactor.conditional;

import com.mitocode.demoreactor.DemoReactorApplication;
import com.mitocode.demoreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Conditional {

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void defaultIfEmpty() {
        Mono.just(new Person(1,"Mito",29))
                .defaultIfEmpty(new Person(0,"DEFAULT",99))
                .subscribe(x -> log.info(x.toString()));
    }

    public void takeUntil() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .takeUntil(person -> person.getAge() > 27)
                .subscribe(x -> log.info(x.toString()));
    }

    public void timeOut() throws InterruptedException{
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .delayElements(Duration.ofSeconds(1))
                .timeout(Duration.ofSeconds(2))
                .subscribe(x -> log.info(x.toString()));

        Thread.sleep(10000);

    }
}
