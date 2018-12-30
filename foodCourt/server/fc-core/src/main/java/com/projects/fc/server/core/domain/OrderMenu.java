package com.projects.fc.server.core.domain;

import com.projects.core.domain.AuditedBaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "order_menu_item")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class OrderMenu extends AuditedBaseEntity {
    @JoinColumn(name = "order1")
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    Order order1;
    @JoinColumn(name = "menu_item")
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    MenuItem menuItem;
    @Column(name = "qty")
    @NotNull
    Integer quantity;
}
