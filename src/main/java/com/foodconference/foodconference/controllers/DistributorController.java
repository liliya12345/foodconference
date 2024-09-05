package com.foodconference.foodconference.controllers;

import com.foodconference.foodconference.dto.DistributorDtoResponse;
import com.foodconference.foodconference.services.impl.DistributorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequiredArgsConstructor
@RequestMapping("api/v1/distributor")

public class DistributorController {
    private final DistributorServiceImpl distributorService;

    @GetMapping("/getAll")
    public ResponseEntity<List<DistributorDtoResponse>> getAllDistributors() {
        return ResponseEntity.ok(distributorService.getAllDistributors());
    }
    @PostMapping("/disapprove")
    public  ResponseEntity <List<DistributorDtoResponse>>  disapprove(@RequestBody DistributorDtoResponse distributor){
//        distributorService.disapproved(object.getValue());
        return ResponseEntity.ok(distributorService.getAllDistributors());
    }
}
