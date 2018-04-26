package parser.syntaxtree;

import java.util.HashMap;
import java.util.Map;

public class TypingContext extends SystemFNode
{
    public Map<String, Type> context = new HashMap<>();
    public TypingContext() {}

    public TypingContext(TypingContext typingContext)
    {
        this.context = new HashMap<>(typingContext.context);
    }

    @Override
    public String toString()
    {
        if(context.size() == 0)
        {
            return "·";
        }
        else 
        {
            StringBuilder builder  = new StringBuilder();

            for(Map.Entry<String, Type> entry : context.entrySet())
            {
                builder.append(entry.getKey() + ": " + entry.getValue() + ", ");
            }

            String contextString = builder.toString();
            // remove the last comma
            contextString = contextString.substring(0, contextString.length() - 2);

            return contextString;
        }
    }
}
