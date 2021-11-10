package com.example.modularconsoleapplication.modules.audio;

import com.example.modularconsoleapplication.Module;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

public abstract class AudioModule implements Module {
    private final String EXTENSIONS = "mp3, wma, aac, m4a, m4p, m4b, mp4, 3gp, ogg, oga, sb0, ogv";

    @Override
    public boolean checkExtension(File file) {
        String fileExtension = FilenameUtils.getExtension(file.getName());
        return file.isFile() && EXTENSIONS.contains(fileExtension);
    }
}
