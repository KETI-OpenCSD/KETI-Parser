package keti.opencsd.sql.parser.adapter;

import keti.opencsd.snippet.SnippetManager;
import keti.opencsd.table.TableManager;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.Function;
import net.sf.jsqlparser.statement.select.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SelectAdapter extends SnippetManager {
    private final SelectItemVisitorAdapter selectItemVisitorAdapter;
    private SnippetManager snippetManager;
    private TableManager tableManager;
    private boolean hasStar = false;

    public SelectAdapter(SnippetManager manager, TableManager table) {
        this.snippetManager = manager;
        this.tableManager = table;
        selectItemVisitorAdapter = new SelectItemVisitorAdapter() {
            @Override
            public void visit(AllColumns columns) {
                hasStar = true;
            }
            @Override
            public void visit(AllTableColumns columns) {
                HashMap<String, TableManager.Table> tbMap = tableManager.getTableList();
                Set<String> columnInfo = tbMap.get(columns.getTable().getName()).colInfo.keySet();
                Iterator<String> it = columnInfo.iterator();
                while(it.hasNext()){
                    snippetManager.appendTableColumn(it.next());
                    snippetManager.appendAlias(it.next());
                }
            }
            @Override
            public void visit(SelectExpressionItem item) {
                if (item.getAlias()!=null){
                    snippetManager.appendAlias(item.getAlias().getName());
                }
                Expression expr = item.getExpression();
                switch (expr.getClass().getSimpleName()){
                    case "Function":
                        Function func = (Function) expr;
                        String funcName = func.getName();
                        String parameters = PlainSelect.getStringList(func.getParameters().getExpressions(), true, false);


                }

            }
        };
    }
}
