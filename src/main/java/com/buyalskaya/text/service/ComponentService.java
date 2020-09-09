package com.buyalskaya.text.service;

import com.buyalskaya.text.entity.BaseComponent;
import com.buyalskaya.text.entity.ComponentName;

import java.util.List;
import java.util.Optional;

public interface ComponentService {
    List<BaseComponent> find(BaseComponent component, ComponentName componentName);

    int countVowelsInWord(BaseComponent word);

    int countWordsInSentence(BaseComponent sentence);

    Optional<Character> findFirstConsonant(BaseComponent word);
}