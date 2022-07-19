package keti.opencsd;

import keti.opencsd.sql.parser.Parser;
import keti.opencsd.table.TableManager;
import keti.opencsd.utils.SQLTypes;
import net.sf.jsqlparser.parser.ParseException;
import net.sf.jsqlparser.statement.Statement;

import java.util.List;


/*
l_orderkey int(11) NOT NULL
l_partkey int(11) NOT NULL
l_suppkey int(11) NOT NULL
l_linenumber int(11) NOT NULL
l_quantity decimal(15,2) NOT NULL
l_extendedprice decimal(15,2) NOT NULL
l_discount decimal(15,2) NOT NULL
l_tax decimal(15,2) NOT NULL
l_returnflag char(1) NOT NULL
l_linestatus char(1) NOT NULL
l_shipDATE date NOT NULL
l_commitDATE date NOT NULL
l_receiptDATE date NOT NULL
l_shipinstruct char(25) NOT NULL
l_shipmode char(10) NOT NULL
l_commentvar char(44) NOT NULL
 */
public class KetiParser {
    public static void main(String[] args) throws ParseException {
        TableManager tableManager = new TableManager();

        List<TableManager.Table> tableList = tableManager.getTableList();
        System.out.println(tableList.size());
        tableManager.AppendTable(tableManager.TableBuilder("lineitem")
                .addSchema("l_orderkey","int")
                .addSchema("l_partkey", "int")
                .addSchema("l_suppkey", "int")
                .addSchema("l_linenumber", "int")
                .addSchema("l_quantity", "decimal",15,2)
                .addSchema("l_extendedprice", "decimal",15,2)
                .addSchema("l_discount", "decimal",15,2)
                .addSchema("l_tax", "decimal",15,2)
                .addSchema("l_returnflag", "char",1)
                .addSchema("l_linestatus", "char",1)
                .addSchema("l_shipDATE", "date")
                .addSchema("l_commitDATE", "date")
                .addSchema("l_receiptDATE", "date")
                .addSchema("l_shipinstruct", "char",25)
                .addSchema("l_shipmode", "char",10)
                .addSchema("l_commentvar", "varchar",44)
                .build());
        tableList = tableManager.getTableList();
        System.out.println(tableList.size());
        tableManager.AppendTable(tableManager.TableBuilder("lineitem")
                .addSchema("l_orderkey","int")
                .addSchema("l_partkey", "int")
                .addSchema("l_suppkey", "int")
                .addSchema("l_linenumber", "int")
                .addSchema("l_quantity", "decimal",15,2)
                .addSchema("l_extendedprice", "decimal",15,2)
                .addSchema("l_discount", "decimal",15,2)
                .addSchema("l_tax", "decimal",15,2)
                .addSchema("l_returnflag", "char",1)
                .addSchema("l_linestatus", "char",1)
                .addSchema("l_shipDATE", "date")
                .addSchema("l_commitDATE", "date")
                .addSchema("l_receiptDATE", "date")
                .addSchema("l_shipinstruct", "char",25)
                .addSchema("l_shipmode", "char",10)
                .addSchema("l_commentvar", "varchar",44)
                .build());
        tableList = tableManager.getTableList();
        System.out.println(tableList.size());
        tableManager.AppendTable(tableManager.TableBuilder("lineitem")
                .addSchema("l_orderkey","int")
                .addSchema("l_partkey", "int")
                .addSchema("l_suppkey", "int")
                .addSchema("l_linenumber", "int")
                .addSchema("l_quantity", "decimal",15,2)
                .addSchema("l_extendedprice", "decimal",15,2)
                .addSchema("l_discount", "decimal",15,2)
                .addSchema("l_tax", "decimal",15,2)
                .addSchema("l_returnflag", "char",1)
                .addSchema("l_linestatus", "char",1)
                .addSchema("l_shipDATE", "date")
                .addSchema("l_commitDATE", "date")
                .addSchema("l_receiptDATE", "date")
                .addSchema("l_shipinstruct", "char",25)
                .addSchema("l_shipmode", "char",10)
                .addSchema("l_commentvar", "varchar",44)
                .build());
        tableList = tableManager.getTableList();
        System.out.println(tableList.size());
        System.out.println(tableList.get(0).tableName);
        System.out.println(tableList.get(0).colInfo);


    }
}