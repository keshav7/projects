package domain;

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
    @JoinColumn(name = "company")
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    Order order;
    @JoinColumn(name = "company")
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    MenuItem menuItem;
    @Column(name = "qty")
    @NotNull
    Integer quantity;
}
