// $ANTLR 3.3 Nov 30, 2010 12:45:30 D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g 2014-04-10 16:42:28

package com.ogm.persistance.sql.antlr;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SQLGrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SELECT", "DISTINCT", "INSERT", "VALUES", "UPDATE", "DELETE", "ASTERISK", "FROM", "WHERE", "IDENT", "IS", "NOT", "NULL", "IN", "OPEN", "CLOSE", "AND", "OR", "OUTER", "StringLiteral", "SYSDATE", "COUNT", "MAX", "MIN", "SUM", "AVG", "LIKE", "TO_DATE", "TO_CHAR", "TRUNC", "BETWEEN", "DOT", "EQUAL", "LT", "GT", "LTGT", "SET", "QUESTION", "INTCONS", "COMMA", "ORDER_BY", "ASC", "DESC", "GROUP_BY", "HAVING", "SCHEMA", "ATTRIBUTTE_ACCESS", "Letter", "JavaIDDigit", "NEWLINE", "WS"
    };
    public static final int EOF=-1;
    public static final int SELECT=4;
    public static final int DISTINCT=5;
    public static final int INSERT=6;
    public static final int VALUES=7;
    public static final int UPDATE=8;
    public static final int DELETE=9;
    public static final int ASTERISK=10;
    public static final int FROM=11;
    public static final int WHERE=12;
    public static final int IDENT=13;
    public static final int IS=14;
    public static final int NOT=15;
    public static final int NULL=16;
    public static final int IN=17;
    public static final int OPEN=18;
    public static final int CLOSE=19;
    public static final int AND=20;
    public static final int OR=21;
    public static final int OUTER=22;
    public static final int StringLiteral=23;
    public static final int SYSDATE=24;
    public static final int COUNT=25;
    public static final int MAX=26;
    public static final int MIN=27;
    public static final int SUM=28;
    public static final int AVG=29;
    public static final int LIKE=30;
    public static final int TO_DATE=31;
    public static final int TO_CHAR=32;
    public static final int TRUNC=33;
    public static final int BETWEEN=34;
    public static final int DOT=35;
    public static final int EQUAL=36;
    public static final int LT=37;
    public static final int GT=38;
    public static final int LTGT=39;
    public static final int SET=40;
    public static final int QUESTION=41;
    public static final int INTCONS=42;
    public static final int COMMA=43;
    public static final int ORDER_BY=44;
    public static final int ASC=45;
    public static final int DESC=46;
    public static final int GROUP_BY=47;
    public static final int HAVING=48;
    public static final int SCHEMA=49;
    public static final int ATTRIBUTTE_ACCESS=50;
    public static final int Letter=51;
    public static final int JavaIDDigit=52;
    public static final int NEWLINE=53;
    public static final int WS=54;

    // delegates
    // delegators


        public SQLGrammarParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SQLGrammarParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return SQLGrammarParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g"; }



    	private GrammarUtil grammarUtil = new GrammarUtil();
    	public GrammarUtil getGrammarUtil(){
    		return grammarUtil;
    	}
    	protected void out(String s) {
    		grammarUtil.out(s);
    	}
    	
    	protected void out(int tokenIndex) {
    		grammarUtil.out(tokenNames[tokenIndex]);
    	}
    	
    	
    	protected void out(org.antlr.runtime.Token token) {
    		grammarUtil.out(token.getText());
    	}	
    	protected void tableName(org.antlr.runtime.Token token){
    		grammarUtil.tableName(token.getText());
    	}
    	
    	protected void fieldName(org.antlr.runtime.Token token){
    		grammarUtil.fieldName(token.getText());
    	}

    	protected void attributeAccess(org.antlr.runtime.Token token){
    		grammarUtil.attributeAccess(token.getText());
    	}	

    	protected void putSchema(){
    		grammarUtil.schema();
    	}
    	
    	protected void putAlias(org.antlr.runtime.Token token){
    		grammarUtil.alias(token.getText());
    	}	



    // $ANTLR start "prog"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:54:1: prog : ( query )+ ;
    public final void prog() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:54:5: ( ( query )+ )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:54:9: ( query )+
            {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:54:9: ( query )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==SELECT||LA1_0==INSERT||LA1_0==UPDATE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:54:9: query
            	    {
            	    pushFollow(FOLLOW_query_in_prog39);
            	    query();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "prog"


    // $ANTLR start "query"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:56:1: query : ( selectStatement | insertStatement | updateSatement );
    public final void query() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:56:6: ( selectStatement | insertStatement | updateSatement )
            int alt2=3;
            switch ( input.LA(1) ) {
            case SELECT:
                {
                alt2=1;
                }
                break;
            case INSERT:
                {
                alt2=2;
                }
                break;
            case UPDATE:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:56:10: selectStatement
                    {
                    pushFollow(FOLLOW_selectStatement_in_query66);
                    selectStatement();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:57:10: insertStatement
                    {
                    pushFollow(FOLLOW_insertStatement_in_query77);
                    insertStatement();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:58:8: updateSatement
                    {
                    pushFollow(FOLLOW_updateSatement_in_query86);
                    updateSatement();

                    state._fsp--;


                    }
                    break;

            }
        }
             finally {
        }
        return ;
    }
    // $ANTLR end "query"


    // $ANTLR start "selectStatement"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:61:1: selectStatement : SELECT ( DISTINCT )? selectFields from ( where )? ( groupby )? ( orderby )? ( having )? ;
    public final void selectStatement() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:62:2: ( SELECT ( DISTINCT )? selectFields from ( where )? ( groupby )? ( orderby )? ( having )? )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:62:4: SELECT ( DISTINCT )? selectFields from ( where )? ( groupby )? ( orderby )? ( having )?
            {
            match(input,SELECT,FOLLOW_SELECT_in_selectStatement100); 
             out("select "); 
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:63:4: ( DISTINCT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==DISTINCT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:63:5: DISTINCT
                    {
                    match(input,DISTINCT,FOLLOW_DISTINCT_in_selectStatement109); 
                    out(" distinct ");

                    }
                    break;

            }

            pushFollow(FOLLOW_selectFields_in_selectStatement119);
            selectFields();

            state._fsp--;

            pushFollow(FOLLOW_from_in_selectStatement123);
            from();

            state._fsp--;

            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:66:3: ( where )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==WHERE) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:66:4: where
                    {
                    pushFollow(FOLLOW_where_in_selectStatement129);
                    where();

                    state._fsp--;


                    }
                    break;

            }

            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:67:3: ( groupby )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==GROUP_BY) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:67:4: groupby
                    {
                    pushFollow(FOLLOW_groupby_in_selectStatement136);
                    groupby();

                    state._fsp--;


                    }
                    break;

            }

            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:68:3: ( orderby )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==ORDER_BY) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:68:4: orderby
                    {
                    pushFollow(FOLLOW_orderby_in_selectStatement143);
                    orderby();

                    state._fsp--;


                    }
                    break;

            }

            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:69:3: ( having )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==HAVING) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:69:4: having
                    {
                    pushFollow(FOLLOW_having_in_selectStatement150);
                    having();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "selectStatement"


    // $ANTLR start "insertStatement"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:73:1: insertStatement : INSERT tablename open fieldname ( comma fieldname )* close VALUES questions ;
    public final void insertStatement() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:74:2: ( INSERT tablename open fieldname ( comma fieldname )* close VALUES questions )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:74:4: INSERT tablename open fieldname ( comma fieldname )* close VALUES questions
            {
            match(input,INSERT,FOLLOW_INSERT_in_insertStatement167); 
             out("insert into "); 
            pushFollow(FOLLOW_tablename_in_insertStatement174);
            tablename();

            state._fsp--;

            pushFollow(FOLLOW_open_in_insertStatement176);
            open();

            state._fsp--;

            pushFollow(FOLLOW_fieldname_in_insertStatement178);
            fieldname();

            state._fsp--;

            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:75:28: ( comma fieldname )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==COMMA) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:75:29: comma fieldname
            	    {
            	    pushFollow(FOLLOW_comma_in_insertStatement181);
            	    comma();

            	    state._fsp--;

            	    pushFollow(FOLLOW_fieldname_in_insertStatement183);
            	    fieldname();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            pushFollow(FOLLOW_close_in_insertStatement187);
            close();

            state._fsp--;

            match(input,VALUES,FOLLOW_VALUES_in_insertStatement192); 
             out(" values "); 
            pushFollow(FOLLOW_questions_in_insertStatement199);
            questions();

            state._fsp--;


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "insertStatement"


    // $ANTLR start "updateSatement"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:80:1: updateSatement : UPDATE tablename sets ( where )? ;
    public final void updateSatement() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:81:2: ( UPDATE tablename sets ( where )? )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:81:4: UPDATE tablename sets ( where )?
            {
            match(input,UPDATE,FOLLOW_UPDATE_in_updateSatement213); 
             out("update "); 
            pushFollow(FOLLOW_tablename_in_updateSatement220);
            tablename();

            state._fsp--;

            pushFollow(FOLLOW_sets_in_updateSatement224);
            sets();

            state._fsp--;

            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:84:3: ( where )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==WHERE) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:84:4: where
                    {
                    pushFollow(FOLLOW_where_in_updateSatement229);
                    where();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "updateSatement"


    // $ANTLR start "deleteSatement"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:87:1: deleteSatement : DELETE tablename ( where )? ;
    public final void deleteSatement() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:88:2: ( DELETE tablename ( where )? )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:88:4: DELETE tablename ( where )?
            {
            match(input,DELETE,FOLLOW_DELETE_in_deleteSatement242); 
             out("delete from "); 
            pushFollow(FOLLOW_tablename_in_deleteSatement249);
            tablename();

            state._fsp--;

            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:90:3: ( where )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==WHERE) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:90:4: where
                    {
                    pushFollow(FOLLOW_where_in_deleteSatement254);
                    where();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "deleteSatement"


    // $ANTLR start "selectFields"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:93:1: selectFields : selectFieldDef ( comma selectFieldDef )* ;
    public final void selectFields() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:94:2: ( selectFieldDef ( comma selectFieldDef )* )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:95:3: selectFieldDef ( comma selectFieldDef )*
            {
            pushFollow(FOLLOW_selectFieldDef_in_selectFields273);
            selectFieldDef();

            state._fsp--;

            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:95:18: ( comma selectFieldDef )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==COMMA) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:95:19: comma selectFieldDef
            	    {
            	    pushFollow(FOLLOW_comma_in_selectFields276);
            	    comma();

            	    state._fsp--;

            	    pushFollow(FOLLOW_selectFieldDef_in_selectFields278);
            	    selectFieldDef();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "selectFields"


    // $ANTLR start "selectFieldDef"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:101:1: selectFieldDef : ( ( tablename dot )? ( fieldname | ASTERISK ) ( alias )* | function ( comma selectFieldDef )* );
    public final void selectFieldDef() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:102:2: ( ( tablename dot )? ( fieldname | ASTERISK ) ( alias )* | function ( comma selectFieldDef )* )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==ASTERISK||LA16_0==IDENT||LA16_0==SCHEMA) ) {
                alt16=1;
            }
            else if ( ((LA16_0>=COUNT && LA16_0<=TRUNC)) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:102:5: ( tablename dot )? ( fieldname | ASTERISK ) ( alias )*
                    {
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:102:5: ( tablename dot )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==SCHEMA) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==IDENT) ) {
                        int LA12_2 = input.LA(2);

                        if ( (LA12_2==DOT) ) {
                            alt12=1;
                        }
                    }
                    switch (alt12) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:102:6: tablename dot
                            {
                            pushFollow(FOLLOW_tablename_in_selectFieldDef313);
                            tablename();

                            state._fsp--;

                            pushFollow(FOLLOW_dot_in_selectFieldDef315);
                            dot();

                            state._fsp--;


                            }
                            break;

                    }

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:102:22: ( fieldname | ASTERISK )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==IDENT) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==ASTERISK) ) {
                        alt13=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:102:23: fieldname
                            {
                            pushFollow(FOLLOW_fieldname_in_selectFieldDef320);
                            fieldname();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:102:33: ASTERISK
                            {
                            match(input,ASTERISK,FOLLOW_ASTERISK_in_selectFieldDef322); 
                             out("*"); 

                            }
                            break;

                    }

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:102:57: ( alias )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==IDENT) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:102:58: alias
                    	    {
                    	    pushFollow(FOLLOW_alias_in_selectFieldDef328);
                    	    alias();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:103:5: function ( comma selectFieldDef )*
                    {
                    pushFollow(FOLLOW_function_in_selectFieldDef336);
                    function();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:103:14: ( comma selectFieldDef )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==COMMA) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:103:16: comma selectFieldDef
                    	    {
                    	    pushFollow(FOLLOW_comma_in_selectFieldDef340);
                    	    comma();

                    	    state._fsp--;

                    	    pushFollow(FOLLOW_selectFieldDef_in_selectFieldDef342);
                    	    selectFieldDef();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }
        }
             finally {
        }
        return ;
    }
    // $ANTLR end "selectFieldDef"


    // $ANTLR start "from"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:106:1: from : ( FROM tablename ( comma tablename )* | FROM open selectStatement close );
    public final void from() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:107:2: ( FROM tablename ( comma tablename )* | FROM open selectStatement close )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FROM) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==IDENT||LA18_1==SCHEMA) ) {
                    alt18=1;
                }
                else if ( (LA18_1==OPEN) ) {
                    alt18=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:107:4: FROM tablename ( comma tablename )*
                    {
                     out(" from "); 
                    match(input,FROM,FOLLOW_FROM_in_from359); 
                    pushFollow(FOLLOW_tablename_in_from361);
                    tablename();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:107:38: ( comma tablename )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==COMMA) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:107:40: comma tablename
                    	    {
                    	    pushFollow(FOLLOW_comma_in_from365);
                    	    comma();

                    	    state._fsp--;

                    	    pushFollow(FOLLOW_tablename_in_from367);
                    	    tablename();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:108:4: FROM open selectStatement close
                    {
                     out(" from "); 
                    match(input,FROM,FOLLOW_FROM_in_from376); 
                    pushFollow(FOLLOW_open_in_from378);
                    open();

                    state._fsp--;

                    pushFollow(FOLLOW_selectStatement_in_from380);
                    selectStatement();

                    state._fsp--;

                    pushFollow(FOLLOW_close_in_from382);
                    close();

                    state._fsp--;


                    }
                    break;

            }
        }
             finally {
        }
        return ;
    }
    // $ANTLR end "from"


    // $ANTLR start "where"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:111:1: where : WHERE logicExpresions ;
    public final void where() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:112:1: ( WHERE logicExpresions )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:112:3: WHERE logicExpresions
            {
             out(" where "); 
            match(input,WHERE,FOLLOW_WHERE_in_where396); 
            pushFollow(FOLLOW_logicExpresions_in_where398);
            logicExpresions();

            state._fsp--;


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "where"


    // $ANTLR start "alias"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:114:1: alias : (a= IDENT ) ;
    public final void alias() throws RecognitionException {
        Token a=null;

        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:115:2: ( (a= IDENT ) )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:115:5: (a= IDENT )
            {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:115:5: (a= IDENT )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:115:6: a= IDENT
            {
            a=(Token)match(input,IDENT,FOLLOW_IDENT_in_alias413); 
            putAlias(a);

            }


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "alias"


    // $ANTLR start "logicExpresions"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:117:1: logicExpresions : logicExpresion ( operator logicExpresion )* ;
    public final void logicExpresions() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:118:2: ( logicExpresion ( operator logicExpresion )* )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:118:5: logicExpresion ( operator logicExpresion )*
            {
            pushFollow(FOLLOW_logicExpresion_in_logicExpresions427);
            logicExpresion();

            state._fsp--;

            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:118:20: ( operator logicExpresion )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=AND && LA19_0<=OR)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:118:21: operator logicExpresion
            	    {
            	    pushFollow(FOLLOW_operator_in_logicExpresions430);
            	    operator();

            	    state._fsp--;

            	    pushFollow(FOLLOW_logicExpresion_in_logicExpresions432);
            	    logicExpresion();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "logicExpresions"


    // $ANTLR start "logicExpresion"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:120:1: logicExpresion : ( detailExpresion | detailExpresion ( expression )? detailExpresion | between | detailExpresion IS ( NOT )? NULL | detailExpresion IN open selectStatement close | OPEN logicExpresions CLOSE );
    public final void logicExpresion() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:121:2: ( detailExpresion | detailExpresion ( expression )? detailExpresion | between | detailExpresion IS ( NOT )? NULL | detailExpresion IN open selectStatement close | OPEN logicExpresions CLOSE )
            int alt22=6;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:121:4: detailExpresion
                    {
                    pushFollow(FOLLOW_detailExpresion_in_logicExpresion445);
                    detailExpresion();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:122:4: detailExpresion ( expression )? detailExpresion
                    {
                    pushFollow(FOLLOW_detailExpresion_in_logicExpresion452);
                    detailExpresion();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:122:20: ( expression )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( ((LA20_0>=AND && LA20_0<=OR)||(LA20_0>=EQUAL && LA20_0<=LTGT)) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:122:21: expression
                            {
                            pushFollow(FOLLOW_expression_in_logicExpresion455);
                            expression();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_detailExpresion_in_logicExpresion459);
                    detailExpresion();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:123:5: between
                    {
                    pushFollow(FOLLOW_between_in_logicExpresion465);
                    between();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:124:5: detailExpresion IS ( NOT )? NULL
                    {
                    pushFollow(FOLLOW_detailExpresion_in_logicExpresion471);
                    detailExpresion();

                    state._fsp--;

                    match(input,IS,FOLLOW_IS_in_logicExpresion473); 
                    out(" is ");
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:124:39: ( NOT )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==NOT) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:124:40: NOT
                            {
                            match(input,NOT,FOLLOW_NOT_in_logicExpresion478); 
                            out(" not ");

                            }
                            break;

                    }

                    match(input,NULL,FOLLOW_NULL_in_logicExpresion485); 
                    out(" null ");

                    }
                    break;
                case 5 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:125:5: detailExpresion IN open selectStatement close
                    {
                    pushFollow(FOLLOW_detailExpresion_in_logicExpresion493);
                    detailExpresion();

                    state._fsp--;

                    match(input,IN,FOLLOW_IN_in_logicExpresion495); 
                    out(" in "); 
                    pushFollow(FOLLOW_open_in_logicExpresion499);
                    open();

                    state._fsp--;

                    pushFollow(FOLLOW_selectStatement_in_logicExpresion501);
                    selectStatement();

                    state._fsp--;

                    pushFollow(FOLLOW_close_in_logicExpresion503);
                    close();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:126:5: OPEN logicExpresions CLOSE
                    {
                    match(input,OPEN,FOLLOW_OPEN_in_logicExpresion509); 
                    out(" ( "); 
                    pushFollow(FOLLOW_logicExpresions_in_logicExpresion513);
                    logicExpresions();

                    state._fsp--;

                    match(input,CLOSE,FOLLOW_CLOSE_in_logicExpresion515); 
                    out(" ) "); 

                    }
                    break;

            }
        }
             finally {
        }
        return ;
    }
    // $ANTLR end "logicExpresion"


    // $ANTLR start "operator"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:128:1: operator : ( AND | OR );
    public final void operator() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:129:2: ( AND | OR )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==AND) ) {
                alt23=1;
            }
            else if ( (LA23_0==OR) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:129:4: AND
                    {
                    match(input,AND,FOLLOW_AND_in_operator527); 
                    out(" and ");

                    }
                    break;
                case 2 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:130:4: OR
                    {
                    match(input,OR,FOLLOW_OR_in_operator534); 
                    out(" or ");

                    }
                    break;

            }
        }
             finally {
        }
        return ;
    }
    // $ANTLR end "operator"


    // $ANTLR start "detailExpresion"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:140:1: detailExpresion : ( question | ( tablename dot )? fieldname ( OUTER )? | sysdate | function | attributeAccess | intcons | (l= StringLiteral ) );
    public final void detailExpresion() throws RecognitionException {
        Token l=null;

        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:141:2: ( question | ( tablename dot )? fieldname ( OUTER )? | sysdate | function | attributeAccess | intcons | (l= StringLiteral ) )
            int alt26=7;
            switch ( input.LA(1) ) {
            case QUESTION:
                {
                alt26=1;
                }
                break;
            case IDENT:
            case SCHEMA:
                {
                alt26=2;
                }
                break;
            case SYSDATE:
                {
                alt26=3;
                }
                break;
            case COUNT:
            case MAX:
            case MIN:
            case SUM:
            case AVG:
            case LIKE:
            case TO_DATE:
            case TO_CHAR:
            case TRUNC:
                {
                alt26=4;
                }
                break;
            case ATTRIBUTTE_ACCESS:
                {
                alt26=5;
                }
                break;
            case INTCONS:
                {
                alt26=6;
                }
                break;
            case StringLiteral:
                {
                alt26=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:141:4: question
                    {
                    pushFollow(FOLLOW_question_in_detailExpresion557);
                    question();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:142:4: ( tablename dot )? fieldname ( OUTER )?
                    {
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:142:4: ( tablename dot )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==SCHEMA) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==IDENT) ) {
                        int LA24_2 = input.LA(2);

                        if ( (LA24_2==DOT) ) {
                            alt24=1;
                        }
                    }
                    switch (alt24) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:142:5: tablename dot
                            {
                            pushFollow(FOLLOW_tablename_in_detailExpresion563);
                            tablename();

                            state._fsp--;

                            pushFollow(FOLLOW_dot_in_detailExpresion565);
                            dot();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_fieldname_in_detailExpresion569);
                    fieldname();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:142:31: ( OUTER )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==OUTER) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:142:32: OUTER
                            {
                            match(input,OUTER,FOLLOW_OUTER_in_detailExpresion572); 
                            out(" (+) ");

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:143:4: sysdate
                    {
                    pushFollow(FOLLOW_sysdate_in_detailExpresion582);
                    sysdate();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:144:4: function
                    {
                    pushFollow(FOLLOW_function_in_detailExpresion587);
                    function();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:145:4: attributeAccess
                    {
                    pushFollow(FOLLOW_attributeAccess_in_detailExpresion592);
                    attributeAccess();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:146:4: intcons
                    {
                    pushFollow(FOLLOW_intcons_in_detailExpresion597);
                    intcons();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:147:4: (l= StringLiteral )
                    {
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:147:4: (l= StringLiteral )
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:147:5: l= StringLiteral
                    {
                    l=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_detailExpresion605); 
                    out(l);

                    }


                    }
                    break;

            }
        }
             finally {
        }
        return ;
    }
    // $ANTLR end "detailExpresion"


    // $ANTLR start "sysdate"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:149:1: sysdate : SYSDATE ;
    public final void sysdate() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:149:9: ( SYSDATE )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:149:10: SYSDATE
            {
            match(input,SYSDATE,FOLLOW_SYSDATE_in_sysdate615); 
            out(" sysdate ");

            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "sysdate"


    // $ANTLR start "function"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:150:1: function : ( COUNT open ( ( tablename dot )? fieldname | ASTERISK ) close ( alias )? | MAX open ( tablename dot )? fieldname close ( alias )? | MIN open ( tablename dot )? fieldname close ( alias )? | SUM open ( tablename dot )? fieldname close ( alias )? | AVG open ( tablename dot )? fieldname close ( alias )? | LIKE open (l= StringLiteral | question ) close ( alias )? | TO_DATE open ( ( tablename dot )? fieldname | (l= StringLiteral ) ) comma (l= StringLiteral ) close ( alias )? | TO_CHAR open ( ( tablename dot )? fieldname | (l= StringLiteral ) ) comma (l= StringLiteral ) close ( alias )? | TRUNC open ( ( tablename dot )? fieldname | (l= StringLiteral ) ) comma (l= StringLiteral ) close ( alias )? );
    public final void function() throws RecognitionException {
        Token l=null;

        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:151:2: ( COUNT open ( ( tablename dot )? fieldname | ASTERISK ) close ( alias )? | MAX open ( tablename dot )? fieldname close ( alias )? | MIN open ( tablename dot )? fieldname close ( alias )? | SUM open ( tablename dot )? fieldname close ( alias )? | AVG open ( tablename dot )? fieldname close ( alias )? | LIKE open (l= StringLiteral | question ) close ( alias )? | TO_DATE open ( ( tablename dot )? fieldname | (l= StringLiteral ) ) comma (l= StringLiteral ) close ( alias )? | TO_CHAR open ( ( tablename dot )? fieldname | (l= StringLiteral ) ) comma (l= StringLiteral ) close ( alias )? | TRUNC open ( ( tablename dot )? fieldname | (l= StringLiteral ) ) comma (l= StringLiteral ) close ( alias )? )
            int alt49=9;
            switch ( input.LA(1) ) {
            case COUNT:
                {
                alt49=1;
                }
                break;
            case MAX:
                {
                alt49=2;
                }
                break;
            case MIN:
                {
                alt49=3;
                }
                break;
            case SUM:
                {
                alt49=4;
                }
                break;
            case AVG:
                {
                alt49=5;
                }
                break;
            case LIKE:
                {
                alt49=6;
                }
                break;
            case TO_DATE:
                {
                alt49=7;
                }
                break;
            case TO_CHAR:
                {
                alt49=8;
                }
                break;
            case TRUNC:
                {
                alt49=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:151:4: COUNT open ( ( tablename dot )? fieldname | ASTERISK ) close ( alias )?
                    {
                    match(input,COUNT,FOLLOW_COUNT_in_function628); 
                    out(" count");
                    pushFollow(FOLLOW_open_in_function632);
                    open();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:152:4: ( ( tablename dot )? fieldname | ASTERISK )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==IDENT||LA28_0==SCHEMA) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==ASTERISK) ) {
                        alt28=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:152:6: ( tablename dot )? fieldname
                            {
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:152:6: ( tablename dot )?
                            int alt27=2;
                            int LA27_0 = input.LA(1);

                            if ( (LA27_0==SCHEMA) ) {
                                alt27=1;
                            }
                            else if ( (LA27_0==IDENT) ) {
                                int LA27_2 = input.LA(2);

                                if ( (LA27_2==DOT) ) {
                                    alt27=1;
                                }
                            }
                            switch (alt27) {
                                case 1 :
                                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:152:7: tablename dot
                                    {
                                    pushFollow(FOLLOW_tablename_in_function641);
                                    tablename();

                                    state._fsp--;

                                    pushFollow(FOLLOW_dot_in_function643);
                                    dot();

                                    state._fsp--;


                                    }
                                    break;

                            }

                            pushFollow(FOLLOW_fieldname_in_function647);
                            fieldname();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:152:36: ASTERISK
                            {
                            match(input,ASTERISK,FOLLOW_ASTERISK_in_function652); 
                            out("*");

                            }
                            break;

                    }

                    pushFollow(FOLLOW_close_in_function662);
                    close();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:153:12: ( alias )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==IDENT) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:153:13: alias
                            {
                            pushFollow(FOLLOW_alias_in_function665);
                            alias();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:154:4: MAX open ( tablename dot )? fieldname close ( alias )?
                    {
                    match(input,MAX,FOLLOW_MAX_in_function672); 
                    out(" max");
                    pushFollow(FOLLOW_open_in_function676);
                    open();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:154:28: ( tablename dot )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==SCHEMA) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==IDENT) ) {
                        int LA30_2 = input.LA(2);

                        if ( (LA30_2==DOT) ) {
                            alt30=1;
                        }
                    }
                    switch (alt30) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:154:29: tablename dot
                            {
                            pushFollow(FOLLOW_tablename_in_function679);
                            tablename();

                            state._fsp--;

                            pushFollow(FOLLOW_dot_in_function681);
                            dot();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_fieldname_in_function685);
                    fieldname();

                    state._fsp--;

                    pushFollow(FOLLOW_close_in_function687);
                    close();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:154:61: ( alias )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==IDENT) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:154:62: alias
                            {
                            pushFollow(FOLLOW_alias_in_function690);
                            alias();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:155:4: MIN open ( tablename dot )? fieldname close ( alias )?
                    {
                    match(input,MIN,FOLLOW_MIN_in_function697); 
                    out(" min");
                    pushFollow(FOLLOW_open_in_function701);
                    open();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:155:28: ( tablename dot )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==SCHEMA) ) {
                        alt32=1;
                    }
                    else if ( (LA32_0==IDENT) ) {
                        int LA32_2 = input.LA(2);

                        if ( (LA32_2==DOT) ) {
                            alt32=1;
                        }
                    }
                    switch (alt32) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:155:29: tablename dot
                            {
                            pushFollow(FOLLOW_tablename_in_function704);
                            tablename();

                            state._fsp--;

                            pushFollow(FOLLOW_dot_in_function706);
                            dot();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_fieldname_in_function710);
                    fieldname();

                    state._fsp--;

                    pushFollow(FOLLOW_close_in_function712);
                    close();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:155:61: ( alias )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==IDENT) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:155:62: alias
                            {
                            pushFollow(FOLLOW_alias_in_function715);
                            alias();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:156:4: SUM open ( tablename dot )? fieldname close ( alias )?
                    {
                    match(input,SUM,FOLLOW_SUM_in_function722); 
                    out(" sum");
                    pushFollow(FOLLOW_open_in_function726);
                    open();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:156:28: ( tablename dot )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==SCHEMA) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==IDENT) ) {
                        int LA34_2 = input.LA(2);

                        if ( (LA34_2==DOT) ) {
                            alt34=1;
                        }
                    }
                    switch (alt34) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:156:29: tablename dot
                            {
                            pushFollow(FOLLOW_tablename_in_function729);
                            tablename();

                            state._fsp--;

                            pushFollow(FOLLOW_dot_in_function731);
                            dot();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_fieldname_in_function735);
                    fieldname();

                    state._fsp--;

                    pushFollow(FOLLOW_close_in_function737);
                    close();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:156:61: ( alias )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==IDENT) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:156:62: alias
                            {
                            pushFollow(FOLLOW_alias_in_function740);
                            alias();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 5 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:157:4: AVG open ( tablename dot )? fieldname close ( alias )?
                    {
                    match(input,AVG,FOLLOW_AVG_in_function747); 
                    out(" avg");
                    pushFollow(FOLLOW_open_in_function751);
                    open();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:157:28: ( tablename dot )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==SCHEMA) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==IDENT) ) {
                        int LA36_2 = input.LA(2);

                        if ( (LA36_2==DOT) ) {
                            alt36=1;
                        }
                    }
                    switch (alt36) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:157:29: tablename dot
                            {
                            pushFollow(FOLLOW_tablename_in_function754);
                            tablename();

                            state._fsp--;

                            pushFollow(FOLLOW_dot_in_function756);
                            dot();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_fieldname_in_function760);
                    fieldname();

                    state._fsp--;

                    pushFollow(FOLLOW_close_in_function762);
                    close();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:157:61: ( alias )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==IDENT) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:157:62: alias
                            {
                            pushFollow(FOLLOW_alias_in_function765);
                            alias();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:158:4: LIKE open (l= StringLiteral | question ) close ( alias )?
                    {
                    match(input,LIKE,FOLLOW_LIKE_in_function773); 
                    out(" like");
                    pushFollow(FOLLOW_open_in_function777);
                    open();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:158:30: (l= StringLiteral | question )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==StringLiteral) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==QUESTION) ) {
                        alt38=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:158:31: l= StringLiteral
                            {
                            l=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_function782); 
                            out(l);

                            }
                            break;
                        case 2 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:158:58: question
                            {
                            pushFollow(FOLLOW_question_in_function787);
                            question();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_close_in_function791);
                    close();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:158:75: ( alias )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==IDENT) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:158:76: alias
                            {
                            pushFollow(FOLLOW_alias_in_function794);
                            alias();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 7 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:159:4: TO_DATE open ( ( tablename dot )? fieldname | (l= StringLiteral ) ) comma (l= StringLiteral ) close ( alias )?
                    {
                    match(input,TO_DATE,FOLLOW_TO_DATE_in_function801); 
                    out(" to_date");
                    pushFollow(FOLLOW_open_in_function805);
                    open();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:159:36: ( ( tablename dot )? fieldname | (l= StringLiteral ) )
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==IDENT||LA41_0==SCHEMA) ) {
                        alt41=1;
                    }
                    else if ( (LA41_0==StringLiteral) ) {
                        alt41=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 41, 0, input);

                        throw nvae;
                    }
                    switch (alt41) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:159:38: ( tablename dot )? fieldname
                            {
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:159:38: ( tablename dot )?
                            int alt40=2;
                            int LA40_0 = input.LA(1);

                            if ( (LA40_0==SCHEMA) ) {
                                alt40=1;
                            }
                            else if ( (LA40_0==IDENT) ) {
                                int LA40_2 = input.LA(2);

                                if ( (LA40_2==DOT) ) {
                                    alt40=1;
                                }
                            }
                            switch (alt40) {
                                case 1 :
                                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:159:39: tablename dot
                                    {
                                    pushFollow(FOLLOW_tablename_in_function810);
                                    tablename();

                                    state._fsp--;

                                    pushFollow(FOLLOW_dot_in_function812);
                                    dot();

                                    state._fsp--;


                                    }
                                    break;

                            }

                            pushFollow(FOLLOW_fieldname_in_function816);
                            fieldname();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:159:67: (l= StringLiteral )
                            {
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:159:67: (l= StringLiteral )
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:159:68: l= StringLiteral
                            {
                            l=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_function823); 
                            out(l);

                            }


                            }
                            break;

                    }

                    pushFollow(FOLLOW_comma_in_function833);
                    comma();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:160:12: (l= StringLiteral )
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:160:13: l= StringLiteral
                    {
                    l=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_function838); 
                    out(l);

                    }

                    pushFollow(FOLLOW_close_in_function842);
                    close();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:160:45: ( alias )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==IDENT) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:160:46: alias
                            {
                            pushFollow(FOLLOW_alias_in_function845);
                            alias();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 8 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:161:4: TO_CHAR open ( ( tablename dot )? fieldname | (l= StringLiteral ) ) comma (l= StringLiteral ) close ( alias )?
                    {
                    match(input,TO_CHAR,FOLLOW_TO_CHAR_in_function853); 
                    out(" to_char");
                    pushFollow(FOLLOW_open_in_function857);
                    open();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:161:36: ( ( tablename dot )? fieldname | (l= StringLiteral ) )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==IDENT||LA44_0==SCHEMA) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==StringLiteral) ) {
                        alt44=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:161:38: ( tablename dot )? fieldname
                            {
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:161:38: ( tablename dot )?
                            int alt43=2;
                            int LA43_0 = input.LA(1);

                            if ( (LA43_0==SCHEMA) ) {
                                alt43=1;
                            }
                            else if ( (LA43_0==IDENT) ) {
                                int LA43_2 = input.LA(2);

                                if ( (LA43_2==DOT) ) {
                                    alt43=1;
                                }
                            }
                            switch (alt43) {
                                case 1 :
                                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:161:39: tablename dot
                                    {
                                    pushFollow(FOLLOW_tablename_in_function862);
                                    tablename();

                                    state._fsp--;

                                    pushFollow(FOLLOW_dot_in_function864);
                                    dot();

                                    state._fsp--;


                                    }
                                    break;

                            }

                            pushFollow(FOLLOW_fieldname_in_function868);
                            fieldname();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:161:67: (l= StringLiteral )
                            {
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:161:67: (l= StringLiteral )
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:161:68: l= StringLiteral
                            {
                            l=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_function875); 
                            out(l);

                            }


                            }
                            break;

                    }

                    pushFollow(FOLLOW_comma_in_function885);
                    comma();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:162:12: (l= StringLiteral )
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:162:13: l= StringLiteral
                    {
                    l=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_function890); 
                    out(l);

                    }

                    pushFollow(FOLLOW_close_in_function894);
                    close();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:162:45: ( alias )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==IDENT) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:162:46: alias
                            {
                            pushFollow(FOLLOW_alias_in_function897);
                            alias();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 9 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:163:4: TRUNC open ( ( tablename dot )? fieldname | (l= StringLiteral ) ) comma (l= StringLiteral ) close ( alias )?
                    {
                    match(input,TRUNC,FOLLOW_TRUNC_in_function904); 
                    out(" trunc");
                    pushFollow(FOLLOW_open_in_function908);
                    open();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:163:32: ( ( tablename dot )? fieldname | (l= StringLiteral ) )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==IDENT||LA47_0==SCHEMA) ) {
                        alt47=1;
                    }
                    else if ( (LA47_0==StringLiteral) ) {
                        alt47=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 0, input);

                        throw nvae;
                    }
                    switch (alt47) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:163:34: ( tablename dot )? fieldname
                            {
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:163:34: ( tablename dot )?
                            int alt46=2;
                            int LA46_0 = input.LA(1);

                            if ( (LA46_0==SCHEMA) ) {
                                alt46=1;
                            }
                            else if ( (LA46_0==IDENT) ) {
                                int LA46_2 = input.LA(2);

                                if ( (LA46_2==DOT) ) {
                                    alt46=1;
                                }
                            }
                            switch (alt46) {
                                case 1 :
                                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:163:35: tablename dot
                                    {
                                    pushFollow(FOLLOW_tablename_in_function913);
                                    tablename();

                                    state._fsp--;

                                    pushFollow(FOLLOW_dot_in_function915);
                                    dot();

                                    state._fsp--;


                                    }
                                    break;

                            }

                            pushFollow(FOLLOW_fieldname_in_function919);
                            fieldname();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:163:63: (l= StringLiteral )
                            {
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:163:63: (l= StringLiteral )
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:163:64: l= StringLiteral
                            {
                            l=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_function926); 
                            out(l);

                            }


                            }
                            break;

                    }

                    pushFollow(FOLLOW_comma_in_function936);
                    comma();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:164:12: (l= StringLiteral )
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:164:13: l= StringLiteral
                    {
                    l=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_function941); 
                    out(l);

                    }

                    pushFollow(FOLLOW_close_in_function945);
                    close();

                    state._fsp--;

                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:164:45: ( alias )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==IDENT) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:164:46: alias
                            {
                            pushFollow(FOLLOW_alias_in_function948);
                            alias();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;

            }
        }
             finally {
        }
        return ;
    }
    // $ANTLR end "function"


    // $ANTLR start "between"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:166:1: between : ( ( tablename dot )? fieldname | sysdate ) BETWEEN detailExpresion AND detailExpresion ;
    public final void between() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:167:1: ( ( ( tablename dot )? fieldname | sysdate ) BETWEEN detailExpresion AND detailExpresion )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:167:3: ( ( tablename dot )? fieldname | sysdate ) BETWEEN detailExpresion AND detailExpresion
            {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:167:3: ( ( tablename dot )? fieldname | sysdate )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==IDENT||LA51_0==SCHEMA) ) {
                alt51=1;
            }
            else if ( (LA51_0==SYSDATE) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:167:4: ( tablename dot )? fieldname
                    {
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:167:4: ( tablename dot )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==SCHEMA) ) {
                        alt50=1;
                    }
                    else if ( (LA50_0==IDENT) ) {
                        int LA50_2 = input.LA(2);

                        if ( (LA50_2==DOT) ) {
                            alt50=1;
                        }
                    }
                    switch (alt50) {
                        case 1 :
                            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:167:5: tablename dot
                            {
                            pushFollow(FOLLOW_tablename_in_between966);
                            tablename();

                            state._fsp--;

                            pushFollow(FOLLOW_dot_in_between968);
                            dot();

                            state._fsp--;


                            }
                            break;

                    }

                    pushFollow(FOLLOW_fieldname_in_between972);
                    fieldname();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:167:33: sysdate
                    {
                    pushFollow(FOLLOW_sysdate_in_between976);
                    sysdate();

                    state._fsp--;


                    }
                    break;

            }

            match(input,BETWEEN,FOLLOW_BETWEEN_in_between979); 
            out(" between ");
            pushFollow(FOLLOW_detailExpresion_in_between983);
            detailExpresion();

            state._fsp--;

            match(input,AND,FOLLOW_AND_in_between985); 
            out(" and ");
            pushFollow(FOLLOW_detailExpresion_in_between989);
            detailExpresion();

            state._fsp--;


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "between"


    // $ANTLR start "dot"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:170:1: dot : ( DOT ) ;
    public final void dot() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:171:1: ( ( DOT ) )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:171:3: ( DOT )
            {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:171:3: ( DOT )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:171:4: DOT
            {
            match(input,DOT,FOLLOW_DOT_in_dot1002); 
            out(".");

            }


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "dot"


    // $ANTLR start "expression"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:173:1: expression : ( ( EQUAL ) | ( LT ) | ( GT ) | ( LTGT ) | ( AND ) | ( OR ) );
    public final void expression() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:174:2: ( ( EQUAL ) | ( LT ) | ( GT ) | ( LTGT ) | ( AND ) | ( OR ) )
            int alt52=6;
            switch ( input.LA(1) ) {
            case EQUAL:
                {
                alt52=1;
                }
                break;
            case LT:
                {
                alt52=2;
                }
                break;
            case GT:
                {
                alt52=3;
                }
                break;
            case LTGT:
                {
                alt52=4;
                }
                break;
            case AND:
                {
                alt52=5;
                }
                break;
            case OR:
                {
                alt52=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:174:4: ( EQUAL )
                    {
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:174:4: ( EQUAL )
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:174:5: EQUAL
                    {
                    match(input,EQUAL,FOLLOW_EQUAL_in_expression1015); 
                    out("=");

                    }


                    }
                    break;
                case 2 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:175:4: ( LT )
                    {
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:175:4: ( LT )
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:175:5: LT
                    {
                    match(input,LT,FOLLOW_LT_in_expression1024); 
                    out("<");

                    }


                    }
                    break;
                case 3 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:176:4: ( GT )
                    {
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:176:4: ( GT )
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:176:5: GT
                    {
                    match(input,GT,FOLLOW_GT_in_expression1033); 
                    out(">");

                    }


                    }
                    break;
                case 4 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:177:4: ( LTGT )
                    {
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:177:4: ( LTGT )
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:177:5: LTGT
                    {
                    match(input,LTGT,FOLLOW_LTGT_in_expression1043); 
                    out("<>");

                    }


                    }
                    break;
                case 5 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:178:4: ( AND )
                    {
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:178:4: ( AND )
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:178:5: AND
                    {
                    match(input,AND,FOLLOW_AND_in_expression1052); 
                    out(" AND ");

                    }


                    }
                    break;
                case 6 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:179:4: ( OR )
                    {
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:179:4: ( OR )
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:179:5: OR
                    {
                    match(input,OR,FOLLOW_OR_in_expression1062); 
                    out(" OR ");

                    }


                    }
                    break;

            }
        }
             finally {
        }
        return ;
    }
    // $ANTLR end "expression"


    // $ANTLR start "questions"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:182:1: questions : open question ( comma question )* close ;
    public final void questions() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:183:2: ( open question ( comma question )* close )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:183:4: open question ( comma question )* close
            {
            pushFollow(FOLLOW_open_in_questions1076);
            open();

            state._fsp--;

            pushFollow(FOLLOW_question_in_questions1078);
            question();

            state._fsp--;

            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:183:18: ( comma question )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==COMMA) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:183:19: comma question
            	    {
            	    pushFollow(FOLLOW_comma_in_questions1081);
            	    comma();

            	    state._fsp--;

            	    pushFollow(FOLLOW_question_in_questions1083);
            	    question();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            pushFollow(FOLLOW_close_in_questions1087);
            close();

            state._fsp--;


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "questions"


    // $ANTLR start "sets"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:186:1: sets : SET ( tablename dot )? fieldname EQUAL question ( comma ( ( tablename dot )? fieldname ) EQUAL question )* ;
    public final void sets() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:186:6: ( SET ( tablename dot )? fieldname EQUAL question ( comma ( ( tablename dot )? fieldname ) EQUAL question )* )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:186:8: SET ( tablename dot )? fieldname EQUAL question ( comma ( ( tablename dot )? fieldname ) EQUAL question )*
            {
            out("set ");
            match(input,SET,FOLLOW_SET_in_sets1104); 
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:187:6: ( tablename dot )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==SCHEMA) ) {
                alt54=1;
            }
            else if ( (LA54_0==IDENT) ) {
                int LA54_2 = input.LA(2);

                if ( (LA54_2==DOT) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:187:7: tablename dot
                    {
                    pushFollow(FOLLOW_tablename_in_sets1107);
                    tablename();

                    state._fsp--;

                    pushFollow(FOLLOW_dot_in_sets1109);
                    dot();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_fieldname_in_sets1113);
            fieldname();

            state._fsp--;

            match(input,EQUAL,FOLLOW_EQUAL_in_sets1115); 
            out("=");
            pushFollow(FOLLOW_question_in_sets1118);
            question();

            state._fsp--;

            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:188:3: ( comma ( ( tablename dot )? fieldname ) EQUAL question )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==COMMA) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:188:4: comma ( ( tablename dot )? fieldname ) EQUAL question
            	    {
            	    pushFollow(FOLLOW_comma_in_sets1124);
            	    comma();

            	    state._fsp--;

            	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:188:10: ( ( tablename dot )? fieldname )
            	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:188:11: ( tablename dot )? fieldname
            	    {
            	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:188:11: ( tablename dot )?
            	    int alt55=2;
            	    int LA55_0 = input.LA(1);

            	    if ( (LA55_0==SCHEMA) ) {
            	        alt55=1;
            	    }
            	    else if ( (LA55_0==IDENT) ) {
            	        int LA55_2 = input.LA(2);

            	        if ( (LA55_2==DOT) ) {
            	            alt55=1;
            	        }
            	    }
            	    switch (alt55) {
            	        case 1 :
            	            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:188:12: tablename dot
            	            {
            	            pushFollow(FOLLOW_tablename_in_sets1128);
            	            tablename();

            	            state._fsp--;

            	            pushFollow(FOLLOW_dot_in_sets1130);
            	            dot();

            	            state._fsp--;


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_fieldname_in_sets1134);
            	    fieldname();

            	    state._fsp--;


            	    }

            	    match(input,EQUAL,FOLLOW_EQUAL_in_sets1137); 
            	    out("=");
            	    pushFollow(FOLLOW_question_in_sets1140);
            	    question();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "sets"


    // $ANTLR start "question"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:190:1: question : (a= QUESTION ) ;
    public final void question() throws RecognitionException {
        Token a=null;

        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:190:10: ( (a= QUESTION ) )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:190:12: (a= QUESTION )
            {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:190:12: (a= QUESTION )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:190:13: a= QUESTION
            {
            a=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_question1155); 
            out(" ? ");

            }


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "question"


    // $ANTLR start "intcons"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:192:1: intcons : (a= INTCONS ) ;
    public final void intcons() throws RecognitionException {
        Token a=null;

        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:192:9: ( (a= INTCONS ) )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:192:11: (a= INTCONS )
            {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:192:11: (a= INTCONS )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:192:12: a= INTCONS
            {
            a=(Token)match(input,INTCONS,FOLLOW_INTCONS_in_intcons1168); 
            out(a);

            }


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "intcons"


    // $ANTLR start "open"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:194:1: open : (a= OPEN ) ;
    public final void open() throws RecognitionException {
        Token a=null;

        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:194:6: ( (a= OPEN ) )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:194:8: (a= OPEN )
            {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:194:8: (a= OPEN )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:194:9: a= OPEN
            {
            a=(Token)match(input,OPEN,FOLLOW_OPEN_in_open1183); 
            out("(");

            }


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "open"


    // $ANTLR start "close"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:197:1: close : (a= CLOSE ) ;
    public final void close() throws RecognitionException {
        Token a=null;

        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:197:7: ( (a= CLOSE ) )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:197:8: (a= CLOSE )
            {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:197:8: (a= CLOSE )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:197:9: a= CLOSE
            {
            a=(Token)match(input,CLOSE,FOLLOW_CLOSE_in_close1200); 
            out(")");

            }


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "close"


    // $ANTLR start "comma"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:199:1: comma : (a= COMMA ) ;
    public final void comma() throws RecognitionException {
        Token a=null;

        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:199:7: ( (a= COMMA ) )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:199:8: (a= COMMA )
            {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:199:8: (a= COMMA )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:199:9: a= COMMA
            {
            a=(Token)match(input,COMMA,FOLLOW_COMMA_in_comma1216); 
            out(",");

            }


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "comma"


    // $ANTLR start "fieldname"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:201:1: fieldname : (a= IDENT ) ;
    public final void fieldname() throws RecognitionException {
        Token a=null;

        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:202:3: ( (a= IDENT ) )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:202:5: (a= IDENT )
            {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:202:5: (a= IDENT )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:202:6: a= IDENT
            {
            a=(Token)match(input,IDENT,FOLLOW_IDENT_in_fieldname1231); 
            fieldName(a);

            }


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "fieldname"


    // $ANTLR start "tablename"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:205:1: tablename : ( schema dot )? (a= IDENT ) ;
    public final void tablename() throws RecognitionException {
        Token a=null;

        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:206:3: ( ( schema dot )? (a= IDENT ) )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:206:5: ( schema dot )? (a= IDENT )
            {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:206:5: ( schema dot )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==SCHEMA) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:206:6: schema dot
                    {
                    pushFollow(FOLLOW_schema_in_tablename1250);
                    schema();

                    state._fsp--;

                    pushFollow(FOLLOW_dot_in_tablename1252);
                    dot();

                    state._fsp--;


                    }
                    break;

            }

            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:206:18: (a= IDENT )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:206:19: a= IDENT
            {
            a=(Token)match(input,IDENT,FOLLOW_IDENT_in_tablename1258); 
            tableName(a);

            }


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "tablename"


    // $ANTLR start "orderby"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:208:1: orderby : ORDER_BY fieldname ( comma fieldname )* ( ASC | DESC )? ;
    public final void orderby() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:209:2: ( ORDER_BY fieldname ( comma fieldname )* ( ASC | DESC )? )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:209:4: ORDER_BY fieldname ( comma fieldname )* ( ASC | DESC )?
            {
            match(input,ORDER_BY,FOLLOW_ORDER_BY_in_orderby1272); 
            out(" order by ");
            pushFollow(FOLLOW_fieldname_in_orderby1276);
            fieldname();

            state._fsp--;

            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:209:44: ( comma fieldname )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==COMMA) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:209:45: comma fieldname
            	    {
            	    pushFollow(FOLLOW_comma_in_orderby1279);
            	    comma();

            	    state._fsp--;

            	    pushFollow(FOLLOW_fieldname_in_orderby1281);
            	    fieldname();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:210:3: ( ASC | DESC )?
            int alt59=3;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==ASC) ) {
                alt59=1;
            }
            else if ( (LA59_0==DESC) ) {
                alt59=2;
            }
            switch (alt59) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:210:4: ASC
                    {
                    match(input,ASC,FOLLOW_ASC_in_orderby1289); 
                    out(" asc ");

                    }
                    break;
                case 2 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:210:26: DESC
                    {
                    match(input,DESC,FOLLOW_DESC_in_orderby1295); 
                    out(" desc ");

                    }
                    break;

            }


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "orderby"


    // $ANTLR start "groupby"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:212:1: groupby : GROUP_BY fieldname ( comma fieldname )* ;
    public final void groupby() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:213:2: ( GROUP_BY fieldname ( comma fieldname )* )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:213:4: GROUP_BY fieldname ( comma fieldname )*
            {
            match(input,GROUP_BY,FOLLOW_GROUP_BY_in_groupby1309); 
            out(" group by ");
            pushFollow(FOLLOW_fieldname_in_groupby1313);
            fieldname();

            state._fsp--;

            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:213:44: ( comma fieldname )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==COMMA) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:213:45: comma fieldname
            	    {
            	    pushFollow(FOLLOW_comma_in_groupby1316);
            	    comma();

            	    state._fsp--;

            	    pushFollow(FOLLOW_fieldname_in_groupby1318);
            	    fieldname();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "groupby"


    // $ANTLR start "having"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:215:1: having : HAVING logicExpresions ;
    public final void having() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:216:2: ( HAVING logicExpresions )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:216:4: HAVING logicExpresions
            {
            match(input,HAVING,FOLLOW_HAVING_in_having1331); 
             out(" having "); 
            pushFollow(FOLLOW_logicExpresions_in_having1335);
            logicExpresions();

            state._fsp--;


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "having"


    // $ANTLR start "schema"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:218:1: schema : SCHEMA ;
    public final void schema() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:219:2: ( SCHEMA )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:219:4: SCHEMA
            {
            match(input,SCHEMA,FOLLOW_SCHEMA_in_schema1347); 
            putSchema();

            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "schema"


    // $ANTLR start "attributeAccess"
    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:221:1: attributeAccess : ATTRIBUTTE_ACCESS (a= IDENT ) ;
    public final void attributeAccess() throws RecognitionException {
        Token a=null;

        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:222:2: ( ATTRIBUTTE_ACCESS (a= IDENT ) )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:222:4: ATTRIBUTTE_ACCESS (a= IDENT )
            {
            match(input,ATTRIBUTTE_ACCESS,FOLLOW_ATTRIBUTTE_ACCESS_in_attributeAccess1361); 
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:222:23: (a= IDENT )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:222:24: a= IDENT
            {
            a=(Token)match(input,IDENT,FOLLOW_IDENT_in_attributeAccess1367); 
            attributeAccess(a);

            }


            }

        }
             finally {
        }
        return ;
    }
    // $ANTLR end "attributeAccess"

    // Delegated rules


    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA22_eotS =
        "\u00d9\uffff";
    static final String DFA22_eofS =
        "\1\uffff\1\24\1\uffff\2\24\12\uffff\2\24\11\uffff\1\65\12\uffff"+
        "\1\65\21\uffff\1\130\43\uffff\1\130\2\uffff\1\130\2\uffff\1\130"+
        "\2\uffff\1\130\2\uffff\2\130\42\uffff\1\u00b2\2\uffff\1\u00b2\2"+
        "\uffff\1\u00b2\2\uffff\1\u00b2\2\uffff\2\u00b2\43\uffff\3\u00bf"+
        "\24\uffff\3\u00d8\3\uffff";
    static final String DFA22_minS =
        "\1\15\1\4\1\43\2\4\11\22\1\15\2\4\1\uffff\2\15\4\uffff\2\15\1\4"+
        "\1\uffff\1\12\4\15\1\27\3\15\1\4\1\uffff\1\43\2\uffff\11\22\1\15"+
        "\2\uffff\1\43\1\4\1\43\2\23\1\43\1\23\1\43\1\23\1\43\1\23\1\43\3"+
        "\23\2\43\1\53\2\43\1\53\2\43\1\53\1\15\1\12\4\15\1\27\3\15\1\uffff"+
        "\2\15\1\4\2\15\1\4\2\15\1\4\2\15\1\4\2\15\2\4\2\15\1\27\2\15\1\27"+
        "\2\15\1\27\2\43\2\23\1\43\1\23\1\43\1\23\1\43\1\23\1\43\3\23\2\43"+
        "\1\53\2\43\1\53\2\43\1\53\1\43\1\23\1\4\1\43\1\23\1\4\1\43\1\23"+
        "\1\4\1\43\1\23\1\4\1\43\1\23\2\4\1\43\1\53\1\23\1\43\1\53\1\23\1"+
        "\43\1\53\1\23\3\15\1\uffff\2\15\1\uffff\2\15\1\uffff\2\15\1\uffff"+
        "\2\15\2\uffff\2\15\1\27\2\15\1\27\2\15\1\27\3\4\1\uffff\1\43\1\23"+
        "\1\43\1\23\1\43\1\23\1\43\1\23\1\43\1\23\1\43\1\53\1\23\1\43\1\53"+
        "\1\23\1\43\1\53\1\23\3\4\3\uffff";
    static final String DFA22_maxS =
        "\2\62\1\43\2\62\11\22\1\15\2\62\1\uffff\2\62\4\uffff\2\15\1\62"+
        "\1\uffff\5\61\1\51\3\61\1\62\1\uffff\1\43\2\uffff\11\22\1\15\2\uffff"+
        "\1\43\1\62\2\43\1\23\10\43\2\23\1\43\2\53\1\43\2\53\1\43\2\53\1"+
        "\15\5\61\1\51\3\61\1\uffff\2\15\1\62\2\15\1\62\2\15\1\62\2\15\1"+
        "\62\2\15\2\62\2\15\1\27\2\15\1\27\2\15\1\27\3\43\1\23\10\43\2\23"+
        "\1\43\2\53\1\43\2\53\1\43\2\53\1\43\1\23\1\60\1\43\1\23\1\60\1\43"+
        "\1\23\1\60\1\43\1\23\1\60\1\43\1\23\2\60\1\43\1\53\1\23\1\43\1\53"+
        "\1\23\1\43\1\53\1\23\3\15\1\uffff\2\15\1\uffff\2\15\1\uffff\2\15"+
        "\1\uffff\2\15\2\uffff\2\15\1\27\2\15\1\27\2\15\1\27\3\62\1\uffff"+
        "\1\43\1\23\1\43\1\23\1\43\1\23\1\43\1\23\1\43\1\23\1\43\1\53\1\23"+
        "\1\43\1\53\1\23\1\43\1\53\1\23\3\60\3\uffff";
    static final String DFA22_acceptS =
        "\21\uffff\1\6\2\uffff\1\1\1\2\1\4\1\5\3\uffff\1\3\12\uffff\1\1"+
        "\1\uffff\2\1\12\uffff\2\1\42\uffff\1\1\114\uffff\1\1\2\uffff\1\1"+
        "\2\uffff\1\1\2\uffff\1\1\2\uffff\2\1\14\uffff\1\1\26\uffff\3\1";
    static final String DFA22_specialS =
        "\u00d9\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\3\4\uffff\1\21\4\uffff\1\20\1\4\1\5\1\6\1\7\1\10\1\11\1"+
            "\12\1\13\1\14\1\15\7\uffff\1\1\1\17\6\uffff\1\2\1\16",
            "\1\24\1\uffff\1\24\1\uffff\1\24\4\uffff\1\25\1\26\2\uffff"+
            "\1\27\1\uffff\1\24\1\22\1\23\1\uffff\13\25\2\uffff\4\25\1\uffff"+
            "\2\25\1\uffff\1\24\2\uffff\2\24\2\25",
            "\1\30",
            "\1\24\1\uffff\1\24\1\uffff\1\24\4\uffff\1\25\1\26\2\uffff"+
            "\1\27\1\uffff\1\24\1\22\1\23\1\32\13\25\1\33\1\31\4\25\1\uffff"+
            "\2\25\1\uffff\1\24\2\uffff\2\24\2\25",
            "\1\24\1\uffff\1\24\1\uffff\1\24\4\uffff\1\25\1\26\2\uffff"+
            "\1\27\1\uffff\1\24\1\22\1\23\1\uffff\13\25\1\33\1\uffff\4\25"+
            "\1\uffff\2\25\1\uffff\1\24\2\uffff\2\24\2\25",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\24\1\uffff\1\24\1\uffff\1\24\4\uffff\1\25\1\26\2\uffff"+
            "\1\27\1\uffff\1\24\1\22\1\23\1\uffff\13\25\2\uffff\4\25\1\uffff"+
            "\2\25\1\uffff\1\24\2\uffff\2\24\2\25",
            "\1\24\1\uffff\1\24\1\uffff\1\24\4\uffff\1\25\1\26\2\uffff"+
            "\1\27\1\uffff\1\24\1\22\1\23\1\uffff\13\25\2\uffff\4\25\1\uffff"+
            "\2\25\1\uffff\1\24\2\uffff\2\24\2\25",
            "",
            "\1\50\4\uffff\1\65\4\uffff\1\65\1\51\1\52\1\53\1\54\1\55\1"+
            "\56\1\57\1\60\1\61\1\62\7\uffff\1\46\1\64\6\uffff\1\47\1\63",
            "\1\50\4\uffff\1\65\4\uffff\1\65\1\51\1\52\1\53\1\54\1\55\1"+
            "\56\1\57\1\60\1\61\1\62\7\uffff\1\46\1\64\6\uffff\1\47\1\63",
            "",
            "",
            "",
            "",
            "\1\66",
            "\1\67",
            "\1\65\1\uffff\1\65\1\uffff\1\65\4\uffff\1\25\1\26\2\uffff"+
            "\1\27\1\uffff\1\65\1\22\1\23\1\uffff\13\25\2\uffff\4\25\1\uffff"+
            "\2\25\1\uffff\1\65\2\uffff\1\24\1\65\2\25",
            "",
            "\1\72\2\uffff\1\71\43\uffff\1\70",
            "\1\74\43\uffff\1\73",
            "\1\76\43\uffff\1\75",
            "\1\100\43\uffff\1\77",
            "\1\102\43\uffff\1\101",
            "\1\103\21\uffff\1\104",
            "\1\106\11\uffff\1\107\31\uffff\1\105",
            "\1\111\11\uffff\1\112\31\uffff\1\110",
            "\1\114\11\uffff\1\115\31\uffff\1\113",
            "\1\65\1\uffff\1\65\1\uffff\1\65\4\uffff\1\25\1\26\2\uffff"+
            "\1\27\1\uffff\1\65\1\22\1\23\1\uffff\13\25\2\uffff\4\25\1\uffff"+
            "\2\25\1\uffff\1\65\2\uffff\1\24\1\65\2\25",
            "",
            "\1\116",
            "",
            "",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "",
            "",
            "\1\31",
            "\1\130\1\uffff\1\130\1\uffff\1\130\4\uffff\1\25\1\26\2\uffff"+
            "\1\27\1\uffff\1\130\1\22\1\23\1\32\13\25\1\33\1\uffff\4\25\1"+
            "\uffff\2\25\1\uffff\1\130\2\uffff\1\24\1\130\2\25",
            "\1\131",
            "\1\133\17\uffff\1\132",
            "\1\133",
            "\1\134",
            "\1\136\17\uffff\1\135",
            "\1\137",
            "\1\141\17\uffff\1\140",
            "\1\142",
            "\1\144\17\uffff\1\143",
            "\1\145",
            "\1\147\17\uffff\1\146",
            "\1\150",
            "\1\150",
            "\1\151",
            "\1\152\7\uffff\1\153",
            "\1\153",
            "\1\154",
            "\1\155\7\uffff\1\156",
            "\1\156",
            "\1\157",
            "\1\160\7\uffff\1\161",
            "\1\161",
            "\1\162",
            "\1\165\2\uffff\1\164\43\uffff\1\163",
            "\1\167\43\uffff\1\166",
            "\1\171\43\uffff\1\170",
            "\1\173\43\uffff\1\172",
            "\1\175\43\uffff\1\174",
            "\1\176\21\uffff\1\177",
            "\1\u0081\11\uffff\1\u0082\31\uffff\1\u0080",
            "\1\u0084\11\uffff\1\u0085\31\uffff\1\u0083",
            "\1\u0087\11\uffff\1\u0088\31\uffff\1\u0086",
            "",
            "\1\u0089",
            "\1\u008a",
            "\1\130\1\uffff\1\130\1\uffff\1\130\4\uffff\1\u008b\1\26\2"+
            "\uffff\1\27\1\uffff\1\130\1\22\1\23\1\uffff\13\25\2\uffff\4"+
            "\25\1\uffff\2\25\1\uffff\1\130\2\uffff\1\24\1\130\2\25",
            "\1\u008c",
            "\1\u008d",
            "\1\130\1\uffff\1\130\1\uffff\1\130\4\uffff\1\u008e\1\26\2"+
            "\uffff\1\27\1\uffff\1\130\1\22\1\23\1\uffff\13\25\2\uffff\4"+
            "\25\1\uffff\2\25\1\uffff\1\130\2\uffff\1\24\1\130\2\25",
            "\1\u008f",
            "\1\u0090",
            "\1\130\1\uffff\1\130\1\uffff\1\130\4\uffff\1\u0091\1\26\2"+
            "\uffff\1\27\1\uffff\1\130\1\22\1\23\1\uffff\13\25\2\uffff\4"+
            "\25\1\uffff\2\25\1\uffff\1\130\2\uffff\1\24\1\130\2\25",
            "\1\u0092",
            "\1\u0093",
            "\1\130\1\uffff\1\130\1\uffff\1\130\4\uffff\1\u0094\1\26\2"+
            "\uffff\1\27\1\uffff\1\130\1\22\1\23\1\uffff\13\25\2\uffff\4"+
            "\25\1\uffff\2\25\1\uffff\1\130\2\uffff\1\24\1\130\2\25",
            "\1\u0095",
            "\1\u0096",
            "\1\130\1\uffff\1\130\1\uffff\1\130\4\uffff\1\u0097\1\26\2"+
            "\uffff\1\27\1\uffff\1\130\1\22\1\23\1\uffff\13\25\2\uffff\4"+
            "\25\1\uffff\2\25\1\uffff\1\130\2\uffff\1\24\1\130\2\25",
            "\1\130\1\uffff\1\130\1\uffff\1\130\4\uffff\1\u0098\1\26\2"+
            "\uffff\1\27\1\uffff\1\130\1\22\1\23\1\uffff\13\25\2\uffff\4"+
            "\25\1\uffff\2\25\1\uffff\1\130\2\uffff\1\24\1\130\2\25",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a5\17\uffff\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a8\17\uffff\1\u00a7",
            "\1\u00a9",
            "\1\u00ab\17\uffff\1\u00aa",
            "\1\u00ac",
            "\1\u00ae\17\uffff\1\u00ad",
            "\1\u00af",
            "\1\u00b1\17\uffff\1\u00b0",
            "\1\u00b2",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4\7\uffff\1\u00b5",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7\7\uffff\1\u00b8",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba\7\uffff\1\u00bb",
            "\1\u00bb",
            "\1\132",
            "\1\133",
            "\1\u00b2\1\uffff\1\u00b2\1\uffff\1\u00b2\5\uffff\1\26\2\uffff"+
            "\1\27\1\uffff\3\u00b2\26\uffff\1\u00b2\2\uffff\1\24\1\u00b2",
            "\1\135",
            "\1\136",
            "\1\u00b2\1\uffff\1\u00b2\1\uffff\1\u00b2\5\uffff\1\26\2\uffff"+
            "\1\27\1\uffff\3\u00b2\26\uffff\1\u00b2\2\uffff\1\24\1\u00b2",
            "\1\140",
            "\1\141",
            "\1\u00b2\1\uffff\1\u00b2\1\uffff\1\u00b2\5\uffff\1\26\2\uffff"+
            "\1\27\1\uffff\3\u00b2\26\uffff\1\u00b2\2\uffff\1\24\1\u00b2",
            "\1\143",
            "\1\144",
            "\1\u00b2\1\uffff\1\u00b2\1\uffff\1\u00b2\5\uffff\1\26\2\uffff"+
            "\1\27\1\uffff\3\u00b2\26\uffff\1\u00b2\2\uffff\1\24\1\u00b2",
            "\1\146",
            "\1\147",
            "\1\u00b2\1\uffff\1\u00b2\1\uffff\1\u00b2\5\uffff\1\26\2\uffff"+
            "\1\27\1\uffff\3\u00b2\26\uffff\1\u00b2\2\uffff\1\24\1\u00b2",
            "\1\u00b2\1\uffff\1\u00b2\1\uffff\1\u00b2\5\uffff\1\26\2\uffff"+
            "\1\27\1\uffff\3\u00b2\26\uffff\1\u00b2\2\uffff\1\24\1\u00b2",
            "\1\152",
            "\1\153",
            "\1\u00bc",
            "\1\155",
            "\1\156",
            "\1\u00bd",
            "\1\160",
            "\1\161",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "",
            "\1\u00c2",
            "\1\u00c3",
            "",
            "\1\u00c4",
            "\1\u00c5",
            "",
            "\1\u00c6",
            "\1\u00c7",
            "",
            "\1\u00c8",
            "\1\u00c9",
            "",
            "",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00bf\1\uffff\1\u00bf\1\uffff\1\u00bf\4\uffff\1\u00d3\1"+
            "\26\2\uffff\1\27\1\uffff\1\u00bf\1\22\1\23\1\uffff\13\25\2\uffff"+
            "\4\25\1\uffff\2\25\1\uffff\1\u00bf\2\uffff\1\24\1\u00bf\2\25",
            "\1\u00bf\1\uffff\1\u00bf\1\uffff\1\u00bf\4\uffff\1\u00d4\1"+
            "\26\2\uffff\1\27\1\uffff\1\u00bf\1\22\1\23\1\uffff\13\25\2\uffff"+
            "\4\25\1\uffff\2\25\1\uffff\1\u00bf\2\uffff\1\24\1\u00bf\2\25",
            "\1\u00bf\1\uffff\1\u00bf\1\uffff\1\u00bf\4\uffff\1\u00d5\1"+
            "\26\2\uffff\1\27\1\uffff\1\u00bf\1\22\1\23\1\uffff\13\25\2\uffff"+
            "\4\25\1\uffff\2\25\1\uffff\1\u00bf\2\uffff\1\24\1\u00bf\2\25",
            "",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00d6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00d7",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00d8",
            "\1\u00d8\1\uffff\1\u00d8\1\uffff\1\u00d8\5\uffff\1\26\2\uffff"+
            "\1\27\1\uffff\3\u00d8\26\uffff\1\u00d8\2\uffff\1\24\1\u00d8",
            "\1\u00d8\1\uffff\1\u00d8\1\uffff\1\u00d8\5\uffff\1\26\2\uffff"+
            "\1\27\1\uffff\3\u00d8\26\uffff\1\u00d8\2\uffff\1\24\1\u00d8",
            "\1\u00d8\1\uffff\1\u00d8\1\uffff\1\u00d8\5\uffff\1\26\2\uffff"+
            "\1\27\1\uffff\3\u00d8\26\uffff\1\u00d8\2\uffff\1\24\1\u00d8",
            "",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "120:1: logicExpresion : ( detailExpresion | detailExpresion ( expression )? detailExpresion | between | detailExpresion IS ( NOT )? NULL | detailExpresion IN open selectStatement close | OPEN logicExpresions CLOSE );";
        }
    }
 

    public static final BitSet FOLLOW_query_in_prog39 = new BitSet(new long[]{0x0000000000000152L});
    public static final BitSet FOLLOW_selectStatement_in_query66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insertStatement_in_query77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateSatement_in_query86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_selectStatement100 = new BitSet(new long[]{0x00020003FE002420L});
    public static final BitSet FOLLOW_DISTINCT_in_selectStatement109 = new BitSet(new long[]{0x00020003FE002420L});
    public static final BitSet FOLLOW_selectFields_in_selectStatement119 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_from_in_selectStatement123 = new BitSet(new long[]{0x0001900000001002L});
    public static final BitSet FOLLOW_where_in_selectStatement129 = new BitSet(new long[]{0x0001900000000002L});
    public static final BitSet FOLLOW_groupby_in_selectStatement136 = new BitSet(new long[]{0x0001100000000002L});
    public static final BitSet FOLLOW_orderby_in_selectStatement143 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_having_in_selectStatement150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSERT_in_insertStatement167 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_tablename_in_insertStatement174 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_open_in_insertStatement176 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_insertStatement178 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_comma_in_insertStatement181 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_insertStatement183 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_close_in_insertStatement187 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_VALUES_in_insertStatement192 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_questions_in_insertStatement199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_updateSatement213 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_tablename_in_updateSatement220 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_sets_in_updateSatement224 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_where_in_updateSatement229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_deleteSatement242 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_tablename_in_deleteSatement249 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_where_in_deleteSatement254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectFieldDef_in_selectFields273 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_comma_in_selectFields276 = new BitSet(new long[]{0x00020003FE002420L});
    public static final BitSet FOLLOW_selectFieldDef_in_selectFields278 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_tablename_in_selectFieldDef313 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dot_in_selectFieldDef315 = new BitSet(new long[]{0x0000000000002400L});
    public static final BitSet FOLLOW_fieldname_in_selectFieldDef320 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ASTERISK_in_selectFieldDef322 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_alias_in_selectFieldDef328 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_function_in_selectFieldDef336 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_comma_in_selectFieldDef340 = new BitSet(new long[]{0x00020003FE002420L});
    public static final BitSet FOLLOW_selectFieldDef_in_selectFieldDef342 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_FROM_in_from359 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_tablename_in_from361 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_comma_in_from365 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_tablename_in_from367 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_FROM_in_from376 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_open_in_from378 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_selectStatement_in_from380 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_close_in_from382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where396 = new BitSet(new long[]{0x00060603FF842420L});
    public static final BitSet FOLLOW_logicExpresions_in_where398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_alias413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicExpresion_in_logicExpresions427 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_operator_in_logicExpresions430 = new BitSet(new long[]{0x00060603FF842420L});
    public static final BitSet FOLLOW_logicExpresion_in_logicExpresions432 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_detailExpresion_in_logicExpresion445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_detailExpresion_in_logicExpresion452 = new BitSet(new long[]{0x000606F3FFB02420L});
    public static final BitSet FOLLOW_expression_in_logicExpresion455 = new BitSet(new long[]{0x00060603FF802420L});
    public static final BitSet FOLLOW_detailExpresion_in_logicExpresion459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_between_in_logicExpresion465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_detailExpresion_in_logicExpresion471 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_IS_in_logicExpresion473 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_NOT_in_logicExpresion478 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NULL_in_logicExpresion485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_detailExpresion_in_logicExpresion493 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_IN_in_logicExpresion495 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_open_in_logicExpresion499 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_selectStatement_in_logicExpresion501 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_close_in_logicExpresion503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_logicExpresion509 = new BitSet(new long[]{0x00060603FF842420L});
    public static final BitSet FOLLOW_logicExpresions_in_logicExpresion513 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_CLOSE_in_logicExpresion515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_operator527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_operator534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_detailExpresion557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tablename_in_detailExpresion563 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dot_in_detailExpresion565 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_detailExpresion569 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_OUTER_in_detailExpresion572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sysdate_in_detailExpresion582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_detailExpresion587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeAccess_in_detailExpresion592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_intcons_in_detailExpresion597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_detailExpresion605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYSDATE_in_sysdate615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COUNT_in_function628 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_open_in_function632 = new BitSet(new long[]{0x0002000000002400L});
    public static final BitSet FOLLOW_tablename_in_function641 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dot_in_function643 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_function647 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_ASTERISK_in_function652 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_close_in_function662 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_alias_in_function665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAX_in_function672 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_open_in_function676 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_tablename_in_function679 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dot_in_function681 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_function685 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_close_in_function687 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_alias_in_function690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIN_in_function697 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_open_in_function701 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_tablename_in_function704 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dot_in_function706 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_function710 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_close_in_function712 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_alias_in_function715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUM_in_function722 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_open_in_function726 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_tablename_in_function729 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dot_in_function731 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_function735 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_close_in_function737 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_alias_in_function740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AVG_in_function747 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_open_in_function751 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_tablename_in_function754 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dot_in_function756 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_function760 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_close_in_function762 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_alias_in_function765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIKE_in_function773 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_open_in_function777 = new BitSet(new long[]{0x0000020000800000L});
    public static final BitSet FOLLOW_StringLiteral_in_function782 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_question_in_function787 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_close_in_function791 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_alias_in_function794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TO_DATE_in_function801 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_open_in_function805 = new BitSet(new long[]{0x0002000000802000L});
    public static final BitSet FOLLOW_tablename_in_function810 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dot_in_function812 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_function816 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_function823 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_comma_in_function833 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_StringLiteral_in_function838 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_close_in_function842 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_alias_in_function845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TO_CHAR_in_function853 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_open_in_function857 = new BitSet(new long[]{0x0002000000802000L});
    public static final BitSet FOLLOW_tablename_in_function862 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dot_in_function864 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_function868 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_function875 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_comma_in_function885 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_StringLiteral_in_function890 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_close_in_function894 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_alias_in_function897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUNC_in_function904 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_open_in_function908 = new BitSet(new long[]{0x0002000000802000L});
    public static final BitSet FOLLOW_tablename_in_function913 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dot_in_function915 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_function919 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_function926 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_comma_in_function936 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_StringLiteral_in_function941 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_close_in_function945 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_alias_in_function948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tablename_in_between966 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dot_in_between968 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_between972 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_sysdate_in_between976 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_BETWEEN_in_between979 = new BitSet(new long[]{0x00060603FF802420L});
    public static final BitSet FOLLOW_detailExpresion_in_between983 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_AND_in_between985 = new BitSet(new long[]{0x00060603FF802420L});
    public static final BitSet FOLLOW_detailExpresion_in_between989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_dot1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUAL_in_expression1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_expression1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_expression1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LTGT_in_expression1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_expression1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_expression1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_open_in_questions1076 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_question_in_questions1078 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_comma_in_questions1081 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_question_in_questions1083 = new BitSet(new long[]{0x0000080000080000L});
    public static final BitSet FOLLOW_close_in_questions1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_sets1104 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_tablename_in_sets1107 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dot_in_sets1109 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_sets1113 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_EQUAL_in_sets1115 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_question_in_sets1118 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_comma_in_sets1124 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_tablename_in_sets1128 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dot_in_sets1130 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_sets1134 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_EQUAL_in_sets1137 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_question_in_sets1140 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_QUESTION_in_question1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTCONS_in_intcons1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPEN_in_open1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLOSE_in_close1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_comma1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_fieldname1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_schema_in_tablename1250 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_dot_in_tablename1252 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENT_in_tablename1258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_BY_in_orderby1272 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_orderby1276 = new BitSet(new long[]{0x0000680000000002L});
    public static final BitSet FOLLOW_comma_in_orderby1279 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_orderby1281 = new BitSet(new long[]{0x0000680000000002L});
    public static final BitSet FOLLOW_ASC_in_orderby1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_orderby1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_BY_in_groupby1309 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_groupby1313 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_comma_in_groupby1316 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_fieldname_in_groupby1318 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_HAVING_in_having1331 = new BitSet(new long[]{0x00060603FF842420L});
    public static final BitSet FOLLOW_logicExpresions_in_having1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SCHEMA_in_schema1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATTRIBUTTE_ACCESS_in_attributeAccess1361 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENT_in_attributeAccess1367 = new BitSet(new long[]{0x0000000000000002L});

}