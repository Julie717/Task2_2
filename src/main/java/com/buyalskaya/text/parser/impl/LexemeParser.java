package com.buyalskaya.text.parser.impl;

import com.buyalskaya.text.entity.Component;
import com.buyalskaya.text.entity.ComponentName;
import com.buyalskaya.text.entity.impl.Symbol;
import com.buyalskaya.text.entity.impl.TextComponent;
import com.buyalskaya.text.parser.BaseParser;

public class LexemeParser implements BaseParser {
    private static final String REGEX_LEXEME = "\\b(?=([\\p{Punct}\\s&&[^-']])+)";
    private static final String REGEX_WORD = "[\\pL\\d-']+";
    private static final char SPACE = ' ';
    private static final Component SPACE_COMPONENT = new Symbol(SPACE, ComponentName.SPACE);
    private static final char PARAGRAPH_END = '\n';
    private static final Component PARAGRAPH_END_COMPONENT = new Symbol(PARAGRAPH_END, ComponentName.PARAGRAPH_END);
    private WordParser wordParser = new WordParser();

    @Override
    public TextComponent parse(String text) {
        TextComponent textComponent = new TextComponent(ComponentName.LEXEME);
        String[] textParts = text.split(REGEX_LEXEME);
        for (String textPart : textParts) {
            if (textPart.matches(REGEX_WORD)) {
                textComponent.add(wordParser.parse(textPart));
            } else {
                for (char symbol : textPart.toCharArray()) {
                    parsePunctuation(symbol, textComponent);
                }
            }
        }
        return textComponent;
    }

    private void parsePunctuation(char punctuation, TextComponent textComponent) {
        switch (punctuation) {
            case SPACE:
                textComponent.add(SPACE_COMPONENT);
                break;
            case PARAGRAPH_END:
                textComponent.add(PARAGRAPH_END_COMPONENT);
                break;
            default:
                textComponent.add(new Symbol(punctuation, ComponentName.PUNCTUATION_MARK));
                break;
        }
    }
}