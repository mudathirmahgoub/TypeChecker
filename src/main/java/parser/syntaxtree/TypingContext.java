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
}
