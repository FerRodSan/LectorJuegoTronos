package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUi;

public class Avanzar implements ActionListener {
	private ParaUi paraui;

	public Avanzar(ParaUi paraui) {
		super();
		this.paraui = paraui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraui.getLibro().avanzarPagina();
		this.paraui.actualizarTextArea();
		this.paraui.setMensaje("Avanzar pagina");
		// this.paraui.getTamanoArea();
	}
}
