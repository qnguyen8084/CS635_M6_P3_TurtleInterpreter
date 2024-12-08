grammar Turtle;

program: statement+;
statement: turtle | forward | backward | left | right | goto | setHeading;

turtle: 'turtle' INT INT INT;
forward: 'forward' INT;
backward: 'backward' INT;
left: 'left' INT;
right: 'right' INT;
goto: 'goto' INT INT;
setHeading: 'setHeading' INT;

INT: '-'?[0-9]+;
WS: [ \t\r\n]+ -> skip;
LINE_COMMENT
    : '//' ~[\r\n]* -> skip
;