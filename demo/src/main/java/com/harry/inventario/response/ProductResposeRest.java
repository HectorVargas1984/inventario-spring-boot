package com.harry.inventario.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResposeRest extends ResponseRest{
    private ProductResponse productResponse = new ProductResponse();
}
