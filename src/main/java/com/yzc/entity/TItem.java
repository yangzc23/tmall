package com.yzc.entity;
// default package
// Generated 2019-9-27 10:33:55 by Hibernate Tools 4.3.5.Final

/**
 * TItem generated by hbm2java
 */
public class TItem implements java.io.Serializable {

	private int id;
	private TOrder TOrder;
	private TProduct TProduct;
	private Integer quality;

	public TItem() {
	}

	public TItem(int id) {
		this.id = id;
	}

	public TItem(int id, TOrder TOrder, TProduct TProduct, Integer quality) {
		this.id = id;
		this.TOrder = TOrder;
		this.TProduct = TProduct;
		this.quality = quality;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TOrder getTOrder() {
		return this.TOrder;
	}

	public void setTOrder(TOrder TOrder) {
		this.TOrder = TOrder;
	}

	public TProduct getTProduct() {
		return this.TProduct;
	}

	public void setTProduct(TProduct TProduct) {
		this.TProduct = TProduct;
	}

	public Integer getQuality() {
		return this.quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

}
