package com.thrifleganger.mountainviews.api.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mountain {
  @Id
  @GeneratedValue
  @Type(type="uuid-char")
  private UUID id;
  private String name;
  private String irishName;
  private Double elevation;
  private Integer osiSheetNumber;
  private String gridReference;
  private String longitude;
  private String latitude;
  private String easting;
  private String northing;
  private Double prominence;
  private Double isolation;
  private String bedrockType;
  @Column(length = 8000)
  private String description;
  private String mountainViewsId;
  private String mountainViewsLink;
  @JsonManagedReference
  @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  @JoinColumn(columnDefinition = "countyId")
  private County county;
  @JsonManagedReference
  @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  @JoinColumn(columnDefinition = "mountainRangeId")
  private MountainRange mountainRange;
}
