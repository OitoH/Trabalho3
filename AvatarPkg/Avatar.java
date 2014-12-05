package AvatarPkg;

import Items.*;
import java.util.Random;

public abstract class Avatar {

	//Variáveis
	//protected:
	protected int constitution;
	protected int dexterity;
	protected int speed;
	protected int strength;
	protected int XP;

	//private:
	private int HP;
	private int MP;
	private String alias;
	private Inventory myitems;

	//Métodos
	//public:
	public Avatar(String name) {
		myitems = new Inventory(20, 50.0);
		alias = name;
		constitution = dexterity = speed = strength = 25;
		HP = 200;
		XP = 1;
		MP = 120;
	}

	public String getName() {
		return alias;
	}

	public String toString() {
		return ( getName() + "\nHP: " + getHP() + "\nMP: " + getMP()
				  + "\nConstitution: " + constitution + "\nDexterity: " + dexterity
				  + "\nSpeed: " + speed + "\nStrength: " + strength + "\n"
				);
	}

	//Métodos de combate
	public void attack(Avatar attackedAvatar) {
		int damage;
		double dice;
		Random rand = new Random();

		if ( HP == 0 )  System.out.println( this.getName() + " está morto e não pode atacar.\n" );
		else {
			System.out.println( this.getName() + " ataca " + attackedAvatar.getName() );

			if ( attackedAvatar.HP != 0 ) {
				dice = rand.nextDouble();
				System.err.println( "Valor no dado para o dano: " + dice );

				if ( dice > 1.0/(10.0 * XP) ) { //Se não ocorrer miss
					damage = this.getAttackPts() - attackedAvatar.getDefensePts() + ( rand.nextInt() % 11 - 5 );
					if ( damage < 1 )   damage = 1;
					dice = rand.nextDouble();
					System.err.println( "Valor no dado para critical: " + dice );
					if ( dice <= XP/100.0 ) {
						damage *= 2;  //Se ocorrer critical
						System.out.println( "Ataque crítico!!!");
					}
					System.out.println( "Dano: " + damage );
					attackedAvatar.addHP(0 - damage);
				}
				else System.out.println( "Errou!" );

				System.out.println( this.getName() + " HP: " + HP + "\n"
						+ attackedAvatar.getName() + " HP: " + attackedAvatar.HP + "\n" );
			}
			else System.out.println( attackedAvatar.getName()  + " já está morto." + "\n");
		}
	}

	//Métodos add
	public void addXP(int extraXP) {
		XP += extraXP;
		if ( XP > 100 )     XP = 100;
	}

	public void addHP(int extraHP) {
		HP += extraHP;
		if ( HP > 200 ) HP = 200;
		else if ( HP < 0 )   HP = 0;
	}

	public void addMP(int extraMP) {
		MP += extraMP;
		if ( MP > 120 ) MP = 120;
		else if ( MP < 0 )  MP = 0;
	}

	//Métodos Getter
	public int getHP() {
		return HP;
	}

	public int getMP() {
		return MP;
	}

	//Métodos Setter
	public void setConstitution(int newConstitution) {
		if ( newConstitution > 0 && newConstitution < 98 ) { //Define o valor do atributo e mantém os outros em equilíbrio.
			int aux = (newConstitution - constitution) / 3; //Armazena o incremento.
			//Se queremos aumentar este atributo devemos remover pontos dos outros.
			dexterity -= aux;
			speed -= aux;
			strength -= aux;
			aux = (newConstitution - constitution) % 3;
			constitution = newConstitution;
			//Podem haver pontos remanescentes, caso isso ocorra, aux != 0
			if ( aux != 0 ) {
				int temp;
				if ( newConstitution > constitution ) //Se houve um incremento em constitution.
					temp = -1;
				else //Se houve uma redução.
					temp = 1;
				dexterity += temp;
				--aux;
				if ( aux != 0 ) speed += temp;
			}
			//else Se não houve nem incremento nem redução, os pontos já foram equilibrados.
			constitution = newConstitution;
		}
		else
			System.err.println( "Erro ao definir constitution no personagem " + getName() + "mantendo valor atual." );
	}

	public void setDexterity(int newDexterity) {
		if ( newDexterity > 0 && newDexterity < 98 ) { //Define o valor do atributo e mantém os outros em equilíbrio.
			int aux = (newDexterity - dexterity) / 3; //Armazena o incremento.
			//Se queremos aumentar este atributo devemos remover pontos dos outros.
			constitution -= aux;
			speed -= aux;
			strength -= aux;
			aux = (newDexterity - dexterity) % 3;
			dexterity = newDexterity;
			//Podem haver pontos remanescentes, caso isso ocorra, aux != 0
			if ( aux != 0 ) {
				int temp;
				if ( newDexterity > dexterity ) //Se houve um incremento em dexterity.
					temp = -1;
				else //Se houve uma redução.
					temp = 1;
				constitution += temp;
				--aux;
				if ( aux != 0 ) speed += temp;
			}
			//else Se não houve nem incremento nem redução, os pontos já foram equilibrados.
			dexterity = newDexterity;
		}
		else
			System.err.println( "Erro ao definir dexterity no personagem " + getName() + "mantendo valor atual." );
	}

	public void setSpeed(int newSpeed) {
		if ( newSpeed > 0 && newSpeed < 98 ) { //Define o valor do atributo e mantém os outros em equilíbrio.
			int aux = (newSpeed - speed) / 3; //Armazena o incremento.
			//Se queremos aumentar este atributo devemos remover pontos dos outros.
			constitution -= aux;
			dexterity -= aux;
			strength -= aux;
			aux = (newSpeed - speed) % 3;
			speed = newSpeed;
			//Podem haver pontos remanescentes, caso isso ocorra, aux != 0
			if ( aux != 0 ) {
				int temp;
				if ( newSpeed > speed ) //Se houve um incremento em speed.
					temp = -1;
				else //Se houve uma redução em speed.
					temp = 1;
				constitution += temp;
				--aux;
				if ( aux != 0 ) dexterity += temp;
			}
			//else Se não houve nem incremento nem redução, os pontos já foram equilibrados.
			speed = newSpeed;
		}
		else
			System.err.println( "Erro ao definir speed no personagem " + getName() + "mantendo valor atual." );
	}

	public void setStrength(int newStrength) {
		if ( newStrength > 0 && newStrength < 98 ) { //Define o valor do atributo e mantém os outros em equilíbrio.
			int aux = (newStrength - strength) / 3; //Armazena o incremento.
			//Se queremos aumentar este atributo devemos remover pontos dos outros.
			constitution -= aux;
			dexterity -= aux;
			speed -= aux;
			aux = (newStrength - strength) % 3;
			strength = newStrength;
			//Podem haver pontos remanescentes, caso isso ocorra, aux != 0
			if ( aux != 0 ) {
				int temp;
				if ( newStrength > strength ) //Se houve um incremento em strength.
					temp = -1;
				else //Se houve uma redução.
					temp = 1;
				constitution += temp;
				--aux;
				if ( aux != 0 ) dexterity += temp;
			}
			//else Se não houve nem incremento nem redução, os pontos já foram equilibrados.
			strength = newStrength;
		}
		else
			System.err.println( "Erro ao definir strength no personagem " + getName() + "mantendo valor atual." );
	}

	//Funções relacionadas a ítens
	public void grabItem(Item item, Boolean equip) {
		myitems.insertItem( item, equip );
	}

	public void dropItem(Item toDrop) {
		//searchItem retorna um ponteiro para um iterador para a posição do item no vetor no inventário.
		int itemPos = myitems.searchItem(toDrop);
		if ( itemPos != -1 )
			myitems.removeItem(itemPos);
	}

	//protected
	//Métodos Getter
	protected int getAttackPts() {
		return new Double ( ( strength * 0.5 + dexterity * 0.3 + speed * 0.2 + myitems.getTotalAttPts() ) * XP/3 ).intValue();
	}

	protected int getDefensePts() {
		return new Double ( ( constitution * 0.5 + dexterity * 0.3 + speed * 0.2 + myitems.getTotalDefPts() ) * XP/2 ).intValue();
	}

	protected int getSpeed() {
		return new Double(speed * Math.exp ( (0 - Math.pow( myitems.getEquippedArmorWeight()/20.0, 2.0 ) ) )).intValue();
	}

}
