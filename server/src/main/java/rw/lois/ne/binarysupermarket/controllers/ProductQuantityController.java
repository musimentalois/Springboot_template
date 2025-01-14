package rw.lois.ne.binarysupermarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rw.lois.ne.binarysupermarket.dtos.NewProductQuantityDTO;
import rw.lois.ne.binarysupermarket.payload.ApiResponse;
import rw.lois.ne.binarysupermarket.services.IProductQuantityService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/product-quantities")
@CrossOrigin
public class ProductQuantityController {
    private final IProductQuantityService service;


    @Autowired
    public ProductQuantityController(IProductQuantityService service) {
        this.service = service;
    }

    @GetMapping("/by-product/{code}")
    public ResponseEntity<ApiResponse> getAll(
            @PathVariable("code") String code
    ) {
        return ResponseEntity.ok(ApiResponse.success(service.byProduct(code)));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<ApiResponse> newQuantity(@Valid @RequestBody NewProductQuantityDTO dto) {
        return ResponseEntity.ok(ApiResponse.success(this.service.newQuantity(dto)));
    }
}
