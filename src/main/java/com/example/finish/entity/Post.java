package com.example.finish.entity;

import com.example.finish.entity.abs.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends BaseEntity {

    private String title;
    @ManyToOne
    private Attachment cover;
    @ManyToOne
    private Attachment audio;
    @ManyToOne
    private Attachment video;
}
