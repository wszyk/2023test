package com.aliyun.demo.controller;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: DevStudio
 */
@RestController
public class ExcelController {

    @GetMapping("/excel")
    public String readExcel() throws Exception {
        InputStream inputStream = this.getClass().getResourceAsStream("/data.xlsx");
        List<List<String>> datas = readXlsx(inputStream);
        StringBuilder sb = new StringBuilder();
        sb.append("<pre>");
        for (List<String> row : datas) {
            for (String cell : row) {
                sb.append(cell).append("\t");
            }
            sb.append("\n");
        }
        sb.append("</pre>");
        return sb.toString();
    }

    public List<List<String>> readXlsx(InputStream inputStream) throws Exception {
        List<List<String>> result = new ArrayList<List<String>>();
        XSSFWorkbook workbook = null;
        try {
//            TODO 请参照以下注释，使用代码智能补全编写代码
//            workbook = new XSSFWorkbook(inputStream);
//            XSSFSheet sheet = workbook.getSheetAt(0);
//            int rows = sheet.getLastRowNum();
//            for (int i = 0; i <= rows; i++) {
//                XSSFRow row = sheet.getRow(i);
//                // TODO 请右键点击XSSFRow，选择"查询代码示例"，根据搜索出的代码示例，遍历每行的单元格，取出字符串数据填充到result变量中
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
