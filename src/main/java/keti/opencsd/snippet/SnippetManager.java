package keti.opencsd.snippet;

import org.json.JSONObject;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SnippetManager {
    protected JSONObject json;




    class Snippet{
        private int QueryID;
        private int WorkID;
        private String TableName;
        private String[] TableColumn;
        private String[] TableFilter;
        private String TableOffset;
        private String TableOfflen;
        private String TableDatatype;
        private String BlockList;
        private String TableAlias;
        private String Alias;
        private String Expr;
        private String ColumnFiltering;
        private String ColumnProjection;
        private String GroupBy;
        private String OrderBy;
        private String Distinct;
        private class Filter{
            private Object LeftValue;
            private Object RightValue;
            private Object ExtraValue;

        }

    }
}
