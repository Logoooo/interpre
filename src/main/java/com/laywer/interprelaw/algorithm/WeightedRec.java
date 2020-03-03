package com.laywer.interprelaw.algorithm;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//将法律条文加权
public class WeightedRec {
    public static void main(String[] args) throws Exception{
        for (int i=1;i<21;i++){
            lawyers(i,3);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            goalLaywer(i);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }

    }

    //读取五个案例
    public static List<String> lawyers(int r, int c) throws Exception{
        List<String> aList = new ArrayList<>();
        File xlsFile = new File("E:\\法律项目\\数据测试\\测试集.xls");
        //获得工作薄对象
        Workbook workbook = Workbook.getWorkbook(xlsFile);
        //获得所有工作表
        Sheet[] sheets = workbook.getSheets();
        //遍历工作表
        Cell cell;
        Map<String,Double> data = new HashMap<String, Double>();

        String regex = "《(.*?)》\\第(.*?)\\条";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        if (sheets != null){
            for (Sheet sheet : sheets){
                //获得行数
                int rows = sheet.getRows();
                //获得列数
                int cols = sheet.getColumns();
                System.out.println(rows + " " +cols);
                //读取数据
                for (int i=c;i<cols-3;i++){
                    cell = sheet.getCell(i,r);
                    System.out.println(cell.getContents());
                    System.out.println("--------------------------------");
                    matcher = pattern.matcher(cell.getContents());
                    //获取匹配的字符串，存入HashMap中
                    while (matcher.find()){
                        if (data.get(matcher.group()) == null){
                            data.put(matcher.group(),(5-i+c)*1.0/5.0);
                        }else {
                            data.put(matcher.group(),data.get(matcher.group())+((5-i+c)*1.0/5.0));
                        }
                    }
                }
            }
            List<Map.Entry<String,Double>> list_Data = new ArrayList<Map.Entry<String, Double>>(data.entrySet());
            Collections.sort(list_Data, new Comparator<Map.Entry<String, Double>>() {
                @Override
                public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            System.out.println(list_Data);
            System.out.println("-------------加权推荐法律释明----------------");
            for (int i=0;i<list_Data.size();i++){
                if (list_Data.get(i).getValue() > 1.0){
                    aList.add(list_Data.get(i).getKey());
                }else {
                    break;
                }
            }
        }
        System.out.println("推荐的法律条文："+aList);
        workbook.close();
        return aList;
    }

    //获取目标案例对应的法律条文
    public static List<String> goalLaywer(int col) throws Exception{
        List<String> aList = new ArrayList<String>();
        File xlsFile = new File("E:\\法律项目\\数据测试\\测试集.xls");
        //获得工作薄对象
        Workbook workbook = Workbook.getWorkbook(xlsFile);
        //获得所有工作表
        Sheet[] sheets = workbook.getSheets();
        //遍历工作表
        Cell cell;
        Map<String,Double> data = new HashMap<String, Double>();

        String regex = "《(.*?)》\\第(.*?)\\条";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        if (sheets != null){
            for (Sheet sheet : sheets){
                //  // 获得行数
                int rows = sheet.getRows();
                // 获得列数
                int cols = sheet.getColumns();
                // 读取数据
                cell = sheet.getCell(9,col);
                matcher = pattern.matcher(cell.getContents());
                //发现匹配的字符串,存入HashMap中
                while (matcher.find()){
                    if (data.get(matcher.group())==null){
                        aList.add(matcher.group());
                    }else {
                        System.out.println("目标案例内容为空");
                    }
                }
            }
        }
        workbook.close();
        System.out.println(aList);
        return aList;
    }
}
