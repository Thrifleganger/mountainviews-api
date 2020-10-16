package com.thrifleganger.mountainviews.api.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "county")
public class CountyEntity {
  @Id
  @GeneratedValue
  @Type(type="uuid-char")
  private UUID id;
  @Column(unique = true)
  private String name;
  private String province;
  @JsonBackReference
  @OneToMany(mappedBy = "county")
  private Set<MountainEntity> mountains;
}
