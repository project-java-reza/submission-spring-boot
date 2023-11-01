package com.enigma.wms_api.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BranchRequest {

    private String branchId;

    @NotBlank
    private String branchName;

    @NotBlank
    private String branchCode;

    @NotBlank
    private String address;

    @NotBlank
    private String phoneNumber;
}
