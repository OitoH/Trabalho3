package Items.Weapons;

import Items.Item;

public class Weapon extends Item {

	//Parâmetros
	//protected:
	protected int attackpts;

	//Métodos
	//public:
	public Weapon(String newName, double newPrice, int newAttackPts) {
		super(newName, newPrice);
		setAttackPts(newAttackPts);
	}

	public Weapon(Weapon rhs) {
		super(rhs);
		setAttackPts( rhs.attackpts );
	}

	//Métodos Getter
	public int getAttackPts() {
		return attackpts;
	}

	//Métodos Setter
	public void setAttackPts(int newAttackPts) {
		if ( newAttackPts > 0 && newAttackPts < 10 )
			attackpts = newAttackPts;
		else    {
			attackpts = 5;
			System.err.println( "Valor inválido de attackpts no item " + getName()
									+ " atribuindo valor padrão: " + attackpts
								  );
		}
	}

}
