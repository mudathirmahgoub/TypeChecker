package parser.syntaxtree;

import rules.ApplicationRule;
import rules.DerivationAnswer;
import rules.DerivationRule;


public class Application extends Term
{
    public Term function;
    public Term argument;
    public Type annotation;

    @Override
    public DerivationRule check(Type type, TypingContext typingContext)
    {
        // check premise1
        ArrowType arrowType = new ArrowType();
        arrowType.domain = annotation;
        arrowType.range = type;
        DerivationRule premise1Rule = function.check(arrowType, typingContext);

        // check premise2
        DerivationRule premise2Rule = argument.check(annotation, typingContext);

        Judgment judgment = new Judgment(typingContext, this, type);
        DerivationAnswer answer = DerivationRule.getAnswer(premise1Rule.isDerivable,
                premise2Rule.isDerivable);

        ApplicationRule rule = new ApplicationRule(judgment, answer, premise1Rule, premise2Rule);

        return rule;
    }

    @Override
    public String toString()
    {
        return "(" + function + " "  + argument + ") [" + annotation + "]";
    }
}
