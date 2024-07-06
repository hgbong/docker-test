package com.example.sampleapp_for_docker.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "my_group")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Group {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;

    @Builder
    public Group(String name) {
        this.name = name;
    }
}
