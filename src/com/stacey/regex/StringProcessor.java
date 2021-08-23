package com.stacey.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {
    public void countLetters(String input) {
        Pattern patternLowercase = Pattern.compile("[a-z]");
        Pattern patternCapital = Pattern.compile("[A-Z]");
        Pattern patternLetters = Pattern.compile("[a-zA-Z]");

        printCount(patternLowercase, input, "Lowercase: ");
        printCount(patternCapital, input, "Capital: ");
        printCount(patternLetters, input, "All: ");
    }

    private void printCount(Pattern pattern, String input, String message) {
        Matcher matcher = pattern.matcher(input);
        long count = matcher.results().count();
        System.out.println(message + count);
    }

    public void normalizeString(String input) {
        String middle = deleteSpaces(" +", input, " ");
        String begin = deleteSpaces("^( +)", middle, "");
        String end = deleteSpaces("( +)$", begin, "");
        System.out.println("Normalized:" + end + ".");
    }

    private String deleteSpaces(String regex, String input, String replace) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll(replace);
    }

    public void countWords(String input) {
        Pattern patternWord = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = patternWord.matcher(input);
        System.out.println(matcher.results().count()+" words");
    }

    public void filterNumbers(String input) {
        Pattern patternNumber = Pattern.compile("\\d+");
        Pattern patternNotNumber = Pattern.compile("[\\D\\-]+");
        Matcher matcher = patternNotNumber.matcher(input);
        matcher.replaceAll(" ");

        matcher = patternNumber.matcher(input);
        List<Integer> integers = new ArrayList<>();
        while (matcher.find()) {
            integers.add(Integer.parseInt(matcher.group()));
        }
        integers.forEach(System.out::println);
    }

    public void deleteDuplicatesAndSpaces(String input) {
        String copy = new StringBuilder(input).reverse().toString();
        copy = copy.replaceAll("(.)(?=.*\\1)", "");
        copy = new StringBuilder(copy).reverse().toString();
        System.out.println(copy);
    }
}
