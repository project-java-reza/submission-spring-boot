package com.enigma.wms_api.service;

import com.enigma.wms_api.model.request.BillRequest;
import com.enigma.wms_api.model.request.SalesHistoryRequest;
import com.enigma.wms_api.model.response.BillResponse;
import com.enigma.wms_api.model.response.TotalSales;
import org.springframework.data.domain.Page;

public interface BillService {
    BillResponse create(BillRequest request);
    BillResponse getById(String id);
    Page<BillResponse> getAll(BillRequest request);
    TotalSales getSalesHistory(SalesHistoryRequest request);
}
