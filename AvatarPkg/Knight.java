package AvatarPkg;

public class Knight extends Avatar {

	//Variáveis
	//protected:
	protected int power;

	//Métodos
	//public:
	public Knight(String name, int newPower) {
		super(name);
		power = newPower;
	}

	public void addPower(int increase) {
		power += increase;
	}

	protected int getAttackPts() {
		return super.getAttackPts() + power;
	}

	//Métodos Getter
	protected int getDefensePts() {
		return super.getDefensePts() + power/3;
	}

}
