package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUi;

public class Marcar implements ActionListener {
	private ParaUi paraui;

	public Marcar(ParaUi paraui) {
		super();
		this.paraui = paraui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraui.getLibro().macarPagina();
		this.paraui.actualizarTextArea();
		this.paraui.setMensaje("Marcas la pagina " + this.paraui.getLibro().getActual());
	}
}
