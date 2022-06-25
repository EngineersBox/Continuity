grammar continuity;

program: statement+;
statement: IfIntEqual | Call;

IfIntEqual: 'ifIntEqual';

Call: 'call' '(' StringLiteral  ')';

StringLiteral: '"' StringCharacters? '"';
fragment StringCharacters: StringCharacter+;
fragment StringCharacter: ~["\\\r\n];

WS: [ \n\t]+ -> skip;