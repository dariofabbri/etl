package org.talend.designer.codegen.translators.databases.mysql;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMysqlCommitMainJava
{
  protected static String nl;
  public static synchronized TMysqlCommitMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlCommitMainJava result = new TMysqlCommitMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_3 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_4 = "\");" + NL + "" + NL + "\tif (null == conn_";
  protected final String TEXT_5 = ") {";
  protected final String TEXT_6 = " " + NL + "\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_7 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES); " + NL + "\t\tconn_";
  protected final String TEXT_8 = " = dataSources_";
  protected final String TEXT_9 = ".get(";
  protected final String TEXT_10 = ").getConnection();" + NL + "\t}" + NL + "" + NL + "if(conn_";
  protected final String TEXT_11 = " != null && !conn_";
  protected final String TEXT_12 = ".isClosed())" + NL + "{" + NL + "\tconn_";
  protected final String TEXT_13 = ".commit();";
  protected final String TEXT_14 = NL + "    conn_";
  protected final String TEXT_15 = ".close();";
  protected final String TEXT_16 = NL + "}";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();

    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    boolean close = ("true").equals(ElementParameterParser.getValue(node,"__CLOSE__"));

    String conn = "conn_" + connection;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    	
		INode connectionNode = null; 
		for (INode processNode : node.getProcess().getGeneratingNodes()) { 
			if(connection.equals(processNode.getUniqueName())) { 
				connectionNode = processNode; 
				break; 
			} 
		} 
		String alias = ElementParameterParser.getValue(connectionNode, "__DATASOURCE_ALIAS__"); 

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
      if(close){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
     }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}