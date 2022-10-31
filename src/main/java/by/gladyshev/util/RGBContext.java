package by.gladyshev.util;

public class RGBContext { // здесь храним максимальные значения для последующей нормировки
    private static int red;
    private static int green;
    private static int blue;

    public static int getRed() {
        return red;
    }

    public static void setRed(int red) {
        RGBContext.red = red;
    }

    public static int getGreen() {
        return green;
    }

    public static void setGreen(int green) {
        RGBContext.green = green;
    }

    public static int getBlue() {
        return blue;
    }

    public static void setBlue(int blue) {
        RGBContext.blue = blue;
    }
}
