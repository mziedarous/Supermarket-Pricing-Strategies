package com.sgcib.supermarket.pricing.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author AROUS Med Zied
 * @category Entity
 * @version 1.0
 */
@Entity
@Table(name = "deal")
@XmlRootElement
public class Deal implements Serializable {

	private static final long serialVersionUID = -3989309031148702634L;
	// Entity attributes
	private int id;
	private String title;
	private String description;
	// Number of element
	private int packet;
	// Percentage of reduction
	private double rate;
	// RelationShip between Entities
	private List<Product> products;

	public Deal() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPacket() {
		return packet;
	}

	public void setPacket(int packet) {
		this.packet = packet;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@OneToMany(mappedBy = "deal", fetch = FetchType.EAGER, cascade = {
			CascadeType.PERSIST, CascadeType.REMOVE })
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Deal [id=" + id + ", title=" + title + ", description="
				+ description + ", packet=" + packet + ", rate=" + rate
				+ ", products=" + products + "]";
	}

}
