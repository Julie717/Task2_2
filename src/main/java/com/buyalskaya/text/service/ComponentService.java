package com.buyalskaya.text.service;

import com.buyalskaya.text.entity.Component;
import com.buyalskaya.text.entity.ComponentName;

import java.util.List;
import java.util.Optional;

public interface ComponentService {
	List<Component> find(Component component, ComponentName componentName);
	int countVowelsInWord(Component word);
	int countWordsInSentence(Component sentence);
	Optional<Character> findFirstConsonant(Component word);
}