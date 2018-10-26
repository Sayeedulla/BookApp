package com.mindtree.BookManagement.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name="purchase")
public class Purchase {

	Book b;

	String customer_name;
	String customer_mobileno;
	Date purchasedate;
	int Amount;
	int purchase_id;

	

	@Id
	@Column(name="purchase_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	//@Generated(value=GenerationTime.INSERT )
	@Column(name = "purchase_date")
	public Date getPurchase_date() {
		return purchasedate;
	}

	public void setPurchase_date(Date purchase_date) {
		purchasedate = purchase_date;
	}
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@ManyToOne(cascade = CascadeType.ALL)
	public Book getB() {
		return b;
	}

	public void setB(Book b) {
		this.b = b;
	}

	@Column(name = "customer_name")
	public String getCustomername() {
		return customer_name;
	}

	public void setCustomername(String customername) {
		this.customer_name = customername;
	}

	@Column(name = "customer_mobileno")
	public String getCustomer_mobileno() {
		return customer_mobileno;
	}

	public void setCustomer_mobileno(String customer_mobileno) {
		this.customer_mobileno = customer_mobileno;
	}

	@Column(name = "amount")
	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

}
