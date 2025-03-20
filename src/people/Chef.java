package people;

import java.util.ArrayList;

import main.Main;
import restaurant.Food;

public class Chef {
	private String name;
	private ArrayList<Food> foodsHistory = new ArrayList<>();
	private ArrayList<Integer> quantityHistory = new ArrayList<>();

	public Chef(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Food> getFoodsHistory() {
		return foodsHistory;
	}

	public void setFoodsHistory(ArrayList<Food> foodsHistory) {
		this.foodsHistory = foodsHistory;
	}

	public ArrayList<Integer> getQuantityHistory() {
		return quantityHistory;
	}

	public void setQuantityHistory(ArrayList<Integer> quantityHistory) {
		this.quantityHistory = quantityHistory;
	}
	
	public void addFoodToHistory(Food food) {
		if(food == null) return;
		foodsHistory.add(food);
	}
	
	public void addQuantityToHistory(Integer qty) {
		if(qty == null) return;
		quantityHistory.add(qty);
	}

	public void showCookHistory() {
		System.out.println("");
		System.out.println(this.name + "'s cook history: ");
		int i = 0;
		for (Food food : foodsHistory) {
			for (Integer qty : quantityHistory) {
				System.out.println("  - " + food.getName() + " (" + Main.formatIDR(qty * food.getPrice()) + ")");
				System.out.println("      " + qty + " x " + Main.formatIDR(food.getPrice()));
			}
			i++;
		}
	}
}
