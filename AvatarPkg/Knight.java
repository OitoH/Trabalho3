package AvatarPkg;
public class Knight extends Avatar {

	//public:
	public Knight(String name, int newPower) {
		super(name);
		power = newPower;
	}

	public void addPower(int increase) {
		power += increase;
	}

	//protected:
	protected int power;

	//Métodos Getter
	protected int getDefensePts() {
		return super.getDefensePts() + power;
	}

}
