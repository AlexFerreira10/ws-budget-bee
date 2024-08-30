package com.ws.budget.bee.domain.subscription;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Setter
@Getter
@Table(name = "tb_bb_subscription")
@Entity(name = "Subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bb_subscriptions_id")
    private Long id;

    @Column(name = "bb_subscription_name")
    private String name;

    @Column(name = "bb_subscription_acess_months")
    private Integer acessMonths;

    @Column(name = "bb_subscription_price")
    private Double price;

    @Column(name = "bb_subscription_product_key")
    private String productKey;

    public Subscription(Long id, String name, Integer acessMonths, Double price, String productKey) {
        this.id = id;
        this.name = name;
        this.acessMonths = acessMonths;
        this.price = price;
        this.productKey = productKey;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", acessMonths=" + acessMonths +
                ", price=" + price +
                ", productKey='" + productKey + '\'' +
                '}';
    }
}