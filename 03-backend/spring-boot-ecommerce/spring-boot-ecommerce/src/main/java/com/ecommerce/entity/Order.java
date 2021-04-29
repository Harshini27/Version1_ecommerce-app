package com.ecommerce.entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="order_tracking_number")
    private String orderTrackingNumber;

    @Column(name="total_quantity")
    private int totalQuantity;

    @Column(name="total_price")
    private BigDecimal totalPrice;

    @Column(name="status")
    private String status;

    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name="last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
//    private Set<OrderItem> orderItems = new HashSet<>();
    
    
    

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
    @Column(name="user_id")
    private int userid;
    
//     public void add(OrderItem item) {
//
//        if (item != null) {
//            if (orderItems == null) {
//                orderItems = new HashSet<>();
//            }
//
//            orderItems.add(item);
//            item.setOrder(this);
//        }
//    }
}
