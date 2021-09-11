package com.formation.sakila.rs.entities;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.util.StringJoiner;

@Entity
    @Table(name="staff")
public class StaffPicture {
    @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
            @Column(name="staff_id")
    private Long id;

    private byte[] picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getPictureAsString() throws UnsupportedEncodingException {
        if ( picture != null )
            return new String(picture,"UTF-8");
        else
            return null;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StaffPicture.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("picture size=" + picture.length)
                .toString();
    }

}
