package AvatarPkg;
public class Thief extends Avatar {

	//public:
	public Thief(String name, int newStealth) {
		super(name);
		stealth = newStealth;
	}

	public void addStealth(int increase) {
		stealth += increase;
	}

	//protected:
	protected int stealth;

	//Métodos Getter
	protected int getAttackPts() {
		return super.getAttackPts() + stealth;
	}

}
