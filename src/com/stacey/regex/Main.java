package com.stacey.regex;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        StringProcessor processor = new StringProcessor();

        System.out.println("1) Count letters");
        processor.countLetters(in.nextLine());
        System.out.println("2) Delete extra spaces");
        processor.normalizeString(in.nextLine());
        System.out.println("3) Count words");
        processor.countWords(in.nextLine());
        System.out.println("4) Show numbers");
        processor.filterNumbers2(in.nextLine());
        System.out.println("5) Delete duplicates");
        processor.deleteDuplicatesAndSpaces(in.nextLine());
    }
}
