package com.mtah.model.Menu;

import com.mtah.model.NamedEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuOption extends NamedEntity {

    private double price;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MenuItem menuItem;
}
