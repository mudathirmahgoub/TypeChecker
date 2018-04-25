package parser.syntaxtree;

import java.util.HashMap;
import java.util.Map;

public class TypingContext extends  SystemFSyntaxTree
{
    public Map<String, Type> context = new HashMap<>();
}
