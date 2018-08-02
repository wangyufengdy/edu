package com.shunchang.yingyong.edu.base.db.green;


import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class EduGreenDao {

    public static String PACKAGE_NAME = "com.gwhome.db.greendao";
    public static String OUT_DIR = "sdk/src/main/java/";
    private static String entityPath = "com.gwhome.db.entity";
    public static void main(String[] args){
        int userDbVersion = 1;

        Schema greeSchema = new Schema(userDbVersion,PACKAGE_NAME);
        greeSchema.enableKeepSectionsByDefault();

        /************************entity*****************************/

        addCityAirport(greeSchema);
        addUpdateLastTime(greeSchema);


        /*****************************************************/
        try {
            new DaoGenerator().generateAll(greeSchema, OUT_DIR);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // ���л���
    private static void addCityAirport(Schema schema) {
        Entity cityAirport =  schema.addEntity("CityAirport");
        cityAirport.implementsSerializable();
        cityAirport.setTableName("cityAirport");
        cityAirport.setClassNameDao("CityAirportDao");
        cityAirport.setJavaPackage(entityPath);

        cityAirport.addIdProperty().autoincrement();
        cityAirport.addStringProperty("CityCode").notNull();
        cityAirport.addStringProperty("CityName");
        cityAirport.addStringProperty("AirPortName");

        cityAirport.setHasKeepSections(true);
    }

    // �����µ�ʱ��
    private static void addUpdateLastTime(Schema schema){
        Entity updateLastTime =  schema.addEntity("UpdateLastTime");
        updateLastTime.implementsSerializable();
        updateLastTime.setTableName("updateLastTime");
        updateLastTime.setClassNameDao("UpdateLastTimeDao");
        updateLastTime.setJavaPackage(entityPath);

        updateLastTime.addIdProperty().autoincrement();
        updateLastTime.addStringProperty("BaseType");//
        updateLastTime.addStringProperty("BaseTimeSpan");//
        updateLastTime.setHasKeepSections(true);
    }


}
