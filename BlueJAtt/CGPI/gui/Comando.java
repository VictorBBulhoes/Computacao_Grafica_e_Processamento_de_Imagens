package gui;

public class Comando {
	
	int x1;
	int y1;
	int x2;
	int y2;
	String forma;
	
	//Contrutor para outras formas
	public Comando(int x1,int y1,int x2,int y2,String forma){
		setX1(x1);
		setX2(x2);
		setY1(y1);
		setY2(y2);
		setForma(forma);
		
	}
	//Construtor para o ponto
	public Comando(int x1,int y1,String forma){
		setX1(x1);
		setY1(y1);
		setForma(forma);
		
	}
	
	
	
	

	public int getX1() {
		return x1;
	}


	public void setX1(int x1) {
		this.x1 = x1;
	}


	public int getY1() {
		return y1;
	}


	public void setY1(int y1) {
		this.y1 = y1;
	}


	public int getX2() {
		return x2;
	}


	public void setX2(int x2) {
		this.x2 = x2;
	}


	public int getY2() {
		return y2;
	}


	public void setY2(int y2) {
		this.y2 = y2;
	}


	public String getForma() {
		return forma;
	}


	public void setForma(String forma) {
		this.forma = forma;
	}

}
