package com.mtah.model.Menu;

import com.mtah.model.BaseEntity;
import com.mtah.model.Chef;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Menu extends BaseEntity {

    @OneToOne(mappedBy = "menu")
    private Chef chef;

    @OneToMany(mappedBy = "menu")
    private List<MenuCategory> categories;
}
