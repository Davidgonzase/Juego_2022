package loaders;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * ImageLoader is used to load all the images we need
 */
public class ImageLoader{
    /**
     * @param path gets the path to the folder where the images are stored
     * @return image that we have loaded, if not, an exception will be launched
     */
    public static BufferedImage loadim(String path){
        try {
            return ImageIO.read(ImageLoader.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
