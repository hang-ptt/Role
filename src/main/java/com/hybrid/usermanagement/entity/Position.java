package com.hybrid.usermanagement.entity;

import com.hybrid.usermanagement.security.Account;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_position", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name","location_id"})
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "positions")
    private List<User> users;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PositionSubject> positionSubjects;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "created_by_account_id")
    private Account createdBy;

    @ManyToOne()
    @JoinColumn(name = "updated_by_account_id")
    private Account updatedBy;

    @Column(name = "status")
    private boolean status;
}
