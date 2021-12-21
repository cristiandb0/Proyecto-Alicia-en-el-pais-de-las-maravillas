package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Personaje {

	private Integer altura;
	private Double peso;
	private String nombre;
	private Integer edad;
	private Double dinero;
	private List<Producto>productosDisponibles;
	private List<Producto>productosQueEncogen;
	
	public Personaje(int altura, double peso, String nombre, int edad, double dinero) {
		this.altura=altura;
		this.peso=peso;
		this.nombre=nombre;
		this.edad=edad;
		this.dinero=dinero;
		this.productosDisponibles=new ArrayList<>();
		this.productosQueEncogen=new ArrayList<>();
	}

	public Boolean comprar(Producto producto) throws sinDinero{
		if(this.dinero>= producto.getPrecio()) {
			this.productosDisponibles.add(producto);
			this.dinero-=producto.getPrecio();
			return true;
		}
		
		throw new sinDinero();
	}
	
	public void comer(Producto productoElegido) throws NoPuedoCrecerException, NoPuedoEncogerException {
		for (Producto producto : productosDisponibles) {
			if(producto.getCodigo().equals(productoElegido.getCodigo())) {
				if((this.altura+productoElegido.getCrecer()) <= 280 && (this.altura+productoElegido.getCrecer())>=50) {
					this.altura+=productoElegido.getCrecer();
					productosDisponibles.remove(productoElegido);
					break;	
				}
				if((this.altura+productoElegido.getCrecer())>280) {
					throw new NoPuedoCrecerException();	
				}
				if((this.altura+productoElegido.getCrecer())<50) {
					throw new NoPuedoEncogerException();	
				}
			}
		}
	}
	
	public List<Producto> ordenarElementosQueEncogenPorNombre() {
		
		for (Producto producto : productosDisponibles) {
			if(producto.getCrecer()<0) {
				this.productosQueEncogen.add(producto);
			}
		}
		
		Collections.sort(productosQueEncogen,new ordenarPorNombre());
		
		return productosQueEncogen;
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

	public List<Producto> getProductosDisponibles() {
		return productosDisponibles;
	}

	public void setProductosDisponibles(List<Producto> productosDisponibles) {
		this.productosDisponibles = productosDisponibles;
	}

	
}
