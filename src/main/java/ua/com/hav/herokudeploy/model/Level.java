package ua.com.hav.herokudeploy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "levels")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;
}
