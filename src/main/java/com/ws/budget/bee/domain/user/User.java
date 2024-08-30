package com.ws.budget.bee.domain.user;

import com.ws.budget.bee.domain.subscription.Subscription;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Setter
@Getter
@Table(name = "tb_bb_user")
@Entity(name = "User")
public class User {

    @Id
    @Column(name = "bb_user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bb_user_name")
    private String name;

    @Column(name = "bb_user_email")
    private String email;

    @Column(name = "bb_user_cpf")
    private String cpf;

    @Column(name = "bb_user_phone")
    private String phone;

    @Column(name= "bb_user_dt_birth")
    private LocalDate bith;

    @Column(name= "bb_user_dt_subscription")
    private LocalDateTime dtSubscription;

    @Column(name= "bb_user_dt_expiration")
    private LocalDateTime dtExpiration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bb_subscriptions_id")
    private Subscription subscriptions;

    public User(Long id, String name, String email, String cpf, String phone, LocalDate bith, LocalDateTime dtSubscription, LocalDateTime dtExpiration, Subscription subscriptions) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        this.bith = bith;
        this.dtSubscription = dtSubscription;
        this.dtExpiration = dtExpiration;
        this.subscriptions = subscriptions;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phone='" + phone + '\'' +
                ", bith=" + bith +
                ", dtSubscription=" + dtSubscription +
                ", dtExpiration=" + dtExpiration +
                ", subscriptions=" + subscriptions +
                '}';
    }
}