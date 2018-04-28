package typechecker;

import parser.syntaxtree.SubBase;

public class SubBaseRule extends DerivationRule
{
    public SubBase subBase;

    public SubBaseRule(SubBase subBase, boolean isDerivable)
    {
        this.subBase = subBase;
        this.isDerivable = isDerivable;
    }

    @Override
    public String toString()
    {
        String premiseString =  "SubBase(" + subBase.subType + ", " +
                subBase.superType + ")";
        String conclusionString = subBase.subType + " <: " + subBase.superType;
        int length = Math.max(premiseString.length(), conclusionString.length() );

        String line = new String(new char[length]).replace('\0', '-');

        return premiseString + "\n" + line + "(subBase)" + "\n" + conclusionString;
    }
}
