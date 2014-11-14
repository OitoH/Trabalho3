public enum Color {

	BLUE ( 0, 0, 255, 0 ),
	RED ( 255, 0, 0, 0 ),
	GREEN ( 0, 255, 0, 0 ),
	YELLOW ( 255, 255, 0, 0 ),
	WHITE ( 255, 255, 255, 0 ),
	BLACK ( 0, 0, 0, 0 );

	Color(int red, int green, int blue, int alpha) {
		rgba = ( red << 24 ) + ( green << 16 ) + ( blue << 8 ) + ( alpha );
	}

	public static String getColorName(Color color) {
		switch(color) {
			case BLUE:
				return "Azul";
			case RED:
				return "Vermelho";
			case GREEN:
				return "Verde";
			case YELLOW:
				return "Amarelo";
			case WHITE:
				return "Branco";
			case BLACK:
				return "Preto";
			default:
				return "Cor indisponível";
		}
	}

	public int getRGBA() { return rgba; }

	private int rgba;

}
