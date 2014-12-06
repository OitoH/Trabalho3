package Items;

import java.io.Serializable;

public abstract class Item implements Serializable {

	//Variáveis
	//private
	private String name;
	private double price;

	//Métodos
	//public
	public Item(String newName, double newPrice) {
		setName(newName);
		setPrice(newPrice);
	}

	public Item(Item rhs) {
		setName( rhs.name );
		setPrice( rhs.price );
	}

	//Métodos Getter
	public String getName() { return name; }

	public double getPrice() { return price; }

	public int getAttackPts() { return 0; }

	public int getDefensePts( ) { return 0; }

	//private
	//Métodos Setter
	private void setName(String newName) { name = newName; }

	private void setPrice(double newPrice) {
		if ( newPrice > 0.0 )    price = newPrice;
		else {
			newPrice = 1.0;
			System.err.println( "Valor inválido de newPrice no item " + getName()
									+ "atribuindo valor padrão: " + newPrice
								  );
		}
	}

}
