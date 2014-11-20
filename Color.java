import java.util.ArrayList;

public enum Color {

	//Variáveis
	//private
	private int rgba;
	private String name;
	private static ArrayList<Color> colorArray;

	//public
	BLUE ( "Azul", 0, 0, 255, 0 ),
	RED ( "Vermelho", 255, 0, 0, 0 ),
	GREEN ( "Verde", 0, 255, 0, 0 ),
	YELLOW ( "Amarelo", 255, 255, 0, 0 ),
	WHITE ( "Branco", 255, 255, 255, 0 ),
	BLACK ( "Preto", 0, 0, 0, 0 );

	//Métodos
	//public
	Color(String newName, int red, int green, int blue, int alpha) {
		name = newName;
		if ( red > 255 )
		{
			System.err.println( "Valor para canal vermelho excede o máximo, atribuindo valor máximo: " + 255 );
			red = 255;
		}
		if ( green > 255 )
		{
			System.err.println( "Valor para canal verde excede o máximo, atribuindo valor máximo: " + 255 );
			green = 255;
		}
		if ( blue > 255 )
		{
			System.err.println( "Valor para canal azul excede o máximo, atribuindo valor máximo: " + 255 );
			blue = 255;
		}
		if ( alpha > 255 )
		{
			System.err.println( "Valor para canal alfa excede o máximo, atribuindo valor máximo: " + 255 );
			alpha = 255;
		}
		rgba = ( red << 24 ) + ( green << 16 ) + ( blue << 8 ) + ( alpha );
		colorArray.add(this);
	}

	public static Color[] getColorList() { return colorArray.toArray(); }

	public String getColorName() { return name; }

	public int getRGBA() { return rgba; }

}
