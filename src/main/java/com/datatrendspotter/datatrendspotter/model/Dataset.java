package com.datatrendspotter.datatrendspotter.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import com.datatrendspotter.datatrendspotter.ExcelReader;

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
    @Transient
    ExcelReader reader = new ExcelReader();
    ArrayList<ArrayList<String>> attributes = reader.getAttributes(reader.getSheets());

}
