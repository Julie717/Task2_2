package com.buyalskaya.text.main;

import com.buyalskaya.text.entity.Component;
import com.buyalskaya.text.exception.ServiceException;
import com.buyalskaya.text.exception.TextReaderException;
import com.buyalskaya.text.reader.DataReader;
import com.buyalskaya.text.service.impl.ComponentServiceImpl;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        ComponentServiceImpl componentService = new ComponentServiceImpl();
        PrintText printText = new PrintText();
        try {
            //Task 2
            Component component = dataReader.textReader();
            List<Component> sentences = componentService.sortSentencesOnCountWords(component);
            printText.printSentences(sentences);

            //Task 3
            int numberOfSentence = 0;
            Set<Component> wordThatAbsentInOtherSentences =
                    componentService.findWordThatAbsentInOtherSentences(component, numberOfSentence);
            printText.printDifferentWords(wordThatAbsentInOtherSentences);

            //Task 6
            List<Component> allWords = componentService.sortWordsOnFirstLetter(component);
            printText.printWordsSortedOnFirstLetter(allWords);

            //Task 7
            List<Component> allWordsSortedOnVowelProportion = componentService.sortWordsOnVowelProportion(component);
            printText.printWords(allWordsSortedOnVowelProportion);

            //Task 8
            List<Component> sortWordsStartFromVowelOnFirstConsonant =
                    componentService.sortWordsStartFromVowelOnFirstConsonant(component);
            printText.printWords(sortWordsStartFromVowelOnFirstConsonant);
        } catch (TextReaderException | ServiceException e) {
            e.printStackTrace();
        }
    }
}