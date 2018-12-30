package com.projects.fc.server.core.domain;

import com.projects.core.domain.AuditedBaseEntity;
import com.projects.fc.server.core.enums.OrderStatus;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "order1")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class Order extends AuditedBaseEntity {
    @Column(name = "order_status", columnDefinition = "VARCHAR(60)", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    OrderStatus orderStatus;
    @Column(name = "customer_phone")
    String customerPhone;
}
