package com.sgcib.supermarket.pricing.dao;

import org.hibernate.Session;

import com.sgcib.supermarket.pricing.entities.Category;
import com.sgcib.supermarket.pricing.entities.Deal;
import com.sgcib.supermarket.pricing.entities.Product;

/**
 * 
 * @author AROUS Med Zied
 *
 */
public interface PricingDao {

	/**
	 * <p>
	 * This will create a product
	 * </p>
	 * 
	 * @param session
	 * @param product
	 * @return Product
	 */
	Product createProduct(Session session, Product product)throws Exception;

	/**
	 * <p>
	 * This method will create a Deal
	 * </p>
	 * 
	 * @param session
	 * @param deal
	 * @return Deal
	 */
	Deal createDeal(Session session, Deal deal)throws Exception;

	/**
	 * <p>
	 * This method will create a category
	 * </p>
	 * @param context 
	 * 
	 * @param session
	 * @param category
	 * @return Category
	 */
	Category createCategory(Session session, Category category)throws Exception;

	/**
	 * <p>
	 * This method will update a product
	 * </p>
	 * 
	 * @param session
	 * @param product
	 * @return Product
	 */
	Product updateProduct(Session session, Product product)throws Exception;

	/**
	 * <p>
	 * This method will update a deal
	 * </p>
	 * 
	 * @param session
	 * @param deal
	 * @return Deal
	 */
	Deal updateDeal(Session session, Deal deal)throws Exception;

	/**
	 * <p>
	 * This method will update a Category
	 * </p>
	 * 
	 * @param session
	 * @param category
	 * @return Category
	 */
	Category updateCategory(Session session, Category category)throws Exception;

	/**
	 * 
	 * @param session
	 * @param product
	 */
	void deleteProduct(Session session, Product product)throws Exception;

	/**
	 * 
	 * @param session
	 * @param deal
	 */
	void deleteDeal(Session session, Deal deal)throws Exception;

	/**
	 * 
	 * @param session
	 * @param category
	 */
	void deleteCategory(Session session, Category category)throws Exception;

	/**
	 * 
	 * @param session
	 * @param product
	 * @return Product
	 */
	Product findProduct(Session session, Product product)throws Exception;

	/**
	 * 
	 * @param session
	 * @param deal
	 * @return Deal
	 */
	Deal findDeal(Session session, Deal deal)throws Exception;

	/**
	 * 
	 * @param session
	 * @param category
	 * @return Category
	 */
	Category findCategory(Session session, Category category)throws Exception;

}
