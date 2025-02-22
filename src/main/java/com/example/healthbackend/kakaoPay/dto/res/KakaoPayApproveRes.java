package com.example.healthbackend.kakaoPay.dto.res;

import lombok.Data;

@Data // Lombok 사용 시
public class KakaoPayApproveRes {
    private String aid; // 요청 고유 번호
    private String tid; // 결제 고유 번호
}

