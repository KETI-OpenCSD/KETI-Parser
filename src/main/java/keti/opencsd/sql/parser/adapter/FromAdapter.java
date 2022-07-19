package keti.opencsd.sql.parser.adapter;

import keti.opencsd.config.JsonKey;
import keti.opencsd.core.Parser;
import keti.opencsd.core.json.JsonManager;
import net.sf.jsqlparser.statement.select.FromItemVisitorAdapter;
import net.sf.jsqlparser.statement.select.SubSelect;

public class FromAdapter extends JsonManager {

    private final FromItemVisitorAdapter fromItemVisitor
    public FromAdapter(){
        fromItemVisitor = new FromItemVisitorAdapter() {
            /**
             * search sub query in from statement
             * @param subSelect visitor event listened
             */
            @Override
            public void visit(SubSelect subSelect) {
                putToJson(JsonKey.FROM_SUB_QUERY, 1, subSelect.toString());
                putToJson(JsonKey.FROM_SUB_QUERY_ANALYSE, 1, new Parser().parse(subSelect.toString()));
                super.visit(subSelect);
            }

            // do not override table visit method
        };

    }


    public FromItemVisitorAdapter getFromItemVisitor() {
        return fromItemVisitor;
    }
}
