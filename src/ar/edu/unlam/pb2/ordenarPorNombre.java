package ar.edu.unlam.pb2;

import java.util.Comparator;

public class ordenarPorNombre implements Comparator<Producto> {

	@Override
	public int compare(Producto o1, Producto o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareTo(o2.getNombre());
	}

}
