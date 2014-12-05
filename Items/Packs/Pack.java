package Items.Packs;

private interface Pack { //Interface para Items que são pacotes de ítens, como pacotes de flechas.

    public int getAmount(); //Adquirir quantidade de elementos no pacote.

    public boolean isEmpty(); //Checa se o pacote está vazio.

    public Pack separate(); //Dividir o pacote em dois.

    public void use(); //Usar um elemento do pacote.

}
