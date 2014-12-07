import Aux.*;
import AvatarPkg.*;
import java.util.Random;
import java.util.Vector;
import java.io.PrintStream;
import java.io.Serializable;

public class Team implements Serializable {

	//Variáveis
	//private:
	private String name;
	private Color color;
	private int win;
	private int lose;
	private int draw;
	private Vector<Avatar> characters;

	//Métodos
	//public:
	public Team(String newName, Color newColor) {
		name = newName;
		color = newColor;
		win = draw = lose = 0;
		characters = new Vector<Avatar>();
	}

	//Métodos Getter
	public String getName() {
		return name;
	}

	public String getResults() {
		return "Vitórias: " + win + "\nDerrotas: " + lose + "\nEmpate: " + draw + "\n";
	}

	public double getPoints() { //Retorna a média dos HPs dos personagens do time, que é a pontuação atual.
		int points = 0;
		for ( Avatar it : characters )
			points += it.getHP();
		return points / characters.size();
	}

	public String toString() {
		return "Time: " + name + "\nCor: " + color.getName() + "\n";
	}

	public String listAvatars() {
		int i = 0;
		String list = new String();

		for ( Avatar it : characters ) {
			list = list.concat( i + 1 + " - " + it.getName() + "\n" );
			++i;
		}

		return list;
	}

	//Esta resolveBattle dá resultados para ambas as classes, o que dispensa uma chamada para cada classe.
	//Retorno: 1 -> Vitória do time local, -1 -> Vitória do time oponente, 0 -> Empate
	//Optei também por batalhas aleatórias, já que não há interação do usuário.
	//Os turnos são limitados para que exista a possibilidade de empate,
	//já que um time nem todos os membros de um time devem morrer para o término da batalha.
	//A String output corresponde ao registro de eventos.
	public String resolveBattle(Team opponent) {
		//A contagem de mortes é utilizada a fim de dar fim à batalha.
		int localDeaths = 0,
			opponentDeaths = localDeaths,
			turnCounter = 1;
		String output = new String();
		Random dice = new Random();

		//Para que a possibilidade de empates ocorra, optei por limitar o número de turnos.
		while( turnCounter <= ( characters.size() * characters.size() * opponent.characters.size() )
				&& localDeaths < characters.size() && opponentDeaths < opponent.characters.size() ) {

			//Optamos por deixar esta impressão dentro da main a fim de
			System.err.println( "Thread atual: " + Thread.currentThread().getName() + "\n");

			if ( dice.nextDouble() > 0.5 )
			{
				output = output.concat("Turno: " + turnCounter + "\n");
				turnCounter++;
				//Seleciona um personagem aleatório do time local e um do oponente, o local ataca o oponente.
				output = output.concat(characters.elementAt( dice.nextInt(characters.size()) )
											    .attack( opponent.characters
																	 .elementAt(dice.nextInt(opponent.characters.size())))
								  );
			}
			if ( dice.nextDouble() > 0.5 )
			{
				output = output.concat("Turno: " + turnCounter + "\n");
				turnCounter++;
				//Seleciona um personagem aleatório do time oponente e um do local, o oponente ataca o local.
				output = output.concat(opponent.characters.elementAt( dice.nextInt(opponent.characters.size()) )
											                  .attack( characters.elementAt(dice.nextInt(characters.size())))
								  );
			}
		}
		if ( getPoints() < opponent.getPoints() ) { // Se o time local perdeu.
			++lose;
			++(opponent.win);
		}
		else if ( opponent.getPoints() < getPoints() ) { //Se o time local venceu
			++win;
			++(opponent.lose);
		}
		else {
			++draw;
			++(opponent.draw);
		}
		return output;
	}

	//Gerenciamento de personagens
	public void addChar(Avatar addedChar) {
		characters.addElement(addedChar);
	}

	public void removeChar(int pos) {
		if ( pos >=0 && pos < characters.size() )
			characters.remove(pos);
		else System.err.println( "Erro! Não há personagem na posição " + pos + "." );
	}

	public void removeChar(Avatar underRemoval) {
		for ( int i = 0; i < characters.size(); i++ ) {
			if ( characters.elementAt(i) == underRemoval ) {
				characters.remove(i);
				i = characters.size();
			}
		}
	}

	public Avatar searchChar(String charName) {
		for ( Avatar it : characters )
			if ( charName.compareTo( it.getName() ) == 0 )     return it;
		System.err.println( "Erro! Personagem não encontrado, retornando null" );
		return null;
	}

}
