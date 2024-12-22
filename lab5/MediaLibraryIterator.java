package main.java.com.example;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class MediaLibraryIterator implements Iterator<MediaFile> {
    private List<MediaFile> mediaFiles;
    private int position = 0;

    public MediaLibraryIterator(List<MediaFile> mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    public MediaLibraryIterator filter(Predicate<MediaFile> predicate) {
        mediaFiles.removeIf(mediaFile -> !predicate.test(mediaFile));
        return this;
    }

    @Override
    public boolean hasNext() {
        return position < mediaFiles.size();
    }

    @Override
    public MediaFile next() {
        return mediaFiles.get(position++);
    }
}