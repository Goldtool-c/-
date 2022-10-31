package by.gladyshev.task;

import by.gladyshev.util.RGBContext;

import java.awt.*;

public class LogConverter {
    private static LogConverter instance;

    private LogConverter(){}
    public static LogConverter getInstance() {
        if(instance==null) {
            instance = new LogConverter();
        }
        return instance;
    }
    public Color[][] convert(Color[][] pixels) {
        Color[][] result = new Color[pixels.length][pixels[0].length];
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                // F' = 255 * (log(1+F)/log(1+Fmax)
                int blue = (int) (255 * (Math.log(1 + pixels[i][j].getBlue())/Math.log(1 + RGBContext.getBlue())));
                int green = (int) (255 * (Math.log(1 + pixels[i][j].getGreen())/Math.log(1 + RGBContext.getGreen())));
                int red = (int) (255 * (Math.log(1 + pixels[i][j].getRed())/Math.log(1+RGBContext.getRed())));
                if (blue > 255) {
                    blue = 255;
                }
                if (green > 255) {
                    green = 255;
                }
                if (red > 255) {
                    red = 255;
                }
                result[i][j] = new Color(red, green, blue);
            }
        }
        return result;
    }
}
