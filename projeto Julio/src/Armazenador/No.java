package Armazenador;

public class No
{
    Object conteudo; // Conteudo/Elemento
    No prox ;
    No anterior;
    
    public No(Object v){
        conteudo = v;
        prox = null;
        anterior = null;
  
    }
    public No getProx(){
        return prox;
    }  
    public void setProx(No prox){
        this.prox = prox;
    }  
    public Object getConteudo(){
        return conteudo;
    }
    public String toString(){
        return getConteudo().toString();
        
    }    
    /*
    public No getAnterior(){
        return anterior;
    }  
    public void setAnterior(No anterior){
        this.anterior = anterior;
    }  
    */
}
