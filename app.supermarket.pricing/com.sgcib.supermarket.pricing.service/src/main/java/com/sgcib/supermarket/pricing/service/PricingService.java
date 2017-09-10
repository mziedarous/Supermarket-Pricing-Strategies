package com.sgcib.supermarket.pricing.service;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.sgcib.supermarket.pricing.entities.Category;
import com.sgcib.supermarket.pricing.entities.Deal;
import com.sgcib.supermarket.pricing.entities.Product;

/**
 * 
 * @author AROUS Med Zied
 *
 */
@Service
public interface PricingService {

	/**
	 * 
	 * @param context
	 * @param session
	 * @param product
	 * @return
	 * @throws Exception
	 */
	Product createProduct(ApplicationContext context, Session session,
			Product product) throws Exception;

	/**
	 * 
	 * @param context
	 * @param session
	 * @param deal
	 * @return
	 * @throws Exception
	 */
	Deal createDeal(ApplicationContext context, Session session, Deal deal)
			throws Exception;

	/**
	 * 
	 * @param context
	 * @param session
	 * @param category
	 * @return
	 * @throws Exception
	 */
	Category createCategory(ApplicationContext context, Session session,
			Category category) throws Exception;

	/**
	 * 
	 * @param context
	 * @param session
	 * @param product
	 * @return
	 * @throws Exception
	 */
	Product updateProduct(ApplicationContext context, Session session,
			Product product) throws Exception;

	/**
	 * 
	 * @param context
	 * @param session
	 * @param deal
	 * @return
	 * @throws Exception
	 */
	Deal updateDeal(ApplicationContext context, Session session, Deal deal)
			throws Exception;

	/**
	 * 
	 * @param context
	 * @param session
	 * @param category
	 * @return
	 * @throws Exception
	 */
	Category updateCategory(ApplicationContext context, Session session,
			Category category) throws Exception;

	/**
	 * 
	 * @param context
	 * @param session
	 * @param product
	 * @throws Exception
	 */
	void deleteProduct(ApplicationContext context, Session session,
			Product product) throws Exception;

	/**
	 * 
	 * @param context
	 * @param session
	 * @param deal
	 * @throws Exception
	 */
	void deleteDeal(ApplicationContext context, Session session, Deal deal)
			throws Exception;

	/**
	 * 
	 * @param context
	 * @param session
	 * @param category
	 * @throws Exception
	 */
	void deleteCategory(ApplicationContext context, Session session,
			Category category) throws Exception;

	/**
	 * 
	 * @param context
	 * @param session
	 * @param product
	 * @return
	 * @throws Exception
	 */
	Product findProduct(ApplicationContext context, Session session,
			Product product) throws Exception;

	/**
	 * 
	 * @param context
	 * @param session
	 * @param deal
	 * @return
	 * @throws Exception
	 */
	Deal findDeal(ApplicationContext context, Session session, Deal deal)
			throws Exception;

	/**
	 * 
	 * @param context
	 * @param session
	 * @param category
	 * @return
	 * @throws Exception
	 */
	Category findCategory(ApplicationContext context, Session session,
			Category category) throws Exception;

	/**
	 * 
	 * @param product
	 * @param deal
	 * @return double
	 */
	double getPackedPrice(Product product, Deal deal) throws Exception;

	/**
	 * 
	 * @param unitePacketPrice
	 * @param numberOfEntity
	 * @param deal
	 * @return double
	 */
	double getPriceFromDeal(double unitePacketPrice, int numberOfEntity,
			Deal deal) throws Exception;

	/**
	 * 
	 * @param unitePound
	 * @param unite
	 * @return double
	 */
	double getOncesFromPound(double unitePound, double unite) throws Exception;

	/**
	 * 
	 * @param uniteOnces
	 * @param unite
	 * @return double
	 */
	double getProundFromOnces(double uniteOnces, double unite) throws Exception;

	/**
	 * 
	 * @param numberOfEntity
	 * @param unitePacketPrice
	 * @return double
	 */
	double getOfferedProduct(int numberOfEntity, double unitePacketPrice)
			throws Exception;

}
