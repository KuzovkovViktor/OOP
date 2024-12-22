package main.java.com.example;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the folder with media files:");
        String mediaFolder = scanner.nextLine();
        
        MediaLibrary library = new MediaLibrary(mediaFolder);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Sort by name");
            System.out.println("2. Sort by size");
            System.out.println("3. Filter by type");
            System.out.println("4. View/Play a file");
            System.out.println("5. Exit");
            System.out.println("-----------------");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    library.sortByName();
                    System.out.println("Files sorted by name:");
                    library.printMediaFiles();
                }
                case 2 -> {
                    library.sortBySize();
                    System.out.println("Files sorted by size:");
                    library.printMediaFiles();
                }
                case 3 -> {
                    System.out.println("Enter file type to filter (audio/video):");
                    String type = scanner.nextLine();
                    library.filterByType(type);
                    System.out.println("Filtered files:");
                    library.printMediaFiles();
                }
                case 4 -> {
                    System.out.println("Enter the name of the file to play:");
                    String fileName = scanner.nextLine();
                    library.playFile(fileName);
                }
                case 5 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
