package test123;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(new File("dir1" + path));
			

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;

	}
}