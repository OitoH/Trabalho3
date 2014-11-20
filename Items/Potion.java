package Items;
import AvatarPkg.*;

public abstract class Potion extends Item {

	//Variáveis
	//protected:
	protected int restorepts;

	//Métodos
	//public:
	public Potion(String newName, double newPrice, int newRestorePts) {
		super(newName, newPrice);
		restorepts = newRestorePts;
	}

	public Potion(Potion rhs) {
		super(rhs);
	}

	//Métodos Getter
	public int getRestorePts() {
		return restorepts;
	}
	/*Optei por não sobrecarregar a função getDefensePts() devido à como
	* a função grabItem em Avatar diferencia os ítens.
	*/
	public abstract void use(Avatar user);

}
