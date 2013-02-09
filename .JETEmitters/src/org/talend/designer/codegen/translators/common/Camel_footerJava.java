package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.JavaResourcesHelper;
import java.util.Vector;
import java.util.List;
import java.util.Map;

public class Camel_footerJava
{
  protected static String nl;
  public static synchronized Camel_footerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Camel_footerJava result = new Camel_footerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t\t}" + NL + "\t\t\t};" + NL + "\t\t}\t" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t* create a fully configured CameContext and add into map" + NL + "\t\t* the Registry of it is #TalendRouteRegistry" + NL + "\t\t* @return " + NL + "\t\t*\t\t<code>key: ";
  protected final String TEXT_2 = "-ctx<code>" + NL + "\t\t*       <code>value: DefaultCamelContext<code>" + NL + "\t\t* " + NL + "\t\t*/" + NL + "\t\tpublic Map<String, CamelContext> getCamelContextMap() {" + NL + "\t\t\tMap<String,CamelContext> answer = new HashMap<String, CamelContext>();" + NL + "\t\t\tDefaultCamelContext camelContext = camelContext();";
  protected final String TEXT_3 = NL + "\t\t\t    ";
  protected final String TEXT_4 = NL + "\t\t\tTalendRouteRegistry contextRegister = new TalendRouteRegistry(camelContext.getRegistry());" + NL + "\t\t\tcamelContext.setRegistry(contextRegister);";
  protected final String TEXT_5 = NL + "\t\t\t\t\tcontextRegister.register(";
  protected final String TEXT_6 = ", new ";
  protected final String TEXT_7 = "(";
  protected final String TEXT_8 = "));";
  protected final String TEXT_9 = NL + "\t\t\t\t{" + NL + "\t\t\t\t\tObject beanInstance = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\tif(beanInstance != null){" + NL + "\t\t\t\t\t\tcontextRegister.register(";
  protected final String TEXT_11 = ", beanInstance);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_12 = NL + "\t\t\t\tcontextRegister.register(";
  protected final String TEXT_13 = ", new ";
  protected final String TEXT_14 = "(";
  protected final String TEXT_15 = "));";
  protected final String TEXT_16 = NL + "\t\t\t\t{" + NL + "\t\t\t\tjavax.jms.ConnectionFactory jmsConnectionFactory = new org.apache.activemq.ActiveMQConnectionFactory(";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\t\t\torg.apache.activemq.pool.PooledConnectionFactory pooledConnectionFactory_";
  protected final String TEXT_19 = " " + NL + "\t\t\t\t\t= new org.apache.activemq.pool.PooledConnectionFactory();" + NL + "\t\t\t\tpooledConnectionFactory_";
  protected final String TEXT_20 = ".setConnectionFactory(jmsConnectionFactory);" + NL + "\t\t\t\tpooledConnectionFactory_";
  protected final String TEXT_21 = ".setExpiryTimeout(";
  protected final String TEXT_22 = "L);" + NL + "\t\t\t\tpooledConnectionFactory_";
  protected final String TEXT_23 = ".setIdleTimeout(";
  protected final String TEXT_24 = ");" + NL + "\t\t\t\tpooledConnectionFactory_";
  protected final String TEXT_25 = ".setMaxConnections(";
  protected final String TEXT_26 = ");" + NL + "\t\t\t\tpooledConnectionFactory_";
  protected final String TEXT_27 = ".setMaximumActive(";
  protected final String TEXT_28 = ");" + NL + "\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_29 = "," + NL + "\t\t\t\t\torg.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_30 = "(pooledConnectionFactory_";
  protected final String TEXT_31 = "));\t";
  protected final String TEXT_32 = "\t\t\t\t" + NL + "\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_33 = "," + NL + "\t\t\t\t\torg.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_34 = "(jmsConnectionFactory));";
  protected final String TEXT_35 = NL + "\t\t\t\t}";
  protected final String TEXT_36 = NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\tjavax.jms.ConnectionFactory jmsConnectionFactory = new com.ibm.mq.jms.MQQueueConnectionFactory();" + NL + "\t       \t\t\t((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setHostName(";
  protected final String TEXT_37 = ");" + NL + "\t       \t\t\ttry {" + NL + "\t       \t\t\t\t((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setPort(";
  protected final String TEXT_38 = ");" + NL + "\t       \t\t\t\t((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setTransportType(";
  protected final String TEXT_39 = ");" + NL + "\t       \t\t\t\t((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setQueueManager(";
  protected final String TEXT_40 = ");\t" + NL + "\t       \t\t\t} catch (javax.jms.JMSException e) {" + NL + "\t\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t}";
  protected final String TEXT_41 = NL + "\t\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_42 = "," + NL + "\t\t\t\t\t\torg.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_43 = "(jmsConnectionFactory));";
  protected final String TEXT_44 = NL + "\t\t\t\t\torg.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter connectionFactoryAdapter";
  protected final String TEXT_45 = " " + NL + "\t\t\t\t\t\t\t= new org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter();" + NL + "       \t\t\t\tconnectionFactoryAdapter";
  protected final String TEXT_46 = ".setUsername(";
  protected final String TEXT_47 = ");" + NL + "      \t\t\t\tconnectionFactoryAdapter";
  protected final String TEXT_48 = ".setPassword(";
  protected final String TEXT_49 = ");" + NL + "       \t\t\t\tconnectionFactoryAdapter";
  protected final String TEXT_50 = ".setTargetConnectionFactory(jmsConnectionFactory);" + NL + "       " + NL + "\t\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_51 = "," + NL + "\t\t\t\t\t\torg.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_52 = "(connectionFactoryAdapter";
  protected final String TEXT_53 = "));";
  protected final String TEXT_54 = NL + "\t\t\t\t\t}";
  protected final String TEXT_55 = NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t  javax.jms.ConnectionFactory jmsConnectionFactory;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_57 = "," + NL + "\t\t\t\t\t\t\torg.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_58 = "(jmsConnectionFactory));" + NL + "\t\t\t\t\t}";
  protected final String TEXT_59 = NL + "\t\t\t//using Route name as CamelContext ID" + NL + "\t\t\tanswer.put(\"";
  protected final String TEXT_60 = "\", camelContext);" + NL + "\t\t\tcamelContext.setName(\"";
  protected final String TEXT_61 = "\");" + NL + "\t\t\treturn answer;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t* create a simple DefaultCamelContext " + NL + "\t\t* please use #getCamelContextMap() to get a fully configured CamelContext" + NL + "\t\t* @return DefaultCamelContext" + NL + "\t\t*/" + NL + "\t\tpublic DefaultCamelContext camelContext() {" + NL + "\t\t\t\t\t\t\tDefaultCamelContext camelContext;";
  protected final String TEXT_62 = NL + "\t\t\t\tif (bundleContext != null) {" + NL + "\t\t\t\t\tCamelContextFactory factory = new CamelContextFactory();" + NL + "\t\t\t\t\tfactory.setBundleContext(bundleContext);" + NL + "\t\t\t\t\tcamelContext = factory.createContext();" + NL + "\t\t\t\t\tbundleContext.registerService(CamelContext.class.getName(), camelContext, null);" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tcamelContext = new DefaultCamelContext();" + NL + "\t\t\t\t}";
  protected final String TEXT_63 = NL + "\t\t\t\tcamelContext = new DefaultCamelContext();";
  protected final String TEXT_64 = NL + "\t\t\treturn camelContext;" + NL + "\t\t}";
  protected final String TEXT_65 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	 Vector v = (Vector) codeGenArgument.getArgument();
	IProcess process = (IProcess)v.get(0);
	
	String jobFolderName = JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
	String packageName = codeGenArgument.getCurrentProjectName().toLowerCase() + "." + jobFolderName;
	
	boolean stats = codeGenArgument.isStatistics();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_2);
    		
			//process cConfig components first 
			List<? extends INode> camelContextNodes = process.getNodesOfType("cConfig");
			for(INode node: camelContextNodes){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CODE__"));
    
			} 

    stringBuffer.append(TEXT_4);
    
			//then process cBeanRegister components
			List<? extends INode> beanRegisterNodes = process.getNodesOfType("cBeanRegister");
			if(beanRegisterNodes != null && beanRegisterNodes.size()>0){
			for(INode node: beanRegisterNodes){
				String id = ElementParameterParser.getValue(node, "__ID__");
				String isSimple = ElementParameterParser.getValue(node, "__SIMPLE_CONFIG__");
				String classQualifiedName = ElementParameterParser.getValue(node, "__CLASS_QUALIFIED_NAME__");
				String hasArguments = ElementParameterParser.getValue(node, "__SPECIFY_ARGUMENTS__");
				List<Map<String, String>> arguments = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ARGUMENTS__");
				
				String code = ElementParameterParser.getValue(node, "__CODE__");
				
				if("true".equals(isSimple)){
					StringBuilder sb = new StringBuilder();
					if("true".equals(hasArguments)){
						for(Map<String, String> s: arguments){
							if(sb.length() == 0){
								sb.append(s.get("VALUE"));
							}else{
								sb.append(",");
								sb.append(s.get("VALUE"));
							}
						}
					}

    stringBuffer.append(TEXT_5);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(classQualifiedName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(sb.toString());
    stringBuffer.append(TEXT_8);
    
				}else{

    stringBuffer.append(TEXT_9);
    stringBuffer.append(code);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_11);
    
				}
			}
			}
			
			//after, process cDataset 
			List<? extends INode> datasetNodes = process.getNodesOfType("cDataset");
			for(INode n: datasetNodes){
				String beanID = ElementParameterParser.getValue(n, "__DATASET_NAME__");
				String registerNewBean = ElementParameterParser.getValue(n, "__REGISTER_DATASET_BEAN__");
				if(!"true".equals(registerNewBean)){
					continue;
				}
				String beanClass = ElementParameterParser.getValue(n, "__BEAN_CLASS__");
				List<Map<String, String>> beanArguments = (List<Map<String, String>>) ElementParameterParser.getObjectValue(n, "__BEAN_ARGUMENTS__");
				StringBuilder sb = new StringBuilder();
				if(beanArguments != null){
					for(Map<String,String> map: beanArguments){
						if(sb.length() == 0){
							sb.append(map.get("VALUE"));
						}else{
							sb.append(",");
							sb.append(map.get("VALUE"));
						}
					}
				}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(beanID);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(beanClass);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(sb.toString());
    stringBuffer.append(TEXT_15);
    
			}
            //cJMSConnectionFactory http://jira.talendforge.org/browse/TESB-4860
			List<? extends INode> jmsCFNodes = process.getNodesOfType("cJMSConnectionFactory");
			for(INode node: jmsCFNodes){
				//Use transaction http://jira.talendforge.org/browse/TESB-5160 By LiXiaopeng
				String useTransaction = ElementParameterParser.getValue(node, "__USE_TRANSACTION__");
				String transactedMethodStr = "";
				if("true".equals(useTransaction)){
					transactedMethodStr = "Transacted";
				}
			
				//Component Name
				String name = node.getUniqueName().replace("_", "");
				name = "\"" + name + "\"";
				    // ElementParameterParser.getValue(node, "__NAME__").trim();
    				//Remove unnecessary subfix
    				//name += "+";
    				//name += ElementParameterParser.getValue(node, "__SUBFIX__").trim();
			
				//ActiveMQ
				String mqType = ElementParameterParser.getValue(node, "__MQ_TYPE__");
				if("ActiveMQ".equals(mqType)){
					String amqUri = ElementParameterParser.getValue(node, "__AMQ_BROKER_URI__").trim();
					

    stringBuffer.append(TEXT_16);
    stringBuffer.append(amqUri);
    stringBuffer.append(TEXT_17);
    
				String amqPool = ElementParameterParser.getValue(node, "__AMQ_POOL__").trim();
				if("true".equals(amqPool)){
				     String amq_pool_max_connections = ElementParameterParser.getValue(node, "__AMQ_POOL_MAX_CONNECTIONS__").trim();
				     String amq_pool_max_active = ElementParameterParser.getValue(node, "__AMQ_POOL_MAX_ACTIVE__").trim();
				     String amq_pool_idle_timeout = ElementParameterParser.getValue(node, "__AMQ_POOL_IDLE_TIMEOUT__").trim();
				     String amq_pool_expiry_timeout = ElementParameterParser.getValue(node, "__AMQ_POOL_EXPIRY_TIMEOUT__").trim();
				     
				     if(amq_pool_max_connections.startsWith("\"")){
						 amq_pool_max_connections = amq_pool_max_connections.substring(1);
					 }
					 if(amq_pool_max_connections.endsWith("\"")){
						 amq_pool_max_connections = amq_pool_max_connections.substring(0, amq_pool_max_connections.length() - 1);
					 }
				     if(amq_pool_max_active.startsWith("\"")){
						 amq_pool_max_active = amq_pool_max_active.substring(1);
					 }
					 if(amq_pool_max_active.endsWith("\"")){
						 amq_pool_max_active = amq_pool_max_active.substring(0, amq_pool_max_active.length() - 1);
					 }
				     if(amq_pool_idle_timeout.startsWith("\"")){
						 amq_pool_idle_timeout = amq_pool_idle_timeout.substring(1);
					 }
					 if(amq_pool_idle_timeout.endsWith("\"")){
						 amq_pool_idle_timeout = amq_pool_idle_timeout.substring(0, amq_pool_idle_timeout.length() - 1);
					 }
				     if(amq_pool_expiry_timeout.startsWith("\"")){
						 amq_pool_expiry_timeout = amq_pool_expiry_timeout.substring(1);
					 }
					 if(amq_pool_expiry_timeout.endsWith("\"")){
						 amq_pool_expiry_timeout = amq_pool_expiry_timeout.substring(0, amq_pool_expiry_timeout.length() - 1);
					 }

    stringBuffer.append(TEXT_18);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(amq_pool_expiry_timeout);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(amq_pool_idle_timeout);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(amq_pool_max_connections);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(amq_pool_max_active);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_31);
    
					 
				}else{

    stringBuffer.append(TEXT_32);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_34);
    				
				    }

    stringBuffer.append(TEXT_35);
    
				}else if("WebSphere MQ".equals(mqType)){
					String wmqServer = ElementParameterParser.getValue(node, "__WQM_SEVER__");
					String wmqPort = ElementParameterParser.getValue(node, "__WMQ_PORT__");
					String wmqTransportType = ElementParameterParser.getValue(node, "__WMQ_TRANSPORT_TYPE__");
					String wmqUM = ElementParameterParser.getValue(node, "__WMQ_QUEUE_MANAGER__");
					
					//Username and password, http://jira.talendforge.org/browse/TESB-4073
					String username = ElementParameterParser.getValue(node, "__WMQ_USERNAME__");
					String password = ElementParameterParser.getValue(node, "__WMQ_PASSWORD__");
					String useAuth = ElementParameterParser.getValue(node, "__WMQ_AUTH__");
					
					if(wmqPort.startsWith("\"")){
						wmqPort = wmqPort.substring(1);
					}
					if(wmqPort.endsWith("\"")){
						wmqPort = wmqPort.substring(0, wmqPort.length() - 1);
					}
					if(wmqTransportType.startsWith("\"")){
						wmqTransportType = wmqTransportType.substring(1);
					}
					if(wmqTransportType.endsWith("\"")){
						wmqTransportType = wmqTransportType.substring(0, wmqTransportType.length() - 1);
					}
					

    stringBuffer.append(TEXT_36);
    stringBuffer.append(wmqServer);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(wmqPort);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(wmqTransportType);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(wmqUM);
    stringBuffer.append(TEXT_40);
    
					if("false".equals(useAuth)){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_43);
    					
					}else{

    stringBuffer.append(TEXT_44);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_53);
    						
					}					

    stringBuffer.append(TEXT_54);
    
				}else if("Other".equals(mqType)){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(ElementParameterParser.getValue(node, "__OTHER_CODE__"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_58);
    
				}
			
			}

			//http://jira.talendforge.org/browse/TESB-4087: Change CamelContext name

    stringBuffer.append(TEXT_59);
    stringBuffer.append(process.getName() + "-ctx");
    stringBuffer.append(TEXT_60);
    stringBuffer.append(process.getName() + "-ctx");
    stringBuffer.append(TEXT_61);
    
			boolean startable = false;
			for (INode node : (List< ? extends INode>)process.getGraphicalNodes()) {
				Object value = node.getPropertyValue("STARTABLE");
				startable = value == null? false:(Boolean)value;
				if(startable){
					break;
				}
			}
			
			if (startable) { 

    stringBuffer.append(TEXT_62);
    
			} else {

    stringBuffer.append(TEXT_63);
    
			}

    stringBuffer.append(TEXT_64);
    stringBuffer.append(TEXT_65);
    return stringBuffer.toString();
  }
}
