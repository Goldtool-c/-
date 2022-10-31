package by.gladyshev.util;

import java.awt.*;

public class RGBtoGreyConverter { //Преобразование цветной картинки в монохром
    //Это рудимент, оставшейся от моей первой попытки сделать лабу
    //Эту хрень можно удалить
    private static RGBtoGreyConverter instance;

    private RGBtoGreyConverter(){}
    public static RGBtoGreyConverter getInstance() {
        if(instance==null) {
            instance = new RGBtoGreyConverter();
        }
        return instance;
    }
    public int[][] convertToGrey(Color[][] pixels)
    {
        int[][] result = new int[pixels.length][pixels[0].length];
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[j].length; j++) {
                int blue = pixels[i][j].getBlue();
                int green = pixels[i][j].getGreen();
                int red = pixels[i][j].getRed();
                int grey = (int) ((0.3*red) + (0.59*green) + (0.11*blue));
                result[i][j] = grey;
            }
        }

        return result;
    }
    public Color[][] convertToRGB(int[][] pixels)
    {
        Color[][] result = new Color[pixels.length][pixels[0].length];
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[j].length; j++) {
                int blue = (int) (0.25*pixels[i][j]);
                int green = (int) (0.45*pixels[i][j]);
                int red = (int) (0.2*pixels[i][j]);
                if(blue > 255) {blue = 255;}
                if(green > 255) {green = 255;}
                if(red > 255) {red = 255;}
                result[i][j] = new Color(red, green, blue);
            }
        }
        return result;
    }
}
