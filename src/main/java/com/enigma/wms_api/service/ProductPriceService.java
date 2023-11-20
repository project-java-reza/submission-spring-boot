package com.enigma.wms_api.service;

import com.enigma.wms_api.model.request.ProductPriceRequest;
import com.enigma.wms_api.entity.ProductPrice;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductPriceService {
    List<ProductPrice> getAllProductPriceByProductCode(String code);
    ProductPrice getActivePriceByProductIdAndBranchId(String productId, String branchId);
    ProductPrice getById(String id);
    ProductPrice getActivePriceByProductCode(String productCode);
    Page<ProductPrice> getAllActiveProductPrice(ProductPriceRequest request);
}
