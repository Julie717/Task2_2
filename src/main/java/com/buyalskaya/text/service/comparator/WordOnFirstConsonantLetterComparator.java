package com.buyalskaya.text.service.comparator;

import com.buyalskaya.text.entity.Component;
import com.buyalskaya.text.service.ServiceFactory;

import java.util.Comparator;
import java.util.Optional;

public class WordOnFirstConsonantLetterComparator implements Comparator<Component> {
    @Override
    public int compare(Component w1, Component w2) {
        Optional<Character> firstConsonant1 = ServiceFactory.getInstance().getComponentService().findFirstConsonant(w1);
        Optional<Character> firstConsonant2 = ServiceFactory.getInstance().getComponentService().findFirstConsonant(w2);
        if (firstConsonant1.isPresent() && firstConsonant2.isEmpty()) {
            return 1;
        }
        if (firstConsonant1.isEmpty() && firstConsonant2.isPresent()) {
            return -1;
        }
        if (firstConsonant1.isEmpty() && firstConsonant2.isEmpty()) {
            return 0;
        }
        return firstConsonant1.get().compareTo(firstConsonant2.get());
    }
}