package armazenador; 


public class ListaLigada
{
    
    private No anterior;
    
    No ccp;
    No inicio;
    No ultima;
    No aux;
    int numElemento ;
    
    public ListaLigada(){
        
         setInicio(null);
         setUltima(null);
         
    }   
    
    public ListaLigada(Object v){
        No cp = new No(v);
        setInicio(cp);
        
    }
    
    public void inserirNoComeco(Object a){
        
        aux = new No(a);
        if(this.numElemento == 0){
             
             setInicio(aux);
             setUltima(aux);
        }else{
            
            aux.prox = getInicio();
            setInicio(aux);
            
            
        }
        this.numElemento++;
        
    }    
    public void inserirNoFim(Object a){
        
        if(this.numElemento == 0){
             inserirNoComeco(a);
        }else{
            aux = new No(a);
            this.ultima.setProx(aux);
            this.ultima = aux;
        }
        this.numElemento++;
        
    }   
    public void removerNoComeco(){
        
        if(this.numElemento == 0){
            throw new IllegalArgumentException("Elementos nao existem");
        }else{        
            this.inicio = this.inicio.getProx();
            this.numElemento--;
            if(this.numElemento == 0){
                this.ultima = null;
            
            }
        }    
    }
    public void removerNoFim(){
        
        if(this.numElemento == 0){
            throw new IllegalArgumentException("Elementos nao existem");
        }else{        
            if(this.numElemento == 1){
                removerNoComeco();
                
            }
            No anterior = inicio;
            while(anterior.getProx()!= ultima){
                anterior = anterior.getProx();
            
            }
            ccp = this.ultima;
            anterior.prox = null;
            this.ultima = anterior;
             
            this.numElemento--;
            
        }    
    }
    public Object buscarObjeto(Object a){
        
        aux = new No(a);
        
        if(this.numElemento == 0){
            throw new IllegalArgumentException("Elemento nao existe");
        }else{    
            while(aux!=null){
                //aux =
            
            }
        }
        
        return a;
    }
    public String toString() {
            
            String s = "";
            No aux = getInicio();
            
            while(aux != null){
                s = s + aux.toString();
                aux = aux.getProx();
            }

       return s;
    }
    
    public Object acessarInicio(){
        
        return this.inicio.getConteudo();
    }
    public Object acessarFim(){
        
        return this.ultima.getConteudo();
    }
    
    public No setInicio(No inicio){
        return this.inicio = inicio;
    }    
    
    public No getInicio(){
     return this.inicio;   
    }    
    
    public No setUltima(No ultima){
        return this.ultima = ultima;
    }    
    
    public No getUltima(){
        return this.ultima;   
    }    
    
    public No getAnterior() {
        return anterior;
    }
  
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
    public int getQtd() {
        return numElemento;
    }
    
}
