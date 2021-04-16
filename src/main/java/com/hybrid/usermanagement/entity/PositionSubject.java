package com.hybrid.usermanagement.entity;

import com.hybrid.usermanagement.security.Account;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_position_subject")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PositionSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @Column(name = "allow_edit")
    private boolean allowEdit;

    @Column(name = "allow_view")
    private boolean allowView;

    @Column(name = "allow_create")
    private boolean allowCreate;

    @Column(name = "allow_delete")
    private boolean allowDelete;

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
