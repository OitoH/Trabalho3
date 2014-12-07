package AvatarPkg;

public class Archer extends Avatar {

    protected double accuracy;

    public Archer(String newName, double newAccuracy) {
        super(newName);
        setAccuracy(newAccuracy);
    }

    private void setAccuracy(double newAccuracy) {
        if ( newAccuracy >= 0.05 && newAccuracy <= 0.9 )
            accuracy = newAccuracy;
        else {
            accuracy = 0.3;
            System.err.println( "Erro! A precisão de um arqueiro não pode assumir o valor: "
                                        + newAccuracy + "\nAtribuindo o valor padrão: " + accuracy
                                      );
        }
    }

    public void addAccuracy(double increase) {
        accuracy += increase;
        if ( accuracy < 0.05 ) {
            accuracy = 0.05;
            System.err.println( "Erro! A precisão de um arqueiro não pode ser menor que 0.05, atribuindo o valor: "
                                        + accuracy;
                                      )
        }
        else if ( accuracy > 0.9 ) {
            accuracy = 0.9;
            System.err.println( "Erro! A precisão de um arqueiro não pode ser maior que 0.9, atribuindo o valor: "
                                        + accuracy;
                                      )
        }
    }

    public int getAttackPts() {
        int extraPts = 0;
        Random dice = new Random();
        if ( dice.nextDouble() < accuracy )
            extraPts = accuracy * 10.0;
        return super.getAttackPts() + extraPts;
    }

}
