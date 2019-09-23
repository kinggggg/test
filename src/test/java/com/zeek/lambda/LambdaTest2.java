package com.zeek.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by weibo_li on 16/8/4.
 */
public class LambdaTest2 {

    /*public static void main(String[] args) throws Exception {
        MyLambdaInterface<String, Integer> myLambdaInterface = r -> { return "1" ;};


        Callable<Runnable> callable = () -> {return () -> {
            System.out.println("hi");
        };} ;

        Runnable runnable = callable.call();
        runnable.run();

        System.out.printf(myLambdaInterface.test(2));
    }*/

    @Test
    public void test() {
        Book book1 = new Book("a", Arrays.asList("z", "t"), new int[]{23});

        Book book2 = new Book("a", Arrays.asList("z", "t"), new int[]{23});

        Book book3 = new Book("a", Arrays.asList("z", "t"), new int[]{23});

        List<Book> library = new ArrayList<>();
        library.add(book1);
        library.add(book2);
        library.add(book3);

        Stream<Book> sorted = library.stream().sorted(Comparator.comparing(Book::getAuthors, Comparator.comparing(List::size))).peek(b -> System.out.println(b.getTitle()));

        Comparator<String> comparator = (Comparator<String>)(c1, c2) -> "a".compareTo("b");

        System.out.println(sorted);
    }

    @Test
    public void scheduleTest() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

        ScheduledFuture<?> future = executor.scheduleWithFixedDelay(new Runnable() {

            @Override public void run() { System.out.println("Now it is 10 seconds later");

            } }, 10, 5, TimeUnit.SECONDS);//10的含义是:从程序开始执行开始,经过10秒后,开始第一次执行这个任务;5的含义是,当第一次执行完成后,在以后的时间内每隔5秒定时执行这个任务一次

        int count = 100;
        while(count > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
        }
    }

    @Test
    public void flatMapTest(){
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);

        Stream<int[]> stream = number1.stream().flatMap(i ->
                                                            number2.stream()
                                                                .map(j -> new int[]{i, j})
                                                        );
    }

    @Test
    public void rangTest() {
        IntStream intStream = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 2 == 0);
        intStream.forEach(System.out::println);
    }

    /**
     * 无限流测试
     */
    @Test
    public void noLimitStreamTest() {
        IntSupplier intSupplier = new IntSupplier() {

            int previous = 0;
            int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;

                return oldPrevious;
            }
        };

        IntStream.generate(intSupplier).limit(10).forEach(System.out::println);
    }
}
