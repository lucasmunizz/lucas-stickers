import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractIMDBContent implements ContentExtract {
	
	public List<Content> extractContent(String json){
		
		var parser = new JsonParser();
		List<Map<String, String>> attributeList = parser.parse(json);
		
		List<Content> contents = new ArrayList<>();
		
		for (Map<String, String> attribute: attributeList) {
			String title = attribute.get("title");
			String image = attribute.get("image");
			Content content = new Content(title, image);
			contents.add(content);
		}
		
		return contents;
		
	}
}
