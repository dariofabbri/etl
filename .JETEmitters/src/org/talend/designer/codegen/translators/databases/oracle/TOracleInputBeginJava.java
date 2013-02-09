package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.Map;
import java.util.List;

public class TOracleInputBeginJava
{
  protected static String nl;
  public static synchronized TOracleInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleInputBeginJava result = new TOracleInputBeginJava();
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
  protected final String TEXT_91 = NL + "            \tString url_";
  protected final String TEXT_92 = " = null;";
  protected final String TEXT_93 = NL + "        \t\t\turl_";
  protected final String TEXT_94 = " = ";
  protected final String TEXT_95 = ";        ";
  protected final String TEXT_96 = NL + "            \t\turl_";
  protected final String TEXT_97 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_98 = " + \":\" + ";
  protected final String TEXT_99 = " + \":\" + ";
  protected final String TEXT_100 = ";";
  protected final String TEXT_101 = NL + "            \t\turl_";
  protected final String TEXT_102 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_103 = " + \")(port=\" + ";
  protected final String TEXT_104 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_105 = " + \")))\";";
  protected final String TEXT_106 = NL + "            \t    url_";
  protected final String TEXT_107 = " = \"jdbc:oracle:oci8:@\" + ";
  protected final String TEXT_108 = ";";
  protected final String TEXT_109 = NL + "\t    \t\t\turl_";
  protected final String TEXT_110 = " = ";
  protected final String TEXT_111 = ";";
  protected final String TEXT_112 = NL;
  protected final String TEXT_113 = "\t\t\t" + NL + "\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_114 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "            if (null != dataSources_";
  protected final String TEXT_115 = ") {";
  protected final String TEXT_116 = NL + "                conn_";
  protected final String TEXT_117 = " = dataSources_";
  protected final String TEXT_118 = ".get(";
  protected final String TEXT_119 = ").getConnection();" + NL + "            } else {" + NL + "\t\t\t\tjava.lang.Class.forName(\"";
  protected final String TEXT_120 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_121 = NL + "\t\t\t\tString dbUser_";
  protected final String TEXT_122 = " = ";
  protected final String TEXT_123 = ";" + NL + "\t\t\t\tString dbPwd_";
  protected final String TEXT_124 = " = ";
  protected final String TEXT_125 = ";";
  protected final String TEXT_126 = NL + "\t\t\t\t\tconn_";
  protected final String TEXT_127 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "\t\t\t\t\tconn_";
  protected final String TEXT_130 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_131 = ",dbUser_";
  protected final String TEXT_132 = ",dbPwd_";
  protected final String TEXT_133 = ");";
  protected final String TEXT_134 = NL + "\t\t\t\tString atnParams_";
  protected final String TEXT_135 = " = ";
  protected final String TEXT_136 = ";" + NL + "\t\t\t\tatnParams_";
  protected final String TEXT_137 = " = atnParams_";
  protected final String TEXT_138 = ".replaceAll(\"&\", \"\\n\");" + NL + "\t\t\t\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_139 = " = new java.util.Properties();" + NL + "\t\t\t\tatnParamsPrope_";
  protected final String TEXT_140 = ".put(\"user\",dbUser_";
  protected final String TEXT_141 = ");" + NL + "\t\t\t\tatnParamsPrope_";
  protected final String TEXT_142 = ".put(\"password\",dbPwd_";
  protected final String TEXT_143 = ");" + NL + "\t\t\t\tatnParamsPrope_";
  protected final String TEXT_144 = ".load(new java.io.ByteArrayInputStream(atnParams_";
  protected final String TEXT_145 = ".getBytes()));" + NL + "\t\t\t\tconn_";
  protected final String TEXT_146 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_147 = ", atnParamsPrope_";
  protected final String TEXT_148 = ");";
  protected final String TEXT_149 = NL + "\t\t\t}";
  protected final String TEXT_150 = NL + "\t\t\t\tjava.sql.Statement stmtGetTZ_";
  protected final String TEXT_151 = " = conn_";
  protected final String TEXT_152 = ".createStatement();" + NL + "\t\t\t\tjava.sql.ResultSet rsGetTZ_";
  protected final String TEXT_153 = " = stmtGetTZ_";
  protected final String TEXT_154 = ".executeQuery(\"select sessiontimezone from dual\");" + NL + "\t\t\t\tString sessionTimezone_";
  protected final String TEXT_155 = " = java.util.TimeZone.getDefault().getID();" + NL + "\t\t\t\twhile (rsGetTZ_";
  protected final String TEXT_156 = ".next()) {" + NL + "\t\t\t\t\tsessionTimezone_";
  protected final String TEXT_157 = " = rsGetTZ_";
  protected final String TEXT_158 = ".getString(1);" + NL + "\t\t\t\t}" + NL + "\t\t\t\t((oracle.jdbc.OracleConnection)conn_";
  protected final String TEXT_159 = ").setSessionTimeZone(sessionTimezone_";
  protected final String TEXT_160 = ");";
  protected final String TEXT_161 = NL + "\t\t\t\tif(((oracle.jdbc.OracleConnection)conn_";
  protected final String TEXT_162 = ").getSessionTimeZone() == null){" + NL + "\t\t\t\t\tjava.sql.Statement stmtGetTZ_";
  protected final String TEXT_163 = " = conn_";
  protected final String TEXT_164 = ".createStatement();" + NL + "\t\t\t\t\tjava.sql.ResultSet rsGetTZ_";
  protected final String TEXT_165 = " = stmtGetTZ_";
  protected final String TEXT_166 = ".executeQuery(\"select sessiontimezone from dual\");" + NL + "\t\t\t\t\tString sessionTimezone_";
  protected final String TEXT_167 = " = java.util.TimeZone.getDefault().getID();" + NL + "\t\t\t\t\twhile (rsGetTZ_";
  protected final String TEXT_168 = ".next()) {" + NL + "\t\t\t\t\t\tsessionTimezone_";
  protected final String TEXT_169 = " = rsGetTZ_";
  protected final String TEXT_170 = ".getString(1);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t((oracle.jdbc.OracleConnection)conn_";
  protected final String TEXT_171 = ").setSessionTimeZone(sessionTimezone_";
  protected final String TEXT_172 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_173 = NL + "                stmt_";
  protected final String TEXT_174 = ".setFetchSize(";
  protected final String TEXT_175 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_176 = NL + "\t\t\t\tjava.io.Reader reader_";
  protected final String TEXT_177 = " = rs_";
  protected final String TEXT_178 = ".getCharacterStream(";
  protected final String TEXT_179 = ");" + NL + "\t\t\t\tjava.io.BufferedReader br_";
  protected final String TEXT_180 = " = null;" + NL + "\t\t\t\tif(reader_";
  protected final String TEXT_181 = " != null) {" + NL + "\t\t\t\t\tbr_";
  protected final String TEXT_182 = " = new java.io.BufferedReader(reader_";
  protected final String TEXT_183 = ");                 \t                        " + NL + " \t                StringBuffer content_";
  protected final String TEXT_184 = " = new StringBuffer();" + NL + " \t                int c_";
  protected final String TEXT_185 = " =0;" + NL + " \t                while( (c_";
  protected final String TEXT_186 = " = br_";
  protected final String TEXT_187 = ".read()) != -1) {" + NL + " \t                \tcontent_";
  protected final String TEXT_188 = ".append((char)c_";
  protected final String TEXT_189 = ");" + NL + "\t\t\t\t\t}" + NL + " \t                br_";
  protected final String TEXT_190 = ".close();" + NL + "\t\t\t\t\t";
  protected final String TEXT_191 = ".";
  protected final String TEXT_192 = " = content_";
  protected final String TEXT_193 = ".toString();" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_194 = ".";
  protected final String TEXT_195 = " = null;" + NL + "\t\t\t\t}                 \t                    ";
  protected final String TEXT_196 = NL + "\t\t\t \t    tmpContent_";
  protected final String TEXT_197 = " = rs_";
  protected final String TEXT_198 = ".getString(";
  protected final String TEXT_199 = ");" + NL + "\t\t\t        if(tmpContent_";
  protected final String TEXT_200 = " != null) {" + NL + "\t\t\t            ";
  protected final String TEXT_201 = ".";
  protected final String TEXT_202 = " = tmpContent_";
  protected final String TEXT_203 = ";" + NL + "\t\t\t        } else {" + NL + "\t\t\t            ";
  protected final String TEXT_204 = ".";
  protected final String TEXT_205 = " = null;" + NL + "\t\t\t        }                 \t                    ";
  protected final String TEXT_206 = NL + "\t\t\tbyte [] tmpBytes_";
  protected final String TEXT_207 = " = rs_";
  protected final String TEXT_208 = ".getBytes(";
  protected final String TEXT_209 = ");" + NL + "\t\t\tif(tmpBytes_";
  protected final String TEXT_210 = " != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_211 = ".";
  protected final String TEXT_212 = " = tmpBytes_";
  protected final String TEXT_213 = ";" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_214 = ".";
  protected final String TEXT_215 = " = null;" + NL + "\t\t\t}\t\t";
  protected final String TEXT_216 = NL + "    \t\t\tTalendTimestampWithTZ talendTimestampWithTZ = null;" + NL + "    \t\t\tif(((oracle.jdbc.OracleResultSet) rs_";
  protected final String TEXT_217 = ").getTIMESTAMPTZ(";
  protected final String TEXT_218 = ") != null){" + NL + "    \t\t\t\ttalendTimestampWithTZ = org.talend.oracle.OracleTSTZUtil.toTalendTSTZ(((oracle.jdbc.OracleResultSet) rs_";
  protected final String TEXT_219 = ").getTIMESTAMPTZ(";
  protected final String TEXT_220 = ").toBytes());" + NL + "                }" + NL + "                if(talendTimestampWithTZ != null){" + NL + "                \t";
  protected final String TEXT_221 = ".";
  protected final String TEXT_222 = " = talendTimestampWithTZ;" + NL + "                }else{" + NL + "                \t";
  protected final String TEXT_223 = ".";
  protected final String TEXT_224 = " = null;" + NL + "                }" + NL + "    \t\t";
  protected final String TEXT_225 = NL + "\t\t\t\t\tjava.sql.Timestamp timestamp = rs_";
  protected final String TEXT_226 = ".getTimestamp(";
  protected final String TEXT_227 = ");" + NL + "\t\t\t\t\tif(timestamp != null) {" + NL + "\t\t\t\t\t    ";
  protected final String TEXT_228 = ".";
  protected final String TEXT_229 = " = new java.util.Date(timestamp.getTime());" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t    ";
  protected final String TEXT_230 = ".";
  protected final String TEXT_231 = " = null;" + NL + "\t\t\t\t\t}\t\t\t " + NL + "\t\t\t\t";
  protected final String TEXT_232 = NL + "\t\t\t\t\tif(rs_";
  protected final String TEXT_233 = ".getTimestamp(";
  protected final String TEXT_234 = ") != null) {" + NL + "\t\t\t\t\t    ";
  protected final String TEXT_235 = ".";
  protected final String TEXT_236 = " = new java.util.Date(rs_";
  protected final String TEXT_237 = ".getTimestamp(";
  protected final String TEXT_238 = ").getTime());" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t    ";
  protected final String TEXT_239 = ".";
  protected final String TEXT_240 = " =  null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_241 = NL + "\t\t\t\tObject tmpObj_";
  protected final String TEXT_242 = "_";
  protected final String TEXT_243 = " = rs_";
  protected final String TEXT_244 = ".getObject(";
  protected final String TEXT_245 = ");" + NL + "\t\t\t\tif(tmpObj_";
  protected final String TEXT_246 = "_";
  protected final String TEXT_247 = " != null) {";
  protected final String TEXT_248 = NL + "\t\t\t\t\t";
  protected final String TEXT_249 = ".";
  protected final String TEXT_250 = " = oracle.xdb.XMLType.createXML((oracle.sql.OPAQUE) tmpObj_";
  protected final String TEXT_251 = "_";
  protected final String TEXT_252 = ").getStringVal();";
  protected final String TEXT_253 = NL + "\t\t\t\t\t";
  protected final String TEXT_254 = ".";
  protected final String TEXT_255 = " = tmpObj_";
  protected final String TEXT_256 = "_";
  protected final String TEXT_257 = ";";
  protected final String TEXT_258 = NL + "\t\t\t\t} else {";
  protected final String TEXT_259 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_260 = ".";
  protected final String TEXT_261 = " = null;";
  protected final String TEXT_262 = "    " + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_263 = NL + "\t\t\t\t}";
  protected final String TEXT_264 = NL + "\t\t\t\t\t";
  protected final String TEXT_265 = ".";
  protected final String TEXT_266 = " = rs_";
  protected final String TEXT_267 = ".get";
  protected final String TEXT_268 = "(";
  protected final String TEXT_269 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_270 = NL + "\t\t\t\t\t\tif(!";
  protected final String TEXT_271 = ".";
  protected final String TEXT_272 = " && rs_";
  protected final String TEXT_273 = ".getObject(";
  protected final String TEXT_274 = ") == null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_275 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_276 = ".";
  protected final String TEXT_277 = " == null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_278 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_279 = ".";
  protected final String TEXT_280 = " == 0 && rs_";
  protected final String TEXT_281 = ".getObject(";
  protected final String TEXT_282 = ") == null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_283 = NL + "\t\t\t\t\t\tif(rs_";
  protected final String TEXT_284 = ".getObject(";
  protected final String TEXT_285 = ") == null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_286 = NL + "\t\t\t\t";
  protected final String TEXT_287 = NL + "\t\t\t\t\tif(rs_";
  protected final String TEXT_288 = ".getObject(";
  protected final String TEXT_289 = ") != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_290 = ".";
  protected final String TEXT_291 = " = rs_";
  protected final String TEXT_292 = ".get";
  protected final String TEXT_293 = "(";
  protected final String TEXT_294 = ");" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_295 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_296 = ".";
  protected final String TEXT_297 = " = null;";
  protected final String TEXT_298 = "    " + NL + " \t                \tthrow new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_299 = NL + "\t\t\t\t\t}";
  protected final String TEXT_300 = NL + NL + "    " + NL + "\t";
  protected final String TEXT_301 = NL + "\t\t    int nb_line_";
  protected final String TEXT_302 = " = 0;" + NL + "\t\t    java.sql.Connection conn_";
  protected final String TEXT_303 = " = null;";
  protected final String TEXT_304 = NL + "\t\t        conn_";
  protected final String TEXT_305 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_306 = "\");" + NL + "\t\t        if (null == conn_";
  protected final String TEXT_307 = ") {";
  protected final String TEXT_308 = NL + "\t\t\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_309 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\t\t\t\tconn_";
  protected final String TEXT_310 = " = dataSources_";
  protected final String TEXT_311 = ".get(";
  protected final String TEXT_312 = ").getConnection();" + NL + "\t\t\t\t\t//globalMap.put(\"";
  protected final String TEXT_313 = "\", conn_";
  protected final String TEXT_314 = ");" + NL + "\t\t        }";
  protected final String TEXT_315 = NL + NL + "\t\t    ";
  protected final String TEXT_316 = NL + "\t\t    " + NL + "\t\t    String dbquery_";
  protected final String TEXT_317 = " = ";
  protected final String TEXT_318 = ";" + NL + "\t\t    " + NL + "\t\t    globalMap.put(\"";
  protected final String TEXT_319 = "_QUERY\",dbquery_";
  protected final String TEXT_320 = ");" + NL + "\t\t    " + NL + "\t\t    java.sql.ResultSet rs_";
  protected final String TEXT_321 = " = stmt_";
  protected final String TEXT_322 = ".executeQuery(dbquery_";
  protected final String TEXT_323 = ");" + NL + "\t\t    java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_324 = " = rs_";
  protected final String TEXT_325 = ".getMetaData();" + NL + "\t\t    int colQtyInRs_";
  protected final String TEXT_326 = " = rsmd_";
  protected final String TEXT_327 = ".getColumnCount();" + NL;
  protected final String TEXT_328 = NL + "\t\t    routines.system.Dynamic dcg_";
  protected final String TEXT_329 = " =  new routines.system.Dynamic();" + NL + "\t\t    dcg_";
  protected final String TEXT_330 = ".setDbmsId(\"";
  protected final String TEXT_331 = "\");" + NL + "\t\t    List<String> listSchema_";
  protected final String TEXT_332 = "=new java.util.ArrayList<String>();" + NL + "\t\t    for(int i_";
  protected final String TEXT_333 = "=1; i_";
  protected final String TEXT_334 = "<";
  protected final String TEXT_335 = "; i_";
  protected final String TEXT_336 = "++) {" + NL + "\t\t    \tlistSchema_";
  protected final String TEXT_337 = ".add(rsmd_";
  protected final String TEXT_338 = ".getColumnName(i_";
  protected final String TEXT_339 = ").toUpperCase());" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tint fixedColumnCount_";
  protected final String TEXT_340 = " = ";
  protected final String TEXT_341 = ";" + NL + "\t\t\t" + NL + "            for (int i = ";
  protected final String TEXT_342 = "; i <= rsmd_";
  protected final String TEXT_343 = ".getColumnCount(); i++) {" + NL + "                if (!(listSchema_";
  protected final String TEXT_344 = ".contains(rsmd_";
  protected final String TEXT_345 = ".getColumnName(i).toUpperCase()) )) {" + NL + "                \troutines.system.DynamicMetadata dcm_";
  protected final String TEXT_346 = "=new routines.system.DynamicMetadata();" + NL + "                \tdcm_";
  protected final String TEXT_347 = ".setName(rsmd_";
  protected final String TEXT_348 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_349 = ".setDbName(rsmd_";
  protected final String TEXT_350 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_351 = ".setType(routines.system.Dynamic.getTalendTypeFromDBType(\"";
  protected final String TEXT_352 = "\", rsmd_";
  protected final String TEXT_353 = ".getColumnTypeName(i).toUpperCase(), rsmd_";
  protected final String TEXT_354 = ".getPrecision(i), rsmd_";
  protected final String TEXT_355 = ".getScale(i)));" + NL + "                \tdcm_";
  protected final String TEXT_356 = ".setDbType(rsmd_";
  protected final String TEXT_357 = ".getColumnTypeName(i));";
  protected final String TEXT_358 = NL + "                \tdcm_";
  protected final String TEXT_359 = ".setFormat(";
  protected final String TEXT_360 = ");";
  protected final String TEXT_361 = NL + "\t\t\tif(\"LONG\".equals(rsmd_";
  protected final String TEXT_362 = ".getColumnTypeName(i).toUpperCase())) {" + NL + "\t\t\t\tString length = MetadataTalendType.getDefaultDBTypes(\"oracle_id\", \"LONG\", MetadataTalendType.DEFAULT_LENGTH);" + NL + "\t\t\t\tif(length!=null && !(\"\".equals(length))) {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_363 = ".setLength(Integer.parseInt(length));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_364 = ".setLength(rsmd_";
  protected final String TEXT_365 = ".getPrecision(i));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdcm_";
  protected final String TEXT_366 = ".setLength(rsmd_";
  protected final String TEXT_367 = ".getPrecision(i));" + NL + "\t\t\t}";
  protected final String TEXT_368 = NL + "\t\t\tdcm_";
  protected final String TEXT_369 = ".setLength(rsmd_";
  protected final String TEXT_370 = ".getPrecision(i));";
  protected final String TEXT_371 = NL + "                \tdcm_";
  protected final String TEXT_372 = ".setPrecision(rsmd_";
  protected final String TEXT_373 = ".getScale(i));" + NL + "                \tdcm_";
  protected final String TEXT_374 = ".setNullable(rsmd_";
  protected final String TEXT_375 = ".isNullable(i) == 0 ? false : true);" + NL + "                \tdcm_";
  protected final String TEXT_376 = ".setKey(false);" + NL + "                \tdcm_";
  protected final String TEXT_377 = ".setSourceType(DynamicMetadata.sourceTypes.database);" + NL + "                \tdcm_";
  protected final String TEXT_378 = ".setColumnPosition(i);" + NL + "                \tdcg_";
  protected final String TEXT_379 = ".metadatas.add(dcm_";
  protected final String TEXT_380 = ");" + NL + "                }" + NL + "            }";
  protected final String TEXT_381 = NL + "\t\t    String tmpContent_";
  protected final String TEXT_382 = " = null;" + NL + "\t\t    while (rs_";
  protected final String TEXT_383 = ".next()) {" + NL + "\t\t        nb_line_";
  protected final String TEXT_384 = "++;" + NL + "\t\t        ";
  protected final String TEXT_385 = " \t" + NL + "\t\t                    if(colQtyInRs_";
  protected final String TEXT_386 = " < ";
  protected final String TEXT_387 = ") { \t\t" + NL + "\t\t                        ";
  protected final String TEXT_388 = ".";
  protected final String TEXT_389 = " = ";
  protected final String TEXT_390 = "; \t\t\t" + NL + "\t\t                    } else {";
  protected final String TEXT_391 = NL + "\t\t                 \t\t\t";
  protected final String TEXT_392 = "\t\t\t";
  protected final String TEXT_393 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_394 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_395 = NL + "\t\t                            ";
  protected final String TEXT_396 = ".";
  protected final String TEXT_397 = " = (List)rs_";
  protected final String TEXT_398 = ".getObject(";
  protected final String TEXT_399 = ");";
  protected final String TEXT_400 = NL + "\t\t                         ";
  protected final String TEXT_401 = NL + "                                    oracle.spatial.geometry.JGeometry jGeom = oracle.spatial.geometry.JGeometry.load((oracle.sql.STRUCT) rs_";
  protected final String TEXT_402 = ".getObject(";
  protected final String TEXT_403 = "));" + NL + "                                    oracle.spatial.util.WKT wkt = new oracle.spatial.util.WKT();" + NL + "                                    String wktValue = new String(wkt.fromJGeometry(jGeom));" + NL;
  protected final String TEXT_404 = NL + "                                    ";
  protected final String TEXT_405 = ".";
  protected final String TEXT_406 = " = new Geometry(wktValue);";
  protected final String TEXT_407 = NL + "                                        ";
  protected final String TEXT_408 = ".";
  protected final String TEXT_409 = ".setEPSG(";
  protected final String TEXT_410 = ");";
  protected final String TEXT_411 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_412 = NL + "                                  ";
  protected final String TEXT_413 = ".";
  protected final String TEXT_414 = "=dcg_";
  protected final String TEXT_415 = ";";
  protected final String TEXT_416 = NL + "\t\t\t\t\t\t\t\t\t\tList<Object> list_";
  protected final String TEXT_417 = " = new java.util.ArrayList<Object>();" + NL + "\t\t\t\t\t    \t\t\t\tfor(int i_";
  protected final String TEXT_418 = " = ";
  protected final String TEXT_419 = "; i_";
  protected final String TEXT_420 = "  <= rsmd_";
  protected final String TEXT_421 = ".getColumnCount(); i_";
  protected final String TEXT_422 = " ++){" + NL + "\t\t\t\t\t\t \t\t\t\t\tif (\"NTEXT\".equals(rsmd_";
  protected final String TEXT_423 = ".getColumnTypeName(i_";
  protected final String TEXT_424 = " ).toUpperCase())) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.ClobImpl clob_";
  protected final String TEXT_425 = " = (net.sourceforge.jtds.jdbc.ClobImpl) rs_";
  protected final String TEXT_426 = ".getClob(i_";
  protected final String TEXT_427 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(clob_";
  protected final String TEXT_428 = "!=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.TalendNTextImpl tNTextImpl_";
  protected final String TEXT_429 = " = new net.sourceforge.jtds.jdbc.TalendNTextImpl(clob_";
  protected final String TEXT_430 = ");" + NL + "\t\t\t\t\t\t\t  \t\t\t\t\t\tlist_";
  protected final String TEXT_431 = ".add(tNTextImpl_";
  protected final String TEXT_432 = ".getValue());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_433 = ".add(null);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t}" + NL + "   \t \t\t\t\t    \t\t\t\t}" + NL + "                                 \t\t routines.system.DynamicUtils.readColumnsFromDatabase_Mssql(";
  protected final String TEXT_434 = ".";
  protected final String TEXT_435 = ", rs_";
  protected final String TEXT_436 = ", fixedColumnCount_";
  protected final String TEXT_437 = ",list_";
  protected final String TEXT_438 = ");";
  protected final String TEXT_439 = NL + "                                \t\t routines.system.DynamicUtils.readColumnsFromDatabase(";
  protected final String TEXT_440 = ".";
  protected final String TEXT_441 = ", rs_";
  protected final String TEXT_442 = ", fixedColumnCount_";
  protected final String TEXT_443 = ");";
  protected final String TEXT_444 = NL + "                                \torg.postgis.Geometry o = org.postgis.PGgeometry.geomFromString(rs_";
  protected final String TEXT_445 = ".getObject(";
  protected final String TEXT_446 = ").toString());" + NL + "                                \tStringBuffer sb = new StringBuffer();" + NL + "                                \to.outerWKT(sb, false);" + NL + "                                \t";
  protected final String TEXT_447 = ".";
  protected final String TEXT_448 = " = new Geometry(sb.toString());";
  protected final String TEXT_449 = NL + "\t\t                          ";
  protected final String TEXT_450 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_451 = NL + "\t\t                    }";
  protected final String TEXT_452 = NL + "\t\t                            ";
  protected final String TEXT_453 = ".";
  protected final String TEXT_454 = " = ";
  protected final String TEXT_455 = ".";
  protected final String TEXT_456 = ";" + NL + "\t\t                            ";
  protected final String TEXT_457 = NL + NL + "\t" + NL + "\t" + NL;
  protected final String TEXT_458 = NL;

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
	
		private INode node = null;
		
		public void beforeComponentProcess(INode node){
	    	super.beforeComponentProcess(node);
	    	this.node = node;
	    }
	
		public void setURL(INode node) {
			
			String localServiceName = ElementParameterParser.getValue(node, "__LOCAL_SERVICE_NAME__");
			String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
			String jdbcURL = ElementParameterParser.getValue(node, "__JDBC_URL__");
    		String rac_url = ElementParameterParser.getValue(node, "__RAC_URL__");

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
				if("ORACLE_RAC".equals(connectionType)) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(rac_url);
    stringBuffer.append(TEXT_95);
    
    			} else if(("ORACLE_SID").equals(connectionType)) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_100);
    
            	} else if(("ORACLE_SERVICE_NAME").equals(connectionType)) {

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_105);
    
            	} else if(("ORACLE_OCI").equals(connectionType)) {
            	    
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(localServiceName);
    stringBuffer.append(TEXT_108);
    
            	}else if(("ORACLE_WALLET").equals(connectionType)) {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(jdbcURL);
    stringBuffer.append(TEXT_111);
    
				}

    stringBuffer.append(TEXT_112);
    
		}
		
		public String getDirverClassName(INode node){
			String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__"); 
			if("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) ){
			    return "oracle.jdbc.OracleDriver";	
			}else {
				return "oracle.jdbc.driver.OracleDriver";	
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
	 		String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
	 		String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__"); 

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
                String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_119);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_120);
    this.setURL(node);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_125);
    
				if(("ORACLE_WALLET").equals(connectionType)) {

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    
				}else if (dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
				} else {

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
				}

    stringBuffer.append(TEXT_149);
    
			if(!"ORACLE_8".equals(dbVersion)){
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
			}
		}
		
		public void afterUseExistConnection(INode node) {
			String dbVersion =  ElementParameterParser.getValue(node, "__DB_VERSION__");
			if(!"ORACLE_8".equals(dbVersion)){
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    
			}
	    }
		
		public void createStatement(INode node) {
			
			String useCursor= ElementParameterParser.getValue(node, "__USE_CURSOR__");
			String cursorSize= ElementParameterParser.getValue(node, "__CURSOR_SIZE__");
			if(!("true").equals(useCursor)) {
				 super.createStatement(node);
			}else {
            	super.createMinValueStatement(node);

    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cursorSize );
    stringBuffer.append(TEXT_175);
    
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {
			String columnType = column.getType();
			if(columnType != null && ("CLOB").equals(columnType)) {

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_195);
    
			} else {

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_205);
    
			}
	    }
	    
	   	public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_215);
    
	    }
	    
	    public void generateTimestampResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    	boolean noNullValues = ("true").equals(ElementParameterParser.getValue(node, "__NO_NULL_VALUES__"));

	    	String dbType = column.getType();
	    	boolean isTSWithTZ = dbType.matches("TIMESTAMP WITH TIME ZONE");
	    	
	    	String dbVersion = "";
			String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
				String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
			    List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
			    for(INode targetNode : nodes){
			    	if (targetNode.getUniqueName().equals(connection)) {
				      dbVersion = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
				    }
			    }
			}else{
				dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
			}
	    	boolean supportTSTZ = false;
	    	if("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_10".equals(dbVersion)){
	    		supportTSTZ = true;
	    	}
	    	if(isTSWithTZ && supportTSTZ){
	    	
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_222);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_224);
    
    		}else{
	    		if(noNullValues){
				
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_229);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_231);
    
				}else{
				//super.generateTimestampResultSet(firstConnName,column,currentColNo);
				
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_240);
    
				}
			}
	    }

	   	public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {
		   	boolean noNullValues = ("true").equals(ElementParameterParser.getValue(node, "__NO_NULL_VALUES__"));
	   		boolean isConvert = ("true").equals(ElementParameterParser.getValue(node, "__IS_CONVERT_XMLTYPE__"));    
			List<Map<String, String>> convertColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONVERT_XMLTYPE__");  
	   		
			if(("Object").equals(typeToGenerate)){
			
				boolean needConvert = false;
	   			String convertToJavaType = "";
				if (isConvert && convertColumns.size() > 0) {
					for(java.util.Map<String, String> convertcolumn : convertColumns) {
						if (convertcolumn.get("REFCOL").equals(column.getLabel()) ) {
							needConvert = true;
							convertToJavaType = convertcolumn.get("CONVETTYPE");
						}
					}
				} 
				

    stringBuffer.append(TEXT_241);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    
				if (needConvert && "String".equals(convertToJavaType)) {

    stringBuffer.append(TEXT_248);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_250);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    
				} else {

    stringBuffer.append(TEXT_253);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_255);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    
				}

    stringBuffer.append(TEXT_258);
    
					if(column.isNullable()) {

    stringBuffer.append(TEXT_259);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_261);
    
					} else {

    stringBuffer.append(TEXT_262);
        
					}

    stringBuffer.append(TEXT_263);
    
			} else {
				if(noNullValues){

    stringBuffer.append(TEXT_264);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_269);
    
					if(("Boolean").equals(typeToGenerate)){
					
    stringBuffer.append(TEXT_270);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_274);
    
					}else if(("Bytes").equals(typeToGenerate) || ("BigDecimal").equals(typeToGenerate)){
					
    stringBuffer.append(TEXT_275);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_277);
    
					}else if(("Byte").equals(typeToGenerate) || ("Double").equals(typeToGenerate) || ("Float").equals(typeToGenerate) || ("Int").equals(typeToGenerate) || ("Long").equals(typeToGenerate) || ("Short").equals(typeToGenerate)){
					
    stringBuffer.append(TEXT_278);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_282);
    
					}else{
					
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_285);
    
					}
					
    stringBuffer.append(TEXT_286);
    
				}else{
				
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_294);
    
				}
				
    		
				if(column.isNullable()) {

    stringBuffer.append(TEXT_295);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_297);
    
				} else {

    stringBuffer.append(TEXT_298);
        
				}

    stringBuffer.append(TEXT_299);
    
			}
	    }	    
	    //---------end according schema type to generate ResultSet
	}//end class
	
	dbInputBeginUtil = new DBInputBeginUtil();

    stringBuffer.append(TEXT_300);
    
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

    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    
		    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
		        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		        String conn = "conn_" + connection;

    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    
                    INode connectionNode = null;
                    for (INode processNode : node.getProcess().getGeneratingNodes()) {
                        if(connection.equals(processNode.getUniqueName())) {
                            connectionNode = processNode;
                            break;
                        }
                    }
                    String alias = ElementParameterParser.getValue(connectionNode, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_312);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    
				dbInputBeginUtil.afterUseExistConnection(node);
		
		    } else {
				dbInputBeginUtil.createConnection(node);
		    }

    stringBuffer.append(TEXT_315);
    dbInputBeginUtil.createStatement(node);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(dbInputBeginUtil.getQueryString(node));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    
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
		    
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(metadata.getListColumns().size()-1);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
     if((DynamicDatePattern!=null) && (!"".equals(DynamicDatePattern)) && (!"\"\"".equals(DynamicDatePattern))) {
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(DynamicDatePattern);
    stringBuffer.append(TEXT_360);
     } 
    
		if (("oracle_id".equalsIgnoreCase(dbms))) {

    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    
		} else {

    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    
		}

    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    
		    }
		    
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    
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
		                    
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_389);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_390);
    
		                        typeToGenerate = dbInputBeginUtil.mappingType(typeToGenerate);
		  
		                        if(("Char").equals(typeToGenerate) || ("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_391);
    dbInputBeginUtil.generateStringCharAndCharacterSet(firstConnName, column,currentColNo, trimMethod, typeToGenerate, whetherTrimAllCol, whetherTrimCol);
    stringBuffer.append(TEXT_392);
    
		                        } else if(("Timestamp").equals(typeToGenerate)) {
		                        	if("vertica_id".equalsIgnoreCase(dbms) && "DATE".equalsIgnoreCase(column.getType())){

    stringBuffer.append(TEXT_393);
    dbInputBeginUtil.generateOthersResultSet(firstConnName, column,  currentColNo,  "Date");
    
									}else{

    stringBuffer.append(TEXT_394);
    dbInputBeginUtil.generateTimestampResultSet(firstConnName, column, currentColNo);
    
									}
		                         } else if (("List").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_395);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_399);
    
		                        } else if(("String").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_400);
    dbInputBeginUtil.generateStringResultSet(firstConnName, column, currentColNo,trimMethod);
    
								} else if("Geometry".equals(typeToGenerate) && type.indexOf("ORACLE") >= 0) {

    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_406);
    
                                    String sourceCRS = ElementParameterParser.getValue(node,"__CRS__");
                                    String forceCRS = ElementParameterParser.getValue(node,"__FORCE_CRS__");
                                    if (forceCRS.equals("true")) {

    stringBuffer.append(TEXT_407);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_409);
    stringBuffer.append(sourceCRS);
    stringBuffer.append(TEXT_410);
    
                                    }
								} else if(("Bytes").equals(typeToGenerate) && (columnType != null && (("LONG RAW").equals(columnType) || ("RAW").equals(columnType)))) {//oracle

    stringBuffer.append(TEXT_411);
    dbInputBeginUtil.generateBytesResultSet(firstConnName, column, currentColNo);
    
								} else if(("Dynamic").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_412);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
     //for bug TDI-20886
									if ("id_MSSQL".equalsIgnoreCase(dbms)) {

    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_438);
    
									}else{

    stringBuffer.append(TEXT_439);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    
									}
								} else if(typeToGenerate.equals("Geometry")) {

    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_448);
    
                 	            } else {

    stringBuffer.append(TEXT_449);
    dbInputBeginUtil.generateOthersResultSet( firstConnName, column,  currentColNo,  typeToGenerate);
    
		                        }

    stringBuffer.append(TEXT_450);
    dbInputBeginUtil.afterGenertorType( firstConnName, column,  currentColNo);
    stringBuffer.append(TEXT_451);
      
		                    currentColNo++;
		                }
		            }
		            if(conns.size() > 1) {
		                for(int connNO = 1 ; connNO < conns.size() ; connNO++) {
		                    IConnection conn2 = conns.get(connNO);
		                    if((conn2.getName().compareTo(firstConnName) != 0) && (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
		                        for(IMetadataColumn column:columnList){
		                            
    stringBuffer.append(TEXT_452);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_453);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_454);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_456);
     
		                        }
		                    }
		                }
		            }
		        }
		}
	}

    stringBuffer.append(TEXT_457);
    stringBuffer.append(TEXT_458);
    return stringBuffer.toString();
  }
}
