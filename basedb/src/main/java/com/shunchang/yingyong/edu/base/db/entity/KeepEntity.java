package com.shunchang.yingyong.edu.base.db.entity;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
import android.os.Build;
// KEEP INCLUDES END

/**
 * Entity mapped to table "KEEP_ENTITY".
 */
@Entity
public class KeepEntity {

    @Id
    private Long id;

    @Transient
    private String extra;

    @Generated(hash = 438590889)
    public KeepEntity() {
    }

    @Generated(hash = 2123631287)
    public KeepEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // KEEP METHODS - put your custom methods here
    @Override
    public String toString() {
        return "KeepEntity ID=42 (extra=" + extra + ")";
    }
    // KEEP METHODS END

}