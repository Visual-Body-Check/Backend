package com.example.healthbackend.kakaoPay.dto.req;

import lombok.Data;

@Data // Lombok 사용 시
public class KakaoPayReadyReq {
    private String partnerOrderId;
    private String partnerUserId;
    private String itemName;
    private int quantity;
    private int totalAmount;
    private int taxFreeAmount;
    private String approvalUrl;
    private String cancelUrl;
    private String failUrl;
}
