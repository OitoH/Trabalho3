import java.util.ArrayList;

public enum Color {

	BLUE ( "Azul", 0, 0, 255, 0 ),
	RED ( "Vermelho", 255, 0, 0, 0 ),
	GREEN ( "Verde", 0, 255, 0, 0 ),
	YELLOW ( "Amarelo", 255, 255, 0, 0 ),
	WHITE ( "Branco", 255, 255, 255, 0 ),
	BLACK ( "Preto", 0, 0, 0, 0 );

	private Color(String newName, int red, int green, int blue, int alpha) {
		name = newName;

		if ( red > 255 )
		{
			red = 255;
			System.err.println( "Valor para canal vermelho excede o máximo, atribuindo valor máximo: " + red );
		}
		else if ( red < 0 )
		{
			red = 0;
			System.err.println( "Valor para canal vermelho abaixo do mínimo, atribuindo valor mínimo: " + red );
		}

		if ( green > 255 )
		{
			green = 255;
			System.err.println( "Valor para canal verde excede o máximo, atribuindo valor máximo: " + green );
		}
		else if ( green < 0 )
		{
			green = 0;
			System.err.println( "Valor para canal verde abaixo do mínimo, atribuindo valor mínimo: " + green );
		}

		if ( blue > 255 )
		{
			blue = 255;
			System.err.println( "Valor para canal azul excede o máximo, atribuindo valor máximo: " + blue );
		}
		else if ( blue < 0 )
		{
			blue = 0;
			System.err.println( "Valor para canal azul abaixo do mínimo, atribuindo valor mínimo: " + blue );
		}

		if ( alpha > 255 )
		{
			alpha = 255;
			System.err.println( "Valor para canal alfa excede o máximo, atribuindo valor máximo: " + alpha );
		}
		else if ( alpha < 0 )
		{
			alpha = 0;
			System.err.println( "Valor para canal alfa abaixo do mínimo, atribuindo valor mínimo: " + alpha );
		}

		rgba = ( red << 24 ) + ( green << 16 ) + ( blue << 8 ) + ( alpha );
	}

	//Variáveis
	//private
	private int rgba;
	private String name;

	//Métodos
	//public
	public String getName() { return name; }

	public int getRGBA() { return rgba; }

}
