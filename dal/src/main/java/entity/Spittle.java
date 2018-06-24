package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Spittle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    @Column(name="spitter")
    private Integer spitter;

    @Getter
    @Setter
    @Column(name="message")
    private String message;

    @Getter
    @Setter
    @Column(name="postedTime")
    private Date postedTime;

    public Spittle(Integer id, Integer spitter, String message, Date postedTime) {
        this.id = id;
        this.spitter = spitter;
        this.message = message;
        this.postedTime = postedTime;
    }

    public Spittle(){}
}
