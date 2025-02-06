package screamatching.modelos;

import screamatching.modelos.Serie;
import screamatching.calculo.Classificavel;

public class Episodio implements Classificavel {
    private int numero;
    private String nome;
    private Serie serie;
    private int totalVisualizacoes;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    public void setTotalVisualizacoes(int totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    // Corrigido para remover a duplicata e o erro de maiúsculas
    @Override
    public int getClassificavel() {
        return (int) pegaMedia() / 2; // Corrija o método pegaMedia ou implemente-o
    }

    // Defina o método pegaMedia corretamente
    private double pegaMedia() {
        // Lógica para calcular a média das avaliações
        return 0; // Exemplo de retorno, substitua pela lógica correta
    }
}
