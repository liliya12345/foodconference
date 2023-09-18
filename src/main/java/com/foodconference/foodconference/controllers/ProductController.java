package com.foodconference.foodconference.controllers;

import com.foodconference.foodconference.dto.CategoryProductsDtoResponse;
import com.foodconference.foodconference.dto.ProductDtoRequest;
import com.foodconference.foodconference.models.Distributor;
import com.foodconference.foodconference.services.CategoryProductService;
import com.foodconference.foodconference.services.impl.CategoryProductServiceImpl;
import com.foodconference.foodconference.services.impl.DistributorServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final CategoryProductServiceImpl categoryProductService;
    private final DistributorServiceImpl distributorService;
    @GetMapping("/getAllCategoryProducts")
    public ResponseEntity<List<CategoryProductsDtoResponse>> getAllCategoryProducts(@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<CategoryProductsDtoResponse> allCategory = categoryProductService.getAllCategories();
        return ResponseEntity.ok(allCategory);
    }
    @PostMapping("/addNewProductsInCategory")
    public ResponseEntity<?> createNewProducts(@RequestBody ProductDtoRequest productDtoRequest){
       Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        Distributor distributor=(Distributor) authentication.getPrincipal();
        if(!distributorService.checkDistributorApprovedAndExist(distributor.getId())){
            return new ResponseEntity<>("Distributor is not exist or not approved", HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
