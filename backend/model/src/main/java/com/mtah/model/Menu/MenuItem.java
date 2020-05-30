package com.mtah.model.Menu;

import com.mtah.model.Item;
import lombok.Data;

import javax.persistence.Entity;

@Data
public class MenuItem extends Item {

    private String description;
    private String image;
}
