package com.mtah.model.Menu;

import com.mtah.model.Chef;
import com.mtah.model.NamedEntity;
import lombok.Data;

@Data
public class MenuCategory extends NamedEntity {

    private Chef chef;
}
