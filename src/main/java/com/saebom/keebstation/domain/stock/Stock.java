package com.saebom.keebstation.domain.stock;

import com.saebom.keebstation.domain.option.ProductOption;
import com.saebom.keebstation.global.common.jpa.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "stock",
        uniqueConstraints = @UniqueConstraint(name = "uk_stock_product_option_id", columnNames = "product_option_id"))
public class Stock extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_option_id", nullable = false, unique = true)
    private ProductOption productOption;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Version
    @Column(name = "version", nullable = false)
    private long version;

    public Stock(ProductOption productOption, int quantity) {
        this.productOption = productOption;
        this.quantity = quantity;
    }

}