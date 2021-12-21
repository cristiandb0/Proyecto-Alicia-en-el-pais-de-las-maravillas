package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasosDePrueba {

	@Test
	public void queSePuedaInstanciarUnPersonaje() {
		
		Personaje persona=new Personaje(170, 65.0, "Alicia", 16, 1300.0);
		
		assertEquals(170, persona.getAltura(),0.01);
		assertEquals(65.0, persona.getPeso(),0.01);
		assertEquals("Alicia", persona.getNombre());
		assertEquals(16, persona.getEdad(),0.01);
		assertEquals(1300.0, persona.getDinero(),0.01);
	}
	
	@Test
	public void queSePuedaInstanciarUnSupermercado() {
		
		Supermercado supermercado = new Supermercado("coto");

		assertEquals("coto", supermercado.getNombre());

	}
	
	@Test
	public void queSePuedaInstanciarUnProducto() {
		
		Producto bagel = new Producto(1,"bagel",150.0,40);

		assertEquals("bagel", bagel.getNombre());
		assertEquals(150.0, bagel.getPrecio(),0.01);
		assertEquals(40, bagel.getCrecer(),0.01);
		
	}
}
