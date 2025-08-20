package com.example.util;

public class TextCleaner {
    public static String normalize(String text) {
        if (text == null) return null;

        // Fix curly quotes
        text = text.replace("\u201C", "\""); // left double quote
        text = text.replace("\u201D", "\""); // right double quote
        text = text.replace("\u2018", "'");  // left single quote
        text = text.replace("\u2019", "'");  // right single quote

        // Fix dashes
        text = text.replace("\u2013", "-");  // en dash
        text = text.replace("\u2014", "-");  // em dash

        // Fix ellipsis
        text = text.replace("\u2026", "...");

        return text.trim();
    }
}
