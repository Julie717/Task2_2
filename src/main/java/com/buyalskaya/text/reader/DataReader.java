package com.buyalskaya.text.reader;

import com.buyalskaya.text.entity.impl.TextComponent;
import com.buyalskaya.text.exception.TextReaderException;
import com.buyalskaya.text.parser.impl.TextParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class DataReader {
    private static final String PARAGRAPH_END = "\n";

    public TextComponent textReader() throws TextReaderException {
        FileNameReader fileNameReader = new FileNameReader();
        String fileName = fileNameReader.getFileName();
        URL url = getClass().getClassLoader().getResource(fileName);
        if (url == null) {
            throw new TextReaderException("File not exist");
        }
        TextComponent textComponent;
        try (FileReader fileReader = new FileReader(Paths.get(url.toURI()).toFile());
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String resultText = bufferedReader.lines().collect(Collectors.joining(PARAGRAPH_END));
            TextParser textParser = new TextParser();
            textComponent = textParser.parse(resultText);
        } catch (IOException | URISyntaxException e) {
            throw new TextReaderException("Error in opening file " + fileName, e);
        }
        return textComponent;
    }
}