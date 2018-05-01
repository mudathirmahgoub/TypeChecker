package printers;

import parser.syntaxtree.*;
import rules.*;

import java.util.Map;

public class LatexPrinter extends AbstractPrinter
{

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public String print(DerivationRule rule)
    {
        visit(rule);
        return "\\begin{prooftree}\n" +   stringBuilder + "\\end{prooftree}";
    }

    private void visit(DerivationRule rule)
    {
        if(rule instanceof VariableRule)
        {
            visit((VariableRule)rule);
        }

        if(rule instanceof ApplicationRule)
        {
            visit((ApplicationRule)rule);
        }

        if(rule instanceof LambdaRule)
        {
            visit((LambdaRule)rule);
        }

        if(rule instanceof SubsumptionRule)
        {
            visit((SubsumptionRule)rule);
        }

        if(rule instanceof  SubBaseRule)
        {
            visit((SubBaseRule)rule);
        }

        if(rule instanceof  TransitivityTypeRule)
        {
            visit((TransitivityTypeRule)rule);
        }

        if(rule instanceof  InvalidTypeRule)
        {
            visit((InvalidTypeRule)rule);
        }

        if(rule instanceof  ArrowTypeRule)
        {
            visit((ArrowTypeRule)rule);
        }

        if(rule instanceof  ReflexivityTypeRule)
        {
            visit((ReflexivityTypeRule)rule);
        }

        if(rule instanceof  ForAllElimination)
        {
            visit((ForAllElimination)rule);
        }

    }

    private void visit(ForAllElimination rule)
    {
        visit(rule.premiseRule);

        String conclusionString = visit(rule.judgment);

        stringBuilder.append("\\RightLabel{\\scriptsize elimination}\\UnaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(ReflexivityTypeRule rule)
    {
        String conclusionString = visit(rule.subtypeJudgment);
        stringBuilder.append("\\AxiomC{} \\RightLabel{\\scriptsize reflexive} \\UnaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(ArrowTypeRule rule)
    {
        visit(rule.premise1Rule);

        visit(rule.premise2Rule);

        String conclusionString = visit(rule.subtypeJudgment);

        stringBuilder.append("\\RightLabel{\\scriptsize arrow} \\BinaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(InvalidTypeRule rule)
    {
        String conclusionString = visit(rule.subtypeJudgment);
        stringBuilder.append("\\AxiomC{\\color{red} $\\perp$ \\color{black}} \\RightLabel{\\scriptsize \\color{red} invalid \\color{black}} \\UnaryInfC{\\color{red} $" + conclusionString + "$ \\color{black}}\n");
    }

    private void visit(VariableRule rule)
    {
        String conclusionString = visit(rule.judgment);
        if(rule.isDerivable)
        {
            stringBuilder.append("\\AxiomC{} \\RightLabel{\\scriptsize var} \\UnaryInfC{$" +
                    conclusionString + "$}\n");
        }
        else
        {
            stringBuilder.append("\\AxiomC{} \\RightLabel{\\color{red} \\scriptsize invalid var} \\UnaryInfC{$" +
                    conclusionString + "$} \\color{black} \n");
        }
    }

    private void visit(ApplicationRule rule)
    {
        visit(rule.premise1Rule);

        visit(rule.premise2Rule);

        String conclusionString = visit(rule.judgment);

        stringBuilder.append("\\RightLabel{\\scriptsize app} \\BinaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(LambdaRule rule)
    {
        visit(rule.premiseRule);

        String conclusionString = visit(rule.judgment);

        stringBuilder.append("\\RightLabel{$\\lambda$}\\UnaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(SubsumptionRule rule)
    {
        visit(rule.premise1Rule);

        visit(rule.premise2Rule);

        String conclusionString = visit(rule.judgment);

        stringBuilder.append("\\RightLabel{\\scriptsize subsumption} \\BinaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(SubBaseRule rule)
    {
        String conclusionString = rule.subBase.subType + " <: " + rule.subBase.superType;
        stringBuilder.append("\\AxiomC{\\scriptsize SubBase($" + rule.subBase.subType+ ","
                + rule.subBase.superType +")$} \\RightLabel{\\scriptsize subBase} \\UnaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(TransitivityTypeRule rule)
    {
        visit(rule.premise1Rule);

        visit(rule.premise2Rule);

        String conclusionString = visit(rule.subtypeJudgment);

        stringBuilder.append("\\RightLabel{\\scriptsize transitive} \\BinaryInfC{$" + conclusionString + "$}\n");
    }

    private String visit(Judgment judgment)
    {
        String string = visit(judgment.typingContext) + " \\vdash " +
                visit(judgment.term) +
                (judgment.term.eliminationAnnotation == null?
                "" : "[" + visit(judgment.term.eliminationAnnotation) +"]"
                ) + " : " +
                visit(judgment.type);
        return string;
    }

    private String visit(SubtypeJudgment judgment)
    {
        String string = visit(judgment.subType) + " <: " +
                        visit(judgment.superType);
        return string;
    }

    private String visit(TypingContext typingContext)
    {
        if(typingContext.context.size() == 0)
        {
            return "\\cdot";
        }
        else
        {
            StringBuilder builder  = new StringBuilder();

            for(Map.Entry<String, Type> entry : typingContext.context.entrySet())
            {
                builder.append(entry.getKey() + ": " + visit(entry.getValue()) + ", ");
            }

            String contextString = builder.toString();
            // remove the last comma
            contextString = contextString.substring(0, contextString.length() - 2);

            return contextString;
        }
    }

    private String visit(Term term)
    {
        if(term instanceof Variable)
        {
            return visit((Variable)term);
        }

        if(term instanceof  Application)
        {
            return visit((Application)term);
        }

        if(term instanceof  Lambda)
        {
            return visit((Lambda)term);
        }

        return null;
    }

    private String visit(Variable variable)
    {
        return  variable.name;
    }

    private String visit(Application application)
    {
        return "(" + visit(application.function) + "\\;"  +
                visit(application.argument) + ") [" +
                visit(application.annotation) + "]";
    }

    private String visit(Lambda lambda)
    {
        return  " \\lambda " + lambda.variable + ". " + visit(lambda.term);
    }

    private String visit(Type type)
    {
        if(type instanceof VariableType)
        {
            return visit((VariableType)type);
        }

        if(type instanceof  ArrowType)
        {
            return visit((ArrowType)type);
        }

        if(type instanceof  ForAllType)
        {
            return visit((ForAllType)type);
        }

        return null;
    }

    private String visit(VariableType type)
    {
        return type.name;
    }

    private String visit(ArrowType type)
    {
        return "(" + visit(type.domain) + " \\rightarrow "  + visit(type.range) + ")";
    }

    private String visit(ForAllType type)
    {
        return "\\forall " + type.typeVariableName + "." + visit(type.type);
    }
}
