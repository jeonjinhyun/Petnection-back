package com.jjh.mtvs.pet.domain.aggregate.entity.Embedded;

import com.jjh.mtvs.pet.domain.aggregate.enums.PetType;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PetId implements Serializable {
    private Long petModelId;

    private PetType petType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetId petId = (PetId) o;
        return Objects.equals(petModelId, petId.petModelId) && petType == petId.petType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(petModelId, petType);
    }
}
