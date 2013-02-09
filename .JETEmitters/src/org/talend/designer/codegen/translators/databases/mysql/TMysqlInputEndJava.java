package org.talend.designer.codegen.translators.databases.mysql;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMysqlInputEndJava
{
  protected static String nl;
  public static synchronized TMysqlInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlInputEndJava result = new TMysqlInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "}" + NL + "rs_";
  protected final String TEXT_3 = ".close();" + NL + "stmt_";
  protected final String TEXT_4 = ".close();";
  protected final String TEXT_5 = NL + "\t\tconn_";
  protected final String TEXT_6 = ".close();" + NL + "\t\t";
  protected final String TEXT_7 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_8 = "_NB_LINE\",nb_line_";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
	if(!("true").equals(useExistingConn))
	{
		
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
	}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
