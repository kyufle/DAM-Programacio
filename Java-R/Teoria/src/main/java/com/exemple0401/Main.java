package com.exemple0401;

public class Main {

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double sumar(double a, double b, double c) {
        return a + b;
    }

    public static void main(String[] args) {

        System.out.println("Suma 3+4=" + sumar(3, 4));
        System.out.println("Suma -2.5+6+4=" + sumar(-2.5, 6, 4));
    }
}
