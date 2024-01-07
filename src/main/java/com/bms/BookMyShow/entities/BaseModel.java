package com.bms.BookMyShow.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@SuperBuilder(toBuilder = true)
@MappedSuperclass
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Data
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @CreatedDate
    @Temporal(value=TemporalType.TIMESTAMP)
    protected Date createdAt;

    @LastModifiedDate
    @Temporal(value= TemporalType.TIMESTAMP)
    protected Date updatedAt;
}
