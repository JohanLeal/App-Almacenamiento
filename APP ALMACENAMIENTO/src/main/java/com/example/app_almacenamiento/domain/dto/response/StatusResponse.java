package com.example.app_almacenamiento.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StatusResponse {

    private String url;
    private String code;
    private String message;
}
