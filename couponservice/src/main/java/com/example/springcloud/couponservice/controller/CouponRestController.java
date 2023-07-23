package com.example.springcloud.couponservice.controller;

import com.example.springcloud.couponservice.model.Coupon;
import com.example.springcloud.couponservice.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon-api")
public class CouponRestController {
    @Autowired
    private CouponRepository couponRepository;

    public CouponRestController(CouponRepository couponRepository) {
        this.couponRepository=couponRepository;
    }

    @PostMapping("/save")
    public Coupon create(@RequestBody Coupon coupon){
        if(coupon==null)
            throw new IllegalArgumentException("Coupon is required!!");
        return couponRepository.save(coupon);
    }

    @GetMapping("/get/{code}")
    public  Coupon getCoupon(@PathVariable String code){

        return couponRepository.findByCode(code);
    }
}
