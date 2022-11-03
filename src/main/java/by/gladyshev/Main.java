package by.gladyshev;

import by.gladyshev.task.*;
import by.gladyshev.util.*;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String... args) throws IOException {
        File file = new File("sw1.bmp");
        Color[][] pixels = new Color[0][0];
        try {
            pixels = BMPtoMatrixParser.getInstance().parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FindMaxRGB.getInstance().find(pixels);
        System.out.println("Enter constant to add");
        Scanner sc = new Scanner(System.in);
        double c = sc.nextDouble();
        Color[][] enbrightenedPixels = AddConstant.getInstance().add(c, pixels);
        PixelsToFileConverter.getInstance().convertAndSave(enbrightenedPixels, "firstTask.jpg");
        System.out.println("Enter constant to multiply by");
        c = sc.nextDouble();
        enbrightenedPixels = MultiplyByConstant.getInstance().add(c, pixels);
        PixelsToFileConverter.getInstance().convertAndSave(enbrightenedPixels, "SecondTask.jpg");
        enbrightenedPixels = ToNegativeConverter.getInstance().convert(pixels);
        PixelsToFileConverter.getInstance().convertAndSave(enbrightenedPixels, "negative.jpg");
        enbrightenedPixels = LogConverter.getInstance().convert(pixels);
        PixelsToFileConverter.getInstance().convertAndSave(enbrightenedPixels, "log.jpg");
        System.out.println("Enter constant for power");
        double power = sc.nextDouble();
        enbrightenedPixels = PowerConverter.getInstance().convert(power, pixels);
        PixelsToFileConverter.getInstance().convertAndSave(enbrightenedPixels, "power.jpg");

    }
}
