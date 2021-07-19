package com.jsako.spring.cloud.alibaba.webflux.test;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Author: JsAko
 * @Email: 359270069@qq.com
 * @Date 2021/5/19 18:26
 * @Description:
 */
public class ReactorTest {

    @Test
    public void test1() {
        Mono.just(1).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(1);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Test
    public void test2() {
        Mono.fromRunnable(() -> {
            System.out.println("1");
//            throw new RuntimeException();
        }).then(Mono.fromRunnable(() -> {
            System.out.println("2");
        })).doOnError(throwable -> {
            System.out.println(2 + "t");
            throwable.printStackTrace();
        }).then(Mono.fromRunnable(() -> {
            System.out.println("3");
        })).doOnError(throwable -> {
            System.out.println(222);
        }).subscribe();
    }

    @Test
    public void test3() {
        Mono.just(2).then(Mono.just(10)).subscribe(integer -> {
            System.out.println(integer);
        });
    }

    @Test
    public void test4() {
        Mono.create(monoSink -> monoSink.success(1)).then(Mono.just(10)).subscribe(i -> {
            System.out.println(i);
        });
    }

    @Test
    public void test5() {
        Mono.empty().subscribe(o -> {
            System.out.println(o);
        });
    }

    @Test
    public void test6() {
        Mono.just(1).subscribe(o -> {
            System.out.println(o);
        });
    }

    @Test
    public void test7() {
        Flux.concat(Mono.empty(), Mono.empty()).next().switchIfEmpty(Mono.just(3))
                .subscribe(integer -> System.out.println(integer));
    }

    @Test
    public void test8() {
        Flux.concat(Mono.just(1), Mono.just(2)).concatMap(integer -> {
            System.out.println("map");
            return Mono.just("map" + integer);
        }).next().subscribe(o -> {
            System.out.println(o);
        });
    }

    @Test
    public void test9() {
        Flux.zip(Mono.just(true), Mono.just(false))
                .map(objects -> true).subscribe(aBoolean -> System.out.println(aBoolean));
    }

    @Test
    public void test10() {
        Flux.just(1, 2).filterWhen(integer -> integer == 1 ? Mono.just(false) : Mono.just(true))
                .subscribe(integer -> System.out.println(integer));
    }

    @Test
    public void test11() {
        Mono.just(1).filterWhen(i -> Mono.just(true)).doOnNext(integer -> System.out.println(integer))
                .filter(integer -> true).doOnNext(System.out::println).subscribe(integer -> System.out.println(integer));
    }

    @Test
    public void test14() {
        Mono.just(1).flatMap(t -> Mono.<Object>just(4)).flatMap(o -> Mono.just(2)).subscribe(integer -> System.out.println("1"));
    }

    @Test
    public void test15() {
        Mono.<Void>fromRunnable(() -> System.out.println("start")).then(Mono.defer(() -> {
            System.out.println("defer1");
            return defer();
        })).subscribe();
    }

    private Mono<Void> defer() {
        return Mono.defer(() -> {
            System.out.println("defer2");
            return Mono.fromRunnable(() -> System.out.println("run"));
        });
    }


    @Test
    public void test16() throws InterruptedException {
        Mono.<Integer>create(monoSink -> {
            new Thread(() -> {
                monoSink.success(1);
            }).start();
        }).subscribe(o -> System.out.println(o + Thread.currentThread().getName()));
        Thread.sleep(1000000L);
    }

    @Test
    public void test17() {
        new Mono<Void>() {
            @Override
            public void subscribe(CoreSubscriber actual) {
                Mono.fromRunnable(() -> {
                    System.out.println("inner runnable");
                }).subscribe(actual);
            }
        }.then(Mono.fromRunnable(() -> {
            System.out.println("outter runnable");
        })).subscribe();
    }
}
