package people;

import main.Main;

public class Visitor {
	private String name;
	private Integer totalPayment = 0;

	public Visitor(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addPayment(Integer price) {
		if(price == null) return;
		this.totalPayment += price;
	}

	public void showTotalPrice() {
		System.out.println("Total bill for " + this.name + " is " + Main.formatIDR(this.totalPayment));
	}
}
