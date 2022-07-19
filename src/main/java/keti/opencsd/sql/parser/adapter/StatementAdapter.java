package keti.opencsd.sql.parser.adapter;

import keti.opencsd.config.JsonKey;
import keti.opencsd.core.json.JsonManager;
import net.sf.jsqlparser.statement.StatementVisitorAdapter;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.update.Update;

public class StatementAdapter extends JsonManager {
    private final StatementVisitorAdapter statementVisitor;
    private final SelectAdapter selectAdapter;
    public StatementAdapter() {
        selectAdapter = new SelectAdapter();
        statementVisitor = new StatementVisitorAdapter() {
            /**
             * insert
             *
             * @param insert visitor event listened
             */
            @Override
            public void visit(Insert insert) {

            }
            /**
             * select
             *
             * @param select visitor event listened
             */
            @Override
            public void visit(Select select) {
                // crud

                putToJson(JsonKey.CRUD, JsonKey.SELECT);
                select.getSelectBody().accept(selectAdapter.getSelectVisitorAdapter());
                super.visit(select);
            }

            /**
             * update
             *
             * @param update visitor event listened
             */
            @Override
            public void visit(Update update) {

            }

            /**
             * delete
             *
             * @param delete visitor event listened
             */
            @Override
            public void visit(Delete delete) {

            }
        };
    }

    public StatementVisitorAdapter getStatementVisitor() {
        return statementVisitor;
    }
}
