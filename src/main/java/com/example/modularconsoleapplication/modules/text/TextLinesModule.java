package com.example.modularconsoleapplication.modules.text;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Component
public class TextLinesModule extends TextModule {
    public String getDescription() {
        return "Вывести количество строк в файле";
    }

    public String getValue(File file, String args) {
        long linesCount = 0L;

        try {
            linesCount = Files.lines(file.toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(linesCount);
    }
}
