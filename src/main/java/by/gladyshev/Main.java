package by.gladyshev;

import by.gladyshev.task.*;
import by.gladyshev.util.*;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String... args) throws IOException {
        //чисто ради приличия поставьте свою картинку
        File file = new File("sw1.bmp");
        Color pixels[][] = new Color[0][0];
        try {
            pixels = BMPtoMatrixParser.getInstance().parse(file);// Преобразование изображения в матрицу пикселей
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Поиск максимальных значений каждого из цветов для последующей нормировки в
        /**link @util.LogConverter**/
        FindMaxRGB.getInstance().find(pixels);
        System.out.println("Enter constant to add");
        Scanner sc = new Scanner(System.in);
        double c = sc.nextDouble();
        Color[][] enbrightenedPixels = AddConstant.getInstance().add(c, pixels); // Добавление константы к изображению служит для
        //увеличения его яркости
        PixelsToFileConverter.getInstance().convertAndSave(enbrightenedPixels, "firstTask.jpg");
        System.out.println("Enter constant to multiply by");
        c = sc.nextDouble();
        enbrightenedPixels = MultiplyByConstant.getInstance().add(c, pixels);// умножение изображения на константу служит для увеличения
        // контрастности при с>1
        PixelsToFileConverter.getInstance().convertAndSave(enbrightenedPixels, "SecondTask.jpg");
        enbrightenedPixels = ToNegativeConverter.getInstance().convert(pixels);// тут без комментариев...
        PixelsToFileConverter.getInstance().convertAndSave(enbrightenedPixels, "negative.jpg");
        //Данная функция используется с целью увеличения контраста на
        //изображениях с малыми значениями яркости
        enbrightenedPixels = LogConverter.getInstance().convert(pixels);
        PixelsToFileConverter.getInstance().convertAndSave(enbrightenedPixels, "log.jpg");
        System.out.println("Enter constant for power");
        double power = sc.nextDouble();
        //Данная операция вызывает отображение узкого
        //диапазона больших входных значений в широкий диапазон выходных
        //значений, при этом для малых входных значений верно обратное
        //утверждение.
        enbrightenedPixels = PowerConverter.getInstance().convert(power, pixels);
        PixelsToFileConverter.getInstance().convertAndSave(enbrightenedPixels, "power.jpg");

    }
}
