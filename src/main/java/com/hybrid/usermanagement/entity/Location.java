package com.hybrid.usermanagement.entity;

import com.hybrid.usermanagement.security.Account;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_location")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "tel")
    private String tel;

    @OneToMany(mappedBy = "location")
    private List<Position> positions;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne()
    @JoinColumn(name = "created_by_account_id")
    private Account createdBy;

    @ManyToOne()
    @JoinColumn(name = "updated_by_account_id")
    private Account updatedBy;

    @Column(name = "status")
    private boolean status;
}
