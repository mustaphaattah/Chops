package com.mtah.model.Menu;

import com.mtah.model.NamedEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuCategory extends NamedEntity {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Menu menu;

    @OneToMany(mappedBy = "category")
    private List<MenuItem> menuItems;
}
