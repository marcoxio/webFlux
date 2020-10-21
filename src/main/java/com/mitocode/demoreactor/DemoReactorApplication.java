package com.mitocode.demoreactor;

import com.mitocode.demoreactor.combination.Combinations;
import com.mitocode.demoreactor.conditional.Conditional;
import com.mitocode.demoreactor.error.ErrorOp;
import com.mitocode.demoreactor.model.Person;
import com.mitocode.demoreactor.operators.Creation;
import com.mitocode.demoreactor.operators.Matematico;
import com.mitocode.demoreactor.transformation.Transformation;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

	public void reactor() {
		Mono.just(new Person(1,"Mito",29))
				.doOnNext(person -> {
					// more logic
					log.info("[Reactor] Persona: " + person);
				})
				.subscribe(person -> log.info("[Reactor] Persona: " + person));
	}


	public void rxjava2() {
		Observable.just(new Person(1,"Mito",29))
				.doOnNext(person -> log.info("[RxJava2] Persona: " + person))
				.subscribe(person -> log.info("[RxJava2] Persona: " + person));
	}


	public void mono() {
		Mono.just(new Person(1,"Mito",29))
				.subscribe(person -> log.info(person.toString()));
	}

	public void flux() {
		List<Person>persons = new ArrayList<>();
		persons.add(new Person(1,"Mito",27));
		persons.add(new Person(2,"Code",28));
		persons.add(new Person(3,"Jaime",29));

		Flux.fromIterable(persons)
				.subscribe(person -> log.info(person.toString()));
	}


	public void fluxMono() {
		List<Person>persons = new ArrayList<>();
		persons.add(new Person(1,"Mito",27));
		persons.add(new Person(2,"Code",28));
		persons.add(new Person(3,"Jaime",29));

		Flux<Person> fx = Flux.fromIterable(persons);
		fx.collectList()
				.subscribe(list -> log.info(list.toString()));


	}



	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Matematico app = new Matematico();
		app.summarizing();
	}

}
