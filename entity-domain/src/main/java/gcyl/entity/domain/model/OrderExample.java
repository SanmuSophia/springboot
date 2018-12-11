package gcyl.entity.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andTableNumEqualTo(String value) {
            addCriterion("table_num =", value, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumNotEqualTo(String value) {
            addCriterion("table_num <>", value, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumGreaterThan(String value) {
            addCriterion("table_num >", value, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumGreaterThanOrEqualTo(String value) {
            addCriterion("table_num >=", value, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumLessThan(String value) {
            addCriterion("table_num <", value, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumLessThanOrEqualTo(String value) {
            addCriterion("table_num <=", value, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumLike(String value) {
            addCriterion("table_num like", value, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumNotLike(String value) {
            addCriterion("table_num not like", value, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumIn(List<String> values) {
            addCriterion("table_num in", values, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumNotIn(List<String> values) {
            addCriterion("table_num not in", values, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumBetween(String value1, String value2) {
            addCriterion("table_num between", value1, value2, "tableNum");
            return (Criteria) this;
        }

        public Criteria andTableNumNotBetween(String value1, String value2) {
            addCriterion("table_num not between", value1, value2, "tableNum");
            return (Criteria) this;
        }

        public Criteria andConsumeSumIsNull() {
            addCriterion("consume_sum is null");
            return (Criteria) this;
        }

        public Criteria andConsumeSumIsNotNull() {
            addCriterion("consume_sum is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeSumEqualTo(BigDecimal value) {
            addCriterion("consume_sum =", value, "consumeSum");
            return (Criteria) this;
        }

        public Criteria andConsumeSumNotEqualTo(BigDecimal value) {
            addCriterion("consume_sum <>", value, "consumeSum");
            return (Criteria) this;
        }

        public Criteria andConsumeSumGreaterThan(BigDecimal value) {
            addCriterion("consume_sum >", value, "consumeSum");
            return (Criteria) this;
        }

        public Criteria andConsumeSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("consume_sum >=", value, "consumeSum");
            return (Criteria) this;
        }

        public Criteria andConsumeSumLessThan(BigDecimal value) {
            addCriterion("consume_sum <", value, "consumeSum");
            return (Criteria) this;
        }

        public Criteria andConsumeSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("consume_sum <=", value, "consumeSum");
            return (Criteria) this;
        }

        public Criteria andConsumeSumIn(List<BigDecimal> values) {
            addCriterion("consume_sum in", values, "consumeSum");
            return (Criteria) this;
        }

        public Criteria andConsumeSumNotIn(List<BigDecimal> values) {
            addCriterion("consume_sum not in", values, "consumeSum");
            return (Criteria) this;
        }

        public Criteria andConsumeSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume_sum between", value1, value2, "consumeSum");
            return (Criteria) this;
        }

        public Criteria andConsumeSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume_sum not between", value1, value2, "consumeSum");
            return (Criteria) this;
        }

        public Criteria andSettleSumIsNull() {
            addCriterion("settle_sum is null");
            return (Criteria) this;
        }

        public Criteria andSettleSumIsNotNull() {
            addCriterion("settle_sum is not null");
            return (Criteria) this;
        }

        public Criteria andSettleSumEqualTo(BigDecimal value) {
            addCriterion("settle_sum =", value, "settleSum");
            return (Criteria) this;
        }

        public Criteria andSettleSumNotEqualTo(BigDecimal value) {
            addCriterion("settle_sum <>", value, "settleSum");
            return (Criteria) this;
        }

        public Criteria andSettleSumGreaterThan(BigDecimal value) {
            addCriterion("settle_sum >", value, "settleSum");
            return (Criteria) this;
        }

        public Criteria andSettleSumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_sum >=", value, "settleSum");
            return (Criteria) this;
        }

        public Criteria andSettleSumLessThan(BigDecimal value) {
            addCriterion("settle_sum <", value, "settleSum");
            return (Criteria) this;
        }

        public Criteria andSettleSumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_sum <=", value, "settleSum");
            return (Criteria) this;
        }

        public Criteria andSettleSumIn(List<BigDecimal> values) {
            addCriterion("settle_sum in", values, "settleSum");
            return (Criteria) this;
        }

        public Criteria andSettleSumNotIn(List<BigDecimal> values) {
            addCriterion("settle_sum not in", values, "settleSum");
            return (Criteria) this;
        }

        public Criteria andSettleSumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_sum between", value1, value2, "settleSum");
            return (Criteria) this;
        }

        public Criteria andSettleSumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_sum not between", value1, value2, "settleSum");
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

        public Criteria andGoodsNumIsNull() {
            addCriterion("goods_num is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIsNotNull() {
            addCriterion("goods_num is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumEqualTo(Integer value) {
            addCriterion("goods_num =", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotEqualTo(Integer value) {
            addCriterion("goods_num <>", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumGreaterThan(Integer value) {
            addCriterion("goods_num >", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_num >=", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumLessThan(Integer value) {
            addCriterion("goods_num <", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            addCriterion("goods_num <=", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIn(List<Integer> values) {
            addCriterion("goods_num in", values, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotIn(List<Integer> values) {
            addCriterion("goods_num not in", values, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            addCriterion("goods_num between", value1, value2, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_num not between", value1, value2, "goodsNum");
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

        public Criteria andPayMethodEqualTo(String value) {
            addCriterion("pay_method =", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotEqualTo(String value) {
            addCriterion("pay_method <>", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThan(String value) {
            addCriterion("pay_method >", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThanOrEqualTo(String value) {
            addCriterion("pay_method >=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThan(String value) {
            addCriterion("pay_method <", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThanOrEqualTo(String value) {
            addCriterion("pay_method <=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLike(String value) {
            addCriterion("pay_method like", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotLike(String value) {
            addCriterion("pay_method not like", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodIn(List<String> values) {
            addCriterion("pay_method in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotIn(List<String> values) {
            addCriterion("pay_method not in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodBetween(String value1, String value2) {
            addCriterion("pay_method between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotBetween(String value1, String value2) {
            addCriterion("pay_method not between", value1, value2, "payMethod");
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

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
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

        public Criteria andGmtModifyEqualTo(Date value) {
            addCriterion("gmt_modify =", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotEqualTo(Date value) {
            addCriterion("gmt_modify <>", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThan(Date value) {
            addCriterion("gmt_modify >", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modify >=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThan(Date value) {
            addCriterion("gmt_modify <", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modify <=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIn(List<Date> values) {
            addCriterion("gmt_modify in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotIn(List<Date> values) {
            addCriterion("gmt_modify not in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyBetween(Date value1, Date value2) {
            addCriterion("gmt_modify between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotBetween(Date value1, Date value2) {
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

        public Criteria andGmtReceiveEqualTo(Date value) {
            addCriterion("gmt_receive =", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveNotEqualTo(Date value) {
            addCriterion("gmt_receive <>", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveGreaterThan(Date value) {
            addCriterion("gmt_receive >", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_receive >=", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveLessThan(Date value) {
            addCriterion("gmt_receive <", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveLessThanOrEqualTo(Date value) {
            addCriterion("gmt_receive <=", value, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveIn(List<Date> values) {
            addCriterion("gmt_receive in", values, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveNotIn(List<Date> values) {
            addCriterion("gmt_receive not in", values, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveBetween(Date value1, Date value2) {
            addCriterion("gmt_receive between", value1, value2, "gmtReceive");
            return (Criteria) this;
        }

        public Criteria andGmtReceiveNotBetween(Date value1, Date value2) {
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

        public Criteria andGmtPayEqualTo(Date value) {
            addCriterion("gmt_pay =", value, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayNotEqualTo(Date value) {
            addCriterion("gmt_pay <>", value, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayGreaterThan(Date value) {
            addCriterion("gmt_pay >", value, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_pay >=", value, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayLessThan(Date value) {
            addCriterion("gmt_pay <", value, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayLessThanOrEqualTo(Date value) {
            addCriterion("gmt_pay <=", value, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayIn(List<Date> values) {
            addCriterion("gmt_pay in", values, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayNotIn(List<Date> values) {
            addCriterion("gmt_pay not in", values, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayBetween(Date value1, Date value2) {
            addCriterion("gmt_pay between", value1, value2, "gmtPay");
            return (Criteria) this;
        }

        public Criteria andGmtPayNotBetween(Date value1, Date value2) {
            addCriterion("gmt_pay not between", value1, value2, "gmtPay");
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

        public Criteria andGmtFinishEqualTo(Date value) {
            addCriterion("gmt_finish =", value, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishNotEqualTo(Date value) {
            addCriterion("gmt_finish <>", value, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishGreaterThan(Date value) {
            addCriterion("gmt_finish >", value, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_finish >=", value, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishLessThan(Date value) {
            addCriterion("gmt_finish <", value, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishLessThanOrEqualTo(Date value) {
            addCriterion("gmt_finish <=", value, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishIn(List<Date> values) {
            addCriterion("gmt_finish in", values, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishNotIn(List<Date> values) {
            addCriterion("gmt_finish not in", values, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishBetween(Date value1, Date value2) {
            addCriterion("gmt_finish between", value1, value2, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andGmtFinishNotBetween(Date value1, Date value2) {
            addCriterion("gmt_finish not between", value1, value2, "gmtFinish");
            return (Criteria) this;
        }

        public Criteria andCutOffIsNull() {
            addCriterion("cut_off is null");
            return (Criteria) this;
        }

        public Criteria andCutOffIsNotNull() {
            addCriterion("cut_off is not null");
            return (Criteria) this;
        }

        public Criteria andCutOffEqualTo(Byte value) {
            addCriterion("cut_off =", value, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffNotEqualTo(Byte value) {
            addCriterion("cut_off <>", value, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffGreaterThan(Byte value) {
            addCriterion("cut_off >", value, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffGreaterThanOrEqualTo(Byte value) {
            addCriterion("cut_off >=", value, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffLessThan(Byte value) {
            addCriterion("cut_off <", value, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffLessThanOrEqualTo(Byte value) {
            addCriterion("cut_off <=", value, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffIn(List<Byte> values) {
            addCriterion("cut_off in", values, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffNotIn(List<Byte> values) {
            addCriterion("cut_off not in", values, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffBetween(Byte value1, Byte value2) {
            addCriterion("cut_off between", value1, value2, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffNotBetween(Byte value1, Byte value2) {
            addCriterion("cut_off not between", value1, value2, "cutOff");
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