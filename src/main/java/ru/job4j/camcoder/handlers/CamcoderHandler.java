package ru.job4j.camcoder.handlers;

import ru.job4j.camcoder.dto.SourseData;
import ru.job4j.camcoder.dto.TokenData;
import ru.job4j.camcoder.dto.VideoData;
import ru.job4j.camcoder.web.WebExecuter;

import java.util.Map;
import java.util.concurrent.Callable;

public class CamcoderHandler implements Callable<VideoData> {

    private final Map<String, Object> camcoder;
    private final WebExecuter webExecuter;

    public CamcoderHandler(Map<String, Object> camcoder, WebExecuter webExecuter) {
        this.camcoder = camcoder;
        this.webExecuter = webExecuter;
    }

    @Override
    public VideoData call() {
        SourseData sourse = webExecuter.get((String) camcoder.get("sourceDataUrl"), SourseData.class);
        TokenData token = webExecuter.get((String) camcoder.get("tokenDataUrl"), TokenData.class);
        return new VideoData((Integer) camcoder.get("id"), sourse, token);
    }
}
