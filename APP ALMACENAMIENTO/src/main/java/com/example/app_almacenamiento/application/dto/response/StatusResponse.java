package com.example.app_almacenamiento.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusResponse {

    private String url;
    private String code;
    private String message;
}
