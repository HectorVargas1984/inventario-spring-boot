package com.harry.inventario.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResposeRest extends ResponseRest{

    private CategoryResponse categoryResponse = new CategoryResponse();
}
