package ru.job4j.camcoder.loader;

import com.google.gson.Gson;
import ru.job4j.camcoder.dto.VideoData;
import ru.job4j.camcoder.handlers.CamcoderHandler;
import ru.job4j.camcoder.web.WebExecuter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class CamcoderLoader implements DataLoader<String, String> {

    private final ExecutorService executor;
    private final WebExecuter webExecuter;

    public CamcoderLoader(ExecutorService executor, WebExecuter webExecuter) {
        this.executor = executor;
        this.webExecuter = webExecuter;
    }

    public String load(String url) {
        List<VideoData> datas = null;
        List<Map<String, Object>> camcoders = webExecuter.get(url, List.class);
        try {
            List<Callable<VideoData>> callables = new ArrayList<>();
            camcoders.forEach(camcoder -> callables.add(new CamcoderHandler(camcoder, webExecuter)));
            for(Future<VideoData> response: executor.invokeAll(callables)) {
                datas.add(response.get());
            }
            executor.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Gson().toJson(datas);
    }
}
