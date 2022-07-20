package keti.opencsd.snippet;

import keti.opencsd.config.IDGenerator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.json.JSONObject;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SnippetManager {
    protected JSONObject json;




    class Snippet{
        @JsonProperty("queryID")
        private int QueryID;
        @JsonProperty("workID")
        private int WorkID;
        @JsonProperty("tableName")
        private String TableName;
        @JsonProperty("tableCol")
        private String[] TableColumn;
        @JsonProperty("tableFilter")
        private String[] TableFilter;
        @JsonProperty("tableOffset")
        private int TableOffset;
        @JsonProperty("tableOfflen")
        private int TableOfflen;
        @JsonProperty("tableDatatype")
        private int TableDatatype;
        @JsonProperty("blockList")
        private final String[] BlockList = null;
        @JsonProperty("tableAlias")
        private final String TableAlias = IDGenerator.MakeSnippetUUID(this.QueryID,this.WorkID);
        @JsonProperty("columnAlias")
        private String[] Alias;
        @JsonProperty("columnFiltering")
        private String[] ColumnFiltering;
        @JsonProperty("columnProjection")
        private String[][] ColumnProjection;
        @JsonProperty("groupBy")
        private String[][] GroupBy;
        @JsonProperty("orderBy")
        private String[][] OrderBy;
        @JsonProperty("distinct")
        private boolean Distinct;
        @JsonProperty("having")
        private String[][] Having;

        private class Filter{
            @JsonProperty("LV")
            private Object LeftValue;
            @JsonProperty("RV")
            private Object RightValue;
            @JsonProperty("extra")
            private Object ExtraValue;
            @JsonProperty("OP")
            private Object OPERATOR;
        }

    }
}
