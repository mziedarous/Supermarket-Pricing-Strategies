package com.sgcib.supermarket.pricing.dao.impl;

import org.hibernate.Session;

import com.sgcib.supermarket.pricing.dao.PricingDao;
import com.sgcib.supermarket.pricing.entities.Category;
import com.sgcib.supermarket.pricing.entities.Deal;
import com.sgcib.supermarket.pricing.entities.Product;

public class PricingDaoImpl implements PricingDao {


	public Product createProduct(Session session, Product product) {
		session.save(product);
		return product;
	}

	public Deal createDeal(Session session, Deal deal) {
		session.save(deal);
		return deal;
	}

	public Category createCategory(Session session, Category category) {
		session.save(category);
		return category;
	}

	public Product findProduct(Session session, Product product) {
		return session.get(Product.class, product.getId());
	}

	public Deal findDeal(Session session, Deal deal) {
		return session.get(Deal.class, deal.getId());
	}

	public Category findCategory(Session session, Category category) {
		return session.get(Category.class, category.getId());
	}

	public Product updateProduct(Session session, Product product) {
		session.update(product);
		return product;
	}

	public Deal updateDeal(Session session, Deal deal) {
		session.update(deal);
		return deal;
	}

	public Category updateCategory(Session session, Category category) {
		session.update(category);
		return category;
	}

	public void deleteProduct(Session session, Product product) {
		session.delete(product);
	}

	public void deleteDeal(Session session, Deal deal) {
		session.delete(deal);
	}

	public void deleteCategory(Session session, Category category) {
		session.delete(category);
	}



}
