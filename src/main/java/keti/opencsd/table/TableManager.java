package keti.opencsd.table;

import keti.opencsd.utils.SQLTypeString;
import keti.opencsd.utils.SQLTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class TableManager {
    private HashMap<String, HashMap<String, Table>> DBInfo;
    private HashMap<String, Table> TableList;
    public TableManager() {
        this.DBInfo = new HashMap<>();
        this.TableList = new HashMap<>();
    }
    public Table TableBuilder(){
        return new Table();
    }
    public void AppendTable(String tableName, Table table){
        this.TableList.put(tableName, table);
    }
    public void AppendTable(String DBName, String tableName, Table table){
        this.TableList.put(tableName, table);
        this.DBInfo.put(DBName, this.TableList);
    }

    public HashMap<String, HashMap<String, Table>> getDBInfo() {
        return DBInfo;
    }

    public HashMap<String, Table> getTableList() {
        return TableList;
    }

    public static class Table extends TableManager{
        public final HashMap<String,HashMap<String, Integer>> colInfo;

        public Table(){
            this.colInfo = new HashMap<>();
        }
        public Table addSchema(String colName, String colType){
            HashMap<String, Integer> integerHashMap = new HashMap<>();
            colType = colType.toUpperCase();
            switch (colType){
                case SQLTypeString.TINYINT:
                    integerHashMap.put(colType,SQLTypes.TINYINT.getByteLength());
                case SQLTypeString.SMALLINT:
                    integerHashMap.put(colType,SQLTypes.SMALLINT.getByteLength());
                case SQLTypeString.MEDIUMINT:
                    integerHashMap.put(colType,SQLTypes.MEDIUMINT.getByteLength());
                case SQLTypeString.INT:
                    integerHashMap.put(colType,SQLTypes.INT.getByteLength());
                case SQLTypeString.BINARY:
                    integerHashMap.put(colType,SQLTypes.BINARY.getByteLength());
                case SQLTypeString.BIT:
                    integerHashMap.put(colType,SQLTypes.BIT.getByteLength());
                case SQLTypeString.BOOL:
                    integerHashMap.put(colType,SQLTypes.BOOL.getByteLength());
                case SQLTypeString.BOOLEAN:
                    integerHashMap.put(colType,SQLTypes.BOOLEAN.getByteLength());
                case SQLTypeString.INTEGER:
                    integerHashMap.put(colType,SQLTypes.INTEGER.getByteLength());
                case SQLTypeString.BIGINT:
                    integerHashMap.put(colType,SQLTypes.BIGINT.getByteLength());
                case SQLTypeString.FLOAT:
                    integerHashMap.put(colType,SQLTypes.FLOAT.getByteLength());
                case SQLTypeString.DOUBLE:
                    integerHashMap.put(colType,SQLTypes.DOUBLE.getByteLength());
                case SQLTypeString.DECIMAL:
                    integerHashMap.put(colType,SQLTypes.DECIMAL.getByteLength(10,0));
                case SQLTypeString.CHAR:
                    integerHashMap.put(colType,SQLTypes.CHAR.getByteLength(1));
                case SQLTypeString.VARCHAR:
                    integerHashMap.put(colType,SQLTypes.VARCHAR.getByteLength(1));
                case SQLTypeString.TINYBLOB:
                    integerHashMap.put(colType,SQLTypes.TINYBLOB.getByteLength(1));
                case SQLTypeString.TINYTEXT:
                    integerHashMap.put(colType,SQLTypes.TINYTEXT.getByteLength(1));
                case SQLTypeString.BLOB:
                    integerHashMap.put(colType,SQLTypes.BLOB.getByteLength(1));
                case SQLTypeString.TEXT:
                    integerHashMap.put(colType,SQLTypes.TEXT.getByteLength(1));
                case SQLTypeString.MEDIUMBLOB:
                    integerHashMap.put(colType,SQLTypes.MEDIUMBLOB.getByteLength(1));
                case SQLTypeString.MEDIUMTEXT:
                    integerHashMap.put(colType,SQLTypes.MEDIUMTEXT.getByteLength(1));
                case SQLTypeString.LONGBLOB:
                    integerHashMap.put(colType,SQLTypes.LONGBLOB.getByteLength(1));
                case SQLTypeString.LONGTEXT:
                    integerHashMap.put(colType,SQLTypes.LONGTEXT.getByteLength(1));
                case SQLTypeString.ENUM:
                    integerHashMap.put(colType,SQLTypes.ENUM.getByteLength(1));
                case SQLTypeString.DATE:
                    integerHashMap.put(colType,SQLTypes.DATE.getByteLength());
                case SQLTypeString.DATETIME:
                    integerHashMap.put(colType,SQLTypes.DATETIME.getByteLength());
                case SQLTypeString.TIMESTAMP:
                    integerHashMap.put(colType,SQLTypes.TIMESTAMP.getByteLength());
                case SQLTypeString.TIME:
                    integerHashMap.put(colType,SQLTypes.TIME.getByteLength());
                case SQLTypeString.YEAR:
                    integerHashMap.put(colType,SQLTypes.YEAR.getByteLength());
            }
            this.colInfo.put(colName,integerHashMap);
            return this;
        }
        public Table addSchema(String colName, String colType, int dataLength){
            HashMap<String, Integer> integerHashMap = new HashMap<>();
            colType = colType.toUpperCase();
            switch (colType){
                case SQLTypeString.CHAR:
                    integerHashMap.put(colType,SQLTypes.CHAR.getByteLength(dataLength));
                case SQLTypeString.VARCHAR:
                    integerHashMap.put(colType,SQLTypes.VARCHAR.getByteLength(dataLength));
                case SQLTypeString.TINYBLOB:
                    integerHashMap.put(colType,SQLTypes.TINYBLOB.getByteLength(dataLength));
                case SQLTypeString.TINYTEXT:
                    integerHashMap.put(colType,SQLTypes.TINYTEXT.getByteLength(dataLength));
                case SQLTypeString.BLOB:
                    integerHashMap.put(colType,SQLTypes.BLOB.getByteLength(dataLength));
                case SQLTypeString.TEXT:
                    integerHashMap.put(colType,SQLTypes.TEXT.getByteLength(dataLength));
                case SQLTypeString.MEDIUMBLOB:
                    integerHashMap.put(colType,SQLTypes.MEDIUMBLOB.getByteLength(dataLength));
                case SQLTypeString.MEDIUMTEXT:
                    integerHashMap.put(colType,SQLTypes.MEDIUMTEXT.getByteLength(dataLength));
                case SQLTypeString.LONGBLOB:
                    integerHashMap.put(colType,SQLTypes.LONGBLOB.getByteLength(dataLength));
                case SQLTypeString.LONGTEXT:
                    integerHashMap.put(colType,SQLTypes.LONGTEXT.getByteLength(dataLength));
                case SQLTypeString.ENUM:
                    integerHashMap.put(colType,SQLTypes.ENUM.getByteLength(dataLength));
            }
            this.colInfo.put(colName,integerHashMap);
            return this;
        }
        public Table addSchema(String colName, String colType, int integerLength, int decimalLength){
            HashMap<String, Integer> integerHashMap = new HashMap<>();
            colType = colType.toUpperCase();
            if ("DECIMAL".equals(colType)) {
                integerHashMap.put(colType, SQLTypes.DECIMAL.getByteLength(integerLength, decimalLength));
            }
            this.colInfo.put(colName,integerHashMap);
            return this;
        }
        public Table build(){
            return this;
        }
    }


}
