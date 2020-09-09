package com.buyalskaya.text.main;

import com.buyalskaya.text.entity.BaseComponent;
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
            BaseComponent component = dataReader.textReader();
            List<BaseComponent> sentences = componentService.sortSentencesOnCountWords(component);
            printText.printComponents(sentences);

            //Task 3
            int numberOfSentence = 0;
            Set<BaseComponent> wordThatAbsentInOtherSentences =
                    componentService.findWordThatAbsentInOtherSentences(component, numberOfSentence);
            printText.printDifferentComponents(wordThatAbsentInOtherSentences);

            //Task 6
            List<BaseComponent> allWords = componentService.sortWordsOnFirstLetter(component);
            printText.printWordsSortedOnFirstLetter(allWords);

            //Task 7
            List<BaseComponent> allWordsSortedOnVowelProportion = componentService.sortWordsOnVowelProportion(component);
            printText.printComponents(allWordsSortedOnVowelProportion);

            //Task 8
            List<BaseComponent> sortWordsStartFromVowelOnFirstConsonant =
                    componentService.sortWordsStartFromVowelOnFirstConsonant(component);
            printText.printComponents(sortWordsStartFromVowelOnFirstConsonant);
        } catch (TextReaderException | ServiceException e) {
            e.printStackTrace();
        }
    }
}