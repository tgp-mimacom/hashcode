package com.flowable.machacasaurios;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class MachacasauriosApplication implements CommandLineRunner {

    public static List<String> inputFiles = Arrays.asList(
            //       "a_example.txt",
            //"b_read_on.txt",
                    "c_incunabula.txt"
            //      "d_tough_choices.txt",
            //      "e_so_many_books.txt",
            //      "f_libraries_of_the_world.txt"
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

            for ( Library library : libraries ) {
                Long score = library.calculateScore(scanningDays,
                                                    library.signupDays,
                                                    library.books,
                                                    library.numberOfBooksPerDay);

                //LOG.info("score {}", score);
            }

            Collections.sort(libraries);
            Collections.reverse(libraries);

            List<Long> usedBooks = new ArrayList<>();

            List<LibrarySolution> solution = new ArrayList<>();
            for ( Library library : libraries ) {
                LibrarySolution libSol = new LibrarySolution();
                libSol.id = library.id;
                List<Long> bookIds = new ArrayList<>();

                for( Book b : library.books) {
                    if(!usedBooks.contains(b.id)){
                        bookIds.add(b.id);
                        usedBooks.add(b.id);
                    }

                }
                libSol.books = bookIds;

                if( !solution.contains(libSol) )
                    solution.add(libSol);
            }

            MachacasauriosApplication.solutionToFile(solution, inputFile);

            numberOfBooks = 0;
            numberOfLibraries = 0;
            scanningDays = 0;

            books = new ArrayList<>();

            libraries = new ArrayList<>();

        }
        LOG.info("APPLICATION FINISHED");
    }

    private static void solutionToFile(List<LibrarySolution> libraries, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/" + "solution_" + fileName));

        writer.write(String.valueOf(libraries.size()));
        libraries.forEach(library -> {
            try {
                writer.write("\n");
                writer.write( library.id + " ");
                writer.write(String.valueOf(library.getBooks().size()));
                writer.write("\n");
                library.getBooks().forEach(book -> {
                    try {
                        writer.write(book + " ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
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
            long libraryCounter = 0;
            while ((line = br.readLine()) != null) {
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
                    if(line.equals("")) {
                        continue;
                    }
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
