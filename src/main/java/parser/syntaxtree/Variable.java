package parser.syntaxtree;

import typechecker.Answer;
import typechecker.DerivationRule;
import typechecker.VariableRule;

public class Variable extends Term
{
    public String name;
    public Variable(String name)
    {
        this.name = name;
    }

    @Override
    public Answer check(Type type, TypingContext typingContext)
    {
        Type contextType = typingContext.context.get(name);

        // the variable is not declared in the context
        if(contextType == null)
        {
            return new Answer(false);
        }

        // check if the type matches the context type
        boolean isDerivable = contextType.equals(type);
        if(! isDerivable)
        {
            return new Answer(false);
        }

        Judgment judgment = new Judgment(typingContext, this, type);
        DerivationRule node = new VariableRule(judgment);
        return new Answer(true, node);
    }
}
