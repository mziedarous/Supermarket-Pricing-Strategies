package com.sgcib.supermarket.pricing.ws;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sgcib.supermarket.pricing.entities.Category;
import com.sgcib.supermarket.pricing.entities.Deal;
import com.sgcib.supermarket.pricing.entities.Product;

/**
 * 
 * @author AROUS Med Zied
 *
 */
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public interface PricingServiceWs {

	/**
	 * 
	 * @param product
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path("/products")
	Product createProduct(Product product);

	/**
	 * 
	 * @param deal
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path("/deal")
	Deal createDeal(Deal deal);

	/**
	 * 
	 * @param category
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path("/category")
	Category createCategory(Category category);

	/**
	 * 
	 * @param product
	 * @return
	 * @throws Exception
	 */
	@PUT
	@Path("/product")
	Product updateProduct(Product product);

	/**
	 * 
	 * @param deal
	 * @return
	 * @throws Exception
	 */
	@PUT
	@Path("/deal")
	Deal updateDeal(Deal deal);

	/**
	 * 
	 * @param category
	 * @return
	 * @throws Exception
	 */
	@PUT
	@Path("/category")
	Category updateCategory(Category category);

	/**
	 * 
	 * @param product
	 * @throws Exception
	 */
	@DELETE
	@Path("/product")
	void deleteProduct(Product product);

	/**
	 * 
	 * @param deal
	 * @throws Exception
	 */
	@DELETE
	@Path("/deal")
	void deleteDeal(Deal deal);

	/**
	 * 
	 * @param category
	 * @throws Exception
	 */
	@DELETE
	@Path("/category")
	void deleteCategory(Category category);

	/**
	 * 
	 * @param product
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/product")
	Product findProduct(Product product);

	/**
	 * 
	 * @param deal
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/deal")
	Deal findDeal(Deal deal);

	/**
	 * 
	 * @param category
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/category")
	Category findCategory(Category category);

	/**
	 * 
	 * @param product
	 * @param deal
	 * @return double
	 */
	@GET
	@Path("/packedPrice")
	double getPackedPrice(Product product, Deal deal);

	/**
	 * 
	 * @param unitePacketPrice
	 * @param numberOfEntity
	 * @param deal
	 * @return double
	 */
	@GET
	@Path("/getPriceFromDeal")
	double getPriceFromDeal(double unitePacketPrice, int numberOfEntity,
			Deal deal);

	/**
	 * 
	 * @param unitePound
	 * @param unite
	 * @return double
	 */
	@GET
	@Path("/getOncesFromPound")
	double getOncesFromPound(double unitePound, double unite);

	/**
	 * 
	 * @param uniteOnces
	 * @param unite
	 * @return double
	 */
	@GET
	@Path("/getProundFromOnces")
	double getProundFromOnces(double uniteOnces, double unite);

	/**
	 * 
	 * @param numberOfEntity
	 * @param unitePacketPrice
	 * @return double
	 */
	@GET
	@Path("/getOfferedProduct")
	double getOfferedProduct(int numberOfEntity, double unitePacketPrice);

}
