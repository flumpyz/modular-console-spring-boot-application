package com.example.modularconsoleapplication.modules.directory;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class DirectoryFilesModule extends DirectoryModule {
    public String getDescription() {
        return "Вывести все файлы в директории";
    }

    public String getValue(File file, String args) {
        StringBuilder files = new StringBuilder();
        for (File item: Objects.requireNonNull(file.listFiles())
             ) {
            if (item.isFile()) {
                files.append(item).append("\n");
            }
        }
        return files.toString();
    }
}
