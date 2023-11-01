package com.enigma.wms_api.service.impl;

import com.enigma.wms_api.entity.Branch;
import com.enigma.wms_api.exception.BranchNotFoundException;
import com.enigma.wms_api.model.request.BranchRequest;
import com.enigma.wms_api.model.response.BranchResponse;
import com.enigma.wms_api.repository.BranchRepository;
import com.enigma.wms_api.service.BranchService;
import com.enigma.wms_api.service.ValidationService;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    private final ValidationService validationService;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public BranchResponse createBranch(BranchRequest request) {

        validationService.validate(request);

        if(branchRepository.existsByBranchName(request.getBranchName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Branch name is already registered");
        }


        if(branchRepository.existsByBranchCode(request.getBranchCode())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Branch code already registered");
        }

        if(branchRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Branch phone already registered");
        }

            Branch branch = Branch.builder()
                    .branchName(request.getBranchName())
                    .branchCode(request.getBranchCode())
                    .address(request.getAddress())
                    .phoneNumber(request.getPhoneNumber())
                    .build();

            branchRepository.saveAndFlush(branch);

            return BranchResponse.builder()
                    .branchId(branch.getId())
                    .branchCode(branch.getBranchCode())
                    .branchName(branch.getBranchName())
                    .address(branch.getAddress())
                    .phoneNumber(branch.getPhoneNumber())
                    .build();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Page<Branch> getAllBranch(Pageable pageable) {
        return branchRepository.findAll(pageable);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public BranchResponse getBranchById(String id) {
        return branchRepository.findById(id)
                .map(branch -> BranchResponse.builder()
                .branchId(branch.getId())
                .branchName(branch.getBranchName())
                .address(branch.getAddress())
                .phoneNumber(branch.getPhoneNumber())
                .build())
                .orElseThrow();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public BranchResponse update(BranchRequest request) {

        if(request.getBranchId() == null) {
            return null;
        }

        Optional<Branch> optionalBranch = branchRepository.findById(request.getBranchId());

        if(optionalBranch.isPresent()) {
            Branch branch = optionalBranch.get();
            branch.setBranchName(request.getBranchName());
            branch.setBranchCode(request.getBranchCode());
            branch.setAddress(request.getAddress());
            branch.setPhoneNumber(request.getPhoneNumber());

            branchRepository.saveAndFlush(branch);

            return BranchResponse.builder()
                    .branchId(branch.getId())
                    .branchCode(branch.getBranchCode())
                    .branchName(branch.getBranchName())
                    .address(branch.getAddress())
                    .phoneNumber(branch.getPhoneNumber())
                    .build();
        } else {
            return BranchResponse.builder()
                    .errors("Failed To Update")
                    .build();
        }
    }

    @Override
    public boolean deleteById(String id) {
       Optional<Branch> optionalBranch = branchRepository.findById(id);

       if(optionalBranch.isPresent()) {
           branchRepository.deleteById(id);
           log.info("Success delete Branch ID");
           return true;
       } else {
           log.warn("Failed delete, With Branch ID " + id);
            return false;
       }

    }
}
