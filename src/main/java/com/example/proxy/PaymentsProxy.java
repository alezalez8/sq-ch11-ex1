package com.example.proxy;

import com.example.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payments", url = "${name.service.url}")
public interface PaymentsProxy {

  @PostMapping("/payment")  // это маппится на точку 8080, другой сервер
  Payment createPayment(
      @RequestHeader String requestId,  // это все описываем для доугого сервера, для запроса
      @RequestBody Payment payment);

}
