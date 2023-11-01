package com.enigma.wms_api.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PagingResponse {
    private Integer count;
    private Integer totalPage;
    private Integer page;
    private Integer size;
}
