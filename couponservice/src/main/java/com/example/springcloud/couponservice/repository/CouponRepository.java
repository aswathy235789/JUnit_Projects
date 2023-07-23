package com.example.springcloud.couponservice.repository;

import com.example.springcloud.couponservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Long> {
    Coupon findByCode(String code);
}
