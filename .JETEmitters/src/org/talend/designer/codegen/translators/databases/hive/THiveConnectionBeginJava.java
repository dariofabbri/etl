package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class THiveConnectionBeginJava
{
  protected static String nl;
  public static synchronized THiveConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveConnectionBeginJava result = new THiveConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\tjava.lang.Class.forName(\"";
  protected final String TEXT_3 = "\");";
  protected final String TEXT_4 = NL + "\t\t\tString sharedConnectionName_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "\t\t\tconn_";
  protected final String TEXT_7 = " = SharedDBConnection.getDBConnection(\"";
  protected final String TEXT_8 = "\",url_";
  protected final String TEXT_9 = ",userName_";
  protected final String TEXT_10 = " , password_";
  protected final String TEXT_11 = " , sharedConnectionName_";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t\tconn_";
  protected final String TEXT_14 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_15 = ",userName_";
  protected final String TEXT_16 = ",password_";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\t\tconn_";
  protected final String TEXT_19 = ".setAutoCommit(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\t\t\tif(true) {" + NL + "\t\t\t\t\tthrow new Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t\t}";
  protected final String TEXT_22 = NL + "\t\t\t\t\tSystem.setProperty(";
  protected final String TEXT_23 = " ,";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\t\t\t\tSystem.setProperty(\"fs.default.name\", ";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_30 = " + \":\" + ";
  protected final String TEXT_31 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\t\tString url_";
  protected final String TEXT_32 = " = \"jdbc:hive://\";";
  protected final String TEXT_33 = NL + "\t\t\t\tString url_";
  protected final String TEXT_34 = " = \"jdbc:hive://\" + ";
  protected final String TEXT_35 = " + \":\" + ";
  protected final String TEXT_36 = " + \"/\" + ";
  protected final String TEXT_37 = ";";
  protected final String TEXT_38 = NL + "\t\t\tconn_";
  protected final String TEXT_39 = ".setAutoCommit(";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + NL + "\t";
  protected final String TEXT_42 = NL + NL + "\tString userName_";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = ";";
  protected final String TEXT_45 = NL + "\tString password_";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = ";" + NL + "" + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_48 = " = null;" + NL;
  protected final String TEXT_49 = NL + "\t";
  protected final String TEXT_50 = NL + NL + "\tif ((null == globalMap.get(KEY_DB_DATASOURCES)) || \"\".equals(";
  protected final String TEXT_51 = ")) {" + NL + "\t\t";
  protected final String TEXT_52 = NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_54 = "\", conn_";
  protected final String TEXT_55 = ");" + NL + "\t}";
  protected final String TEXT_56 = NL + "\tif (null != conn_";
  protected final String TEXT_57 = ") {" + NL + "\t\t";
  protected final String TEXT_58 = NL + "\t}";
  protected final String TEXT_59 = NL + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_60 = "\",conn_";
  protected final String TEXT_61 = ");" + NL + "" + NL + "\tglobalMap.put(\"db_";
  protected final String TEXT_62 = "\",";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	class DefaultConnectionUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    
	    public void beforeComponentProcess(INode node){
	    }
	    
		public void createURL(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
		
		public void classForName(INode node){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_3);
    
		}
		
		public void useShareConnection(INode node) {
			String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
		}
		
		public void createConnection(INode node) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
		}
		
		public void setAutoCommit(INode node) {
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_20);
    
		}
		
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultUtil class
	
	DefaultConnectionUtil connUtil = new DefaultConnectionUtil();

    

	class ConnectionUtil extends DefaultConnectionUtil{
	
		public void createURL(INode node) {
			super.createURL(node);
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			
			boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
			boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
			List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");

			if(("HDP_1_0".equals(hiveVersion) && "STANDALONE".equals(connectionMode)) || ("APACHE_0_20_203".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("MAPR1".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)) || ("Cloudera_CDH3".equals(hiveVersion) && "EMBEDDED".equals(connectionMode))) {

    stringBuffer.append(TEXT_21);
    
			}
			
			if(hadoopProps.size() > 0){
				for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_24);
    
				} 
			}
			
			if(setMapredJT) {
				String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_25);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_26);
    
			}
			
			if(setNamenode) {
				String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_27);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_28);
    
			}
			
			if("EMBEDDED".equals(connectionMode)) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
			} else {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_37);
    	
			}
		}
		
		public void setAutoCommit(INode node) {
			boolean useTransaction = false;//("true").equals(ElementParameterParser.getValue(node,"__IS_USE_AUTO_COMMIT__"));
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
			if (useTransaction) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_40);
    
			}
		}
		
		public String getDirverClassName(INode node){
			return "org.apache.hadoop.hive.jdbc.HiveDriver";
		}
	}//end class
	
	connUtil = new ConnectionUtil();

    //----------------------------component codes-----------------------------------------
    stringBuffer.append(TEXT_41);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
	
    String cid = node.getUniqueName();
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
    if(dbschema == null||dbschema.trim().length()==0) {
    	 dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
    }
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser = ElementParameterParser.getValue(node, "__USER__");
    String dbpass = ElementParameterParser.getValue(node, "__PASS__");
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    
	boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_SHARED_CONNECTION__"));

    
	connUtil.beforeComponentProcess(node);
	
	connUtil.createURL(node);

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append((dbuser != null && dbuser.trim().length() == 0)? "null":dbuser);
    stringBuffer.append(TEXT_44);
    //the tSQLiteConnection component not contain user and pass return null
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append((dbpass != null && dbpass.trim().length() == 0)? "null":dbpass);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
	if(isUseSharedConnection){

    stringBuffer.append(TEXT_49);
    connUtil.useShareConnection(node);
    
	} else {
		String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_50);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_51);
    connUtil.classForName(node);
    stringBuffer.append(TEXT_52);
    connUtil.createConnection(node);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
	}

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    connUtil.setAutoCommit(node);
    stringBuffer.append(TEXT_58);
    
	connUtil.afterComponentProcess(node);

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(TEXT_64);
    return stringBuffer.toString();
  }
}
