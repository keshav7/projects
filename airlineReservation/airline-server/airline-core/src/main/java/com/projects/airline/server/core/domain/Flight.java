package com.projects.airline.server.core.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projects.airline.server.core.enums.FlightStatus;
import com.projects.core.domain.AuditedBaseEntity;
import com.projects.core.utils.datetime.JodaDateTimeConverter;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.joda.time.DateTime;

import javax.persistence.*;

@Data
@Entity
@Table(name = "flight")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class Flight extends AuditedBaseEntity{

    @JoinColumn(name = "airline_comapany")
    @OneToOne(fetch = FetchType.LAZY)
    AirlineCompany airlineCompany;
    @JoinColumn(name = "aircraft")
    @OneToOne(fetch = FetchType.LAZY)
    Aircraft aircraft;
    @JoinColumn(name = "src_loc")
    @OneToOne(fetch = FetchType.LAZY)
    Location sourceLoc;
    @JoinColumn(name = "dest_loc")
    @OneToOne(fetch = FetchType.LAZY)
    Location destLoc;
    @Column(name = "design_src_arr_time")
    @Convert(converter = JodaDateTimeConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    DateTime designSrcArrivalTime;
    @Column(name = "actual_src_arr_time")
    @Convert(converter = JodaDateTimeConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    DateTime actualSrcArrivalTime;
    @Column(name = "design_src_dep_time")
    @Convert(converter = JodaDateTimeConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    DateTime designSrcDepTime;
    @Column(name = "actual_src_dep_time")
    @Convert(converter = JodaDateTimeConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    DateTime actualSrcDepTime;
    @Column(name = "design_dest_arr_time")
    @Convert(converter = JodaDateTimeConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    DateTime designDestArrivalTime;
    @Column(name = "actual_dest_arr_time")
    @Convert(converter = JodaDateTimeConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    DateTime actualDestArrivalTime;
    @Column(name = "status", columnDefinition = "VARCHAR(60)")
    @Enumerated(EnumType.STRING)
    FlightStatus status;

}
