package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasosDePrueba {

	@Test
	public void queSePuedaInstanciarUnPersonaje() {

		Personaje persona = new Personaje(180, 65.0, "Alicia", 16, 1300.0);

		assertEquals(180, persona.getAltura(), 0.01);
		assertEquals(65.0, persona.getPeso(), 0.01);
		assertEquals("Alicia", persona.getNombre());
		assertEquals(16, persona.getEdad(), 0.01);
		assertEquals(1300.0, persona.getDinero(), 0.01);
	}

	@Test
	public void queSePuedaInstanciarUnSupermercado() {

		Supermercado supermercado = new Supermercado("coto");

		assertEquals("coto", supermercado.getNombre());

	}

	@Test
	public void queSePuedaInstanciarUnProducto() {

		Producto bagel = new Producto(1, "bagel", 150.0, 40);

		assertEquals("bagel", bagel.getNombre());
		assertEquals(150.0, bagel.getPrecio(), 0.01);
		assertEquals(40, bagel.getCrecer(), 0.01);

	}

	@Test(expected = sinDinero.class)
	public void queNoSePuedaSuperarElTopeDeDinero() throws sinDinero {

		Supermercado coto = new Supermercado("coto");
		Personaje alicia = new Personaje(180, 62.0, "Alicia", 15, 800.0);

		coto.agregarProducto(new Producto(1, "bagel", 350.0, -50));
		coto.agregarProducto(new Producto(2, "caramelo", 50.0, 40));
		coto.agregarProducto(new Producto(3, "alfajor", 250.0, -50));
		coto.agregarProducto(new Producto(4, "gomitas", 70.0, 40));
		coto.agregarProducto(new Producto(2, "caramelo", 50.0, 40));
		coto.agregarProducto(new Producto(3, "alfajor", 250.0, -50));

		coto.agregarAlCarrito(alicia, new Producto(1, "bagel", 350.0, -50));
		coto.agregarAlCarrito(alicia, new Producto(3, "alfajor", 250.0, -50));
		coto.agregarAlCarrito(alicia, new Producto(3, "alfajor", 250.0, -50));

	}
	
	@Test
	public void queSePuedaAgregarProductoAlSupermercado() {

		Supermercado coto = new Supermercado("coto");
		Personaje alicia = new Personaje(180, 62.0, "Alicia", 15, 800.0);

		coto.agregarProducto(new Producto(1, "bagel", 350.0, -50));
		coto.agregarProducto(new Producto(2, "caramelo", 50.0, 40));
		coto.agregarProducto(new Producto(3, "alfajor", 250.0, -50));
		coto.agregarProducto(new Producto(4, "gomitas", 70.0, 40));
		coto.agregarProducto(new Producto(2, "caramelo", 50.0, 40));
		coto.agregarProducto(new Producto(3, "alfajor", 250.0, -50));

		assertEquals(6, coto.getStock().size());

	}
	
	@Test
	public void queSeDescuenteDinero() throws sinDinero {

		Supermercado coto = new Supermercado("coto");
		Personaje alicia = new Personaje(180, 62.0, "Alicia", 15, 800.0);

		coto.agregarProducto(new Producto(1, "bagel", 350.0, -50));
		coto.agregarProducto(new Producto(2, "caramelo", 50.0, 40));
		coto.agregarProducto(new Producto(3, "alfajor", 250.0, -50));
		coto.agregarProducto(new Producto(4, "gomitas", 70.0, 40));
		coto.agregarProducto(new Producto(2, "caramelo", 50.0, 40));
		coto.agregarProducto(new Producto(3, "alfajor", 250.0, -50));
		
		try {
			coto.agregarAlCarrito(alicia, new Producto(1, "bagel", 350.0, -50));
			coto.agregarAlCarrito(alicia, new Producto(3, "alfajor", 250.0, -50));
		} catch (sinDinero e) {
			e.getMessage();	
			}
		
		
		assertEquals(200.0,alicia.getDinero() ,0.01);

	}
	
	@Test
	public void queSePuedaCrecer() throws sinDinero, NoPuedoCrecerException, NoPuedoEncogerException {

		Supermercado coto = new Supermercado("coto");
		Personaje alicia = new Personaje(180, 62.0, "Alicia", 15, 800.0);

		coto.agregarProducto(new Producto(1, "bagel", 350.0, -50));
		coto.agregarProducto(new Producto(2, "caramelo", 50.0, 40));
		coto.agregarProducto(new Producto(3, "alfajor", 250.0, -50));
		coto.agregarProducto(new Producto(4, "gomitas", 70.0, 40));
		coto.agregarProducto(new Producto(2, "caramelo", 50.0, 40));
		coto.agregarProducto(new Producto(3, "alfajor", 250.0, -50));

		coto.agregarAlCarrito(alicia,new Producto(2, "caramelo", 50.0, 40));
		coto.agregarAlCarrito(alicia, new Producto(2, "caramelo", 50.0, 40));
		
		alicia.comer(new Producto(2, "caramelo", 50.0, 40));
		alicia.comer(new Producto(2, "caramelo", 50.0, 40));
		
		//assertEquals(260, alicia.getAltura(),0.01);
		assertEquals(260, alicia.getAltura(),0.01);
	}
	
	@Test
	public void queSePuedaEncoger() throws sinDinero, NoPuedoCrecerException, NoPuedoEncogerException {

		Supermercado coto = new Supermercado("coto");
		Personaje alicia = new Personaje(180, 62.0, "Alicia", 15, 800.0);

		coto.agregarProducto(new Producto(1, "bagel", 350.0, -50));
		coto.agregarProducto(new Producto(2, "caramelo", 50.0, 40));
		coto.agregarProducto(new Producto(3, "alfajor", 250.0, -50));
		coto.agregarProducto(new Producto(4, "gomitas", 70.0, 40));
		coto.agregarProducto(new Producto(2, "caramelo", 50.0, 40));
		coto.agregarProducto(new Producto(3, "alfajor", 250.0, -50));

		coto.agregarAlCarrito(alicia,new Producto(3, "alfajor", 250.0, -50));
		coto.agregarAlCarrito(alicia, new Producto(3, "alfajor", 250.0, -50));
		coto.agregarAlCarrito(alicia, new Producto(3, "alfajor", 250.0, -50));
		
		alicia.comer(new Producto(3, "alfajor", 250.0, -50));
		alicia.comer(new Producto(3, "alfajor", 250.0, -50));
	
		
		//assertEquals(260, alicia.getAltura(),0.01);
		assertEquals(80, alicia.getAltura(),0.01);
	}
	
	@Test
	public void queSePuedaOrdenarProductosQueEncogen() throws sinDinero, NoPuedoCrecerException, NoPuedoEncogerException {

		Supermercado coto = new Supermercado("coto");
		Personaje alicia = new Personaje(180, 62.0, "Alicia", 15, 1800.0);

		coto.agregarProducto(new Producto(1, "bagel", 350.0, -50));
		coto.agregarProducto(new Producto(2, "caramelo", 50.0, 40));
		coto.agregarProducto(new Producto(3, "alfajor", 250.0, -50));
		coto.agregarProducto(new Producto(4, "gomitas", 70.0, 40));
		coto.agregarProducto(new Producto(2, "caramelo", 50.0, 40));
		coto.agregarProducto(new Producto(3, "alfajor", 250.0, -50));
		
		coto.agregarAlCarrito(alicia,new Producto(1, "bagel", 350.0, -50));
		coto.agregarAlCarrito(alicia,new Producto(3, "alfajor", 250.0, -50));
		coto.agregarAlCarrito(alicia, new Producto(3, "alfajor", 250.0, -50));
		coto.agregarAlCarrito(alicia,new Producto(1, "bagel", 350.0, -50));
		coto.agregarAlCarrito(alicia,new Producto(2, "caramelo", 50.0, 40));
		coto.agregarAlCarrito(alicia, new Producto(2, "caramelo", 50.0, 40));
		
		//System.out.println(alicia.getProductosDisponibles().toString());
		System.out.println(alicia.ordenarElementosQueEncogenPorNombre().toString());
	}
}
