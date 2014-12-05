package Items.Potions;
import Items.Item;
import AvatarPkg.Avatar;

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

	public abstract void use(Avatar user);

}
