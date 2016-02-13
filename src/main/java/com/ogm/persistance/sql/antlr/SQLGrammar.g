grammar SQLGrammar;

@header {
package es.caser.persistance.sql.antlr;
import java.util.List;
import java.util.ArrayList;
}

@lexer::header {
	package es.caser.persistance.sql.antlr;
}

@rulecatch { } 

@members {

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
}

prog:   query+ ;
                
query:   selectStatement
    |    insertStatement
    |	 updateSatement
    ;

selectStatement
	: SELECT { out("select "); } 
 	 (DISTINCT {out(" distinct ");} )?
 	 selectFields
	 from 
	 (where)?
	 (groupby)?
	 (orderby)?
	 (having)?
    ;


insertStatement
	: INSERT { out("insert into "); } 
		tablename open fieldname (comma fieldname)* close 
		VALUES { out(" values "); } 
		questions
    ;

updateSatement
	: UPDATE { out("update "); } 
		tablename
		sets
		(where)?
	;

deleteSatement
	: DELETE { out("delete from "); } 
		tablename
		(where)?
	;
		
selectFields //TODO: hay que mejorar esto
	: 
	 selectFieldDef (comma selectFieldDef)*
	//|selectFieldDef (comma function)*
       // |function ( comma selectFieldDef)*
        //|function ( comma function)*
	;
	
selectFieldDef
	:  (tablename dot)? (fieldname|ASTERISK { out("*"); }) (alias)*
	|  function ( comma selectFieldDef)*
	;
		
from
	: { out(" from "); } FROM tablename ( comma tablename)*
	| { out(" from "); } FROM open selectStatement close
	;
  
where
: { out(" where "); } WHERE logicExpresions
	;	
alias
	:  (a=IDENT{putAlias(a);})
	;
logicExpresions	
	:  logicExpresion (operator logicExpresion) *
	;
logicExpresion
	: detailExpresion  
	| detailExpresion (expression)? detailExpresion
	|  between
	|  detailExpresion IS {out(" is ");} (NOT {out(" not ");} )? NULL {out(" null ");}
	|  detailExpresion IN {out(" in "); } open selectStatement close
	|  OPEN {out(" ( "); } logicExpresions CLOSE {out(" ) "); }
	;
operator
	: AND {out(" and ");}
	| OR {out(" or ");}	
	;

//leftExpresion
//	:(tablename dot)? fieldname
//	| function
//	| intcons
//	| question
//	;
		
detailExpresion
	: question
	| (tablename dot)? fieldname (OUTER {out(" (+) ");} )?
	| sysdate
	| function
	| attributeAccess
	| intcons
	| (l=StringLiteral{out(l);})
	;
sysdate :SYSDATE {out(" sysdate ");}	;	
function 
	: COUNT {out(" count");}	open 
			( (tablename dot)? fieldname  | ASTERISK {out("*");})
					close (alias)?
	| MAX {out(" max");}	open (tablename dot)? fieldname close (alias)?
	| MIN {out(" min");}	open (tablename dot)? fieldname close (alias)?
	| SUM {out(" sum");}	open (tablename dot)? fieldname close (alias)?
	| AVG {out(" avg");}	open (tablename dot)? fieldname close (alias)?	
	| LIKE {out(" like");}	open (l=StringLiteral{out(l);} | question)  close (alias)?
	| TO_DATE {out(" to_date");}	open ( (tablename dot)? fieldname | (l=StringLiteral{out(l);}))
					comma (l=StringLiteral{out(l);}) close	(alias)?	
	| TO_CHAR {out(" to_char");}	open ( (tablename dot)? fieldname | (l=StringLiteral{out(l);}))
					comma (l=StringLiteral{out(l);}) close	(alias)?
	| TRUNC {out(" trunc");}	open ( (tablename dot)? fieldname | (l=StringLiteral{out(l);}))
					comma (l=StringLiteral{out(l);}) close	(alias)?					
	;
between
: ((tablename dot)? fieldname | sysdate) BETWEEN {out(" between ");} detailExpresion AND {out(" and ");} detailExpresion
	;
		
dot
: (DOT {out(".");})
;
expression
	: (EQUAL {out("=");})
	| (LT {out("<");})
	| (GT {out(">");})	
	| (LTGT {out("<>");})
	| (AND {out(" AND ");})	
	| (OR {out(" OR ");})
	;

questions
	: open question (comma question)* close	
;   

sets	: {out("set ");}	
	SET (tablename dot)? fieldname EQUAL{out("=");} question 
		(comma ((tablename dot)? fieldname) EQUAL{out("=");} question)*
	; 
question	: (a=QUESTION{out(" ? ");})
;
intcons	: (a=INTCONS{out(a);})
	;	
open	: (a=OPEN{out("(");})
;
    
close	:(a=CLOSE{out(")");})
;    
comma	:(a=COMMA{out(",");})
;
fieldname
 	: (a=IDENT {fieldName(a);})
	 ;
	 
tablename
 	: (schema dot)?(a=IDENT {tableName(a);})
	 ;
orderby
	: ORDER_BY {out(" order by ");} fieldname (comma fieldname)* 
		(ASC {out(" asc ");} | DESC {out(" desc ");})?
	;
groupby
	: GROUP_BY {out(" group by ");} fieldname (comma fieldname)* 
	;
having
	: HAVING { out(" having "); }	logicExpresions
	;
schema  
	: SCHEMA {putSchema();}
	;	
attributeAccess 
	: ATTRIBUTTE_ACCESS  (a=IDENT {attributeAccess(a);})	
	;
// string literals
StringLiteral
    :  '\'' ( ~('\''|'\\') )* '\''
    ;
SCHEMA	:	'{schema}';
SELECT	:	'select';
INSERT	:	'insert into';
UPDATE  :	'update';
DELETE  :	'delete from';
FROM    :	'from';
WHERE   :	'where';
VALUES 	:	'values';
SET	:	'set';
ASTERISK:	'*';
COMMA   :	',';
DOT     :	'.';
OPEN	:	'(';
CLOSE	:	')';
QUESTION:	'?';
EQUAL   :	'=';
LT	:	'<';
GT	:	'>';
LTGT    :	'<>';
NOT	:	'not';
IS	:	'is';
NULL	:	'null';
AND	:	'and';
OR	:	'or';
IN	:	'in';
COUNT	:	'count';
SUM	:	'sum';
AVG	:	'avg';
MAX	:	'max';
MIN	:	'min';
LIKE	:	'like';
TO_CHAR :	'to_char';
TO_DATE :	'to_date';
TRUNC   :	'trunc';
BETWEEN :	'between';
SYSDATE :	'sysdate';
ORDER_BY:	'order by';
ASC	:	'asc';
DESC	:	'desc';
GROUP_BY:	'group by';
HAVING  :	'having';
DISTINCT:	'distinct';
OUTER	:	'(+)';
ATTRIBUTTE_ACCESS
	:	 ':=';
IDENT  : Letter (Letter|JavaIDDigit)*
    ;
INTCONS
  : ('0'..'9')+
  ;
  
  fragment
Letter
    :  '\u0024' |
       '\u0041'..'\u005a' |
       '\u005f' |
       '\u0061'..'\u007a' |
       '\u00c0'..'\u00d6' |
       '\u00d8'..'\u00f6' |
       '\u00f8'..'\u00ff' |
       '\u0100'..'\u1fff' |
       '\u3040'..'\u318f' |
       '\u3300'..'\u337f' |
       '\u3400'..'\u3d2d' |
       '\u4e00'..'\u9fff' |
       '\uf900'..'\ufaff'
    ;

fragment
JavaIDDigit
    :  '\u0030'..'\u0039' |
       '\u0660'..'\u0669' |
       '\u06f0'..'\u06f9' |
       '\u0966'..'\u096f' |
       '\u09e6'..'\u09ef' |
       '\u0a66'..'\u0a6f' |
       '\u0ae6'..'\u0aef' |
       '\u0b66'..'\u0b6f' |
       '\u0be7'..'\u0bef' |
       '\u0c66'..'\u0c6f' |
       '\u0ce6'..'\u0cef' |
       '\u0d66'..'\u0d6f' |
       '\u0e50'..'\u0e59' |
       '\u0ed0'..'\u0ed9' |
       '\u1040'..'\u1049'
   ;
NEWLINE:'\r'? '\n';
WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;} ;



