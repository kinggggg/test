package com.zeek.reactor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import javax.xml.bind.SchemaOutputResolver;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
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
    public void flatMap() {
//        Flux<Player> playerFlux = Flux.just("a AA", "b BB", "c CC")
//                .flatMap(n -> Mono.just(n)
//                        .map(p -> {
//                            String[] split = p.split("\\s");
//                            return new Player(split[0], split[1]);
//                        })
//                        .subscribeOn(Schedulers.parallel())
//                );

        List<Player> playerList = Arrays.asList(new Player("a", "AA"), new Player("b", "BB"), new Player("c", "CC"));
        // 下面输出false，因此下面的测试会失败
        System.out.println(playerList.contains(new Player("a", "AA")));
//        StepVerifier.create(playerFlux)
//                .expectNextMatches(p -> playerList.contains(p))
//                .expectNextMatches(p -> playerList.contains(p))
//                .expectNextMatches(p -> playerList.contains(p))
//                .verifyComplete();


    }

    @Test
    public void flatMap2() {
        Flux<String> stringFlux = Flux.just("a", "b", "c")
                                      .flatMap(n -> Mono.just(n).log()
                                                        .map(p -> {
                                                            // 通过输出线程的名称可以看到在不同的线程中执行
                                                            System.out.println(Thread.currentThread().getName());
                                                           return p + p.toUpperCase();})
                                                        .subscribeOn(Schedulers.parallel())
                                       );

        List<String> stringList = Arrays.asList("aA", "bB", "cC");
        StepVerifier.create(stringFlux)
                .expectNextMatches(p -> stringList.contains(p))
                .expectNextMatches(p -> stringList.contains(p))
                .expectNextMatches(p -> stringList.contains(p))
                .verifyComplete();
    }

    @Test
    public void buffer() {
        Flux<List<String>> bufferedFlux = Flux.just("a", "b", "c", "d", "e")
                .buffer(3);
        StepVerifier.create(bufferedFlux)
                .expectNext(Arrays.asList("a", "b", "c"))
                .expectNext(Arrays.asList("d", "e"))
                .verifyComplete();
    }

    @Test
    public void buffer2() {
        Flux<List<String>> bufferedFlux = Flux.just("a", "b", "c", "d", "e")
                .buffer(3);
                bufferedFlux.flatMap(x ->
                        Flux.fromIterable(x)
                                .map(y -> {
                                    System.out.println(Thread.currentThread().getName());
                                    System.out.println(y);
                                    return y.toUpperCase();
                                })
                                .subscribeOn(Schedulers.parallel())
                                .log())
                        .subscribe();

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

