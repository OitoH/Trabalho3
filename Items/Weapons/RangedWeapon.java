package Items.Weapons;

public class RangedWeapon extends Weapon {

    //Parâmetros
    //protected:
    protected double range;

    //Métodos
    //public:
    public RangedWeapon(String newName, double newPrice, int newAttackPts, double newRange) {
        super(newName, newPrice, newAttackPts);
        setRange(newRange);
    }

    public RangedWeapon(RangedWeapon rhs) {
        super(rhs);
        setRange(rhs.range);
    }

    public double getRange() {
        return range;
    }

    public void setRange(double newRange) {
        if ( newRange > 1.0 )
            range = newRange;
        else {
            range = 1.5;
            System.err.println( "Erro! Alcance da arma insuficiente, definindo valor padrão: " + range );
        }
    }

}
