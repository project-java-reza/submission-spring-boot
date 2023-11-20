package com.enigma.wms_api.controller;

import com.enigma.wms_api.entity.Branch;
import com.enigma.wms_api.model.request.BranchRequest;
import com.enigma.wms_api.model.response.BranchResponse;
import com.enigma.wms_api.model.response.CommonResponse;
import com.enigma.wms_api.model.response.PagingResponse;
import com.enigma.wms_api.service.BranchService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/branch")
public class BranchController {

    private final BranchService branchService;

    @PostMapping
    public ResponseEntity<?> createNewBranch(@RequestBody BranchRequest branchRequest) {
        BranchResponse branchResponse = branchService.createBranch(branchRequest);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(CommonResponse.builder()
                            .statusCode(HttpStatus.CREATED.value())
                            .data(branchResponse)
                            .message("Successfully create new branch")
                            .build());
    }

    @GetMapping
    public ResponseEntity<?> getAllBranch(@RequestParam(defaultValue = "0")int page,
                                          @RequestParam(defaultValue = "10")int size) {
        Pageable pageable= PageRequest.of(page, size);
        Page<Branch> branch = branchService.getAllBranch(pageable);

        List<Branch> branchList = branch.getContent();

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully get all branch")
                        .data(branchList)
                        .paging(new PagingResponse())
                        .build());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCustomerId(@PathVariable String id) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CommonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message("Successfully get branch by id")
                            .data(branchService.getBranchById(id))
                            .build());

    }

    @PutMapping()
    public ResponseEntity<?> updateBranch(@RequestBody BranchRequest request) {
        BranchResponse branch = branchService.update(request);

        if(branch != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CommonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message("Successfully update branch")
                            .data(branchService.update(request))
                            .build());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(CommonResponse.builder()
                            .statusCode(HttpStatus.BAD_REQUEST.value())
                            .errors("Failed update branch")
                            .data(null)
                            .paging(null)
                            .build());
        }


    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBranch(@PathVariable String id) {
        boolean deleted = branchService.deleteById(id);

        if(deleted) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CommonResponse.builder()
                            .data("OK")
                            .message("Successfully Delete Branch ID")
                            .errors(null)
                            .build());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(CommonResponse.builder()
                            .data(null)
                            .errors("Not Found")
                            .paging(null)
                            .build());
        }


    }



}

