package keti.opencsd.config;

import keti.opencsd.KetiParser;

public class Config {
    public enum AggregationFunc {
        COLUMN(0),
        SUM(1),
        AVG(2),
        COUNT(3),
        STARCOUNT(4),
        MIN(5),
        MAX(6),
        CASE(7),
        WHEN(8),
        THEN(9),
        ELSE(10),
        LIKE(11);
        private final int value;
        AggregationFunc(int value) {
            this.value = value;
        }
        public int getValue() { return value; }
    }
    public enum ExtraSelectFunc {
        ORDERBY(0),
        GROUPBY(1),
        HAVING(2),
        LIMIT(3);
        private final int value;
        ExtraSelectFunc(int value) {
            this.value = value;
        }
        public int getValue() { return value; }
    }
    public enum OrderType {
        ASC(0),
        DESC(1);
        private final int value;
        OrderType(int value) {
            this.value = value;
        }
        public int getValue() { return value; }
    }

    public enum FilterOperatorType {
        KETI_GE(0),  // >=
        KETI_LE(1),      // <=
        KETI_GT(2),      // >
        KETI_LT(3),      // <
        KETI_ET(4),      // ==
        KETI_NE(5),      // !=
        KETI_LIKE(6),    // RV로 스트링
        KETI_BETWEEN(7), // RV로 배열형식 [10,20] OR [COL1,20] --> extra
        KETI_IN(8),      // RV로 배열형식 [10,20,30,40] + 크기 --> extra
        KETI_IS(9),      // IS 와 IS NOT을 구분 RV는 무조건 NULL
        KETI_ISNOT(10),   // IS와 구분 필요 RV는 무조건 NULL
        KETI_NOT(11),     // ISNOT과 관련 없음 OPERATOR 앞에 붙는 형식 --> 혼자 들어오는 oper
        KETI_AND(12),     // AND --> 혼자 들어오는 oper
        KETI_OR(13),      // OR --> 혼자 들어오는 oper
        KETI_JOIN(14),    // 타입 나눠야함 left, right, inner, outer
        KETI_DEFAULT(15),
        KETI_UNION (100),
        KETI_UNIONALL(101),
        KETI_INTERSECT(102), //MySQL 미지원
        KETI_MINUS(103), //MySQL 미지원
        KETI_PLUS(104);
        private final int value;
        FilterOperatorType(int value) {
            this.value = value;
        }
        public int getValue() { return value; }
    }

    public enum DataType{
        TINYINT(0),
        SMALLINT(1),
        MEDIUMINT(2),
        INT(3),
        BINARY(4),
        BIT(5),
        BOOL(6),
        BOOLEAN(7),
        INTEGER(8),
        BIGINT(9),
        FLOAT(10),
        DOUBLE(11),
        DECIMAL(12),
        CHAR(13),
        VARCHAR(14),
        TINYBLOB(15),
        TINYTEXT(16),
        BLOB(17),
        TEXT(18),
        MEDIUMBLOB(19),
        MEDIUMTEXT(20),
        LONGBLOB(21),
        LONGTEXT(22),
        ENUM(23),
        DATE(24),
        DATETIME(25),
        TIMESTAMP(26),
        TIME(27),
        YEAR(28);
        private final int value;
        DataType(int value) {
            this.value = value;
        }
        public int getValue() { return value; }
    }

    public static int getValue(Object DataType){
        KetiParser.print(DataType.getClass());
        return 0;
    }
}
