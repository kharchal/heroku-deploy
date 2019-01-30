package ua.com.hav.herokudeploy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reasons")
public class Reason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;
}
