package parser.syntaxtree;

import java.util.HashMap;
import java.util.Map;

public class TypingContext extends SystemFNode
{
    public Map<String, Type> context = new HashMap<>();
}
