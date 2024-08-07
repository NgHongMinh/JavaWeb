package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private int id;
	private String name;
	private double price;
	private int quantity;
	private String image;
	private String description;
	private Category category;
	private int status;
	private int amount;
	
	private List<Product> CProduct = new ArrayList<Product>();;
	
	
	public Product(int id, String name, double price, int quantity, String image, String description, Category category,
			int status, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.description = description;
		this.category = category;
		this.status = status;
		this.amount = 1;
	}

	public Product() {
		this.CProduct = new ArrayList<>();
	}
	
	public Product(String name, double price, int quantity, String image, String description, Category category,
			int status) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.description = description;
		this.category = category;
		this.status = status;
	}



	public Product(int id, String name, double price, int quantity, String image, String description, Category category,
			int status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.description = description;
		this.category = category;
		this.status = status;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void remove(int id) {
		for(Product p :CProduct){
			if(p.getId()==id){
                CProduct.remove(p);
                return;
            }
		}
	}
		
}