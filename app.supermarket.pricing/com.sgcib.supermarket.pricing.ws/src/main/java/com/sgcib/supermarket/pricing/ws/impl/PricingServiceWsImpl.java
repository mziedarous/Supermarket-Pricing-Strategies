package com.sgcib.supermarket.pricing.ws.impl;

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
import com.sgcib.supermarket.pricing.ws.PricingServiceWs;

/**
 * 
 * @author AROUS Med Zied
 *
 */
public class PricingServiceWsImpl implements PricingServiceWs {

	PricingService pricingService = new PricingServiceImpl();

	@Override
	public Product createProduct(Product product) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			return pricingService.createProduct(context, session, product);

		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Deal createDeal(Deal deal) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			return pricingService.createDeal(context, session, deal);

		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Category createCategory(Category category) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			return pricingService.createCategory(context, session, category);

		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Product updateProduct(Product product) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			return pricingService.updateProduct(context, session, product);

		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Deal updateDeal(Deal deal) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			return pricingService.updateDeal(context, session, deal);

		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Category updateCategory(Category category) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			return pricingService.updateCategory(context, session, category);

		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void deleteProduct(Product product) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			pricingService.deleteProduct(context, session, product);

		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteDeal(Deal deal) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			pricingService.deleteDeal(context, session, deal);

		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteCategory(Category category) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			pricingService.deleteCategory(context, session, category);

		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}

	}

	@Override
	public Product findProduct(Product product) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			return pricingService.findProduct(context, session, product);

		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Deal findDeal(Deal deal) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			return pricingService.findDeal(context, session, deal);

		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Category findCategory(Category category) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			return pricingService.findCategory(context, session, category);

		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public double getPackedPrice(Product product, Deal deal) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			return pricingService.getPackedPrice(product, deal);

		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
		return 0.0;
	}

	@Override
	public double getPriceFromDeal(double unitePacketPrice, int numberOfEntity,
			Deal deal) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		try {
			return pricingService.getPriceFromDeal(unitePacketPrice,
					numberOfEntity, deal);
		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
		return 0.0;
	}

	@Override
	public double getOncesFromPound(double unitePound, double unite) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			return pricingService.getOncesFromPound(unitePound, unite);

		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
		return 0.0;
	}

	@Override
	public double getProundFromOnces(double uniteOnces, double unite) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			return pricingService.getProundFromOnces(uniteOnces, unite);

		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
		return 0.0;
	}

	@Override
	public double getOfferedProduct(int numberOfEntity, double unitePacketPrice) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/sgcib/supermarket/pricing/configuration/application-context.xml");
		PricingService pricingService = (PricingService) context
				.getBean("PricingService");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		try {
			return pricingService.getOfferedProduct(numberOfEntity,
					unitePacketPrice);
		} catch (Exception e) {
			session.beginTransaction().rollback();
		} finally {
			session.close();
		}
		return 0.0;
	}

}
