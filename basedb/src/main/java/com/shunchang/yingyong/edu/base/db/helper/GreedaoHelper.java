package com.shunchang.yingyong.edu.base.db.helper;

import android.content.Context;


import com.shunchang.yingyong.edu.base.db.entity.UpdateLastTime;
import com.shunchang.yingyong.edu.base.db.greendao.DaoMaster;
import com.shunchang.yingyong.edu.base.db.greendao.DaoSession;
import com.shunchang.yingyong.edu.base.db.greendao.UpdateLastTimeDao;

import java.util.List;

/**
 * Created by mo on 2018/1/30.
 */

public class GreedaoHelper {
    private static GreedaoHelper instance = new GreedaoHelper();
    public static final String USER_DB_FILE = "%s.dat";
    private DaoSession session;
    private String dbFile;
    private GreedaoHelper(){

    };

    public void init(Context context,String userId){
        if (context == null) {
            throw new IllegalStateException("Cannot get the service context");
        }
        this.dbFile = String.format(USER_DB_FILE, userId);

        DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, dbFile, null);
        DaoMaster daoMaster = new DaoMaster(helper.getWritableDatabase());

        session = daoMaster.newSession();
    }

    public static GreedaoHelper getInstance(){
        return instance;
    }

    public String getDbFile(){
        return  dbFile;
    }


    /******************************更新时间**********************************/

    public void addUpdateLastTime(UpdateLastTime updateLastTime){
        UpdateLastTimeDao updateLastTimeDao = session.getUpdateLastTimeDao();
        updateLastTimeDao.insertOrReplaceInTx(updateLastTime);
    }

    public void updateUpdateLastTime(UpdateLastTime updateLastTime){
        UpdateLastTimeDao updateLastTimeDao = session.getUpdateLastTimeDao();
        UpdateLastTime updateUl = queryUpdateLastTime(updateLastTime.getBaseType());
        if(updateUl != null){
            updateUl = updateLastTime;
            updateLastTimeDao.updateInTx(updateUl);
        }else{
            updateUl = updateLastTime;
            addUpdateLastTime(updateUl);
        }

    }

    public UpdateLastTime queryUpdateLastTime(String baseType){
        UpdateLastTimeDao updateLastTimeDao = session.getUpdateLastTimeDao();
        UpdateLastTime updateLastTime = updateLastTimeDao.queryBuilder()
                .where(UpdateLastTimeDao.Properties.BaseType.eq(baseType)).unique();
        return updateLastTime;
    }

    /***********************************机型*******************************************/


}
