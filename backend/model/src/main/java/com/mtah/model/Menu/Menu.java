package com.mtah.model.Menu;

import com.mtah.model.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class Menu extends BaseEntity {

    private List<MenuCategory> categories;
}
