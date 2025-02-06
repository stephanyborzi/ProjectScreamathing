package screamatching.principal;

import screamatching.calculo.CalculadoraDeTempo;
import screamatching.calculo.Recomendacao;
import screamatching.modelos.Episodio;
import screamatching.modelos.Filme;
import screamatching.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme favorito = new Filme("The Matrix",1999);
        favorito.setDuracaoEmMinutos(135);
        favorito.setIncluidoNoPlano(true);

        favorito.exibeFichaTecnica();
        favorito.avalia(9);
        favorito.avalia(8);
        favorito.avalia(9);

        System.out.println("Duração do filme: " + favorito.getDuracaoEmMinutos());
        System.out.println("Média de avaliações do filme: " + favorito.pegaMedia());

        Serie lost = new Serie("Lost",2006);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(30);
        System.out.println("Duração da Série: " + lost.getDuracaoEmMinutos());

        Filme outroFavorito = new Filme("Avatar",2018);
        outroFavorito.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.incluir(favorito);
        calculadora.incluir(outroFavorito);
        calculadora.incluir(lost);
        System.out.println("O tempo total para assistir o / os filmes que você selecionou é: " + calculadora.getTempoTotal());

        Recomendacao filtro = new Recomendacao();
        filtro.filtra(favorito);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filmeDoUsuario = new Filme("Cinderela",1943);
        filmeDoUsuario.setDuracaoEmMinutos(200);
        filmeDoUsuario.avalia(10);

        ArrayList<Filme>listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoUsuario);
        listaDeFilmes.add(favorito);
        listaDeFilmes.add(outroFavorito);
        System.out.println("Tamanho do filme: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);


    }
}