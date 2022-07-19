package keti.opencsd.sql.parser;

import keti.opencsd.config.JsonKey;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.arithmetic.*;
import net.sf.jsqlparser.expression.operators.relational.Between;
import net.sf.jsqlparser.parser.CCJSqlParser;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.parser.ParseException;
import net.sf.jsqlparser.parser.StringProvider;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitorAdapter;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.statement.update.Update;
import org.json.JSONObject;

import java.util.List;

public class Parser {

}
