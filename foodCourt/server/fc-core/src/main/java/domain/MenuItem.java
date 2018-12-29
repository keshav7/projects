package domain;

import com.projects.core.domain.AuditedBaseEntity;
import enums.MenuType;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "menu_item")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamicUpdate
public class MenuItem extends AuditedBaseEntity{
    @JoinColumn(name = "company")
    @OneToOne(fetch = FetchType.LAZY)
    @NotNull
    Company company;
    @Column(name = "name")
    @NotNull
    String name;
    @Column(name = "price")
    @NotNull
    Double price;
    @Column(name = "menu_type", columnDefinition = "VARCHAR(60)", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    MenuType menuType;
}
