package com.jjh.mtvs.domain.model.myroom.entity;

import com.jjh.mtvs.domain.model.object.entity.Object;
import com.jjh.mtvs.domain.model.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tbl_my_room")
public class MyRoom {
    @Id
    @Column(name = "my_room_id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "object_id")
    private List<Object> objects = new ArrayList<>();

    public void setObjects(List<Object> objects) {
        this.objects.addAll(objects);
    }
}
