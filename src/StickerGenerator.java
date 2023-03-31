import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;


public class StickerGenerator {

	public void create(InputStream inputStream, String fileName) throws Exception {
		
		//leitura da imagem
		
		//InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_8.jpg")
		//		.openStream();
		BufferedImage originalImage = ImageIO.read(inputStream);
		
		//cria nova imagem em memória com transparência e com tamanho novo
		
		int width = originalImage.getWidth();
		int height = originalImage.getHeight();
		int newHeight = height + 350;
		
		BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
		
		//copiar a imagem original pra novo imagem (em memória)
		
		Graphics2D graphics = (Graphics2D) newImage.getGraphics();
		graphics.drawImage(originalImage, 0, 0, null);
		
		
		//configurar a fonte
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setColor(Color.YELLOW);
		graphics.setFont(font);
		
		//escrever uma frase na nova imagem
		graphics.drawString(fileName, 200, newHeight - 150);
		
		//escrever a nova imagem em um arquivo
		ImageIO.write(newImage, "png", new File(fileName));
		
	}

}
