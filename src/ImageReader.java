//import java.awt.*;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.*;
//
//public class ImageReader {
//    private Image image;
//
//    public ImageReader() {
//        image = null;
//    }
//
//    public Image readImage(String fileName) {
//        try {
//            File file = new File("../" + fileName);
//            image = ImageIO.read(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return image;
//    }
//}
