package ru.lok.board.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "task", orphanRemoval = true)
    private List<Comment> list = new ArrayList<>();
    private String title;
    @Column(columnDefinition = "text")
    private String message;
    private Integer complited;

    @Column(updatable = false)
    private LocalDateTime createdDate;


    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }


}
