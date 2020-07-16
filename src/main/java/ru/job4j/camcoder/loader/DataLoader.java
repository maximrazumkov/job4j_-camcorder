package ru.job4j.camcoder.loader;

public interface DataLoader<T, R> {
   R load(T from);
}
