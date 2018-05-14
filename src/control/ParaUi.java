package control;

import Utiles.Constantes;
import acciones.Avanzar;
import acciones.IrMarca;
import acciones.Marcar;
import acciones.Retroceder;
import modelo.AlmacenLibro;
import modelo.Libro;
import modelo.Pagina;
import vista.Ui;

public class ParaUi extends Ui {

	private Avanzar avanzar;
	private IrMarca irMarca;
	private Retroceder retroceder;
	private Marcar marcar;
	private Libro libro;
	private AlmacenLibro almacenLibro;

	public ParaUi() {
		super();
		this.libro = new Libro(this);
		this.avanzar = new Avanzar(this);
		this.irMarca = new IrMarca(this);
		this.marcar = new Marcar(this);
		this.retroceder = new Retroceder(this);
		this.almacenLibro = new AlmacenLibro(this.libro.getLectura());
		asignarListener();
		this.libro.irAPagina(); // Al cargar nos lleva a la pagina 0
		actualizarTextArea();
	}

	/**
	 * Actualiza el numero de la pagina actual en la vista
	 */
	private void actualizarNumPagina() {
		this.lblNum.setText(String.valueOf(this.libro.getActual()));
	}

	/**
	 * Inserta un mensaje en el txtMensaje
	 * @param mensaje
	 */
	public void setMensaje(String mensaje) {
		this.txtMensaje.setText(mensaje);
	}

	public Libro getLibro() {
		return libro;
	}

	public AlmacenLibro getAlmacenLibro() {
		return almacenLibro;
	}

	/**
	 * Calcula el numero maximo de caracteres x pagina
	 * @return devuelve el numero de caracteres por pagina
	 */
	public int getMaximoCaracteres() {
		int maximoCaracteres = Utiles.Constantes.width * Utiles.Constantes.height;
		return maximoCaracteres;
	}

	/**
	 * Carga el texto completo en el textArea
	 */
	private void cargarTexto() {
		this.textArea.setText(this.almacenLibro.leer());
		this.almacenLibro.escribirLineas();
	}

	/**
	 * Actualiza la vista al completo
	 */
	public void actualizarTextArea() {
		actualizarNumPagina();
		Pagina pagina = this.libro.getPaginas().get(this.libro.getActual());
		this.textArea.setText(
				new AlmacenLibro(this.libro.getLectura()).leer().substring(pagina.getPrimer(), pagina.getUltimo()));
	}

	/**
	 * Asigna los listener a cada boton
	 */
	private void asignarListener() {
		this.btnAvanzar.addActionListener(this.avanzar);
		this.btnRetroceder.addActionListener(this.retroceder);
		this.btnIrMarca.addActionListener(this.irMarca);
		this.btnMarcar.addActionListener(this.marcar);
	}

	/**
	 * Calcula el alto y el ancho del textArea
	 */
	public void getTamanoArea() {
		System.out.println(this.textArea.getPreferredSize().getHeight());
		System.out.println(this.textArea.getHeight());
		System.out.println(this.textArea.getPreferredSize().getWidth());
		System.out.println(this.textArea.getWidth());
	}
}
