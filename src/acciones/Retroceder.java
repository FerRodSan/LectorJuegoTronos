package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUi;

public class Retroceder implements ActionListener {
	private ParaUi paraui;

	public Retroceder(ParaUi paraui) {
		super();
		this.paraui = paraui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraui.getLibro().retrocederPagina();
		this.paraui.actualizarTextArea();
	}
}
