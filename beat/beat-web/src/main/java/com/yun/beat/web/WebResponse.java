package com.yun.beat.web;

import java.util.Map;

public class WebResponse<T> {

    public static WebResponse<Map<String, Object>> getSuccessResponse(Map<String, Object> map) {

        WebResponse<Map<String, Object>> response = new WebResponse<Map<String, Object>>();
        return response;
    }
}
