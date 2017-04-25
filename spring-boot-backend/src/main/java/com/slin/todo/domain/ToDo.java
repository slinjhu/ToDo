package com.slin.todo.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class ToDo {
  @Id
  @GeneratedValue
  private Long id;

  @CreatedDate
  private Date created;

  @LastModifiedDate
  private Date modified;

  @Column
  private String title = "";

  @Column
  private Boolean done = false;

  public ToDo(String title, Boolean done){
    this.title = title;
    this.done = done;
  }
}


