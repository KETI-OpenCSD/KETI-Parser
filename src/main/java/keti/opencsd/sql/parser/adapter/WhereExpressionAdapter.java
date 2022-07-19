package keti.opencsd.sql.parser.adapter;

import keti.opencsd.config.JsonKey;
import keti.opencsd.core.Parser;
import keti.opencsd.core.json.JsonManager;
import net.sf.jsqlparser.expression.ExpressionVisitorAdapter;
import net.sf.jsqlparser.statement.select.SubSelect;

public class WhereExpressionAdapter extends JsonManager {
    private final ExpressionVisitorAdapter whereExpressionVisitor;
    public WhereExpressionAdapter(){
        whereExpressionVisitor = new ExpressionVisitorAdapter() {
            /**
             * used for only where expression (need no where column)
             * @param subSelect visitor event listened
             */
            @Override
            public void visit(SubSelect subSelect) {
                putToJson(JsonKey.WHERE_SUB_QUERY, 1, subSelect.toString());
                putToJson(JsonKey.WHERE_SUB_QUERY_ANALYSE, 1, new Parser().parse(subSelect.toString()));
                super.visit(subSelect);
            }

            // do not override column visit method here
        };
    }

    public ExpressionVisitorAdapter getWhereExpressionVisitor() {
        return whereExpressionVisitor;
    }
}
