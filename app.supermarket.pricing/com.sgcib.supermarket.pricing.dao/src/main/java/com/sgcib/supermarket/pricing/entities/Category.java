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
@Table(name = "category")
@XmlRootElement
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	// Entity attributes
	private int id;
	private String family;
	private String description;
	// RelationShip between Entities
	private List<Product> products;

	public Category() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Category [id=" + id + ", family=" + family + ", description="
				+ description + ", products=" + products + "]";
	}
}
