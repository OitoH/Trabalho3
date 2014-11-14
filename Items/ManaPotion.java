package Items;
import AvatarPkg.*;

public class ManaPotion extends Potion {

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
