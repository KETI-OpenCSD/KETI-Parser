package keti.opencsd.sql.parser.adapter;

import net.sf.jsqlparser.statement.StatementVisitorAdapter;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.update.Update;

public class StatementAdapter{
    private final StatementVisitorAdapter statementVisitor;
    //private final SelectAdapter selectAdapter;
    public StatementAdapter() {
        //selectAdapter = new SelectAdapter();
        statementVisitor = new StatementVisitorAdapter() {

            @Override
            public void visit(Insert insert) {

            }

            @Override
            public void visit(Select select) {
                // crud


                super.visit(select);
            }


            @Override
            public void visit(Update update) {

            }


            @Override
            public void visit(Delete delete) {

            }
        };
    }

    public StatementVisitorAdapter getStatementVisitor() {
        return statementVisitor;
    }
}
