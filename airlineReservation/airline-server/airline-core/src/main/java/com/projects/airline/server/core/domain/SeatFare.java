package com.projects.airline.server.core.domain;

import com.projects.core.domain.AuditedBaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "fare")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class SeatFare extends AuditedBaseEntity{

    Double price;
}
