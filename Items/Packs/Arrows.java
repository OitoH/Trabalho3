package Items.Packs;

public class Arrows extends Item implements Pack {

    private int amount;

    public Arrows(String newName, double newPrice, int newAmount) {
        super(newName, newPrice);
        setAmount(newAmount);
    }

    public int getAmount() { //Adquirir quantidade de elementos no pacote.
        return amount;
    }

    public boolean isEmpty() {
        return amount != 0;
    }

    public Arrows separate() throws PackManipulationException { //Dividir o pacote em dois.
        if ( amount < 2 )
            throw new PackManipulationException( "Não é possível separar o pacote de flechas em dois." );
        //Se é possível separar o pacote
        int aux = amount/2;
        amount -= aux;
        return new Arrows( name, price, aux );
    }

    public void use() throws PackManipulationException { //Usar um elemento do pacote.
        if ( isEmpty() )
            throw new PackManipulationException( "Não há mais flechas no pacote." );
        //Se não está vazio, diminui a quantidade de ítens.
        --amount;
    }

    private void setAmount(int newAmount) {
        if ( newAmount < 1 ) {
            newAmount = 5;
            System.err.println( "A quantidade de flechas não pode ter o valor "
                                        + amount + "\nAtribuindo valor padrão: "
                                        + newAmount
                                      );
        }
        amount = newAmount;
    }

}
