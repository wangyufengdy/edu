package com.shunchang.yingyong.edu.base.db.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;


import com.shunchang.yingyong.edu.base.db.entity.UpdateLastTime;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "updateLastTime".
*/
public class UpdateLastTimeDao extends AbstractDao<UpdateLastTime, Long> {

    public static final String TABLENAME = "updateLastTime";

    /**
     * Properties of entity UpdateLastTime.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property BaseType = new Property(1, String.class, "BaseType", false, "BASE_TYPE");
        public final static Property BaseTimeSpan = new Property(2, String.class, "BaseTimeSpan", false, "BASE_TIME_SPAN");
    };


    public UpdateLastTimeDao(DaoConfig config) {
        super(config);
    }
    
    public UpdateLastTimeDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"updateLastTime\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"BASE_TYPE\" TEXT," + // 1: BaseType
                "\"BASE_TIME_SPAN\" TEXT);"); // 2: BaseTimeSpan
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"updateLastTime\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, UpdateLastTime entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String BaseType = entity.getBaseType();
        if (BaseType != null) {
            stmt.bindString(2, BaseType);
        }
 
        String BaseTimeSpan = entity.getBaseTimeSpan();
        if (BaseTimeSpan != null) {
            stmt.bindString(3, BaseTimeSpan);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public UpdateLastTime readEntity(Cursor cursor, int offset) {
        UpdateLastTime entity = new UpdateLastTime( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // BaseType
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // BaseTimeSpan
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, UpdateLastTime entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setBaseType(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setBaseTimeSpan(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }

    @Override
    protected void bindValues(DatabaseStatement stmt, UpdateLastTime entity) {

    }

    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(UpdateLastTime entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(UpdateLastTime entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected boolean hasKey(UpdateLastTime entity) {
        return false;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
