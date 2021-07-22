package com.bnamericas.holidays.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "holidays")
@Data
@NoArgsConstructor
public class Holidays implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date", length = 10)
    @NonNull
    private String date;

    @Column(name = "title")
    @NonNull
    private String title;

    @Column(name = "extra")
    @NonNull
    private String extra;
}
