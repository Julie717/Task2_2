package com.buyalskaya.text.main;

import com.buyalskaya.text.entity.BaseComponent;

import java.util.List;
import java.util.Set;

public class PrintText {
    private static final String TABULATION = "\n\t";
    private static final String SPACE = " ";

    public void printComponents(List<BaseComponent> textParts) {
        textParts.stream().forEach(t -> System.out.println(t));
    }

    public void printDifferentComponents(Set<BaseComponent> textParts) {
        textParts.stream().forEach(t -> System.out.println(t));
    }

    public void printWordsSortedOnFirstLetter(List<BaseComponent> words) {
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
}