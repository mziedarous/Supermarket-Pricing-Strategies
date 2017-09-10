package com.sgcib.supermarket.pricing.test;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sgcib.supermarket.pricing.entities.Category;
import com.sgcib.supermarket.pricing.entities.Deal;
import com.sgcib.supermarket.pricing.entities.Product;
import com.sgcib.supermarket.pricing.service.PricingService;

/**
 * 
 * @author AROUS Med Zied
 *
 */
public class PricingCasesTest {

	public static Session session;
	public static Deal deal;
	public static Category category;
	public static Product product;
	public static PricingService pricingService;

	@Test
	public void testGetPackedPrice() throws Exception {
		assertEquals(2.25, pricingService.getPackedPrice(product, deal), 0.001);
	}

	@Test
	public void testGetPriceFromDeal() throws Exception {

		assertEquals(1.3333333333333333,
				pricingService.getPriceFromDeal(1, 4, deal), 0.001);
	}

	@Test
	public void testGetOncesFromPound() throws Exception {
		assertEquals(48.0, pricingService.getOncesFromPound(3, 1), 0.001);
	}

	@Test
	public void testGetProundFromOnces() throws Exception {
		assertEquals(0.1875, pricingService.getProundFromOnces(1, 3), 0.001);
	}

	@Test
	public void testGetOfferedProduct() throws Exception {
		assertEquals(0.6666666666666666,
				pricingService.getOfferedProduct(3, 2), 0.001);
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		pricingService = (PricingService) context.getBean("PricingService");
		deal = (Deal) context.getBean("Deal");
		category = (Category) context.getBean("Category");
		product = (Product) context.getBean("Product");

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
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
		pricingService.createCategory(context, session, category);
		pricingService.createDeal(context, session, deal);
		pricingService.createProduct(context, session, product);
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		session.getTransaction().commit();
		session.close();
	}
}
