# MenuCategory

- Create a MenuCategory
    - POST /chefs/:chefId/menu/:menuId/create-category
- Update a MenuCategory
    - PUT /chefs/:chefId/menu/:menuId/category/:categoryId
- Delete MenuCategory and all its items
    - DELETE /chefs/:chefId/menu/:menuId/category/:categoryId
- *Fetch MenuCategories and all its items by menu
    - GET /chefs/:chefId/menu/:menuId/categories