package parser.syntaxtree;

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
    public DerivationRule check(Type type, TypingContext typingContext)
    {
        Type contextType = typingContext.context.get(name);
        Judgment judgment = new Judgment(typingContext, this, type);

        // the variable is not declared in the context
        if(contextType == null)
        {
            return new VariableRule(judgment, false);
        }

        // check if the type matches the context type
        boolean isDerivable = contextType.equals(type);
        if(! isDerivable)
        {
            return new VariableRule(judgment, false);
        }

        return new VariableRule(judgment, true);
    }

    @Override
    public String toString()
    {
        return  name;
    }
}
