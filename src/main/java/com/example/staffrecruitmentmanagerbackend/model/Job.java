package com.example.staffrecruitmentmanagerbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "jobs")
@Data 

public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String type;
    private String salary;
    private String location;
    private String deadline;
    private String description;

}

