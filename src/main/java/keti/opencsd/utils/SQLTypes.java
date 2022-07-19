package keti.opencsd.utils;

public class SQLTypes {
    public static final TINYINT TINYINT = new TINYINT();
    public static final SMALLINT SMALLINT = new SMALLINT();
    public static final MEDIUMINT MEDIUMINT = new MEDIUMINT();
    public static final INT INT = new INT();
    public static final BINARY BINARY = new BINARY();
    public static final BIT BIT = new BIT();
    public static final BOOL BOOL = new BOOL();
    public static final BOOLEAN BOOLEAN = new BOOLEAN();
    public static final INTEGER INTEGER = new INTEGER();
    public static final BIGINT BIGINT = new BIGINT();
    public static final FLOAT FLOAT = new FLOAT();
    public static final DOUBLE DOUBLE = new DOUBLE();
    public static final DECIMAL DECIMAL = new DECIMAL();

    public static final CHAR CHAR = new CHAR();
    public static final VARCHAR VARCHAR = new VARCHAR();
    public static final TINYBLOB TINYBLOB = new TINYBLOB();
    public static final TINYTEXT TINYTEXT = new TINYTEXT();
    public static final BLOB BLOB = new BLOB();
    public static final TEXT TEXT = new TEXT();
    public static final MEDIUMBLOB MEDIUMBLOB = new MEDIUMBLOB();
    public static final MEDIUMTEXT MEDIUMTEXT = new MEDIUMTEXT();
    public static final LONGBLOB LONGBLOB = new LONGBLOB();
    public static final LONGTEXT LONGTEXT = new LONGTEXT();
    public static final ENUM ENUM = new ENUM();

    public static final DATE DATE = new DATE();
    public static final DATETIME DATETIME = new DATETIME();
    public static final TIMESTAMP TIMESTAMP = new TIMESTAMP();
    public static final TIME TIME = new TIME();
    public static final YEAR YEAR = new YEAR();

    public static final class TINYINT {
        public int getByteLength() {
            return 1;
        }

        @Override
        public final String toString() {
            return "TINYINT";
        }
    }
    public static class SMALLINT {
        public int getByteLength() {
            return 2;
        }
        @Override
        public final String toString() {
            return "SMALLINT";
        }
    }
    public static class MEDIUMINT {
        public int getByteLength() {
            return 3;
        }
        @Override
        public final String toString() {
            return "MEDIUMINT";
        }
    }
    public static class INT {
        public int getByteLength() {
            return 4;
        }
        @Override
        public final String toString() {
            return "INT";
        }
    }
    public static class BINARY{
        public int getByteLength() {
            return 1;
        }
        public final String toString() {
            return "BINARY";
        }
    }
    public static class BIT {
        public int getByteLength() {
            return 1;
        }
        @Override
        public final String toString() {
            return "BIT";
        }
    }
    public static class BOOL {
        public int getByteLength() {
            return 1;
        }
        @Override
        public final String toString() {
            return "BOOL";
        }
    }
    public static class BOOLEAN {
        public int getByteLength() {
            return 1;
        }
        @Override
        public final String toString() {
            return "BOOLEAN";
        }
    }
    public static class INTEGER {
        public int getByteLength() {
            return 4;
        }
        @Override
        public final String toString() {
            return "INTEGER";
        }
    }
    public static class BIGINT {
        public int getByteLength() {
            return 8;
        }
        @Override
        public final String toString() {
            return "BIGINT";
        }
    }
    public static class FLOAT {
        public int getByteLength() {
            return 4;
        }
        @Override
        public final String toString() {
            return "FLOAT";
        }
    }
    public static class DOUBLE {
        public int getByteLength() {
            return 8;
        }
        @Override
        public final String toString() {
            return "DOUBLE";
        }
    }
    public static class DECIMAL extends SQLTypes{
        public int getByteLength(int Length,int decimalLength) {
            return 1+getLength(Length-decimalLength)+getLength(decimalLength);
        }
        @Override
        public final String toString() {
            return "DECIMAL";
        }
    }
    public static class CHAR {
        public int getByteLength(int Length) {
            return Length;
        }
        @Override
        public final String toString() {
            return "CHAR";
        }
    }
    public static class VARCHAR {
        public int getByteLength(int Length) {
            return Length;
        }
        @Override
        public final String toString() {
            return "VARCHAR";
        }
    }
    public static class TINYBLOB {
        public int getByteLength(int Length) {
            return Length;
        }
        @Override
        public final String toString() {
            return "TINYBLOB";
        }
    }
    public static class TINYTEXT {
        public int getByteLength(int Length) {
            return Length;
        }
        @Override
        public final String toString() {
            return "TINYTEXT";
        }
    }
    public static class BLOB {
        public int getByteLength(int Length) {
            return Length;
        }
        @Override
        public final String toString() {
            return "BLOB";
        }
    }
    public static class TEXT {
        public int getByteLength(int Length) {
            return Length;
        }
        @Override
        public final String toString() {
            return "TEXT";
        }
    }
    public static class MEDIUMBLOB {
        public int getByteLength(int Length) {
            return Length;
        }
        @Override
        public final String toString() {
            return "MEDIUMBLOB";
        }
    }
    public static class MEDIUMTEXT {
        public int getByteLength(int Length) {
            return Length;
        }
        @Override
        public final String toString() {
            return "MEDIUMTEXT";
        }
    }
    public static class LONGBLOB {
        public int getByteLength(int Length) {
            return Length;
        }
        @Override
        public final String toString() {
            return "LONGBLOB";
        }
    }
    public static class LONGTEXT {
        public int getByteLength(int Length) {
            return Length;
        }
        @Override
        public final String toString() {
            return "LONGTEXT";
        }
    }
    public static class ENUM {
        public int getByteLength(int Length) {
            return Length;
        }
        @Override
        public final String toString() {
            return "ENUM";
        }
    }
    public static class DATE {
        public int getByteLength() {
            return 3;
        }
        @Override
        public final String toString() {
            return "DATE";
        }
    }
    public static class DATETIME {
        public int getByteLength() {
            return 8;
        }
        @Override
        public final String toString() {
            return "DATETIME";
        }
    }
    public static class TIMESTAMP {
        public int getByteLength() {
            return 4;
        }
        @Override
        public final String toString() {
            return "TIMESTAMP";
        }
    }
    public static class TIME {
        public int getByteLength() {
            return 3;
        }
        @Override
        public final String toString() {
            return "TIME";
        }
    }
    public static class YEAR {
        public int getByteLength() {
            return 1;
        }
        @Override
        public final String toString() {
            return "YEAR";
        }
    }
    protected int getLength(int typeLength){
        long lenMax = (long)Math.pow(10,typeLength);
        lenMax--;
        return Long.toHexString(lenMax).length()/2;
    }


}
