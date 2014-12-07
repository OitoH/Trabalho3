import Items.*;
import Items.Potions.*;
import Items.Weapons.*;
import Aux.*;
import AvatarPkg.*;
import java.util.*;

public class Exec {

	public static void main ( String... args ) {

		HealthPotion lightPotion = new HealthPotion( "Poção Leve", 1.99, 5 );
		HealthPotion whitePotion = new HealthPotion( "Poção Branca", 8.00, 15 );
		HealthPotion minorPotion = new HealthPotion( "Poção Menor",  14.00, 35 );
		HealthPotion greatPotion = new HealthPotion( "Poção Maior", 40.00, 50 );
		HealthPotion maximaPotion = new HealthPotion(  "Poção Máxima", 60.00, 100 );

		ManaPotion energyPotion = new ManaPotion( "Poção de Energia", 5.00, 10 );
		ManaPotion spiritPotion = new ManaPotion( "Poção Espirtual", 23.25, 20 );
		ManaPotion elixir = new ManaPotion( "Elixir", 100.00, 60 );

		Armor leatherArmor = new Armor( "Armadura de Pano", 5.50, 2, 1.00);
		Armor lightArmor = new Armor( "Armadura Leve", 10.00, 5, 4.00);
		Armor fullMetalArmor = new Armor( "Armadura de Metal", 35.00, 10, 8.00);
		Armor steelArmor = new Armor( "Armadura de Aço", 60.50, 15, 18.50);
		Armor magicArmor = new Armor( "Armadura Mágica ", 200.0, 18, 5.0);
		Armor goldenArmor = new Armor( "Armadura Dourada", 300.0, 20, 20.0);

		Weapon knife = new Weapon( "Faca", 1.00, 1 );
		Weapon staff = new Weapon( "Cajado", 5.0, 1 );
		Weapon hashis = new Weapon( "Hashis Mágicos", 15.00, 8 );
		Weapon maca = new Weapon( "Maça", 10.0, 4 );
		Weapon lance = new Weapon( "Lança", 5.00, 3 );
		Weapon metalLance = new Weapon( "Lança Metálica", 12.50, 5 );
		Weapon shortSword = new Weapon( "Espada Curta", 8.00, 5 );
		Weapon longSword = new Weapon( "Espada Longa", 14.00, 7 );
		Weapon sparda = new Weapon( "Sparda", 183.35, 8 );
		Weapon excalibur = new Weapon( "Excalibur", 550.00, 9 );

		// Time Foo
		// ===========================================================================================

		Team fooTeam = new Team( "Masters of the fooland", Color.GREEN );

		Knight fooLancer = new Knight( "Lanceiro Foo", 40 );
		fooLancer.grabItem( new Weapon(lance), true );
		fooLancer.grabItem( new Armor(steelArmor), true );
		fooLancer.grabItem( new HealthPotion(lightPotion), false );
		fooLancer.grabItem( new HealthPotion(lightPotion), false );
		fooLancer.addXP(30);
		fooLancer.setDexterity(30);
		fooLancer.setStrength(45);
		fooLancer.addPower(37);

		Knight fooFighter = new Knight( "Foofigther", 28 );
		fooFighter.grabItem( new Weapon(maca), true );
		fooFighter.grabItem( new HealthPotion(greatPotion), false );
		fooFighter.grabItem( new HealthPotion(maximaPotion), false );
		fooFighter.grabItem( new Armor(lightArmor), true );
		fooFighter.addXP(45);
		fooFighter.setConstitution(40);
		fooFighter.setStrength(32);

		Wizard fooMage = new Wizard( "Mágico Foo", 22 );
		fooMage.grabItem( new Armor(magicArmor), true );
		fooMage.grabItem( new HealthPotion(minorPotion), false );
		fooMage.grabItem( new ManaPotion(elixir), false );
		fooMage.grabItem( new ManaPotion(energyPotion), false );
		fooMage.grabItem( new Weapon(staff), true );
		fooMage.addXP(33);
		fooMage.setConstitution(38);
		fooMage.setSpeed(30);

		Thief fooThief = new Thief( "Ladino Foo", 45 );
		fooThief.grabItem( new Weapon(knife), true );
		fooThief.grabItem( new Weapon(knife), true );
		fooThief.grabItem( new Armor(leatherArmor), true );
		fooThief.grabItem( new HealthPotion(minorPotion), false );
		fooThief.grabItem( new HealthPotion(minorPotion), false );
		fooThief.addXP(45);

		fooTeam.addChar( fooLancer );
		fooTeam.addChar( fooFighter );
		fooTeam.addChar( fooMage );
		fooTeam.addChar( fooThief );

		// Time Bar
		// ===========================================================================================

		Team barTeam = new Team( "Time Bar", Color.RED );

		Thief barLeader = new Thief( "Líder Bar", 30 );
		barLeader.grabItem( new Armor(fullMetalArmor), true );
		barLeader.grabItem( new Weapon(shortSword), true );
		barLeader.grabItem( new Weapon(shortSword), true );
		barLeader.grabItem( new HealthPotion(whitePotion), false );
		barLeader.addXP(40);
		barLeader.setDexterity(40);
		barLeader.setConstitution(28);

		Wizard barJap = new Wizard( "Jap Bar", 6 );
		barJap.grabItem( new Armor(goldenArmor), true );
		barJap.grabItem( new Weapon(hashis), true );
		barJap.grabItem( new Weapon(hashis), true );
		barJap.grabItem( new ManaPotion(elixir), false );
		barJap.addXP(30);
		barJap.setSpeed(40);
		barJap.addWisdom(50);

		Knight barSeker = new Knight( "BarSeker", 17 );
		barSeker.grabItem( new Armor(fullMetalArmor), true );
		barSeker.grabItem( new Weapon(maca), true );
		barSeker.grabItem( new Weapon(maca), true );
		barSeker.grabItem( new HealthPotion(greatPotion), false );
		barSeker.addXP(40);
		barSeker.setConstitution( 60 );
		barSeker.setStrength( 50 );

		Thief barLadin = new Thief( "Barladino", 6 );
		barLadin.grabItem( new Armor(fullMetalArmor), true );
		barLadin.grabItem( new Weapon(knife), true );
		barLadin.grabItem( new Weapon(knife), true );
		barLadin.grabItem( new HealthPotion(greatPotion), false );
		barLadin.addXP(30);
		barLadin.setDexterity(30);
		barLadin.setSpeed(40);
		barLadin.addStealth(33);

		barTeam.addChar(barLeader);
		barTeam.addChar(barJap);
		barTeam.addChar(barSeker);
		barTeam.addChar(barLadin);

		// Time Vila
		// ===========================================================================================

		Team vilaTeam = new Team( "A Vila", Color.YELLOW );

		Knight vilaLancer = new Knight( "Seu Madruga", 40 );
		vilaLancer.grabItem( new Weapon(lance), true );
		vilaLancer.grabItem( new Armor(steelArmor), true );
		vilaLancer.grabItem( new HealthPotion(lightPotion), false );
		vilaLancer.grabItem( new HealthPotion(lightPotion), false );
		vilaLancer.addXP(30);
		vilaLancer.setDexterity(30);
		vilaLancer.setStrength(45);
		vilaLancer.addPower(37);

		Knight vilaFighter = new Knight( "Jaiminho, o carteiro de Tangamandápio", 28 );
		vilaFighter.grabItem( new Weapon(maca), true );
		vilaFighter.grabItem( new HealthPotion(greatPotion), false );
		vilaFighter.grabItem( new HealthPotion(maximaPotion), false );
		vilaFighter.grabItem( new Armor(lightArmor), true );
		vilaFighter.addXP(45);
		vilaFighter.setConstitution(40);
		vilaFighter.setStrength(32);

		Wizard vilaMage = new Wizard( "Bruxa do 71", 22 );
		vilaMage.grabItem( new Armor(magicArmor), true );
		vilaMage.grabItem( new HealthPotion(minorPotion), false );
		vilaMage.grabItem( new ManaPotion(elixir), false );
		vilaMage.grabItem( new ManaPotion(energyPotion), false );
		vilaMage.grabItem( new Weapon(staff), true );
		vilaMage.addXP(33);
		vilaMage.setConstitution(38);
		vilaMage.setSpeed(30);

		Thief vilaThief = new Thief( "Chaves, do 8", 45 );
		vilaThief.grabItem( new Weapon(knife), true );
		vilaThief.grabItem( new Weapon(knife), true );
		vilaThief.grabItem( new Armor(leatherArmor), true );
		vilaThief.grabItem( new HealthPotion(minorPotion), false );
		vilaThief.grabItem( new HealthPotion(minorPotion), false );
		vilaThief.addXP(45);

		vilaTeam.addChar( vilaLancer );
		vilaTeam.addChar( vilaFighter );
		vilaTeam.addChar( vilaMage );
		vilaTeam.addChar( vilaThief );

		// Time Brigada
		// ===========================================================================================
		Team brigadaTeam = new Team( "Time Brigada dos Encapotados", Color.BLACK );

		Thief brigadaJohn = new Thief( "John Constantine", 20 );
		brigadaJohn.grabItem( new Armor(fullMetalArmor), true );
		brigadaJohn.grabItem( new Weapon(shortSword), true );
		brigadaJohn.grabItem( new Weapon(shortSword), true );
		brigadaJohn.grabItem( new HealthPotion(whitePotion), false );
		brigadaJohn.addXP(40);
		brigadaJohn.setDexterity(40);
		brigadaJohn.setConstitution(28);

		Wizard brigadaIo = new Wizard( "Mister Io", 5 );
		brigadaIo.grabItem( new Armor(goldenArmor), true );
		brigadaIo.grabItem( new Weapon(hashis), true );
		brigadaIo.grabItem( new Weapon(hashis), true );
		brigadaIo.grabItem( new ManaPotion(elixir), false );
		brigadaIo.addXP(30);
		brigadaIo.setSpeed(40);
		brigadaIo.addWisdom(50);

		Knight brigadaOculto = new Knight( "Doutor Oculto", 18 );
		brigadaOculto.grabItem( new Armor(fullMetalArmor), true );
		brigadaOculto.grabItem( new Weapon(maca), true );
		brigadaOculto.grabItem( new Weapon(maca), true );
		brigadaOculto.grabItem( new HealthPotion(greatPotion), false );
		brigadaOculto.addXP(40);
		brigadaOculto.setConstitution( 60 );
		brigadaOculto.setStrength( 50 );

		Thief brigadaVingador = new Thief( "Vingador Fantasma", 9 );
		brigadaVingador.grabItem( new Armor(fullMetalArmor), true );
		brigadaVingador.grabItem( new Weapon(knife), true );
		brigadaVingador.grabItem( new Weapon(knife), true );
		brigadaVingador.grabItem( new HealthPotion(greatPotion), false );
		brigadaVingador.addXP(30);
		brigadaVingador.setDexterity(30);
		brigadaVingador.setSpeed(40);
		brigadaVingador.addStealth(33);

		brigadaTeam.addChar(brigadaJohn);
		brigadaTeam.addChar(brigadaIo);
		brigadaTeam.addChar(brigadaOculto);
		brigadaTeam.addChar(brigadaVingador);

		// Batalhas e Threads
		// ===========================================================================================

		Battle battle1;
		Battle battle2;

		Thread t1;
		Thread t2;

		int buffer;
		String strBuffer;
		NetworkMatch onlineMatch;
		Scanner input = new Scanner(System.in);
		System.out.println( "Opções disponíveis:\n" +
									"1 - Iniciar as batalhas\n" +
									"2 - Hospedar partida pela rede usando o time foo\n" +
									"3 - Conectar-se a uma partida pela rede usando o time bar\n" +
									"Digite a opção desejada:\t"
						   );
		try{
			buffer = input.nextInt();
			switch(buffer) {
				case 1:
					battle1 = new Battle("Duelo 1", fooTeam, barTeam);
					battle2 = new Battle("Duelo 2", vilaTeam, brigadaTeam);

					t1 = new Thread( battle1, "Thread - " + battle1.getName() );
					t2 = new Thread( battle2, "Thread - " + battle2.getName() );

					t1.start();
					t2.start();

					t1.join();
					t2.join();

					System.out.println( barTeam.toString() + barTeam.getResults() );
					System.out.println( fooTeam.toString() + fooTeam.getResults() );
					System.out.println( vilaTeam.toString() + vilaTeam.getResults() );
					System.out.println( brigadaTeam.toString() + brigadaTeam.getResults() );
					break;
				case 2:
					onlineMatch = new NetworkMatch(fooTeam);
					System.out.println("Digite uma porta para a conexão:\t");
					buffer = input.nextInt();
					onlineMatch.host(buffer);
					break;
				case 3:
					System.out.println("Digite o endereço (IP ou domínio) do servidor:\t");
					strBuffer = input.next();
					System.out.println("Digite a porta para conexão com o servidor:\t");
					buffer = input.nextInt();
					onlineMatch = new NetworkMatch(barTeam);
					onlineMatch.connect(strBuffer, buffer);
					break;
				default:
					break;
			}
		}catch(InterruptedException e){
			System.err.println("Thread abortada durante atividade: " + e.getMessage() );
		}catch(InputMismatchException e) {
			System.err.println("Entrada inválida: " + e.getMessage());
		}catch(NoSuchElementException e) {
			System.err.println("Entrada inválida: " + e.getMessage());
		}
	}

}
