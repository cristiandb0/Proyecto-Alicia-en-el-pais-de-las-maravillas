package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Personaje {

	private Integer altura;
	private Double peso;
	private String nombre;
	private Integer edad;
	private Double dinero;
	private List<Producto>productosDisponibles;
	
	public Personaje(int altura, double peso, String nombre, int edad, double dinero) {
		this.altura=altura;
		this.peso=peso;
		this.nombre=nombre;
		this.edad=edad;
		this.dinero=dinero;
		this.productosDisponibles=new ArrayList<>();
	}

	public Boolean comprar(Producto producto) throws sinDinero{
		if(this.dinero>= producto.getPrecio()) {
			this.productosDisponibles.add(producto);
			return true;
		}
		
		throw new sinDinero();
	}
	
	public void comer(Producto productoElegido) {
		for (Producto producto : productosDisponibles) {
			if(producto.equals(productoElegido)) {
				this.altura+=producto.getCrecer();
				productosDisponibles.remove(productoElegido);
			}
		}
	}
	
	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}

	
}
