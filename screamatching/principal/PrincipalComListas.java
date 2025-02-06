package screamatching.principal;

import screamatching.modelos.Filme;
import screamatching.modelos.Serie;
import screamatching.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalComListas {
    public static void main(String[] args){
        Filme favorito = new Filme("The Matrix",1999);
        favorito.avalia(9);
        Filme outroFavorito = new Filme("Avatar",2018);
        outroFavorito.avalia(3);
        var filmeDoUsuario = new Filme("Cinderela",1943);
        filmeDoUsuario.avalia(10);
        Serie lost = new Serie("Lost",2006);

        ArrayList<Titulo> listaDeAssistidos = new ArrayList<>();
        listaDeAssistidos.add(filmeDoUsuario);
        listaDeAssistidos.add(favorito);
        listaDeAssistidos.add(outroFavorito);
        listaDeAssistidos.add(lost);

        for (Titulo item: listaDeAssistidos){
            System.out.println(item.getNome());
            if (item instanceof Filme filme) {
                System.out.println(filme.getClassificavel());
            }
        }
    }
}
