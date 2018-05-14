package modelo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Reader;

import javax.print.attribute.standard.Sides;

public class AlmacenLibro {

	private String ruta;

	public AlmacenLibro(String ruta) {
		super();
		this.ruta = ruta;
	}

	/**
	 * PRIMERA opcion.... leer un archivo de texto, escribirlo en otro archivo Dummy
	 * con un tama�o de cada linea x, de esta manera en el archivoDummy apareceria
	 * el texto entero pero cada linea seria cada pagina del texto. De esta manera
	 * al pasar paginas solo se irian pasando las lineas con readLine(), pero hay
	 * muchos errores con los saltos de linea.
	 */
	public void escribirLineas() {
		File fichero = null;
		FileOutputStream fw = null;
		BufferedOutputStream bw = null;
		String textoEntero = leer();
		try {
			fichero = new File("src/Texto/TextoDummy.txt");
			fw = new FileOutputStream(fichero);
			bw = new BufferedOutputStream(fw);
			int i = 0;
			for (; i < textoEntero.length(); i++)
				bw.write(textoEntero.charAt(i));
			if (i == Utiles.Constantes.height * Utiles.Constantes.width) {
				i = 0;
				bw.write(Integer.valueOf("/n"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			fw.close();
			bw.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	/**
	 * SEGUNDA opcion Obtiener todo el texto como una cadena. En un entero x
	 * obtienes el tama�o cadena.lenght dependiendo del tama�o de textarea ver
	 * cuantos caracteres hay por linea calculas el numero de lineas y declarar un
	 * StringBuilder y a�ades al builder cada caracter del texto
	 * 
	 * Hay un error al convertir, ya que al leer interpreta todas las letras con
	 * acento de una manera distinta.... Al usar el conversor me detecta todos los
	 * caracteres en chino. �Que hago?
	 * 
	 * @return el StringBuilder con todo el texto
	 */
	public String leer() {
		File archivo = new File(this.ruta);
		StringBuilder builder = new StringBuilder();
		Reader reader = null;
		BufferedReader fin = null;
		try {
			reader = new InputStreamReader(new FileInputStream(archivo), "UTF-8");
			fin = new BufferedReader(reader);
			int numCaracter = fin.read();
			while (numCaracter != -1) {
				builder.append(String.valueOf(Character.valueOf((char) numCaracter)));
				numCaracter = fin.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				fin.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return builder.toString();
	}
}
