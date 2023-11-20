package com.enigma.wms_api.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PagingResponse {
    private Long count;
    private Integer totalPage;
    private Integer page;
    private Integer size;
}
