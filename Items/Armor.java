package Items;
import java.lang.System;

public class Armor extends Item {

	//Variáveis
	//protected:
	protected int defensepts;
	protected double weight;

	//Métodos
	//public:
	public Armor(String newName, double newPrice, int newDefensePts, double newWeight) {
		super(newName, newPrice);
		setDefensePts(newDefensePts);
		setWeight(newWeight);
	}

	public Armor(Armor rhs) {
		super(rhs);
		setDefensePts( rhs.defensepts );
		setWeight( rhs.weight );
	}

	//Métodos Getter
	public int getDefensePts() {
		return defensepts;
	}

	public double getWeight() {
		return weight;
	}

	//Métodos Setter
	public void setDefensePts(int newDefensePts) {
		if ( newDefensePts > 0 && newDefensePts < 21 )
			defensepts = newDefensePts;
		else {
			defensepts = 10;
			System.err.println( "Valor inválido de defensepts no item " + getName()
									+ " atribuindo valor padrão: " + defensepts
								  );
		}
	}

	public void setWeight(double newWeight) {
		if ( newWeight >= 1.0 && newWeight <= 20.0 )
			weight = newWeight;
		else {
			weight = 10.0;
			System.err.println( "Valor inválido de weight no item " + getName()
									+ " atribuindo valor padrão: " + weight
								  );
		}
	}

}
