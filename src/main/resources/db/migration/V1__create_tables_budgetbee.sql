CREATE TABLE tb_bb_subscription (
        bb_subscriptions_id BIGINT AUTO_INCREMENT PRIMARY KEY,
        bb_subscription_name VARCHAR(255) NOT NULL,
        bb_subscription_acess_months INT,
        bb_subscription_price DECIMAL(10,2),
        bb_subscription_product_key VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE tb_bb_user (
        bb_user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
        bb_user_name VARCHAR(255) NOT NULL,
        bb_user_email VARCHAR(255) UNIQUE NOT NULL,
        bb_user_cpf VARCHAR(255) UNIQUE NOT NULL,
        bb_user_phone VARCHAR(15) UNIQUE NOT NULL,
        bb_user_dt_birth VARCHAR(15) UNIQUE NOT NULL,
        bb_user_dt_subscription DATE NOT NULL,
        bb_user_dt_expiration DATE NOT NULL,

        bb_subscriptions_id BIGINT,

        CONSTRAINT fk_bb_subscriptions_id FOREIGN KEY (bb_subscriptions_id) REFERENCES tb_bb_subscription(bb_subscriptions_id)
);

CREATE TABLE tb_bb_credit_card (
       bb_credit_card_id BIGINT AUTO_INCREMENT PRIMARY KEY,
       bb_credit_card_number VARCHAR(30) UNIQUE NOT NULL,
       bb_credit_card_expiration VARCHAR(5) NOT NULL,
       bb_credit_card_security_code VARCHAR(5) NOT NULL,
       bb_credit_card_dt_payment DATE NOT NULL,

       bb_user_id BIGINT,

       CONSTRAINT fk_bb_user_id FOREIGN KEY (bb_user_id) REFERENCES tb_bb_user(bb_user_id)
);