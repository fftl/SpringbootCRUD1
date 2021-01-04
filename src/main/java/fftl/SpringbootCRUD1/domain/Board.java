package fftl.SpringbootCRUD1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@Entity
public class Board {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;

    public String title;

    public String content;

    public String regdate;

}
