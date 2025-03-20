package restaurant;

import java.util.ArrayList;

import main.Main;
import people.Chef;
import people.Visitor;

public class Restaurant {
	private String name;
	private ArrayList<Menu> menus = new ArrayList<>();
	private ArrayList<Chef> chefs = new ArrayList<>();
	private Integer totalIncome = 0;

	public Restaurant(String name) {
		this.name = name;
		System.out.println("Welcome to " + this.name + " Restaurant");
	}

	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub
		if(menu == null) return;
		this.menus.add(menu);
	}

	public void showMenu() {
		System.out.println("");
		System.out.println("=== ALL MENUS ===");
		int j = 1;
		for (Menu menu : menus) {
			System.out.println((j++) + "." + menu.getName() + ": ");
			int i = 0;
			for (Food food : menu.getFoods()) {
				System.out.println("  - " + food.getName() + " (" + (Main.formatIDR(food.getPrice())) + ")");
				i++;
			}
		}
		System.out.println("=================");
		System.out.println("");
	}

	public void showChef() {
		System.out.println("");
		System.out.println("=== ALL CHEFS ===");
		for (Chef chef : chefs) {
			System.out.println("- " + chef.getName());
		}
		System.out.println("=================");
		System.out.println("");
		
	}

	public void addChef(Chef chef) {
		if(chef == null) return;
		this.chefs.add(chef);
	}

	public void order(Chef chef, Visitor visitor, String menuName, int qty) {
		Food food = null;
		for (Menu menu : menus) {
			for (Food f: menu.getFoods()) {
				if(f.getName().equals(menuName)) {
					food = f;
					break;
				};
			}
		}
		
		if(food == null) {
			System.out.println("Food named " + menuName + " not found");
			return;
		};
		
		Integer totalPrice = food.getPrice() * qty;
		totalIncome += totalPrice;
		chef.getFoodsHistory().add(food);
		chef.getQuantityHistory().add(qty);
		visitor.addPayment(totalPrice);
	}

	public void showTotalIncome() {
		System.out.println(this.name + "'s restaurant total income : " + Main.formatIDR(this.totalIncome));
	}
}
