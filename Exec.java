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

		fooTeam.addChar( fooLancer );
		fooTeam.addChar( fooFighter );
		fooTeam.addChar( fooMage );

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
		brigadaTeam.addChar(brigadaVingador);

		// Time Mestres
		// ===========================================================================================

		Team mestreTeam = new Team( "Time dos Mestres", Color.WHITE );

		Wizard mestreWizard = new Wizard( "Mestre dos Magos", 6 );
		mestreWizard.grabItem( new Armor(goldenArmor), true );
		mestreWizard.grabItem( new Weapon(hashis), true );
		mestreWizard.grabItem( new Weapon(hashis), true );
		mestreWizard.grabItem( new ManaPotion(elixir), false );
		mestreWizard.addXP(30);
		mestreWizard.setSpeed(40);
		mestreWizard.addWisdom(50);

		Thief mestreThief = new Thief( "Master Chief", 45 );
		mestreThief.grabItem( new Weapon(knife), true );
		mestreThief.grabItem( new Weapon(knife), true );
		mestreThief.grabItem( new Armor(leatherArmor), true );
		mestreThief.grabItem( new HealthPotion(minorPotion), false );
		mestreThief.grabItem( new HealthPotion(minorPotion), false );
		mestreThief.addXP(45);

		Knight mestreKnight = new Knight( "Mestre Kame", 28 );
		mestreKnight.grabItem( new Weapon(maca), true );
		mestreKnight.grabItem( new HealthPotion(greatPotion), false );
		mestreKnight.grabItem( new HealthPotion(maximaPotion), false );
		mestreKnight.grabItem( new Armor(lightArmor), true );
		mestreKnight.addXP(45);
		mestreKnight.setConstitution(40);
		mestreKnight.setStrength(32);

		mestreTeam.addChar(mestreWizard);
		mestreTeam.addChar(mestreThief);
		mestreTeam.addChar(mestreKnight);


		// Time Error
		// ===========================================================================================
		Team errorTeam = new Team( "Time dos Erros", Color.GREEN );

		Knight stackError = new Knight( "StackOverflow", 28 );
		stackError.grabItem( new Weapon(maca), true );
		stackError.grabItem( new HealthPotion(greatPotion), false );
		stackError.grabItem( new HealthPotion(maximaPotion), false );
		stackError.grabItem( new Armor(lightArmor), true );
		stackError.addXP(45);
		stackError.setConstitution(40);
		stackError.setStrength(32);

		Wizard nullMage = new Wizard( "NullPointerException", 22 );
		nullMage.grabItem( new Armor(magicArmor), true );
		nullMage.grabItem( new HealthPotion(minorPotion), false );
		nullMage.grabItem( new ManaPotion(elixir), false );
		nullMage.grabItem( new ManaPotion(energyPotion), false );
		nullMage.grabItem( new Weapon(staff), true );
		nullMage.addXP(33);
		nullMage.setConstitution(38);
		nullMage.setSpeed(30);
		
		Thief thief404 = new Thief( "404 Error", 45 );
		thief404.grabItem( new Weapon(knife), true );
		thief404.grabItem( new Weapon(knife), true );
		thief404.grabItem( new Armor(leatherArmor), true );
		thief404.grabItem( new HealthPotion(minorPotion), false );
		thief404.grabItem( new HealthPotion(minorPotion), false );
		thief404.addXP(45);
		
		errorTeam.addChar(stackError);
		errorTeam.addChar(nullMage);
		errorTeam.addChar(thief404);



		// Time Magos
		// ===========================================================================================
		Team mageTeam = new Team( "Time dos Magos", Color.BLACK );

		Wizard alanMage = new Wizard( "Alan Moore", 22 );
		alanMage.grabItem( new Armor(magicArmor), true );
		alanMage.grabItem( new HealthPotion(minorPotion), false );
		alanMage.grabItem( new ManaPotion(elixir), false );
		alanMage.grabItem( new ManaPotion(energyPotion), false );
		alanMage.grabItem( new Weapon(staff), true );
		alanMage.setConstitution(38);
		alanMage.setSpeed(30);
		alanMage.addXP(33);


		Wizard coelhoMage = new Wizard( "Paulo Coelho", 22 );
		coelhoMage.grabItem( new Armor(magicArmor), true );
		coelhoMage.grabItem( new HealthPotion(minorPotion), false );
		coelhoMage.grabItem( new ManaPotion(elixir), false );
		coelhoMage.grabItem( new ManaPotion(energyPotion), false );
		coelhoMage.grabItem( new Weapon(staff), true );
		coelhoMage.addXP(30);
		coelhoMage.setConstitution(34);
		coelhoMage.setSpeed(27);

		Wizard crowleyMage = new Wizard( "Aleister Crowley", 22 );
		crowleyMage.grabItem( new Armor(magicArmor), true );
		crowleyMage.grabItem( new HealthPotion(minorPotion), false );
		crowleyMage.grabItem( new ManaPotion(elixir), false );
		crowleyMage.grabItem( new ManaPotion(energyPotion), false );
		crowleyMage.grabItem( new Weapon(staff), true );
		crowleyMage.setConstitution(38);
		crowleyMage.setSpeed(30);
		crowleyMage.addXP(22);
		
		mageTeam.addChar(alanMage);
		mageTeam.addChar(coelhoMage);
		mageTeam.addChar(crowleyMage);

		// Time Metalinguistico
		// ===========================================================================================
		Team metaTeam = new Team( "Time este não não é um time", Color.BLACK );

		Thief objThief = new Thief( "Referencia para um objeto da classe Thief", 20 );
		objThief.grabItem( new Armor(fullMetalArmor), true );
		objThief.grabItem( new Weapon(shortSword), true );
		objThief.grabItem( new Weapon(shortSword), true );
		objThief.grabItem( new HealthPotion(whitePotion), false );
		objThief.addXP(40);
		objThief.setDexterity(40);
		objThief.setConstitution(28);		

		Knight niilistaKnight = new Knight( "Se você parar pra pensar eu não existo", 17 );
		niilistaKnight.grabItem( new Armor(fullMetalArmor), true );
		niilistaKnight.grabItem( new Weapon(maca), true );
		niilistaKnight.grabItem( new Weapon(maca), true );
		niilistaKnight.grabItem( new HealthPotion(greatPotion), false );
		niilistaKnight.addXP(40);
		niilistaKnight.setConstitution( 60 );
		niilistaKnight.setStrength( 50 );

		Thief conhecidoThief = new Thief( "Aquele que você sabe quem é", 45 );
		conhecidoThief.grabItem( new Weapon(knife), true );
		conhecidoThief.grabItem( new Weapon(knife), true );
		conhecidoThief.grabItem( new Armor(leatherArmor), true );
		conhecidoThief.grabItem( new HealthPotion(minorPotion), false );
		conhecidoThief.grabItem( new HealthPotion(minorPotion), false );
		conhecidoThief.addXP(45);

		metaTeam.addChar(objThief);
		metaTeam.addChar(niilistaKnight);
		metaTeam.addChar(conhecidoThief);

		// Batalhas e Threads
		// ===========================================================================================

		Battle battle1;
		Battle battle2;
		Battle battle3;
		Battle battle4;

		Thread t1;
		Thread t2;
		Thread t3;
		Thread t4;

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
					battle3 = new Battle("Duelo 3", mestreTeam, errorTeam);
					battle4 = new Battle("Duelo 4", mageTeam, metaTeam);


					t1 = new Thread( battle1, "Thread - " + battle1.getName() );
					t2 = new Thread( battle2, "Thread - " + battle2.getName() );
					t3 = new Thread( battle3, "Thread - " + battle3.getName() );
					t4 = new Thread( battle4, "Thread - " + battle4.getName() );

					t1.start();
					t2.start();
					t3.start();
					t4.start();

					t1.join();
					t2.join();
					t3.join();
					t4.join();

					System.out.println( barTeam.toString() + barTeam.getResults() );
					System.out.println( fooTeam.toString() + fooTeam.getResults() );

					System.out.println( vilaTeam.toString() + vilaTeam.getResults() );
					System.out.println( brigadaTeam.toString() + brigadaTeam.getResults() );

					System.out.println( mestreTeam.toString() + mestreTeam.getResults() );
					System.out.println( errorTeam.toString() + errorTeam.getResults() );
			
					System.out.println( mageTeam.toString() + mageTeam.getResults() );
					System.out.println( metaTeam.toString() + metaTeam.getResults() );
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
