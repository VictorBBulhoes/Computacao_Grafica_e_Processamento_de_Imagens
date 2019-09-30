package primitivos;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class RetanguloGr {
	
	
	Color corReta;
	int x1, y1, x2, y2;
	
	public RetanguloGr(int x1 ,int y1,int x2,int y2,Color corReta){
		setCorReta(corReta);
		setX1(x1);
		setX2(x2);
		setY1(y1);
		setY2(y2);
		
	}
	
	
	public void desenharQuadrado(GraphicsContext gc, int x1,int y1,int x2 ,int y2,Color corReta)
	{
		RetaGr.desenhar(gc, x1, y1, x2, y1, "", corReta, 2, AlgoritmosRetas.MIDPOINT);
		RetaGr.desenhar(gc, x2, y1, x2, y2, "", corReta, 2, AlgoritmosRetas.MIDPOINT);
		RetaGr.desenhar(gc, x2, y2, x1, y2, "", corReta, 2, AlgoritmosRetas.MIDPOINT);
		RetaGr.desenhar(gc, x1, y2, x1,y1, "",corReta, 2, AlgoritmosRetas.MIDPOINT);	
		
	}


	public Color getCorReta() {
		return corReta;
	}


	public void setCorReta(Color corReta) {
		this.corReta = corReta;
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
	
	
}
