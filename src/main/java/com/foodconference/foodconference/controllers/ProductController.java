package com.foodconference.foodconference.controllers;

import com.foodconference.foodconference.dto.CategoryProductsDtoResponse;
import com.foodconference.foodconference.dto.ProductDtoRequest;
import com.foodconference.foodconference.dto.ProductDtoResponse;
import com.foodconference.foodconference.models.Distributor;
import com.foodconference.foodconference.models.User;
import com.foodconference.foodconference.services.CategoryProductService;
import com.foodconference.foodconference.services.ProductService;
import com.foodconference.foodconference.services.impl.CategoryProductServiceImpl;
import com.foodconference.foodconference.services.impl.DistributorServiceImpl;
import com.foodconference.foodconference.services.impl.ProductServiceImpl;
import com.foodconference.foodconference.services.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final CategoryProductServiceImpl categoryProductService;
    private final DistributorServiceImpl distributorService;
    private final ProductServiceImpl productService;
    private final UserServiceImpl userService;

    @GetMapping("/getAllCategoryProducts")
    public ResponseEntity<List<CategoryProductsDtoResponse>> getAllCategoryProducts(@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<CategoryProductsDtoResponse> allCategory = categoryProductService.getAllCategories();
        return ResponseEntity.ok(allCategory);
    }
    @GetMapping("/getAllProductsByCategory/{categoryId}")
    public ResponseEntity<Page<ProductDtoResponse>> getAllProductsByCategory(@PathVariable Long categoryId,@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<ProductDtoResponse> allProducts = productService.getAllProductsByCategory(categoryId, PageRequest.of(pageNumber,pageSize));
        return ResponseEntity.ok(allProducts);
    }


    @PostMapping("/addNewProductsInCategory")
    public ResponseEntity<?> createNewProducts(@RequestBody ProductDtoRequest productDtoRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) authentication.getPrincipal();
        Optional<User> byUsername = userService.findByUsername(username);
        if (!distributorService.checkDistributorApprovedAndExist(byUsername)) {
            return new ResponseEntity<>("Distributor is not exist or not approved", HttpStatus.BAD_REQUEST);
        }
        ProductDtoResponse productDtoResponse = productService.addProduct(productDtoRequest,(Distributor)byUsername.get());
        return ResponseEntity.ok(productDtoResponse);
    }

}
