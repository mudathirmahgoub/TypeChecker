package parser.syntaxtree;

import typechecker.DerivationRule;
import typechecker.SubBaseRule;
import typechecker.SubsumptionRule;
import typechecker.VariableRule;

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

            //ToDo: handle subtyping with arrow types
            return new VariableRule(judgment, false);
        }

        return new VariableRule(judgment, true);
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
        String premiseTarget = path.get(1);
        Judgment premise1Judgment = new Judgment(judgment.typingContext,
                judgment.term, new BaseType(premiseTarget));
        path.remove(0);
        DerivationRule premise1Rule = buildBaseSubtypingRules(premise1Judgment,
                source , premiseTarget, path);
        SubBaseRule premise2Rule = new SubBaseRule(
                new SubBase(premiseTarget, target), true);

        SubsumptionRule rule = new SubsumptionRule(judgment, true,
                premise1Rule, premise2Rule);

        return rule;
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
