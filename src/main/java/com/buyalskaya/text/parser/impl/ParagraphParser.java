package com.buyalskaya.text.parser.impl;

import com.buyalskaya.text.entity.ComponentName;
import com.buyalskaya.text.entity.impl.TextComponent;
import com.buyalskaya.text.parser.BaseParser;

import java.util.stream.Stream;

public class ParagraphParser implements BaseParser {
    private static final String SENTENCE_END = "(?<=[.!?]\\s)";
    private SentenceParser sentenceParser = new SentenceParser();

    @Override
    public TextComponent parse(String text) {
        TextComponent textComponent = new TextComponent(ComponentName.PARAGRAPH);
        String[] textParts = text.split(SENTENCE_END);
        Stream.of(textParts).forEach(p -> textComponent.add(sentenceParser.parse(p)));
        return textComponent;
    }
}