package org.talend.designer.codegen.translators.esb.rest;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TRESTClientMainJava
{
  protected static String nl;
  public static synchronized TRESTClientMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRESTClientMainJava result = new TRESTClientMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + NL + "try {" + NL + "\t// request body" + NL + "\torg.dom4j.Document requestDoc_";
  protected final String TEXT_4 = " = null;" + NL + "\tString requestString_";
  protected final String TEXT_5 = " = null;" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\tif (null != ";
  protected final String TEXT_7 = ".body) {" + NL + "\t\t\trequestDoc_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ".body.getDocument();" + NL + "\t\t}" + NL + "\t\trequestString_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ".string;" + NL + "\t";
  protected final String TEXT_12 = NL + NL + "\tObject requestBody_";
  protected final String TEXT_13 = " = requestDoc_";
  protected final String TEXT_14 = " != null ? requestDoc_";
  protected final String TEXT_15 = " : requestString_";
  protected final String TEXT_16 = ";" + NL + "" + NL + "\t// expected response body" + NL + "\tObject responseDoc_";
  protected final String TEXT_17 = " = null;" + NL + "\tClass<?> responseClass_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = "String.class";
  protected final String TEXT_20 = "org.dom4j.Document.class";
  protected final String TEXT_21 = ";" + NL + "" + NL + "\t// create web client instance" + NL + "\torg.apache.cxf.jaxrs.client.JAXRSClientFactoryBean factoryBean_";
  protected final String TEXT_22 = " =" + NL + "\t\tnew org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean();" + NL + "\tfactoryBean_";
  protected final String TEXT_23 = ".setAddress(";
  protected final String TEXT_24 = ");" + NL + "\t";
  protected final String TEXT_25 = NL + "\t\tfactoryBean_";
  protected final String TEXT_26 = ".setUsername(";
  protected final String TEXT_27 = ");" + NL + "\t\tfactoryBean_";
  protected final String TEXT_28 = ".setPassword(";
  protected final String TEXT_29 = ");" + NL + "\t";
  protected final String TEXT_30 = NL + NL + "\tjava.util.List<Object> providers_";
  protected final String TEXT_31 = " = new java.util.ArrayList<Object>();" + NL + "\tproviders_";
  protected final String TEXT_32 = ".add(new org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider() {" + NL + "\t    // workaround for https://jira.talendforge.org/browse/TESB-7276" + NL + "        public org.dom4j.Document readFrom(Class<org.dom4j.Document> cls," + NL + "                                           java.lang.reflect.Type type," + NL + "                                           java.lang.annotation.Annotation[] anns, " + NL + "                                           javax.ws.rs.core.MediaType mt," + NL + "                                           javax.ws.rs.core.MultivaluedMap<String, String> headers, " + NL + "                                           java.io.InputStream is) throws IOException, javax.ws.rs.WebApplicationException {" + NL + "            String contentLength = headers.getFirst(\"Content-Length\"); " + NL + "            if (!org.apache.cxf.common.util.StringUtils.isEmpty(contentLength)" + NL + "                && Integer.valueOf(contentLength) <= 0) {" + NL + "                try {" + NL + "                    return org.dom4j.DocumentHelper.parseText(\"<root/>\");" + NL + "                } catch (org.dom4j.DocumentException e) {" + NL + "                    e.printStackTrace();" + NL + "                }" + NL + "                return null;" + NL + "            }" + NL + "            return super.readFrom(cls, type, anns, mt, headers, is);" + NL + "        }" + NL + "    });" + NL + "\torg.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider_";
  protected final String TEXT_33 = " =" + NL + "\t\tnew org.apache.cxf.jaxrs.provider.json.JSONProvider();" + NL + "\tjsonProvider_";
  protected final String TEXT_34 = ".setIgnoreNamespaces(true);" + NL + "    jsonProvider_";
  protected final String TEXT_35 = ".setAttributesToElements(true); " + NL + "    jsonProvider_";
  protected final String TEXT_36 = ".setSupportUnwrapped(true);" + NL + "    jsonProvider_";
  protected final String TEXT_37 = ".setWrapperName(\"root\");" + NL + "\tproviders_";
  protected final String TEXT_38 = ".add(jsonProvider_";
  protected final String TEXT_39 = ");" + NL + "\tfactoryBean_";
  protected final String TEXT_40 = ".setProviders(providers_";
  protected final String TEXT_41 = ");" + NL + "\tfactoryBean_";
  protected final String TEXT_42 = ".setTransportId(\"http://cxf.apache.org/transports/http\");" + NL + "" + NL + "\torg.apache.cxf.jaxrs.client.WebClient webClient_";
  protected final String TEXT_43 = " = factoryBean_";
  protected final String TEXT_44 = ".createWebClient();" + NL + "" + NL + "\t// set connection properties" + NL + "\torg.apache.cxf.transport.http.HTTPConduit conduit_";
  protected final String TEXT_45 = " =" + NL + "\torg.apache.cxf.jaxrs.client.WebClient.getConfig(webClient_";
  protected final String TEXT_46 = ").getHttpConduit();" + NL + "\tconduit_";
  protected final String TEXT_47 = ".getClient().setReceiveTimeout((long)(";
  protected final String TEXT_48 = " * 1000));" + NL + "\tconduit_";
  protected final String TEXT_49 = ".getClient().setConnectionTimeout((long)(";
  protected final String TEXT_50 = " * 1000));" + NL + "\t";
  protected final String TEXT_51 = NL + "\t\tconduit_";
  protected final String TEXT_52 = ".getClient().setProxyServer(";
  protected final String TEXT_53 = ");" + NL + "\t\tconduit_";
  protected final String TEXT_54 = ".getClient().setProxyServerPort(Integer.valueOf(";
  protected final String TEXT_55 = "));" + NL + "\t\tconduit_";
  protected final String TEXT_56 = ".getProxyAuthorization().setUserName(";
  protected final String TEXT_57 = ");" + NL + "\t\tconduit_";
  protected final String TEXT_58 = ".getProxyAuthorization().setPassword(";
  protected final String TEXT_59 = ");" + NL + "\t";
  protected final String TEXT_60 = NL + NL + "\t// set Content-Type" + NL + "\t";
  protected final String TEXT_61 = NL + "\t\twebClient_";
  protected final String TEXT_62 = ".type(\"";
  protected final String TEXT_63 = "\");" + NL + "\t";
  protected final String TEXT_64 = NL + "\t// set Accept-Type" + NL + "\t";
  protected final String TEXT_65 = NL + "\t\twebClient_";
  protected final String TEXT_66 = ".accept(\"";
  protected final String TEXT_67 = "\");" + NL + "\t";
  protected final String TEXT_68 = NL + NL + "\t// set optional query and header properties if any" + NL + "\t";
  protected final String TEXT_69 = NL + "\t\twebClient_";
  protected final String TEXT_70 = ".header(";
  protected final String TEXT_71 = " ,";
  protected final String TEXT_72 = ");" + NL + "\t";
  protected final String TEXT_73 = NL + NL + "\t// if FORM request then capture query parameters into Form, otherwise set them as queries" + NL + "\t";
  protected final String TEXT_74 = NL + "\t\torg.apache.cxf.jaxrs.ext.form.Form form_";
  protected final String TEXT_75 = " = new org.apache.cxf.jaxrs.ext.form.Form();" + NL + "\t\t";
  protected final String TEXT_76 = NL + "\t\t\tform_";
  protected final String TEXT_77 = ".set(";
  protected final String TEXT_78 = " ,";
  protected final String TEXT_79 = ");" + NL + "\t\t";
  protected final String TEXT_80 = NL + "\t\trequestBody_";
  protected final String TEXT_81 = " = form_";
  protected final String TEXT_82 = ";" + NL + "\t";
  protected final String TEXT_83 = NL + "\t\t";
  protected final String TEXT_84 = NL + "\t\t\twebClient_";
  protected final String TEXT_85 = ".query(";
  protected final String TEXT_86 = " ,";
  protected final String TEXT_87 = ");" + NL + "\t\t";
  protected final String TEXT_88 = NL + "\t";
  protected final String TEXT_89 = NL + NL + NL + "\ttry {" + NL + "" + NL + "\t\t";
  protected final String TEXT_90 = NL + "\t\t\tresponseDoc_";
  protected final String TEXT_91 = " = webClient_";
  protected final String TEXT_92 = ".get(responseClass_";
  protected final String TEXT_93 = ");" + NL + "\t\t";
  protected final String TEXT_94 = NL + "\t\t\tresponseDoc_";
  protected final String TEXT_95 = " = webClient_";
  protected final String TEXT_96 = ".post(requestBody_";
  protected final String TEXT_97 = ", responseClass_";
  protected final String TEXT_98 = ");" + NL + "\t\t";
  protected final String TEXT_99 = NL + "\t\t\twebClient_";
  protected final String TEXT_100 = ".invoke(\"";
  protected final String TEXT_101 = "\", requestBody_";
  protected final String TEXT_102 = ");" + NL + "\t\t";
  protected final String TEXT_103 = NL + NL + "\t\t";
  protected final String TEXT_104 = NL + "\t\t\tif (";
  protected final String TEXT_105 = " == null) {" + NL + "\t\t\t\t";
  protected final String TEXT_106 = " = new ";
  protected final String TEXT_107 = "Struct();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_108 = ".statusCode = webClient_";
  protected final String TEXT_109 = ".getResponse().getStatus();" + NL + "\t\t\tif (responseDoc_";
  protected final String TEXT_110 = " != null) {" + NL + "\t\t\t\tif (responseClass_";
  protected final String TEXT_111 = " == String.class) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_112 = ".string = (String) responseDoc_";
  protected final String TEXT_113 = ";" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tDocument responseTalendDoc_";
  protected final String TEXT_114 = " = null;" + NL + "\t\t\t\t\tif (null != responseDoc_";
  protected final String TEXT_115 = ") {" + NL + "\t\t\t\t\t\tresponseTalendDoc_";
  protected final String TEXT_116 = " = new Document();" + NL + "\t\t\t\t\t\tresponseTalendDoc_";
  protected final String TEXT_117 = ".setDocument((org.dom4j.Document) responseDoc_";
  protected final String TEXT_118 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_119 = ".body = responseTalendDoc_";
  protected final String TEXT_120 = ";" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_121 = NL + NL + "\t} catch (javax.ws.rs.WebApplicationException ex_";
  protected final String TEXT_122 = ") {" + NL + "\t\t";
  protected final String TEXT_123 = NL + "\t\t\tif (";
  protected final String TEXT_124 = " == null) {" + NL + "\t\t\t\t";
  protected final String TEXT_125 = " = new ";
  protected final String TEXT_126 = "Struct();" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_127 = ".errorCode = ex_";
  protected final String TEXT_128 = ".getResponse().getStatus();" + NL + "\t\t\t";
  protected final String TEXT_129 = ".errorMessage = ex_";
  protected final String TEXT_130 = ".getMessage();" + NL + "\t\t";
  protected final String TEXT_131 = NL + "\t\t\tSystem.out.println(\"error response: \" + ex_";
  protected final String TEXT_132 = ".getResponse().getStatus() + \":\" + ex_";
  protected final String TEXT_133 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_134 = NL + "\t}" + NL + "" + NL + "} catch(Exception e_";
  protected final String TEXT_135 = ") {" + NL + "\t";
  protected final String TEXT_136 = NL + "\t\tthrow(e_";
  protected final String TEXT_137 = ");" + NL + "\t";
  protected final String TEXT_138 = NL + "\t\tSystem.err.print(e_";
  protected final String TEXT_139 = ".getMessage());" + NL + "\t";
  protected final String TEXT_140 = NL + "}";
  protected final String TEXT_141 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();


IConnection inputConn = null;
List<? extends IConnection> incomingConnections = node.getIncomingConnections();
if (incomingConnections != null && !incomingConnections.isEmpty()) {
	for (IConnection conn : incomingConnections) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			inputConn = conn;
			break;
		}
	}
}

List<? extends IConnection> conns = node.getOutgoingSortedConnections();
if (conns != null && conns.size() > 0) {
	for (int i = 0; i < conns.size(); i++) {
		IConnection conn = conns.get(i);
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_2);
    
		}
	}
}

List<? extends IConnection> connsResponse = node.getOutgoingConnections("RESPONSE");
List<? extends IConnection> connsFault = node.getOutgoingConnections("FAULT");
IConnection connResponse = null;
IConnection connFault = null;
if (connsResponse.size() == 1) {
	connResponse = connsResponse.get(0);
}
if (connsFault.size() == 1) {
	connFault = connsFault.get(0);
}



String url = ElementParameterParser.getValue(node,"__URL__");

String connectionTimeout = ElementParameterParser.getValue(node,"__CONNECTION_TIMEOUT__");

String receiveTimeout = ElementParameterParser.getValue(node,"__RECEIVE_TIMEOUT__");

List<Map<String, String>> headers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__HEADERS__");
List<Map<String, String>> queries = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__QUERY__");

String method = ElementParameterParser.getValue(node,"__METHOD__");

String acceptType = ElementParameterParser.getValue(node,"__ACCEPT_TYPE__");
if (acceptType == null) {
	acceptType = "application/xml";
}

String contentType = ElementParameterParser.getValue(node,"__CONTENT_TYPE__");
if (contentType == null) {
	contentType = "application/xml";
}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
     if (null != inputConn) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_11);
     } 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
     if ("*/*".equals(acceptType)) { 
    stringBuffer.append(TEXT_19);
     } else { 
    stringBuffer.append(TEXT_20);
     } 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_24);
     if (Boolean.valueOf(ElementParameterParser.getValue(node,"__NEED_AUTH__"))) { 
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(ElementParameterParser.getValue(node,"__AUTH_USERNAME__"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(ElementParameterParser.getValue(node,"__AUTH_PASSWORD__"));
    stringBuffer.append(TEXT_29);
     } 
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(receiveTimeout);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connectionTimeout);
    stringBuffer.append(TEXT_50);
     if (Boolean.valueOf(ElementParameterParser.getValue(node,"__USE_PROXY__"))) { 
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(ElementParameterParser.getValue(node,"__PROXY_HOST__"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ElementParameterParser.getValue(node,"__PROXY_PORT__"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(ElementParameterParser.getValue(node,"__PROXY_USERNAME__"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(ElementParameterParser.getValue(node,"__PROXY_PASSWORD__"));
    stringBuffer.append(TEXT_59);
     } 
    stringBuffer.append(TEXT_60);
     if (!"GET".equals(method) && !"DELETE".equals(method)) { 
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(contentType);
    stringBuffer.append(TEXT_63);
     } 
    stringBuffer.append(TEXT_64);
     if (!acceptType.isEmpty()) { 
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(acceptType);
    stringBuffer.append(TEXT_67);
     } 
    stringBuffer.append(TEXT_68);
     for (Map<String, String> header : headers) { 
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(header.get("NAME") );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(header.get("VALUE") );
    stringBuffer.append(TEXT_72);
     } 
    stringBuffer.append(TEXT_73);
     if ("application/x-www-form-urlencoded".equals(contentType) && !"GET".equals(method) && !"DELETE".equals(method)) { 
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
     for (Map<String, String> query : queries) { 
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(query.get("NAME") );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(query.get("VALUE") );
    stringBuffer.append(TEXT_79);
     } 
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
     } else { 
    stringBuffer.append(TEXT_83);
     for (Map<String, String> query : queries) { 
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(query.get("NAME") );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(query.get("VALUE") );
    stringBuffer.append(TEXT_87);
     } 
    stringBuffer.append(TEXT_88);
     } 
    stringBuffer.append(TEXT_89);
     if ("GET".equals(method)) { 
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
     } else if ("POST".equals(method)) { 
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
     } else { 
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
     } 
    stringBuffer.append(TEXT_103);
     if (null != connResponse) {
			String connResponseName = connResponse.getName(); 
    stringBuffer.append(TEXT_104);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
     } 
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
     if (null != connFault) {
			String connFaultName = connFault.getName(); 
    stringBuffer.append(TEXT_123);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
     } else { 
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
     } 
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
     if ("true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"))) { 
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
     } else { 
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
     } 
    stringBuffer.append(TEXT_140);
    stringBuffer.append(TEXT_141);
    return stringBuffer.toString();
  }
}
