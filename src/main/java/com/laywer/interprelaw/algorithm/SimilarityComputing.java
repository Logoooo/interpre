package com.laywer.interprelaw.algorithm;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.biff.DisplayFormat;
import jxl.read.biff.BiffException;
import jxl.write.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.Float.NEGATIVE_INFINITY;

public class SimilarityComputing {
    public static double[] getMinArray(double[][] index){
        double [] min = new double[index[0].length];
        for (int j=0;j<index[0].length;j++){
            double minValue = index[0][j];
            for (int i=0; i<index.length;i++){
                if (minValue>index[i][j]){
                    minValue = index[i][j];
                }
            }
            min[j] = minValue;
        }
        return min;
    }

    public static double[] getMaxArray(double[][] index){
        double [] max = new double[index[0].length];

        for (int j=0;j<index[0].length;j++){
            double maxValue = index[0][j];
            for (int i=0; i<index.length;i++){
                if (maxValue<index[i][j]){
                    maxValue = index[i][j];
                }
            }
            max[j] = maxValue;
        }
        return max;
    }

    //属性标准化处理
    public static double[][] getStandardizationValue(double[][] index,double[] minArray, double[] maxArray){
        double[][] standard = new double[index.length][index[0].length];
        double value;
        for(int i = 0; i<index.length;i++){
            for (int j=0; j<index[i].length;j++){
                value = index[i][j];
                double min = minArray[j];
                double max = maxArray[j];
                System.out.print(value +"*"+min +"*"+max+" ");
                if (max == 0){
                    standard[i][j] = 0;
                }else{
                    standard[i][j] = (value - min) / max;
                }

                System.out.print("标准值："+standard[i][j]);

            }
            System.out.println();

        }

        return standard;
    }

    //计算特征属性值比重
    public static double[][] getAttributeRatio(double[][] standardArray){
        double value = 0;
        double[] standardCollection = new double[standardArray[0].length];
        double[][] attributeCollection = new double[standardArray.length][standardArray[0].length];
        //求公式（2）的分母
        for (int j=0; j<standardArray[0].length;j++){
            double sum = 0;
            for (int i=0; i<standardArray.length;i++){
                value = standardArray[i][j];
                sum += value;
            }
            standardCollection[j] = sum;
            System.out.print("第"+j+"列和："+standardCollection[j]+" ");
        }
        System.out.println();
        //计算公式（2）
        for (int m=0;m<standardArray.length;m++){
            for (int n=0;n<standardArray[m].length;n++){
                double standardValue = standardArray[m][n];
                double standardSum = standardCollection[n];
                if (standardSum == 0){
                    attributeCollection[m][n] = 0;
                }else{
                    attributeCollection[m][n] =  standardValue/standardSum;
                }

                System.out.print("Pij的值为: "+attributeCollection[m][n]+" ");
            }
            System.out.println();
        }
        return attributeCollection;
    }
    //计算特征属性值的熵值
    public static double[] getAttributeEntropy(double[][] attributeRatio){
        double attributeEntropyValue = 0;
//        double attributeEntropySum = 0;
        double attributeEntropyMultiply=0;
        double[] standardCollection = new double[attributeRatio[0].length];
        for (int j=0; j<attributeRatio[0].length;j++){
            double attributeEntropySum = 0;
            for (int i=0; i<attributeRatio.length;i++){
                attributeEntropyValue= attributeRatio[i][j];
//                System.out.println(Math.log(attributeEntropyValue)+"开心不");
                // 有错误，继续修改
                if (Math.log(attributeEntropyValue) == NEGATIVE_INFINITY) {
                    attributeEntropyMultiply = 0;
                } else if (Math.log(attributeEntropyValue) == 0) {
                    attributeEntropyMultiply = 0;
                } else {
                    attributeEntropyMultiply = Math.log(attributeEntropyValue) * attributeEntropyValue;
                }

                System.out.print(attributeEntropyMultiply+" ");
                attributeEntropySum += attributeEntropyMultiply;
            }
            System.out.println();
            if (Math.log(attributeRatio.length) == 0){
                standardCollection[j] = 0;
            }else {
                standardCollection[j] = -attributeEntropySum / (Math.log(attributeRatio.length));
            }
            System.out.println("第"+j+"个指标特征属性值的熵值"+standardCollection[j]);
        }
        return standardCollection;
    }
    //公式（4）计算特征属性值的信息熵
    public static double[] getInformationEntropy(double[] informationEntropy){
        double[] entropyValue  = new double[informationEntropy.length];
        for (int i=0; i<informationEntropy.length;i++){
            entropyValue[i] = 1 - informationEntropy[i];
            System.out.print("信息熵"+entropyValue[i]+" ");
        }
        System.out.println();
        return entropyValue;
    }

    //公式（5）计算特征属性值的权重
    public static double[] getAttributeWeight(double[] informationEntropy){
        double informationWeightSum = 0;
        double[] informationWeight = new double[informationEntropy.length];
        for (int i=0;i<informationEntropy.length;i++){
            System.out.print(informationEntropy[i]+" ");
            informationWeightSum += informationEntropy[i];

        }
        System.out.println("信息熵之和为："+informationWeightSum);
        for (int j=0;j<informationEntropy.length;j++){
            informationWeight[j] = informationEntropy[j] / informationWeightSum;
            System.out.print("权重"+informationWeight[j]+" ");
        }
        System.out.println();
        return informationWeight;
    }
    //公式（6）相似度计算模型
    public static double computerSimility(double[] index,double[] attributeWeight,double[] goal){
        double up = 0;
        double downl = 0;
        double down2 = 0;
        double downLeft = 0;
        double downRight = 0;
        double similityResult = 0;
        for (int i=0;i<index.length;i++){
            up +=(index[i]*attributeWeight[i]*goal[i]*attributeWeight[i]);
        }
        for (int j=0;j<index.length;j++){
            downLeft += (index[j]*index[j]*attributeWeight[j]*attributeWeight[j]);
        }
        for (int z=0;z<index.length;z++){
            downRight += goal[z]*goal[z]*attributeWeight[z]*attributeWeight[z];
        }
        downl = Math.sqrt(downLeft);
        down2 = Math.sqrt(downRight);

        similityResult = up/(downl*down2);

        return similityResult;
    }
    public static void main(String[] args) throws BiffException, IOException,Exception{

        Map<Integer,Double> map = new HashMap<Integer, Double>();
        caseTest();
        double[] goal = getGoalCase(19);
        for (int i=0;i<goal.length;i++){
            System.out.print(goal[i]+" ");
        }
        double[][] index = caseDataSet();
//        double[][] index2 =caseTest();

        double[] minArray = getMinArray(index);
        double[] maxArray = getMaxArray(index);

        double[][] standardArray = getStandardizationValue(index,minArray,maxArray);

        //计算特征属性值比重
        double[][] attributeRatio = getAttributeRatio(standardArray);
        for (int i=0; i<attributeRatio.length;i++){
            for (int j=0; j<attributeRatio[i].length;j++){
                System.out.print(standardArray[i][j]+" 分割 ");

            }
            System.out.println();
        }
//        System.out.println(attributeRatio);
        //计算特征属性值的熵值
        double[] attributeEntropy = getAttributeEntropy(attributeRatio);

        // 计算特征属性值的信息熵
        double[] informationEntropy = getInformationEntropy(attributeEntropy);

        // 计算特征属性值的权重
        double[] attributeWeight = getAttributeWeight(informationEntropy);
        //历史案例与目标案例之间的相似度为：
        double[] similitySet = new double[index.length];

        //相似度统计
//        TimeSeries timeSeries1 = new TimeSeries("A", Month.class);
//        for(int i=0;i< index[0].length;i++) {
        for (int i=0;i<standardArray.length;i++){

            System.out.println("第"+(i+1)+"个案例的标准化值为：");
            for (int j=0;j<standardArray[i].length;j++){
                System.out.print(standardArray[i][j]+" ");
            }
            System.out.println();
            System.out.println();
        }
        for (int i=0;i<index.length;i++){
//            for (int j=0;j<index[0].length;j++){
//            }
            // 有问题代入参数应为：标准化后的值standardArray[][] ，权重，目标案例
//                System.out.print(index[i][j]+" ");
            similitySet[i] = computerSimility(index[i], attributeWeight, goal);
            map.put(i+1,similitySet[i]);
            System.out.println("案例号"+(i+1)+" "+"相似度"+similitySet[i] + " ");
        }
        List<Map.Entry<Integer,Double>> list_Data = new ArrayList<Map.Entry<Integer, Double>>(map.entrySet());
        Collections.sort(list_Data, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println(list_Data);
    }

    //读取前130条作为案例数据集
    public static double[][] caseDataSet() throws Exception{
        WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false);
        DisplayFormat displayFormat = NumberFormats.TEXT;
        WritableCellFormat format = new WritableCellFormat(wf,displayFormat);

        format.setAlignment(jxl.format.Alignment.LEFT);
        format.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.NONE);
        double[][] index = new double[130][60];
//        File xFile = new File("E:\\法律项目\\jxl(1).xls");
        File xFile = new File("E:\\法律项目\\数据测试\\txt2\\historyCase.xls");
        // 创建一个工作簿
        WritableWorkbook workbook1 = Workbook.createWorkbook(xFile);
        // 创建一个工作表
        WritableSheet sheetss = workbook1.createSheet("sheet1", 1);
//        jxl.write.Number number = new jxl.write.Number(1, 1, Double.parseDouble("2000"),format);
//        sheetss.addCell(number);
//        workbook1.write();
//        workbook1.close();
//        File xlsFile = new File("E:\\法律项目\\数据测试\\data(无日期).xls");
        File xlsFile = new File("E:\\法律项目\\数据测试\\txt2\\指标值1.xls");
        // 获得工作簿对象
        Workbook workbook = Workbook.getWorkbook(xlsFile);
        // 获得所有工作表
        Sheet[] sheets = workbook.getSheets();
        // 遍历工作表
        if (sheets != null)
        {
            for (Sheet sheet : sheets)
            {
                // 获得行数
                int rows = sheet.getRows();
                // 获得列数
                int cols = sheet.getColumns();
                System.out.println(rows + " " +cols);
                // 读取数据(自提取指标)
//                for (int row = 2; row < 132; row++)
//                {
//                    for (int col = 9; col < cols; col++)
//                    {
//                        jxl.write.Number number = new jxl.write.Number(col-9, row-2, Double.parseDouble(sheet.getCell(col, row)
//                                .getContents()),format);
//                        index[row-2][col-9] = Double.parseDouble(sheet.getCell(col, row).getContents());
//                        sheetss.addCell(number);
////                        System.out.printf("%10s", sheet.getCell(col, row)
////                                .getContents());
//                    }
////                    System.out.println();
//                }

                //读取数据（if-idf）
                for (int row = 0; row < 130; row++)
                {
                    for (int col = 2; col < cols; col++)
                    {
                        jxl.write.Number number = new jxl.write.Number(col-2, row, Double.parseDouble(sheet.getCell(col, row)
                                .getContents()),format);
                        index[row][col-2] = Double.parseDouble(sheet.getCell(col, row).getContents());
                        sheetss.addCell(number);
                    }
                }

                workbook1.write();
                workbook1.close();
            }
        }
        workbook.close();
        return index;
    }
    //读取后20条作为测试用例
    public static double[][] caseTest() throws Exception{
        WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false);
        DisplayFormat displayFormat = NumberFormats.TEXT;
        WritableCellFormat format = new WritableCellFormat(wf,displayFormat);

        format.setAlignment(jxl.format.Alignment.LEFT);
        format.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.NONE);
        double[][] index = new double[20][60];
//        File xFile = new File("E:\\法律项目\\jxl(2).xls");

        File xFile = new File("E:\\法律项目\\数据测试\\txt2\\testCase.xls");
        // 创建一个工作簿
        WritableWorkbook workbook1 = Workbook.createWorkbook(xFile);
        // 创建一个工作表
        WritableSheet sheetss = workbook1.createSheet("sheet1", 1);
//        File xlsFile = new File("E:\\法律项目\\数据测试\\data(无日期).xls");
        File xlsFile = new File("E:\\法律项目\\数据测试\\txt2\\指标值1.xls");
        // 获得工作簿对象
        Workbook workbook = Workbook.getWorkbook(xlsFile);
        // 获得所有工作表
        Sheet[] sheets = workbook.getSheets();
        // 遍历工作表
        if (sheets != null)
        {
            for (Sheet sheet : sheets)
            {
                // 获得行数
                int rows = sheet.getRows();
                // 获得列数
                int cols = sheet.getColumns();
                System.out.println(rows + " " +cols);


                // 读取数据
//                for (int row = 132; row < 152; row++)
//                {
//                    for (int col = 9; col < cols; col++)
//                    {
//                        jxl.write.Number number = new jxl.write.Number(col-9, row-132, Double.parseDouble(sheet.getCell(col, row)
//                                .getContents()),format);
//                        index[row-132][col-9] = Double.parseDouble(sheet.getCell(col, row).getContents());
//                        sheetss.addCell(number);
////                        System.out.printf("%10s", sheet.getCell(col, row)
////                                .getContents());
//                    }
////                    System.out.println();
//                }

                //读取数据（if-idf方法）
                for (int row = 130; row < 150; row++)
                {
                    for (int col = 2; col < cols; col++)
                    {
                        jxl.write.Number number = new jxl.write.Number(col-2, row-130, Double.parseDouble(sheet.getCell(col, row)
                                .getContents()),format);
                        index[row-130][col-2] = Double.parseDouble(sheet.getCell(col, row).getContents());
                        sheetss.addCell(number);
//                        System.out.printf("%10s", sheet.getCell(col, row)
//                                .getContents());
                    }
//                    System.out.println();
                }

                workbook1.write();
                workbook1.close();
            }
        }
        workbook.close();
        return index;
    }
    //读取目标案例
    public static double[] getGoalCase(int row) throws Exception{
        double index[] = new double[60];
//        File xlsFile = new File("E:\\法律项目\\jxl(2).xls");
        File xlsFile = new File("E:\\法律项目\\数据测试\\txt2\\testCase.xls");
        // 获得工作簿对象
        Workbook workbook = Workbook.getWorkbook(xlsFile);
        // 获得所有工作表
        Sheet[] sheets = workbook.getSheets();
        // 遍历工作表
        Cell cell;
//        Map<String,Double> data = new HashMap<String, Double>();

//        String regex = "《(.*?)》\\第(.*?)\\条";
//        java.util.regex.Pattern pattern = Pattern.compile(regex);
//        Matcher matcher;

        if (sheets != null)
        {
            for (Sheet sheet : sheets)
            {
                // 获得行数
                int rows = sheet.getRows();
                // 获得列数
                int cols = sheet.getColumns();
                // 读取数据
                for (int i=0;i<cols;i++){
//                    cell = sheet.getCell(i,row);
                    index[i] = Double.parseDouble(sheet.getCell(i, row).getContents());
                }
//                matcher = pattern.matcher(cell.getContents());
//                //发现匹配的字符串,存入HashMap中
//                while (matcher.find()){
//                    if(data.get(matcher.group())==null){
//                        aList.add(matcher.group());
//                    }else{
//                        System.out.println("目标案例内容为空");
//                    }
//                }
            }
        }
        workbook.close();
        System.out.println(index);
        return index;
    }
}
