package main.java.com.example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class ProxyMediaFile implements MediaFile {
    private String name;
    private String type;
    private String filePath;

    public ProxyMediaFile(String name, String type, String filePath) {
        this.name = name;
        this.type = type;
        this.filePath = filePath;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public void play() {
        try {
            File file = new File(filePath);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
                System.out.println("Opening file: " + name);
            } else {
                System.out.println("Desktop operations are not supported on this system.");
            }
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }
    }
}

