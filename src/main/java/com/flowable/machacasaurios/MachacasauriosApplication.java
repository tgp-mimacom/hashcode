package com.flowable.machacasaurios;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class MachacasauriosApplication implements CommandLineRunner {

    public static List<String> inputFiles = Arrays.asList("a_example.txt"
            //        "b_lovely_landscapes.txt"
            //        "c_memorable_moments.txt"
            //        "d_pet_pictures.txt",
            //        "e_shiny_selfies.txt"
    );

    private static long numberOfBooks;
    private static long numberOfLibraries ;
    private static long scanningDays;

    private static List<Book> books = new ArrayList<>();

    private static List<Library> libraries = new ArrayList<>();

    private static Logger LOG = LoggerFactory
            .getLogger(MachacasauriosApplication.class);

    public static void main(String[] args) throws IOException {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(MachacasauriosApplication.class, args);

        for (String inputFile : inputFiles) {
            InputStream inputStream1 = new ClassPathResource(inputFile).getInputStream();

            readFromInputStream(inputStream1);


//            solutionToFile(slides, inputFile);
        }
        LOG.info("APPLICATION FINISHED");
    }

    private static void solutionToFile(List<Library> libraries, Book books, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/" + "solution_" + fileName));

        writer.write(String.valueOf(libraries.size()));
        libraries.forEach(slide -> {
            try {
                writer.write("\n");
//                writer.write((slide.toString()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();

    }

    private static void readFromInputStream(InputStream inputStream)
        throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            int i = 0;
            Library currentLibrary = null;
            while ((line = br.readLine()) != null) {
                long libraryCounter = 0;
                if (i == 0) {
                    String[] splited = line.split("\\s+");
                    numberOfBooks = Long.parseLong(splited[0]);
                    numberOfLibraries = Long.parseLong(splited[1]);
                    scanningDays = Long.parseLong(splited[2]);
                } else if (i == 1) {
                    String[] splited = line.split("\\s+");
                    long bookId = 0;
                    for (String s : splited) {
                        Book book = new Book(bookId, Long.parseLong(s));
                        books.add(book);
                        bookId++;
                    }
                } else {
                    if(i % 2 == 0) {
                        // Definicion de libreria
                        String[] splited = line.split("\\s+");
                        long numberOfBooksInLibrary = Long.parseLong(splited[0]);
                        long signupDays = Long.parseLong(splited[1]);
                        long numberOfBooksPerDay = Long.parseLong(splited[2]);
                        currentLibrary = new Library(libraryCounter, signupDays, numberOfBooksPerDay, numberOfBooksInLibrary);
                        libraries.add(currentLibrary);
                    } else {
                        // Libros de la libreria
                        List<Book> libraryBooks = new ArrayList<>();
                        String[] splited = line.split("\\s+");
                        for (String s : splited) {

                            Book book = books.get((int) Long.parseLong(s));
                            libraryBooks.add(book);
                        }
                        currentLibrary.setBooks(libraryBooks);
                        libraryCounter++;
                    }
                }
                i++;

            }
        }
    }
    
    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");

        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
    }

}
