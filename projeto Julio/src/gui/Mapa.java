package gui;


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


public class Mapa {
	
	
	public Mapa(Stage palco) {
		
		palco.setTitle("Mapeamento");
		
		palco.setWidth(300);
		palco.setHeight(400);
		
		
		// Painel para os componentes
				BorderPane pane = new BorderPane();

				// componente para desenho
				Canvas canvas = new Canvas(800, 800);
				
				
				// componente para desenhar graficos
				GraphicsContext gc;
				
				gc = canvas.getGraphicsContext2D();
				
				
				
				
		
		// atributos do painel
				pane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				pane.setBottom(canvas); // posiciona o componente de desenho

				// cria e insere cena
				Scene scene = new Scene(pane);
				palco.setScene(scene);
				palco.show();	
		
		
	}
	
	
}
