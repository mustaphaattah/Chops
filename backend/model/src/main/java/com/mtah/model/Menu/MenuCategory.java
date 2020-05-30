package com.mtah.model.Menu;

import com.mtah.model.Chef;
import com.mtah.model.NamedEntity;
import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Data
public class MenuCategory extends NamedEntity {

    private List<MenuItem> menuItems;
}
