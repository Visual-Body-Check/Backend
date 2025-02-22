package com.example.healthbackend.kakaoPay.dto.res;

import lombok.Data;

@Data
public class KakaoPayReadyRes {
    private String tid;
    private String next_redirect_pc_url;
}

