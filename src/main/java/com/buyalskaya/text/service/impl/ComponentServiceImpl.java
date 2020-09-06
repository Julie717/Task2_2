package com.buyalskaya.text.service.impl;

import com.buyalskaya.text.entity.Component;
import com.buyalskaya.text.entity.ComponentName;
import com.buyalskaya.text.exception.ServiceException;
import com.buyalskaya.text.service.ComponentService;
import com.buyalskaya.text.service.comparator.SentenceAmountOfWordComparator;
import com.buyalskaya.text.service.comparator.WordOnFirstConsonantLetterComparator;
import com.buyalskaya.text.service.comparator.WordOnVowelProportionComparator;

import java.util.*;
import java.util.stream.Collectors;

public class ComponentServiceImpl implements ComponentService {
    private static final String VOWELS = "[aAeEiIoOuUyYаАеЕёЁиИоОуУыЫэЭюЮяЯ]";

    @Override
    public int countWordsInSentence(Component sentence) {
        int countWords = 0;
        if (sentence.getComponentName() == ComponentName.SENTENCE) {
            countWords = find(sentence, ComponentName.WORD).size();
        }
        return countWords;
    }

    public List<Component> sortSentencesOnCountWords(Component component) {
        List<Component> sentences = find(component, ComponentName.SENTENCE);
        SentenceAmountOfWordComparator sentenceAmountOfWordComparator = new SentenceAmountOfWordComparator();
        sentences.sort((s1, s2) -> sentenceAmountOfWordComparator.compare(s1, s2));
        return sentences;
    }

    public Set<Component> findWordThatAbsentInOtherSentences(Component component,
                                                             int numberOfSentence) throws ServiceException {
        List<Component> sentences = find(component, ComponentName.SENTENCE);
        int amountOfSentences = sentences.size();
        if (amountOfSentences < numberOfSentence || amountOfSentences == numberOfSentence) {
            throw new ServiceException("Incorrect number of sentence");
        }
        List<Component> wordsInRequestSentence = find(sentences.get(numberOfSentence), ComponentName.WORD);
        List<Component> wordsInSentence;
        Set<Component> resultWords = new HashSet<>(wordsInRequestSentence);
        for (int i = 0; i < amountOfSentences; i++) {
            if (i != numberOfSentence) {
                wordsInSentence = find(sentences.get(i), ComponentName.WORD);
                for (Component word : wordsInSentence) {
                    if (wordsInRequestSentence.contains(word)) {
                        resultWords.remove(word);
                    }
                }
            }
        }
        return resultWords;
    }

    public List<Component> sortWordsOnFirstLetter(Component component) {
        List<Component> allWords = find(component, ComponentName.WORD);
        allWords.sort((word1, word2) -> word1.toString().compareToIgnoreCase(word2.toString()));
        return allWords;
    }

    @Override
    public int countVowelsInWord(Component word) {
        int countVowels = 0;
        if (word.getComponentName() == ComponentName.WORD) {
            countVowels = (int) word.getChildren().stream()
                    .filter(s -> VOWELS.contains(s.toString().subSequence(0, 1)))
                    .count();
        }
        return countVowels;
    }

    public List<Component> sortWordsOnVowelProportion(Component component) {
        List<Component> allWords = find(component, ComponentName.WORD);
        WordOnVowelProportionComparator wordOnVowelProportionComparator = new WordOnVowelProportionComparator();
        allWords.sort((w1, w2) -> wordOnVowelProportionComparator.compare(w1, w2));
        return allWords;
    }

    public List<Component> findWordsStartFromVowel(List<Component> allWords) {
        List<Component> resultWords = allWords.stream()
                .filter(w -> w.getComponentName() == ComponentName.WORD)
                .filter(w -> VOWELS.contains(w.toString().subSequence(0, 1)))
                .collect(Collectors.toList());
        return resultWords;
    }

    public Optional<Character> findFirstConsonant(Component word) {
        if (word.getComponentName() == ComponentName.WORD) {
            Optional<Component> symbol = word.getChildren().stream()
                    .filter(w -> !VOWELS.contains(w.toString().subSequence(0, 1)))
                    .findFirst();
            if (symbol.isPresent()) {
                return Optional.of(symbol.get().toString().charAt(0));
            }
        }
        return Optional.empty();
    }

    public List<Component> sortWordsStartFromVowelOnFirstConsonant(Component component) {
        List<Component> allWords = find(component, ComponentName.WORD);
        List<Component> wordsStartFromVowel = findWordsStartFromVowel(allWords);
        WordOnFirstConsonantLetterComparator wordOnFirstConsonantLetterComparator = new WordOnFirstConsonantLetterComparator();
        wordsStartFromVowel.sort((w1, w2) -> wordOnFirstConsonantLetterComparator.compare(w1, w2));
        return wordsStartFromVowel;
    }

    @Override
    public List<Component> find(Component component, ComponentName componentName) {
        List<Component> result = new ArrayList<>();
        findOneComponent(component, componentName, result);
        return result;
    }

    private void findOneComponent(Component component,
                                  ComponentName componentName, List<Component> result) {
        if (component.getComponentName() == componentName) {
            result.add(component);
        } else {
            if (component.amountOfChild() > 0) {
                for (int i = 0; i < component.amountOfChild(); i++) {
                    findOneComponent(component.getChild(i), componentName, result);
                }
            }
        }
    }
}