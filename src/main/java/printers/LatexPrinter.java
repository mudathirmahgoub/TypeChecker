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
        return rule.isDerivable + "\n \\begin{prooftree}\n" +   stringBuilder + "\\end{prooftree}";
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

        if(rule instanceof  ForAllIntroduction)
        {
            visit((ForAllIntroduction)rule);
        }

        if(rule instanceof  RenamingRule)
        {
            visit((RenamingRule)rule);
        }
    }

    private void visit(RenamingRule rule)
    {
        visit(rule.premiseRule);

        String conclusionString = visit(rule.judgment);

        stringBuilder.append("\\RightLabel{\\scriptsize renaming}\n" +
                "\\UnaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(ForAllIntroduction rule)
    {
        visit(rule.premiseRule);

        String conclusionString = visit(rule.judgment);

        stringBuilder.append("\\RightLabel{\\scriptsize introduction}\n" +
                "\\UnaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(ForAllElimination rule)
    {
        visit(rule.premiseRule);

        String conclusionString = visit(rule.judgment);

        stringBuilder.append("\\RightLabel{\\scriptsize elimination}\n" +
                "\\UnaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(ReflexivityTypeRule rule)
    {
        String conclusionString = visit(rule.subtypeJudgment);
        stringBuilder.append("\\AxiomC{} \\RightLabel{\\scriptsize reflexive}\n" +
                " \\UnaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(ArrowTypeRule rule)
    {
        visit(rule.premise1Rule);

        visit(rule.premise2Rule);

        String conclusionString = visit(rule.subtypeJudgment);

        stringBuilder.append("\\RightLabel{\\scriptsize arrow}\n" +
                "\\BinaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(InvalidTypeRule rule)
    {
        String conclusionString = visit(rule.subtypeJudgment);
        stringBuilder.append("\\AxiomC{\\color{red} $\\perp$ \\color{black}} \n" +
                "\\RightLabel{\\scriptsize \\color{red} invalid \\color{black}}\n" +
                "\\UnaryInfC{\\color{red} $" + conclusionString + "$ \\color{black}}\n");
    }

    private void visit(VariableRule rule)
    {
        String conclusionString = visit(rule.judgment);
        if(rule.isDerivable == DerivationAnswer.Yes)
        {
            stringBuilder.append("\\AxiomC{} \\RightLabel{\\scriptsize var}\n" +
                    "\\UnaryInfC{$" + conclusionString + "$}\n");
        }
        else
        {
            if(rule.isDerivable == DerivationAnswer.No)
            {
                stringBuilder.append("\\AxiomC{}\n" +
                        "\\RightLabel{\\color{red} \\scriptsize invalid var}\n" +
                        "\\UnaryInfC{$" + conclusionString + "$ \\color{black}}  \n");
            }
            else
            {
                stringBuilder.append("\\AxiomC{}\n" +
                        "\\RightLabel{\\color{blue} \\scriptsize unknown}\n" +
                        "\\UnaryInfC{$" + conclusionString + "$ \\color{black}}  \n");
            }
        }
    }

    private void visit(ApplicationRule rule)
    {
        visit(rule.premise1Rule);

        visit(rule.premise2Rule);

        String conclusionString = visit(rule.judgment);

        stringBuilder.append("\\RightLabel{\\scriptsize app}\n" +
                "\\BinaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(LambdaRule rule)
    {
        visit(rule.premiseRule);

        String conclusionString = visit(rule.judgment);

        stringBuilder.append("\\RightLabel{$\\lambda$}\n" +
                "\\UnaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(SubsumptionRule rule)
    {
        visit(rule.premise1Rule);

        visit(rule.premise2Rule);

        String conclusionString = visit(rule.judgment);

        stringBuilder.append("\\RightLabel{\\scriptsize subsumption}\n" +
                "\\BinaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(SubBaseRule rule)
    {
        String conclusionString = rule.subBase.subType + " <: " + rule.subBase.superType;
        stringBuilder.append("\\AxiomC{\\scriptsize $SubBase(" + rule.subBase.subType+ ","
                + rule.subBase.superType +")$}\n" +
                "\\RightLabel{\\scriptsize subBase}\n" +
                "\\UnaryInfC{$" + conclusionString + "$}\n");
    }

    private void visit(TransitivityTypeRule rule)
    {
        visit(rule.premise1Rule);

        visit(rule.premise2Rule);

        String conclusionString = visit(rule.subtypeJudgment);

        stringBuilder.append("\\RightLabel{\\scriptsize transitive}\n" +
                "\\BinaryInfC{$" + conclusionString + "$}\n");
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

    private String visit(Variable term)
    {
        return  term.name +
                (term.eliminationAnnotation == null? "":
                        "[[" + visit(term.eliminationAnnotation) + "]]");
    }

    private String visit(Application term)
    {
        return "(" + visit(term.function) + "\\;"  +
                visit(term.argument) + ") [" +
                visit(term.annotation) + "]" +
                (term.eliminationAnnotation == null? "":
                        "[[" + visit(term.eliminationAnnotation) + "]]");
    }

    private String visit(Lambda term)
    {
        return  "(\\lambda " + term.variable + ". " + visit(term.term)+ ")"+
        (term.eliminationAnnotation == null? "":
                "[[" + visit(term.eliminationAnnotation) + "]]");
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
