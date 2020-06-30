package com.mtah.model.Menu;

import com.mtah.model.BaseEntity;
import com.mtah.model.Chef;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Menu extends BaseEntity {

    @OneToOne(mappedBy = "menu")
    private Chef chef;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MenuCategory> categories;
}
