package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Supermercado {
	private String nombre;
	private List<Producto> stock;
	private Set<Producto> stockUnico;
	
	public Supermercado(String nombre) {
		this.nombre = nombre;
		this.stock = new ArrayList<>();
		this.stockUnico=new HashSet<>();
	}

	public void agregarProducto(Producto producto) {
		this.stock.add(producto);
	}
/*
	public void agregarProducto(Producto producto) {
		if(!stockUnico.add(producto)) {
			System.out.println("No se pudo agregar");
		}
		else {
			stockUnico.add(producto);
		}
	}
	*/
	
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

	public List<Producto> getStock() {
		return stock;
	}

	public void setStock(List<Producto> stock) {
		this.stock = stock;
	}
	public Set<Producto> getStockUnico() {
		return stockUnico;
	}
	public void setStockUnico(Set<Producto> stockUnico) {
		this.stockUnico = stockUnico;
	}

}
