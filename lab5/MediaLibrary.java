package main.java.com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MediaLibrary {
    private List<MediaFile> mediaFiles = new ArrayList<>();

    public MediaLibrary(String directoryPath) {
        loadMediaFiles(directoryPath);
    }

    private void loadMediaFiles(String directoryPath) {
        File folder = new File(directoryPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".mp3") || name.endsWith(".mp4"));
            if (files != null) {
                for (File file : files) {
                    String fileName = file.getName();
                    String fileType = fileName.endsWith(".mp3") ? "audio" : "video";
                    mediaFiles.add(new ProxyMediaFile(fileName, fileType, file.getAbsolutePath()));
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a folder: " + directoryPath);
        }
    }

    public void sortByName() {
        mediaFiles.sort(Comparator.comparing(MediaFile::getName));
    }

    public void sortBySize() {
        mediaFiles.sort(Comparator.comparing(file -> new File(((ProxyMediaFile) file).getFilePath()).length()));
    }

    public void filterByType(String type) {
        mediaFiles = mediaFiles.stream()
                .filter(file -> file.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    public void printMediaFiles() {
        for (MediaFile file : mediaFiles) {
            System.out.println(file.getName() + " (" + file.getType() + ")");
        }
    }

    public void playFile(String fileName) {
        for (MediaFile file : mediaFiles) {
            if (file.getName().equalsIgnoreCase(fileName)) {
                file.play();
                return;
            }
        }
        System.out.println("File not found: " + fileName);
    }
}

