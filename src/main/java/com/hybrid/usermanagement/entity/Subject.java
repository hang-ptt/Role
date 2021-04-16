package com.hybrid.usermanagement.entity;

import com.hybrid.usermanagement.security.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_subject")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

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
