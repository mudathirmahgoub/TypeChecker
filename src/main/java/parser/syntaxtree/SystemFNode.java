package parser.syntaxtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class SystemFNode
{
    public static Map<String, List<String>> subTypes = new HashMap<>();
    public static List<String> variableTypeNames = new ArrayList<>();

    public static String getNewVariableTypeName()
    {
        String name = "X_";
        int index = 1;
        while(variableTypeNames.contains(name + index))
        {
            index++;
        }
        name = name + index;
        variableTypeNames.add(name);
        return  name;
    }
}
