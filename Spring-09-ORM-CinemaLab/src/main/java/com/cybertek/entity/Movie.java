package com.cybertek.entity;

import com.cybertek.enums.MovieState;
import com.cybertek.enums.MovieType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie extends BaseEntity {

    private String name;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private MovieType type;

    @Enumerated(EnumType.STRING)
    private MovieState state;

    //@Temporal(TemporalType.DATE)
    //private Date releaseDate;
    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

    private Integer duration;

    @Column(columnDefinition = "text")
    private String summary;


}
