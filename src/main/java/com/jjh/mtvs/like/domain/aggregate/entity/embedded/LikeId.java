package com.jjh.mtvs.like.domain.aggregate.entity.embedded;

import com.jjh.mtvs.like.domain.aggregate.enums.LikeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.tool.schema.TargetType;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikeId implements Serializable {

    private Long userId;

    private Long targetId;

    private LikeType likeType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikeId likeId = (LikeId) o;
        return Objects.equals(userId, likeId.userId) && Objects.equals(targetId, likeId.targetId) && likeType == likeId.likeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, targetId, likeType);
    }
}
