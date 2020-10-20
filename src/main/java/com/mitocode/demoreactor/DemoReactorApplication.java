package com.mitocode.demoreactor;

import com.mitocode.demoreactor.model.Person;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

	public void reactor() {
		Mono.just(new Person(1,"Mito",29))
				.doOnNext(person -> {
					// more logic
					log.info("[Reactor] Persona: " + person);
				});
				.subscribe(person -> log.info("[Reactor] Persona: " + person));
	}


	public void rxjava2() {
		Observable.just(new Person(1,"Mito",29))
				.doOnNext(person -> log.info("[RxJava2] Persona: " + person)));
				.subscribe(person -> log.info("[RxJava2] Persona: " + person));
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		reactor();
		rxjava2();
	}

}
