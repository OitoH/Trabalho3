package Items;
import java.lang.System;

public class Weapon extends Item {

	//Variáveis
	//protected:
	protected int attackpts;
	protected double range;

	//Métodos
	//public:
	public Weapon(String newName, double newPrice, int newAttackPts, double newRange) {
		super(newName, newPrice);
		setAttackPts(newAttackPts);
		setRange(newRange);
	}

	public Weapon(Weapon rhs) {
		super(rhs);
		setAttackPts( rhs.attackpts );
		setRange( rhs.range );
	}

	//Métodos Getter
	public int getAttackPts() {
		return attackpts;
	}

	public double getRange() {
		return range;
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

	public void setRange(double newRange) {
		range = newRange;
	}

}
