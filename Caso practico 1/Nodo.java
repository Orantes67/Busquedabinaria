public class Nodo {
    private Productos dato;
    private Nodo izq;
    private Nodo der;
    public Nodo (Productos dato){
        this.dato= dato;
    }
    public Nodo (){    }
    public Nodo getIzq(){
        return izq;
    }
    public Nodo getDer(){
        return der;
    }
    public Productos getDato(){
        return dato;
    }
    public void setDato(Productos dato){
        this.dato= dato;
    }
    public void setIzq(Nodo nodo){
        izq=nodo;
    }
    public void setDer(Nodo nodo){
        der=nodo;
    }
}

