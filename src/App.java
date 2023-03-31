import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//fazer uma conexão http e buscar os 250 filmes
		//String poke = "https://pokeapi.co/api/v2/pokemon/1";
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		
		ClientHttp http = new ClientHttp();
		
		String json = http.searchData(url);
		
		
		//exibir e manipular os dados que a gente quiser
		
		ContentExtract extract = new ExtractIMDBContent();
		List<Content> contents = extract.extractContent(json);
		
		
		StickerGenerator generator = new StickerGenerator();
		
		for (int i = 0; i < 3; i++) {
	
			Content content = contents.get(i);	
			String fileName = "saida/" + content.getTitle() + ".png";
		
			
			InputStream inputStream = new URL(content.getUrlImage()).openStream();
			
			generator.create(inputStream, fileName);
			
			System.out.println(content.getTitle());
            System.out.println();

		}
		
	}

}

