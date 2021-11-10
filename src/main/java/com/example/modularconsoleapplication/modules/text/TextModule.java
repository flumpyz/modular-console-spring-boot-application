package com.example.modularconsoleapplication.modules.text;

import com.example.modularconsoleapplication.Module;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

public abstract class TextModule implements Module{
    private final String EXTENSIONS = "txt, ini, xml, html";

    @Override
    public boolean checkExtension(File file) {
        String fileExtension = FilenameUtils.getExtension(file.getName());
        return file.isFile() && EXTENSIONS.contains(fileExtension);
    }
}
