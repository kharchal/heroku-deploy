package ua.com.hav.herokudeploy.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Channel channel;

    private Integer amount;

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
