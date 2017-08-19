package dataobject;

public class Product {
	private int id;
	private String productcode;
	private String productname;
	private Category category;
	private Brand brand;
	private Uniofmeasure uniofmeasure;
	private double unitPrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Uniofmeasure getUniofmeasure() {
		return uniofmeasure;
	}
	public void setUniofmeasure(Uniofmeasure uniofmeasure) {
		this.uniofmeasure = uniofmeasure;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productcode=" + productcode + ", productname=" + productname + ", category="
				+ category + ", brand=" + brand + ", uniofmeasure=" + uniofmeasure + ", unitPrice=" + unitPrice + "]";
	}
	public Product(int id, String productcode, String productname, Category category, Brand brand,
			Uniofmeasure uniofmeasure, double unitPrice) {
		super();
		this.id = id;
		this.productcode = productcode;
		this.productname = productname;
		this.category = category;
		this.brand = brand;
		this.uniofmeasure = uniofmeasure;
		this.unitPrice = unitPrice;
	}
	
	
}
