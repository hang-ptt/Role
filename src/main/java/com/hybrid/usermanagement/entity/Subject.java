package com.hybrid.usermanagement.entity;

import com.hybrid.usermanagement.security.Account;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_subject")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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

    public Subject(String name, String description, Date createdAt, Date updatedAt, Account createdBy, boolean status) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.status = status;
    }
}
