package main.java.com.example;

public class RealMediaFile implements MediaFile {
    private String name;
    private String type;
    

    public RealMediaFile(String name, String type, String filePath) {
        this.name = name;
        this.type = type;
        this.filePath = filePath;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + name + " from disk...");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void play() {
        System.out.println("Playing " + name);
    }
}