package com.laywer.interprelaw.model;

import java.util.ArrayList;
import java.util.List;

public class PrivateLendBaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrivateLendBaseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCaseidIsNull() {
            addCriterion("caseId is null");
            return (Criteria) this;
        }

        public Criteria andCaseidIsNotNull() {
            addCriterion("caseId is not null");
            return (Criteria) this;
        }

        public Criteria andCaseidEqualTo(Integer value) {
            addCriterion("caseId =", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotEqualTo(Integer value) {
            addCriterion("caseId <>", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidGreaterThan(Integer value) {
            addCriterion("caseId >", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("caseId >=", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidLessThan(Integer value) {
            addCriterion("caseId <", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidLessThanOrEqualTo(Integer value) {
            addCriterion("caseId <=", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidIn(List<Integer> values) {
            addCriterion("caseId in", values, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotIn(List<Integer> values) {
            addCriterion("caseId not in", values, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidBetween(Integer value1, Integer value2) {
            addCriterion("caseId between", value1, value2, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotBetween(Integer value1, Integer value2) {
            addCriterion("caseId not between", value1, value2, "caseid");
            return (Criteria) this;
        }

        public Criteria andWhetherrepayIsNull() {
            addCriterion("whetherRepay is null");
            return (Criteria) this;
        }

        public Criteria andWhetherrepayIsNotNull() {
            addCriterion("whetherRepay is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherrepayEqualTo(Integer value) {
            addCriterion("whetherRepay =", value, "whetherrepay");
            return (Criteria) this;
        }

        public Criteria andWhetherrepayNotEqualTo(Integer value) {
            addCriterion("whetherRepay <>", value, "whetherrepay");
            return (Criteria) this;
        }

        public Criteria andWhetherrepayGreaterThan(Integer value) {
            addCriterion("whetherRepay >", value, "whetherrepay");
            return (Criteria) this;
        }

        public Criteria andWhetherrepayGreaterThanOrEqualTo(Integer value) {
            addCriterion("whetherRepay >=", value, "whetherrepay");
            return (Criteria) this;
        }

        public Criteria andWhetherrepayLessThan(Integer value) {
            addCriterion("whetherRepay <", value, "whetherrepay");
            return (Criteria) this;
        }

        public Criteria andWhetherrepayLessThanOrEqualTo(Integer value) {
            addCriterion("whetherRepay <=", value, "whetherrepay");
            return (Criteria) this;
        }

        public Criteria andWhetherrepayIn(List<Integer> values) {
            addCriterion("whetherRepay in", values, "whetherrepay");
            return (Criteria) this;
        }

        public Criteria andWhetherrepayNotIn(List<Integer> values) {
            addCriterion("whetherRepay not in", values, "whetherrepay");
            return (Criteria) this;
        }

        public Criteria andWhetherrepayBetween(Integer value1, Integer value2) {
            addCriterion("whetherRepay between", value1, value2, "whetherrepay");
            return (Criteria) this;
        }

        public Criteria andWhetherrepayNotBetween(Integer value1, Integer value2) {
            addCriterion("whetherRepay not between", value1, value2, "whetherrepay");
            return (Criteria) this;
        }

        public Criteria andRepaymentamountIsNull() {
            addCriterion("repaymentAmount is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentamountIsNotNull() {
            addCriterion("repaymentAmount is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentamountEqualTo(Integer value) {
            addCriterion("repaymentAmount =", value, "repaymentamount");
            return (Criteria) this;
        }

        public Criteria andRepaymentamountNotEqualTo(Integer value) {
            addCriterion("repaymentAmount <>", value, "repaymentamount");
            return (Criteria) this;
        }

        public Criteria andRepaymentamountGreaterThan(Integer value) {
            addCriterion("repaymentAmount >", value, "repaymentamount");
            return (Criteria) this;
        }

        public Criteria andRepaymentamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("repaymentAmount >=", value, "repaymentamount");
            return (Criteria) this;
        }

        public Criteria andRepaymentamountLessThan(Integer value) {
            addCriterion("repaymentAmount <", value, "repaymentamount");
            return (Criteria) this;
        }

        public Criteria andRepaymentamountLessThanOrEqualTo(Integer value) {
            addCriterion("repaymentAmount <=", value, "repaymentamount");
            return (Criteria) this;
        }

        public Criteria andRepaymentamountIn(List<Integer> values) {
            addCriterion("repaymentAmount in", values, "repaymentamount");
            return (Criteria) this;
        }

        public Criteria andRepaymentamountNotIn(List<Integer> values) {
            addCriterion("repaymentAmount not in", values, "repaymentamount");
            return (Criteria) this;
        }

        public Criteria andRepaymentamountBetween(Integer value1, Integer value2) {
            addCriterion("repaymentAmount between", value1, value2, "repaymentamount");
            return (Criteria) this;
        }

        public Criteria andRepaymentamountNotBetween(Integer value1, Integer value2) {
            addCriterion("repaymentAmount not between", value1, value2, "repaymentamount");
            return (Criteria) this;
        }

        public Criteria andWhetherinterestIsNull() {
            addCriterion("whetherInterest is null");
            return (Criteria) this;
        }

        public Criteria andWhetherinterestIsNotNull() {
            addCriterion("whetherInterest is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherinterestEqualTo(Integer value) {
            addCriterion("whetherInterest =", value, "whetherinterest");
            return (Criteria) this;
        }

        public Criteria andWhetherinterestNotEqualTo(Integer value) {
            addCriterion("whetherInterest <>", value, "whetherinterest");
            return (Criteria) this;
        }

        public Criteria andWhetherinterestGreaterThan(Integer value) {
            addCriterion("whetherInterest >", value, "whetherinterest");
            return (Criteria) this;
        }

        public Criteria andWhetherinterestGreaterThanOrEqualTo(Integer value) {
            addCriterion("whetherInterest >=", value, "whetherinterest");
            return (Criteria) this;
        }

        public Criteria andWhetherinterestLessThan(Integer value) {
            addCriterion("whetherInterest <", value, "whetherinterest");
            return (Criteria) this;
        }

        public Criteria andWhetherinterestLessThanOrEqualTo(Integer value) {
            addCriterion("whetherInterest <=", value, "whetherinterest");
            return (Criteria) this;
        }

        public Criteria andWhetherinterestIn(List<Integer> values) {
            addCriterion("whetherInterest in", values, "whetherinterest");
            return (Criteria) this;
        }

        public Criteria andWhetherinterestNotIn(List<Integer> values) {
            addCriterion("whetherInterest not in", values, "whetherinterest");
            return (Criteria) this;
        }

        public Criteria andWhetherinterestBetween(Integer value1, Integer value2) {
            addCriterion("whetherInterest between", value1, value2, "whetherinterest");
            return (Criteria) this;
        }

        public Criteria andWhetherinterestNotBetween(Integer value1, Integer value2) {
            addCriterion("whetherInterest not between", value1, value2, "whetherinterest");
            return (Criteria) this;
        }

        public Criteria andInterestrateIsNull() {
            addCriterion("interestRate is null");
            return (Criteria) this;
        }

        public Criteria andInterestrateIsNotNull() {
            addCriterion("interestRate is not null");
            return (Criteria) this;
        }

        public Criteria andInterestrateEqualTo(Double value) {
            addCriterion("interestRate =", value, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateNotEqualTo(Double value) {
            addCriterion("interestRate <>", value, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateGreaterThan(Double value) {
            addCriterion("interestRate >", value, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateGreaterThanOrEqualTo(Double value) {
            addCriterion("interestRate >=", value, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateLessThan(Double value) {
            addCriterion("interestRate <", value, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateLessThanOrEqualTo(Double value) {
            addCriterion("interestRate <=", value, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateIn(List<Double> values) {
            addCriterion("interestRate in", values, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateNotIn(List<Double> values) {
            addCriterion("interestRate not in", values, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateBetween(Double value1, Double value2) {
            addCriterion("interestRate between", value1, value2, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateNotBetween(Double value1, Double value2) {
            addCriterion("interestRate not between", value1, value2, "interestrate");
            return (Criteria) this;
        }

        public Criteria andDefeandantexpensesIsNull() {
            addCriterion("defeandantExpenses is null");
            return (Criteria) this;
        }

        public Criteria andDefeandantexpensesIsNotNull() {
            addCriterion("defeandantExpenses is not null");
            return (Criteria) this;
        }

        public Criteria andDefeandantexpensesEqualTo(Integer value) {
            addCriterion("defeandantExpenses =", value, "defeandantexpenses");
            return (Criteria) this;
        }

        public Criteria andDefeandantexpensesNotEqualTo(Integer value) {
            addCriterion("defeandantExpenses <>", value, "defeandantexpenses");
            return (Criteria) this;
        }

        public Criteria andDefeandantexpensesGreaterThan(Integer value) {
            addCriterion("defeandantExpenses >", value, "defeandantexpenses");
            return (Criteria) this;
        }

        public Criteria andDefeandantexpensesGreaterThanOrEqualTo(Integer value) {
            addCriterion("defeandantExpenses >=", value, "defeandantexpenses");
            return (Criteria) this;
        }

        public Criteria andDefeandantexpensesLessThan(Integer value) {
            addCriterion("defeandantExpenses <", value, "defeandantexpenses");
            return (Criteria) this;
        }

        public Criteria andDefeandantexpensesLessThanOrEqualTo(Integer value) {
            addCriterion("defeandantExpenses <=", value, "defeandantexpenses");
            return (Criteria) this;
        }

        public Criteria andDefeandantexpensesIn(List<Integer> values) {
            addCriterion("defeandantExpenses in", values, "defeandantexpenses");
            return (Criteria) this;
        }

        public Criteria andDefeandantexpensesNotIn(List<Integer> values) {
            addCriterion("defeandantExpenses not in", values, "defeandantexpenses");
            return (Criteria) this;
        }

        public Criteria andDefeandantexpensesBetween(Integer value1, Integer value2) {
            addCriterion("defeandantExpenses between", value1, value2, "defeandantexpenses");
            return (Criteria) this;
        }

        public Criteria andDefeandantexpensesNotBetween(Integer value1, Integer value2) {
            addCriterion("defeandantExpenses not between", value1, value2, "defeandantexpenses");
            return (Criteria) this;
        }

        public Criteria andOtherfeeIsNull() {
            addCriterion("otherFee is null");
            return (Criteria) this;
        }

        public Criteria andOtherfeeIsNotNull() {
            addCriterion("otherFee is not null");
            return (Criteria) this;
        }

        public Criteria andOtherfeeEqualTo(Integer value) {
            addCriterion("otherFee =", value, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeNotEqualTo(Integer value) {
            addCriterion("otherFee <>", value, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeGreaterThan(Integer value) {
            addCriterion("otherFee >", value, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("otherFee >=", value, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeLessThan(Integer value) {
            addCriterion("otherFee <", value, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeLessThanOrEqualTo(Integer value) {
            addCriterion("otherFee <=", value, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeIn(List<Integer> values) {
            addCriterion("otherFee in", values, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeNotIn(List<Integer> values) {
            addCriterion("otherFee not in", values, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeBetween(Integer value1, Integer value2) {
            addCriterion("otherFee between", value1, value2, "otherfee");
            return (Criteria) this;
        }

        public Criteria andOtherfeeNotBetween(Integer value1, Integer value2) {
            addCriterion("otherFee not between", value1, value2, "otherfee");
            return (Criteria) this;
        }

        public Criteria andWhetheroverdueIsNull() {
            addCriterion("whetherOverdue is null");
            return (Criteria) this;
        }

        public Criteria andWhetheroverdueIsNotNull() {
            addCriterion("whetherOverdue is not null");
            return (Criteria) this;
        }

        public Criteria andWhetheroverdueEqualTo(Integer value) {
            addCriterion("whetherOverdue =", value, "whetheroverdue");
            return (Criteria) this;
        }

        public Criteria andWhetheroverdueNotEqualTo(Integer value) {
            addCriterion("whetherOverdue <>", value, "whetheroverdue");
            return (Criteria) this;
        }

        public Criteria andWhetheroverdueGreaterThan(Integer value) {
            addCriterion("whetherOverdue >", value, "whetheroverdue");
            return (Criteria) this;
        }

        public Criteria andWhetheroverdueGreaterThanOrEqualTo(Integer value) {
            addCriterion("whetherOverdue >=", value, "whetheroverdue");
            return (Criteria) this;
        }

        public Criteria andWhetheroverdueLessThan(Integer value) {
            addCriterion("whetherOverdue <", value, "whetheroverdue");
            return (Criteria) this;
        }

        public Criteria andWhetheroverdueLessThanOrEqualTo(Integer value) {
            addCriterion("whetherOverdue <=", value, "whetheroverdue");
            return (Criteria) this;
        }

        public Criteria andWhetheroverdueIn(List<Integer> values) {
            addCriterion("whetherOverdue in", values, "whetheroverdue");
            return (Criteria) this;
        }

        public Criteria andWhetheroverdueNotIn(List<Integer> values) {
            addCriterion("whetherOverdue not in", values, "whetheroverdue");
            return (Criteria) this;
        }

        public Criteria andWhetheroverdueBetween(Integer value1, Integer value2) {
            addCriterion("whetherOverdue between", value1, value2, "whetheroverdue");
            return (Criteria) this;
        }

        public Criteria andWhetheroverdueNotBetween(Integer value1, Integer value2) {
            addCriterion("whetherOverdue not between", value1, value2, "whetheroverdue");
            return (Criteria) this;
        }

        public Criteria andIouIsNull() {
            addCriterion("iou is null");
            return (Criteria) this;
        }

        public Criteria andIouIsNotNull() {
            addCriterion("iou is not null");
            return (Criteria) this;
        }

        public Criteria andIouEqualTo(Integer value) {
            addCriterion("iou =", value, "iou");
            return (Criteria) this;
        }

        public Criteria andIouNotEqualTo(Integer value) {
            addCriterion("iou <>", value, "iou");
            return (Criteria) this;
        }

        public Criteria andIouGreaterThan(Integer value) {
            addCriterion("iou >", value, "iou");
            return (Criteria) this;
        }

        public Criteria andIouGreaterThanOrEqualTo(Integer value) {
            addCriterion("iou >=", value, "iou");
            return (Criteria) this;
        }

        public Criteria andIouLessThan(Integer value) {
            addCriterion("iou <", value, "iou");
            return (Criteria) this;
        }

        public Criteria andIouLessThanOrEqualTo(Integer value) {
            addCriterion("iou <=", value, "iou");
            return (Criteria) this;
        }

        public Criteria andIouIn(List<Integer> values) {
            addCriterion("iou in", values, "iou");
            return (Criteria) this;
        }

        public Criteria andIouNotIn(List<Integer> values) {
            addCriterion("iou not in", values, "iou");
            return (Criteria) this;
        }

        public Criteria andIouBetween(Integer value1, Integer value2) {
            addCriterion("iou between", value1, value2, "iou");
            return (Criteria) this;
        }

        public Criteria andIouNotBetween(Integer value1, Integer value2) {
            addCriterion("iou not between", value1, value2, "iou");
            return (Criteria) this;
        }

        public Criteria andCommitmentIsNull() {
            addCriterion("commitment is null");
            return (Criteria) this;
        }

        public Criteria andCommitmentIsNotNull() {
            addCriterion("commitment is not null");
            return (Criteria) this;
        }

        public Criteria andCommitmentEqualTo(Integer value) {
            addCriterion("commitment =", value, "commitment");
            return (Criteria) this;
        }

        public Criteria andCommitmentNotEqualTo(Integer value) {
            addCriterion("commitment <>", value, "commitment");
            return (Criteria) this;
        }

        public Criteria andCommitmentGreaterThan(Integer value) {
            addCriterion("commitment >", value, "commitment");
            return (Criteria) this;
        }

        public Criteria andCommitmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("commitment >=", value, "commitment");
            return (Criteria) this;
        }

        public Criteria andCommitmentLessThan(Integer value) {
            addCriterion("commitment <", value, "commitment");
            return (Criteria) this;
        }

        public Criteria andCommitmentLessThanOrEqualTo(Integer value) {
            addCriterion("commitment <=", value, "commitment");
            return (Criteria) this;
        }

        public Criteria andCommitmentIn(List<Integer> values) {
            addCriterion("commitment in", values, "commitment");
            return (Criteria) this;
        }

        public Criteria andCommitmentNotIn(List<Integer> values) {
            addCriterion("commitment not in", values, "commitment");
            return (Criteria) this;
        }

        public Criteria andCommitmentBetween(Integer value1, Integer value2) {
            addCriterion("commitment between", value1, value2, "commitment");
            return (Criteria) this;
        }

        public Criteria andCommitmentNotBetween(Integer value1, Integer value2) {
            addCriterion("commitment not between", value1, value2, "commitment");
            return (Criteria) this;
        }

        public Criteria andTransferinstructionsIsNull() {
            addCriterion("transferInstructions is null");
            return (Criteria) this;
        }

        public Criteria andTransferinstructionsIsNotNull() {
            addCriterion("transferInstructions is not null");
            return (Criteria) this;
        }

        public Criteria andTransferinstructionsEqualTo(Integer value) {
            addCriterion("transferInstructions =", value, "transferinstructions");
            return (Criteria) this;
        }

        public Criteria andTransferinstructionsNotEqualTo(Integer value) {
            addCriterion("transferInstructions <>", value, "transferinstructions");
            return (Criteria) this;
        }

        public Criteria andTransferinstructionsGreaterThan(Integer value) {
            addCriterion("transferInstructions >", value, "transferinstructions");
            return (Criteria) this;
        }

        public Criteria andTransferinstructionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("transferInstructions >=", value, "transferinstructions");
            return (Criteria) this;
        }

        public Criteria andTransferinstructionsLessThan(Integer value) {
            addCriterion("transferInstructions <", value, "transferinstructions");
            return (Criteria) this;
        }

        public Criteria andTransferinstructionsLessThanOrEqualTo(Integer value) {
            addCriterion("transferInstructions <=", value, "transferinstructions");
            return (Criteria) this;
        }

        public Criteria andTransferinstructionsIn(List<Integer> values) {
            addCriterion("transferInstructions in", values, "transferinstructions");
            return (Criteria) this;
        }

        public Criteria andTransferinstructionsNotIn(List<Integer> values) {
            addCriterion("transferInstructions not in", values, "transferinstructions");
            return (Criteria) this;
        }

        public Criteria andTransferinstructionsBetween(Integer value1, Integer value2) {
            addCriterion("transferInstructions between", value1, value2, "transferinstructions");
            return (Criteria) this;
        }

        public Criteria andTransferinstructionsNotBetween(Integer value1, Integer value2) {
            addCriterion("transferInstructions not between", value1, value2, "transferinstructions");
            return (Criteria) this;
        }

        public Criteria andWechatrecordIsNull() {
            addCriterion("weChatRecord is null");
            return (Criteria) this;
        }

        public Criteria andWechatrecordIsNotNull() {
            addCriterion("weChatRecord is not null");
            return (Criteria) this;
        }

        public Criteria andWechatrecordEqualTo(Integer value) {
            addCriterion("weChatRecord =", value, "wechatrecord");
            return (Criteria) this;
        }

        public Criteria andWechatrecordNotEqualTo(Integer value) {
            addCriterion("weChatRecord <>", value, "wechatrecord");
            return (Criteria) this;
        }

        public Criteria andWechatrecordGreaterThan(Integer value) {
            addCriterion("weChatRecord >", value, "wechatrecord");
            return (Criteria) this;
        }

        public Criteria andWechatrecordGreaterThanOrEqualTo(Integer value) {
            addCriterion("weChatRecord >=", value, "wechatrecord");
            return (Criteria) this;
        }

        public Criteria andWechatrecordLessThan(Integer value) {
            addCriterion("weChatRecord <", value, "wechatrecord");
            return (Criteria) this;
        }

        public Criteria andWechatrecordLessThanOrEqualTo(Integer value) {
            addCriterion("weChatRecord <=", value, "wechatrecord");
            return (Criteria) this;
        }

        public Criteria andWechatrecordIn(List<Integer> values) {
            addCriterion("weChatRecord in", values, "wechatrecord");
            return (Criteria) this;
        }

        public Criteria andWechatrecordNotIn(List<Integer> values) {
            addCriterion("weChatRecord not in", values, "wechatrecord");
            return (Criteria) this;
        }

        public Criteria andWechatrecordBetween(Integer value1, Integer value2) {
            addCriterion("weChatRecord between", value1, value2, "wechatrecord");
            return (Criteria) this;
        }

        public Criteria andWechatrecordNotBetween(Integer value1, Integer value2) {
            addCriterion("weChatRecord not between", value1, value2, "wechatrecord");
            return (Criteria) this;
        }

        public Criteria andOtherevidenceIsNull() {
            addCriterion("otherEvidence is null");
            return (Criteria) this;
        }

        public Criteria andOtherevidenceIsNotNull() {
            addCriterion("otherEvidence is not null");
            return (Criteria) this;
        }

        public Criteria andOtherevidenceEqualTo(Integer value) {
            addCriterion("otherEvidence =", value, "otherevidence");
            return (Criteria) this;
        }

        public Criteria andOtherevidenceNotEqualTo(Integer value) {
            addCriterion("otherEvidence <>", value, "otherevidence");
            return (Criteria) this;
        }

        public Criteria andOtherevidenceGreaterThan(Integer value) {
            addCriterion("otherEvidence >", value, "otherevidence");
            return (Criteria) this;
        }

        public Criteria andOtherevidenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("otherEvidence >=", value, "otherevidence");
            return (Criteria) this;
        }

        public Criteria andOtherevidenceLessThan(Integer value) {
            addCriterion("otherEvidence <", value, "otherevidence");
            return (Criteria) this;
        }

        public Criteria andOtherevidenceLessThanOrEqualTo(Integer value) {
            addCriterion("otherEvidence <=", value, "otherevidence");
            return (Criteria) this;
        }

        public Criteria andOtherevidenceIn(List<Integer> values) {
            addCriterion("otherEvidence in", values, "otherevidence");
            return (Criteria) this;
        }

        public Criteria andOtherevidenceNotIn(List<Integer> values) {
            addCriterion("otherEvidence not in", values, "otherevidence");
            return (Criteria) this;
        }

        public Criteria andOtherevidenceBetween(Integer value1, Integer value2) {
            addCriterion("otherEvidence between", value1, value2, "otherevidence");
            return (Criteria) this;
        }

        public Criteria andOtherevidenceNotBetween(Integer value1, Integer value2) {
            addCriterion("otherEvidence not between", value1, value2, "otherevidence");
            return (Criteria) this;
        }

        public Criteria andAmountreturnedIsNull() {
            addCriterion("amountReturned is null");
            return (Criteria) this;
        }

        public Criteria andAmountreturnedIsNotNull() {
            addCriterion("amountReturned is not null");
            return (Criteria) this;
        }

        public Criteria andAmountreturnedEqualTo(Integer value) {
            addCriterion("amountReturned =", value, "amountreturned");
            return (Criteria) this;
        }

        public Criteria andAmountreturnedNotEqualTo(Integer value) {
            addCriterion("amountReturned <>", value, "amountreturned");
            return (Criteria) this;
        }

        public Criteria andAmountreturnedGreaterThan(Integer value) {
            addCriterion("amountReturned >", value, "amountreturned");
            return (Criteria) this;
        }

        public Criteria andAmountreturnedGreaterThanOrEqualTo(Integer value) {
            addCriterion("amountReturned >=", value, "amountreturned");
            return (Criteria) this;
        }

        public Criteria andAmountreturnedLessThan(Integer value) {
            addCriterion("amountReturned <", value, "amountreturned");
            return (Criteria) this;
        }

        public Criteria andAmountreturnedLessThanOrEqualTo(Integer value) {
            addCriterion("amountReturned <=", value, "amountreturned");
            return (Criteria) this;
        }

        public Criteria andAmountreturnedIn(List<Integer> values) {
            addCriterion("amountReturned in", values, "amountreturned");
            return (Criteria) this;
        }

        public Criteria andAmountreturnedNotIn(List<Integer> values) {
            addCriterion("amountReturned not in", values, "amountreturned");
            return (Criteria) this;
        }

        public Criteria andAmountreturnedBetween(Integer value1, Integer value2) {
            addCriterion("amountReturned between", value1, value2, "amountreturned");
            return (Criteria) this;
        }

        public Criteria andAmountreturnedNotBetween(Integer value1, Integer value2) {
            addCriterion("amountReturned not between", value1, value2, "amountreturned");
            return (Criteria) this;
        }

        public Criteria andAmountowedIsNull() {
            addCriterion("amountOwed is null");
            return (Criteria) this;
        }

        public Criteria andAmountowedIsNotNull() {
            addCriterion("amountOwed is not null");
            return (Criteria) this;
        }

        public Criteria andAmountowedEqualTo(Integer value) {
            addCriterion("amountOwed =", value, "amountowed");
            return (Criteria) this;
        }

        public Criteria andAmountowedNotEqualTo(Integer value) {
            addCriterion("amountOwed <>", value, "amountowed");
            return (Criteria) this;
        }

        public Criteria andAmountowedGreaterThan(Integer value) {
            addCriterion("amountOwed >", value, "amountowed");
            return (Criteria) this;
        }

        public Criteria andAmountowedGreaterThanOrEqualTo(Integer value) {
            addCriterion("amountOwed >=", value, "amountowed");
            return (Criteria) this;
        }

        public Criteria andAmountowedLessThan(Integer value) {
            addCriterion("amountOwed <", value, "amountowed");
            return (Criteria) this;
        }

        public Criteria andAmountowedLessThanOrEqualTo(Integer value) {
            addCriterion("amountOwed <=", value, "amountowed");
            return (Criteria) this;
        }

        public Criteria andAmountowedIn(List<Integer> values) {
            addCriterion("amountOwed in", values, "amountowed");
            return (Criteria) this;
        }

        public Criteria andAmountowedNotIn(List<Integer> values) {
            addCriterion("amountOwed not in", values, "amountowed");
            return (Criteria) this;
        }

        public Criteria andAmountowedBetween(Integer value1, Integer value2) {
            addCriterion("amountOwed between", value1, value2, "amountowed");
            return (Criteria) this;
        }

        public Criteria andAmountowedNotBetween(Integer value1, Integer value2) {
            addCriterion("amountOwed not between", value1, value2, "amountowed");
            return (Criteria) this;
        }

        public Criteria andCashIsNull() {
            addCriterion("cash is null");
            return (Criteria) this;
        }

        public Criteria andCashIsNotNull() {
            addCriterion("cash is not null");
            return (Criteria) this;
        }

        public Criteria andCashEqualTo(Integer value) {
            addCriterion("cash =", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotEqualTo(Integer value) {
            addCriterion("cash <>", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashGreaterThan(Integer value) {
            addCriterion("cash >", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashGreaterThanOrEqualTo(Integer value) {
            addCriterion("cash >=", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashLessThan(Integer value) {
            addCriterion("cash <", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashLessThanOrEqualTo(Integer value) {
            addCriterion("cash <=", value, "cash");
            return (Criteria) this;
        }

        public Criteria andCashIn(List<Integer> values) {
            addCriterion("cash in", values, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotIn(List<Integer> values) {
            addCriterion("cash not in", values, "cash");
            return (Criteria) this;
        }

        public Criteria andCashBetween(Integer value1, Integer value2) {
            addCriterion("cash between", value1, value2, "cash");
            return (Criteria) this;
        }

        public Criteria andCashNotBetween(Integer value1, Integer value2) {
            addCriterion("cash not between", value1, value2, "cash");
            return (Criteria) this;
        }

        public Criteria andBanktransferIsNull() {
            addCriterion("bankTransfer is null");
            return (Criteria) this;
        }

        public Criteria andBanktransferIsNotNull() {
            addCriterion("bankTransfer is not null");
            return (Criteria) this;
        }

        public Criteria andBanktransferEqualTo(Integer value) {
            addCriterion("bankTransfer =", value, "banktransfer");
            return (Criteria) this;
        }

        public Criteria andBanktransferNotEqualTo(Integer value) {
            addCriterion("bankTransfer <>", value, "banktransfer");
            return (Criteria) this;
        }

        public Criteria andBanktransferGreaterThan(Integer value) {
            addCriterion("bankTransfer >", value, "banktransfer");
            return (Criteria) this;
        }

        public Criteria andBanktransferGreaterThanOrEqualTo(Integer value) {
            addCriterion("bankTransfer >=", value, "banktransfer");
            return (Criteria) this;
        }

        public Criteria andBanktransferLessThan(Integer value) {
            addCriterion("bankTransfer <", value, "banktransfer");
            return (Criteria) this;
        }

        public Criteria andBanktransferLessThanOrEqualTo(Integer value) {
            addCriterion("bankTransfer <=", value, "banktransfer");
            return (Criteria) this;
        }

        public Criteria andBanktransferIn(List<Integer> values) {
            addCriterion("bankTransfer in", values, "banktransfer");
            return (Criteria) this;
        }

        public Criteria andBanktransferNotIn(List<Integer> values) {
            addCriterion("bankTransfer not in", values, "banktransfer");
            return (Criteria) this;
        }

        public Criteria andBanktransferBetween(Integer value1, Integer value2) {
            addCriterion("bankTransfer between", value1, value2, "banktransfer");
            return (Criteria) this;
        }

        public Criteria andBanktransferNotBetween(Integer value1, Integer value2) {
            addCriterion("bankTransfer not between", value1, value2, "banktransfer");
            return (Criteria) this;
        }

        public Criteria andCreditcardIsNull() {
            addCriterion("creditCard is null");
            return (Criteria) this;
        }

        public Criteria andCreditcardIsNotNull() {
            addCriterion("creditCard is not null");
            return (Criteria) this;
        }

        public Criteria andCreditcardEqualTo(Integer value) {
            addCriterion("creditCard =", value, "creditcard");
            return (Criteria) this;
        }

        public Criteria andCreditcardNotEqualTo(Integer value) {
            addCriterion("creditCard <>", value, "creditcard");
            return (Criteria) this;
        }

        public Criteria andCreditcardGreaterThan(Integer value) {
            addCriterion("creditCard >", value, "creditcard");
            return (Criteria) this;
        }

        public Criteria andCreditcardGreaterThanOrEqualTo(Integer value) {
            addCriterion("creditCard >=", value, "creditcard");
            return (Criteria) this;
        }

        public Criteria andCreditcardLessThan(Integer value) {
            addCriterion("creditCard <", value, "creditcard");
            return (Criteria) this;
        }

        public Criteria andCreditcardLessThanOrEqualTo(Integer value) {
            addCriterion("creditCard <=", value, "creditcard");
            return (Criteria) this;
        }

        public Criteria andCreditcardIn(List<Integer> values) {
            addCriterion("creditCard in", values, "creditcard");
            return (Criteria) this;
        }

        public Criteria andCreditcardNotIn(List<Integer> values) {
            addCriterion("creditCard not in", values, "creditcard");
            return (Criteria) this;
        }

        public Criteria andCreditcardBetween(Integer value1, Integer value2) {
            addCriterion("creditCard between", value1, value2, "creditcard");
            return (Criteria) this;
        }

        public Criteria andCreditcardNotBetween(Integer value1, Integer value2) {
            addCriterion("creditCard not between", value1, value2, "creditcard");
            return (Criteria) this;
        }

        public Criteria andWatransferIsNull() {
            addCriterion("WATransfer is null");
            return (Criteria) this;
        }

        public Criteria andWatransferIsNotNull() {
            addCriterion("WATransfer is not null");
            return (Criteria) this;
        }

        public Criteria andWatransferEqualTo(Integer value) {
            addCriterion("WATransfer =", value, "watransfer");
            return (Criteria) this;
        }

        public Criteria andWatransferNotEqualTo(Integer value) {
            addCriterion("WATransfer <>", value, "watransfer");
            return (Criteria) this;
        }

        public Criteria andWatransferGreaterThan(Integer value) {
            addCriterion("WATransfer >", value, "watransfer");
            return (Criteria) this;
        }

        public Criteria andWatransferGreaterThanOrEqualTo(Integer value) {
            addCriterion("WATransfer >=", value, "watransfer");
            return (Criteria) this;
        }

        public Criteria andWatransferLessThan(Integer value) {
            addCriterion("WATransfer <", value, "watransfer");
            return (Criteria) this;
        }

        public Criteria andWatransferLessThanOrEqualTo(Integer value) {
            addCriterion("WATransfer <=", value, "watransfer");
            return (Criteria) this;
        }

        public Criteria andWatransferIn(List<Integer> values) {
            addCriterion("WATransfer in", values, "watransfer");
            return (Criteria) this;
        }

        public Criteria andWatransferNotIn(List<Integer> values) {
            addCriterion("WATransfer not in", values, "watransfer");
            return (Criteria) this;
        }

        public Criteria andWatransferBetween(Integer value1, Integer value2) {
            addCriterion("WATransfer between", value1, value2, "watransfer");
            return (Criteria) this;
        }

        public Criteria andWatransferNotBetween(Integer value1, Integer value2) {
            addCriterion("WATransfer not between", value1, value2, "watransfer");
            return (Criteria) this;
        }

        public Criteria andWhethermoneytransferIsNull() {
            addCriterion("whetherMoneyTransfer is null");
            return (Criteria) this;
        }

        public Criteria andWhethermoneytransferIsNotNull() {
            addCriterion("whetherMoneyTransfer is not null");
            return (Criteria) this;
        }

        public Criteria andWhethermoneytransferEqualTo(Integer value) {
            addCriterion("whetherMoneyTransfer =", value, "whethermoneytransfer");
            return (Criteria) this;
        }

        public Criteria andWhethermoneytransferNotEqualTo(Integer value) {
            addCriterion("whetherMoneyTransfer <>", value, "whethermoneytransfer");
            return (Criteria) this;
        }

        public Criteria andWhethermoneytransferGreaterThan(Integer value) {
            addCriterion("whetherMoneyTransfer >", value, "whethermoneytransfer");
            return (Criteria) this;
        }

        public Criteria andWhethermoneytransferGreaterThanOrEqualTo(Integer value) {
            addCriterion("whetherMoneyTransfer >=", value, "whethermoneytransfer");
            return (Criteria) this;
        }

        public Criteria andWhethermoneytransferLessThan(Integer value) {
            addCriterion("whetherMoneyTransfer <", value, "whethermoneytransfer");
            return (Criteria) this;
        }

        public Criteria andWhethermoneytransferLessThanOrEqualTo(Integer value) {
            addCriterion("whetherMoneyTransfer <=", value, "whethermoneytransfer");
            return (Criteria) this;
        }

        public Criteria andWhethermoneytransferIn(List<Integer> values) {
            addCriterion("whetherMoneyTransfer in", values, "whethermoneytransfer");
            return (Criteria) this;
        }

        public Criteria andWhethermoneytransferNotIn(List<Integer> values) {
            addCriterion("whetherMoneyTransfer not in", values, "whethermoneytransfer");
            return (Criteria) this;
        }

        public Criteria andWhethermoneytransferBetween(Integer value1, Integer value2) {
            addCriterion("whetherMoneyTransfer between", value1, value2, "whethermoneytransfer");
            return (Criteria) this;
        }

        public Criteria andWhethermoneytransferNotBetween(Integer value1, Integer value2) {
            addCriterion("whetherMoneyTransfer not between", value1, value2, "whethermoneytransfer");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}