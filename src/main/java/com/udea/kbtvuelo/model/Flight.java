package com.udea.kbtvuelo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private @NonNull String name;

    @Column(name = "flight_number")
    private @NonNull String flightNumber;

    @Column(name = "origin")
    private @NonNull String origin;

    @Column(name = "destination")
    private @NonNull String destination;

    @Column(name = "capacity")
    private @NonNull Integer capacity;

    @Column(name = "rating")
    @Min(value = 1, message = "Rating should be greater than 1")
    @Max(value = 5, message = "Rating should be lower than 1")
    private @NonNull Integer rating;

    @Column(name = "flight_plan", nullable = false, length = 100)
    private @NonNull Long flightPlan;

    private Boolean completed;
}
