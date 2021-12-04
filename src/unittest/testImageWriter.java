package unittest;

import Renderer.ImageWriter;
import org.junit.jupiter.api.Test;

import java.awt.*;

class testImageWriter {

    @Test
    public void test() {
        ImageWriter imageWriter = new ImageWriter("imgWriterTest", 3600, 1200, 3600, 1200);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        for(int y = 0; y< nY; ++y){
            for (int x = 0; x < nX; ++x) {
                //background
                imageWriter.writePixel(x,y, new Color(204, 237, 255));
                //circle

                if(((0.00009 * Math.pow(x - 1800, 2) + 150) < y + 100) && ((0.00009 * Math.pow(x - 1800, 2) + 150) > y - 100)){
                    imageWriter.writePixel(x,y, new Color(255, 0, 24));
                }
                if(((0.00009 * Math.pow(x - 1800, 2) + 250) < y + 100) && ((0.00009 * Math.pow(x - 1800, 2) + 250) > y - 100)){
                    imageWriter.writePixel(x,y, new Color(255, 165, 44));
                }
                if(((0.00009 * Math.pow(x - 1800, 2) + 350) < y + 100) && ((0.00009 * Math.pow(x - 1800, 2) + 350) > y - 100)){
                    imageWriter.writePixel(x,y, new Color(255, 255, 65));
                }
                if(((0.00009 * Math.pow(x - 1800, 2) + 450) < y + 100) && ((0.00009 * Math.pow(x - 1800, 2) + 450) > y - 100)){
                    imageWriter.writePixel(x,y, new Color(0, 128, 24));
                }
                if(((0.00009 * Math.pow(x - 1800, 2) + 550) < y + 100) && ((0.00009 * Math.pow(x - 1800, 2) + 550) > y - 100)){
                    imageWriter.writePixel(x,y, new Color(0, 0, 249));
                }
                if(((0.00009 * Math.pow(x - 1800, 2) + 600) < y + 50) && ((0.00009 * Math.pow(x - 1800, 2) + 600) > y - 50)){
                    imageWriter.writePixel(x,y, new Color(134, 0, 125));
                }

            }
        }
        imageWriter.writeToImage();
    }
}