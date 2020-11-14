package com.mapofzones.adaptor.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@IdClass(GraphKey.class)
@Table(name = "zones_graphs", schema = "public")
public class Graph {
    @Id
    @Column(name = "timeframe")
    @NonNull
    private Integer timeframe;

    @Id
    @Column(name = "source")
    @NonNull
    private String sourceZone;

    @Id
    @Column(name = "target")
    @NonNull
    private String targetZone;
}
