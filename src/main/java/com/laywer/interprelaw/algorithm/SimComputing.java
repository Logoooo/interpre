package com.laywer.interprelaw.algorithm;

import com.laywer.interprelaw.model.PrivateLendBase;
import com.laywer.interprelaw.service.PrivateLendBaseService;

import javax.annotation.Resource;
import java.util.*;

import static java.lang.Float.NEGATIVE_INFINITY;

public class SimComputing {

    @Resource
    private PrivateLendBaseService privateLendBaseService;


    public void similaritySet(Double[] goal){
        System.out.println("来了");
        Map<Integer,Double> map = new HashMap<Integer, Double>();

        //目标案例(可删)
        for (int i=0;i<goal.length;i++){
            System.out.print(goal[i]+" ");
        }


        //读取案例库数据
        double[][] index = caseDataSet();

        //开始计算
        double[] minArray = getMinArray(index);
        double[] maxArray = getMaxArray(index);

        double[][] standardArray = getStandardizationValue(index,minArray,maxArray);

        //计算特征属性值比重
        double[][] attributeRatio = getAttributeRatio(standardArray);
        //输出控制台（可删）：属性值比重
        for (int i=0; i<attributeRatio.length;i++){
            for (int j=0; j<attributeRatio[i].length;j++){
                System.out.println(" 比重："+standardArray[i][j]);
            }
            System.out.println();
        }

        //计算特征属性值的熵值
        double[] attributeEntropy = getAttributeEntropy(attributeRatio);

        //计算特征属性值的信息熵
        double[] informationEntropy = getInformationEntropy(attributeEntropy);

        //计算特征属性值的权重
        double[] attributeWeight = getAttributeWeight(informationEntropy);

        //历史案例与目标案例之间的相似度为：
        double[] similitySet = new double[index.length];

        for (int i=0; i<index.length;i++){
//            similitySet[i] = computerSimility(index[i],attributeWeight,goal);
            map.put(i+1, similitySet[i]);
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

    //从数据库读取案例库数据
    public  double[][] caseDataSet(){

        List<PrivateLendBase> list =  privateLendBaseService.selectAllCase();

        Object[] s = (Object[]) list.toArray();
        double[][] index = new double[s.length][];

        int j=0;
        for (int i=0; i<s.length;i++){
            index[i] = (double[]) s[i];
        }

        //输出二维数组的值
        for (int z=0;z<index.length;z++){
            for (int i=0;i<index[z].length;i++){
                System.out.println(index[z][i]);
            }
        }

        return index;
    }
}
