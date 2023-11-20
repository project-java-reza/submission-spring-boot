package com.enigma.wms_api.service;


import com.enigma.wms_api.model.request.ReceiptSequenceRequest;

public interface ReceiptSequenceService {
    String generateReceipt(ReceiptSequenceRequest request);
}
