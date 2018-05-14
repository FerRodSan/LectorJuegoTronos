package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUi;

public class IrMarca implements ActionListener {
	private ParaUi paraui;

	public IrMarca(ParaUi paraui) {
		super();
		this.paraui = paraui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraui.getLibro().irAPagina();
		this.paraui.actualizarTextArea();
		this.paraui.setMensaje("Vas a la pagina " + this.paraui.getLibro().getMarca());
	}
}
