package com.jpa.exercise.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    private Integer id;
    private String roadNameAddress;
    private String hospitalName;

    @JsonManagedReference
    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private List<Review> reviews;
}
