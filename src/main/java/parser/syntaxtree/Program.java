package parser.syntaxtree;

import typechecker.DerivationRule;

import java.util.List;

public class Program extends SystemFNode
{
    public List<SubBase> subBases;
    public Judgment judgment;


    public DerivationRule check()
    {
        return judgment.check();
    }

}
