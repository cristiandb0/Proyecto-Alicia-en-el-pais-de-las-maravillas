package ar.edu.unlam.pb2;

import java.util.Objects;

public class Producto {

	private String nombre;
	private Double precio;
	private Integer crecer;
	private Integer codigo;

	public Producto(int codigo,String nombre, double precio, int crecer) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.precio=precio;
		this.crecer=crecer;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCrecer() {
		return crecer;
	}

	public void setCrecer(Integer crecer) {
		this.crecer = crecer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", crecer=" + crecer + ", codigo=" + codigo + "]";
	}

	
}
