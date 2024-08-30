package com.ws.budget.bee.controller.creditcard;

import com.ws.budget.bee.controller.user.User;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Setter
@Getter
@Table(name = "tb_bb_credit_card")
@Entity(name = "CreditCard")
public class CreditCard {

    @Id
    @Column(name = "bb_credit_card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bb_credit_card_number")
    private String number;

    @Column(name = "bb_credit_card_expiration")
    private String expiration;

    @Column(name = "bb_credit_card_security_code")
    private String securityCode;

    @Column(name = "bb_credit_card_dt_payment")
    private LocalDate dtPayment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bb_user_id")
    private User user;

    public CreditCard(Long id, String number, String expiration, String securityCode, LocalDate dtPayment, User user) {
        this.id = id;
        this.number = number;
        this.expiration = expiration;
        this.securityCode = securityCode;
        this.dtPayment = dtPayment;
        this.user = user;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", number=" + number +
                ", expiration='" + expiration + '\'' +
                ", securityCode='" + securityCode + '\'' +
                ", dtPayment=" + dtPayment +
                ", user=" + user +
                '}';
    }
}