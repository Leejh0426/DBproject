package DB.DBproject.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int product_id;
    private String name;
    private String image;
    private int price;
}
