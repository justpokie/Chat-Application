package com.pokie.pokichat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "channel")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer channel_id;

    @Column(nullable = false)
    private String name;

}
