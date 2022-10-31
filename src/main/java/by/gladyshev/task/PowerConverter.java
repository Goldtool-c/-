package by.gladyshev.task;

import java.awt.*;

public class PowerConverter {
    private static PowerConverter instance;

    private PowerConverter(){}
    public static PowerConverter getInstance() {
        if(instance==null) {
            instance = new PowerConverter();
        }
        return instance;
    }
    public Color[][] convert(double c, Color[][] pixels) {
        Color[][] result = new Color[pixels.length][pixels[0].length];
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                //F' = (F)^c
                //По-хорошему нужно нормировать тоже
                //Но не очень то и нужно все делать по-хорошему
                int blue = (int) Math.pow(pixels[i][j].getBlue(), c);
                int green = (int) Math.pow(pixels[i][j].getGreen(), c);
                int red = (int) Math.pow(pixels[i][j].getRed(), c);
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
