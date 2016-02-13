// $ANTLR 3.3 Nov 30, 2010 12:45:30 D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g 2014-04-10 16:42:28

	package com.ogm.persistance.sql.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SQLGrammarLexer extends Lexer {
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

    public SQLGrammarLexer() {;} 
    public SQLGrammarLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SQLGrammarLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g"; }

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:226:5: ( '\\'' (~ ( '\\'' | '\\\\' ) )* '\\'' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:226:8: '\\'' (~ ( '\\'' | '\\\\' ) )* '\\''
            {
            match('\''); 
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:226:13: (~ ( '\\'' | '\\\\' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='&')||(LA1_0>='(' && LA1_0<='[')||(LA1_0>=']' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:226:15: ~ ( '\\'' | '\\\\' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "StringLiteral"

    // $ANTLR start "SCHEMA"
    public final void mSCHEMA() throws RecognitionException {
        try {
            int _type = SCHEMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:228:8: ( '{schema}' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:228:10: '{schema}'
            {
            match("{schema}"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SCHEMA"

    // $ANTLR start "SELECT"
    public final void mSELECT() throws RecognitionException {
        try {
            int _type = SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:229:8: ( 'select' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:229:10: 'select'
            {
            match("select"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SELECT"

    // $ANTLR start "INSERT"
    public final void mINSERT() throws RecognitionException {
        try {
            int _type = INSERT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:230:8: ( 'insert into' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:230:10: 'insert into'
            {
            match("insert into"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INSERT"

    // $ANTLR start "UPDATE"
    public final void mUPDATE() throws RecognitionException {
        try {
            int _type = UPDATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:231:9: ( 'update' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:231:11: 'update'
            {
            match("update"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UPDATE"

    // $ANTLR start "DELETE"
    public final void mDELETE() throws RecognitionException {
        try {
            int _type = DELETE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:232:9: ( 'delete from' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:232:11: 'delete from'
            {
            match("delete from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DELETE"

    // $ANTLR start "FROM"
    public final void mFROM() throws RecognitionException {
        try {
            int _type = FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:233:9: ( 'from' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:233:11: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FROM"

    // $ANTLR start "WHERE"
    public final void mWHERE() throws RecognitionException {
        try {
            int _type = WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:234:9: ( 'where' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:234:11: 'where'
            {
            match("where"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHERE"

    // $ANTLR start "VALUES"
    public final void mVALUES() throws RecognitionException {
        try {
            int _type = VALUES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:235:9: ( 'values' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:235:11: 'values'
            {
            match("values"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VALUES"

    // $ANTLR start "SET"
    public final void mSET() throws RecognitionException {
        try {
            int _type = SET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:236:5: ( 'set' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:236:7: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SET"

    // $ANTLR start "ASTERISK"
    public final void mASTERISK() throws RecognitionException {
        try {
            int _type = ASTERISK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:237:9: ( '*' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:237:11: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASTERISK"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:238:9: ( ',' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:238:11: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:239:9: ( '.' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:239:11: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "OPEN"
    public final void mOPEN() throws RecognitionException {
        try {
            int _type = OPEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:240:6: ( '(' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:240:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPEN"

    // $ANTLR start "CLOSE"
    public final void mCLOSE() throws RecognitionException {
        try {
            int _type = CLOSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:241:7: ( ')' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:241:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSE"

    // $ANTLR start "QUESTION"
    public final void mQUESTION() throws RecognitionException {
        try {
            int _type = QUESTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:242:9: ( '?' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:242:11: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUESTION"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:243:9: ( '=' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:243:11: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:244:4: ( '<' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:244:6: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:245:4: ( '>' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:245:6: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "LTGT"
    public final void mLTGT() throws RecognitionException {
        try {
            int _type = LTGT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:246:9: ( '<>' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:246:11: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LTGT"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:247:5: ( 'not' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:247:7: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "IS"
    public final void mIS() throws RecognitionException {
        try {
            int _type = IS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:248:4: ( 'is' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:248:6: 'is'
            {
            match("is"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IS"

    // $ANTLR start "NULL"
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:249:6: ( 'null' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:249:8: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NULL"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:250:5: ( 'and' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:250:7: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:251:4: ( 'or' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:251:6: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:252:4: ( 'in' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:252:6: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IN"

    // $ANTLR start "COUNT"
    public final void mCOUNT() throws RecognitionException {
        try {
            int _type = COUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:253:7: ( 'count' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:253:9: 'count'
            {
            match("count"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COUNT"

    // $ANTLR start "SUM"
    public final void mSUM() throws RecognitionException {
        try {
            int _type = SUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:254:5: ( 'sum' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:254:7: 'sum'
            {
            match("sum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUM"

    // $ANTLR start "AVG"
    public final void mAVG() throws RecognitionException {
        try {
            int _type = AVG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:255:5: ( 'avg' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:255:7: 'avg'
            {
            match("avg"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AVG"

    // $ANTLR start "MAX"
    public final void mMAX() throws RecognitionException {
        try {
            int _type = MAX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:256:5: ( 'max' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:256:7: 'max'
            {
            match("max"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAX"

    // $ANTLR start "MIN"
    public final void mMIN() throws RecognitionException {
        try {
            int _type = MIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:257:5: ( 'min' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:257:7: 'min'
            {
            match("min"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MIN"

    // $ANTLR start "LIKE"
    public final void mLIKE() throws RecognitionException {
        try {
            int _type = LIKE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:258:6: ( 'like' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:258:8: 'like'
            {
            match("like"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LIKE"

    // $ANTLR start "TO_CHAR"
    public final void mTO_CHAR() throws RecognitionException {
        try {
            int _type = TO_CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:259:9: ( 'to_char' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:259:11: 'to_char'
            {
            match("to_char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TO_CHAR"

    // $ANTLR start "TO_DATE"
    public final void mTO_DATE() throws RecognitionException {
        try {
            int _type = TO_DATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:260:9: ( 'to_date' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:260:11: 'to_date'
            {
            match("to_date"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TO_DATE"

    // $ANTLR start "TRUNC"
    public final void mTRUNC() throws RecognitionException {
        try {
            int _type = TRUNC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:261:9: ( 'trunc' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:261:11: 'trunc'
            {
            match("trunc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUNC"

    // $ANTLR start "BETWEEN"
    public final void mBETWEEN() throws RecognitionException {
        try {
            int _type = BETWEEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:262:9: ( 'between' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:262:11: 'between'
            {
            match("between"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BETWEEN"

    // $ANTLR start "SYSDATE"
    public final void mSYSDATE() throws RecognitionException {
        try {
            int _type = SYSDATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:263:9: ( 'sysdate' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:263:11: 'sysdate'
            {
            match("sysdate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SYSDATE"

    // $ANTLR start "ORDER_BY"
    public final void mORDER_BY() throws RecognitionException {
        try {
            int _type = ORDER_BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:264:9: ( 'order by' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:264:11: 'order by'
            {
            match("order by"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ORDER_BY"

    // $ANTLR start "ASC"
    public final void mASC() throws RecognitionException {
        try {
            int _type = ASC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:265:5: ( 'asc' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:265:7: 'asc'
            {
            match("asc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASC"

    // $ANTLR start "DESC"
    public final void mDESC() throws RecognitionException {
        try {
            int _type = DESC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:266:6: ( 'desc' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:266:8: 'desc'
            {
            match("desc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DESC"

    // $ANTLR start "GROUP_BY"
    public final void mGROUP_BY() throws RecognitionException {
        try {
            int _type = GROUP_BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:267:9: ( 'group by' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:267:11: 'group by'
            {
            match("group by"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GROUP_BY"

    // $ANTLR start "HAVING"
    public final void mHAVING() throws RecognitionException {
        try {
            int _type = HAVING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:268:9: ( 'having' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:268:11: 'having'
            {
            match("having"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HAVING"

    // $ANTLR start "DISTINCT"
    public final void mDISTINCT() throws RecognitionException {
        try {
            int _type = DISTINCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:269:9: ( 'distinct' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:269:11: 'distinct'
            {
            match("distinct"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DISTINCT"

    // $ANTLR start "OUTER"
    public final void mOUTER() throws RecognitionException {
        try {
            int _type = OUTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:270:7: ( '(+)' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:270:9: '(+)'
            {
            match("(+)"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OUTER"

    // $ANTLR start "ATTRIBUTTE_ACCESS"
    public final void mATTRIBUTTE_ACCESS() throws RecognitionException {
        try {
            int _type = ATTRIBUTTE_ACCESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:272:2: ( ':=' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:272:5: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ATTRIBUTTE_ACCESS"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:273:8: ( Letter ( Letter | JavaIDDigit )* )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:273:10: Letter ( Letter | JavaIDDigit )*
            {
            mLetter(); 
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:273:17: ( Letter | JavaIDDigit )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='$'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')||(LA2_0>='\u00C0' && LA2_0<='\u00D6')||(LA2_0>='\u00D8' && LA2_0<='\u00F6')||(LA2_0>='\u00F8' && LA2_0<='\u1FFF')||(LA2_0>='\u3040' && LA2_0<='\u318F')||(LA2_0>='\u3300' && LA2_0<='\u337F')||(LA2_0>='\u3400' && LA2_0<='\u3D2D')||(LA2_0>='\u4E00' && LA2_0<='\u9FFF')||(LA2_0>='\uF900' && LA2_0<='\uFAFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "INTCONS"
    public final void mINTCONS() throws RecognitionException {
        try {
            int _type = INTCONS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:276:3: ( ( '0' .. '9' )+ )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:276:5: ( '0' .. '9' )+
            {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:276:5: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:276:6: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTCONS"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:281:5: ( '\\u0024' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u00ff' | '\\u0100' .. '\\u1fff' | '\\u3040' .. '\\u318f' | '\\u3300' .. '\\u337f' | '\\u3400' .. '\\u3d2d' | '\\u4e00' .. '\\u9fff' | '\\uf900' .. '\\ufaff' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Letter"

    // $ANTLR start "JavaIDDigit"
    public final void mJavaIDDigit() throws RecognitionException {
        try {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:298:5: ( '\\u0030' .. '\\u0039' | '\\u0660' .. '\\u0669' | '\\u06f0' .. '\\u06f9' | '\\u0966' .. '\\u096f' | '\\u09e6' .. '\\u09ef' | '\\u0a66' .. '\\u0a6f' | '\\u0ae6' .. '\\u0aef' | '\\u0b66' .. '\\u0b6f' | '\\u0be7' .. '\\u0bef' | '\\u0c66' .. '\\u0c6f' | '\\u0ce6' .. '\\u0cef' | '\\u0d66' .. '\\u0d6f' | '\\u0e50' .. '\\u0e59' | '\\u0ed0' .. '\\u0ed9' | '\\u1040' .. '\\u1049' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='\u0660' && input.LA(1)<='\u0669')||(input.LA(1)>='\u06F0' && input.LA(1)<='\u06F9')||(input.LA(1)>='\u0966' && input.LA(1)<='\u096F')||(input.LA(1)>='\u09E6' && input.LA(1)<='\u09EF')||(input.LA(1)>='\u0A66' && input.LA(1)<='\u0A6F')||(input.LA(1)>='\u0AE6' && input.LA(1)<='\u0AEF')||(input.LA(1)>='\u0B66' && input.LA(1)<='\u0B6F')||(input.LA(1)>='\u0BE7' && input.LA(1)<='\u0BEF')||(input.LA(1)>='\u0C66' && input.LA(1)<='\u0C6F')||(input.LA(1)>='\u0CE6' && input.LA(1)<='\u0CEF')||(input.LA(1)>='\u0D66' && input.LA(1)<='\u0D6F')||(input.LA(1)>='\u0E50' && input.LA(1)<='\u0E59')||(input.LA(1)>='\u0ED0' && input.LA(1)<='\u0ED9')||(input.LA(1)>='\u1040' && input.LA(1)<='\u1049') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "JavaIDDigit"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:314:8: ( ( '\\r' )? '\\n' )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:314:9: ( '\\r' )? '\\n'
            {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:314:9: ( '\\r' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:314:9: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:315:4: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:315:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:315:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\t' && LA5_0<='\n')||LA5_0=='\r'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:8: ( StringLiteral | SCHEMA | SELECT | INSERT | UPDATE | DELETE | FROM | WHERE | VALUES | SET | ASTERISK | COMMA | DOT | OPEN | CLOSE | QUESTION | EQUAL | LT | GT | LTGT | NOT | IS | NULL | AND | OR | IN | COUNT | SUM | AVG | MAX | MIN | LIKE | TO_CHAR | TO_DATE | TRUNC | BETWEEN | SYSDATE | ORDER_BY | ASC | DESC | GROUP_BY | HAVING | DISTINCT | OUTER | ATTRIBUTTE_ACCESS | IDENT | INTCONS | NEWLINE | WS )
        int alt6=49;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:10: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 2 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:24: SCHEMA
                {
                mSCHEMA(); 

                }
                break;
            case 3 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:31: SELECT
                {
                mSELECT(); 

                }
                break;
            case 4 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:38: INSERT
                {
                mINSERT(); 

                }
                break;
            case 5 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:45: UPDATE
                {
                mUPDATE(); 

                }
                break;
            case 6 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:52: DELETE
                {
                mDELETE(); 

                }
                break;
            case 7 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:59: FROM
                {
                mFROM(); 

                }
                break;
            case 8 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:64: WHERE
                {
                mWHERE(); 

                }
                break;
            case 9 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:70: VALUES
                {
                mVALUES(); 

                }
                break;
            case 10 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:77: SET
                {
                mSET(); 

                }
                break;
            case 11 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:81: ASTERISK
                {
                mASTERISK(); 

                }
                break;
            case 12 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:90: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 13 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:96: DOT
                {
                mDOT(); 

                }
                break;
            case 14 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:100: OPEN
                {
                mOPEN(); 

                }
                break;
            case 15 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:105: CLOSE
                {
                mCLOSE(); 

                }
                break;
            case 16 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:111: QUESTION
                {
                mQUESTION(); 

                }
                break;
            case 17 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:120: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 18 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:126: LT
                {
                mLT(); 

                }
                break;
            case 19 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:129: GT
                {
                mGT(); 

                }
                break;
            case 20 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:132: LTGT
                {
                mLTGT(); 

                }
                break;
            case 21 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:137: NOT
                {
                mNOT(); 

                }
                break;
            case 22 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:141: IS
                {
                mIS(); 

                }
                break;
            case 23 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:144: NULL
                {
                mNULL(); 

                }
                break;
            case 24 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:149: AND
                {
                mAND(); 

                }
                break;
            case 25 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:153: OR
                {
                mOR(); 

                }
                break;
            case 26 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:156: IN
                {
                mIN(); 

                }
                break;
            case 27 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:159: COUNT
                {
                mCOUNT(); 

                }
                break;
            case 28 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:165: SUM
                {
                mSUM(); 

                }
                break;
            case 29 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:169: AVG
                {
                mAVG(); 

                }
                break;
            case 30 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:173: MAX
                {
                mMAX(); 

                }
                break;
            case 31 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:177: MIN
                {
                mMIN(); 

                }
                break;
            case 32 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:181: LIKE
                {
                mLIKE(); 

                }
                break;
            case 33 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:186: TO_CHAR
                {
                mTO_CHAR(); 

                }
                break;
            case 34 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:194: TO_DATE
                {
                mTO_DATE(); 

                }
                break;
            case 35 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:202: TRUNC
                {
                mTRUNC(); 

                }
                break;
            case 36 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:208: BETWEEN
                {
                mBETWEEN(); 

                }
                break;
            case 37 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:216: SYSDATE
                {
                mSYSDATE(); 

                }
                break;
            case 38 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:224: ORDER_BY
                {
                mORDER_BY(); 

                }
                break;
            case 39 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:233: ASC
                {
                mASC(); 

                }
                break;
            case 40 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:237: DESC
                {
                mDESC(); 

                }
                break;
            case 41 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:242: GROUP_BY
                {
                mGROUP_BY(); 

                }
                break;
            case 42 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:251: HAVING
                {
                mHAVING(); 

                }
                break;
            case 43 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:258: DISTINCT
                {
                mDISTINCT(); 

                }
                break;
            case 44 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:267: OUTER
                {
                mOUTER(); 

                }
                break;
            case 45 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:273: ATTRIBUTTE_ACCESS
                {
                mATTRIBUTTE_ACCESS(); 

                }
                break;
            case 46 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:291: IDENT
                {
                mIDENT(); 

                }
                break;
            case 47 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:297: INTCONS
                {
                mINTCONS(); 

                }
                break;
            case 48 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:305: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 49 :
                // D:\\entornotrabajo\\workspace-sgo\\persistance\\src\\main\\java\\es\\caser\\persistance\\sql\\antlr\\SQLGrammar.g:1:313: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\3\uffff\7\36\3\uffff\1\57\3\uffff\1\61\1\uffff\12\36\3\uffff\1"+
        "\42\1\101\1\uffff\3\36\1\107\1\110\6\36\4\uffff\5\36\1\126\11\36"+
        "\1\uffff\1\36\1\141\1\142\2\36\2\uffff\7\36\1\154\1\36\1\156\1\157"+
        "\1\160\1\36\1\uffff\1\36\1\163\1\164\7\36\2\uffff\4\36\1\u0081\1"+
        "\36\1\u0083\2\36\1\uffff\1\u0086\3\uffff\2\36\2\uffff\1\u0089\13"+
        "\36\1\uffff\1\36\1\uffff\1\u0096\1\36\1\uffff\1\36\1\u0099\1\uffff"+
        "\2\36\1\u009c\3\36\1\u00a0\2\36\1\u00a3\2\36\1\uffff\1\u00a6\2\uffff"+
        "\2\36\1\uffff\1\36\1\uffff\1\u00aa\1\uffff\1\u00ab\3\uffff\1\36"+
        "\1\uffff\1\u00ad\1\u00ae\1\u00af\2\uffff\1\u00b0\4\uffff";
    static final String DFA6_eofS =
        "\u00b1\uffff";
    static final String DFA6_minS =
        "\1\11\2\uffff\1\145\1\156\1\160\1\145\1\162\1\150\1\141\3\uffff"+
        "\1\53\3\uffff\1\76\1\uffff\1\157\1\156\1\162\1\157\1\141\1\151\1"+
        "\157\1\145\1\162\1\141\3\uffff\1\12\1\11\1\uffff\1\154\1\155\1\163"+
        "\2\44\1\144\1\154\1\163\1\157\1\145\1\154\4\uffff\1\164\1\154\1"+
        "\144\1\147\1\143\1\44\1\165\1\170\1\156\1\153\1\137\1\165\1\164"+
        "\1\157\1\166\1\uffff\1\145\2\44\1\144\1\145\2\uffff\1\141\1\145"+
        "\1\143\1\164\1\155\1\162\1\165\1\44\1\154\3\44\1\145\1\uffff\1\156"+
        "\2\44\1\145\1\143\1\156\1\167\1\165\1\151\1\143\2\uffff\1\141\1"+
        "\162\2\164\1\44\1\151\1\44\2\145\1\uffff\1\44\3\uffff\1\162\1\164"+
        "\2\uffff\1\44\1\150\1\141\1\143\1\145\1\160\1\156\3\164\2\145\1"+
        "\uffff\1\156\1\uffff\1\44\1\163\1\uffff\1\40\1\44\1\uffff\1\141"+
        "\1\164\1\44\1\145\1\40\1\147\1\44\1\145\1\40\1\44\1\40\1\143\1\uffff"+
        "\1\44\2\uffff\1\162\1\145\1\uffff\1\156\1\uffff\1\44\1\uffff\1\44"+
        "\3\uffff\1\164\1\uffff\3\44\2\uffff\1\44\4\uffff";
    static final String DFA6_maxS =
        "\1\ufaff\2\uffff\1\171\1\163\1\160\1\151\1\162\1\150\1\141\3\uffff"+
        "\1\53\3\uffff\1\76\1\uffff\1\165\1\166\1\162\1\157\2\151\1\162\1"+
        "\145\1\162\1\141\3\uffff\1\12\1\40\1\uffff\1\164\1\155\1\163\2\ufaff"+
        "\1\144\2\163\1\157\1\145\1\154\4\uffff\1\164\1\154\1\144\1\147\1"+
        "\143\1\ufaff\1\165\1\170\1\156\1\153\1\137\1\165\1\164\1\157\1\166"+
        "\1\uffff\1\145\2\ufaff\1\144\1\145\2\uffff\1\141\1\145\1\143\1\164"+
        "\1\155\1\162\1\165\1\ufaff\1\154\3\ufaff\1\145\1\uffff\1\156\2\ufaff"+
        "\1\145\1\144\1\156\1\167\1\165\1\151\1\143\2\uffff\1\141\1\162\2"+
        "\164\1\ufaff\1\151\1\ufaff\2\145\1\uffff\1\ufaff\3\uffff\1\162\1"+
        "\164\2\uffff\1\ufaff\1\150\1\141\1\143\1\145\1\160\1\156\3\164\2"+
        "\145\1\uffff\1\156\1\uffff\1\ufaff\1\163\1\uffff\1\40\1\ufaff\1"+
        "\uffff\1\141\1\164\1\ufaff\1\145\1\40\1\147\1\ufaff\1\145\1\40\1"+
        "\ufaff\1\40\1\143\1\uffff\1\ufaff\2\uffff\1\162\1\145\1\uffff\1"+
        "\156\1\uffff\1\ufaff\1\uffff\1\ufaff\3\uffff\1\164\1\uffff\3\ufaff"+
        "\2\uffff\1\ufaff\4\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\7\uffff\1\13\1\14\1\15\1\uffff\1\17\1\20\1\21"+
        "\1\uffff\1\23\12\uffff\1\55\1\56\1\57\2\uffff\1\61\13\uffff\1\54"+
        "\1\16\1\24\1\22\17\uffff\1\60\5\uffff\1\32\1\26\15\uffff\1\31\12"+
        "\uffff\1\12\1\34\11\uffff\1\25\1\uffff\1\30\1\35\1\47\2\uffff\1"+
        "\36\1\37\14\uffff\1\50\1\uffff\1\7\2\uffff\1\27\2\uffff\1\40\14"+
        "\uffff\1\10\1\uffff\1\46\1\33\2\uffff\1\43\1\uffff\1\51\1\uffff"+
        "\1\3\1\uffff\1\4\1\5\1\6\1\uffff\1\11\3\uffff\1\52\1\45\1\uffff"+
        "\1\41\1\42\1\44\1\53";
    static final String DFA6_specialS =
        "\u00b1\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\42\1\41\2\uffff\1\40\22\uffff\1\42\3\uffff\1\36\2\uffff"+
            "\1\1\1\15\1\16\1\12\1\uffff\1\13\1\uffff\1\14\1\uffff\12\37"+
            "\1\35\1\uffff\1\21\1\20\1\22\1\17\1\uffff\32\36\4\uffff\1\36"+
            "\1\uffff\1\24\1\32\1\26\1\6\1\36\1\7\1\33\1\34\1\4\2\36\1\30"+
            "\1\27\1\23\1\25\3\36\1\3\1\31\1\5\1\11\1\10\3\36\1\2\104\uffff"+
            "\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff\u0150\36\u0170"+
            "\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff\u5200\36\u5900"+
            "\uffff\u0200\36",
            "",
            "",
            "\1\43\17\uffff\1\44\3\uffff\1\45",
            "\1\46\4\uffff\1\47",
            "\1\50",
            "\1\51\3\uffff\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "",
            "",
            "",
            "\1\56",
            "",
            "",
            "",
            "\1\60",
            "",
            "\1\62\5\uffff\1\63",
            "\1\64\4\uffff\1\66\2\uffff\1\65",
            "\1\67",
            "\1\70",
            "\1\71\7\uffff\1\72",
            "\1\73",
            "\1\74\2\uffff\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "",
            "",
            "",
            "\1\41",
            "\2\42\2\uffff\1\42\22\uffff\1\42",
            "",
            "\1\102\7\uffff\1\103",
            "\1\104",
            "\1\105",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\22"+
            "\36\1\106\7\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36"+
            "\u1040\uffff\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e"+
            "\36\u10d2\uffff\u5200\36\u5900\uffff\u0200\36",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\111",
            "\1\112\6\uffff\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "",
            "",
            "",
            "",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\3"+
            "\36\1\125\26\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08"+
            "\36\u1040\uffff\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e"+
            "\36\u10d2\uffff\u5200\36\u5900\uffff\u0200\36",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "",
            "\1\140",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\143",
            "\1\144",
            "",
            "",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\155",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\161",
            "",
            "\1\162",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\165",
            "\1\166\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "",
            "",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\u0082",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\u0084",
            "\1\u0085",
            "",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "",
            "",
            "",
            "\1\u0087",
            "\1\u0088",
            "",
            "",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "",
            "\1\u0095",
            "",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\u0097",
            "",
            "\1\u0098",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "",
            "\1\u009a",
            "\1\u009b",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\u00a1",
            "\1\u00a2",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\u00a4",
            "\1\u00a5",
            "",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "",
            "",
            "\1\u00a7",
            "\1\u00a8",
            "",
            "\1\u00a9",
            "",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "",
            "",
            "",
            "\1\u00ac",
            "",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "",
            "",
            "\1\36\13\uffff\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32"+
            "\36\105\uffff\27\36\1\uffff\37\36\1\uffff\u1f08\36\u1040\uffff"+
            "\u0150\36\u0170\uffff\u0080\36\u0080\uffff\u092e\36\u10d2\uffff"+
            "\u5200\36\u5900\uffff\u0200\36",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( StringLiteral | SCHEMA | SELECT | INSERT | UPDATE | DELETE | FROM | WHERE | VALUES | SET | ASTERISK | COMMA | DOT | OPEN | CLOSE | QUESTION | EQUAL | LT | GT | LTGT | NOT | IS | NULL | AND | OR | IN | COUNT | SUM | AVG | MAX | MIN | LIKE | TO_CHAR | TO_DATE | TRUNC | BETWEEN | SYSDATE | ORDER_BY | ASC | DESC | GROUP_BY | HAVING | DISTINCT | OUTER | ATTRIBUTTE_ACCESS | IDENT | INTCONS | NEWLINE | WS );";
        }
    }
 

}