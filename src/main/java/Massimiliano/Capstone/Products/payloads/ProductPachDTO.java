package Massimiliano.Capstone.Products.payloads;

import Massimiliano.Capstone.Products.ProducType;
import Massimiliano.Capstone.Products.validator.ValidProductType;

public record ProductPachDTO(@ValidProductType(enumClass = ProducType.class,
        message = "The Products can be:" +
                "  COMIC or MANGA") String type
) {
}
