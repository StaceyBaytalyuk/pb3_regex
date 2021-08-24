package com.stacey.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        return Pattern.compile(regex)
                .matcher(input)
                .replaceAll(replace);
    }

    public void countWords(String input) {
        long n = Pattern.compile("\\b\\w+\\b").matcher(input).results().count();
        System.out.println(n + " words");
    }

    public void filterNumbers1(String input) {
        Pattern patternNumber = Pattern.compile("\\d+");
        Matcher matcher = patternNumber.matcher(input);
        List<Integer> integers = new ArrayList<>();
        while (matcher.find()) {
            integers.add(Integer.parseInt(matcher.group()));
        }
        integers.forEach(System.out::println);
    }

    // alternative
    public void filterNumbers2(String input) {
        List<String> matches = Pattern.compile("\\d+")
                .matcher(input)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.toList());
        matches.forEach(System.out::println);
    }

    public void deleteDuplicatesAndSpaces(String input) {
        String copy = new StringBuilder(input).reverse().toString();
        copy = copy.replaceAll("(.)(?=.*\\1)", "");
        copy = new StringBuilder(copy).reverse().toString();
        String res = copy.replaceAll(" ", "");
        System.out.println(res);
    }

    public void findByC() {
        List<String> progLangs = Arrays.asList("apl", "basic", "c", "c++", "c#", "cobol", "java", "javascript", "perl", "python", "scala");
        Pattern p = Pattern.compile("^c");
        progLangs.stream().filter(p.asPredicate()).forEach(System.out::println);
    }
}
