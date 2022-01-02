package com.mapofzones.adaptor.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class ZoneStatus {
    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Column(name = "is_zone_up_to_date")
    private Boolean isZoneUpToDate;

    @NonNull
    public String getZone() {
        return zone;
    }

    public Boolean getZoneUpToDate() {
        return isZoneUpToDate;
    }
}
