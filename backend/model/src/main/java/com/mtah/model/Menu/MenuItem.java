package com.mtah.model.Menu;

import com.mtah.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem extends Item {

    @ManyToOne
    @JoinColumn(nullable = false)
    private MenuCategory category;

    private String description;
    private String image;

    @OneToMany(mappedBy = "menuItem")
    private List<MenuOption> menuOptions;
}
