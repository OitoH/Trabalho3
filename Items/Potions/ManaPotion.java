package Items.Potions;
import AvatarPkg.Avatar;

public class ManaPotion extends Potion {

	//Métodos
	//public:
	public ManaPotion(String newName, double newPrice, int newRestorePts) {
		super(newName, newPrice, newRestorePts);
	}

	public ManaPotion(ManaPotion rhs) {
		super(rhs);
	}

	public void use(Avatar user) {
		user.addMP(restorepts);
		user.dropItem(this);
	}

}
