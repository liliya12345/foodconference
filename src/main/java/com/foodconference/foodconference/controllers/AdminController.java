package com.foodconference.foodconference.controllers;

import com.foodconference.foodconference.dto.DistributorDtoResponse;
import com.foodconference.foodconference.models.Distributor;
import com.foodconference.foodconference.services.impl.DistributorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    private final DistributorServiceImpl distributorService;

    @PostMapping("/approveDistributor/{distributorId}")
    public ResponseEntity<DistributorDtoResponse> approved(@PathVariable Long distributorId) {
        DistributorDtoResponse approved = distributorService.approved(distributorId);
        return ResponseEntity.ok(approved);

    }

    @GetMapping("/getAllDistributors")
    public ResponseEntity<Page<DistributorDtoResponse>> getAllDistributors(@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<DistributorDtoResponse> allDistributors = distributorService.getAllDistributors(PageRequest.of(pageNumber, pageSize));
        return ResponseEntity.ok(allDistributors);
    }
}

