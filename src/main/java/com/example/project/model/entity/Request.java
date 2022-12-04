package com.example.project.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Request {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;

    @ManyToOne(optional = false)
    @JoinColumn(name = "storage_id", nullable = false)
    private Storage storage;

    @OneToMany(mappedBy = "request", orphanRemoval = true)
    private Set<RequestDetails> requestDetails = new LinkedHashSet<>();

    @Column(name = "is_completed", nullable = false)
    private Boolean isCompleted = false;

}
