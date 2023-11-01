package com.enigma.wms_api.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CommonResponse<T> {
    private T data;
    private PagingResponse paging;
    private Integer statusCode;
    private String message;
    private String errors;
}
