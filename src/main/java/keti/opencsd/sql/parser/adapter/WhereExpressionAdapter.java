package keti.opencsd.sql.parser.adapter;

import keti.opencsd.config.JsonKey;
import net.sf.jsqlparser.expression.ExpressionVisitorAdapter;
import net.sf.jsqlparser.statement.select.SubSelect;

public class WhereExpressionAdapter{
    private final ExpressionVisitorAdapter whereExpressionVisitor;
    public WhereExpressionAdapter(){
        whereExpressionVisitor = new ExpressionVisitorAdapter() {
            /**
             * used for only where expression (need no where column)
             * @param subSelect visitor event listened
             */
            @Override
            public void visit(SubSelect subSelect) {

                super.visit(subSelect);
            }

            // do not override column visit method here
        };
    }

    public ExpressionVisitorAdapter getWhereExpressionVisitor() {
        return whereExpressionVisitor;
    }
}
