package ru.job4j.camcoder;

import ru.job4j.camcoder.loader.CamcoderLoader;
import ru.job4j.camcoder.loader.DataLoader;
import ru.job4j.camcoder.web.SimpleWebExecuter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppCamcoder {
    public static void main(String[] args) {
        new AppCamcoder().run(args);
    }

    private void run (String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        DataLoader<String, String> loader = new CamcoderLoader(executorService, new SimpleWebExecuter());
        if (args.length == 0) {
            throw new RuntimeException("Не указан адрес сервиса");
        }
        loader.load(args[0]);
    }
}

