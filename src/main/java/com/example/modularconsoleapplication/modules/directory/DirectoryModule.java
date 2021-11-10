package com.example.modularconsoleapplication.modules.directory;

import com.example.modularconsoleapplication.Module;

import java.io.File;

public abstract class DirectoryModule implements Module {
    @Override
    public boolean checkExtension(File file) {
        return file.isDirectory();
    }
}
