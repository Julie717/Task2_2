package com.buyalskaya.text.parser.impl;

import com.buyalskaya.text.entity.ComponentName;
import com.buyalskaya.text.entity.impl.TextComponent;
import com.buyalskaya.text.parser.BaseParser;

import java.util.stream.Stream;

public class TextParser implements BaseParser {
    private static final String PARAGRAPH_END = "(?<=\n)";
    private ParagraphParser paragraphParser = new ParagraphParser();

    @Override
    public TextComponent parse(String text) {
        TextComponent textComponent = new TextComponent(ComponentName.TEXT);
        String[] textParts = text.split(PARAGRAPH_END);
        Stream.of(textParts).map(p -> paragraphParser.parse(p)).forEach(p -> textComponent.add(p));
        return textComponent;
    }
}