package com.example.modularconsoleapplication.modules.image;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifImageDirectory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class ImageEXIFDataModule extends ImageModule {
    public String getDescription() {
        return "Вывести EXIF информацию о изображении";
    }

    public String getValue(File file, String args) {
        StringBuilder result = new StringBuilder();
        Metadata metadata = null;
        try {
            metadata = ImageMetadataReader.readMetadata(file);
            Directory dir = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
            for (Tag tag : dir.getTags()) {
                result.append(String.format("%s : %s\n", tag.getTagName(), tag.getDescription()));
            }

        } catch (ImageProcessingException | IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
