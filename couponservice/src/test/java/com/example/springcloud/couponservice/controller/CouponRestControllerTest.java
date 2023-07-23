package com.example.springcloud.couponservice.controller;

import com.example.springcloud.couponservice.model.Coupon;
import com.example.springcloud.couponservice.repository.CouponRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.lang.IllegalArgumentException;

@SpringBootTest
class CouponRestControllerTest {

//    @Mock
//    private CouponRepository couponRepository;
//    @InjectMocks
//    private CouponRestController couponRestController;
//    @Test
//    public  void testCreate()
//    {
//
//        CouponRepository couponRepository = Mockito.mock(CouponRepository.class);
//        Coupon coupon=new Coupon();
//        coupon.setCode("SUPER");
//        when(couponRepository.save(coupon)).thenReturn(coupon);
//        Coupon couponCreated = couponRestController.create(new Coupon());
//        verify(couponRepository.save(coupon));
//        assertNotNull(couponCreated);
//        assertEquals("SUPER",couponCreated.getCode());
//
//
//    }
    CouponRepository couponRepository = Mockito.mock(CouponRepository.class); // Create a mock of CouponRepository
    CouponRestController couponRestController = new CouponRestController(couponRepository);

    @Test
    public void testCreate() {


        Coupon coupon = new Coupon();
        coupon.setCode("SUPER");

        // Stub the save method of the couponRepository mock to return the coupon when invoked
        Mockito.when(couponRepository.save(Mockito.any(Coupon.class))).thenReturn(coupon);

        // Call the method to be tested
        Coupon couponCreated = couponRestController.create(new Coupon());

        // Verify that the save method of the couponRepository mock was called exactly once with the coupon object
        Mockito.verify(couponRepository, Mockito.times(1)).save(Mockito.any(Coupon.class));

        assertNotNull(couponCreated);
        assertEquals("SUPER", couponCreated.getCode());
    }

    @Test
    public void testGetCoupon()
    {
//        CouponRepository couponRepository = Mockito.mock(CouponRepository.class); // Create a mock of CouponRepository
//        CouponRestController couponRestController = new CouponRestController(couponRepository);

        Coupon coupon = new Coupon();
        coupon.setId(123L);
        coupon.setCode("SUPER");
        coupon.setDiscount(new BigDecimal(10));

        // Stub the save method of the couponRepository mock to return the coupon when invoked
        Mockito.when(couponRepository.findByCode(coupon.getCode())).thenReturn(coupon);

        // Call the method to be tested
        Coupon couponResponse = couponRestController.getCoupon("SUPER");

//        // Verify that the save method of the couponRepository mock was called exactly once with the coupon object
//        Mockito.verify(couponRepository, Mockito.times(1)).save(Mockito.any(Coupon.class));

        assertNotNull(couponResponse);
        assertEquals("SUPER", couponResponse.getCode());


    }
    @Test
    public void testCreate_WHEN_COUPON_IS_NULL_THROW_EXCEPTION() {
        assertThrows(IllegalArgumentException.class, () -> {
            couponRestController.create(null);
        });
    }


}