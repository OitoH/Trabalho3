package Items.Weapons;

public class RangedWeapon extends Weapon {

    //Parâmetros
    //protected:
    protected double range;
    protected Pack ammo;

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

    public int getAttackPts() {
        try {
            ammo.use();
            return attackpts;
        } catch (Exception e) {
            System.err.println( e.getMessage() );
            return 0;
        }
    }

    public void setRange(double newRange) {
        if ( newRange > 1.0 )
            range = newRange;
        else {
            range = 1.5;
            System.err.println( "Erro! Alcance da arma insuficiente, definindo valor padrão: " + range );
        }
    }

    //Esta função associa um pacote de ítens à uma arma de longo alcance.
    public Pack setAmmo(Pack ammo) {
        Pack previousAmmo = ammo;
        ammo = newAmmo;
        return previousAmmo;
    }

}
