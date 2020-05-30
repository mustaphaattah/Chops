package com.mtah.model.Menu;

import com.mtah.model.BaseEntity;
import com.mtah.model.Chef;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
public class Menu extends BaseEntity {

    @OneToOne
    private Chef chef;
    private List<MenuCategory> categories;
}
