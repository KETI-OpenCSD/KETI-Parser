package keti.opencsd.snippet;

import keti.opencsd.config.IDGenerator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class SnippetManager {
    protected Snippet snippet;
    protected Snippet.Filter filter;

    ObjectMapper mapper = new ObjectMapper();
    public SnippetManager(){
        this.snippet = new Snippet();
        this.filter = new Snippet.Filter();
    }
    public String GetJsonData(){
        String jsonInString01;
        try {
            jsonInString01 = mapper.writeValueAsString(snippet);
            return jsonInString01;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public void setQueryID(int queryID) {
        snippet.QueryID = queryID;
    }
    public void setWorkID(int workID) {
        snippet.WorkID = workID;
    }
    public void setTableName(String tableName) {
        snippet.TableName = tableName;
    }
    public void setTableColumn(List<String> tableColumn) {
        snippet.TableColumn = tableColumn;
    }
    public void appendTableColumn(String tableColumn) {
        snippet.TableColumn.add(tableColumn);
    }
    public void setTableFilter(List<Snippet.Filter> tableFilter) {
        snippet.TableFilter = tableFilter;
    }
    public void appendTableFilter(Snippet.Filter tableFilter) {
        snippet.TableFilter.add(tableFilter);
    }
    public void setTableOffset(int tableOffset) {
        snippet.TableOffset = tableOffset;
    }
    public void setTableOfflen(int tableOfflen) {
        snippet.TableOfflen = tableOfflen;
    }
    public void setTableDatatype(int tableDatatype) {
        snippet.TableDatatype = tableDatatype;
    }
    public void setAlias(List<String> alias) {
        snippet.Alias = alias;
    }
    public void appendAlias(String alias) {
        snippet.Alias.add(alias);
    }
    public void setColumnFiltering(List<String> columnFiltering) {
        snippet.ColumnFiltering = columnFiltering;
    }
    public void appendColumnFiltering(String columnFiltering) {
        snippet.ColumnFiltering.add(columnFiltering);
    }
    public void setColumnProjection(List<List<Object>> columnProjection) {
        snippet.ColumnProjection = columnProjection;
    }
    public void appendColumnProjection(List<Object> columnProjection) {
        snippet.ColumnProjection.add(columnProjection);
    }
    public void setGroupBy(List<List<String>> groupBy) {
        snippet.GroupBy = groupBy;
    }
    public void appendGroupBy(List<String> groupBy) {
        snippet.GroupBy.add(groupBy);
    }
    public void setOrderBy(List<List<String>> orderBy) {
        snippet.OrderBy = orderBy;
    }
    public void appendOrderBy(List<String> orderBy) {
        snippet.OrderBy.add(orderBy);
    }
    public void setDistinct(boolean distinct) {
        snippet.Distinct = distinct;
    }
    public void setHaving(List<List<String>> having) {
        snippet.Having = having;
    }
    public void appendHaving(List<String> having) {
        snippet.Having.add(having);
    }
    public void setLeftValue(Object leftValue) {
        filter.LeftValue = leftValue;
    }
    public void setRightValue(Object rightValue) {
        filter.RightValue = rightValue;
    }
    public void setExtraValue(Object extraValue) {
        filter.ExtraValue = extraValue;
    }
    public void setOPERATOR(Object OPERATOR) {
        filter.OPERATOR = OPERATOR;
    }



    static class Snippet{
        @JsonProperty("queryID")
        private int QueryID;
        @JsonProperty("workID")
        private int WorkID;
        @JsonProperty("tableName")
        private String TableName;
        @JsonProperty("tableCol")
        private List<String> TableColumn;
        @JsonProperty("tableFilter")
        private List<Filter> TableFilter;
        @JsonProperty("tableOffset")
        private int TableOffset;
        @JsonProperty("tableOfflen")
        private int TableOfflen;
        @JsonProperty("tableDatatype")
        private int TableDatatype;
        @JsonProperty("blockList")
        private final List<String> BlockList = null;
        @JsonProperty("tableAlias")
        private final String TableAlias = IDGenerator.MakeSnippetUUID(this.QueryID,this.WorkID);
        @JsonProperty("columnAlias")
        private List<String> Alias;
        @JsonProperty("columnFiltering")
        private List<String> ColumnFiltering;
        @JsonProperty("columnProjection")
        private List<List<Object>> ColumnProjection;
        @JsonProperty("groupBy")
        private List<List<String>> GroupBy;
        @JsonProperty("orderBy")
        private List<List<String>> OrderBy;
        @JsonProperty("distinct")
        private boolean Distinct;
        @JsonProperty("having")
        private List<List<String>> Having;

        public int getQueryID() {
            return QueryID;
        }

        public void setQueryID(int queryID) {
            QueryID = queryID;
        }

        public int getWorkID() {
            return WorkID;
        }

        public void setWorkID(int workID) {
            WorkID = workID;
        }

        public String getTableName() {
            return TableName;
        }

        public void setTableName(String tableName) {
            TableName = tableName;
        }

        public List<String> getTableColumn() {
            return TableColumn;
        }

        public void setTableColumn(List<String> tableColumn) {
            TableColumn = tableColumn;
        }

        public List<Filter> getTableFilter() {
            return TableFilter;
        }

        public void setTableFilter(List<Filter> tableFilter) {
            TableFilter = tableFilter;
        }

        public int getTableOffset() {
            return TableOffset;
        }

        public void setTableOffset(int tableOffset) {
            TableOffset = tableOffset;
        }

        public int getTableOfflen() {
            return TableOfflen;
        }

        public void setTableOfflen(int tableOfflen) {
            TableOfflen = tableOfflen;
        }

        public int getTableDatatype() {
            return TableDatatype;
        }

        public void setTableDatatype(int tableDatatype) {
            TableDatatype = tableDatatype;
        }

        public List<String> getBlockList() {
            return BlockList;
        }

        public String getTableAlias() {
            return TableAlias;
        }

        public List<String> getAlias() {
            return Alias;
        }

        public void setAlias(List<String> alias) {
            Alias = alias;
        }

        public List<String> getColumnFiltering() {
            return ColumnFiltering;
        }

        public void setColumnFiltering(List<String> columnFiltering) {
            ColumnFiltering = columnFiltering;
        }

        public List<List<Object>> getColumnProjection() {
            return ColumnProjection;
        }

        public void setColumnProjection(List<List<Object>> columnProjection) {
            ColumnProjection = columnProjection;
        }

        public List<List<String>> getGroupBy() {
            return GroupBy;
        }

        public void setGroupBy(List<List<String>> groupBy) {
            GroupBy = groupBy;
        }

        public List<List<String>> getOrderBy() {
            return OrderBy;
        }

        public void setOrderBy(List<List<String>> orderBy) {
            OrderBy = orderBy;
        }

        public boolean isDistinct() {
            return Distinct;
        }

        public void setDistinct(boolean distinct) {
            Distinct = distinct;
        }

        public List<List<String>> getHaving() {
            return Having;
        }

        public void setHaving(List<List<String>> having) {
            Having = having;
        }

        private static class Filter{
            @JsonProperty("LV")
            private Object LeftValue;
            @JsonProperty("RV")
            private Object RightValue;
            @JsonProperty("extra")
            private Object ExtraValue;
            @JsonProperty("OP")
            private Object OPERATOR;

            public Object getLeftValue() {
                return LeftValue;
            }

            public void setLeftValue(Object leftValue) {
                LeftValue = leftValue;
            }

            public Object getRightValue() {
                return RightValue;
            }

            public void setRightValue(Object rightValue) {
                RightValue = rightValue;
            }

            public Object getExtraValue() {
                return ExtraValue;
            }

            public void setExtraValue(Object extraValue) {
                ExtraValue = extraValue;
            }

            public Object getOPERATOR() {
                return OPERATOR;
            }

            public void setOPERATOR(Object OPERATOR) {
                this.OPERATOR = OPERATOR;
            }
        }


    }
}
