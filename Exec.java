import Items.*;
import Aux.*;
import AvatarPkg.*;

import java.lang.System;

public class Exec {

	public static void main ( String [] args ) {

		HealthPotion lightPotion = new HealthPotion( "Poção Leve", 1.99, 5 );
		HealthPotion whitePotion = new HealthPotion( "Poção Branca", 8.00, 15 );
		HealthPotion minorPotion = new HealthPotion( "Poção Menor",  14.00, 35 );
		HealthPotion greatPotion = new HealthPotion( "Poção Maior", 40.00, 50 );
		HealthPotion maximaPotion = new HealthPotion(  "Poção Máxima", 60.00, 100 );

		ManaPotion energyPotion = new ManaPotion( "Poção de Energia", 5.00, 10 );
		ManaPotion spiritPotion = new ManaPotion( "Poção Espirtual", 23.25, 20 );
		ManaPotion elixir = new ManaPotion( "Elixir", 100.00, 60 );

		Armor leatherArmor = new Armor( "Armadura de Pano", 2.50, 2, 1.00);
		Armor lightArmor = new Armor( "Armadura Leve", 10.00, 5, 4.00);
		Armor fullMetalArmor = new Armor( "Armadura de Metal", 35.00, 10, 8.00);
		Armor steelArmor = new Armor( "Armadura de Aço", 60.50, 15, 18.50);
		Armor magicArmor = new Armor( "Armadura Mágica ", 200.0, 18, 5.0);
		Armor goldenArmor = new Armor( "Armadura Dourada", 300.0, 20, 20.0);

		Weapon knife = new Weapon( "Knife", 1.00, 1, 1.0 );
		Weapon staff = new Weapon( "Cajado", 5.0, 1, 1.0 );
		Weapon hashis = new Weapon( "Hashis Mágicos", 15.00, 8, 1.0 );
		Weapon maca = new Weapon( "Maça", 10.0, 4, 1.0 );
		Weapon lance = new Weapon( "Lança", 5.00, 3, 3.0 );
		Weapon metalLance = new Weapon( "Lança Metálica", 12.50, 5, 3.0 );
		Weapon shortSword = new Weapon( "Espada Curta", 8.00, 5, 1.0 );
		Weapon longSword = new Weapon( "Espada Longa", 14.00, 7, 2.0 );
		Weapon sparda = new Weapon( "Sparda", 183.35, 8, 1.0 );
		Weapon excalibur = new Weapon( "Excalibur", 550.00, 9, 1.0 );

		// Time Foo
		// Os objetos character serão deletados pela classe Team, não sendo necessário desalocar a memória na main.
		Team fooTeam = new Team( "Masters of the fooland", Color.GREEN );

		Knight fooLancer = new Knight( "Lanceiro Foo", 8 );
		fooLancer.grabItem( new Weapon(lance), true );
		fooLancer.grabItem( new Armor(steelArmor), true );
		fooLancer.grabItem( new HealthPotion(lightPotion), false );
		fooLancer.grabItem( new HealthPotion(lightPotion), false );
		fooLancer.addXP(30);

		Knight fooFighter = new Knight( "Foofigther", 10 );
		fooFighter.grabItem( new Weapon(maca), true );
		fooFighter.grabItem( new HealthPotion(greatPotion), false );
		fooFighter.grabItem( new HealthPotion(maximaPotion), false );
		fooFighter.grabItem( new Armor(lightArmor), true );
		fooLancer.addXP(45);

		Wizard fooMage = new Wizard( "Mágico Foo", 8 );
		fooMage.grabItem( new Armor(magicArmor), true );
		fooMage.grabItem( new HealthPotion(minorPotion), false );
		fooMage.grabItem( new ManaPotion(elixir), false );
		fooMage.grabItem( new ManaPotion(energyPotion), false );
		fooMage.grabItem( new Weapon(staff), true );
		fooMage.addXP(33);

		Thief fooThief = new Thief( "Ladino Foo", 5 );
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
		Team barTeam = new Team( "Time Bar", Color.RED );

		Thief barLeader = new Thief( "Líder Bar", 9 );
		barLeader.grabItem( new Armor(fullMetalArmor), true );
		barLeader.grabItem( new Weapon(shortSword), true );
		barLeader.grabItem( new Weapon(shortSword), true );
		barLeader.grabItem( new HealthPotion(whitePotion), false );
		barLeader.addXP(40);

		Wizard barJap = new Wizard( "Jap Bar", 6 );
		barJap.grabItem( new Armor(goldenArmor), true );
		barJap.grabItem( new Weapon(hashis), true );
		barJap.grabItem( new Weapon(hashis), true );
		barJap.grabItem( new ManaPotion(elixir), false );
		barJap.addXP(30);

		Knight barSeker = new Knight( "BarSeker", 9 );
		barSeker.grabItem( new Armor(fullMetalArmor), true );
		barSeker.grabItem( new Weapon(maca), true );
		barSeker.grabItem( new Weapon(maca), true );
		barSeker.grabItem( new HealthPotion(greatPotion), false );
		barSeker.addXP(40);

		Thief barLadin = new Thief( "Barladino", 6 );
		barLadin.grabItem( new Armor(fullMetalArmor), true );
		barLadin.grabItem( new Weapon(knife), true );
		barLadin.grabItem( new Weapon(knife), true );
		barLadin.grabItem( new HealthPotion(greatPotion), false );
		barLadin.addXP(30);

		barTeam.addChar(barLeader);
		barTeam.addChar(barJap);
		barTeam.addChar(barSeker);
		barTeam.addChar(barLadin);

		barTeam.resolveBattle(fooTeam);
		System.out.println( barTeam.toString() + barTeam.getResults() );
		System.out.println( fooTeam.toString() + fooTeam.getResults() );

	}

}
