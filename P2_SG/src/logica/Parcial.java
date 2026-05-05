package logica;

public class Parcial {
	private int b;
	private int e;
	public Parcial(int b, int e) {
		this.b = b;
		this.e = e;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getE() {
		return e;
	}
	public void setE(int e) {
		this.e = e;
	}
	
	public int calcularValor(int b,int e) {
		int result = (int) Math.pow(b, e);
		return result;
		
	}

}
