package com.example.modularconsoleapplication;

import org.apache.commons.io.FilenameUtils;

import java.io.File;

public interface Module {
    boolean checkExtension(File file);

    String getDescription();

    String getValue(File file, String args);
}
