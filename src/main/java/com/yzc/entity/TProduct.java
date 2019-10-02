package com.yzc.entity;
// default package
// Generated 2019-9-27 10:33:55 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;



/**
 * TProduct generated by hbm2java
 */
public class TProduct implements java.io.Serializable {

	private int id;
	private String name;
	private Float price;
	private Integer exchangeCredit;
	private Integer exchangeCountLimit;
	private Integer stock;
	private Boolean exchangeFlag;
	private String imageUrl;
	private String desc;
	
	private Set TItems = new HashSet(0);

	public TProduct() {
	}

	public TProduct(int id) {
		this.id = id;
	}

	public TProduct(int id, String name, Float price, Integer exchangeCredit, Integer exchangeCountLimit, Integer stock,
			Boolean exchangeFlag, String imageUrl, String desc, Set TItems) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.exchangeCredit = exchangeCredit;
		this.exchangeCountLimit = exchangeCountLimit;
		this.stock = stock;
		this.exchangeFlag = exchangeFlag;
		this.imageUrl = imageUrl;
		this.desc = desc;
		this.TItems = TItems;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getExchangeCredit() {
		return this.exchangeCredit;
	}

	public void setExchangeCredit(Integer exchangeCredit) {
		this.exchangeCredit = exchangeCredit;
	}

	public Integer getExchangeCountLimit() {
		return this.exchangeCountLimit;
	}

	public void setExchangeCountLimit(Integer exchangeCountLimit) {
		this.exchangeCountLimit = exchangeCountLimit;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Boolean getExchangeFlag() {
		return this.exchangeFlag;
	}

	public void setExchangeFlag(Boolean exchangeFlag) {
		this.exchangeFlag = exchangeFlag;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}	
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Set getTItems() {
		return this.TItems;
	}

	public void setTItems(Set TItems) {
		this.TItems = TItems;
	}

}
