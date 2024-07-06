package com.example.sampleapp_for_docker.repository;

import com.example.sampleapp_for_docker.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
