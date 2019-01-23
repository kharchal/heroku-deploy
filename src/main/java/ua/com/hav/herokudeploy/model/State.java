package ua.com.hav.herokudeploy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "states")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;
}
