package modelo;

public class Pagina {
	
	private int primer;
	private int ultimo;

	public Pagina(int primer, int ultimo) {
		super();
		this.primer = primer;
		this.ultimo = ultimo;
	}

	public int getPrimer() {
		return primer;
	}

	public int getUltimo() {
		return ultimo;
	}

	public void setPrimer(int primer) {
		this.primer = primer;
	}

	public void setUltimo(int ultimo) {
		this.ultimo = ultimo;
	}

}
