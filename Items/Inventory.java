package Items;
import Aux.*;
import java.lang.Boolean;
import java.util.Vector;

public class Inventory {

	//Variáveis
	//private:
	private int spaces;
	private double gold;
	private Vector< Pair<Item, Boolean> > items;

	//Métodos
	//public:
	public Inventory(int newSpace, double newGold) {
		setSpaces(newSpace);
		if ( newSpace < 1 ) {
			System.err.println( "Erro! Você não pode definir um número de espaços menor que 1, definindo como 1" );
			newSpace = 1;
		}
		else    spaces = newSpace;
		items = new Vector< Pair<Item, Boolean> >();
	}

	//Métodos relacionados a space
	public int getAvailableSpace() {
		return spaces - items.size();
	}

	public void setSpaces(int newSpace) {
		if ( newSpace < 1 )     System.err.println( "Erro! Você não pode definir um número de espaços menor que 1" );
		else    spaces = newSpace;
	}

	//Métodos relacionados  gold
	public double getTotalGold() {
		return gold;
	}

	public void spendGold(double expenses) {
		if (expenses > gold)    System.err.println( "Erro! Você não não possui ouro suficiente." );
		else    gold -= expenses;
	}

	public void earnGold(double earning) {
		if ( earning < 0.0 )    System.err.println( "Erro! Você não pode receber uma quantidade de ouro menor que 0" );
		else gold += earning;
	}

	//Métodos relacionados a ítens
	public int getTotalAttPts() {
		int points = 0;
		//Como os ítens equipados são mantidos no fim e há apenas 3 no máximo, será uma busca linear eficiente.
		for( int i = items.size() - 1; i >= 0; i-- ) {
			if ( items.elementAt(i).second )	points += items.elementAt(i).first.getAttackPts();
			else i = -1;
		}
		return points;
	}

	public int getTotalDefPts() {
		int points = 0;
		//Como os ítens equipados são mantidos no fim e há apenas 3 no máximo, será uma busca linear eficiente.
		for( int i = items.size() - 1; i >= 0; i-- ) {
			if ( items.elementAt(i).second )	points += items.elementAt(i).first.getAttackPts();
			else i = -1;
		}
		return points;
	}

	public double getEquippedArmorWeight() {
		//Busca linearmente em ordem inversa porque os ítens equipados se encontram no fim do vetor.
		int i = items.size() - 1;
		while( i >= 0 && items.elementAt(i).second && items.elementAt(i).first.getAttackPts() > 0 ) --i;

		if ( i >= 0 && items.elementAt(i).second ) //Se há uma armadura equipada.
			return ((Armor)(items.elementAt(i).first)).getWeight();
		return 0.0;
	}

	public Item searchItem(String itemName) {
		for( Pair<Item, Boolean> it : items )
			if ( itemName.compareTo( it.first.getName() ) == 0 )     return it.first;
		System.err.println( "Erro! Ítem não encontrado, retornando null" );
		return null;
	}

	public Item searchItem(int itemPos) {
		if ( itemPos >= 0 && itemPos < items.size()  )      return items.elementAt(itemPos).first;
		System.err.println( "Erro! Ítem não encontrado, retornando null" );
		return null;
	}

	public int searchItem(Item item) {
		int i = 0;
		while ( i < items.size() && items.elementAt(i).first != item ) ++i;
		if ( i == items.size() )    return -1;
		return i;
	}

	public void insertItem(Item newItem, Boolean equip) {
		if ( getAvailableSpace() < 1 )
			System.err.println( "Erro! Não há espaço disponível no inventário." );
		//Se há espaço no inventário.
		else {
			if ( equip ) {
				 if ( newItem.getAttackPts() == 0 && newItem.getDefensePts() == 0 ) {
					System.err.println( "Erro! O ítem não é equipável." );
					equip = false;
				}
			}
			items.addElement( new Pair<Item, Boolean>(newItem, equip) );
			if ( !equip ) { //Se não pretendemos ou não podemos equipar o ítem, coloca em posição anterior aos ítens equipados.
				int i = items.size() - 2;
				while ( i >= 0 && items.elementAt(i).second )	--i;
				if ( i >= 0 ) { //Se há items equipados antes da posição deste elemento no vetor, troca-o de posição com o elemento inserido.
					items.add(items.size() - 1, items.elementAt(i) );
					items.elementAt(i).first = newItem;
					items.elementAt(i).second = equip;
				}
			}
		}
	}

	public void removeItem(String itemName) {
		int i = 0;
		while ( i < items.size() && ( itemName.compareTo( items.elementAt(i).first.getName() ) ) != 0 )
			++i;
		if ( i < items.size() )	items.remove(i);
	}

	public void removeItem(int itemPos) {
		if ( itemPos >= 0 && itemPos < items.size() )
			items.remove(itemPos);
		else System.err.println( "Erro! Não há item na posição " + itemPos + "." );
	}

	public void removeItem(Item toRemove) {
		for ( int i = 0; i < items.size(); i++ )
			if ( items.elementAt(i).first == toRemove )	items.remove(i);
	}

	public void equipItem(int itemPos) {
		if ( itemPos < 0 || itemPos >= items.size() )
			System.err.println( "Erro! Não há ítem na posição " + itemPos + "." );
		else if ( items.elementAt(itemPos).second )
			System.err.println( "Erro! O ítem já está equipado." );
		else {
			int count = 0;
			Item toEquip = items.elementAt(itemPos).first; //Salva o elemento.
			if ( items.elementAt(itemPos).first.getAttackPts() > 0 ) {
				//Busca armas, se houver mais de um equipada, pede para desequipar, senão, reinsere o elemento.
				for ( int i = items.size() - 1; i >= 0 && items.elementAt(i).second; i-- )
					if ( items.elementAt(i).first.getAttackPts() > 0 )    ++count;
				if ( count < 2 ) { //Se o número de armas equipadas for menor que 2.
					items.remove(itemPos); //Remove o elemento.
					items.addElement(new Pair<Item, Boolean>(toEquip, Boolean.TRUE )  ); //Reinsere o elemento.
				}
				else    System.err.println( "Erro! Desequipe uma arma antes de equipar uma nova!" );
			}
			else if ( items.elementAt(itemPos).first.getDefensePts() > 0 ) { //Se for uma armadura.
				int i = items.size() - 1;
				while(i >= 0 && items.elementAt(i).second && items.elementAt(i).first.getAttackPts() > 0 )
					--i;
				if ( i >= 0 && items.elementAt(i).second ) { //Se há uma armadura equipada, troca com a armadura nova.
					items.elementAt(i).second = false;
					items.add(itemPos, items.elementAt(i) );
					items.add(i, new Pair<Item, Boolean>(toEquip, Boolean.TRUE ) );
				}
				else { //Se não há armadura equipada, reinsere a armadura, marcando como equipada.
					items.remove(itemPos);
					items.addElement(new Pair<Item, Boolean>(toEquip, Boolean.TRUE ) );
				}
			}
			else //Se não for equipável
				System.err.println( "Erro! O ítem não é equipável." );
		}
	}

	public void unequipItem(int itemPos) {
		if ( itemPos < 0 || itemPos >= items.size() )
			System.err.println( "Erro! Não há ítem na posição " + itemPos );
		else if ( !(items.elementAt(itemPos).second) ) //Se não estiver equipado
			System.err.println( "Erro! O ítem não está equipado." );
		else {
			int i = itemPos - 1;
			items.elementAt(itemPos).second = false;
			while ( i >= 0 && items.elementAt(i).second ) //Busca elementos à esquerda que estão equipados.
				--i;
			if ( i >= 0 && items.elementAt(++i).second ) { //Se houver ítens equipados à esquerda.
				Pair<Item, Boolean> pairBuffer = items.elementAt(i); //Buffer para realizar o swap.
				items.add(i, items.elementAt(itemPos) );
				items.add(itemPos, pairBuffer);
			}
		}
	}

}
