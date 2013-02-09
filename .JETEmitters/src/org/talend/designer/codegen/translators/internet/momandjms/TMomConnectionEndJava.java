package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMomConnectionEndJava
{
  protected static String nl;
  public static synchronized TMomConnectionEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomConnectionEndJava result = new TMomConnectionEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    //\t\tglobalMap.put(\"producer_";
  protected final String TEXT_3 = "\",producer_";
  protected final String TEXT_4 = ");" + NL + "\t\tglobalMap.put(\"session_";
  protected final String TEXT_5 = "\",session_";
  protected final String TEXT_6 = ");" + NL + "\t\tglobalMap.put(\"connection_";
  protected final String TEXT_7 = "\",connection_";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "// 2012.10.02 Renat asked not to close the connections here." + NL + "//\tSystem.out.println(\"Closing connection\");" + NL + "//\tproducer_";
  protected final String TEXT_10 = ".close();" + NL + "//    session_";
  protected final String TEXT_11 = ".close();" + NL + "//    connection_";
  protected final String TEXT_12 = ".close();";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));

//if (transacted) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
//	} else {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
//	}

    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
