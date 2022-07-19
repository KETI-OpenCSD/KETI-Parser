package keti.opencsd.table;

import keti.opencsd.utils.SQLTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


/*
case SQLTypes.TINYINT.toString():
case SQLTypes.SMALLINT.toString():
case SQLTypes.MEDIUMINT.toString():
case SQLTypes.INT.toString():
case SQLTypes.BINARY.toString():
case SQLTypes.BIT.toString():
case SQLTypes.BOOL.toString():
case SQLTypes.BOOLEAN.toString():
case SQLTypes.INTEGER.toString():
case SQLTypes.BIGINT.toString():
case SQLTypes.FLOAT.toString():
case SQLTypes.DOUBLE.toString():
case SQLTypes.DECIMAL.toString():
case SQLTypes.CHAR.toString():
case SQLTypes.VARCHAR.toString():
case SQLTypes.TINYBLOB.toString():
case SQLTypes.TINYTEXT.toString():
case SQLTypes.BLOB.toString():
case SQLTypes.TEXT.toString():
case SQLTypes.MEDIUMBLOB.toString():
case SQLTypes.MEDIUMTEXT.toString():
case SQLTypes.LONGBLOB.toString():
case SQLTypes.LONGTEXT.toString():
case SQLTypes.ENUM.toString():
case SQLTypes.DATE.toString():
case SQLTypes.DATETIME.toString():
case SQLTypes.TIMESTAMP.toString():
case SQLTypes.TIME.toString():
case SQLTypes.YEAR.toString():
 */
public class TableManager {
    private List<Table> tableList;
    public TableManager() {
        this.tableList = new ArrayList<>();
    }
    public TableManager(List<Table> tableList) {
        this.tableList = tableList;
    }

    public Table TableBuilder(String tableName){
        return new Table(tableName);
    }
    public void AppendTable(Table table){
        this.tableList.add(table);
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public static class Table extends TableManager{
        public final String tableName;
        public final HashMap<String,HashMap<String, Integer>> colInfo;

        public Table(String tableName){
            this.tableName = tableName;
            this.colInfo = new HashMap<>();
        }
        public Table addSchema(String colName, String colType){
            HashMap<String, Integer> integerHashMap = new HashMap<>();
            colType = colType.toUpperCase();
            switch (colType){
                case "TINYINT":
                    integerHashMap.put(colType,SQLTypes.TINYINT.getByteLength());
                case "SMALLINT":
                    integerHashMap.put(colType,SQLTypes.SMALLINT.getByteLength());
                case "MEDIUMINT":
                    integerHashMap.put(colType,SQLTypes.MEDIUMINT.getByteLength());
                case "INT":
                    integerHashMap.put(colType,SQLTypes.INT.getByteLength());
                case "BINARY":
                    integerHashMap.put(colType,SQLTypes.BINARY.getByteLength());
                case "BIT":
                    integerHashMap.put(colType,SQLTypes.BIT.getByteLength());
                case "BOOL":
                    integerHashMap.put(colType,SQLTypes.BOOL.getByteLength());
                case "BOOLEAN":
                    integerHashMap.put(colType,SQLTypes.BOOLEAN.getByteLength());
                case "INTEGER":
                    integerHashMap.put(colType,SQLTypes.INTEGER.getByteLength());
                case "BIGINT":
                    integerHashMap.put(colType,SQLTypes.BIGINT.getByteLength());
                case "FLOAT":
                    integerHashMap.put(colType,SQLTypes.FLOAT.getByteLength());
                case "DOUBLE":
                    integerHashMap.put(colType,SQLTypes.DOUBLE.getByteLength());
                case "DECIMAL":
                    integerHashMap.put(colType,SQLTypes.DECIMAL.getByteLength(10,0));
                case "CHAR":
                    integerHashMap.put(colType,SQLTypes.CHAR.getByteLength(1));
                case "VARCHAR":
                    integerHashMap.put(colType,SQLTypes.VARCHAR.getByteLength(1));
                case "TINYBLOB":
                    integerHashMap.put(colType,SQLTypes.TINYBLOB.getByteLength(1));
                case "TINYTEXT":
                    integerHashMap.put(colType,SQLTypes.TINYTEXT.getByteLength(1));
                case "BLOB":
                    integerHashMap.put(colType,SQLTypes.BLOB.getByteLength(1));
                case "TEXT":
                    integerHashMap.put(colType,SQLTypes.TEXT.getByteLength(1));
                case "MEDIUMBLOB":
                    integerHashMap.put(colType,SQLTypes.MEDIUMBLOB.getByteLength(1));
                case "MEDIUMTEXT":
                    integerHashMap.put(colType,SQLTypes.MEDIUMTEXT.getByteLength(1));
                case "LONGBLOB":
                    integerHashMap.put(colType,SQLTypes.LONGBLOB.getByteLength(1));
                case "LONGTEXT":
                    integerHashMap.put(colType,SQLTypes.LONGTEXT.getByteLength(1));
                case "ENUM":
                    integerHashMap.put(colType,SQLTypes.ENUM.getByteLength(1));
                case "DATE":
                    integerHashMap.put(colType,SQLTypes.DATE.getByteLength());
                case "DATETIME":
                    integerHashMap.put(colType,SQLTypes.DATETIME.getByteLength());
                case "TIMESTAMP":
                    integerHashMap.put(colType,SQLTypes.TIMESTAMP.getByteLength());
                case "TIME":
                    integerHashMap.put(colType,SQLTypes.TIME.getByteLength());
                case "YEAR":
                    integerHashMap.put(colType,SQLTypes.YEAR.getByteLength());
            }
            this.colInfo.put(colName,integerHashMap);
            return this;
        }
        public Table addSchema(String colName, String colType, int dataLength){
            HashMap<String, Integer> integerHashMap = new HashMap<>();
            colType = colType.toUpperCase();
            switch (colType){
                case "CHAR":
                    integerHashMap.put(colType,SQLTypes.CHAR.getByteLength(dataLength));
                case "VARCHAR":
                    integerHashMap.put(colType,SQLTypes.VARCHAR.getByteLength(dataLength));
                case "TINYBLOB":
                    integerHashMap.put(colType,SQLTypes.TINYBLOB.getByteLength(dataLength));
                case "TINYTEXT":
                    integerHashMap.put(colType,SQLTypes.TINYTEXT.getByteLength(dataLength));
                case "BLOB":
                    integerHashMap.put(colType,SQLTypes.BLOB.getByteLength(dataLength));
                case "TEXT":
                    integerHashMap.put(colType,SQLTypes.TEXT.getByteLength(dataLength));
                case "MEDIUMBLOB":
                    integerHashMap.put(colType,SQLTypes.MEDIUMBLOB.getByteLength(dataLength));
                case "MEDIUMTEXT":
                    integerHashMap.put(colType,SQLTypes.MEDIUMTEXT.getByteLength(dataLength));
                case "LONGBLOB":
                    integerHashMap.put(colType,SQLTypes.LONGBLOB.getByteLength(dataLength));
                case "LONGTEXT":
                    integerHashMap.put(colType,SQLTypes.LONGTEXT.getByteLength(dataLength));
                case "ENUM":
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
