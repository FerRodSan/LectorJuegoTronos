package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import control.ParaUi;
import modelo.Legible;
import modelo.Libro;

class LegibleTest {
	
	ParaUi paraui=new ParaUi();
	Legible instancia=new Libro(paraui);


	@Ignore
	void testAvanzarPagina() {
		int paginaActual=((Libro)instancia).getActual();
		instancia.avanzarPagina();
		assertEquals(paginaActual+1,((Libro)instancia).getActual());
	}

	@Ignore
	void testRetrocederPagina() {
		int paginaActual=((Libro)instancia).getActual();
		instancia.retrocederPagina();
		System.out.println(paginaActual);
		assertEquals(paginaActual,((Libro)instancia).getActual());
	}

	@Ignore
	void testMacarPagina() {
		for (int i = 0; i < 5; i++) {
			instancia.avanzarPagina();
		}
		System.out.println(((Libro) instancia).getActual());
		instancia.macarPagina();
		assertEquals(((Libro)instancia).getMarca(),((Libro)instancia).getActual());
	}

	@Test
	void testIrAPagina() {
		for (int i = 0; i < 10; i++) {
			instancia.avanzarPagina();
			if(i==6) {
				instancia.macarPagina();
				System.out.println(((Libro) instancia).getMarca()+" pagina marcada");
			}
		}
		System.out.println(((Libro) instancia).getActual()+ " pagina que estamos");
		instancia.irAPagina();
		assertEquals(((Libro)instancia).getMarca(),((Libro)instancia).getActual());
	}

}
