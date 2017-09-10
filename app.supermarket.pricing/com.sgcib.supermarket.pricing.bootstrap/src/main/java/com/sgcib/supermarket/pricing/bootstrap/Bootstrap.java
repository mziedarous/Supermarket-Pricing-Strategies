package com.sgcib.supermarket.pricing.bootstrap;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sgcib.supermarket.pricing.entities.Category;
import com.sgcib.supermarket.pricing.entities.Deal;
import com.sgcib.supermarket.pricing.entities.Product;
import com.sgcib.supermarket.pricing.service.PricingService;
import com.sgcib.supermarket.pricing.service.impl.PricingServiceImpl;

public class Bootstrap {
	static final Logger logger = Logger.getLogger(PricingServiceImpl.class);

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		Deal deal = (Deal) context.getBean("Deal");
		Category category = (Category) context.getBean("Category");
		Product product = (Product) context.getBean("Product");

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		deal.setPacket(3);
		deal.setRate(0.75);
		deal.setTitle("Summer Package 2017");

		category.setFamily("Food");
		category.setDescription("dairy product");
		product.setName("strawberry yoghurt");
		product.setDescription("strawberry yogurt mousse");
		product.setCurrency("Dollar");
		product.setUnitePrice(1);
		product.setOnDiscount(Boolean.TRUE);
		product.setDeal(deal);
		product.setCategory(category);
		try {
			pricingService.createCategory(context, session, category);
			pricingService.createDeal(context, session, deal);
			pricingService.createProduct(context, session, product);
			LambdaLogger lambdaLogger = (String msgInfo) -> logger
					.info(msgInfo);
			lambdaLogger.traceInfo("Summer Package 2017 3 yoghurt for :"+pricingService.getPackedPrice(product, deal)
					+ " " + product.getCurrency());
			lambdaLogger.traceInfo("three for a dollar (so what’s the price if I buy 4)");
			lambdaLogger.traceInfo(pricingService.getPriceFromDeal(1, 4, deal) + " "
					+ product.getCurrency());
			lambdaLogger.traceInfo("three for a dollar (so what’s the price if I buy 5)");
			lambdaLogger.traceInfo(pricingService.getPriceFromDeal(1, 5, deal) + " "
					+ product.getCurrency());
			lambdaLogger.traceInfo("$1.99/pound (so what does 4 ounces cost?)");
			lambdaLogger.traceInfo(pricingService.getPriceFromDeal(30, 8, deal) + " "
					+ product.getCurrency());
			lambdaLogger.traceInfo("$1/onces (so what does 3 ounces cost?)");
			lambdaLogger.traceInfo(pricingService.getProundFromOnces(1, 3) + " "
					+ product.getCurrency());
			lambdaLogger.traceInfo("buy two, get one free (so does the third item have a price?)");
			lambdaLogger.traceInfo(pricingService.getOfferedProduct(3, 2) + " "
					+ product.getCurrency());

			session.getTransaction().commit();
		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}

	}

}

interface LambdaLogger {
	void traceInfo(String msgInfo);
}