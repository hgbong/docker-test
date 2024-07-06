package com.example.sampleapp_for_docker.dto;

import com.example.sampleapp_for_docker.entity.Group;
import lombok.Data;

@Data
public class CreateGroupDto {
    private String name;

    public Group toEntity() {
        return Group.builder()
            .name(name)
            .build();
    }
}
