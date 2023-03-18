package com.aliyun.gp.dto;

import lombok.Data;

@Data
public class HistoryDayLineDto extends Response {
    String code;
    String time;
    String turnoverRatio;
    String amount;
    String change;
    String high;
    String low;
    String changeRatio;
    String close;
    String volume;
}
