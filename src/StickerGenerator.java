import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class StickerGenerator {

	public void create() throws Exception {
		
		//leitura da imagem
			
		BufferedImage originalImage = ImageIO.read(new File("entrada/pulp.jpg"));
		
		//cria nova imagem em memória com transparência e com tamanho novo
		
		int width = originalImage.getWidth();
		int height = originalImage.getHeight();
		int newHeight = height + 350;
		
		BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
		
		//copiar a imagem original pra novo imagem (em memória)
		
		Graphics2D graphics = (Graphics2D) newImage.getGraphics();
		graphics.drawImage(originalImage, 0, 0, null);
		
		
		//escrever a nova imagem em um arquivo
		ImageIO.write(newImage, "png", new File("saida/sticker.png"));
		
	}
	
	public static void main(String[] args) throws Exception {
		var generator = new StickerGenerator();
		generator.create();
	}

}
