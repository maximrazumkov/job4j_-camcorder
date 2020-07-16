package ru.job4j.camcoder.web;


public interface WebExecuter {
    <T> T get(String url, Class<T> clazz);
}
