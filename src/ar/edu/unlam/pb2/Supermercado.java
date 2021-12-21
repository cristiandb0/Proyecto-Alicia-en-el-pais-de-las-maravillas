package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	private String nombre;
	private List<Producto> stock;

	public Supermercado(String nombre) {
		this.nombre = nombre;
		this.stock = new ArrayList<>();
	}

	public void agregarProducto(Producto producto) {
		this.stock.add(producto);
	}

	public void agregarAlCarrito(Personaje personaje, Producto producto) throws sinDinero {
		personaje.comprar(producto);
		stock.remove(producto);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
