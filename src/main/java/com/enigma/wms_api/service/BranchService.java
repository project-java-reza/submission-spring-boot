package com.enigma.wms_api.service;


import com.enigma.wms_api.entity.Branch;
import com.enigma.wms_api.model.request.BranchRequest;
import com.enigma.wms_api.model.response.BranchResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

public interface BranchService {


    BranchResponse createBranch(BranchRequest branchRequest);

    BranchResponse getBranchById(String id);

    Page<Branch> getAllBranch(Pageable pageable);

    BranchResponse update(BranchRequest branchRequest);

    boolean deleteById(String id);

}
