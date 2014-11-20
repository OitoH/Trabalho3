package AvatarPkg;
public class Wizard extends Avatar {

	//Variáveis
	//protected:
	protected int wisdom;

	//Métodos
	//public:
	public Wizard(String name, int newWisdom) {
		super(name);
		wisdom = newWisdom;
	}

	public void addWisdom(int increase) {
		wisdom += increase;
	}

	//protected:
	//Métodos Getter
	protected int getDefensePts() {
		return super.getDefensePts() + wisdom/2;
	}

}
