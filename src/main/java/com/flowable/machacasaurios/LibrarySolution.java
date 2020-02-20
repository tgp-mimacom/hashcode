package com.flowable.machacasaurios;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibrarySolution {
    long id;

    long numberOfBooksPerDay;

    List<Long> books;


}
