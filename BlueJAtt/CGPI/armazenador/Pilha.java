 package armazenador;


public class Pilha implements IPilha 
{

    ListaLigada cc; 

    int limite;
    
    public Pilha (int limite){
        cc =  new ListaLigada();
        setLimite(limite);
    }

    public void push(Object v){
        
        
        if(cc.getQtd() != limite){
            
        cc.inserirNoFim(v);
        }
    }

    public Object pop() {
        //pop
        Object retorno;

        retorno = cc.acessarFim();
        cc.removerNoFim();
        return retorno;
    }

    public void setLimite(int limite){
        this.limite = limite;
    }

    public int getLimite(){
        return this.limite;
    }    
    public String toString(){
     return cc.toString();   
        
        
    }    
}
