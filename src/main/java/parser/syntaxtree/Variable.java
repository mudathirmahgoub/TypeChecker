package parser.syntaxtree;

import rules.*;

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
        if(isEqual)
        {
            return new VariableRule(judgment, true);
        }
        else
        {
            if(contextType.getClass() == ForAllType.class || type.getClass() == ForAllType.class )
            {
                if(contextType.getClass() == ForAllType.class && type.getClass() == ForAllType.class )
                {
                    // both types are ForAllType and (isEqual = false) => (isDerivable = false)
                    return new VariableRule(judgment, false);
                }
                //ToDo: check forall rules
                if(contextType.getClass() == ForAllType.class)
                {
                    if(this.eliminationAnnotation != null)
                    {
                        // try for all elimination rule
                        Term term = new Variable(this.name);
                        term.eliminationAnnotation = null;

                        // choose a unique name
                        String typeVariableName = SystemFNode.getNewVariableTypeName();
                        ForAllType premiseType = new ForAllType();
                        premiseType.typeVariableName = typeVariableName;
                        premiseType.type = Type.replace(type, this.eliminationAnnotation, typeVariableName);

                        DerivationRule premiseRule = term.check(premiseType, typingContext);
                        return new ForAllElimination(judgment, premiseRule.isDerivable, premiseRule);
                    }

                }
                throw new UnsupportedOperationException();
            }

            // return a subsumption rule
            Judgment premise1Judgment = new Judgment(judgment.typingContext,
                    judgment.term, contextType);
            VariableRule premise1Rule = new VariableRule(premise1Judgment,
                    true);
            SubtypeRule premise2Rule = checkSubtypingRules(contextType, type);

            SubsumptionRule rule = new SubsumptionRule(judgment,
                    premise1Rule.isDerivable && premise2Rule.isDerivable,
                    premise1Rule, premise2Rule);
            return rule;
        }
    }

    private SubtypeRule checkSubtypingRules(Type subType, Type superType)
    {
        // subtyping only valid for the same type class
        if(subType.getClass() != superType.getClass())
        {
            return new InvalidTypeRule(new SubtypeJudgment(subType, superType));
        }

        // if types are equal, use the reflexive rule

        if(subType.equals(superType))
        {
            return new ReflexivityTypeRule(subType);
        }


        // check subtyping for base types
        if(subType.getClass() == VariableType.class)
        {
            // check if there is a path from the context type to the judgment type
            String source = ((VariableType) subType).name;
            String target = ((VariableType) superType).name;

            List<String> path  = searchPath(source, target);

            if(path.size() == 0) // no subtyping path is found
            {
                return new InvalidTypeRule(new SubtypeJudgment(subType, superType));
            }
            else // there a subtyping path from the source to the target
            {
                return buildBaseSubtypingRules(source, target, path);
            }
        }
        else //handle subtyping with arrow types
        {
            ArrowType source = (ArrowType) subType;
            ArrowType target = (ArrowType) superType;

            SubtypeRule rule = buildArrowSubtypingRules(source, target);
            return rule;
        }
    }

    private SubtypeRule buildArrowSubtypingRules(ArrowType source, ArrowType target)
    {

        SubtypeRule premise1Rule, premise2Rule ;

        // check the type of the domains
        if(source.domain.getClass() != target.domain.getClass())
        {
            premise1Rule = new InvalidTypeRule(new SubtypeJudgment(source.domain, target.domain));
        }
        else
        {
            // reverse the order for the domains
            premise1Rule = checkSubtypingRules(target.domain, source.domain);
        }

        // check the type of the ranges
        if(source.range.getClass() != target.range.getClass())
        {
            premise2Rule = new InvalidTypeRule(new SubtypeJudgment(source.range, target.range));
        }
        else
        {
            premise2Rule = checkSubtypingRules(source.range, target.range);
        }

        SubtypeJudgment judgment = new SubtypeJudgment(source, target);
        ArrowTypeRule rule = new ArrowTypeRule(judgment,
                premise1Rule.isDerivable && premise2Rule.isDerivable,
                premise1Rule, premise2Rule);
        return rule;
    }


    private SubtypeRule buildBaseSubtypingRules(String source, String target, List<String> path)
    {
        if(path.size() == 1)
        {
            // the source is a subtype of the target
            SubBaseRule rule = new SubBaseRule(
                    new SubBase(source, target), true);
            return rule;
        }
        // path size >= 2
        SubtypeRule rule = buildTransitiveRules(source, target, path);
        return rule;
    }

    private SubtypeRule buildTransitiveRules(String source, String target, List<String> path)
    {
        if(path.size() == 2)
        {
            SubtypeJudgment subtypeJudgment = new SubtypeJudgment(new VariableType(source),
                    new VariableType(target));
            String middle = path.get(1);
            SubBaseRule premise1Rule = new SubBaseRule(new SubBase(source, middle), true);
            SubBaseRule premise2Rule = new SubBaseRule(new SubBase(middle, target), true);
            TransitivityTypeRule rule = new TransitivityTypeRule(subtypeJudgment, true,
                    premise1Rule, premise2Rule);
            return rule;
        }
        else
        {
            SubtypeJudgment subtypeJudgment = new SubtypeJudgment(new VariableType(source),
                    new VariableType(target));
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
