package ua.com.hav.herokudeploy.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int qty;

    @CreationTimestamp
    @Column(updatable = false)
    private Date created;

    @UpdateTimestamp
    private Date updated;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd-MM-YYYY")
    private Date date;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    public String getXdate() {
        if (date == null) {
            date = new Date();
            date.setTime(0L);
        }
        return format.format(date);
    }

    public void setXdate(String str) {
        try {
            date = format.parse(str);
        } catch (ParseException e) {


        }
    }
}
