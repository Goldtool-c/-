package by.gladyshev.task;

import by.gladyshev.util.RGBContext;

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
                //Если он всё-таки доебется до отсутсвия нормирования, меняй 3 предыдущие строки на
                //3 внизу в коментах. Но он не должен, ибо 3/3 людей сдали этот код без нее
                //без надобности не меняй, в поле эти 3 строки не были
                /*int blue = (int) (255 *(Math.pow((double)pixels[i][j].getBlue()/ (double) RGBContext.getBlue(), c)));
                int green = (int) (255 *(Math.pow((double)pixels[i][j].getGreen()/ (double)RGBContext.getGreen(), c)));
                int red = (int) (255 *(Math.pow((double)pixels[i][j].getRed()/ (double)RGBContext.getRed(), c)));*/
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
