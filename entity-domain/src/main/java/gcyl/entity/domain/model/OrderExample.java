package gcyl.entity.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNull() {
            addCriterion("order_sn is null");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNotNull() {
            addCriterion("order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSnEqualTo(String value) {
            addCriterion("order_sn =", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotEqualTo(String value) {
            addCriterion("order_sn <>", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThan(String value) {
            addCriterion("order_sn >", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("order_sn >=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThan(String value) {
            addCriterion("order_sn <", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThanOrEqualTo(String value) {
            addCriterion("order_sn <=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLike(String value) {
            addCriterion("order_sn like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotLike(String value) {
            addCriterion("order_sn not like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnIn(List<String> values) {
            addCriterion("order_sn in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotIn(List<String> values) {
            addCriterion("order_sn not in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnBetween(String value1, String value2) {
            addCriterion("order_sn between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotBetween(String value1, String value2) {
            addCriterion("order_sn not between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(Integer value) {
            addCriterion("order_state =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(Integer value) {
            addCriterion("order_state <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(Integer value) {
            addCriterion("order_state >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_state >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(Integer value) {
            addCriterion("order_state <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(Integer value) {
            addCriterion("order_state <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<Integer> values) {
            addCriterion("order_state in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<Integer> values) {
            addCriterion("order_state not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(Integer value1, Integer value2) {
            addCriterion("order_state between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(Integer value1, Integer value2) {
            addCriterion("order_state not between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNull() {
            addCriterion("is_pay is null");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNotNull() {
            addCriterion("is_pay is not null");
            return (Criteria) this;
        }

        public Criteria andIsPayEqualTo(Boolean value) {
            addCriterion("is_pay =", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotEqualTo(Boolean value) {
            addCriterion("is_pay <>", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThan(Boolean value) {
            addCriterion("is_pay >", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_pay >=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThan(Boolean value) {
            addCriterion("is_pay <", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThanOrEqualTo(Boolean value) {
            addCriterion("is_pay <=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayIn(List<Boolean> values) {
            addCriterion("is_pay in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotIn(List<Boolean> values) {
            addCriterion("is_pay not in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayBetween(Boolean value1, Boolean value2) {
            addCriterion("is_pay between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_pay not between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNull() {
            addCriterion("pay_method is null");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNotNull() {
            addCriterion("pay_method is not null");
            return (Criteria) this;
        }

        public Criteria andPayMethodEqualTo(Integer value) {
            addCriterion("pay_method =", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotEqualTo(Integer value) {
            addCriterion("pay_method <>", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThan(Integer value) {
            addCriterion("pay_method >", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_method >=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThan(Integer value) {
            addCriterion("pay_method <", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThanOrEqualTo(Integer value) {
            addCriterion("pay_method <=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodIn(List<Integer> values) {
            addCriterion("pay_method in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotIn(List<Integer> values) {
            addCriterion("pay_method not in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodBetween(Integer value1, Integer value2) {
            addCriterion("pay_method between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_method not between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNull() {
            addCriterion("pay_way is null");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNotNull() {
            addCriterion("pay_way is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayEqualTo(Integer value) {
            addCriterion("pay_way =", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotEqualTo(Integer value) {
            addCriterion("pay_way <>", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThan(Integer value) {
            addCriterion("pay_way >", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_way >=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThan(Integer value) {
            addCriterion("pay_way <", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThanOrEqualTo(Integer value) {
            addCriterion("pay_way <=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayIn(List<Integer> values) {
            addCriterion("pay_way in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotIn(List<Integer> values) {
            addCriterion("pay_way not in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayBetween(Integer value1, Integer value2) {
            addCriterion("pay_way between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_way not between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Long value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Long> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTableNumIsNull() {
            addCriterion("table_num is null");
            return (Criteria) this;
        }

        public Criteria andTableNumIsNotNull() {
            addCriterion("table_num is not null");
            return (Criteria) this;
        }

        public Criteria andTableNumEqualTo(Integer value) {
            addCriterion("table_num =", value, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumNotEqualTo(Integer value) {
            addCriterion("table_num <>", value, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumGreaterThan(Integer value) {
            addCriterion("table_num >", value, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("table_num >=", value, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumLessThan(Integer value) {
            addCriterion("table_num <", value, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumLessThanOrEqualTo(Integer value) {
            addCriterion("table_num <=", value, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumIn(List<Integer> values) {
            addCriterion("table_num in", values, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumNotIn(List<Integer> values) {
            addCriterion("table_num not in", values, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumBetween(Integer value1, Integer value2) {
            addCriterion("table_num between", value1, value2, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumNotBetween(Integer value1, Integer value2) {
            addCriterion("table_num not between", value1, value2, "tableNum");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountIsNull() {
            addCriterion("consume_amount is null");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountIsNotNull() {
            addCriterion("consume_amount is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountEqualTo(BigDecimal value) {
            addCriterion("consume_amount =", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountNotEqualTo(BigDecimal value) {
            addCriterion("consume_amount <>", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountGreaterThan(BigDecimal value) {
            addCriterion("consume_amount >", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("consume_amount >=", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountLessThan(BigDecimal value) {
            addCriterion("consume_amount <", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("consume_amount <=", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountIn(List<BigDecimal> values) {
            addCriterion("consume_amount in", values, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountNotIn(List<BigDecimal> values) {
            addCriterion("consume_amount not in", values, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume_amount between", value1, value2, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume_amount not between", value1, value2, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountIsNull() {
            addCriterion("settle_amount is null");
            return (Criteria) this;
        }

        public Criteria andSettleAmountIsNotNull() {
            addCriterion("settle_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSettleAmountEqualTo(BigDecimal value) {
            addCriterion("settle_amount =", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotEqualTo(BigDecimal value) {
            addCriterion("settle_amount <>", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountGreaterThan(BigDecimal value) {
            addCriterion("settle_amount >", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_amount >=", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountLessThan(BigDecimal value) {
            addCriterion("settle_amount <", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_amount <=", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountIn(List<BigDecimal> values) {
            addCriterion("settle_amount in", values, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotIn(List<BigDecimal> values) {
            addCriterion("settle_amount not in", values, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_amount between", value1, value2, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_amount not between", value1, value2, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountIsNull() {
            addCriterion("deduct_amount is null");
            return (Criteria) this;
        }

        public Criteria andDeductAmountIsNotNull() {
            addCriterion("deduct_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDeductAmountEqualTo(BigDecimal value) {
            addCriterion("deduct_amount =", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountNotEqualTo(BigDecimal value) {
            addCriterion("deduct_amount <>", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountGreaterThan(BigDecimal value) {
            addCriterion("deduct_amount >", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deduct_amount >=", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountLessThan(BigDecimal value) {
            addCriterion("deduct_amount <", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deduct_amount <=", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountIn(List<BigDecimal> values) {
            addCriterion("deduct_amount in", values, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountNotIn(List<BigDecimal> values) {
            addCriterion("deduct_amount not in", values, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduct_amount between", value1, value2, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduct_amount not between", value1, value2, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductMethodIsNull() {
            addCriterion("deduct_method is null");
            return (Criteria) this;
        }

        public Criteria andDeductMethodIsNotNull() {
            addCriterion("deduct_method is not null");
            return (Criteria) this;
        }

        public Criteria andDeductMethodEqualTo(Integer value) {
            addCriterion("deduct_method =", value, "deductMethod");
            return (Criteria) this;
        }

        public Criteria andDeductMethodNotEqualTo(Integer value) {
            addCriterion("deduct_method <>", value, "deductMethod");
            return (Criteria) this;
        }

        public Criteria andDeductMethodGreaterThan(Integer value) {
            addCriterion("deduct_method >", value, "deductMethod");
            return (Criteria) this;
        }

        public Criteria andDeductMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("deduct_method >=", value, "deductMethod");
            return (Criteria) this;
        }

        public Criteria andDeductMethodLessThan(Integer value) {
            addCriterion("deduct_method <", value, "deductMethod");
            return (Criteria) this;
        }

        public Criteria andDeductMethodLessThanOrEqualTo(Integer value) {
            addCriterion("deduct_method <=", value, "deductMethod");
            return (Criteria) this;
        }

        public Criteria andDeductMethodIn(List<Integer> values) {
            addCriterion("deduct_method in", values, "deductMethod");
            return (Criteria) this;
        }

        public Criteria andDeductMethodNotIn(List<Integer> values) {
            addCriterion("deduct_method not in", values, "deductMethod");
            return (Criteria) this;
        }

        public Criteria andDeductMethodBetween(Integer value1, Integer value2) {
            addCriterion("deduct_method between", value1, value2, "deductMethod");
            return (Criteria) this;
        }

        public Criteria andDeductMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("deduct_method not between", value1, value2, "deductMethod");
            return (Criteria) this;
        }

        public Criteria andConsumptionIsNull() {
            addCriterion("consumption is null");
            return (Criteria) this;
        }

        public Criteria andConsumptionIsNotNull() {
            addCriterion("consumption is not null");
            return (Criteria) this;
        }

        public Criteria andConsumptionEqualTo(BigDecimal value) {
            addCriterion("consumption =", value, "consumption");
            return (Criteria) this;
        }

        public Criteria andConsumptionNotEqualTo(BigDecimal value) {
            addCriterion("consumption <>", value, "consumption");
            return (Criteria) this;
        }

        public Criteria andConsumptionGreaterThan(BigDecimal value) {
            addCriterion("consumption >", value, "consumption");
            return (Criteria) this;
        }

        public Criteria andConsumptionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("consumption >=", value, "consumption");
            return (Criteria) this;
        }

        public Criteria andConsumptionLessThan(BigDecimal value) {
            addCriterion("consumption <", value, "consumption");
            return (Criteria) this;
        }

        public Criteria andConsumptionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("consumption <=", value, "consumption");
            return (Criteria) this;
        }

        public Criteria andConsumptionIn(List<BigDecimal> values) {
            addCriterion("consumption in", values, "consumption");
            return (Criteria) this;
        }

        public Criteria andConsumptionNotIn(List<BigDecimal> values) {
            addCriterion("consumption not in", values, "consumption");
            return (Criteria) this;
        }

        public Criteria andConsumptionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consumption between", value1, value2, "consumption");
            return (Criteria) this;
        }

        public Criteria andConsumptionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consumption not between", value1, value2, "consumption");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andPersonNumIsNull() {
            addCriterion("person_num is null");
            return (Criteria) this;
        }

        public Criteria andPersonNumIsNotNull() {
            addCriterion("person_num is not null");
            return (Criteria) this;
        }

        public Criteria andPersonNumEqualTo(Integer value) {
            addCriterion("person_num =", value, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumNotEqualTo(Integer value) {
            addCriterion("person_num <>", value, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumGreaterThan(Integer value) {
            addCriterion("person_num >", value, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_num >=", value, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumLessThan(Integer value) {
            addCriterion("person_num <", value, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumLessThanOrEqualTo(Integer value) {
            addCriterion("person_num <=", value, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumIn(List<Integer> values) {
            addCriterion("person_num in", values, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumNotIn(List<Integer> values) {
            addCriterion("person_num not in", values, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumBetween(Integer value1, Integer value2) {
            addCriterion("person_num between", value1, value2, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumNotBetween(Integer value1, Integer value2) {
            addCriterion("person_num not between", value1, value2, "personNum");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Long value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Long value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Long value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Long value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Long value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Long> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Long> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Long value1, Long value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Long value1, Long value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNull() {
            addCriterion("gmt_modify is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNotNull() {
            addCriterion("gmt_modify is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyEqualTo(Long value) {
            addCriterion("gmt_modify =", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotEqualTo(Long value) {
            addCriterion("gmt_modify <>", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThan(Long value) {
            addCriterion("gmt_modify >", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_modify >=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThan(Long value) {
            addCriterion("gmt_modify <", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Long value) {
            addCriterion("gmt_modify <=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIn(List<Long> values) {
            addCriterion("gmt_modify in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotIn(List<Long> values) {
            addCriterion("gmt_modify not in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyBetween(Long value1, Long value2) {
            addCriterion("gmt_modify between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotBetween(Long value1, Long value2) {
            addCriterion("gmt_modify not between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveIsNull() {
            addCriterion("gmt_receive is null");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveIsNotNull() {
            addCriterion("gmt_receive is not null");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveEqualTo(Long value) {
            addCriterion("gmt_receive =", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveNotEqualTo(Long value) {
            addCriterion("gmt_receive <>", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveGreaterThan(Long value) {
            addCriterion("gmt_receive >", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_receive >=", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveLessThan(Long value) {
            addCriterion("gmt_receive <", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveLessThanOrEqualTo(Long value) {
            addCriterion("gmt_receive <=", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveIn(List<Long> values) {
            addCriterion("gmt_receive in", values, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveNotIn(List<Long> values) {
            addCriterion("gmt_receive not in", values, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveBetween(Long value1, Long value2) {
            addCriterion("gmt_receive between", value1, value2, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveNotBetween(Long value1, Long value2) {
            addCriterion("gmt_receive not between", value1, value2, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtPayIsNull() {
            addCriterion("gmt_pay is null");
            return (Criteria) this;
        }

        public Criteria andGmtPayIsNotNull() {
            addCriterion("gmt_pay is not null");
            return (Criteria) this;
        }

        public Criteria andGmtPayEqualTo(Long value) {
            addCriterion("gmt_pay =", value, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayNotEqualTo(Long value) {
            addCriterion("gmt_pay <>", value, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayGreaterThan(Long value) {
            addCriterion("gmt_pay >", value, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_pay >=", value, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayLessThan(Long value) {
            addCriterion("gmt_pay <", value, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayLessThanOrEqualTo(Long value) {
            addCriterion("gmt_pay <=", value, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayIn(List<Long> values) {
            addCriterion("gmt_pay in", values, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayNotIn(List<Long> values) {
            addCriterion("gmt_pay not in", values, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayBetween(Long value1, Long value2) {
            addCriterion("gmt_pay between", value1, value2, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayNotBetween(Long value1, Long value2) {
            addCriterion("gmt_pay not between", value1, value2, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtServingFinishIsNull() {
            addCriterion("gmt_serving_finish is null");
            return (Criteria) this;
        }

        public Criteria andGmtServingFinishIsNotNull() {
            addCriterion("gmt_serving_finish is not null");
            return (Criteria) this;
        }

        public Criteria andGmtServingFinishEqualTo(Long value) {
            addCriterion("gmt_serving_finish =", value, "gmtServingFinish");
            return (Criteria) this;
        }

        public Criteria andGmtServingFinishNotEqualTo(Long value) {
            addCriterion("gmt_serving_finish <>", value, "gmtServingFinish");
            return (Criteria) this;
        }

        public Criteria andGmtServingFinishGreaterThan(Long value) {
            addCriterion("gmt_serving_finish >", value, "gmtServingFinish");
            return (Criteria) this;
        }

        public Criteria andGmtServingFinishGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_serving_finish >=", value, "gmtServingFinish");
            return (Criteria) this;
        }

        public Criteria andGmtServingFinishLessThan(Long value) {
            addCriterion("gmt_serving_finish <", value, "gmtServingFinish");
            return (Criteria) this;
        }

        public Criteria andGmtServingFinishLessThanOrEqualTo(Long value) {
            addCriterion("gmt_serving_finish <=", value, "gmtServingFinish");
            return (Criteria) this;
        }

        public Criteria andGmtServingFinishIn(List<Long> values) {
            addCriterion("gmt_serving_finish in", values, "gmtServingFinish");
            return (Criteria) this;
        }

        public Criteria andGmtServingFinishNotIn(List<Long> values) {
            addCriterion("gmt_serving_finish not in", values, "gmtServingFinish");
            return (Criteria) this;
        }

        public Criteria andGmtServingFinishBetween(Long value1, Long value2) {
            addCriterion("gmt_serving_finish between", value1, value2, "gmtServingFinish");
            return (Criteria) this;
        }

        public Criteria andGmtServingFinishNotBetween(Long value1, Long value2) {
            addCriterion("gmt_serving_finish not between", value1, value2, "gmtServingFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishIsNull() {
            addCriterion("gmt_finish is null");
            return (Criteria) this;
        }

        public Criteria andGmtFinishIsNotNull() {
            addCriterion("gmt_finish is not null");
            return (Criteria) this;
        }

        public Criteria andGmtFinishEqualTo(Long value) {
            addCriterion("gmt_finish =", value, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishNotEqualTo(Long value) {
            addCriterion("gmt_finish <>", value, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishGreaterThan(Long value) {
            addCriterion("gmt_finish >", value, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_finish >=", value, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishLessThan(Long value) {
            addCriterion("gmt_finish <", value, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishLessThanOrEqualTo(Long value) {
            addCriterion("gmt_finish <=", value, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishIn(List<Long> values) {
            addCriterion("gmt_finish in", values, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishNotIn(List<Long> values) {
            addCriterion("gmt_finish not in", values, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishBetween(Long value1, Long value2) {
            addCriterion("gmt_finish between", value1, value2, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishNotBetween(Long value1, Long value2) {
            addCriterion("gmt_finish not between", value1, value2, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andShopCutOffIsNull() {
            addCriterion("shop_cut_off is null");
            return (Criteria) this;
        }

        public Criteria andShopCutOffIsNotNull() {
            addCriterion("shop_cut_off is not null");
            return (Criteria) this;
        }

        public Criteria andShopCutOffEqualTo(Boolean value) {
            addCriterion("shop_cut_off =", value, "shopCutOff");
            return (Criteria) this;
        }

        public Criteria andShopCutOffNotEqualTo(Boolean value) {
            addCriterion("shop_cut_off <>", value, "shopCutOff");
            return (Criteria) this;
        }

        public Criteria andShopCutOffGreaterThan(Boolean value) {
            addCriterion("shop_cut_off >", value, "shopCutOff");
            return (Criteria) this;
        }

        public Criteria andShopCutOffGreaterThanOrEqualTo(Boolean value) {
            addCriterion("shop_cut_off >=", value, "shopCutOff");
            return (Criteria) this;
        }

        public Criteria andShopCutOffLessThan(Boolean value) {
            addCriterion("shop_cut_off <", value, "shopCutOff");
            return (Criteria) this;
        }

        public Criteria andShopCutOffLessThanOrEqualTo(Boolean value) {
            addCriterion("shop_cut_off <=", value, "shopCutOff");
            return (Criteria) this;
        }

        public Criteria andShopCutOffIn(List<Boolean> values) {
            addCriterion("shop_cut_off in", values, "shopCutOff");
            return (Criteria) this;
        }

        public Criteria andShopCutOffNotIn(List<Boolean> values) {
            addCriterion("shop_cut_off not in", values, "shopCutOff");
            return (Criteria) this;
        }

        public Criteria andShopCutOffBetween(Boolean value1, Boolean value2) {
            addCriterion("shop_cut_off between", value1, value2, "shopCutOff");
            return (Criteria) this;
        }

        public Criteria andShopCutOffNotBetween(Boolean value1, Boolean value2) {
            addCriterion("shop_cut_off not between", value1, value2, "shopCutOff");
            return (Criteria) this;
        }

        public Criteria andUserCutOffIsNull() {
            addCriterion("user_cut_off is null");
            return (Criteria) this;
        }

        public Criteria andUserCutOffIsNotNull() {
            addCriterion("user_cut_off is not null");
            return (Criteria) this;
        }

        public Criteria andUserCutOffEqualTo(Boolean value) {
            addCriterion("user_cut_off =", value, "userCutOff");
            return (Criteria) this;
        }

        public Criteria andUserCutOffNotEqualTo(Boolean value) {
            addCriterion("user_cut_off <>", value, "userCutOff");
            return (Criteria) this;
        }

        public Criteria andUserCutOffGreaterThan(Boolean value) {
            addCriterion("user_cut_off >", value, "userCutOff");
            return (Criteria) this;
        }

        public Criteria andUserCutOffGreaterThanOrEqualTo(Boolean value) {
            addCriterion("user_cut_off >=", value, "userCutOff");
            return (Criteria) this;
        }

        public Criteria andUserCutOffLessThan(Boolean value) {
            addCriterion("user_cut_off <", value, "userCutOff");
            return (Criteria) this;
        }

        public Criteria andUserCutOffLessThanOrEqualTo(Boolean value) {
            addCriterion("user_cut_off <=", value, "userCutOff");
            return (Criteria) this;
        }

        public Criteria andUserCutOffIn(List<Boolean> values) {
            addCriterion("user_cut_off in", values, "userCutOff");
            return (Criteria) this;
        }

        public Criteria andUserCutOffNotIn(List<Boolean> values) {
            addCriterion("user_cut_off not in", values, "userCutOff");
            return (Criteria) this;
        }

        public Criteria andUserCutOffBetween(Boolean value1, Boolean value2) {
            addCriterion("user_cut_off between", value1, value2, "userCutOff");
            return (Criteria) this;
        }

        public Criteria andUserCutOffNotBetween(Boolean value1, Boolean value2) {
            addCriterion("user_cut_off not between", value1, value2, "userCutOff");
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