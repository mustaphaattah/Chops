package com.mtah.model.Menu;

import com.mtah.model.NamedEntity;
import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class MenuCategory extends NamedEntity {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Menu menu;

    @OneToMany(mappedBy = "category")
    private List<MenuItem> menuItems;
}
