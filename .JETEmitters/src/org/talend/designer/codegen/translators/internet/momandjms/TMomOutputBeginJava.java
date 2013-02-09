package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMomOutputBeginJava
{
  protected static String nl;
  public static synchronized TMomOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomOutputBeginJava result = new TMomOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.util.Hashtable props_";
  protected final String TEXT_3 = "=new java.util.Hashtable();" + NL;
  protected final String TEXT_4 = NL + "            javax.jms.Connection connection_";
  protected final String TEXT_5 = " = null;" + NL + "\t    javax.jms.Session session_";
  protected final String TEXT_6 = " = null;" + NL + "            try {" + NL + "\t        connection_";
  protected final String TEXT_7 = " = (javax.jms.Connection) globalMap.get(\"connection_";
  protected final String TEXT_8 = "\");" + NL + "                connection_";
  protected final String TEXT_9 = ".start();" + NL + "\t\tsession_";
  protected final String TEXT_10 = " = (javax.jms.Session) globalMap.get(\"session_";
  protected final String TEXT_11 = "\");" + NL + "\t\t} catch (NullPointerException npe) {" + NL + "\t\t    throw new RuntimeException(\"";
  protected final String TEXT_12 = " still not initialized. Try to redesign job.\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tjavax.jms.Destination des_";
  protected final String TEXT_13 = ";";
  protected final String TEXT_14 = NL + "\t\t\tdes_";
  protected final String TEXT_15 = " = session_";
  protected final String TEXT_16 = ".createQueue(";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t    \tdes_";
  protected final String TEXT_19 = " = session_";
  protected final String TEXT_20 = ".createTopic(";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + " " + NL + "\t\t    javax.jms.MessageProducer producer_";
  protected final String TEXT_23 = " = session_";
  protected final String TEXT_24 = ".createProducer(des_";
  protected final String TEXT_25 = ");" + NL + "\t\t";
  protected final String TEXT_26 = NL + "\t\t\tproducer_";
  protected final String TEXT_27 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);";
  protected final String TEXT_28 = NL + "\t\t\tproducer_";
  protected final String TEXT_29 = ".setDeliveryMode(javax.jms.DeliveryMode.PERSISTENT);";
  protected final String TEXT_30 = NL + "\t\t\tglobalMap.put(\"producer_";
  protected final String TEXT_31 = "\",producer_";
  protected final String TEXT_32 = ");" + NL + "\t\t\tglobalMap.put(\"session_";
  protected final String TEXT_33 = "\",session_";
  protected final String TEXT_34 = ");" + NL + "\t\t\tglobalMap.put(\"connection_";
  protected final String TEXT_35 = "\",connection_";
  protected final String TEXT_36 = ");" + NL + "" + NL + "\t\t";
  protected final String TEXT_37 = NL + "        \ttry {   // For rollback" + NL + "\t\t";
  protected final String TEXT_38 = NL + "\t\t    ";
  protected final String TEXT_39 = NL + "\t\t\tprops_";
  protected final String TEXT_40 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,\"org.jnp.interfaces.NamingContextFactory\");" + NL + "\t\t\tprops_";
  protected final String TEXT_41 = ".put(javax.naming.Context.PROVIDER_URL, ";
  protected final String TEXT_42 = "+\":\"+";
  protected final String TEXT_43 = ");" + NL + "\t\t\tprops_";
  protected final String TEXT_44 = ".put(\"java.naming.rmi.security.manager\", \"yes\");" + NL + "\t\t\t" + NL + "\t\t\tjavax.naming.Context context_";
  protected final String TEXT_45 = "=new javax.naming.InitialContext(props_";
  protected final String TEXT_46 = ");" + NL + "\t\t\tjavax.jms.ConnectionFactory factory_";
  protected final String TEXT_47 = NL + "\t\t\t\t= (javax.jms.ConnectionFactory)context_";
  protected final String TEXT_48 = ".lookup(\"ConnectionFactory\");\t" + NL + "\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\tString url_";
  protected final String TEXT_50 = " =\"\";" + NL;
  protected final String TEXT_51 = NL + "\t\t\turl_";
  protected final String TEXT_52 = " = \"failover:(\";" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_54 = " = url_";
  protected final String TEXT_55 = " +\",\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_57 = " = url_";
  protected final String TEXT_58 = " +\"tcp://\";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_59 = " = url_";
  protected final String TEXT_60 = " +";
  protected final String TEXT_61 = ";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_62 = " = url_";
  protected final String TEXT_63 = " +\":\";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_64 = " = url_";
  protected final String TEXT_65 = " +";
  protected final String TEXT_66 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\turl_";
  protected final String TEXT_68 = " = url_";
  protected final String TEXT_69 = " +\")?randomize=false\";" + NL + "\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\turl_";
  protected final String TEXT_71 = " = \"tcp://\"+";
  protected final String TEXT_72 = "+\":\"+";
  protected final String TEXT_73 = ";" + NL + "\t\t\t";
  protected final String TEXT_74 = "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\tSystem.out.println(\"Connecting to URL: \" + url_";
  protected final String TEXT_75 = ");" + NL + "\t\t\tSystem.out.println(\"Producing \" + (";
  protected final String TEXT_76 = " ? \"topic\" : \"queue\") + \": \" + ";
  protected final String TEXT_77 = ");" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\torg.apache.activemq.ActiveMQConnectionFactory factory_";
  protected final String TEXT_78 = " = " + NL + "\t\t\t\tnew org.apache.activemq.ActiveMQConnectionFactory(url_";
  protected final String TEXT_79 = ");";
  protected final String TEXT_80 = "\t" + NL + "\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\tjavax.jms.Connection connection_";
  protected final String TEXT_82 = " = factory_";
  protected final String TEXT_83 = ".createConnection();";
  protected final String TEXT_84 = NL + "\t\t\tjavax.jms.Connection connection_";
  protected final String TEXT_85 = " = factory_";
  protected final String TEXT_86 = ".createConnection(";
  protected final String TEXT_87 = ",";
  protected final String TEXT_88 = ");";
  protected final String TEXT_89 = NL + "\t\t\t" + NL + "\t\tconnection_";
  protected final String TEXT_90 = ".start();" + NL + "\t" + NL + "\t\tjavax.jms.Session session_";
  protected final String TEXT_91 = " = connection_";
  protected final String TEXT_92 = ".createSession(";
  protected final String TEXT_93 = ", javax.jms.Session.";
  protected final String TEXT_94 = ");" + NL + "\t\t" + NL + "\t\tjavax.jms.Destination des_";
  protected final String TEXT_95 = ";";
  protected final String TEXT_96 = NL + "\t\t\tdes_";
  protected final String TEXT_97 = " = session_";
  protected final String TEXT_98 = ".createQueue(";
  protected final String TEXT_99 = ");";
  protected final String TEXT_100 = NL + "\t    \tdes_";
  protected final String TEXT_101 = " = session_";
  protected final String TEXT_102 = ".createTopic(";
  protected final String TEXT_103 = ");";
  protected final String TEXT_104 = NL + "\t\tjavax.jms.MessageProducer producer_";
  protected final String TEXT_105 = " = session_";
  protected final String TEXT_106 = ".createProducer(des_";
  protected final String TEXT_107 = ");" + NL + "\t\t";
  protected final String TEXT_108 = NL + "\t\t\tproducer_";
  protected final String TEXT_109 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);";
  protected final String TEXT_110 = NL + "\t\t\tproducer_";
  protected final String TEXT_111 = ".setDeliveryMode(javax.jms.DeliveryMode.PERSISTENT);";
  protected final String TEXT_112 = NL + NL + "\t\t\tglobalMap.put(\"producer_";
  protected final String TEXT_113 = "\",producer_";
  protected final String TEXT_114 = ");" + NL + "\t\t\tglobalMap.put(\"session_";
  protected final String TEXT_115 = "\",session_";
  protected final String TEXT_116 = ");" + NL + "\t\t\tglobalMap.put(\"connection_";
  protected final String TEXT_117 = "\",connection_";
  protected final String TEXT_118 = ");" + NL + "" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_119 = NL + "        \ttry {   // For rollback" + NL + "\t\t";
  protected final String TEXT_120 = NL + "\t    props_";
  protected final String TEXT_121 = ".put(\"hostname\", ";
  protected final String TEXT_122 = ");" + NL + "\t    props_";
  protected final String TEXT_123 = ".put(\"port\", Integer.valueOf(";
  protected final String TEXT_124 = "));" + NL + "\t    props_";
  protected final String TEXT_125 = ".put(\"channel\", ";
  protected final String TEXT_126 = ");" + NL + "\t    props_";
  protected final String TEXT_127 = ".put(\"CCSID\", new Integer(1208));" + NL + "\t    props_";
  protected final String TEXT_128 = ".put(\"transport\", \"MQSeries\");" + NL + "\t    " + NL + "\t    ";
  protected final String TEXT_129 = NL + "\t\t\tcom.ibm.mq.MQEnvironment.sslCipherSuite = \"";
  protected final String TEXT_130 = "\";" + NL + "\t\t";
  protected final String TEXT_131 = NL + "\t\t\tprops_";
  protected final String TEXT_132 = ".put(\"userID\",";
  protected final String TEXT_133 = ");" + NL + "\t\t\tprops_";
  protected final String TEXT_134 = ".put(\"password\",";
  protected final String TEXT_135 = ");" + NL + "\t\t";
  protected final String TEXT_136 = NL + "\t" + NL + "\t\tcom.ibm.mq.MQQueueManager qMgr_";
  protected final String TEXT_137 = " = new com.ibm.mq.MQQueueManager(";
  protected final String TEXT_138 = ", props_";
  protected final String TEXT_139 = ");" + NL + "\t    com.ibm.mq.MQQueue remoteQ_";
  protected final String TEXT_140 = " = qMgr_";
  protected final String TEXT_141 = ".accessQueue(";
  protected final String TEXT_142 = ", 16);" + NL + "\t    com.ibm.mq.MQPutMessageOptions opM_";
  protected final String TEXT_143 = " = new com.ibm.mq.MQPutMessageOptions();";
  protected final String TEXT_144 = "\t" + NL + "\t\topM_";
  protected final String TEXT_145 = ".options=opM_";
  protected final String TEXT_146 = ".options+com.ibm.mq.MQC.MQGMO_SYNCPOINT;";
  protected final String TEXT_147 = NL + "\t";
  protected final String TEXT_148 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

        boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
        String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");

	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String host=ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port=ElementParameterParser.getValue(node, "__SERVERPORT__");
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
	String to = ElementParameterParser.getValue(node, "__TO__");
	String deliverMode = ElementParameterParser.getValue(node, "__DELIVERY_MODE__");
	
	boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	
	boolean failover =  ("true").equals(ElementParameterParser.getValue(node, "__FAILOVER__"));
	List<Map<String,String>> servers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SERVERS__");

	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
		
	String strHost = null;
	String strPort = null;

	IMetadataTable metadata=null;
	List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			metadata = metadatas.get(0);
		}

        boolean isCommitRollback = (!node.getProcess().getNodesOfType("tMomCommit").isEmpty()
	|| !node.getProcess().getNodesOfType("tMomRollback").isEmpty());

        if (isUseSharedConnection) {
		for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
			if (pNode.getUniqueName().equals(connectionComponentName)) {
				transacted = "true".equals(ElementParameterParser.getValue(pNode, "__IS_TRANSACTED__")); 
				serverType=ElementParameterParser.getValue(pNode, "__SERVER__");
                           	failover =  ("true").equals(ElementParameterParser.getValue(pNode, "__FAILOVER__"));
			}	
		}
	}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
          if (isUseSharedConnection) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
		if (("Queue").equals(msgType)) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_17);
    
		} else {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_21);
    
		}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
		if ("N_PERSISTENT".equals(deliverMode)) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    
		} else if ("PERSISTENT".equals(deliverMode)) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
		}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    if(!isCommitRollback && transacted){
    stringBuffer.append(TEXT_37);
    
		}
		
    stringBuffer.append(TEXT_38);
          } else if (("JBoss").equals(serverType) || ("ActiveMQ").equals(serverType)) {// server judgement
	
	/*---------------------------------------1.initial jms connection factry---------------------------------*/ 
		if(("JBoss").equals(serverType)){ 

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
		}else if(("ActiveMQ").equals(serverType) || isUseSharedConnection) {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    if(failover){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    
				int i=0;
				for(Map<String, String> serversMap : servers) {
					strHost = serversMap.get("SERVERS_HOST");
					strPort = serversMap.get("SERVERS_PORT");

					if(i>0) {
					
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    
					}
					
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(strHost);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(strPort);
    stringBuffer.append(TEXT_66);
    
					i++;
				}
				
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    }else{
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(!("Queue").equals(msgType));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    
		}
		
		/*---------------------------------------2.create Queue Or Topic from connection ---------------------------------*/ 

    stringBuffer.append(TEXT_80);
                   if(dbuser == null || ("\"\"").equals(dbuser) || ("").equals(dbuser)) { 
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    		} else { 
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_88);
    		} 
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(transacted);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(acknowledgmentMode);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    
		if (("Queue").equals(msgType)) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_99);
    
		} else {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_103);
    
		}

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    
		if ("N_PERSISTENT".equals(deliverMode)) {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    
		} else if ("PERSISTENT".equals(deliverMode)) {

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    
		}

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    if(!isCommitRollback && transacted){
    stringBuffer.append(TEXT_119);
    
		}
		
    
	}else{ //server judgement   /***WebSphere MQ*****/
		String channel=ElementParameterParser.getValue(node, "__CHANNEL__");
		String qm=ElementParameterParser.getValue(node, "__QM__");
		String queue = ElementParameterParser.getValue(node, "__QUEUE__");
		boolean needSSLCipher = ("true").equals(ElementParameterParser.getValue(node,"__SET_MQ_SSL_CIPHER__"));
		String sslCipher = ElementParameterParser.getValue(node, "__MQ_SSL_CIPHER__");

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(channel);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
		if(needSSLCipher){
		
    stringBuffer.append(TEXT_129);
    stringBuffer.append(sslCipher);
    stringBuffer.append(TEXT_130);
    
		}
		if(!(dbuser == null) && !("\"\"").equals(dbuser) && !("").equals(dbuser)) {
		
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_135);
    
		}
		
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(qm);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    	    
	    if (transacted) {

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
	    }
	}

    stringBuffer.append(TEXT_147);
    stringBuffer.append(TEXT_148);
    return stringBuffer.toString();
  }
}
