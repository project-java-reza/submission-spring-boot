package com.enigma.wms_api.service;

import com.enigma.wms_api.model.request.BranchRequest;

public interface ValidationService {

    void validate(BranchRequest request);
}
