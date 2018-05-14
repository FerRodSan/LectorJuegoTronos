package modelo;

import java.util.ArrayList;

import control.ParaUi;

public class Libro implements Legible {

	private String lectura;
	private int actual = 0;
	private int marca = 0;
	private ArrayList<Pagina> paginas;
	private ParaUi paraui;

	public Libro(ParaUi paraui) {
		super();
		this.lectura = "src/Texto/CanciondeHielo.txt";
		this.paginas = new ArrayList<>();
		this.paraui = paraui;
	}

	/**
	 * Comprueba si puedes avanzar y te carga la siguiente pagina
	 */
	@Override
	public void avanzarPagina() {
		if (!comprobarUltima()) {
			cargarSiguientePagina();
		} else {
			this.paraui.setMensaje("LLegaste a la ultima");
		}
	}

	/**
	 * Aumenta el numero de la pagina y te crea la siguiente
	 */
	private void cargarSiguientePagina() {
		this.actual++;
		crearPagina(this.actual);
	}

	/**
	 * Comprueba si la pagina tiene menos caracteres del maximo.
	 * 
	 * @return true si es la ultima.
	 */
	private boolean comprobarUltima() {
		boolean ultima = false;
		// int tamanoTextoTotal = this.lectura.length(); Devuelve un numero muy inferior...
		int tamanoTextoTotal = this.paraui.getAlmacenLibro().leer().length();
		if (tamanoTextoTotal / paraui.getMaximoCaracteres() < paraui.getMaximoCaracteres()) {
			ultima = true;
		}
		return ultima;
	}

	/**
	 * Comprueba si la pagina actual es la numero 0
	 * 
	 * @return
	 */
	private boolean comprobarPrimeraPagina() {
		return this.actual == 0;
	}

	/**
	 * Comprueba si puedes retroceder y va a la pagina anterior
	 */
	@Override
	public void retrocederPagina() {
		if (!comprobarPrimeraPagina()) {
			cargarAnteriorPagina();
		} else {
			this.paraui.setMensaje("Es la primera");
		}
	}

	/**
	 * carga la pagina anterior
	 */
	private void cargarAnteriorPagina() {
		this.actual--;
		this.paraui.setMensaje("Vuelves atras");
	}

	/**
	 * crea una pagina dentro de la lista paginas, desde una posicion inicial a una
	 * posicion final
	 * 
	 * @param actual,
	 *            el numero actual de la pagina en la que estas
	 */
	private void crearPagina(int actual) {
		int posicionEmpezar = this.actual * paraui.getMaximoCaracteres();
		int posicionTerminar = this.actual * paraui.getMaximoCaracteres() + paraui.getMaximoCaracteres();
		this.paginas.add(new Pagina(posicionEmpezar, posicionTerminar));
	}

	/**
	 * Guarda en una variable el numero de la pagina actual
	 */
	@Override
	public void macarPagina() {
		this.marca = this.actual;
	}

	/**
	 * Nos devuelve a la pagina marcada
	 */
	@Override
	public void irAPagina() {
		this.actual = this.marca;
		crearPagina(this.actual);
	}

	public String getLectura() {
		return lectura;
	}

	public int getActual() {
		return actual;
	}

	public int getMarca() {
		return marca;
	}

	public ArrayList<Pagina> getPaginas() {
		return paginas;
	}

}
