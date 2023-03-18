package com.aliyun.gp.task;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import com.aliyun.gp.dto.HistoryDayLineDto;
import com.aliyun.gp.dto.Response;
import com.aliyun.gp.utils.RestTemplateUtil;
import org.junit.Test;

import java.util.*;

public class test {
    @Test
    public void test1()  {

        String today= DateUtil.today();
        String start = DateUtil.formatDate(DateUtil.offset(DateUtil.parse(today), DateField.DAY_OF_WEEK, -30));


        String code = "002288";
        String end = "2023-03-09";
//        String url = "https://stockapi.com.cn/v1/base/day";

        Map<String, String> paramMap = MapUtil.builder(new HashMap<String,String>()).put("code", code).put("startDate", start).put("endDate", today).build();
        String path = "/v1/base/day";
        String url = RestTemplateUtil.convertUrl(path, paramMap);
        String result = RestTemplateUtil.httpGetRequest(url);

//        HistoryDayLineDto dto = JSONUtil.toBean(result, HistoryDayLineDto.class);
        Response<HistoryDayLineDto> response = JSONUtil.toBean(result, Response.class);
//        Class<HistoryDayLineDto> tClass = new SingleResponse<HistoryDayLineDto>().getTClass();
//        tClass.getClass();
        List<JSONObject> data = (List<JSONObject>) response.getData();
        JSONArray objects = JSONUtil.parseArray(data);
        List<HistoryDayLineDto> dataList = JSONUtil.toList(objects, HistoryDayLineDto.class);

        HistoryDayLineDto min = dataList.stream().min(Comparator.comparing(s -> Double.valueOf(s.getAmount()))).get();

//        System.out.println(dto);
        System.out.println(response);
        System.out.println(min);
    }
}
