package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileOutputDelimitedMainJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedMainJava result = new TFileOutputDelimitedMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "    \t\t\t\tStringBuilder sb_";
  protected final String TEXT_4 = " = new StringBuilder();" + NL + "    \t\t        ";
  protected final String TEXT_5 = NL + "\t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tsynchronized (lockWrite) {" + NL + "\t\t        ";
  protected final String TEXT_7 = NL + "\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_8 = NL + "\t        \t\tif(isFirstCheckDyn_";
  protected final String TEXT_9 = " && (file_";
  protected final String TEXT_10 = ".length()==0)){" + NL + "\t                \t";
  protected final String TEXT_11 = NL + "    \t\t        if(isFirstCheckDyn_";
  protected final String TEXT_12 = " && file";
  protected final String TEXT_13 = ".length()==0){" + NL + "        \t\t        ";
  protected final String TEXT_14 = NL + "                            \t\tfileOutputDelimitedUtil_";
  protected final String TEXT_15 = ".putHeaderVaule_";
  protected final String TEXT_16 = "(out";
  protected final String TEXT_17 = ",OUT_DELIM_";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "    \t\t        \tout";
  protected final String TEXT_20 = ".write(\"";
  protected final String TEXT_21 = "\");" + NL + "        \t\t         ";
  protected final String TEXT_22 = NL + "\t    \t\t        routines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = ", out";
  protected final String TEXT_25 = ", OUT_DELIM_";
  protected final String TEXT_26 = "); " + NL + "    \t    \t\t     ";
  protected final String TEXT_27 = NL + "                        out";
  protected final String TEXT_28 = ".write(OUT_DELIM_";
  protected final String TEXT_29 = ");" + NL + "        \t\t         ";
  protected final String TEXT_30 = NL + "                        out";
  protected final String TEXT_31 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_32 = ");" + NL + "                        isFirstCheckDyn_";
  protected final String TEXT_33 = " = false;" + NL + "    \t\t        }" + NL + "\t\t        ";
  protected final String TEXT_34 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_35 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_36 = NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_37 = NL + "    \t\t                    ";
  protected final String TEXT_38 = NL + "                            fileOutputDelimitedUtil_";
  protected final String TEXT_39 = ".putVaule_";
  protected final String TEXT_40 = "(";
  protected final String TEXT_41 = ",sb_";
  protected final String TEXT_42 = ",OUT_DELIM_";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = "   \t\t\t\t" + NL + "    \t    \t\t\t\tif(";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = " != null) {" + NL + "        \t\t\t\t    ";
  protected final String TEXT_47 = NL + "    \t\t\t\t    routines.system.DynamicUtils.writeValuesToStringBuilder(";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = ", sb_";
  protected final String TEXT_50 = ", OUT_DELIM_";
  protected final String TEXT_51 = ");" + NL + "    \t\t\t\t    ";
  protected final String TEXT_52 = NL + "    \t\t\t\t\tsb_";
  protected final String TEXT_53 = ".append(" + NL + "    \t\t\t        ";
  protected final String TEXT_54 = NL + "    \t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = ", ";
  protected final String TEXT_57 = ")" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_58 = NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_59 = NL + "        \t\t\t\t\t\t\tFormatterUtils.format_Number(";
  protected final String TEXT_60 = ".toPlainString(), ";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ")\t\t\t\t\t" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_63 = NL + "        \t\t\t\t\t\t\tFormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = ")).toPlainString(), ";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ")\t\t\t\t\t\t" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_69 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_70 = ".toPlainString()" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_71 = NL + "    \t\t\t\t\t\tjava.nio.charset.Charset.forName(";
  protected final String TEXT_72 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_73 = ".";
  protected final String TEXT_74 = ")).toString()" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_75 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_78 = NL + "    \t\t\t\t\t);" + NL + "    \t\t\t\t\t";
  protected final String TEXT_79 = NL + "    \t\t\t\t\t    } " + NL + "    \t\t\t\t\t";
  protected final String TEXT_80 = "\t\t\t\t\t" + NL + "    \t\t\t            sb_";
  protected final String TEXT_81 = ".append(OUT_DELIM_";
  protected final String TEXT_82 = ");" + NL + "    \t\t\t            ";
  protected final String TEXT_83 = NL + "    \t\t        sb_";
  protected final String TEXT_84 = ".append(OUT_DELIM_ROWSEP_";
  protected final String TEXT_85 = ");" + NL + "    \t\t" + NL + "    \t\t\t\t" + NL + "    \t\t\t\t";
  protected final String TEXT_86 = NL + "    \t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "    \t\t\t\t";
  protected final String TEXT_87 = NL + "    \t\t\t\tsynchronized (lockWrite) {" + NL + "    \t\t        ";
  protected final String TEXT_88 = NL + "\t\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_89 = NL + "    \t\t        nb_line_";
  protected final String TEXT_90 = "++;" + NL + "    \t\t        ";
  protected final String TEXT_91 = NL + "    \t\t            if(currentRow_";
  protected final String TEXT_92 = " % splitEvery_";
  protected final String TEXT_93 = "==0 && currentRow_";
  protected final String TEXT_94 = "!=0){" + NL + "    \t\t                splitedFileNo_";
  protected final String TEXT_95 = "++;" + NL + "    \t\t                out";
  protected final String TEXT_96 = ".close(); " + NL + "    \t\t                //close original outputStream" + NL + "    \t\t                out";
  protected final String TEXT_97 = " = new ";
  protected final String TEXT_98 = "(new java.io.OutputStreamWriter(" + NL + "    \t\t                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_99 = " + splitedFileNo_";
  protected final String TEXT_100 = " + extension_";
  protected final String TEXT_101 = ", ";
  protected final String TEXT_102 = "),";
  protected final String TEXT_103 = "));" + NL + "    \t\t                file";
  protected final String TEXT_104 = " = new java.io.File(fullName_";
  protected final String TEXT_105 = " + splitedFileNo_";
  protected final String TEXT_106 = " + extension_";
  protected final String TEXT_107 = ");  \t\t\t\t\t" + NL + "    " + NL + "    \t\t                ";
  protected final String TEXT_108 = NL + "    \t\t                    if(file";
  protected final String TEXT_109 = ".length()==0){  " + NL + "    \t\t                        ";
  protected final String TEXT_110 = NL + "                            \t\t\tfileOutputDelimitedUtil_";
  protected final String TEXT_111 = ".putHeaderVaule_";
  protected final String TEXT_112 = "(out";
  protected final String TEXT_113 = ",OUT_DELIM_";
  protected final String TEXT_114 = ");";
  protected final String TEXT_115 = NL + "    \t\t                            out";
  protected final String TEXT_116 = ".write(\"";
  protected final String TEXT_117 = "\");" + NL + "    \t\t                            ";
  protected final String TEXT_118 = NL + "\t    \t\t            \t\t\troutines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = ", out";
  protected final String TEXT_121 = ", OUT_DELIM_";
  protected final String TEXT_122 = "); " + NL + "\t    \t\t            \t\t\t";
  protected final String TEXT_123 = NL + "    \t\t                                out";
  protected final String TEXT_124 = ".write(OUT_DELIM_";
  protected final String TEXT_125 = ");" + NL + "    \t\t                                ";
  protected final String TEXT_126 = NL + "    \t\t                        out";
  protected final String TEXT_127 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_128 = ");" + NL + "    \t\t                    }\t" + NL + "    \t\t                    ";
  protected final String TEXT_129 = NL + "    \t\t                out";
  protected final String TEXT_130 = ".write(sb_";
  protected final String TEXT_131 = ".toString());" + NL + "    \t\t                ";
  protected final String TEXT_132 = NL + "        \t\t                if(nb_line_";
  protected final String TEXT_133 = "%";
  protected final String TEXT_134 = " == 0) {" + NL + "        \t\t                out";
  protected final String TEXT_135 = ".flush();" + NL + "        \t\t                }" + NL + "    \t\t                    ";
  protected final String TEXT_136 = " \t\t\t" + NL + "    \t\t            }else{" + NL + "    \t\t                out";
  protected final String TEXT_137 = ".write(sb_";
  protected final String TEXT_138 = ".toString());" + NL + "    \t\t                ";
  protected final String TEXT_139 = NL + "        \t\t                if(nb_line_";
  protected final String TEXT_140 = "%";
  protected final String TEXT_141 = " == 0) {" + NL + "        \t\t                out";
  protected final String TEXT_142 = ".flush();" + NL + "        \t\t                }" + NL + "    \t\t                    ";
  protected final String TEXT_143 = "  \t\t\t" + NL + "    \t\t            }\t" + NL + "    \t\t            currentRow_";
  protected final String TEXT_144 = "++;\t\t\t\t" + NL + "    \t\t\t" + NL + "    " + NL + "    \t\t            ";
  protected final String TEXT_145 = NL + "    \t\t" + NL + "    \t\t            out";
  protected final String TEXT_146 = ".write(sb_";
  protected final String TEXT_147 = ".toString());" + NL + "    \t\t            ";
  protected final String TEXT_148 = NL + "        \t\t                if(nb_line_";
  protected final String TEXT_149 = "%";
  protected final String TEXT_150 = " == 0) {" + NL + "        \t\t                out";
  protected final String TEXT_151 = ".flush();" + NL + "        \t\t                }" + NL + "    \t\t                ";
  protected final String TEXT_152 = "     \t\t\t" + NL + "    \t\t            ";
  protected final String TEXT_153 = NL + "    \t\t        ";
  protected final String TEXT_154 = NL + "    \t\t\t\t} " + NL + "    \t\t        ";
  protected final String TEXT_155 = NL + "    \t\t\t\t} " + NL + "    \t\t        ";
  protected final String TEXT_156 = NL + "    \t\t\t\t}" + NL + "    \t\t\t\t";
  protected final String TEXT_157 = " \t\t\t" + NL + "    \t\t        " + NL + "    \t\t        ";
  protected final String TEXT_158 = NL;
  protected final String TEXT_159 = NL;
  protected final String TEXT_160 = NL + "\t\t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\t\t\tsynchronized (lockWrite) {" + NL + "\t        \t\t\t\t";
  protected final String TEXT_162 = NL + "        \t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "        \t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_163 = NL + "        \t\t\t\tif(isFirstCheckDyn_";
  protected final String TEXT_164 = " && (file_";
  protected final String TEXT_165 = ".length()==0)){" + NL + "        \t\t\t\t\theadColu";
  protected final String TEXT_166 = " = new String[";
  protected final String TEXT_167 = "-1+";
  protected final String TEXT_168 = ".";
  protected final String TEXT_169 = ".getColumnCount()];" + NL + "            \t\t\t\t";
  protected final String TEXT_170 = NL + "            \t\t\tif(isFirstCheckDyn_";
  protected final String TEXT_171 = " && file";
  protected final String TEXT_172 = ".length()==0){" + NL + "            \t\t\t\theadColu";
  protected final String TEXT_173 = " = new String[";
  protected final String TEXT_174 = "-1+";
  protected final String TEXT_175 = ".";
  protected final String TEXT_176 = ".getColumnCount()];" + NL + "            \t\t\t";
  protected final String TEXT_177 = NL + "                            \t\tfileOutputDelimitedUtil_";
  protected final String TEXT_178 = ".putHeaderVaule_";
  protected final String TEXT_179 = "(headColu";
  protected final String TEXT_180 = ");";
  protected final String TEXT_181 = NL + "        \t\t        \theadColu";
  protected final String TEXT_182 = "[";
  protected final String TEXT_183 = "]=\"";
  protected final String TEXT_184 = "\";" + NL + "            \t\t         ";
  protected final String TEXT_185 = NL + "        \t    \t\t     for(int mi=0;mi<";
  protected final String TEXT_186 = ".";
  protected final String TEXT_187 = ".getColumnCount();mi++){" + NL + "        \t    \t\t     \theadColu";
  protected final String TEXT_188 = "[";
  protected final String TEXT_189 = "+mi]=";
  protected final String TEXT_190 = ".";
  protected final String TEXT_191 = ".getColumnMetadata(mi).getName();" + NL + "        \t    \t\t     }" + NL + "        \t    \t\t     ";
  protected final String TEXT_192 = NL + "                            CsvWriter";
  protected final String TEXT_193 = ".writeNext(headColu";
  protected final String TEXT_194 = ");" + NL + "        \t            \tCsvWriter";
  protected final String TEXT_195 = ".flush();" + NL + "        \t            \t";
  protected final String TEXT_196 = NL + "        \t            \tout";
  protected final String TEXT_197 = ".write(strWriter";
  protected final String TEXT_198 = ".getBuffer().toString());" + NL + "        \t            \tout";
  protected final String TEXT_199 = ".flush();" + NL + "        \t            \tstrWriter";
  protected final String TEXT_200 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_201 = ".getBuffer().length()); \t" + NL + "                    \t\t";
  protected final String TEXT_202 = NL + "        \t            }" + NL + "            \t        ";
  protected final String TEXT_203 = NL + "\t\t\t\t\t} " + NL + "            \t        ";
  protected final String TEXT_204 = NL + "\t\t\t\t\t} " + NL + "            \t        ";
  protected final String TEXT_205 = NL + "\t\t\t\t\t}" + NL + "            \t\t\t";
  protected final String TEXT_206 = NL + "        \t            if(isFirstCheckDyn_";
  protected final String TEXT_207 = "){" + NL + "                    \t\tCsvWriter";
  protected final String TEXT_208 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_209 = ".getEscapeChar());" + NL + "            \t\t\t\tCsvWriter";
  protected final String TEXT_210 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_211 = ".getTextEnclosure());" + NL + "            \t\t\t\tCsvWriter";
  protected final String TEXT_212 = ".setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);" + NL + "                    \t\tisFirstCheckDyn_";
  protected final String TEXT_213 = " = false;" + NL + "                    \t}";
  protected final String TEXT_214 = "  \t" + NL + "                    \tString[] row";
  protected final String TEXT_215 = "=new String[";
  protected final String TEXT_216 = "];\t\t" + NL + "                    \t";
  protected final String TEXT_217 = NL + "                            \tfileOutputDelimitedUtil_";
  protected final String TEXT_218 = ".putVaule_";
  protected final String TEXT_219 = "(";
  protected final String TEXT_220 = ",row";
  protected final String TEXT_221 = ");";
  protected final String TEXT_222 = NL + "                            if (";
  protected final String TEXT_223 = ".";
  protected final String TEXT_224 = " != null) {" + NL + "                            \troutines.system.DynamicUtils.writeValuesToStringArray(";
  protected final String TEXT_225 = ".";
  protected final String TEXT_226 = ", row";
  protected final String TEXT_227 = ", ";
  protected final String TEXT_228 = ");" + NL + "                            }" + NL + "                \t\t\t";
  protected final String TEXT_229 = " " + NL + "                \t\t\trow";
  protected final String TEXT_230 = "[";
  protected final String TEXT_231 = "]=";
  protected final String TEXT_232 = ".";
  protected final String TEXT_233 = ";" + NL + "                \t\t\t";
  protected final String TEXT_234 = "FormatterUtils.format_Date(";
  protected final String TEXT_235 = ".";
  protected final String TEXT_236 = ", ";
  protected final String TEXT_237 = ");" + NL + "                \t\t\t";
  protected final String TEXT_238 = "java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_239 = ".";
  protected final String TEXT_240 = ")).toString();" + NL + "                \t\t\t";
  protected final String TEXT_241 = "FormatterUtils.format_Number(";
  protected final String TEXT_242 = ".toPlainString(), ";
  protected final String TEXT_243 = ", ";
  protected final String TEXT_244 = ");\t\t\t\t\t" + NL + "                \t\t\t";
  protected final String TEXT_245 = "FormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_246 = ".";
  protected final String TEXT_247 = ")).toPlainString(), ";
  protected final String TEXT_248 = ", ";
  protected final String TEXT_249 = ");\t\t\t\t\t\t" + NL + "                \t\t\t";
  protected final String TEXT_250 = ".toPlainString();" + NL + "                \t\t\t";
  protected final String TEXT_251 = "String.valueOf(";
  protected final String TEXT_252 = ".";
  protected final String TEXT_253 = ");" + NL + "                \t\t\t";
  protected final String TEXT_254 = NL + "    \t\t\tsynchronized (multiThreadLockWrite) {";
  protected final String TEXT_255 = NL + "\t\t\t\tsynchronized (lockWrite) {";
  protected final String TEXT_256 = NL + "\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\tsynchronized (pLockWrite) {";
  protected final String TEXT_257 = NL + "\t\t\t\tnb_line_";
  protected final String TEXT_258 = "++;";
  protected final String TEXT_259 = NL + "            \t\t\t    if(currentRow_";
  protected final String TEXT_260 = " % splitEvery_";
  protected final String TEXT_261 = "==0 && currentRow_";
  protected final String TEXT_262 = "!=0){" + NL + "            \t\t\t        splitedFileNo_";
  protected final String TEXT_263 = "++;" + NL + "            \t\t\t        CsvWriter";
  protected final String TEXT_264 = ".close(); " + NL + "            \t\t\t        //close original outputStream" + NL + "            \t\t\t        ";
  protected final String TEXT_265 = NL + "            \t\t\t        out";
  protected final String TEXT_266 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "\t\t\t\t\t\t\t\t\tnew java.io.FileOutputStream(fullName_";
  protected final String TEXT_267 = " + splitedFileNo_";
  protected final String TEXT_268 = " + extension_";
  protected final String TEXT_269 = ", ";
  protected final String TEXT_270 = "),";
  protected final String TEXT_271 = "));" + NL + "\t\t\t\t\t\t\t\tstrWriter";
  protected final String TEXT_272 = " = new java.io.StringWriter();" + NL + "            \t                CsvWriter";
  protected final String TEXT_273 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_274 = ");" + NL + "            \t                CsvWriter";
  protected final String TEXT_275 = ".setSeparator(csvSettings_";
  protected final String TEXT_276 = ".getFieldDelim());" + NL + "            \t                ";
  protected final String TEXT_277 = NL + "            \t                CsvWriter";
  protected final String TEXT_278 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "\t\t\t\t\t\t\t\t\tnew java.io.FileOutputStream(fullName_";
  protected final String TEXT_279 = " + splitedFileNo_";
  protected final String TEXT_280 = " + extension_";
  protected final String TEXT_281 = ", ";
  protected final String TEXT_282 = "),";
  protected final String TEXT_283 = ")));" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_284 = ".setSeparator(csvSettings_";
  protected final String TEXT_285 = ".getFieldDelim());" + NL + "            \t                ";
  protected final String TEXT_286 = NL + "    \t\t\t            \tif(csvSettings_";
  protected final String TEXT_287 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_288 = ".getRowDelim()!='\\n')" + NL + "    \t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_289 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_290 = ".getRowDelim());" + NL + "            \t\t\t        //set header." + NL + "            \t\t\t        ";
  protected final String TEXT_291 = NL + "            \t\t\t            CsvWriter";
  protected final String TEXT_292 = ".writeNext(headColu";
  protected final String TEXT_293 = ");" + NL + "            \t\t\t            ";
  protected final String TEXT_294 = "\t" + NL + "            \t\t\t            out";
  protected final String TEXT_295 = ".write(strWriter";
  protected final String TEXT_296 = ".getBuffer().toString());" + NL + "               \t\t\t\t\t\tstrWriter";
  protected final String TEXT_297 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_298 = ".getBuffer().length());" + NL + "            \t\t\t            ";
  protected final String TEXT_299 = NL + "                                    file";
  protected final String TEXT_300 = " = new java.io.File(fullName_";
  protected final String TEXT_301 = " + splitedFileNo_";
  protected final String TEXT_302 = " + extension_";
  protected final String TEXT_303 = ");" + NL + "                        \t\t    if(file";
  protected final String TEXT_304 = ".length() == 0) {" + NL + "                        \t\t        CsvWriter";
  protected final String TEXT_305 = ".writeNext(headColu";
  protected final String TEXT_306 = "); " + NL + "                        \t\t        ";
  protected final String TEXT_307 = NL + "                        \t\t        out";
  protected final String TEXT_308 = ".write(strWriter";
  protected final String TEXT_309 = ".getBuffer().toString());" + NL + "                \t\t\t\t\t\tstrWriter";
  protected final String TEXT_310 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_311 = ".getBuffer().length());" + NL + "                \t\t\t\t\t\t";
  protected final String TEXT_312 = NL + "                       \t\t    \t}\t  " + NL + "                        \t\t    ";
  protected final String TEXT_313 = NL + "                        \t\t//initialize new CsvWriter information" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_314 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_315 = ".getEscapeChar());" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_316 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_317 = ".getTextEnclosure());" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_318 = ".setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);" + NL + "\t\t\t\t\t      \t\t        \t\t" + NL + "                        \t\tCsvWriter";
  protected final String TEXT_319 = ".writeNext(row";
  protected final String TEXT_320 = ");" + NL + "                        \t\t";
  protected final String TEXT_321 = NL + "                        \t\tout";
  protected final String TEXT_322 = ".write(strWriter";
  protected final String TEXT_323 = ".getBuffer().toString());" + NL + "                \t\t\t\tstrWriter";
  protected final String TEXT_324 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_325 = ".getBuffer().length());" + NL + "                        \t\t";
  protected final String TEXT_326 = NL + "            \t\t                if(nb_line_";
  protected final String TEXT_327 = "%";
  protected final String TEXT_328 = " == 0) {" + NL + "            \t\t                ";
  protected final String TEXT_329 = NL + "            \t\t                out";
  protected final String TEXT_330 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_331 = NL + "            \t\t                CsvWriter";
  protected final String TEXT_332 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_333 = NL + "            \t\t                }" + NL + "                        \t\t    ";
  protected final String TEXT_334 = " " + NL + "         \t\t\t\t" + NL + "         \t\t\t\t\t}else{" + NL + "         \t\t\t\t\t    CsvWriter";
  protected final String TEXT_335 = ".writeNext(row";
  protected final String TEXT_336 = ");\t" + NL + "         \t\t\t\t\t    ";
  protected final String TEXT_337 = NL + "         \t\t\t\t\t    out";
  protected final String TEXT_338 = ".write(strWriter";
  protected final String TEXT_339 = ".getBuffer().toString());" + NL + "                \t\t\t\tstrWriter";
  protected final String TEXT_340 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_341 = ".getBuffer().length());" + NL + "         \t\t\t\t\t    ";
  protected final String TEXT_342 = NL + "            \t\t                if(nb_line_";
  protected final String TEXT_343 = "%";
  protected final String TEXT_344 = " == 0) {" + NL + "            \t\t                ";
  protected final String TEXT_345 = NL + "            \t\t                out";
  protected final String TEXT_346 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_347 = NL + "            \t\t                CsvWriter";
  protected final String TEXT_348 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_349 = NL + "            \t\t                }" + NL + "         \t\t\t\t\t        ";
  protected final String TEXT_350 = "  \t\t\t\t\t" + NL + "         \t\t\t\t\t}\t" + NL + "            \t\t\t    currentRow_";
  protected final String TEXT_351 = "++;\t\t" + NL + "             \t\t\t" + NL + "            \t\t\t    ";
  protected final String TEXT_352 = NL + "            \t\t\t    CsvWriter";
  protected final String TEXT_353 = ".writeNext(row";
  protected final String TEXT_354 = ");\t" + NL + "            \t\t\t    ";
  protected final String TEXT_355 = NL + "            \t\t\t    out";
  protected final String TEXT_356 = ".write(strWriter";
  protected final String TEXT_357 = ".getBuffer().toString());" + NL + "                \t\t\tstrWriter";
  protected final String TEXT_358 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_359 = ".getBuffer().length());" + NL + "            \t\t\t    ";
  protected final String TEXT_360 = NL + "            \t\t                if(nb_line_";
  protected final String TEXT_361 = "%";
  protected final String TEXT_362 = " == 0) {" + NL + "            \t\t                ";
  protected final String TEXT_363 = NL + "            \t\t                out";
  protected final String TEXT_364 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_365 = NL + "            \t\t                CsvWriter";
  protected final String TEXT_366 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_367 = NL + "            \t\t                }" + NL + "            \t\t\t        ";
  protected final String TEXT_368 = "  \t\t\t\t" + NL + "            \t\t\t    ";
  protected final String TEXT_369 = NL + "    \t\t\t} ";
  protected final String TEXT_370 = NL + "\t\t\t\t}";
  protected final String TEXT_371 = NL + "    \t\t\t}";
  protected final String TEXT_372 = NL + "            \t\t\t" + NL + "            \t\t\t";
  protected final String TEXT_373 = NL;
  protected final String TEXT_374 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_2);
    
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
                        
            String fieldSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__FIELDSEPARATOR__",
                "FIELDSEPARATOR"
            );
            
            String rowSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__ROWSEPARATOR__",
                "ROWSEPARATOR"
            );
            
            String encoding = ElementParameterParser.getValue(
                node,
                "__ENCODING__"
            );
            
            boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
            
            boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
    		String fileNewname = ElementParameterParser.getValue(node,"__FILENAME__");
    		
    		boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
    		
    		boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
            
            boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
            String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
            
    		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
   		    
			String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
			boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
			
			boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
			
			boolean hasDynamic = metadata.isDynamicSchema();

        	List< ? extends IConnection> conns = node.getIncomingConnections();
        	for (IConnection conn : conns) {
        		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        			List<IMetadataColumn> columns = metadata.getListColumns();
        			int sizeColumns = columns.size();
        		    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
	                if(isIncludeHeader && hasDynamic){
						if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_5);
    
    					}
    					if (codeGenArgument.subTreeContainsParallelIterate()) {
				
    stringBuffer.append(TEXT_6);
     
    		        	}
    		        	if (isParallelize) {
				
    stringBuffer.append(TEXT_7);
     
						}
	                	if(!split && compress && !isAppend){
	                	
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
	                	}else{
    		        
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
        		        }
                    	for (int i = 0; i < sizeColumns; i++) {
                            IMetadataColumn column = columns.get(i);
                            if(sizeColumns> schemaOptNum){
                            	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    
                            	}
                            }else{//AA
                            if(!("id_Dynamic".equals(column.getTalendType()))) {
        		         
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_21);
    
        		            }else{
    	    		     
    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
        		            }
        		            if(i != sizeColumns - 1) {
        		         
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
                            }
                            }//AA
                        }
        		        
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
     
		        		if (isParallelize) {
				
    stringBuffer.append(TEXT_34);
    
		        		}
						if (codeGenArgument.subTreeContainsParallelIterate()) {
				
    stringBuffer.append(TEXT_35);
    
		        		}
		        		if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_36);
    
						}
		        
    stringBuffer.append(TEXT_37);
    
    		        }					  
        			for (int i = 0; i < sizeColumns; i++) {
      			
        				IMetadataColumn column = columns.get(i);
    					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
    					if(sizeColumns> schemaOptNum){
                            if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    
                            }
                        }else{//BB
    					if(!isPrimitive) {
    					    
    stringBuffer.append(TEXT_44);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_46);
    
    				    } 
    				    if(column.getTalendType().equals("id_Dynamic")){
    				    
    stringBuffer.append(TEXT_47);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
    				    }else{
    				    
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    
    			        	String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    			        	if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
    			            
    stringBuffer.append(TEXT_54);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_57);
    	
    						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
							
    stringBuffer.append(TEXT_58);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_62);
     } else { 
    stringBuffer.append(TEXT_63);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_67);
     } 
    stringBuffer.append(TEXT_68);
    
							} else if(javaType == JavaTypesManager.BIGDECIMAL){
    						
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_70);
    
							} else if(javaType == JavaTypesManager.BYTE_ARRAY){
    						
    stringBuffer.append(TEXT_71);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_74);
    
    			        	} else {
    			            
    stringBuffer.append(TEXT_75);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_77);
    				
    			        	}
    			        
    stringBuffer.append(TEXT_78);
    
    					}
    					if(!isPrimitive) {
    					    
    stringBuffer.append(TEXT_79);
    
    			        } 
    			        if(i != sizeColumns - 1) {
    			            
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    
    			        }
    			        }//BB
    		        }
    		        
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    
    					if(codeGenArgument.getIsRunInMultiThread()){
    				
    stringBuffer.append(TEXT_86);
    
    					}
    					if (codeGenArgument.subTreeContainsParallelIterate()) {
    				
    stringBuffer.append(TEXT_87);
     
    		        	}
    		        	if (isParallelize) {
  					
    stringBuffer.append(TEXT_88);
     
						}
    		        
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    
    		        // add a prerequisite useStream to support output stream feature:8873
    		        if(!useStream && split){ 
    		            
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(isInRowMode?"routines.system.BufferedOutput":"java.io.BufferedWriter");
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append( isAppend);
    stringBuffer.append(TEXT_102);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
    		                if(isIncludeHeader){
    		                    
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    		
    		                        //List<IMetadataColumn> columns = metadata.getListColumns();
    		                        //int sizeColumns = columns.size();
    		                        for (int i = 0; i < sizeColumns; i++) {
    		                            IMetadataColumn column = columns.get(i);
										if(sizeColumns> schemaOptNum){
                            				if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    
                            				}
                           			 	}else{//CC
    		                            if(!("id_Dynamic".equals(column.getTalendType()))) {
    		                            
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_117);
    
    		                            }else{
	    		            			
    stringBuffer.append(TEXT_118);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    
    		                            }
    		                            if(i != sizeColumns - 1) {
    		                                
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    
    		                            }
    		                            }//CC
    		                        }
    		                        
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    
    		                }
    		                
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
     
    		                if(flushOnRow) { 
    		                    
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    
    		                }
    		                
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
     
    		                if(flushOnRow) { 
    		                    
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    
    		                }
    		                
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
     
    		        } else { 
    		            
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
     
    		            if(flushOnRow) { 
    		                
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    
    		            }
    		            
    stringBuffer.append(TEXT_152);
    
    		        }
    		        
    stringBuffer.append(TEXT_153);
     
    		        	if (isParallelize) {
    				
    stringBuffer.append(TEXT_154);
    
    		        	}
    					if (codeGenArgument.subTreeContainsParallelIterate()) {
    				
    stringBuffer.append(TEXT_155);
    
    		        	}
    		        	if(codeGenArgument.getIsRunInMultiThread()){
    				
    stringBuffer.append(TEXT_156);
    
    					}
    		        
    stringBuffer.append(TEXT_157);
    
    	        }
            }
        }
    }
    
    stringBuffer.append(TEXT_158);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{//the following is the tFileOutputCSV component
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_159);
    
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {                                    
            String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    		String delim = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
        	boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
        	boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));

        	boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
        	
        	boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
        	
        	boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
        	String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
        	
    		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);        	
        	
        	String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
			boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
        	
        	List< ? extends IConnection> conns = node.getIncomingConnections();
        	
        	boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
        	
        	boolean hasDynamic = metadata.isDynamicSchema();
        	IMetadataColumn dynamicCol = metadata.getDynamicColumn();
        	
        	if(conns!=null){
        		if (conns.size()>0){
        		    IConnection conn =conns.get(0);
            		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        				List<IMetadataColumn> columns = metadata.getListColumns();
            			int sizeColumns = columns.size();
            			if(isIncludeHeader && hasDynamic){

							if(codeGenArgument.getIsRunInMultiThread()){
							
    stringBuffer.append(TEXT_160);
    
            				}
            				if (codeGenArgument.subTreeContainsParallelIterate()) {
							
    stringBuffer.append(TEXT_161);
     
            	        	}
            	        	if (isParallelize) {
							
    stringBuffer.append(TEXT_162);
     
							}
            				if(!split && compress && !isAppend){
            				
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_168);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_169);
    
            				}else{
            			
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_176);
    
            				}
                        	for (int i = 0; i < sizeColumns; i++) {
                                IMetadataColumn column = columns.get(i);
								if(sizeColumns> schemaOptNum){
                            		if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    
                            		}
                            	}else{//DD
                                if(!("id_Dynamic".equals(column.getTalendType()))) {
            		         
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_184);
    
            		            }else{
        	    		     
    stringBuffer.append(TEXT_185);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_191);
    
            		            }
            		            }//DD
                            }
                            
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    if(isInRowMode){
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    }
    stringBuffer.append(TEXT_202);
     
            	        	if (isParallelize) {
            			
    stringBuffer.append(TEXT_203);
    
            	        	}
            				if (codeGenArgument.subTreeContainsParallelIterate()) {
            			
    stringBuffer.append(TEXT_204);
    
            	        	}
            	        	if(codeGenArgument.getIsRunInMultiThread()){
            			
    stringBuffer.append(TEXT_205);
    
            				}
            	        
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    
            			}
            			
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(hasDynamic?"+"+conn.getName()+".":"" );
    stringBuffer.append(dynamicCol==null?"":dynamicCol.getLabel()+".getColumnCount()-1" );
    stringBuffer.append(TEXT_216);
    
            			for (int i = 0; i < sizeColumns; i++) {
                			IMetadataColumn column = columns.get(i);
                			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                			boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
							if(sizeColumns> schemaOptNum){
                            	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    
                            	}
                            }else{//EE
                			if(("id_Dynamic").equals(column.getTalendType())) {
                			
    stringBuffer.append(TEXT_222);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_223);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_224);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_225);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_228);
    
                			}else{
                			
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ "==null?\"\":");
    					
                				if(javaType == JavaTypesManager.STRING ){
                			
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_233);
    
                				}else if(javaType == JavaTypesManager.DATE && pattern != null){
                			
    stringBuffer.append(TEXT_234);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_236);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_237);
    
                				}else if(javaType == JavaTypesManager.BYTE_ARRAY){
                			
    stringBuffer.append(TEXT_238);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_240);
    
                				} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        							if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_241);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_242);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_243);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_244);
      	} else { 
    stringBuffer.append(TEXT_245);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_248);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_249);
    		}
        						} else if (javaType == JavaTypesManager.BIGDECIMAL) {
							
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_250);
    
                			 	} else{
                			
    stringBuffer.append(TEXT_251);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_253);
    
                				}
                			}
                			}//EE
            			}

        					if(codeGenArgument.getIsRunInMultiThread()){

    stringBuffer.append(TEXT_254);
    
    					}
    					if (codeGenArgument.subTreeContainsParallelIterate()) {

    stringBuffer.append(TEXT_255);
    
						}
						if (isParallelize) {

    stringBuffer.append(TEXT_256);
    
						}

    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    
            			if(!useStream && split){
            			    
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    if(isInRowMode){
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    }else{
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    }
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    
            			        if(isIncludeHeader && !isAppend){
            			            
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    if(isInRowMode){
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    }
            			        }
            			        if(isIncludeHeader && isAppend){
            			            
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    if(isInRowMode){
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    }
    stringBuffer.append(TEXT_312);
    
            			        }
                        		
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    if(isInRowMode){
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    }
                        		if(flushOnRow) { 
                        		    
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_328);
    if(isInRowMode){
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    }else{
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    }
    stringBuffer.append(TEXT_333);
    
                    			}
                        		
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    if(isInRowMode){
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    }
         					    if(flushOnRow) { 
         					        
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_344);
    if(isInRowMode){
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    }else{
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    }
    stringBuffer.append(TEXT_349);
    
         					    }
         					    
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    
            			}else{
            			    
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    if(isInRowMode){
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    }
            			    if(flushOnRow) { 
            			        
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_362);
    if(isInRowMode){
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    }else{
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    }
    stringBuffer.append(TEXT_367);
    
                			}
            			    
    stringBuffer.append(TEXT_368);
       		
            		
            			}
            			
     
						if ( isParallelize) {

    stringBuffer.append(TEXT_369);
    
    		        	}
    					if (codeGenArgument.subTreeContainsParallelIterate()) {

    stringBuffer.append(TEXT_370);
    
						}
						if(codeGenArgument.getIsRunInMultiThread()){

    stringBuffer.append(TEXT_371);
    
    					}

    stringBuffer.append(TEXT_372);
       		
            		}
        		
        		}
        	}	
    	
        }
    
    }
    
    stringBuffer.append(TEXT_373);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

    stringBuffer.append(TEXT_374);
    return stringBuffer.toString();
  }
}
