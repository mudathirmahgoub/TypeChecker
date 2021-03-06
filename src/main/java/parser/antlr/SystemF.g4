grammar SystemF;

// parser rules

systemF : (subtype)*  judgment;

subtype : SubBase '(' Identifier ',' Identifier ')' ';' ; 

judgment : typingContext Turnstile term ':' type ';' ;

typingContext : EmptyContext |  (Identifier ':' type) (',' Identifier ':' type)* ;

type :  variableType
        | variableType arrowType
        | forAllType
        | forAllType arrowType
        | '(' type ')'
        | '(' type ')' arrowType;


variableType : Identifier;

forAllType : ForAll Identifier '.' type;

arrowType : Arrow type;

term : variable
	| application
	| lambda
	| variable typeApplication
	| application typeApplication
	| '(' lambda ')' typeApplication
	;

variable : Identifier ;

application : '(' term term ')' '[' type ']';

lambda : Lambda Identifier '.' term;

typeApplication : '[[' type ']]';
// lexer rules

SubBase : 'SubBase' ;

Turnstile : '⊢' | '|-' | '\\vdash' ;

EmptyContext : '.';

ForAll : '\\forall' ;

Arrow : '→' | '->' | '\\rightarrow' | '\\u2192';

Lambda : 'λ' | '\\lambda' ;

Identifier : IdentifierLetter (IdentifierLetter | Digit)* ;

IdentifierLetter : 'a'..'z'|'A'..'Z'|'_' ;

Digit : '0'..'9' ;

WhiteSpace : [ \t\r\n]+ -> skip ;

AnyCharacter : . ;