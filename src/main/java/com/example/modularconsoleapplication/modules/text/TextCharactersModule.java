package com.example.modularconsoleapplication.modules.text;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class TextCharactersModule extends TextModule {
    @Override
    public String getDescription() {
        return "Вывести количество символов в файле";
    }

    @Override
    public String getValue(File file, String args) {
        long charactersCount = 0;
        char searchChar = args.toCharArray()[0];

        try {
            for (String line: Files.readAllLines(file.toPath())
                 ) {
                for(char c: line.toCharArray()) {
                    if (c == searchChar) {
                        charactersCount++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.valueOf(charactersCount);
    }
}
