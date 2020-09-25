package com.zeek.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2020-09-18
 */
@Slf4j
public class ReactorTest {

    /**
     * 创建一个Flux，并订阅该Flux，然后进行消费
     */
    @Test
    public void createAFlux_just() {
        Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");
        fruitFlux.subscribe(
                f -> System.out.println("Here' some fruit: " + f)
        );
    }

    /**
     * 使用StepVerifier验证Flux
     */
    @Test
    public void stepVerifierTest() {

        Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");
        StepVerifier.create(fruitFlux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Banana")
                .expectNext("Strawberry")
                .verifyComplete();
    }

    @Test
    public void createAFlux_fromArray() {
        String[] fruits = new String[]{
                "Apple", "Orange", "Grape", "Banana", "Strawberry"
        };

        Flux<String> fruitFlux = Flux.fromArray(fruits).log();
        fruitFlux.subscribe(e -> System.out.println(e));
//        StepVerifier.create(fruitFlux)
//                .expectNext("Apple")
//                .expectNext("Orange")
//                .expectNext("Grape")
//                .expectNext("Banana")
//                .expectNext("Strawberry")
//                .verifyComplete();
    }

    @Test
    public void createAFlux_fromStream() {
        Stream<String> fruitStream = Stream.of("Apple", "Orange", "Grape", "Banana", "Strawberry");
        Flux<String> fruitFlux = Flux.fromStream(fruitStream);
    }

    @Test
    public void firstFlux() {

        Flux<String> slowFlux = Flux.just("one", "two", "three")
                .delaySubscription(Duration.ofMillis(100));

        Flux<String> fastFlux = Flux.just("1", "2", "3");

        Flux<String> firstFlux = Flux.first(slowFlux, fastFlux);
        StepVerifier.create(firstFlux)
                .expectNext("1")
                .expectNext("2")
                .expectNext("3")
                .verifyComplete();


    }

    @Test
    public void collectMap() {
        System.out.println("collectMap");
        Flux<String> animalFlux = Flux.just("aardvark", "elephant", "koala", "eagle", "kangaroo");
        // 当不执行StepVerifier代码时log不输出; 当执行了StepVerifier代码后log才输出; 说明消费Mono的时候才进行实际的计算
        Mono<Map<Character, String>> animalMapMono = animalFlux.log().collectMap(a -> a.charAt(0));
        // animalMapMono.subscribe(e -> System.out.println(e));
        // 下面之所以可以这么写，而不用expectNext类似的写法，是因为上一步的collectMap需要得到一个完整的Map对象
        StepVerifier.create(animalMapMono)
                .expectNextMatches(map -> {
                    return map.size() == 3
                            && map.get('a').equals("aardvark")
                            && map.get('e').equals("eagle")
                            && map.get('k').equals("kangaroo");
                })
                .verifyComplete();
    }
}
