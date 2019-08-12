import java.awt.*;
import primitivos.*;

/**
 * Escreva a descrição da classe FiguraCirculos aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class FiguraPontos
{
    public static void desenharPonto(Graphics g, int x, int y, int diametro){
            Color cor = new Color((int) (Math.random() * 256),  
                    (int) (Math.random() * 256),  
                    (int) (Math.random() * 256));
                    PontoGr p = new PontoGr(x, y, cor, "", diametro);
            p.desenharPonto(g);
    }

   public static void desenharPontos(Graphics g, int qtde, int larg){

        for(int i=0; i < qtde; i++) {
            int x = (int) (Math.random() * 801);
            int y = (int) (Math.random() * 801);

            // R, G e B aleatorio
            Color cor = new Color((int) (Math.random() * 256),  
                    (int) (Math.random() * 256),  
                    (int) (Math.random() * 256));
            PontoGr p = new PontoGr(x, y, cor, larg);
            p.desenharPonto(g);
        }
    }
}
