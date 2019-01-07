package gcyl.entity.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsSpecExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsSpecExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andSpecKeyIsNull() {
            addCriterion("spec_key is null");
            return (Criteria) this;
        }

        public Criteria andSpecKeyIsNotNull() {
            addCriterion("spec_key is not null");
            return (Criteria) this;
        }

        public Criteria andSpecKeyEqualTo(String value) {
            addCriterion("spec_key =", value, "specKey");
            return (Criteria) this;
        }

        public Criteria andSpecKeyNotEqualTo(String value) {
            addCriterion("spec_key <>", value, "specKey");
            return (Criteria) this;
        }

        public Criteria andSpecKeyGreaterThan(String value) {
            addCriterion("spec_key >", value, "specKey");
            return (Criteria) this;
        }

        public Criteria andSpecKeyGreaterThanOrEqualTo(String value) {
            addCriterion("spec_key >=", value, "specKey");
            return (Criteria) this;
        }

        public Criteria andSpecKeyLessThan(String value) {
            addCriterion("spec_key <", value, "specKey");
            return (Criteria) this;
        }

        public Criteria andSpecKeyLessThanOrEqualTo(String value) {
            addCriterion("spec_key <=", value, "specKey");
            return (Criteria) this;
        }

        public Criteria andSpecKeyLike(String value) {
            addCriterion("spec_key like", value, "specKey");
            return (Criteria) this;
        }

        public Criteria andSpecKeyNotLike(String value) {
            addCriterion("spec_key not like", value, "specKey");
            return (Criteria) this;
        }

        public Criteria andSpecKeyIn(List<String> values) {
            addCriterion("spec_key in", values, "specKey");
            return (Criteria) this;
        }

        public Criteria andSpecKeyNotIn(List<String> values) {
            addCriterion("spec_key not in", values, "specKey");
            return (Criteria) this;
        }

        public Criteria andSpecKeyBetween(String value1, String value2) {
            addCriterion("spec_key between", value1, value2, "specKey");
            return (Criteria) this;
        }

        public Criteria andSpecKeyNotBetween(String value1, String value2) {
            addCriterion("spec_key not between", value1, value2, "specKey");
            return (Criteria) this;
        }

        public Criteria andSpecNameIsNull() {
            addCriterion("spec_name is null");
            return (Criteria) this;
        }

        public Criteria andSpecNameIsNotNull() {
            addCriterion("spec_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpecNameEqualTo(String value) {
            addCriterion("spec_name =", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotEqualTo(String value) {
            addCriterion("spec_name <>", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameGreaterThan(String value) {
            addCriterion("spec_name >", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameGreaterThanOrEqualTo(String value) {
            addCriterion("spec_name >=", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameLessThan(String value) {
            addCriterion("spec_name <", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameLessThanOrEqualTo(String value) {
            addCriterion("spec_name <=", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameLike(String value) {
            addCriterion("spec_name like", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotLike(String value) {
            addCriterion("spec_name not like", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameIn(List<String> values) {
            addCriterion("spec_name in", values, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotIn(List<String> values) {
            addCriterion("spec_name not in", values, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameBetween(String value1, String value2) {
            addCriterion("spec_name between", value1, value2, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotBetween(String value1, String value2) {
            addCriterion("spec_name not between", value1, value2, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecPriceIsNull() {
            addCriterion("spec_price is null");
            return (Criteria) this;
        }

        public Criteria andSpecPriceIsNotNull() {
            addCriterion("spec_price is not null");
            return (Criteria) this;
        }

        public Criteria andSpecPriceEqualTo(BigDecimal value) {
            addCriterion("spec_price =", value, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceNotEqualTo(BigDecimal value) {
            addCriterion("spec_price <>", value, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceGreaterThan(BigDecimal value) {
            addCriterion("spec_price >", value, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("spec_price >=", value, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceLessThan(BigDecimal value) {
            addCriterion("spec_price <", value, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("spec_price <=", value, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceIn(List<BigDecimal> values) {
            addCriterion("spec_price in", values, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceNotIn(List<BigDecimal> values) {
            addCriterion("spec_price not in", values, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("spec_price between", value1, value2, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("spec_price not between", value1, value2, "specPrice");
            return (Criteria) this;
        }

        public Criteria andSpecDayStockIsNull() {
            addCriterion("spec_day_stock is null");
            return (Criteria) this;
        }

        public Criteria andSpecDayStockIsNotNull() {
            addCriterion("spec_day_stock is not null");
            return (Criteria) this;
        }

        public Criteria andSpecDayStockEqualTo(Integer value) {
            addCriterion("spec_day_stock =", value, "specDayStock");
            return (Criteria) this;
        }

        public Criteria andSpecDayStockNotEqualTo(Integer value) {
            addCriterion("spec_day_stock <>", value, "specDayStock");
            return (Criteria) this;
        }

        public Criteria andSpecDayStockGreaterThan(Integer value) {
            addCriterion("spec_day_stock >", value, "specDayStock");
            return (Criteria) this;
        }

        public Criteria andSpecDayStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("spec_day_stock >=", value, "specDayStock");
            return (Criteria) this;
        }

        public Criteria andSpecDayStockLessThan(Integer value) {
            addCriterion("spec_day_stock <", value, "specDayStock");
            return (Criteria) this;
        }

        public Criteria andSpecDayStockLessThanOrEqualTo(Integer value) {
            addCriterion("spec_day_stock <=", value, "specDayStock");
            return (Criteria) this;
        }

        public Criteria andSpecDayStockIn(List<Integer> values) {
            addCriterion("spec_day_stock in", values, "specDayStock");
            return (Criteria) this;
        }

        public Criteria andSpecDayStockNotIn(List<Integer> values) {
            addCriterion("spec_day_stock not in", values, "specDayStock");
            return (Criteria) this;
        }

        public Criteria andSpecDayStockBetween(Integer value1, Integer value2) {
            addCriterion("spec_day_stock between", value1, value2, "specDayStock");
            return (Criteria) this;
        }

        public Criteria andSpecDayStockNotBetween(Integer value1, Integer value2) {
            addCriterion("spec_day_stock not between", value1, value2, "specDayStock");
            return (Criteria) this;
        }

        public Criteria andSpecStockIsNull() {
            addCriterion("spec_stock is null");
            return (Criteria) this;
        }

        public Criteria andSpecStockIsNotNull() {
            addCriterion("spec_stock is not null");
            return (Criteria) this;
        }

        public Criteria andSpecStockEqualTo(Integer value) {
            addCriterion("spec_stock =", value, "specStock");
            return (Criteria) this;
        }

        public Criteria andSpecStockNotEqualTo(Integer value) {
            addCriterion("spec_stock <>", value, "specStock");
            return (Criteria) this;
        }

        public Criteria andSpecStockGreaterThan(Integer value) {
            addCriterion("spec_stock >", value, "specStock");
            return (Criteria) this;
        }

        public Criteria andSpecStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("spec_stock >=", value, "specStock");
            return (Criteria) this;
        }

        public Criteria andSpecStockLessThan(Integer value) {
            addCriterion("spec_stock <", value, "specStock");
            return (Criteria) this;
        }

        public Criteria andSpecStockLessThanOrEqualTo(Integer value) {
            addCriterion("spec_stock <=", value, "specStock");
            return (Criteria) this;
        }

        public Criteria andSpecStockIn(List<Integer> values) {
            addCriterion("spec_stock in", values, "specStock");
            return (Criteria) this;
        }

        public Criteria andSpecStockNotIn(List<Integer> values) {
            addCriterion("spec_stock not in", values, "specStock");
            return (Criteria) this;
        }

        public Criteria andSpecStockBetween(Integer value1, Integer value2) {
            addCriterion("spec_stock between", value1, value2, "specStock");
            return (Criteria) this;
        }

        public Criteria andSpecStockNotBetween(Integer value1, Integer value2) {
            addCriterion("spec_stock not between", value1, value2, "specStock");
            return (Criteria) this;
        }

        public Criteria andSpecSalesCountIsNull() {
            addCriterion("spec_sales_count is null");
            return (Criteria) this;
        }

        public Criteria andSpecSalesCountIsNotNull() {
            addCriterion("spec_sales_count is not null");
            return (Criteria) this;
        }

        public Criteria andSpecSalesCountEqualTo(Integer value) {
            addCriterion("spec_sales_count =", value, "specSalesCount");
            return (Criteria) this;
        }

        public Criteria andSpecSalesCountNotEqualTo(Integer value) {
            addCriterion("spec_sales_count <>", value, "specSalesCount");
            return (Criteria) this;
        }

        public Criteria andSpecSalesCountGreaterThan(Integer value) {
            addCriterion("spec_sales_count >", value, "specSalesCount");
            return (Criteria) this;
        }

        public Criteria andSpecSalesCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("spec_sales_count >=", value, "specSalesCount");
            return (Criteria) this;
        }

        public Criteria andSpecSalesCountLessThan(Integer value) {
            addCriterion("spec_sales_count <", value, "specSalesCount");
            return (Criteria) this;
        }

        public Criteria andSpecSalesCountLessThanOrEqualTo(Integer value) {
            addCriterion("spec_sales_count <=", value, "specSalesCount");
            return (Criteria) this;
        }

        public Criteria andSpecSalesCountIn(List<Integer> values) {
            addCriterion("spec_sales_count in", values, "specSalesCount");
            return (Criteria) this;
        }

        public Criteria andSpecSalesCountNotIn(List<Integer> values) {
            addCriterion("spec_sales_count not in", values, "specSalesCount");
            return (Criteria) this;
        }

        public Criteria andSpecSalesCountBetween(Integer value1, Integer value2) {
            addCriterion("spec_sales_count between", value1, value2, "specSalesCount");
            return (Criteria) this;
        }

        public Criteria andSpecSalesCountNotBetween(Integer value1, Integer value2) {
            addCriterion("spec_sales_count not between", value1, value2, "specSalesCount");
            return (Criteria) this;
        }

        public Criteria andSpecMonthSalesIsNull() {
            addCriterion("spec_month_sales is null");
            return (Criteria) this;
        }

        public Criteria andSpecMonthSalesIsNotNull() {
            addCriterion("spec_month_sales is not null");
            return (Criteria) this;
        }

        public Criteria andSpecMonthSalesEqualTo(Integer value) {
            addCriterion("spec_month_sales =", value, "specMonthSales");
            return (Criteria) this;
        }

        public Criteria andSpecMonthSalesNotEqualTo(Integer value) {
            addCriterion("spec_month_sales <>", value, "specMonthSales");
            return (Criteria) this;
        }

        public Criteria andSpecMonthSalesGreaterThan(Integer value) {
            addCriterion("spec_month_sales >", value, "specMonthSales");
            return (Criteria) this;
        }

        public Criteria andSpecMonthSalesGreaterThanOrEqualTo(Integer value) {
            addCriterion("spec_month_sales >=", value, "specMonthSales");
            return (Criteria) this;
        }

        public Criteria andSpecMonthSalesLessThan(Integer value) {
            addCriterion("spec_month_sales <", value, "specMonthSales");
            return (Criteria) this;
        }

        public Criteria andSpecMonthSalesLessThanOrEqualTo(Integer value) {
            addCriterion("spec_month_sales <=", value, "specMonthSales");
            return (Criteria) this;
        }

        public Criteria andSpecMonthSalesIn(List<Integer> values) {
            addCriterion("spec_month_sales in", values, "specMonthSales");
            return (Criteria) this;
        }

        public Criteria andSpecMonthSalesNotIn(List<Integer> values) {
            addCriterion("spec_month_sales not in", values, "specMonthSales");
            return (Criteria) this;
        }

        public Criteria andSpecMonthSalesBetween(Integer value1, Integer value2) {
            addCriterion("spec_month_sales between", value1, value2, "specMonthSales");
            return (Criteria) this;
        }

        public Criteria andSpecMonthSalesNotBetween(Integer value1, Integer value2) {
            addCriterion("spec_month_sales not between", value1, value2, "specMonthSales");
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

        public Criteria andCutOffIsNull() {
            addCriterion("cut_off is null");
            return (Criteria) this;
        }

        public Criteria andCutOffIsNotNull() {
            addCriterion("cut_off is not null");
            return (Criteria) this;
        }

        public Criteria andCutOffEqualTo(Boolean value) {
            addCriterion("cut_off =", value, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffNotEqualTo(Boolean value) {
            addCriterion("cut_off <>", value, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffGreaterThan(Boolean value) {
            addCriterion("cut_off >", value, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffGreaterThanOrEqualTo(Boolean value) {
            addCriterion("cut_off >=", value, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffLessThan(Boolean value) {
            addCriterion("cut_off <", value, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffLessThanOrEqualTo(Boolean value) {
            addCriterion("cut_off <=", value, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffIn(List<Boolean> values) {
            addCriterion("cut_off in", values, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffNotIn(List<Boolean> values) {
            addCriterion("cut_off not in", values, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffBetween(Boolean value1, Boolean value2) {
            addCriterion("cut_off between", value1, value2, "cutOff");
            return (Criteria) this;
        }

        public Criteria andCutOffNotBetween(Boolean value1, Boolean value2) {
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