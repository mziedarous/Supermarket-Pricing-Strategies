package com.sgcib.supermarket.pricing.service.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;

import com.sgcib.supermarket.pricing.dao.PricingDao;
import com.sgcib.supermarket.pricing.entities.Category;
import com.sgcib.supermarket.pricing.entities.Deal;
import com.sgcib.supermarket.pricing.entities.Product;
import com.sgcib.supermarket.pricing.service.PricingService;

/**
 * 
 * @author AROUS Med Zied
 *
 */
public class PricingServiceImpl implements PricingService {
	
	static final Logger logger = Logger.getLogger(PricingServiceImpl.class);
	private PricingDao dao;

	public Product createProduct(ApplicationContext context, Session session,
			Product product) {
		try {
			PricingDao dao = getDaoContext(context);
			return dao.createProduct(session, product);
		} catch (Exception e) {
			LambdaLogger lambdaLogger = (String msgInfo) -> logger
					.error(msgInfo,e);
			lambdaLogger.traceInfo("Exception in create Praduct : ");
			return null;
		}
	}

	public Deal createDeal(ApplicationContext context, Session session,
			Deal deal) {
		PricingDao dao = getDaoContext(context);
		try {
			return dao.createDeal(session, deal);
		} catch (Exception e) {
			LambdaLogger lambdaLogger = (String msgInfo) -> logger
					.error(msgInfo,e);
			lambdaLogger.traceInfo("Exception in create Deal : ");
			return null;
		}
	}

	public Category createCategory(ApplicationContext context, Session session,
			Category category) {
		PricingDao dao = getDaoContext(context);
		try {
			return dao.createCategory(session, category);
		} catch (Exception e) {
			LambdaLogger lambdaLogger = (String msgInfo) -> logger
					.error(msgInfo,e);
			lambdaLogger.traceInfo("Exception in create Category : ");
			return null;
		}
	}

	public Product updateProduct(ApplicationContext context, Session session,
			Product product) {
		PricingDao dao = getDaoContext(context);
		try {
			return dao.updateProduct(session, product);
		} catch (Exception e) {
			LambdaLogger lambdaLogger = (String msgInfo) -> logger
					.error(msgInfo,e);
			lambdaLogger.traceInfo("Exception in update Product : ");
			return null;
		}
	}

	public Deal updateDeal(ApplicationContext context, Session session,
			Deal deal) {
		PricingDao dao = getDaoContext(context);
		try {
			return dao.updateDeal(session, deal);
		} catch (Exception e) {
			LambdaLogger lambdaLogger = (String msgInfo) -> logger
					.error(msgInfo,e);
			lambdaLogger.traceInfo("Exception in update Deal : ");
			return null;
		}
	}

	public Category updateCategory(ApplicationContext context, Session session,
			Category category) {
		PricingDao dao = getDaoContext(context);
		try {
			return dao.updateCategory(session, category);
		} catch (Exception e) {
			LambdaLogger lambdaLogger = (String msgInfo) -> logger
					.error(msgInfo,e);
			lambdaLogger.traceInfo("Exception in update Category : ");
			return null;
		}
	}

	public void deleteProduct(ApplicationContext context, Session session,
			Product product) {
		PricingDao dao = getDaoContext(context);
		try {
			dao.deleteProduct(session, product);
		} catch (Exception e) {
			LambdaLogger lambdaLogger = (String msgInfo) -> logger
					.error(msgInfo,e);
			lambdaLogger.traceInfo("Exception in delete Product : ");
		}
	}

	public void deleteDeal(ApplicationContext context, Session session,
			Deal deal) {
		PricingDao dao = getDaoContext(context);
		try {
			dao.deleteDeal(session, deal);
		} catch (Exception e) {
			LambdaLogger lambdaLogger = (String msgInfo) -> logger
					.error(msgInfo,e);
			lambdaLogger.traceInfo("Exception in delete Deal : ");
		}
	}

	public void deleteCategory(ApplicationContext context, Session session,
			Category category) {
		PricingDao dao = getDaoContext(context);
		try {
			dao.deleteCategory(session, category);
		} catch (Exception e) {
			LambdaLogger lambdaLogger = (String msgInfo) -> logger
					.error(msgInfo,e);
			lambdaLogger.traceInfo("Exception in delete Category : ");
		}
	}

	public Product findProduct(ApplicationContext context, Session session,
			Product product) {
		PricingDao dao = getDaoContext(context);
		try {
			return dao.findProduct(session, product);
		} catch (Exception e) {
			LambdaLogger lambdaLogger = (String msgInfo) -> logger
					.error(msgInfo,e);
			lambdaLogger.traceInfo("Exception in delete Product : ");
			return null;
		}
	}

	public Deal findDeal(ApplicationContext context, Session session, Deal deal) {
		PricingDao dao = getDaoContext(context);
		try {
			return dao.findDeal(session, deal);
		} catch (Exception e) {
			LambdaLogger lambdaLogger = (String msgInfo) -> logger
					.error(msgInfo,e);
			lambdaLogger.traceInfo("Exception in delete Deal : ");
			return null;
		}
	}

	public Category findCategory(ApplicationContext context, Session session,
			Category category) {
		PricingDao dao = getDaoContext(context);
		try {
			return dao.findCategory(session, category);
		} catch (Exception e) {
			LambdaLogger lambdaLogger = (String msgInfo) -> logger
					.error(msgInfo,e);
			lambdaLogger.traceInfo("Exception in delete Category : ");
			return null;
		}
	}

	public double getPackedPrice(Product product, Deal deal) {

		if (product.isOnDiscount()) {
			return product.getUnitePrice() * deal.getPacket() * deal.getRate();
		}
		LambdaLogger lambdaLogger = (String msgInfo) -> logger
				.error(msgInfo);
		lambdaLogger.traceInfo("this product is not included in a deal");
		return 0.0;
	}

	public double getPriceFromDeal(double unitePacketPrice, int numberOfEntity,
			Deal deal) {
		if (deal.getPacket() * deal.getRate() != 0.0) {
			return (unitePacketPrice / (deal.getPacket() * deal.getRate()))
					* numberOfEntity * deal.getRate();
		}
		LambdaLogger lambdaLogger = (String msgInfo) -> logger
				.error(msgInfo);
		lambdaLogger.traceInfo("Please verify that the packet and rate are different of zero");
		return 0.0;
	}

	public double getOncesFromPound(double unitePound, double unite) {
		return (unitePound * unite) * 16;
	}

	public double getProundFromOnces(double uniteOnces, double unite) {
		return (uniteOnces * unite) / 16;
	}

	public double getOfferedProduct(int numberOfEntity, double unitePacketPrice) {
		if (numberOfEntity != 0)
			return unitePacketPrice / numberOfEntity;
		LambdaLogger lambdaLogger = (String msgInfo) -> logger
				.error(msgInfo);
		lambdaLogger.traceInfo("Please verify that the numberOfEntity is different of zero");
		return 0;
	}

	private PricingDao getDaoContext(ApplicationContext context) {
		return setDao((PricingDao) context.getBean("PricingDao"));
	}

	public PricingDao getDao() {
		return dao;
	}

	public PricingDao setDao(PricingDao dao) {
		this.dao = dao;
		return dao;
	}
}
interface LambdaLogger {
	void traceInfo(String msgInfo);
}