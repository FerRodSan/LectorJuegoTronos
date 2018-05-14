package vista;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.UIManager;

public class Ui extends JFrame {

	private JPanel contentPane;
	protected JButton btnRetroceder;
	protected JButton btnMarcar;
	protected JButton btnIrMarca;
	protected JButton btnAvanzar;
	protected JTextArea textArea;
	protected JLabel lblNum;
	protected JLabel lblImagen;
	protected JPanel panelBotones;
	protected JTextField txtMensaje;

	/**
	 * Create the frame.
	 */
	public Ui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		/**
		 * INTENTO de marca de agua. La imagen no hay manera de ponerla translucida para
		 * que el texto se pueda ver tras ella.
		 */
		ImageIcon imagen = new ImageIcon("src/img/trono2.png");
		lblImagen = new JLabel(imagen);
		lblImagen.setSize(new Dimension(300, 500));
		lblImagen.setHorizontalTextPosition(SwingConstants.CENTER);
		lblImagen.setPreferredSize(new Dimension(320, 500));
		lblImagen.setMinimumSize(new Dimension(320, 560));
		lblImagen.setMaximumSize(new Dimension(320, 560));
		lblImagen.setBackground(new Color(0f,0f,0f,0.4f));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBorder(BorderFactory.createEmptyBorder());
		lblImagen.setBackground(UIManager.getColor("Label.disabledForeground"));
		contentPane.add(lblImagen);

		textArea = new JTextArea();
		textArea.setFont(new Font("Mistral", Font.PLAIN, 17));
		textArea.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setOpaque(false);
		textArea.setBorder(BorderFactory.createEmptyBorder());
		textArea.setBackground(new Color(Color.TRANSLUCENT));
		contentPane.add(textArea, BorderLayout.CENTER);

		panelBotones = new JPanel();
		panelBotones.setSize(new Dimension(60, 60));
		panelBotones.setPreferredSize(new Dimension(60, 60));
		panelBotones.setMinimumSize(new Dimension(0, 0));
		panelBotones.setBorder(null);
		FlowLayout fl_panelBotones = (FlowLayout) panelBotones.getLayout();
		fl_panelBotones.setAlignment(FlowLayout.LEFT);
		contentPane.add(panelBotones, BorderLayout.SOUTH);

		btnRetroceder = new JButton("<<");
		panelBotones.add(btnRetroceder);

		btnMarcar = new JButton("Marcar");
		panelBotones.add(btnMarcar);

		btnIrMarca = new JButton("Ir a Marca");
		panelBotones.add(btnIrMarca);

		btnAvanzar = new JButton(">>");
		panelBotones.add(btnAvanzar);

		lblNum = new JLabel("0");
		panelBotones.add(lblNum);

		JLabel lblmensaje = new JLabel("Mensaje :");
		panelBotones.add(lblmensaje);

		txtMensaje = new JTextField();
		txtMensaje.setBackground(Color.BLACK);
		txtMensaje.setForeground(Color.WHITE);
		txtMensaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtMensaje.setMaximumSize(new Dimension(200, 20));
		txtMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		txtMensaje.setPreferredSize(new Dimension(200, 20));
		txtMensaje.setMinimumSize(new Dimension(200, 20));
		txtMensaje.setSize(new Dimension(200, 20));
		txtMensaje.setEnabled(false);
		panelBotones.add(txtMensaje);
		txtMensaje.setColumns(10);

		JLabel lbltitulo = new JLabel("JUEGO DE TRONOS");
		lbltitulo.setBackground(Color.WHITE);
		lbltitulo.setForeground(Color.BLACK);
		lbltitulo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbltitulo.setFont(new Font("Mistral", Font.BOLD, 20));
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbltitulo, BorderLayout.NORTH);
	}
}
