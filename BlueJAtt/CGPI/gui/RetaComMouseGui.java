package gui;

import armazenador.ListaLigada;
import armazenador.No;
import armazenador.Pilha;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import primitivos.AlgoritmosCirculos;
import primitivos.AlgoritmosRetas;
import primitivos.CirculoGr;
import primitivos.Ponto;
import primitivos.PontoGr;
import primitivos.RetaGr;
import primitivos.RetanguloGr;

public class RetaComMouseGui  {
	int x1=0, y1=0, x2=0, y2=0;
	int x=0, y=0, xant=0, yant=0;

	int divisoes; 
	int tamLado = 300;
	int tamForma =170;
	int evento = 0;
	int z = 0;
	
	ListaLigada circ = new ListaLigada();
	ListaLigada pont = new ListaLigada();
	ListaLigada reta = new ListaLigada();
	ListaLigada retan = new ListaLigada();
	
	
	boolean primeiraVez = true;

	public RetaComMouseGui(Stage palco) {
		
		Pilha res = new Pilha(15);
		Stage mapa = new Stage();
		
		
		
		// define titulo da janela
		palco.setTitle("Reta e Circulo com mouse");

		// define largura e altura da janela
		palco.setWidth(800);
		palco.setHeight(600);

		// Painel para os componentes
		BorderPane pane = new BorderPane();

		// componente para desenho
		Canvas canvas = new Canvas(800, 800);
			
		
		
		// componente para desenhar graficos
		GraphicsContext gc;
		gc = canvas.getGraphicsContext2D();

		
		//desenhar quadrado
		
		//Ponto novo = new Ponto(30,70);
		
		
		//Caixa de texto com botao de leitura
		//Label label1 = new Label("Divisoes:");
		//TextField textField = new TextField ();
		HBox hb = new HBox();
		Button buttonCurrent = new Button("Mapeamento");
		Button retangulo = new Button("Retangulo");
		Button ponto = new Button("Ponto");
		Button circulo = new Button("Circulo");
		Button linha = new Button("Linha");
		Button limpa = new Button("Limpar");
		Button crz = new Button("CTRL + Z");
		//tamanho botoes
		limpa.setPrefSize(150, 20);
		retangulo.setPrefSize(100, 20);
		buttonCurrent.setPrefSize(100, 20);// botao mapeamento 
		linha.setPrefSize(100, 20);//botao linha
		ponto.setPrefSize(100, 20);//botao ponto
		circulo.setPrefSize(100, 20);//botao circulo
		crz.setPrefSize(150, 20);
		
		buttonCurrent.setOnAction(event->{
			
			// Controi o canvas pequeno !!
			new Mapa(mapa);
			
		});
		
		crz.setOnAction(event->{
			
			redesenhar(gc);
			
		});
		
		
		ponto.setOnAction(event->{
			//Desenhar retangulo
			
			evento = 5;
			
		});
		
		
		circulo.setOnAction(event->{
			
			evento = 1;
			
		});
		
		
		linha.setOnAction(event->{
			//Desenhar retangulo
			
			evento = 2;
			
		});
		
		retangulo.setOnAction(event->{
			//Desenhar retangulo
			
			evento = 3;
			
		});
		
		
		limpa.setOnAction(event->{
			
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		});
		
		hb.getChildren().addAll(ponto,linha,circulo,retangulo,limpa,buttonCurrent,crz);
		hb.setSpacing(10);
		
		pane.setTop(hb);
		
		
		
		
		
		// Eventos de mouse
		// trata mouseMoved
		canvas.setOnMouseMoved(event -> {
			palco.setTitle("(BotaoEsq - desenha reta) (BotaoDir - desenha circulo) (BotaoMeio - limpa canvas)"+" (" + (int)event.getX() + ", " + (int)event.getY() + ")");

		});

		// trata mousePressed
		
		
		canvas.setOnMousePressed(event -> {
			if (event.getButton() == MouseButton.PRIMARY) {
				if (primeiraVez == true) {
					if(evento != 0){
						x1 = (int)event.getX();
						y1 = (int)event.getY();
						PontoGr p1 = new PontoGr(x1, y1, Color.BLUE);
						new PontoGr(x1, y1, Color.BLUE, "", 6).desenharPonto(gc);
						pont.inserirNoComeco(p1);
						primeiraVez = false;
					}
				} else{
					x2 = (int)event.getX();
					y2 = (int)event.getY();
					if(evento ==1){
						double raio = new PontoGr (x1, y1).distance(x2, y2);
						CirculoGr c1 = new CirculoGr(x1, y1, raio, Color.GREEN, "", 2);
						CirculoGr.desenhar(gc, x1, y1, raio, Color.GREEN, "", 2, AlgoritmosCirculos.STROKELINE);
						circ.inserirNoComeco(c1);
					}
					if(evento == 2){
						
						RetaGr r1 = new RetaGr(x1,y1,x2,y2,Color.RED,"",2);
						RetaGr.desenhar(gc, x1, y1, x2, y2, "", Color.RED,  2, AlgoritmosRetas.MIDPOINT);
						reta.inserirNoComeco(r1);
					}
					if(evento ==3){
						RetanguloGr re1 = new RetanguloGr(x1,y1,x2,y2,Color.RED);
						re1.desenharQuadrado(gc, x1, y1, x2, y2,Color.RED);
						retan.inserirNoComeco(re1);
						
					}
					PontoGr p2 = new PontoGr(x2, y2, Color.BLUE);
					new PontoGr(x2, y2, Color.BLUE, "", 6).desenharPonto(gc);
					pont.inserirNoComeco(p2);
					primeiraVez = true;
				}
			}
		});

		// atributos do painel
		pane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		pane.setBottom(canvas); // posiciona o componente de desenho

		// cria e insere cena
		Scene scene = new Scene(pane);
		palco.setScene(scene);
		palco.show();	
	}
	
	
	
	private void desenharForma(GraphicsContext gc, Ponto inicial,Color r ,Color g)
	{
		//Hexa
		RetaGr.desenhar(gc, inicial.getX(), inicial.getY(), 180 , 155, "", r, 2, AlgoritmosRetas.MIDPOINT);
		RetaGr.desenhar(gc, 180, 155, 180, 325 , "", r, 2, AlgoritmosRetas.MIDPOINT);
		RetaGr.desenhar(gc, 180, 325, 350, 400 , "", r, 2, AlgoritmosRetas.MIDPOINT);
		RetaGr.desenhar(gc, 350, 400, 520, 325 , "", r, 2, AlgoritmosRetas.MIDPOINT);
		RetaGr.desenhar(gc, 520, 325 , 520, 155 , "", r, 2, AlgoritmosRetas.MIDPOINT);
		RetaGr.desenhar(gc,520,155, inicial.getX(), inicial.getY(), "", r, 2, AlgoritmosRetas.MIDPOINT);
		//Retangulo
		RetaGr.desenhar(gc, 180, 155, 520, 155 , "", r, 2, AlgoritmosRetas.MIDPOINT);
		RetaGr.desenhar(gc, 180, 325, 520, 325 , "", r, 2, AlgoritmosRetas.MIDPOINT);
		//X no meio
		RetaGr.desenhar(gc, 180, 155, 520,325, "", r, 2, AlgoritmosRetas.MIDPOINT);
		RetaGr.desenhar(gc, 180, 325, 520,155, "", r, 2, AlgoritmosRetas.MIDPOINT);
		//trian 1#
		RetaGr.desenhar(gc, inicial.getX(), inicial.getY(), 520 , 325, "", r, 2, AlgoritmosRetas.MIDPOINT);
		RetaGr.desenhar(gc, inicial.getX(), inicial.getY(), 180 , 325, "", r, 2, AlgoritmosRetas.MIDPOINT);
		//trian 2#
		RetaGr.desenhar(gc, 180, 155, 350,400, "", r, 2, AlgoritmosRetas.MIDPOINT);
		RetaGr.desenhar(gc, 180, 155, 350,400, "", r, 2, AlgoritmosRetas.MIDPOINT);
		//trian 3#
		RetaGr.desenhar(gc,520,155, 350, 400, "", r, 2, AlgoritmosRetas.MIDPOINT);
		RetaGr.desenhar(gc,300,155, 400, 325, "",r, 2, AlgoritmosRetas.MIDPOINT);
		RetaGr.desenhar(gc,400,155, 300, 325, "", r, 2, AlgoritmosRetas.MIDPOINT);
		//reta do meio
		RetaGr.desenhar(gc,240,240,460, 240, "", r, 2, AlgoritmosRetas.MIDPOINT);
		RetaGr.desenhar(gc, inicial.getX(), inicial.getY(), 350 , 400, "", r, 2, AlgoritmosRetas.MIDPOINT);
		//Circulos
		CirculoGr.desenhar(gc, 350, 240, 110, g, "", 2, AlgoritmosCirculos.STROKELINE);
		CirculoGr.desenhar(gc, 240, 240, 105, g, "", 2, AlgoritmosCirculos.STROKELINE);
		CirculoGr.desenhar(gc, 460, 240, 105, g, "", 2, AlgoritmosCirculos.STROKELINE);
		CirculoGr.desenhar(gc, 283, 155, 102, g, "", 2, AlgoritmosCirculos.STROKELINE);
		CirculoGr.desenhar(gc, 420, 155, 102, g, "", 2, AlgoritmosCirculos.STROKELINE);
		CirculoGr.desenhar(gc, 283, 325, 102, g, "", 2, AlgoritmosCirculos.STROKELINE);
		CirculoGr.desenhar(gc, 420, 330, 102, g, "", 2, AlgoritmosCirculos.STROKELINE);
		
	}
	
	
public void desenharLinhas(GraphicsContext gc,Ponto inicial ){
		
		int i = 0;
		double auxX, auxY, delta;
		
		double x1,x2;
		double y1,y2;
		
		x1 =  inicial.getX();
		x2 = inicial.getX() + tamLado;
		y1 = inicial.getY();
		y2 = inicial.getY()+ tamLado;
		
		
		if(divisoes == 1){
			
			RetaGr.desenhar(gc,x1, y1,x2 ,y2 , "", Color.BLUE, 2, AlgoritmosRetas.MIDPOINT);
			RetaGr.desenhar(gc,x2, y1,x1 ,y2 , "", Color.BLUE, 2, AlgoritmosRetas.MIDPOINT);

			
			
		}else{
			
			delta = tamLado / divisoes;
			
			for(i = 1; i<=divisoes; i++){ // linha baixo
				
				
				auxX = x1 + (delta * (i - 1));
				//auxY = delta * (i - 1) + y1;
				auxY = y2 - (delta * i);
				
				RetaGr.desenhar(gc,auxX, y2,x2 ,auxY, "", Color.BLUE, 2, AlgoritmosRetas.MIDPOINT);
				
			}
			
			for(i = 1; i <= divisoes; i++){ // linha direita
				auxX = x2 - ( delta * i );
				auxY = y2 - (delta * (i - 1));
				
				RetaGr.desenhar(gc,x2, auxY, auxX, y1, "", Color.BLUE, 2, AlgoritmosRetas.MIDPOINT);
			}
			
			for(i = 1; i <= divisoes; i++){// linha cima
				auxX = x2 - ( delta * (i - 1) );
				auxY = y1 + (delta * i);
				
				RetaGr.desenhar(gc,auxX, y1, x1, auxY, "", Color.BLUE, 2, AlgoritmosRetas.MIDPOINT);
			}
			
			for(i = 1; i <= divisoes; i++){// linha esquerdista comunista taxista
				auxX = x1 + ( delta * i );
				auxY = y1 + (delta * (i - 1));
				
				RetaGr.desenhar(gc,x1, auxY, auxX, y2, "", Color.BLUE, 2, AlgoritmosRetas.MIDPOINT);
			}
		}
		
		
	}

	public void redesenhar(GraphicsContext gc){
		
		No p;
		CirculoGr gg;
		
		if(circ != null){
			gg = (CirculoGr) circ.getInicio().getConteudo();
			p = circ.getInicio();
			while(p.getProx()!= null){
				gg.desenhar(gc,gg.getCentro().getx(), gg.getRaio(), 105, Color.RED,"", 2, AlgoritmosCirculos.STROKELINE);
				
				p = p.getProx();
			}
		}
		
		
	}

}
