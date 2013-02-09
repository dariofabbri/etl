package org.talend.designer.codegen.translators.databases.db_jdbc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;
import java.util.Map;

public class TJDBCInputBeginJava
{
  protected static String nl;
  public static synchronized TJDBCInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCInputBeginJava result = new TJDBCInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "            java.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_3 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "            if (null != dataSources_";
  protected final String TEXT_4 = ") {";
  protected final String TEXT_5 = NL + "                conn_";
  protected final String TEXT_6 = " = dataSources_";
  protected final String TEXT_7 = ".get(";
  protected final String TEXT_8 = ").getConnection();" + NL + "            } else {" + NL + "\t\t\t    java.lang.Class.forName(\"";
  protected final String TEXT_9 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t        String dbUser_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ";" + NL + "\t\t        String dbPwd_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "\t\t        conn_";
  protected final String TEXT_15 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_16 = ",dbUser_";
  protected final String TEXT_17 = ",dbPwd_";
  protected final String TEXT_18 = ");" + NL + "\t\t    }";
  protected final String TEXT_19 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_20 = " = conn_";
  protected final String TEXT_21 = ".createStatement();";
  protected final String TEXT_22 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_23 = " = conn_";
  protected final String TEXT_24 = ".createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tjava.sql.ResultSet.CONCUR_READ_ONLY);" + NL + "\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\ttmpContent_";
  protected final String TEXT_26 = " = rs_";
  protected final String TEXT_27 = ".getString(";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "                        if(tmpContent_";
  protected final String TEXT_30 = " != null) {" + NL + "                            tmpContent_";
  protected final String TEXT_31 = " = tmpContent_";
  protected final String TEXT_32 = ";" + NL + "                        }";
  protected final String TEXT_33 = NL + "                    if(tmpContent_";
  protected final String TEXT_34 = " != null && tmpContent_";
  protected final String TEXT_35 = ".length() > 0) {\t\t\t  \t";
  protected final String TEXT_36 = NL + "                        ";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = " = tmpContent_";
  protected final String TEXT_39 = ".charAt(0);\t\t\t  \t\t" + NL + "                    } else {\t\t\t  \t";
  protected final String TEXT_40 = "\t\t\t  \t    " + NL + "                            if(tmpContent_";
  protected final String TEXT_41 = " == null) {\t\t\t  \t   \t";
  protected final String TEXT_42 = NL + "                                ";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = " = null;\t\t\t  \t\t\t" + NL + "                            } else {\t\t\t  \t\t";
  protected final String TEXT_45 = NL + "                                ";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            }";
  protected final String TEXT_48 = "\t\t\t  \t\t" + NL + "                            if((\"\").equals(tmpContent_";
  protected final String TEXT_49 = ")) {\t\t\t  \t\t";
  protected final String TEXT_50 = NL + "                                ";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            } else {\t\t\t  \t\t" + NL + "        \t\t\t  \t\t\tthrow new RuntimeException(" + NL + "        \t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_53 = "' in '";
  protected final String TEXT_54 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t" + NL + "                            }\t\t\t  \t\t";
  protected final String TEXT_55 = NL + "                    }";
  protected final String TEXT_56 = NL + "\t\t\tif(rs_";
  protected final String TEXT_57 = ".getTimestamp(";
  protected final String TEXT_58 = ") != null) {" + NL + "\t\t\t    ";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = " = new java.util.Date(rs_";
  protected final String TEXT_61 = ".getTimestamp(";
  protected final String TEXT_62 = ").getTime());" + NL + "\t\t\t} else {" + NL + "\t\t\t    ";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = " =  null;" + NL + "\t\t\t}\t\t\t ";
  protected final String TEXT_65 = NL + "            tmpContent_";
  protected final String TEXT_66 = " = rs_";
  protected final String TEXT_67 = ".getString(";
  protected final String TEXT_68 = ");" + NL + "            if(tmpContent_";
  protected final String TEXT_69 = " != null) {";
  protected final String TEXT_70 = NL + "                ";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = " = tmpContent_";
  protected final String TEXT_73 = ";" + NL + "            } else {";
  protected final String TEXT_74 = NL + "                ";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = " = null;" + NL + "            }";
  protected final String TEXT_77 = NL + "            if(rs_";
  protected final String TEXT_78 = ".getObject(";
  protected final String TEXT_79 = ") != null) {";
  protected final String TEXT_80 = NL + "                ";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = " = rs_";
  protected final String TEXT_83 = ".get";
  protected final String TEXT_84 = "(";
  protected final String TEXT_85 = ");" + NL + "            } else {";
  protected final String TEXT_86 = NL + "                    ";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = " = null;";
  protected final String TEXT_89 = "    " + NL + "                    throw new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_90 = NL + "            }";
  protected final String TEXT_91 = NL + "\t\t\tString url_";
  protected final String TEXT_92 = " = ";
  protected final String TEXT_93 = ";";
  protected final String TEXT_94 = NL + "                stmt_";
  protected final String TEXT_95 = ".setFetchSize(";
  protected final String TEXT_96 = ");";
  protected final String TEXT_97 = "\t\t\t" + NL + "\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_98 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "            if (null != dataSources_";
  protected final String TEXT_99 = ") {";
  protected final String TEXT_100 = NL + "                conn_";
  protected final String TEXT_101 = " = dataSources_";
  protected final String TEXT_102 = ".get(";
  protected final String TEXT_103 = ").getConnection();" + NL + "            } else {" + NL + "\t\t\t    java.lang.Class.forName(";
  protected final String TEXT_104 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_105 = NL + "\t\t        String dbUser_";
  protected final String TEXT_106 = " = ";
  protected final String TEXT_107 = ";" + NL + "\t\t        String dbPwd_";
  protected final String TEXT_108 = " = ";
  protected final String TEXT_109 = ";" + NL + "\t\t        conn_";
  protected final String TEXT_110 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_111 = ",dbUser_";
  protected final String TEXT_112 = ",dbPwd_";
  protected final String TEXT_113 = ");" + NL + "\t\t\t}";
  protected final String TEXT_114 = NL + "            java.util.Date date_";
  protected final String TEXT_115 = " = null;" + NL + "            try{" + NL + "            \tdate_";
  protected final String TEXT_116 = " = rs_";
  protected final String TEXT_117 = ".getTimestamp(";
  protected final String TEXT_118 = ");" + NL + "            }catch(Exception e){" + NL + "            \tdate_";
  protected final String TEXT_119 = " = rs_";
  protected final String TEXT_120 = ".getDate(";
  protected final String TEXT_121 = ");" + NL + "            }";
  protected final String TEXT_122 = NL + "            ";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = " = date_";
  protected final String TEXT_125 = ";";
  protected final String TEXT_126 = NL + "\t\t\t\tif (rs_";
  protected final String TEXT_127 = ".wasNull()) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = " = null;" + NL + "\t\t\t\t}";
  protected final String TEXT_130 = NL + "    " + NL + "\t";
  protected final String TEXT_131 = NL + "\t\t    int nb_line_";
  protected final String TEXT_132 = " = 0;" + NL + "\t\t    java.sql.Connection conn_";
  protected final String TEXT_133 = " = null;";
  protected final String TEXT_134 = NL + "\t\t        conn_";
  protected final String TEXT_135 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_136 = "\");" + NL + "\t\t        if (null == conn_";
  protected final String TEXT_137 = ") {";
  protected final String TEXT_138 = NL + "\t\t\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_139 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\t\t\t\tconn_";
  protected final String TEXT_140 = " = dataSources_";
  protected final String TEXT_141 = ".get(";
  protected final String TEXT_142 = ").getConnection();" + NL + "\t\t\t\t\t//globalMap.put(\"";
  protected final String TEXT_143 = "\", conn_";
  protected final String TEXT_144 = ");" + NL + "\t\t        }";
  protected final String TEXT_145 = NL + NL + "\t\t    ";
  protected final String TEXT_146 = NL + "\t\t    " + NL + "\t\t    String dbquery_";
  protected final String TEXT_147 = " = ";
  protected final String TEXT_148 = ";" + NL + "\t\t    " + NL + "\t\t    globalMap.put(\"";
  protected final String TEXT_149 = "_QUERY\",dbquery_";
  protected final String TEXT_150 = ");" + NL + "\t\t    " + NL + "\t\t    java.sql.ResultSet rs_";
  protected final String TEXT_151 = " = stmt_";
  protected final String TEXT_152 = ".executeQuery(dbquery_";
  protected final String TEXT_153 = ");" + NL + "\t\t    java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_154 = " = rs_";
  protected final String TEXT_155 = ".getMetaData();" + NL + "\t\t    int colQtyInRs_";
  protected final String TEXT_156 = " = rsmd_";
  protected final String TEXT_157 = ".getColumnCount();" + NL;
  protected final String TEXT_158 = NL + "\t\t    routines.system.Dynamic dcg_";
  protected final String TEXT_159 = " =  new routines.system.Dynamic();" + NL + "\t\t    dcg_";
  protected final String TEXT_160 = ".setDbmsId(\"";
  protected final String TEXT_161 = "\");" + NL + "\t\t    List<String> listSchema_";
  protected final String TEXT_162 = "=new java.util.ArrayList<String>();" + NL + "\t\t    for(int i_";
  protected final String TEXT_163 = "=1; i_";
  protected final String TEXT_164 = "<";
  protected final String TEXT_165 = "; i_";
  protected final String TEXT_166 = "++) {" + NL + "\t\t    \tlistSchema_";
  protected final String TEXT_167 = ".add(rsmd_";
  protected final String TEXT_168 = ".getColumnName(i_";
  protected final String TEXT_169 = ").toUpperCase());" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tint fixedColumnCount_";
  protected final String TEXT_170 = " = ";
  protected final String TEXT_171 = ";" + NL + "\t\t\t" + NL + "            for (int i = ";
  protected final String TEXT_172 = "; i <= rsmd_";
  protected final String TEXT_173 = ".getColumnCount(); i++) {" + NL + "                if (!(listSchema_";
  protected final String TEXT_174 = ".contains(rsmd_";
  protected final String TEXT_175 = ".getColumnName(i).toUpperCase()) )) {" + NL + "                \troutines.system.DynamicMetadata dcm_";
  protected final String TEXT_176 = "=new routines.system.DynamicMetadata();" + NL + "                \tdcm_";
  protected final String TEXT_177 = ".setName(rsmd_";
  protected final String TEXT_178 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_179 = ".setDbName(rsmd_";
  protected final String TEXT_180 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_181 = ".setType(routines.system.Dynamic.getTalendTypeFromDBType(\"";
  protected final String TEXT_182 = "\", rsmd_";
  protected final String TEXT_183 = ".getColumnTypeName(i).toUpperCase(), rsmd_";
  protected final String TEXT_184 = ".getPrecision(i), rsmd_";
  protected final String TEXT_185 = ".getScale(i)));" + NL + "                \tdcm_";
  protected final String TEXT_186 = ".setDbType(rsmd_";
  protected final String TEXT_187 = ".getColumnTypeName(i));";
  protected final String TEXT_188 = NL + "                \tdcm_";
  protected final String TEXT_189 = ".setFormat(";
  protected final String TEXT_190 = ");";
  protected final String TEXT_191 = NL + "\t\t\tif(\"LONG\".equals(rsmd_";
  protected final String TEXT_192 = ".getColumnTypeName(i).toUpperCase())) {" + NL + "\t\t\t\tString length = MetadataTalendType.getDefaultDBTypes(\"oracle_id\", \"LONG\", MetadataTalendType.DEFAULT_LENGTH);" + NL + "\t\t\t\tif(length!=null && !(\"\".equals(length))) {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_193 = ".setLength(Integer.parseInt(length));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_194 = ".setLength(rsmd_";
  protected final String TEXT_195 = ".getPrecision(i));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdcm_";
  protected final String TEXT_196 = ".setLength(rsmd_";
  protected final String TEXT_197 = ".getPrecision(i));" + NL + "\t\t\t}";
  protected final String TEXT_198 = NL + "\t\t\tdcm_";
  protected final String TEXT_199 = ".setLength(rsmd_";
  protected final String TEXT_200 = ".getPrecision(i));";
  protected final String TEXT_201 = NL + "                \tdcm_";
  protected final String TEXT_202 = ".setPrecision(rsmd_";
  protected final String TEXT_203 = ".getScale(i));" + NL + "                \tdcm_";
  protected final String TEXT_204 = ".setNullable(rsmd_";
  protected final String TEXT_205 = ".isNullable(i) == 0 ? false : true);" + NL + "                \tdcm_";
  protected final String TEXT_206 = ".setKey(false);" + NL + "                \tdcm_";
  protected final String TEXT_207 = ".setSourceType(DynamicMetadata.sourceTypes.database);" + NL + "                \tdcm_";
  protected final String TEXT_208 = ".setColumnPosition(i);" + NL + "                \tdcg_";
  protected final String TEXT_209 = ".metadatas.add(dcm_";
  protected final String TEXT_210 = ");" + NL + "                }" + NL + "            }";
  protected final String TEXT_211 = NL + "\t\t    String tmpContent_";
  protected final String TEXT_212 = " = null;" + NL + "\t\t    while (rs_";
  protected final String TEXT_213 = ".next()) {" + NL + "\t\t        nb_line_";
  protected final String TEXT_214 = "++;" + NL + "\t\t        ";
  protected final String TEXT_215 = " \t" + NL + "\t\t                    if(colQtyInRs_";
  protected final String TEXT_216 = " < ";
  protected final String TEXT_217 = ") { \t\t" + NL + "\t\t                        ";
  protected final String TEXT_218 = ".";
  protected final String TEXT_219 = " = ";
  protected final String TEXT_220 = "; \t\t\t" + NL + "\t\t                    } else {";
  protected final String TEXT_221 = NL + "\t\t                 \t\t\t";
  protected final String TEXT_222 = "\t\t\t";
  protected final String TEXT_223 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_224 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_225 = NL + "\t\t                            ";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = " = (List)rs_";
  protected final String TEXT_228 = ".getObject(";
  protected final String TEXT_229 = ");";
  protected final String TEXT_230 = NL + "\t\t                         ";
  protected final String TEXT_231 = NL + "                                    oracle.spatial.geometry.JGeometry jGeom = oracle.spatial.geometry.JGeometry.load((oracle.sql.STRUCT) rs_";
  protected final String TEXT_232 = ".getObject(";
  protected final String TEXT_233 = "));" + NL + "                                    oracle.spatial.util.WKT wkt = new oracle.spatial.util.WKT();" + NL + "                                    String wktValue = new String(wkt.fromJGeometry(jGeom));" + NL;
  protected final String TEXT_234 = NL + "                                    ";
  protected final String TEXT_235 = ".";
  protected final String TEXT_236 = " = new Geometry(wktValue);";
  protected final String TEXT_237 = NL + "                                        ";
  protected final String TEXT_238 = ".";
  protected final String TEXT_239 = ".setEPSG(";
  protected final String TEXT_240 = ");";
  protected final String TEXT_241 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_242 = NL + "                                  ";
  protected final String TEXT_243 = ".";
  protected final String TEXT_244 = "=dcg_";
  protected final String TEXT_245 = ";";
  protected final String TEXT_246 = NL + "\t\t\t\t\t\t\t\t\t\tList<Object> list_";
  protected final String TEXT_247 = " = new java.util.ArrayList<Object>();" + NL + "\t\t\t\t\t    \t\t\t\tfor(int i_";
  protected final String TEXT_248 = " = ";
  protected final String TEXT_249 = "; i_";
  protected final String TEXT_250 = "  <= rsmd_";
  protected final String TEXT_251 = ".getColumnCount(); i_";
  protected final String TEXT_252 = " ++){" + NL + "\t\t\t\t\t\t \t\t\t\t\tif (\"NTEXT\".equals(rsmd_";
  protected final String TEXT_253 = ".getColumnTypeName(i_";
  protected final String TEXT_254 = " ).toUpperCase())) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.ClobImpl clob_";
  protected final String TEXT_255 = " = (net.sourceforge.jtds.jdbc.ClobImpl) rs_";
  protected final String TEXT_256 = ".getClob(i_";
  protected final String TEXT_257 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(clob_";
  protected final String TEXT_258 = "!=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.TalendNTextImpl tNTextImpl_";
  protected final String TEXT_259 = " = new net.sourceforge.jtds.jdbc.TalendNTextImpl(clob_";
  protected final String TEXT_260 = ");" + NL + "\t\t\t\t\t\t\t  \t\t\t\t\t\tlist_";
  protected final String TEXT_261 = ".add(tNTextImpl_";
  protected final String TEXT_262 = ".getValue());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_263 = ".add(null);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t}" + NL + "   \t \t\t\t\t    \t\t\t\t}" + NL + "                                 \t\t routines.system.DynamicUtils.readColumnsFromDatabase_Mssql(";
  protected final String TEXT_264 = ".";
  protected final String TEXT_265 = ", rs_";
  protected final String TEXT_266 = ", fixedColumnCount_";
  protected final String TEXT_267 = ",list_";
  protected final String TEXT_268 = ");";
  protected final String TEXT_269 = NL + "                                \t\t routines.system.DynamicUtils.readColumnsFromDatabase(";
  protected final String TEXT_270 = ".";
  protected final String TEXT_271 = ", rs_";
  protected final String TEXT_272 = ", fixedColumnCount_";
  protected final String TEXT_273 = ");";
  protected final String TEXT_274 = NL + "                                \torg.postgis.Geometry o = org.postgis.PGgeometry.geomFromString(rs_";
  protected final String TEXT_275 = ".getObject(";
  protected final String TEXT_276 = ").toString());" + NL + "                                \tStringBuffer sb = new StringBuffer();" + NL + "                                \to.outerWKT(sb, false);" + NL + "                                \t";
  protected final String TEXT_277 = ".";
  protected final String TEXT_278 = " = new Geometry(sb.toString());";
  protected final String TEXT_279 = NL + "\t\t                          ";
  protected final String TEXT_280 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_281 = NL + "\t\t                    }";
  protected final String TEXT_282 = NL + "\t\t                            ";
  protected final String TEXT_283 = ".";
  protected final String TEXT_284 = " = ";
  protected final String TEXT_285 = ".";
  protected final String TEXT_286 = ";" + NL + "\t\t                            ";
  protected final String TEXT_287 = NL + NL + NL;
  protected final String TEXT_288 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by connection component
	class DefaultDBInputUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    protected String dbuser;
		protected String dbpwd ;
	    
	    public void beforeComponentProcess(INode node){
	    	cid = node.getUniqueName();
	    }
	    
	    public void afterUseExistConnection(INode node) {
	    }
	    
	    public String getDirverClassName(INode node){
			return "";
		}
	    
	    public void setURL(INode node) {
	    }

		public void createConnection(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");
	 		dbpwd = ElementParameterParser.getValue(node, "__PASS__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
                String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_8);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_9);
    this.setURL(node);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
		}
		
		public String getQueryString(INode node) {
			String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			
			return dbquery;
		}
		
		public void createStatement(INode node) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
		}
		public void createMinValueStatement(INode node){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
		public String mappingType(String typeToGenerate) {
		
            if(("byte[]").equals(typeToGenerate)) {
                return "Bytes";
            } else if(("java.util.Date").equals(typeToGenerate)) {
                return "Timestamp";
            } else if(("Integer").equals(typeToGenerate)) {
               return "Int";
            } else {
                return typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringCharAndCharacterSet(String firstConnName, IMetadataColumn column, int currentColNo,
					String trimMethod, String typeToGenerate, boolean whetherTrimAllCol, boolean whetherTrimCol) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_28);
    
                    if(whetherTrimAllCol || whetherTrimCol) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_32);
    
                    }

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
                        if(("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_47);
    
                        } else {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_54);
    
                        }

    stringBuffer.append(TEXT_55);
    
		}
		
	    public void generateTimestampResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_64);
    
	    }
	    
	    public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_76);
    
	    }
	    
	    public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    }
	    
	    public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_85);
    
                if(column.isNullable()) {
                    
    stringBuffer.append(TEXT_86);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_88);
    
                } else {
                    
    stringBuffer.append(TEXT_89);
        
                }
                
    stringBuffer.append(TEXT_90);
    
	    }
	    //---------end according schema type to generate ResultSet
	    
		public void afterGenertorType(String firstConnName, IMetadataColumn column, int currentColNo) {
	    }
	    
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultDBInputUtil class
	
	DefaultDBInputUtil dbInputBeginUtil = new DefaultDBInputUtil();
	
	

    

	class DBInputBeginUtil extends DefaultDBInputUtil{
	    
		public void setURL(INode node) {
			
			String jdbcUrl = ElementParameterParser.getValue(node, "__URL__");

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(jdbcUrl);
    stringBuffer.append(TEXT_93);
    
		}
		
		public void createStatement(INode node) {
			super.createStatement(node);
			String useCursor= ElementParameterParser.getValue(node, "__USE_CURSOR__");
			String cursorSize= ElementParameterParser.getValue(node, "__CURSOR_SIZE__");
            if(("true").equals(useCursor)) {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cursorSize );
    stringBuffer.append(TEXT_96);
    
            }
		}
		
		public void createConnection(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");
	 		dbpwd = ElementParameterParser.getValue(node, "__PASS__");

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
                String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_103);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_104);
    this.setURL(node);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
		}
		public String getDirverClassName(INode node){
			String driverJar = ElementParameterParser.getValue(node, "__DRIVER_JAR__");
			String driverClass = ElementParameterParser.getValue(node, "__DRIVER_CLASS__");
			return driverClass;
		}
		
		//-----------according schema type to generate ResultSet
		public void generateTimestampResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
	    }  
	    
	    public void afterGenertorType(String firstConnName, IMetadataColumn column, int currentColNo) {
			if (column.isNullable()) {

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_129);
    
			}	
	    }
	    //---------end according schema type to generate ResultSet
	}//end class
	
	dbInputBeginUtil = new DBInputBeginUtil();

    stringBuffer.append(TEXT_130);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	        
	String type = ElementParameterParser.getValue(node, "__TYPE__");
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser = ElementParameterParser.getValue(node, "__USER__");
	String dbpwd = ElementParameterParser.getValue(node, "__PASS__");
	String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
	String enableStream = ElementParameterParser.getValue(node, "__ENABLE_STREAM__");
	String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
	
    boolean whetherTrimAllCol = ("true").equals(ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__"));
    List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");
    
    dbInputBeginUtil.beforeComponentProcess(node);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas != null) && (metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata != null) {

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
		    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
		        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		        String conn = "conn_" + connection;

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
                    INode connectionNode = null;
                    for (INode processNode : node.getProcess().getGeneratingNodes()) {
                        if(connection.equals(processNode.getUniqueName())) {
                            connectionNode = processNode;
                            break;
                        }
                    }
                    String alias = ElementParameterParser.getValue(connectionNode, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_142);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
				dbInputBeginUtil.afterUseExistConnection(node);
		
		    } else {
				dbInputBeginUtil.createConnection(node);
		    }

    stringBuffer.append(TEXT_145);
    dbInputBeginUtil.createStatement(node);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(dbInputBeginUtil.getQueryString(node));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    
		    List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		    List<IMetadataColumn> columnList = metadata.getListColumns();
		    boolean isDynamic = metadata.isDynamicSchema();
		    if(isDynamic){
		    	String DynamicDatePattern = "\"dd-MM-yyyy\"";
		    	for(IMetadataColumn column : columnList) {
		    		if("id_Dynamic".equals(column.getTalendType())) {
		    			DynamicDatePattern = column.getPattern();
		    			break;
		    		}
		    	}
		    
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(metadata.getListColumns().size()-1);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
     if((DynamicDatePattern!=null) && (!"".equals(DynamicDatePattern)) && (!"\"\"".equals(DynamicDatePattern))) {
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(DynamicDatePattern);
    stringBuffer.append(TEXT_190);
     } 
    
		if (("oracle_id".equalsIgnoreCase(dbms))) {

    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
		} else {

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    
		}

    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    
		    }
		    
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    
		        if(conns != null && conns.size() > 0) {
		            IConnection conn = conns.get(0);
		            String firstConnName = conn.getName();
		            int currentColNo = 1;
		            for(IMetadataColumn column : columnList) {
		                boolean whetherTrimCol = false;
		                if((trimColumnList != null && trimColumnList.size() > 0) && !whetherTrimAllCol) {
		                    for(Map<String, String> trimColumn : trimColumnList) {
		                        if(column.getLabel().equals(trimColumn.get("SCHEMA_COLUMN"))) {
		                            if(("true").equals(trimColumn.get("TRIM"))) {
		                                whetherTrimCol = true;
		                                break;
		                            }
		                        }
		                    }
		                }
		                String trimMethod = "";
		                if(whetherTrimAllCol || whetherTrimCol) {
		                    trimMethod = ".trim()";
		                }
		                String columnType = column.getType();
		                 
		                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		                String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate); 	
		                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		                    
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_219);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_220);
    
		                        typeToGenerate = dbInputBeginUtil.mappingType(typeToGenerate);
		  
		                        if(("Char").equals(typeToGenerate) || ("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_221);
    dbInputBeginUtil.generateStringCharAndCharacterSet(firstConnName, column,currentColNo, trimMethod, typeToGenerate, whetherTrimAllCol, whetherTrimCol);
    stringBuffer.append(TEXT_222);
    
		                        } else if(("Timestamp").equals(typeToGenerate)) {
		                        	if("vertica_id".equalsIgnoreCase(dbms) && "DATE".equalsIgnoreCase(column.getType())){

    stringBuffer.append(TEXT_223);
    dbInputBeginUtil.generateOthersResultSet(firstConnName, column,  currentColNo,  "Date");
    
									}else{

    stringBuffer.append(TEXT_224);
    dbInputBeginUtil.generateTimestampResultSet(firstConnName, column, currentColNo);
    
									}
		                         } else if (("List").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_225);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_229);
    
		                        } else if(("String").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_230);
    dbInputBeginUtil.generateStringResultSet(firstConnName, column, currentColNo,trimMethod);
    
								} else if("Geometry".equals(typeToGenerate) && type.indexOf("ORACLE") >= 0) {

    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_236);
    
                                    String sourceCRS = ElementParameterParser.getValue(node,"__CRS__");
                                    String forceCRS = ElementParameterParser.getValue(node,"__FORCE_CRS__");
                                    if (forceCRS.equals("true")) {

    stringBuffer.append(TEXT_237);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_239);
    stringBuffer.append(sourceCRS);
    stringBuffer.append(TEXT_240);
    
                                    }
								} else if(("Bytes").equals(typeToGenerate) && (columnType != null && (("LONG RAW").equals(columnType) || ("RAW").equals(columnType)))) {//oracle

    stringBuffer.append(TEXT_241);
    dbInputBeginUtil.generateBytesResultSet(firstConnName, column, currentColNo);
    
								} else if(("Dynamic").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
     //for bug TDI-20886
									if ("id_MSSQL".equalsIgnoreCase(dbms)) {

    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    
									}else{

    stringBuffer.append(TEXT_269);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    
									}
								} else if(typeToGenerate.equals("Geometry")) {

    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_278);
    
                 	            } else {

    stringBuffer.append(TEXT_279);
    dbInputBeginUtil.generateOthersResultSet( firstConnName, column,  currentColNo,  typeToGenerate);
    
		                        }

    stringBuffer.append(TEXT_280);
    dbInputBeginUtil.afterGenertorType( firstConnName, column,  currentColNo);
    stringBuffer.append(TEXT_281);
      
		                    currentColNo++;
		                }
		            }
		            if(conns.size() > 1) {
		                for(int connNO = 1 ; connNO < conns.size() ; connNO++) {
		                    IConnection conn2 = conns.get(connNO);
		                    if((conn2.getName().compareTo(firstConnName) != 0) && (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
		                        for(IMetadataColumn column:columnList){
		                            
    stringBuffer.append(TEXT_282);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_283);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_284);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_286);
     
		                        }
		                    }
		                }
		            }
		        }
		}
	}

    stringBuffer.append(TEXT_287);
    stringBuffer.append(TEXT_288);
    return stringBuffer.toString();
  }
}
