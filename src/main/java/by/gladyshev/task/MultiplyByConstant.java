package by.gladyshev.task;

import java.awt.*;

public class MultiplyByConstant {
    private static MultiplyByConstant instance;

    private MultiplyByConstant(){}
    public static MultiplyByConstant getInstance() {
        if(instance==null) {
            instance = new MultiplyByConstant();
        }
        return instance;
    }
    public Color[][] add(double c, Color[][] pixels)
    {
        Color[][] result = new Color[pixels.length][pixels[0].length];
        //Опять же, проходим циклами по матрице пикселей
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                //И умножаем каждый цвет каждого пикселя на с
                int blue = (int) (pixels[i][j].getBlue()*c);
                int green = (int) (pixels[i][j].getGreen()*c);
                int red = (int) (pixels[i][j].getRed()*c);
                if(blue > 255) {blue = 255;}
                if(green > 255) {green = 255;}
                if(red > 255) {red = 255;}
                result[i][j] = new Color(red, green, blue);
            }
        }
        return result;
    }
}
