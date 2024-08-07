package service;


import java.util.List;

import DAO.ProductDAO;
import model.Product;

public class ProductService {
	private ProductDAO productDAO;
	
	public ProductService() {
		super();
		this.productDAO = new ProductDAO();
	}
	
	public List<Product> getProducts() {
		return this.productDAO.findAll();
	}
	
	public Product getById(String id) {
		return this.productDAO.findById(id);
	}
	
//	public List<Product> sortByPrice(String status) {
//		return this.productDAO.sortByPrice(status);
//	}
	
	public List<Product> searchByName(String name) {
		return this.productDAO.searchByName(name);
	}
	
	public void deleteProduct(String pid) {
		this.productDAO.deleteById(pid);
	}
	
	public void createProduct(Product product) {
		this.productDAO.create(product);
	}
	
	public void updateProduct(int id, Product product) {
		Product p = getById(String.valueOf(id));
		if(p != null) {
			this.productDAO.update(id, product);
		}
	}
}
