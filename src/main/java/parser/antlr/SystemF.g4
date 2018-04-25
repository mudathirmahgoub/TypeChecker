grammar SystemF;

// parser rules

systemF : (subtype)*  judgment;

subtype : SubBase '(' Identifier ',' Identifier ')' ';' ; 

judgment : typingContext Turnstile term ':' type ';' ;

typingContext : EmptyContext |  (Identifier ':' type) (',' Identifier ':' type)* ;

type :  Identifier
        | type Arrow type
        | '(' type ')'
        | ForAll Identifier '.' type ;

term : variable
	| application
	| lambda
	;

variable : Identifier ;

application : '(' term term ')' '[' type ']';

lambda : Lambda '.' term;

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