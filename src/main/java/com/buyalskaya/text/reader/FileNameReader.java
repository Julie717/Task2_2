package com.buyalskaya.text.reader;

import com.buyalskaya.text.exception.TextReaderException;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class FileNameReader {
    private static final String FILE_NAME = "fileName";
    private String fileName;

    public FileNameReader() throws TextReaderException {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("fileProperties");
            fileName = resourceBundle.getString(FILE_NAME);
        } catch (MissingResourceException ex) {
            throw new TextReaderException("Properties file is missing", ex);
        }
    }

    public String getFileName() {
        return fileName;
    }
}