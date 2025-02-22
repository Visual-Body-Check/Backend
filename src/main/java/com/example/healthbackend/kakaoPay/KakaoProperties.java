package com.example.healthbackend.kakaoPay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KakaoProperties {
    public static String adminKey;
    public static String cid;
    public static String readyUrl;
    public static String approveUrl;

    @Value("${kakaopay.admin-key")
    public void setAdminKey(String adminKey){
        KakaoProperties.adminKey = adminKey;
    }
    @Value("${kakaopay.cid")
    public void setCid(String cid){
        KakaoProperties.cid = cid;
    }
    @Value("${kakaopay.ready-url")
    public void setReadyUrl(String readyUrl){
        KakaoProperties.readyUrl = readyUrl;
    }
    @Value("${kakaopay.approve-url")
    public void setApproveUrl(String approveUrl){
        KakaoProperties.approveUrl = approveUrl;
    }

}
