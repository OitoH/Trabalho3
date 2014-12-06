package Aux;

import java.io.Serializable;

public class Pair<T1, T2> implements Serializable {

	//Variáveis
	//public
	public T1 first;
	public T2 second;

	//Métodos
	//public
	public Pair(T1 newFirst, T2 newSecond) {
		first = newFirst;
		second = newSecond;
	}

}
