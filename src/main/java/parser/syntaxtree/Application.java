package parser.syntaxtree;

import printers.LatexPrinter;
import rules.*;


public class Application extends Term
{
    public Term function;
    public Term argument;
    public Type annotation;

    @Override
    public DerivationRule check(Type type, TypingContext typingContext)
    {
        // try the application rule first

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

        //ToDo: review this
        if(answer == DerivationAnswer.Yes)
        {
            return rule;
        }

        if(type.getClass() == ForAllType.class)
        {
            ForAllType forAllType = (ForAllType) type;
            // check if the type variable is not free in the typing context
            if(!typingContext.isFreeType(forAllType.typeVariableName))
            {
                // check the premise rule
                DerivationRule premiseAnswer = this.check(forAllType.type, typingContext);
                return new ForAllIntroduction(judgment, premiseAnswer.isDerivable, premiseAnswer);
            }
            else
            {
                // rename the variable
                String name = SystemFNode.getNewVariableTypeName();
                forAllType = (ForAllType) type.rename(name, forAllType.typeVariableName);

                // check the premise rule
                DerivationRule premiseAnswer = this.check(forAllType, typingContext);
                return new RenamingRule(judgment, premiseAnswer.isDerivable, premiseAnswer);
            }
        }

        //check forall elimination rule
        if(this.eliminationAnnotation != null)
        {
            // try for all elimination rule
            Application term = new Application();
            term.function = this.function;
            term.argument = this.argument;
            term.annotation = this.annotation;
            term.eliminationAnnotation = null;

            // choose a unique name
            String typeVariableName = SystemFNode.getNewVariableTypeName();
            ForAllType premiseType = new ForAllType();
            premiseType.typeVariableName = typeVariableName;
            premiseType.type = Type.replace(type, this.eliminationAnnotation, typeVariableName);

            DerivationRule premiseRule = term.check(premiseType, typingContext);
            return new ForAllElimination(judgment, premiseRule.isDerivable, premiseRule);
        }
        return rule;
    }


    @Override
    public String toString()
    {
        return "(" + function + " "  + argument + ") [" + annotation + "]";
    }
}
