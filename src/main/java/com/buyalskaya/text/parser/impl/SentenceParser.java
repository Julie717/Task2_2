package com.buyalskaya.text.parser.impl;

import com.buyalskaya.text.entity.ComponentName;
import com.buyalskaya.text.entity.impl.TextComponent;
import com.buyalskaya.text.parser.BaseParser;

import java.util.stream.Stream;

public class SentenceParser implements BaseParser {
    private static final String REGEX_SENTENCE = "\\b(?=[\\pL\\d]+)(?<!\\pL[-'])";
    private LexemeParser lexemeParser = new LexemeParser();

    @Override
    public TextComponent parse(String text) {
        TextComponent textComponent = new TextComponent(ComponentName.SENTENCE);
        String[] textParts = text.split(REGEX_SENTENCE);
        Stream.of(textParts).forEach(p -> textComponent.add(lexemeParser.parse(p)));
        return textComponent;
    }
}