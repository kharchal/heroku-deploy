package ua.com.hav.herokudeploy.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String phone;
    private String email;

    private int balance;

    @Column(nullable = true)
    private Integer initialBalance;

    @ManyToOne
    private Level level;

    @ManyToOne
    private State state;

    @CreationTimestamp
    @Column(updatable = false)
    private Date created;

    @UpdateTimestamp
    private Date updated;

    public String getMnemo() {
        return name + " " + surname;
    }
}
