package com.example.sampleapp_for_docker.controller;

import com.example.sampleapp_for_docker.dto.CreateGroupDto;
import com.example.sampleapp_for_docker.dto.GroupResponseDto;
import com.example.sampleapp_for_docker.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    // anti-pattern
    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public List<GroupResponseDto> listAllGroups() {
        return groupRepository.findAll().stream()
            .map(GroupResponseDto::from)
            .toList();
    }

    @PostMapping
    public void createGroup(@RequestBody CreateGroupDto dto) {
        groupRepository.save(dto.toEntity());
    }
}
