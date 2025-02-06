package screamatching.calculo;

import screamatching.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(int tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    /*public void incluir(screamatching.modelos.Filme f){
        tempoTotal += f.getDuracaoEmMinutos();
    }   

    public void incluir(Serie s){
        tempoTotal += .getDuracaoEmMinutos();
    } 
     */

    public void incluir(Titulo titulo){
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
    
}   



