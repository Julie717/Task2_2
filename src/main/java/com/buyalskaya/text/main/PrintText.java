package com.buyalskaya.text.main;

import com.buyalskaya.text.entity.Component;

import java.util.List;
import java.util.Set;

public class PrintText {
    private static final String TABULATION = "\n\t";
    private static final String SPACE = " ";

    public void printSentences(List<Component> sentences) {
        sentences.stream().forEach(s -> System.out.println(s));
    }

    public void printDifferentWords(Set<Component> words) {
        words.stream().forEach(w -> System.out.println(w));
    }

    public void printWordsSortedOnFirstLetter(List<Component> words) {
        char firstLetterOfWord1;
        int amountOfWords = words.size();
        char firstLetterOfWord2;
        StringBuilder onePrintRow = new StringBuilder();
        onePrintRow.append(TABULATION);
        onePrintRow.append(words.get(0));
        for (int i = 1; i < amountOfWords; i++) {
            firstLetterOfWord1 = words.get(i - 1).getChild(0).toString().toUpperCase().charAt(0);
            firstLetterOfWord2 = words.get(i).getChild(0).toString().toUpperCase().charAt(0);
            if (firstLetterOfWord1 == firstLetterOfWord2) {
                onePrintRow.append(SPACE);
            } else {
                System.out.print(onePrintRow.toString());
                onePrintRow.delete(0, onePrintRow.length());
                onePrintRow.append(TABULATION);
            }
            onePrintRow.append(words.get(i));
        }
        System.out.print(onePrintRow);
    }

    public void printWords(List<Component> words) {
        words.stream().forEach(w -> System.out.println(w));
    }
}