package parser.syntaxtree;

import typechecker.Answer;

public class Application extends Term
{
    public Term function;
    public Term argument;
    public Type annotation;

    @Override
    public Answer check(Type type, TypingContext typingContext)
    {
        throw new UnsupportedOperationException();
    }
}
