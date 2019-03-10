package com.datatrendspotter.datatrendspotter.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "datasets")
public class Dataset {

    @Id
    @GeneratedValue
    private long id;
    @NonNull
    String name;
    String contributor;
}
