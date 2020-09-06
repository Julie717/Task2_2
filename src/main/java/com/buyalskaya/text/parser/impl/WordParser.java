package com.buyalskaya.text.parser.impl;

import com.buyalskaya.text.entity.Component;
import com.buyalskaya.text.entity.ComponentName;
import com.buyalskaya.text.entity.impl.Symbol;
import com.buyalskaya.text.entity.impl.TextComponent;
import com.buyalskaya.text.parser.BaseParser;

public class WordParser implements BaseParser {
    private static final String REGEX_LETTER = "\\pL";
    private static final String REGEX_DIGIT = "\\d";

    @Override
    public TextComponent parse(String text) {
        TextComponent textComponent = new TextComponent(ComponentName.WORD);
        text.chars()
                .mapToObj(ch -> parseSymbol((char) ch))
                .forEach(s -> textComponent.add(s));
        return textComponent;
    }

    private Component parseSymbol(char symbol) {
        Component component;
        if (Character.toString(symbol).matches(REGEX_LETTER)) {
            component = new Symbol(symbol, ComponentName.LETTER);
        } else if (Character.toString(symbol).matches(REGEX_DIGIT)) {
            component = new Symbol(symbol, ComponentName.DIGIT);
        } else {
            component = new Symbol(symbol, ComponentName.PUNCTUATION_MARK);
        }
        return component;
    }
}