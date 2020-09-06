package com.buyalskaya.text.parser;

import com.buyalskaya.text.entity.impl.TextComponent;

public interface BaseParser {
    TextComponent parse(String text);
}