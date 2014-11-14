package Items;
import AvatarPkg.*;

public class HealthPotion extends Potion {

	//public:
	public HealthPotion(String newName, double newPrice, int newRestorePts) {
		super(newName, newPrice, newRestorePts);
	}

	public HealthPotion(HealthPotion rhs) {
		super(rhs);
	}

	public void use(Avatar user) {
		user.addHP(restorepts);
		user.dropItem(this);
	}

}
