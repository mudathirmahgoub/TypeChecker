package parser.syntaxtree;

import typechecker.Answer;

import java.util.List;

public class Program extends SystemFNode
{
    public List<SubBase> subBases;
    public Judgment judgment;


    public Answer check()
    {
        return judgment.check();
    }
}
