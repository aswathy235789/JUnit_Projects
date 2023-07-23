package com.example.springcloud.couponservice.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="code")
    private String  code;
    @Column(name="discount")
    private BigDecimal discount;
    @Column(name="exp_date")
    private  String expDate;

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", discount=" + discount +
                ", expDate='" + expDate + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
}
