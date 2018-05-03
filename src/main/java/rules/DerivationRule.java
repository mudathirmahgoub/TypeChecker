package rules;

public class DerivationRule
{
    public DerivationAnswer isDerivable;
    public static DerivationAnswer getAnswer(DerivationAnswer answer1, DerivationAnswer answer2)
    {
        if(answer1 == DerivationAnswer.No || answer2 == DerivationAnswer.No)
        {
            return DerivationAnswer.No;
        }

        if(answer1 == DerivationAnswer.Unknown || answer2 == DerivationAnswer.Unknown)
        {
            return DerivationAnswer.Unknown;
        }

        return DerivationAnswer.Yes;
    }
}
