package by.gladyshev.util;

import java.awt.*;

public class FindMaxRGB {
    private static FindMaxRGB instance;

    private FindMaxRGB(){}
    public static FindMaxRGB getInstance() {
        if(instance==null) {
            instance = new FindMaxRGB();
        }
        return instance;
    }

    public void find(Color[][] pixels)
    {
        Color temp;
        //Поиск максимальных значений каждого из цветов для последующей нормировки в
        /**link @util.LogConverter**/
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length ; j++) {
                temp = pixels[i][j];
                if(temp.getRed()>=RGBContext.getRed())
                {
                    RGBContext.setRed(temp.getRed());
                }
                if(temp.getGreen()>=RGBContext.getGreen())
                {
                    RGBContext.setGreen(temp.getGreen());
                }
                if(temp.getBlue()>=RGBContext.getBlue())
                {
                    RGBContext.setBlue(temp.getBlue());
                }
            }
        }
    }
}
