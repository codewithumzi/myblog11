package com.myblog.myblog11.entity;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    //name,body;
    private String text;
    // Other comment properties...
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    // Constructors, getters, setters...
}

