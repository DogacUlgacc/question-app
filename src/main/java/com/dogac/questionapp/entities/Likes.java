package com.dogac.questionapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "p_like")
public class Likes
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="post_id" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;
}
