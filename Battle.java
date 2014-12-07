import Aux.*;
import AvatarPkg.*;

/*	Classe Battle
			Classe responsável pelas batalhas entre os times.
		Implementada no padrão 'Bridge', possui times associados a cada batalha e faz a chamada para as lutas,
		que acontecem em 'resolveBattle()' na classe Team.
 */
public class Battle implements Runnable{

	private String battleName;
	private Team teamA;
	private Team teamB;
	//private int result; // Faz referência ao time vencedor da batalha. 
						// 1 -> Vitória de 'teamA; -1 -> Vitória de 'teamB'; 0 -> Empate ou batalha não ocorrida

	/* Construtor */
	public Battle (String name, Team teamA, Team teamB){
		this.battleName = name;
		this.teamA = teamA;
		this.teamB = teamB;
	}

	/* 	Método run() a ser executado quando a thread é iniciada. */
	public void run(){ 

		/* Batalhas acontecem entre os dois times, onde o atacante e o defensor são escolhidos randomicamente em 'resolveBattle()' */
		System.out.println( teamA.resolveBattle(this.teamB) );
	}

	public String getName() {
		return battleName;
	}
}
