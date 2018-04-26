grammar SystemF;

// parser rules

systemF : (subtype)*  judgment;

subtype : SubBase '(' Identifier ',' Identifier ')' ';' ; 

judgment : typingContext Turnstile term ':' type ';' ;

typingContext : EmptyContext |  (Identifier ':' type) (',' Identifier ':' type)* ;

type :  baseType
        | baseType arrowType
        | forAllType
        | forAllType arrowType
        | '(' type ')'
        | '(' type ')' arrowType;


baseType : Identifier;

forAllType : ForAll Identifier '.' type;

arrowType : Arrow type;

term : variable
	| application
	| lambda
	;

variable : Identifier ;

application : '(' term term ')' '[' type ']';

lambda : Lambda Identifier '.' term;

// lexer rules

SubBase : 'SubBase' ;

Turnstile : '⊢' | '|-' | '\\vdash' ;

EmptyContext : '.'; 

ForAll : '\\forall' ;

Arrow : '→' | '->' | '\\rightarrow';

Lambda : 'λ' | '\\lambda' ;

Identifier : IdentifierLetter (IdentifierLetter | Digit)* ;

IdentifierLetter : 'a'..'z'|'A'..'Z'|'_' ;

Digit : '0'..'9' ;

LineComment : '%' .*? '\n' -> skip ;

WhiteSpace : [ \t\r]+ -> skip ;

AnyCharacter : . ;