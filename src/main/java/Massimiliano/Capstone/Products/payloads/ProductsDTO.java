package Massimiliano.Capstone.Products.payloads;

import Massimiliano.Capstone.Products.ProducType;
import Massimiliano.Capstone.Products.validator.ValidProductType;
import jakarta.validation.constraints.NotEmpty;


public record ProductsDTO(@NotEmpty(message = "The price is required.")
                          int price,
                          @NotEmpty(message = "The description is required.")
                          String description,
                          @NotEmpty(message = "The immagine is required.")
                          String immagine,
                          @ValidProductType(enumClass = ProducType.class,
                                  message = "The Bill can be:" +
                                          "  MANGA or COMICS") String productsType


) {
}


