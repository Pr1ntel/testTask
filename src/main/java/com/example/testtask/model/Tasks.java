package com.example.testtask.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "header")
    private String header;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "status_type_id")
    private StatusType statusTypeId;

    @ManyToOne
    @JoinColumn(name = "priority_type_id")
    private PriorityType priorityTypeId;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Users authorId;

    @ManyToOne
    @JoinColumn(name = "executor_id")
    private Users executorId;

}