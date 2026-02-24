package com.pokie.pokichat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer message_id;

    @Column(name = "username")
    private String user;

    @NotBlank
    private String content;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dateCreated;

    public Message() {

    }

    public Message(String content) {
        this.content = content;
    }

}
