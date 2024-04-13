package in.ashokit.entity;

public class Product {
	
	
	 	private int id;
	    private String name;
	    private double price;
	    private String buyer;
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
		public String getBuyer() {
			return buyer;
		}
		public void setBuyer(String buyer) {
			this.buyer = buyer;
		}
		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", price=" + price + ", buyer=" + buyer + "]";
		}
		public Product(int id, String name, double price, String buyer) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.buyer = buyer;
		}
		
		
		public Product() {}
		
	    
	    

}
