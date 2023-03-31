import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//fazer uma conexão http e buscar os 250 filmes
		String poke = "https://pokeapi.co/api/v2/pokemon/1";
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		URI endereco = URI.create(poke); //criar uma URI
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build(); //buscar dados de uma url
		var response = client.send(request, BodyHandlers.ofString());
		String body = response.body(); //pegar o body e jogar numa string
		//System.out.println(body);
		
		
		var parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);  //lista -> map, string da chave, string do valor
		//System.out.println(listaDeFilmes.get(0));
		
		
		
		//exibir e manipular os dados que a gente quiser
		
		for (Map<String, String> filme : listaDeFilmes) {
			System.out.println(filme.get("name"));
            System.out.println();

		}
		
		System.out.println(listaDeFilmes.size());
		
	}

}

