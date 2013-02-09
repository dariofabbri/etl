package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class THiveRowBeginJava
{
  protected static String nl;
  public static synchronized THiveRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveRowBeginJava result = new THiveRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "java.sql.Connection conn_";
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = " " + NL + "\t\tSystem.setProperty(\"java.io.tmpdir\", ";
  protected final String TEXT_5 = "); ";
  protected final String TEXT_6 = NL + "\t\tconn_";
  protected final String TEXT_7 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_8 = "\");" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t\t\tif(true) {" + NL + "\t\t\t\tthrow new Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t}";
  protected final String TEXT_10 = NL + "\t\t\t\tSystem.setProperty(";
  protected final String TEXT_11 = " ,";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\t\t\tSystem.setProperty(\"fs.default.name\", ";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_18 = " + \":\" + ";
  protected final String TEXT_19 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\tString url_";
  protected final String TEXT_20 = " = \"jdbc:hive://\";";
  protected final String TEXT_21 = NL + "\t\t\tString url_";
  protected final String TEXT_22 = " = \"jdbc:hive://\" + ";
  protected final String TEXT_23 = " + \":\" + ";
  protected final String TEXT_24 = " + \"/\" + ";
  protected final String TEXT_25 = ";";
  protected final String TEXT_26 = NL + "\t\tString dbUser_";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ";" + NL + "\t\tString dbPwd_";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = ";    " + NL + "\t\tjava.lang.Class.forName(\"";
  protected final String TEXT_31 = "\");" + NL + "\t\tconn_";
  protected final String TEXT_32 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_33 = ", dbUser_";
  protected final String TEXT_34 = ", dbPwd_";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL;
  protected final String TEXT_37 = NL + "        if(conn_";
  protected final String TEXT_38 = ".getAutoCommit()) {" + NL + "            conn_";
  protected final String TEXT_39 = ".setAutoCommit(false);" + NL + "        }        " + NL + "        int commitEvery_";
  protected final String TEXT_40 = " = ";
  protected final String TEXT_41 = ";" + NL + "        int commitCounter_";
  protected final String TEXT_42 = " = 0;";
  protected final String TEXT_43 = NL;
  protected final String TEXT_44 = NL + "\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_45 = " = conn_";
  protected final String TEXT_46 = ".prepareStatement(";
  protected final String TEXT_47 = ");\t";
  protected final String TEXT_48 = NL + "\tjava.sql.Statement stmt_";
  protected final String TEXT_49 = " = conn_";
  protected final String TEXT_50 = ".createStatement();";
  protected final String TEXT_51 = NL + "String query_";
  protected final String TEXT_52 = " = \"\";" + NL + "boolean whetherReject_";
  protected final String TEXT_53 = " = false;";
  protected final String TEXT_54 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
    String commitEvery = "0";//ElementParameterParser.getValue(node, "__COMMIT_EVERY__");//hive jdbc not support setAutoCommit
    String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	dbquery = dbquery.replaceAll("\n"," ");
	dbquery = dbquery.replaceAll("\r"," ");
    
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	boolean setTempPath = "true".equals(ElementParameterParser.getValue(node, "__SET_TEMP_PATH__")); 
	if(setTempPath) { 
		String tempPath = ElementParameterParser.getValue(node, "__TEMP_PATH__"); 

    stringBuffer.append(TEXT_4);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_5);
     
	} 
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;;
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_8);
    
	} else {
		String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
		String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
		boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
		boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
		List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
		
		if(("HDP_1_0".equals(hiveVersion) && "STANDALONE".equals(connectionMode)) || ("APACHE_0_20_203".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("MAPR1".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("Cloudera_CDH3".equals(hiveVersion) && "EMBEDDED".equals(connectionMode))) {

    stringBuffer.append(TEXT_9);
    
		}
		
		if(hadoopProps.size() > 0){
			for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_12);
    
			} 
		}
			
		if(setMapredJT) {
			String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_13);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_14);
    
		}
		
		if(setNamenode) {
			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_15);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_16);
    
		}		
		
		if("EMBEDDED".equals(connectionMode)) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
		} else {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_25);
    
		}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
	}	

    stringBuffer.append(TEXT_36);
    
if(!("true").equals(useExistingConn)) {
    if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
        
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
    }
}

    stringBuffer.append(TEXT_43);
    
	if (usePrepareStatement ) {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_47);
    
	} else {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    
	}

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(TEXT_54);
    return stringBuffer.toString();
  }
}
