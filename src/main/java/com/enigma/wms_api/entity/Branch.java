package com.enigma.wms_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "branch")
@Builder(toBuilder = true)
public class Branch {

    @Id
    @GenericGenerator(strategy = "uuid2", name= "system-uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    @Column(name = "no_branch", unique = true, nullable = false, length = 20)
    private String branchCode;

    @Column(name = "branch_name", unique = true, nullable = false, length = 100)
    private String branchName;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(name = "phone_number", unique = true, nullable = false, length = 15)
    private String phoneNumber;

    @OneToMany(mappedBy = "branch")
    public List<ProductPrice> productPrices;
}