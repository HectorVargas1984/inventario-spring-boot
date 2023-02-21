package com.harry.inventario.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
@Data
@Entity
@Table(name ="category" )
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @Serial
    private static final long serialVersionUID = 1L;
}
