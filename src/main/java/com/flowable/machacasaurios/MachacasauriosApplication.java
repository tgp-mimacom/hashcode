package com.flowable.machacasaurios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import ch.qos.logback.core.BasicStatusManager;

@SpringBootApplication
public class MachacasauriosApplication implements CommandLineRunner {

    public static List<String> inputFiles = Arrays.asList("a_example.txt"
            //        "b_lovely_landscapes.txt"

            //        "c_memorable_moments.txt"
            //        "d_pet_pictures.txt",
            //        "e_shiny_selfies.txt"
    );

    private long scanningDays;

    private static List<Book> books = new ArrayList<>();

    //    public static List<String> inputFiles = Arrays.asList("a_example.txt");

    private static Logger LOG = LoggerFactory
        .getLogger(MachacasauriosApplication.class);

    public static void main(String[] args) throws IOException {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(MachacasauriosApplication.class, args);

        for (String inputFile : inputFiles) {
            InputStream inputStream1 = new ClassPathResource(inputFile).getInputStream();

            readFromInputStream(inputStream1);
            //                        System.out.println("Number of photos: " + numberOfPhotos);
            //            System.out.println("Photos:");
            //            photos.forEach(photo -> System.out.println(photo.toString()));

//            List<Slide> slides = First.simple(photos);
            //        System.out.println("SOLUTION:");

//            solutionToFile(slides, inputFile);
            //        System.out.println(slides.size());
            //        slides.forEach(slide -> System.out.println(slide.toString()));
//            photos.clear();
//            slides.clear();
//            numberOfPhotos = 0;
        }
        LOG.info("APPLICATION FINISHED");
    }

//    private static void solutionToFile(List<Slide> slides, String fileName) throws IOException {
//        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/" + "solution_" + fileName));
//
//        writer.write(String.valueOf(slides.size()));
//        slides.forEach(slide -> {
//            try {
//                writer.write("\n");
////                writer.write((slide.toString()));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        writer.close();
//
//    }
    private static void readFromInputStream(InputStream inputStream)
        throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    String[] splited = line.split("\\s+");
                    long numberOfBooks = Long.parseLong(splited[0]);
                    long numberOfLibraries = Long.parseLong(splited[1]);
                    long scanningDays = Long.parseLong(splited[2]);
                } else if (i == 1) {
                    String[] splited = line.split("\\s+");
                    for (String s : splited) {
                        long bookId = 0;
                        Book book = new Book(Long.parseLong(s), bookId);
                        books.add(book);
                        bookId++;
                    }
                } else {
                    if(i % 2 == 0) {
                        // Definicion de libreria
                        LOG.info("linea par " + line);
                    } else {
                        // Libros de la libreria

                    }
                }

                //                    numberOfPhotos = Long.parseLong(line);
                //                } else {
                //                    String[] splited = line.split("\\s+");
                //                    String id = String.valueOf((i - 1));
                //                    String numberOfTags = splited[1];
                //                    String orientation = splited[0];
                //                    List<String> tags = new ArrayList<>();
                //
                //                    for (int j = 2; j < splited.length; j++) {
                //                        tags.add(splited[j]);
                //                    }
                //                    photos.add(new Photo(id, numberOfTags, orientation, tags));
                //                }
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
