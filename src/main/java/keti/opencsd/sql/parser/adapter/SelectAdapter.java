package keti.opencsd.sql.parser.adapter;

import keti.opencsd.config.JsonKey;
import keti.opencsd.core.Parser;
import keti.opencsd.core.json.JsonManager;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.select.*;

import java.util.List;

public class SelectAdapter extends JsonManager {
    private final SelectVisitorAdapter selectVisitorAdapter;
    private FromAdapter fromAdapter;
    private GroupByAdapter groupByAdapter;
    private OrderByAdapter orderByAdapter;
    private WhereExpressionAdapter whereExpressionAdapter;

    public SelectAdapter() {

        selectVisitorAdapter = new SelectVisitorAdapter() {
            /**
             * most select query is processed as plain select
             * @param plainSelect visitor event listened
             */
            @Override
            public void visit(PlainSelect plainSelect) {
                // distinct
                Distinct distinct = plainSelect.getDistinct();
                if (distinct != null)
                    putToJson(JsonKey.DISTINCT, "TRUE");

                // column
                List<SelectItem> selectItems = plainSelect.getSelectItems();
                if (selectItems != null)
                    //selectItems.forEach(selectItem -> putToJson(JsonKey.COLUMN, selectItem.toString()));
                    selectItems.forEach(selectItem -> selectItem.accept());


                // table
                FromItem fromItem = plainSelect.getFromItem();
                if (fromItem != null) {
                    putToJson(JsonKey.FROM, fromItem.toString());
                    Alias alias = fromItem.getAlias();
                    if (alias != null) {
                        String aliasName = alias.getName();
                        putToJson(JsonKey.FROM_ALIAS, aliasName);

                        // remove table alias from table query
                        fromItem.getAlias().setUseAs(false);
                        fromItem.setAlias(null);
                    }
                    fromItem.accept(fromItemVisitor);
                }

                // where
                Expression whereExpression = plainSelect.getWhere();
                if (whereExpression != null) {
                    putToJson(JsonKey.WHERE, whereExpression.toString());
                    whereExpression.accept(whereExpressionVisitor);
                }

                // group by
                GroupByElement groupByElement = plainSelect.getGroupBy();
                if (groupByElement != null)
                    groupByElement.accept(groupByVisitor);

                // order by
                List<OrderByElement> orderByElements = plainSelect.getOrderByElements();
                if (orderByElements != null)
                    orderByElements.forEach(orderByElement -> orderByElement.accept(orderByVisitor));

                // joins
                List<Join> joins = plainSelect.getJoins();
                if (joins != null) {
                    joins.forEach(join -> {
                        putToJson(JsonKey.JOIN, 1, join.toString());
                        Alias joinAlias = join.getRightItem().getAlias();
                        if (joinAlias != null) {
                            String joinAliasName = joinAlias.getName();
                            putToJson(JsonKey.JOIN_ALIAS, 1, joinAliasName);

                            // remove join alias in join query
                            joinAlias.setUseAs(false);
                            join.getRightItem().setAlias(null);
                        }
                    });
                }
            }

            /**
             * select including union(and etc...)
             * @param setOperationList visitor event listened
             */
            @Override
            public void visit(SetOperationList setOperationList) {
                // union
                List<SelectBody> selectBodies = setOperationList.getSelects();
                List<SetOperation> setOperations = setOperationList.getOperations();

                for (int i = 0; i < selectBodies.size(); ++i) {
                    if (i == 0)
                        injectJson(new Parser().parse(selectBodies.get(i).toString()));

                    if (i < setOperations.size()) {
                        String setOperationKey = String.format("%s %d", setOperations.get(i), i + 1); // ex) UNION 1, UNION ALL 1 ...
                        String setOperationAnalyseKey = String.format("%s %d", setOperations.get(i) + " ANALYSE", i + 1); // ex) UNION ANALYSE 1, UNION ALL ANALYSE 1 ...
                        putToJson(setOperationKey, selectBodies.get(i + 1).toString());
                        putToJson(setOperationAnalyseKey, new Parser().parse(selectBodies.get(i + 1).toString()));
                    } else break;
                }
            }
        };
    }

    public SelectVisitorAdapter getSelectVisitorAdapter() {
        return selectVisitorAdapter;
    }
}
