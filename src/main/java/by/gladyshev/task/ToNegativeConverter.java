package by.gladyshev.task;

import java.awt.*;

public class ToNegativeConverter {
    private static ToNegativeConverter instance;

    private ToNegativeConverter(){}
    public static ToNegativeConverter getInstance() {
        if(instance==null) {
            instance = new ToNegativeConverter();
        }
        return instance;
    }
    public Color[][] convert(Color[][] pixels)
    {
        Color[][] result = new Color[pixels.length][pixels[0].length];
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                //Преобразование в негатив осуществляется вычитанием текущего цветового значения пикселя из 255
                int blue = 255 - pixels[i][j].getBlue();
                int green = 255 - pixels[i][j].getGreen();
                int red = 255 - pixels[i][j].getRed();
                if(blue > 255) {blue = 255;}
                if(green > 255) {green = 255;}
                if(red > 255) {red = 255;}
                result[i][j] = new Color(red, green, blue);
            }
        }
        return result;
    }
}
