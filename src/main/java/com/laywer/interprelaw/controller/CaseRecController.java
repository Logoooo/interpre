package com.laywer.interprelaw.controller;


import com.laywer.interprelaw.algorithm.SimComputing;
import com.laywer.interprelaw.model.Law;
import com.laywer.interprelaw.model.PrivateLendBase;
import com.laywer.interprelaw.service.LawService;
import com.laywer.interprelaw.service.PrivateLendBaseService;

import com.laywer.interprelaw.service.SimComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/case",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
public class CaseRecController {

    @Resource
    private LawService lawService;
    @Resource
    private PrivateLendBaseService privateLendBaseService;
    @Resource
    private SimComService simComService;

    private PrivateLendBase privateLendBase;

    private Law law;

    //前五相似案例推荐
    @PostMapping(value = "/rec")
    @ResponseBody
    public List<Law> caseRecommod(@RequestParam(value = "whetherrepay") String whetherrepay, @RequestParam("repaymentAmount") double repaymentAmount, @RequestParam(value = "whetherinterest") String whetherinterest,@RequestParam("interestRate")  double interestRate,
                                  @RequestParam(value = "defeandantexpenses") String defeandantexpenses, @RequestParam("otherFee") double otherFee,@RequestParam(value = "whetheroverdue") String whetheroverdue,@RequestParam(value = "iou")  String iou,
                                  @RequestParam(value = "commitment") String commitment,@RequestParam(value = "transferinstructions") String transferinstructions,@RequestParam(value = "wechatrecord")  String wechatrecord,@RequestParam(value = "otherevidence")  String otherevidence,
                                  @RequestParam(value = "amountReturned")  double amountReturned,@RequestParam(value = "amountOwed") double amountOwed,@RequestParam(value = "cash",required = false)  String cash,@RequestParam(value = "banktransfer",required = false)  String banktransfer,@RequestParam(value = "creditcard",required = false)  String creditcard,
                                  @RequestParam(value = "watransfer")  String watransfer,@RequestParam(value = "whethermoneytransfer") String whethermoneytransfer){

        //创建相似案例推荐集合
        List<Law> lawList = new ArrayList<Law>();

        //创建List
        List<Double> list = new ArrayList<Double>();
        //是否偿还

//        System.out.println(whetherrepay);
        if (whetherrepay.equals("是")){
//            privateLendBase.setWhetherrepay(1);
            list.add(1.0);
        }else if (whetherrepay.equals("否") || whetherrepay == null){
//            privateLendBase.setWhetherrepay(0);
            list.add(0.0);
        }

        //偿还金额
        if(repaymentAmount == 0.0){
//            privateLendBase.setRepaymentamount(0);
            list.add(0.0);
        }else{
//            privateLendBase.setRepaymentamount(repaymentAmount);
            list.add(repaymentAmount);
        }

        //是否有利息
        if(whetherinterest.equals("是")){
//            privateLendBase.setWhetherinterest(1);
            list.add(1.0);
        }else if (whetherinterest.equals("否") || whetherinterest == null){
//            privateLendBase.setWhetherinterest(0);
            list.add(0.0);
        }

        //年利率
        if (interestRate == 0){
//            privateLendBase.setInterestrate(0.0);
            list.add(0.0);
        }else {
//            privateLendBase.setInterestrate(interestRate);
            list.add(interestRate);
        }

        //是否需要被告承担其他费用
        if (defeandantexpenses.equals("是")){
//            privateLendBase.setDefeandantexpenses(1);
            list.add(1.0);
        }else if (defeandantexpenses.equals("否") || defeandantexpenses==null){
//            privateLendBase.setDefeandantexpenses(0);
            list.add(0.0);
        }

        //违约金及其他费用
        if(otherFee == 0){
//            privateLendBase.setOtherfee(0);
            list.add(0.0);
        }else {
//            privateLendBase.setOtherfee(otherFee);
            list.add(otherFee);
        }

        //是否逾期
        if (whetheroverdue.equals("是")){
//            privateLendBase.setWhetheroverdue(1);
            list.add(1.0);
        }else if (whetheroverdue.equals("否") || whetheroverdue == null){
//            privateLendBase.setWhetheroverdue(0);
            list.add(0.0);
        }

        //证物--借条
        if (iou.equals("是")){
//            privateLendBase.setIou(1);
            list.add(1.0);
        }else if (iou.equals("否")  || iou == null){
//            privateLendBase.setIou(0);
            list.add(0.0);
        }

        //证物--承诺书
        if(commitment.equals("是")){
//            privateLendBase.setCommitment(1);
            list.add(1.0);
        }else if (commitment.equals("否") || commitment == null){
//            privateLendBase.setCommitment(0);
            list.add(0.0);
        }

        //证物--转账说明
        if (transferinstructions.equals("是")){
//            privateLendBase.setTransferinstructions(1);
            list.add(1.0);
        }else if (transferinstructions.equals("否") || transferinstructions == null){
//            privateLendBase.setTransferinstructions(0);
            list.add(0.0);
        }

        //证物--微信转账记录
        if (wechatrecord.equals("是")){
//            privateLendBase.setWechatrecord(1);
            list.add(1.0);
        }else if (wechatrecord.equals("否") || wechatrecord == null){
//            privateLendBase.setWechatrecord(0);
            list.add(0.0);
        }

        //其他证物
        if (otherevidence.equals("是")){
//            privateLendBase.setOtherevidence(1);
            list.add(1.0);
        }else if (otherevidence.equals("否") || otherevidence == null){
//            privateLendBase.setOtherevidence(0);
            list.add(0.0);
        }

        //已归还金额
        if (amountReturned==0){
//            privateLendBase.setAmountreturned(0);
            list.add(0.0);
        }else {
//            privateLendBase.setAmountreturned(amountReturned);
            list.add(amountReturned);
        }

        //尚欠款金额
        if (amountOwed == 0){
//            privateLendBase.setAmountowed(0);
            list.add(0.0);
        }else {
//            privateLendBase.setAmountowed(amountOwed);
            list.add(amountOwed);
        }

        //付款方式--现金
        if (cash.equals("是")){
//            privateLendBase.setCash(1);
            list.add(1.0);
        }else if (cash.equals("否") || cash ==null){
//            privateLendBase.setCash(0);
            list.add(0.0);
        }

        //付款方式--银行转账
        if (banktransfer.equals("是")){
//            privateLendBase.setBanktransfer(1);
            list.add(1.0);
        }else if (banktransfer.equals("否") || banktransfer == null){
//            privateLendBase.setBanktransfer(0);
            list.add(0.0);
        }

        //付款方式--代还信用卡
        if (creditcard.equals("是")){
//            privateLendBase.setCreditcard(1);
            list.add(1.0);
        }else if (creditcard.equals("否")|| creditcard ==null){
//            privateLendBase.setCreditcard(0);
            list.add(0.0);
        }

        //付款方式--微信支付宝转账
        if (watransfer.equals("是")){
//            privateLendBase.setWatransfer(1);
            list.add(1.0);
        }else if (watransfer.equals("否") || watransfer == null){
//            privateLendBase.setWatransfer(0);
            list.add(0.0);
        }

        //付款方式--是否有流水转账
        if (whethermoneytransfer.equals("是")){
//            privateLendBase.setWhethermoneytransfer(1);
            list.add(1.0);
        }else if (whethermoneytransfer.equals("否") || whethermoneytransfer == null){
//            privateLendBase.setWhethermoneytransfer(0);
            list.add(0.0);
        }

//        //遍历list
//        for (Iterator i=list.iterator();i.hasNext();){
//            System.out.print(i.next()+" ");
//        }

        //目标案例数据
        double[] goalCase = new double[list.size()];
        for (int i=0;i<list.size();i++){
            goalCase[i] = list.get(i);
        }


        //读取数据库数据
        List<PrivateLendBase> list1 = privateLendBaseService.selectAllCase();
        double[][] history = new double[list1.size()][19];
        for (int i=0;i<list1.size();i++){
           history[i][0] = list1.get(i).getWhetherrepay();
           history[i][1] = list1.get(i).getRepaymentamount();
           history[i][2] = list1.get(i).getWhetherinterest();
           history[i][3] = list1.get(i).getInterestrate();
           history[i][4] = list1.get(i).getDefeandantexpenses();
           history[i][5] = list1.get(i).getOtherfee();
           history[i][6] = list1.get(i).getWhetheroverdue();
           history[i][7] = list1.get(i).getIou();
           history[i][8] = list1.get(i).getCommitment();
           history[i][9] = list1.get(i).getTransferinstructions();
           history[i][10] = list1.get(i).getWechatrecord();
           history[i][11] = list1.get(i).getOtherevidence();
           history[i][12] = list1.get(i).getAmountreturned();
           history[i][13] = list1.get(i).getAmountowed();
           history[i][14] = list1.get(i).getCash();
           history[i][15] = list1.get(i).getBanktransfer();
           history[i][16] = list1.get(i).getCreditcard();
           history[i][17] = list1.get(i).getWatransfer();
           history[i][18] = list1.get(i).getWhethermoneytransfer();
        }

        //调用算法——计算相似案例集
        List list2 = new ArrayList();
        list2 = simComService.similaritySet(goalCase,history);
        //相似案例编号保存到数组中
        int[] caseSet = new int[5];
        //取前五个：list2.size()==5
        for (int i=0;i<5;i++){
            String caseNumber = list2.get(i).toString().split("=")[0];
            System.out.println(Integer.valueOf(caseNumber));
            caseSet[i] = Integer.valueOf(caseNumber);
        }

        //通过案例号查询对应的法律案例及法律条文
        for (int i=0;i<caseSet.length;i++){
            law = lawService.selectLaw(caseSet[i]);
            System.out.println(law.getContext()+law.getLegalprovisions());
            lawList.add(law);
        }
        return lawList;
    }


    //法律条文推荐
    @PostMapping(value = "/recLaw")
    @ResponseBody
    public List<String> lawRecommod(@RequestParam(value = "whetherrepay") String whetherrepay, @RequestParam("repaymentAmount") double repaymentAmount, @RequestParam(value = "whetherinterest") String whetherinterest,@RequestParam("interestRate")  double interestRate,
                                  @RequestParam(value = "defeandantexpenses") String defeandantexpenses, @RequestParam("otherFee") double otherFee,@RequestParam(value = "whetheroverdue") String whetheroverdue,@RequestParam(value = "iou")  String iou,
                                  @RequestParam(value = "commitment") String commitment,@RequestParam(value = "transferinstructions") String transferinstructions,@RequestParam(value = "wechatrecord")  String wechatrecord,@RequestParam(value = "otherevidence")  String otherevidence,
                                  @RequestParam(value = "amountReturned")  double amountReturned,@RequestParam(value = "amountOwed") double amountOwed,@RequestParam(value = "cash",required = false)  String cash,@RequestParam(value = "banktransfer",required = false)  String banktransfer,@RequestParam(value = "creditcard",required = false)  String creditcard,
                                  @RequestParam(value = "watransfer")  String watransfer,@RequestParam(value = "whethermoneytransfer") String whethermoneytransfer){

        //创建相似案例推荐集合
        List<Law> lawList = new ArrayList<Law>();

        //创建List
        List<Double> list = new ArrayList<Double>();

        //是否偿还

        if (whetherrepay.equals("是")){
            list.add(1.0);
        }else if (whetherrepay.equals("否") || whetherrepay == null){
            list.add(0.0);
        }

        //偿还金额
        if(repaymentAmount == 0.0){
            list.add(0.0);
        }else{
            list.add(repaymentAmount);
        }

        //是否有利息
        if(whetherinterest.equals("是")){
            list.add(1.0);
        }else if (whetherinterest.equals("否") || whetherinterest == null){
            list.add(0.0);
        }

        //年利率
        if (interestRate == 0){
            list.add(0.0);
        }else {
            list.add(interestRate);
        }

        //是否需要被告承担其他费用
        if (defeandantexpenses.equals("是")){
            list.add(1.0);
        }else if (defeandantexpenses.equals("否") || defeandantexpenses==null){
            list.add(0.0);
        }

        //违约金及其他费用
        if(otherFee == 0){
            list.add(0.0);
        }else {
            list.add(otherFee);
        }

        //是否逾期
        if (whetheroverdue.equals("是")){
            list.add(1.0);
        }else if (whetheroverdue.equals("否") || whetheroverdue == null){
            list.add(0.0);
        }

        //证物--借条
        if (iou.equals("是")){
            list.add(1.0);
        }else if (iou.equals("否")  || iou == null){
            list.add(0.0);
        }

        //证物--承诺书
        if(commitment.equals("是")){
            list.add(1.0);
        }else if (commitment.equals("否") || commitment == null){
            list.add(0.0);
        }

        //证物--转账说明
        if (transferinstructions.equals("是")){
            list.add(1.0);
        }else if (transferinstructions.equals("否") || transferinstructions == null){
            list.add(0.0);
        }

        //证物--微信转账记录
        if (wechatrecord.equals("是")){
            list.add(1.0);
        }else if (wechatrecord.equals("否") || wechatrecord == null){
            list.add(0.0);
        }

        //其他证物
        if (otherevidence.equals("是")){
            list.add(1.0);
        }else if (otherevidence.equals("否") || otherevidence == null){
            list.add(0.0);
        }

        //已归还金额
        if (amountReturned==0){
            list.add(0.0);
        }else {
            list.add(amountReturned);
        }

        //尚欠款金额
        if (amountOwed == 0){
            list.add(0.0);
        }else {
            list.add(amountOwed);
        }

        //付款方式--现金
        if (cash.equals("是")){
            list.add(1.0);
        }else if (cash.equals("否") || cash ==null){
            list.add(0.0);
        }

        //付款方式--银行转账
        if (banktransfer.equals("是")){
            list.add(1.0);
        }else if (banktransfer.equals("否") || banktransfer == null){
            list.add(0.0);
        }

        //付款方式--代还信用卡
        if (creditcard.equals("是")){
            list.add(1.0);
        }else if (creditcard.equals("否")|| creditcard ==null){
            list.add(0.0);
        }

        //付款方式--微信支付宝转账
        if (watransfer.equals("是")){
            list.add(1.0);
        }else if (watransfer.equals("否") || watransfer == null){
            list.add(0.0);
        }

        //付款方式--是否有流水转账
        if (whethermoneytransfer.equals("是")){
            list.add(1.0);
        }else if (whethermoneytransfer.equals("否") || whethermoneytransfer == null){
            list.add(0.0);
        }

        //目标案例数据
        double[] goalCase = new double[list.size()];
        for (int i=0;i<list.size();i++){
            goalCase[i] = list.get(i);
        }


        //读取数据库数据
        List<PrivateLendBase> list1 = privateLendBaseService.selectAllCase();
        double[][] history = new double[list1.size()][19];
        for (int i=0;i<list1.size();i++){
            history[i][0] = list1.get(i).getWhetherrepay();
            history[i][1] = list1.get(i).getRepaymentamount();
            history[i][2] = list1.get(i).getWhetherinterest();
            history[i][3] = list1.get(i).getInterestrate();
            history[i][4] = list1.get(i).getDefeandantexpenses();
            history[i][5] = list1.get(i).getOtherfee();
            history[i][6] = list1.get(i).getWhetheroverdue();
            history[i][7] = list1.get(i).getIou();
            history[i][8] = list1.get(i).getCommitment();
            history[i][9] = list1.get(i).getTransferinstructions();
            history[i][10] = list1.get(i).getWechatrecord();
            history[i][11] = list1.get(i).getOtherevidence();
            history[i][12] = list1.get(i).getAmountreturned();
            history[i][13] = list1.get(i).getAmountowed();
            history[i][14] = list1.get(i).getCash();
            history[i][15] = list1.get(i).getBanktransfer();
            history[i][16] = list1.get(i).getCreditcard();
            history[i][17] = list1.get(i).getWatransfer();
            history[i][18] = list1.get(i).getWhethermoneytransfer();
        }

        //调用算法——计算相似案例集
        List<String> aList = new ArrayList<String>();
        List list2 = new ArrayList();
        list2 = simComService.similaritySet(goalCase,history);
        //相似案例编号保存到数组中
        int[] caseSet = new int[5];
        //取前五个：list2.size()==5
        for (int i=0;i<5;i++){
            String caseNumber = list2.get(i).toString().split("=")[0];
//            System.out.println(Integer.valueOf(caseNumber));
            caseSet[i] = Integer.valueOf(caseNumber);
        }

        //通过案例号查询对应的法律案例及法律条文
        Map<String,Double> data = new HashMap<String, Double>();


        for (int i=0;i<caseSet.length;i++){
//            System.out.println("第"+i+"个进来");
            law = lawService.selectLaw(caseSet[i]);
            //加权
            String legalProvisions = law.getLegalprovisions();
//            System.out.println(legalProvisions);
            //分割字符串
            String[] strings = legalProvisions.split("\\、");
//            for (int j=0;j<strings.length;j++){
//                System.out.print(strings[j]+" ");
//            }
            for (int i1 = 0;i1<strings.length;i1++){
//                System.out.println(data.get(strings[i1]));
                if (data.get(strings[i1]) == null){
                    data.put(strings[i1],(5-i)*1.0/5.0);
                }else {
                    data.put(strings[i1],data.get(strings[i1])+((5-i)*1.0/5.0));
                }

            }
//            System.out.println(data.toString());
        }
        List<Map.Entry<String,Double>> list_Data = new ArrayList<Map.Entry<String,Double>>(data.entrySet());
        Collections.sort(list_Data, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println(list_Data);
        for (int i=0;i<list_Data.size();i++){
            if (list_Data.get(i).getValue() >= 1.0){
                aList.add(list_Data.get(i).getKey());
            }else {
                break;
            }
        }
        return aList;
    }
}
