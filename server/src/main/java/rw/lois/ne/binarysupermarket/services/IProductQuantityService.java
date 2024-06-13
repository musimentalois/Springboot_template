package rw.lois.ne.binarysupermarket.services;

import rw.lois.ne.binarysupermarket.dtos.NewProductQuantityDTO;
import rw.lois.ne.binarysupermarket.models.ProductQuantity;

public interface IProductQuantityService {

    Integer byProduct(String productCode);

    ProductQuantity newQuantity(NewProductQuantityDTO dto);
}
