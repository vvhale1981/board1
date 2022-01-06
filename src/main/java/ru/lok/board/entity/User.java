package ru.lok.board.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Column(updatable = false)
   private LocalDateTime createdDate;



    @PrePersist
    protected  void onCreate() {
        this.createdDate = LocalDateTime.now();
   }
}
