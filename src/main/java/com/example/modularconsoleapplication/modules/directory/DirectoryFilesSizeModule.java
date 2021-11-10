package com.example.modularconsoleapplication.modules.directory;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DirectoryFilesSizeModule extends DirectoryModule {
    public String getDescription() {
        return "Вывести размер всех файлов в директории";
    }

    public String getValue(File file, String args) {
        return String.valueOf(file.getTotalSpace() / 1024);
    }
}
