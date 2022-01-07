package ru.lok.board.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Task task;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false, columnDefinition = "text")
    private String message;
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(updatable = false)
    private LocalDateTime createdDate;


    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }

}
