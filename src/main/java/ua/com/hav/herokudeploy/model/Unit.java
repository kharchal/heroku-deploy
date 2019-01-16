package ua.com.hav.herokudeploy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int qty;
}
