package parser.syntaxtree;

import typechecker.*;

import java.util.ArrayList;
import java.util.List;

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
        boolean isEqual = contextType.equals(type);
        if(! isEqual)
        {
            return checkSubtypingRules(type, contextType, judgment);
        }

        return new VariableRule(judgment, true);
    }

    private DerivationRule checkSubtypingRules(Type type, Type contextType, Judgment judgment)
    {
        // subtyping only valid for the same type class
        if(contextType.getClass() != type.getClass())
        {
            return new VariableRule(judgment, false);
        }

        // check subtyping for base types
        if(contextType.getClass() == BaseType.class)
        {
            // check if there is a path from the context type to the judgment type
            String source = ((BaseType) contextType).name;
            String target = ((BaseType) type).name;
            List<String> path  = searchPath(source, target);

            if(path.size() == 0) // no subtyping path is found
            {
                return new VariableRule(judgment, false);
            }
            else // there a subtyping path from the source to target
            {
                return buildBaseSubtypingRules(judgment, source, target, path);
            }
        }

        //handle subtyping with arrow types
        if(contextType.getClass() == ArrowType.class)
        {
            ArrowType conextArrowType = (ArrowType) contextType;

            throw new UnsupportedOperationException();
        }

        return new VariableRule(judgment, false);
    }

    private DerivationRule buildBaseSubtypingRules(Judgment judgment, String source, String target, List<String> path)
    {
        if(path.size() == 1)
        {
            Judgment premise1Judgment = new Judgment(judgment.typingContext,
                    judgment.term, new BaseType(source));
            VariableRule premise1Rule = new VariableRule(premise1Judgment,
                    true);
            SubBaseRule premise2Rule = new SubBaseRule(
                    new SubBase(source, target), true);

            SubsumptionRule rule = new SubsumptionRule(judgment, true,
                    premise1Rule, premise2Rule);

            return rule;
        }

        // path size >= 2
        Judgment premise1Judgment = new Judgment(judgment.typingContext,
                judgment.term, new BaseType(source));
        VariableRule premise1Rule = new VariableRule(premise1Judgment,
                true);
        DerivationRule premise2Rule = buildTransitiveRules(source, target, path);
        SubsumptionRule rule = new SubsumptionRule(judgment, true,
                premise1Rule, premise2Rule);

        return rule;
    }

    private DerivationRule buildTransitiveRules(String source, String target, List<String> path)
    {
        if(path.size() == 2)
        {
            SubtypeJudgment subtypeJudgment = new SubtypeJudgment(new BaseType(source),
                    new BaseType(target));
            String middle = path.get(1);
            SubBaseRule premise1Rule = new SubBaseRule(new SubBase(source, middle), true);
            SubBaseRule premise2Rule = new SubBaseRule(new SubBase(middle, target), true);
            TransitivityTypeRule rule = new TransitivityTypeRule(subtypeJudgment, true,
                    premise1Rule, premise2Rule);
            return rule;
        }
        else
        {
            SubtypeJudgment subtypeJudgment = new SubtypeJudgment(new BaseType(source),
                    new BaseType(target));
            String middle = path.get(1);
            path.remove(0);
            DerivationRule premise1Rule = buildTransitiveRules(source, middle,path);
            SubBaseRule premise2Rule = new SubBaseRule(new SubBase(middle, target), true);
            TransitivityTypeRule rule = new TransitivityTypeRule(subtypeJudgment, true,
                    premise1Rule, premise2Rule);
            return rule;
        }
    }

    private List<String> searchPath(String source, String target)
    {
        if(SystemFNode.subTypes.containsKey(source))
        {
            List<String> superTypes = SystemFNode.subTypes.get(source);
            if(superTypes.contains(target))
            {
                List<String> path = new ArrayList<>();
                path.add(target);
                return path;
            }
            for (String superType: superTypes )
            {
                List<String> path = searchPath(superType, target);
                // a path is found
                if (path.size() > 0)
                {
                    path.add(superType);
                    return path;
                }
            }
        }
        return new ArrayList<>();
    }

    @Override
    public String toString()
    {
        return  name;
    }
}
