package com.enigma.wms_api.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BranchResponse {
    private String branchId;
    private String branchCode;
    private String branchName;
    private String address;
    private String phoneNumber;
    private String errors;
}
