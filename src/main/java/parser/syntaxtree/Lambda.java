package parser.syntaxtree;

import rules.DerivationRule;
import rules.LambdaRule;

public class Lambda extends Term
{
    public String variable;
    public Term term;

    @Override
    public DerivationRule check(Type type, TypingContext typingContext)
    {

        Judgment judgment = new Judgment(typingContext, this, type);

        // for a lambda term, the type should be an arrow type
        if(ArrowType.class != type.getClass())
        {
            return new LambdaRule(judgment,false, null);
        }

        ArrowType arrowType = (ArrowType) type;

        TypingContext premiseTypingContext = new TypingContext(typingContext);

        // add the variable and the domain type to context
        premiseTypingContext.context.put(variable, arrowType.domain);

        // check the premise rule
        DerivationRule premiseAnswer = term.check(arrowType.range, premiseTypingContext);


        LambdaRule rule = new LambdaRule(judgment, premiseAnswer.isDerivable, premiseAnswer);
        return rule;
    }

    @Override
    public String toString()
    {
        return  "λ" + variable + ". " + term;
    }
}
