public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(int tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    /*public void incluir(Filme f){
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



