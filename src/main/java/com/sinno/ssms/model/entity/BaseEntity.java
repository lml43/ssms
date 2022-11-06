package com.sinno.ssms.model.entity;

import com.sinno.ssms.util.DateTimeUtil;
import com.sinno.ssms.util.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String createdAt;

    /**
     * The handler for INSERT event
     */
    @PrePersist
    public void onPrePersist() {
        String currentDate = DateTimeUtil.getCurrentDate();
        setCreatedAt(currentDate);
    }

}
