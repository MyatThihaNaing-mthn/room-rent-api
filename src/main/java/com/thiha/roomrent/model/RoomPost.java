package com.thiha.roomrent.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thiha.roomrent.enums.AirConTime;
import com.thiha.roomrent.enums.CookingAllowance;
import com.thiha.roomrent.enums.Location;
import com.thiha.roomrent.enums.PropertyType;
import com.thiha.roomrent.enums.RoomType;
import com.thiha.roomrent.enums.SharePub;
import com.thiha.roomrent.enums.StationName;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "room_posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "station_name")
    private StationName stationName;

    @Column(name = "price")
    private double price;

    @Column(name = "posted_at")
    private Date postedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type")
    private RoomType roomType;

    @Column(name = "total_person")
    @Min(1)
    @Max(4)
    private int totalPax;

    @Column(name = "cooking_allowance")
    @Enumerated(EnumType.STRING)
    private CookingAllowance cookingAllowance;
   
    @Column(name = "share_PUB")
    @Enumerated(EnumType.STRING)
    private SharePub sharePub;

    @Column(name = "aircon_time")
    @Enumerated(EnumType.STRING)
    private AirConTime airConTime;

    @Column(name = "allow_visitor", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean allowVisitor;


    @Column(name = "location")
    @Enumerated(EnumType.STRING)
    private Location location;

    @Column(name = "property_type")
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "agent_id", referencedColumnName = "id")
    private Agent agent;

    @OneToMany(mappedBy = "roomPost", cascade = CascadeType.ALL, orphanRemoval = true)
    List<RoomPhoto> roomPhotos;

}
