package parser.syntaxtree;

import typechecker.Answer;

abstract public class Term extends SystemFNode
{
    public abstract Answer check(Type type, TypingContext typingContext);
}
