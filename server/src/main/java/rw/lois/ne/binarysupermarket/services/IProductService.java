package rw.lois.ne.binarysupermarket.services;

import rw.lois.ne.binarysupermarket.models.Product;
import rw.lois.ne.binarysupermarket.dtos.CreateOrUpdateProductDTO;

import java.util.List;

public interface IProductService {

    Product findByCode(String code);

    List<Product> all();

    Product register(CreateOrUpdateProductDTO dto);
}
