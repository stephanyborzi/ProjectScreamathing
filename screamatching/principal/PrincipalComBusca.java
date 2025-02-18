package screamatching.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import screamatching.modelos.Titulo;
import screamatching.modelos.TituloOmdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = ""; // Inicializa a variável

        while (!busca.equalsIgnoreCase("sair")) { // Continua até o usuário digitar "sair"
            System.out.println("\nDigite um filme para buscar (ou 'sair' para encerrar):");
            busca = leitura.nextLine().trim(); // Lê a entrada do usuário

            if (busca.equalsIgnoreCase("sair")) { // Se for "sair", encerra o programa
                System.out.println("Encerrando o programa...");
                break;
            }

            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=6585022c";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();

                // Verifica se a API retornou um erro
                if (json.contains("\"Error\"")) {
                    System.out.println("Filme não encontrado. Verifique o nome e tente novamente.");
                    continue; // Permite nova busca sem sair do loop
                }

                Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                        .create();

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Título já convertido:");
                System.out.println(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Erro ao converter um valor numérico. Verifique os dados recebidos.");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro na construção da URL. Verifique a entrada de dados.");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }

        System.out.println("Programa finalizado.");
    }
}
