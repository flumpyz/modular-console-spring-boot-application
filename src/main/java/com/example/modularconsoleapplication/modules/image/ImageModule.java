package com.example.modularconsoleapplication.modules.image;

import com.example.modularconsoleapplication.Module;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

public abstract class ImageModule implements Module {
    private final String EXTENSIONS = "jpg, jpeg, jpe, tif, tiff, webp, psd, png, bmp, dib, rle, gif, ico, pcx, pcc";

    @Override
    public boolean checkExtension(File file) {
        String fileExtension = FilenameUtils.getExtension(file.getName());
        return file.isFile() && EXTENSIONS.contains(fileExtension);
    }
}
