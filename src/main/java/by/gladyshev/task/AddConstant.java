package by.gladyshev.task;

import java.awt.*;

public class AddConstant {
    private static AddConstant instance;

    private AddConstant(){}
    public static AddConstant getInstance() {
        if(instance==null) {
            instance = new AddConstant();
        }
        return instance;
    }
    // добавляем int c к каждому значению RGB каждого пикселя
    public Color[][] add(double c, Color[][] pixels)
    {
        Color[][] result = new Color[pixels.length][pixels[0].length];
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                int blue = (int) (pixels[i][j].getBlue()+c);
                int green = (int) (pixels[i][j].getGreen()+c);
                int red = (int) (pixels[i][j].getRed()+c);
                // В результате операции значние может превысить 255
                // В таком случае его нужно срезать
                if(blue > 255) {blue = 255;}
                if(green > 255) {green = 255;}
                if(red > 255) {red = 255;}
                if(blue < 0) {blue = 0;}
                if(green < 0) {green = 0;}
                if(red < 0) {red = 0;}
                result[i][j] = new Color(red, green, blue);
            }
        }
        return result;
    }
}
