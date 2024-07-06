package com.example.sampleapp_for_docker.dto;

import com.example.sampleapp_for_docker.entity.Group;
import com.example.sampleapp_for_docker.repository.GroupRepository;
import lombok.Data;

@Data
public class GroupResponseDto {
    private Long id;
    private String name;

    public static GroupResponseDto from(Group entity) {
        GroupResponseDto groupResponseDto = new GroupResponseDto();
        groupResponseDto.setId(entity.getId());
        groupResponseDto.setName(entity.getName());
        return groupResponseDto;
    }
}
