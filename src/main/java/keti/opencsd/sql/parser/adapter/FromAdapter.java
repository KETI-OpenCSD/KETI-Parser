package keti.opencsd.sql.parser.adapter;

import net.sf.jsqlparser.statement.select.FromItemVisitorAdapter;
import net.sf.jsqlparser.statement.select.SubSelect;

public class FromAdapter {

    private final FromItemVisitorAdapter fromItemVisitor;
    public FromAdapter(){
        fromItemVisitor = new FromItemVisitorAdapter() {
            /**
             * search sub query in from statement
             * @param subSelect visitor event listened
             */
            @Override
            public void visit(SubSelect subSelect) {
                super.visit(subSelect);
            }

            // do not override table visit method
        };

    }


    public FromItemVisitorAdapter getFromItemVisitor() {
        return fromItemVisitor;
    }
}
