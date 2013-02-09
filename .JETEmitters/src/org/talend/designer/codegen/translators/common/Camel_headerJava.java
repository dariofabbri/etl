package org.talend.designer.codegen.translators.common;

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Map;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.utils.JavaResourcesHelper;
import org.talend.core.ui.branding.IBrandingService;
import org.talend.core.ui.branding.AbstractBrandingService;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.CodeGeneratorRoutine;
import org.talend.designer.codegen.i18n.Messages;
import org.talend.designer.codegen.ITalendSynchronizer;

public class Camel_headerJava
{
  protected static String nl;
  public static synchronized Camel_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Camel_headerJava result = new Camel_headerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\treturn new RouteBuilder() {" + NL + "\t\t\tpublic void configure() throws Exception {";
  protected final String TEXT_2 = NL + "\t\t\t\t// CXF endpoint for ";
  protected final String TEXT_3 = NL + "\t\t\t\torg.apache.camel.Endpoint ";
  protected final String TEXT_4 = " = endpoint(";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\t\t\t\t// Add Service Locator Service to ";
  protected final String TEXT_7 = NL + "\t\t\t\tif (null != bundleContext) {" + NL + "\t\t\t\t\torg.talend.esb.servicelocator.cxf.LocatorFeature locatorFeature = new org.talend.esb.servicelocator.cxf.LocatorFeature();" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t\t\tjava.util.Map<String, String> slCustomProps_";
  protected final String TEXT_9 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\t\tslCustomProps_";
  protected final String TEXT_11 = ".put(";
  protected final String TEXT_12 = ", ";
  protected final String TEXT_13 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\t\tlocatorFeature.setRequiredEndpointProperties(slCustomProps_";
  protected final String TEXT_16 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t\tlocatorFeature.setAvailableEndpointProperties(slCustomProps_";
  protected final String TEXT_18 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\t";
  protected final String TEXT_20 = NL + NL + "\t\t\t\t\t((org.apache.camel.component.cxf.CxfEndpoint)";
  protected final String TEXT_21 = ").getFeatures().add(locatorFeature);" + NL + "\t\t\t\t}";
  protected final String TEXT_22 = NL + "\t\t\t\t// Add Service Activity Monitor Service to ";
  protected final String TEXT_23 = NL + "\t\t\t\tif (eventFeature != null) {" + NL + "\t\t\t\t\t((org.apache.camel.component.cxf.CxfEndpoint)";
  protected final String TEXT_24 = ").getFeatures().add(eventFeature);" + NL + "\t\t\t\t}";
  protected final String TEXT_25 = NL + "\t\t\t\t\t\torg.apache.camel.spi.AggregationRepository repo_";
  protected final String TEXT_26 = " = new ";
  protected final String TEXT_27 = ";";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\torg.apache.camel.spi.RecoverableAggregationRepository repo_";
  protected final String TEXT_29 = " = new ";
  protected final String TEXT_30 = ";";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_32 = ".setUseRecovery(true);" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_33 = ".setMaximumRedeliveries(";
  protected final String TEXT_34 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_35 = ".setDeadLetterUri(";
  protected final String TEXT_36 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_37 = ".setRecoveryInterval(";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "\t\t\t\t\t\t\torg.apache.camel.component.hawtdb.HawtDBAggregationRepository repo_";
  protected final String TEXT_40 = " = new org.apache.camel.component.hawtdb.HawtDBAggregationRepository(\"";
  protected final String TEXT_41 = "\", ";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\t\torg.apache.camel.component.hawtdb.HawtDBAggregationRepository repo_";
  protected final String TEXT_44 = " = new org.apache.camel.component.hawtdb.HawtDBAggregationRepository(\"";
  protected final String TEXT_45 = "\");";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_47 = ".setUseRecovery(true);" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_48 = ".setMaximumRedeliveries(";
  protected final String TEXT_49 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_50 = ".setDeadLetterUri(";
  protected final String TEXT_51 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_52 = ".setRecoveryInterval(";
  protected final String TEXT_53 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	Vector v = (Vector) codeGenArgument.getArgument();
	IProcess process = (IProcess) v.get(0);
	String version = (String) v.get(1);

	boolean startable = false;
	for (INode node : (List< ? extends INode>)process.getGraphicalNodes()) {
		Object value = node.getPropertyValue("STARTABLE");
		startable = value == null? false:(Boolean)value;
		if(startable){
			break;
		}
	}

	boolean stats = codeGenArgument.isStatistics();

	List< ? extends INode> processNodes = (List< ? extends INode>)process.getGeneratingNodes();

    stringBuffer.append(TEXT_1);
    
	for (INode node : processNodes) {
		if (node.getComponent().getName().equals("cCXF")) {
			IElementParameter param = node.getElementParameter("LABEL");
		   	String cid = node.getUniqueName();
		//  http://jira.talendforge.org/browse/TESB-5241
			/*
		   	 * change to use label + unique to make it unique but readable
		   	 */
			if(param != null && !"__UNIQUE_NAME__".equals(param.getValue())){
				cid = (String)param.getValue()+"_"+cid;	
			}
			String endpointVar = "endpoint_" + node.getUniqueName();
			String uriRef = "uriMap.get(\"" + cid + "\")";

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(uriRef);
    stringBuffer.append(TEXT_5);
    
			String useSL = ElementParameterParser.getValue(node, "__ENABLE_SL__");
			String useSAM = ElementParameterParser.getValue(node, "__ENABLE_SAM__");
			if ("true".equals(useSL)) {
				List<Map<String, String>> customProperties = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__SL_META_DATA__");

    stringBuffer.append(TEXT_6);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_7);
     if (!customProperties.isEmpty()) { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
     for (Map<String, String> custProp : customProperties) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(custProp.get("NAME"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(custProp.get("VALUE"));
    stringBuffer.append(TEXT_13);
     } 
    
							boolean actAsConsumer = false;
							List<? extends IConnection> conns = node.getIncomingConnections();
							if (!conns.isEmpty()) {
								INode source = conns.get(0).getSource();
								if (!("cErrorHandler".equals(source.getComponent().getName())
										&& source.getIncomingConnections().isEmpty())) {
									actAsConsumer = true;
								}
							}

    stringBuffer.append(TEXT_14);
     if (actAsConsumer) { 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
     } else { 
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
     } 
    stringBuffer.append(TEXT_19);
     } 
    stringBuffer.append(TEXT_20);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_21);
    
			}
			//http://jira.talendforge.org/browse/TESB-3850
			String formatType = ElementParameterParser.getValue(node, "__DATAFORMAT__");
			if ("true".equals(useSAM) && !"RAW".equals(formatType)) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_24);
    
			}
		}
	}

    
	for (INode node : processNodes) {
		if (node.isActivate()) {
			if (node.getComponent().getName().equals("cAggregate")) {
				boolean usePersistence = "true".equals(ElementParameterParser.getValue(node, "__USE_PERSISTENCE__"));
				String repository = ElementParameterParser.getValue(node, "__REPOSITORY__");
				if (usePersistence) {
					boolean useRecovery = "true".equals(ElementParameterParser.getValue(node, "__USE_RECOVERY__"));
					String recoveryInterval = ElementParameterParser.getValue(node, "__RECOVERY_INTERVAL__");
					String deadLetterUri = ElementParameterParser.getValue(node, "__DEAD_LETTER_URI__");
					String maximumRedeliveries = ElementParameterParser.getValue(node, "__MAXIMUM_REDELIVERIES__");

					if ("AGGREGATION".equals(repository)) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CUSTOM_REPOSITORY__") );
    stringBuffer.append(TEXT_27);
    
					} else if ("RECOVERABLE".equals(repository)) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CUSTOM_REPOSITORY__") );
    stringBuffer.append(TEXT_30);
    
						if (useRecovery) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(maximumRedeliveries);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(deadLetterUri);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(recoveryInterval);
    stringBuffer.append(TEXT_38);
    
						}
					} else if ("HAWTDB".equals(repository)) {
						boolean usePersistentFile = "true".equals(ElementParameterParser.getValue(node, "__USE_PERSISTENT_FILE__"));
						String persistentFile = ElementParameterParser.getValue(node, "__PERSISTENT_FILENAME__");
						if (usePersistentFile) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(persistentFile);
    stringBuffer.append(TEXT_42);
    
						} else {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_45);
    
						}
						if (useRecovery) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(maximumRedeliveries);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(deadLetterUri);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(recoveryInterval);
    stringBuffer.append(TEXT_53);
    
						}
					}
				}
			}
		}
	}

    return stringBuffer.toString();
  }
}
