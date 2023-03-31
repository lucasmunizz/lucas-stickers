import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractNasaContent implements ContentExtract {
	
	public List<Content> extractContent(String json){
		
		var parser = new JsonParser();
		List<Map<String, String>> attributeList = parser.parse(json);  //lista -> map, string da chave, string do valor
		
		List<Content> contents = new ArrayList<>();
		
		for(Map<String, String> attributes : attributeList) {
			
			String title = attributes.get("title");
			String image = attributes.get("url");
			
			Content content = new Content(title, image);
			contents.add(content);
		}
		
		return contents;
	}
	
}
