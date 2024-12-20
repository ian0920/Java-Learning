package com.artogether.util;

public final class DataBaseUtil {


    public static final String username = "root";          //填入帳號
    public static final String password = "Aa12345678";    //填入密碼
    public static final String schemaName = "demo";        //填入資料庫schema



    public static final String serverName = "localhost";
    public static final String port = "3306";
    public static final String databaseDriver = "com.mysql.jdbc.Driver";

    //選擇使用的資料庫系統mysql; oracle; sqlserver
    public static final String dbName = "mysql";






    // oracle資料庫系統才要填 Express Edition = xe; Enterprise Edition = ee;
    public static final String SID = "xe";



    public static String getFullUrl(){

        String fullUrl = "";

        switch(dbName){
            case "mysql": fullUrl = "jdbc:mysql://"+serverName+":"+port+"/"+schemaName + "?serverTimezone=Asia/Taipei";
            break;
            case "oracle": fullUrl = "jdbc:oracle:thin:@"+serverName+":"+port+":" + SID;
            break;
            case "sqlserver": fullUrl = "jdbc:sqlserver://"+serverName+":"+port+";databaseName="+schemaName;
            break;
            default: fullUrl = "";
        }

        return fullUrl;
    }
}
