package com.example.modularconsoleapplication.modules.image;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Component
public class ImageSizeModule extends ImageModule {
    public String getDescription() {
        return "Вывести размер изображения";
    }

    public String getValue(File file, String args) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int height = Objects.requireNonNull(image).getHeight();
        int width = image.getWidth();

        return String.format("Height: %s , Width: %s", height, width);
    }
}
