package com.yzc.pojo;
// default package
// Generated 2019-9-27 10:33:55 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TOrder generated by hbm2java
 */
public class OrderVO implements java.io.Serializable {

	private String id;
	private Float totalAmount;
	private Float actualTotalAmount;
	private Float discountByCredit;
	private Integer paymentGateway;
	private Integer paymentStatus;
	private Integer orderStatus;
	private Boolean useCredit;
	private Date createTime;
	private Set TItems = new HashSet(0);

	public OrderVO() {
	}

	public OrderVO(String id) {
		this.id = id;
	}

	public OrderVO(String id, Float totalAmount, Float actualTotalAmount, Float discountByCredit,
			Integer paymentGateway, Integer paymentStatus, Integer orderStatus, Boolean useCredit, Date createTime, Set TItems) {
		this.id = id;
		this.totalAmount = totalAmount;
		this.actualTotalAmount = actualTotalAmount;
		this.discountByCredit = discountByCredit;
		this.paymentGateway = paymentGateway;
		this.paymentStatus = paymentStatus;
		this.orderStatus = orderStatus;
		this.useCredit = useCredit;
		this.createTime = createTime;
		this.TItems = TItems;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Float getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Float getActualTotalAmount() {
		return this.actualTotalAmount;
	}

	public void setActualTotalAmount(Float actualTotalAmount) {
		this.actualTotalAmount = actualTotalAmount;
	}

	public Float getDiscountByCredit() {
		return this.discountByCredit;
	}

	public void setDiscountByCredit(Float discountByCredit) {
		this.discountByCredit = discountByCredit;
	}

	public Integer getPaymentGateway() {
		return this.paymentGateway;
	}

	public void setPaymentGateway(Integer paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	public Integer getPaymentStatus() {
		return this.paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Boolean getUseCredit() {
		return this.useCredit;
	}

	public void setUseCredit(Boolean useCredit) {
		this.useCredit = useCredit;
	}	
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Set getTItems() {
		return this.TItems;
	}

	public void setTItems(Set TItems) {
		this.TItems = TItems;
	}

}
