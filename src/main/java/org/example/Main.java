package org.example;

import org.example.app.App;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            new App(sc).run();
        sc.close();
    }
}

