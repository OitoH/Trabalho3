import Items.*;
import Items.Potions.*;
import Items.Weapons.*;
import Aux.*;
import AvatarPkg.*;
import java.util.*;

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
		fooLancer.addXP(45);
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

		barTeam.resolveBattle(fooTeam);
		System.out.println( barTeam.toString() + barTeam.getResults() );
		System.out.println( fooTeam.toString() + fooTeam.getResults() );

	}

}
