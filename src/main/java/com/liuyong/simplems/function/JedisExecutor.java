package com.liuyong.simplems.function;

import com.liuyong.simplems.exception.RedisConnectException;

// 该注解不是必须的，如果一个接口符合"函数式接口"定义，那么加不加该注解都没有影响。加上该注解能够更好地让编译器进行检查。如果编写的不是函数式接口，但是加上了@FunctionInterface，那么编译器会报错。@FunctionalInterface标记在接口上，“函数式接口”是指仅仅只包含一个抽象方法的接口。
@FunctionalInterface
public interface JedisExecutor<T, R> {
    R excute(T t) throws RedisConnectException;
}
