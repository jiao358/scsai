package scsai.cmb.datasource.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RequestInfoExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
	public RequestInfoExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
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
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(String value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(String value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(String value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(String value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLike(String value) {
			addCriterion("ID like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotLike(String value) {
			addCriterion("ID not like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<String> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<String> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(String value1, String value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(String value1, String value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIpIsNull() {
			addCriterion("IP is null");
			return (Criteria) this;
		}

		public Criteria andIpIsNotNull() {
			addCriterion("IP is not null");
			return (Criteria) this;
		}

		public Criteria andIpEqualTo(String value) {
			addCriterion("IP =", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotEqualTo(String value) {
			addCriterion("IP <>", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThan(String value) {
			addCriterion("IP >", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThanOrEqualTo(String value) {
			addCriterion("IP >=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThan(String value) {
			addCriterion("IP <", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThanOrEqualTo(String value) {
			addCriterion("IP <=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLike(String value) {
			addCriterion("IP like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotLike(String value) {
			addCriterion("IP not like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpIn(List<String> values) {
			addCriterion("IP in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotIn(List<String> values) {
			addCriterion("IP not in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpBetween(String value1, String value2) {
			addCriterion("IP between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotBetween(String value1, String value2) {
			addCriterion("IP not between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andContentLengthIsNull() {
			addCriterion("CONTENT_LENGTH is null");
			return (Criteria) this;
		}

		public Criteria andContentLengthIsNotNull() {
			addCriterion("CONTENT_LENGTH is not null");
			return (Criteria) this;
		}

		public Criteria andContentLengthEqualTo(Integer value) {
			addCriterion("CONTENT_LENGTH =", value, "contentLength");
			return (Criteria) this;
		}

		public Criteria andContentLengthNotEqualTo(Integer value) {
			addCriterion("CONTENT_LENGTH <>", value, "contentLength");
			return (Criteria) this;
		}

		public Criteria andContentLengthGreaterThan(Integer value) {
			addCriterion("CONTENT_LENGTH >", value, "contentLength");
			return (Criteria) this;
		}

		public Criteria andContentLengthGreaterThanOrEqualTo(Integer value) {
			addCriterion("CONTENT_LENGTH >=", value, "contentLength");
			return (Criteria) this;
		}

		public Criteria andContentLengthLessThan(Integer value) {
			addCriterion("CONTENT_LENGTH <", value, "contentLength");
			return (Criteria) this;
		}

		public Criteria andContentLengthLessThanOrEqualTo(Integer value) {
			addCriterion("CONTENT_LENGTH <=", value, "contentLength");
			return (Criteria) this;
		}

		public Criteria andContentLengthIn(List<Integer> values) {
			addCriterion("CONTENT_LENGTH in", values, "contentLength");
			return (Criteria) this;
		}

		public Criteria andContentLengthNotIn(List<Integer> values) {
			addCriterion("CONTENT_LENGTH not in", values, "contentLength");
			return (Criteria) this;
		}

		public Criteria andContentLengthBetween(Integer value1, Integer value2) {
			addCriterion("CONTENT_LENGTH between", value1, value2, "contentLength");
			return (Criteria) this;
		}

		public Criteria andContentLengthNotBetween(Integer value1, Integer value2) {
			addCriterion("CONTENT_LENGTH not between", value1, value2, "contentLength");
			return (Criteria) this;
		}

		public Criteria andContentTypeIsNull() {
			addCriterion("CONTENT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andContentTypeIsNotNull() {
			addCriterion("CONTENT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andContentTypeEqualTo(String value) {
			addCriterion("CONTENT_TYPE =", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeNotEqualTo(String value) {
			addCriterion("CONTENT_TYPE <>", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeGreaterThan(String value) {
			addCriterion("CONTENT_TYPE >", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeGreaterThanOrEqualTo(String value) {
			addCriterion("CONTENT_TYPE >=", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeLessThan(String value) {
			addCriterion("CONTENT_TYPE <", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeLessThanOrEqualTo(String value) {
			addCriterion("CONTENT_TYPE <=", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeLike(String value) {
			addCriterion("CONTENT_TYPE like", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeNotLike(String value) {
			addCriterion("CONTENT_TYPE not like", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeIn(List<String> values) {
			addCriterion("CONTENT_TYPE in", values, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeNotIn(List<String> values) {
			addCriterion("CONTENT_TYPE not in", values, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeBetween(String value1, String value2) {
			addCriterion("CONTENT_TYPE between", value1, value2, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeNotBetween(String value1, String value2) {
			addCriterion("CONTENT_TYPE not between", value1, value2, "contentType");
			return (Criteria) this;
		}

		public Criteria andLocalAddrIsNull() {
			addCriterion("LOCAL_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andLocalAddrIsNotNull() {
			addCriterion("LOCAL_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andLocalAddrEqualTo(String value) {
			addCriterion("LOCAL_ADDR =", value, "localAddr");
			return (Criteria) this;
		}

		public Criteria andLocalAddrNotEqualTo(String value) {
			addCriterion("LOCAL_ADDR <>", value, "localAddr");
			return (Criteria) this;
		}

		public Criteria andLocalAddrGreaterThan(String value) {
			addCriterion("LOCAL_ADDR >", value, "localAddr");
			return (Criteria) this;
		}

		public Criteria andLocalAddrGreaterThanOrEqualTo(String value) {
			addCriterion("LOCAL_ADDR >=", value, "localAddr");
			return (Criteria) this;
		}

		public Criteria andLocalAddrLessThan(String value) {
			addCriterion("LOCAL_ADDR <", value, "localAddr");
			return (Criteria) this;
		}

		public Criteria andLocalAddrLessThanOrEqualTo(String value) {
			addCriterion("LOCAL_ADDR <=", value, "localAddr");
			return (Criteria) this;
		}

		public Criteria andLocalAddrLike(String value) {
			addCriterion("LOCAL_ADDR like", value, "localAddr");
			return (Criteria) this;
		}

		public Criteria andLocalAddrNotLike(String value) {
			addCriterion("LOCAL_ADDR not like", value, "localAddr");
			return (Criteria) this;
		}

		public Criteria andLocalAddrIn(List<String> values) {
			addCriterion("LOCAL_ADDR in", values, "localAddr");
			return (Criteria) this;
		}

		public Criteria andLocalAddrNotIn(List<String> values) {
			addCriterion("LOCAL_ADDR not in", values, "localAddr");
			return (Criteria) this;
		}

		public Criteria andLocalAddrBetween(String value1, String value2) {
			addCriterion("LOCAL_ADDR between", value1, value2, "localAddr");
			return (Criteria) this;
		}

		public Criteria andLocalAddrNotBetween(String value1, String value2) {
			addCriterion("LOCAL_ADDR not between", value1, value2, "localAddr");
			return (Criteria) this;
		}

		public Criteria andRequestPathIsNull() {
			addCriterion("REQUEST_PATH is null");
			return (Criteria) this;
		}

		public Criteria andRequestPathIsNotNull() {
			addCriterion("REQUEST_PATH is not null");
			return (Criteria) this;
		}

		public Criteria andRequestPathEqualTo(String value) {
			addCriterion("REQUEST_PATH =", value, "requestPath");
			return (Criteria) this;
		}

		public Criteria andRequestPathNotEqualTo(String value) {
			addCriterion("REQUEST_PATH <>", value, "requestPath");
			return (Criteria) this;
		}

		public Criteria andRequestPathGreaterThan(String value) {
			addCriterion("REQUEST_PATH >", value, "requestPath");
			return (Criteria) this;
		}

		public Criteria andRequestPathGreaterThanOrEqualTo(String value) {
			addCriterion("REQUEST_PATH >=", value, "requestPath");
			return (Criteria) this;
		}

		public Criteria andRequestPathLessThan(String value) {
			addCriterion("REQUEST_PATH <", value, "requestPath");
			return (Criteria) this;
		}

		public Criteria andRequestPathLessThanOrEqualTo(String value) {
			addCriterion("REQUEST_PATH <=", value, "requestPath");
			return (Criteria) this;
		}

		public Criteria andRequestPathLike(String value) {
			addCriterion("REQUEST_PATH like", value, "requestPath");
			return (Criteria) this;
		}

		public Criteria andRequestPathNotLike(String value) {
			addCriterion("REQUEST_PATH not like", value, "requestPath");
			return (Criteria) this;
		}

		public Criteria andRequestPathIn(List<String> values) {
			addCriterion("REQUEST_PATH in", values, "requestPath");
			return (Criteria) this;
		}

		public Criteria andRequestPathNotIn(List<String> values) {
			addCriterion("REQUEST_PATH not in", values, "requestPath");
			return (Criteria) this;
		}

		public Criteria andRequestPathBetween(String value1, String value2) {
			addCriterion("REQUEST_PATH between", value1, value2, "requestPath");
			return (Criteria) this;
		}

		public Criteria andRequestPathNotBetween(String value1, String value2) {
			addCriterion("REQUEST_PATH not between", value1, value2, "requestPath");
			return (Criteria) this;
		}

		public Criteria andRequestServerIsNull() {
			addCriterion("REQUEST_SERVER is null");
			return (Criteria) this;
		}

		public Criteria andRequestServerIsNotNull() {
			addCriterion("REQUEST_SERVER is not null");
			return (Criteria) this;
		}

		public Criteria andRequestServerEqualTo(String value) {
			addCriterion("REQUEST_SERVER =", value, "requestServer");
			return (Criteria) this;
		}

		public Criteria andRequestServerNotEqualTo(String value) {
			addCriterion("REQUEST_SERVER <>", value, "requestServer");
			return (Criteria) this;
		}

		public Criteria andRequestServerGreaterThan(String value) {
			addCriterion("REQUEST_SERVER >", value, "requestServer");
			return (Criteria) this;
		}

		public Criteria andRequestServerGreaterThanOrEqualTo(String value) {
			addCriterion("REQUEST_SERVER >=", value, "requestServer");
			return (Criteria) this;
		}

		public Criteria andRequestServerLessThan(String value) {
			addCriterion("REQUEST_SERVER <", value, "requestServer");
			return (Criteria) this;
		}

		public Criteria andRequestServerLessThanOrEqualTo(String value) {
			addCriterion("REQUEST_SERVER <=", value, "requestServer");
			return (Criteria) this;
		}

		public Criteria andRequestServerLike(String value) {
			addCriterion("REQUEST_SERVER like", value, "requestServer");
			return (Criteria) this;
		}

		public Criteria andRequestServerNotLike(String value) {
			addCriterion("REQUEST_SERVER not like", value, "requestServer");
			return (Criteria) this;
		}

		public Criteria andRequestServerIn(List<String> values) {
			addCriterion("REQUEST_SERVER in", values, "requestServer");
			return (Criteria) this;
		}

		public Criteria andRequestServerNotIn(List<String> values) {
			addCriterion("REQUEST_SERVER not in", values, "requestServer");
			return (Criteria) this;
		}

		public Criteria andRequestServerBetween(String value1, String value2) {
			addCriterion("REQUEST_SERVER between", value1, value2, "requestServer");
			return (Criteria) this;
		}

		public Criteria andRequestServerNotBetween(String value1, String value2) {
			addCriterion("REQUEST_SERVER not between", value1, value2, "requestServer");
			return (Criteria) this;
		}

		public Criteria andRequestMethodIsNull() {
			addCriterion("REQUEST_METHOD is null");
			return (Criteria) this;
		}

		public Criteria andRequestMethodIsNotNull() {
			addCriterion("REQUEST_METHOD is not null");
			return (Criteria) this;
		}

		public Criteria andRequestMethodEqualTo(String value) {
			addCriterion("REQUEST_METHOD =", value, "requestMethod");
			return (Criteria) this;
		}

		public Criteria andRequestMethodNotEqualTo(String value) {
			addCriterion("REQUEST_METHOD <>", value, "requestMethod");
			return (Criteria) this;
		}

		public Criteria andRequestMethodGreaterThan(String value) {
			addCriterion("REQUEST_METHOD >", value, "requestMethod");
			return (Criteria) this;
		}

		public Criteria andRequestMethodGreaterThanOrEqualTo(String value) {
			addCriterion("REQUEST_METHOD >=", value, "requestMethod");
			return (Criteria) this;
		}

		public Criteria andRequestMethodLessThan(String value) {
			addCriterion("REQUEST_METHOD <", value, "requestMethod");
			return (Criteria) this;
		}

		public Criteria andRequestMethodLessThanOrEqualTo(String value) {
			addCriterion("REQUEST_METHOD <=", value, "requestMethod");
			return (Criteria) this;
		}

		public Criteria andRequestMethodLike(String value) {
			addCriterion("REQUEST_METHOD like", value, "requestMethod");
			return (Criteria) this;
		}

		public Criteria andRequestMethodNotLike(String value) {
			addCriterion("REQUEST_METHOD not like", value, "requestMethod");
			return (Criteria) this;
		}

		public Criteria andRequestMethodIn(List<String> values) {
			addCriterion("REQUEST_METHOD in", values, "requestMethod");
			return (Criteria) this;
		}

		public Criteria andRequestMethodNotIn(List<String> values) {
			addCriterion("REQUEST_METHOD not in", values, "requestMethod");
			return (Criteria) this;
		}

		public Criteria andRequestMethodBetween(String value1, String value2) {
			addCriterion("REQUEST_METHOD between", value1, value2, "requestMethod");
			return (Criteria) this;
		}

		public Criteria andRequestMethodNotBetween(String value1, String value2) {
			addCriterion("REQUEST_METHOD not between", value1, value2, "requestMethod");
			return (Criteria) this;
		}

		public Criteria andProtocolIsNull() {
			addCriterion("PROTOCOL is null");
			return (Criteria) this;
		}

		public Criteria andProtocolIsNotNull() {
			addCriterion("PROTOCOL is not null");
			return (Criteria) this;
		}

		public Criteria andProtocolEqualTo(String value) {
			addCriterion("PROTOCOL =", value, "protocol");
			return (Criteria) this;
		}

		public Criteria andProtocolNotEqualTo(String value) {
			addCriterion("PROTOCOL <>", value, "protocol");
			return (Criteria) this;
		}

		public Criteria andProtocolGreaterThan(String value) {
			addCriterion("PROTOCOL >", value, "protocol");
			return (Criteria) this;
		}

		public Criteria andProtocolGreaterThanOrEqualTo(String value) {
			addCriterion("PROTOCOL >=", value, "protocol");
			return (Criteria) this;
		}

		public Criteria andProtocolLessThan(String value) {
			addCriterion("PROTOCOL <", value, "protocol");
			return (Criteria) this;
		}

		public Criteria andProtocolLessThanOrEqualTo(String value) {
			addCriterion("PROTOCOL <=", value, "protocol");
			return (Criteria) this;
		}

		public Criteria andProtocolLike(String value) {
			addCriterion("PROTOCOL like", value, "protocol");
			return (Criteria) this;
		}

		public Criteria andProtocolNotLike(String value) {
			addCriterion("PROTOCOL not like", value, "protocol");
			return (Criteria) this;
		}

		public Criteria andProtocolIn(List<String> values) {
			addCriterion("PROTOCOL in", values, "protocol");
			return (Criteria) this;
		}

		public Criteria andProtocolNotIn(List<String> values) {
			addCriterion("PROTOCOL not in", values, "protocol");
			return (Criteria) this;
		}

		public Criteria andProtocolBetween(String value1, String value2) {
			addCriterion("PROTOCOL between", value1, value2, "protocol");
			return (Criteria) this;
		}

		public Criteria andProtocolNotBetween(String value1, String value2) {
			addCriterion("PROTOCOL not between", value1, value2, "protocol");
			return (Criteria) this;
		}

		public Criteria andQueryIsNull() {
			addCriterion("QUERY is null");
			return (Criteria) this;
		}

		public Criteria andQueryIsNotNull() {
			addCriterion("QUERY is not null");
			return (Criteria) this;
		}

		public Criteria andQueryEqualTo(String value) {
			addCriterion("QUERY =", value, "query");
			return (Criteria) this;
		}

		public Criteria andQueryNotEqualTo(String value) {
			addCriterion("QUERY <>", value, "query");
			return (Criteria) this;
		}

		public Criteria andQueryGreaterThan(String value) {
			addCriterion("QUERY >", value, "query");
			return (Criteria) this;
		}

		public Criteria andQueryGreaterThanOrEqualTo(String value) {
			addCriterion("QUERY >=", value, "query");
			return (Criteria) this;
		}

		public Criteria andQueryLessThan(String value) {
			addCriterion("QUERY <", value, "query");
			return (Criteria) this;
		}

		public Criteria andQueryLessThanOrEqualTo(String value) {
			addCriterion("QUERY <=", value, "query");
			return (Criteria) this;
		}

		public Criteria andQueryLike(String value) {
			addCriterion("QUERY like", value, "query");
			return (Criteria) this;
		}

		public Criteria andQueryNotLike(String value) {
			addCriterion("QUERY not like", value, "query");
			return (Criteria) this;
		}

		public Criteria andQueryIn(List<String> values) {
			addCriterion("QUERY in", values, "query");
			return (Criteria) this;
		}

		public Criteria andQueryNotIn(List<String> values) {
			addCriterion("QUERY not in", values, "query");
			return (Criteria) this;
		}

		public Criteria andQueryBetween(String value1, String value2) {
			addCriterion("QUERY between", value1, value2, "query");
			return (Criteria) this;
		}

		public Criteria andQueryNotBetween(String value1, String value2) {
			addCriterion("QUERY not between", value1, value2, "query");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNull() {
			addCriterion("CREATE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNotNull() {
			addCriterion("CREATE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andCreateDateEqualTo(Date value) {
			addCriterion("CREATE_DATE =", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotEqualTo(Date value) {
			addCriterion("CREATE_DATE <>", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThan(Date value) {
			addCriterion("CREATE_DATE >", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATE_DATE >=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThan(Date value) {
			addCriterion("CREATE_DATE <", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThanOrEqualTo(Date value) {
			addCriterion("CREATE_DATE <=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateIn(List<Date> values) {
			addCriterion("CREATE_DATE in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotIn(List<Date> values) {
			addCriterion("CREATE_DATE not in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateBetween(Date value1, Date value2) {
			addCriterion("CREATE_DATE between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotBetween(Date value1, Date value2) {
			addCriterion("CREATE_DATE not between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andResponseDateIsNull() {
			addCriterion("RESPONSE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andResponseDateIsNotNull() {
			addCriterion("RESPONSE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andResponseDateEqualTo(Date value) {
			addCriterion("RESPONSE_DATE =", value, "responseDate");
			return (Criteria) this;
		}

		public Criteria andResponseDateNotEqualTo(Date value) {
			addCriterion("RESPONSE_DATE <>", value, "responseDate");
			return (Criteria) this;
		}

		public Criteria andResponseDateGreaterThan(Date value) {
			addCriterion("RESPONSE_DATE >", value, "responseDate");
			return (Criteria) this;
		}

		public Criteria andResponseDateGreaterThanOrEqualTo(Date value) {
			addCriterion("RESPONSE_DATE >=", value, "responseDate");
			return (Criteria) this;
		}

		public Criteria andResponseDateLessThan(Date value) {
			addCriterion("RESPONSE_DATE <", value, "responseDate");
			return (Criteria) this;
		}

		public Criteria andResponseDateLessThanOrEqualTo(Date value) {
			addCriterion("RESPONSE_DATE <=", value, "responseDate");
			return (Criteria) this;
		}

		public Criteria andResponseDateIn(List<Date> values) {
			addCriterion("RESPONSE_DATE in", values, "responseDate");
			return (Criteria) this;
		}

		public Criteria andResponseDateNotIn(List<Date> values) {
			addCriterion("RESPONSE_DATE not in", values, "responseDate");
			return (Criteria) this;
		}

		public Criteria andResponseDateBetween(Date value1, Date value2) {
			addCriterion("RESPONSE_DATE between", value1, value2, "responseDate");
			return (Criteria) this;
		}

		public Criteria andResponseDateNotBetween(Date value1, Date value2) {
			addCriterion("RESPONSE_DATE not between", value1, value2, "responseDate");
			return (Criteria) this;
		}

		public Criteria andIsWorkIsNull() {
			addCriterion("IS_WORK is null");
			return (Criteria) this;
		}

		public Criteria andIsWorkIsNotNull() {
			addCriterion("IS_WORK is not null");
			return (Criteria) this;
		}

		public Criteria andIsWorkEqualTo(Boolean value) {
			addCriterion("IS_WORK =", value, "isWork");
			return (Criteria) this;
		}

		public Criteria andIsWorkNotEqualTo(Boolean value) {
			addCriterion("IS_WORK <>", value, "isWork");
			return (Criteria) this;
		}

		public Criteria andIsWorkGreaterThan(Boolean value) {
			addCriterion("IS_WORK >", value, "isWork");
			return (Criteria) this;
		}

		public Criteria andIsWorkGreaterThanOrEqualTo(Boolean value) {
			addCriterion("IS_WORK >=", value, "isWork");
			return (Criteria) this;
		}

		public Criteria andIsWorkLessThan(Boolean value) {
			addCriterion("IS_WORK <", value, "isWork");
			return (Criteria) this;
		}

		public Criteria andIsWorkLessThanOrEqualTo(Boolean value) {
			addCriterion("IS_WORK <=", value, "isWork");
			return (Criteria) this;
		}

		public Criteria andIsWorkIn(List<Boolean> values) {
			addCriterion("IS_WORK in", values, "isWork");
			return (Criteria) this;
		}

		public Criteria andIsWorkNotIn(List<Boolean> values) {
			addCriterion("IS_WORK not in", values, "isWork");
			return (Criteria) this;
		}

		public Criteria andIsWorkBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_WORK between", value1, value2, "isWork");
			return (Criteria) this;
		}

		public Criteria andIsWorkNotBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_WORK not between", value1, value2, "isWork");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table REQUEST_INFO
	 * @mbg.generated  Tue Apr 04 00:38:00 GMT+08:00 2017
	 */
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table REQUEST_INFO
     *
     * @mbg.generated do_not_delete_during_merge Mon Apr 03 22:54:25 GMT+08:00 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}