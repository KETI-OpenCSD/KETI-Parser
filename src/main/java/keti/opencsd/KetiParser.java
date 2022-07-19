package keti.opencsd;

import keti.opencsd.sql.parser.Parser;
import net.sf.jsqlparser.parser.ParseException;
import net.sf.jsqlparser.statement.Statement;

public class KetiParser {
    public static void main(String[] args) throws ParseException {
        Parser parser = new Parser();
        String query = ""
                + "select "
                + "    s_acctbal, "
                + "    s_name, "
                + "    n_name, "
                + "    p_partkey, "
                + "    p_mfgr, "
                + "    s_address, "
                + "    s_phone, "
                + "    s_comment "
                + "from "
                + "    part, "
                + "    supplier, "
                + "    partsupp, "
                + "    nation, "
                + "    region "
                + "where "
                + "    p_partkey = ps_partkey and "
                + "    s_suppkey = ps_suppkey and "
                + "    p_size = 30 and "
                + "    p_type like '%steel' and "
                + "    s_nationkey = n_nationkey and "
                + "    n_regionkey = r_regionkey and "
                + "    r_name = 'asia' and "
                + "    ps_supplycost = ( "
                + "        select "
                + "            min(ps_supplycost) "
                + "        from "
                + "            partsupp, "
                + "            supplier, "
                + "            nation, "
                + "            region "
                + "        where "
                + "            p_partkey = ps_partkey and "
                + "            s_suppkey = ps_suppkey and "
                + "            s_nationkey = n_nationkey and "
                + "            n_regionkey = r_regionkey and "
                + "            r_name = 'asia' "
                + "    ) "
                + "order by "
                + "    s_acctbal desc, "
                + "    n_name, "
                + "    s_name, "
                + "    p_partkey "
                + "limit 100;";
        Statement stmt = parser.parseStatement(query);
        System.out.println(stmt.toString());
    }
}