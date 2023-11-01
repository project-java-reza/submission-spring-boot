package com.enigma.wms_api.repository;

import com.enigma.wms_api.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, String> {

    boolean existsByBranchName(String branchName);

    boolean existsByBranchCode(String branchCode);

    boolean existsByPhoneNumber(String phoneNumber);

}
