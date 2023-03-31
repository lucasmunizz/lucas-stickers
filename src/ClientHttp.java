import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class ClientHttp {
	
	public String searchData(String url) {
		
		try {
			URI endereco = URI.create(url); //criar uma URI
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(endereco).GET().build(); //buscar dados de uma url
			var response = client.send(request, BodyHandlers.ofString());
			String body = response.body(); //pegar o body e jogar numa string
			return body;
		}
		
		catch (IOException | InterruptedException ex ) {
			throw new RuntimeException(ex);
		}
		
	
	}
	
}
