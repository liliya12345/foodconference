package com.foodconference.foodconference.controllers;

import com.foodconference.foodconference.dto.CourierDtoResponse;
import com.foodconference.foodconference.dto.DistributorDtoResponse;
import com.foodconference.foodconference.models.CategoryProduct;
import com.foodconference.foodconference.services.impl.CategoryProductServiceImpl;
import com.foodconference.foodconference.services.impl.CourierServiceImpl;
import com.foodconference.foodconference.services.impl.DistributorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    private final DistributorServiceImpl distributorService;
    private final CourierServiceImpl courierService;
    private final CategoryProductServiceImpl categoryProductService;

    @PostMapping("/approveDistributor/{distributorId}")
    public ResponseEntity<?> approved(@PathVariable Long distributorId) {
        if (distributorService.approved(distributorId)) {
            DistributorDtoResponse byId = distributorService.getById(distributorId);
            return ResponseEntity.ok(byId);
        }
        return ResponseEntity.ok("Not found distributor:" + distributorId);

    }

    @PostMapping("/disapproveDistributor/{distributorId}")
    public ResponseEntity<?> disapproved(@PathVariable Long distributorId) {
        if (distributorService.disapproved(distributorId)) {
            DistributorDtoResponse byId = distributorService.getById(distributorId);
            return ResponseEntity.ok(byId);
        }
        return ResponseEntity.ok("Not found distributor:" + distributorId);

    }

    @PostMapping("/approveCourier/{courierId}")
    public ResponseEntity<?> approvedCourier(@PathVariable Long courierId) {
        if (courierService.approved(courierId)) {
            CourierDtoResponse byId = courierService.getById(courierId);
            return ResponseEntity.ok(byId);
        }
        return ResponseEntity.ok("Not found courier:" + courierId);

    }

    @PostMapping("/disapproveCourier/{courierId}")
    public ResponseEntity<?> disapprovedCourier(@PathVariable Long courierId) {
        if (courierService.disapproved(courierId)) {
            CourierDtoResponse byId = courierService.getById(courierId);
            return ResponseEntity.ok(byId);
        }
        return ResponseEntity.ok("Not found courier:" + courierId);

    }

    @GetMapping("/getAllDistributors")
    public ResponseEntity<Page<DistributorDtoResponse>> getAllDistributors(@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<DistributorDtoResponse> allDistributors = distributorService.getAllDistributors(PageRequest.of(pageNumber, pageSize));
        return ResponseEntity.ok(allDistributors);
    }
    @PostMapping("/createNewCategory")
    public ResponseEntity<?> createCategory(@RequestBody String categoryName) {
        Optional<CategoryProduct> categoryByName = categoryProductService.getCategoryByName(categoryName);
        if (categoryByName.isPresent()) {
            return new ResponseEntity<>("Already exist", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(categoryProductService.createCategory(categoryName));
    }
}

