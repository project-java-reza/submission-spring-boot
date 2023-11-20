package com.enigma.wms_api.service;

import com.enigma.wms_api.model.request.ProductRequest;
import com.enigma.wms_api.model.response.ProductResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    ProductResponse create(ProductRequest request);
    Page<ProductResponse> getAll(ProductRequest request);
    List<ProductResponse> getAllByBranchCode(String branchCode);
    ProductResponse update(ProductRequest request);
    void deleteById(String id);

}
