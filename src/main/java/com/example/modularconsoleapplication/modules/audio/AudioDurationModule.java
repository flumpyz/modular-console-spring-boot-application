package com.example.modularconsoleapplication.modules.audio;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class AudioDurationModule extends AudioModule {
    public String getDescription() {
        return "Вывести длительность аудиозаписи";
    }

    public String getValue(File file, String args) {
        double result = 0;
        FFprobe ffprobe = null;
        try {
            ffprobe = new FFprobe("C:\\Users\\Natasha\\IdeaProjects\\ffmpeg-2021-11-07-git-45dc668aea-full_build\\ffmpeg-2021-11-07-git-45dc668aea-full_build\\bin\\ffprobe.exe");
            FFmpegProbeResult probeResult = ffprobe.probe(file.getAbsolutePath());
            FFmpegFormat format = probeResult.getFormat();
            result = format.duration;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(result);
    }
}
