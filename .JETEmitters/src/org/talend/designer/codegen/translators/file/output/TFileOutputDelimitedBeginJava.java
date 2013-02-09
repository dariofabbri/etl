package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;

public class TFileOutputDelimitedBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedBeginJava result = new TFileOutputDelimitedBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "String fileName_";
  protected final String TEXT_3 = " = \"\";";
  protected final String TEXT_4 = NL + "\tclass FileOutputDelimitedUtil_";
  protected final String TEXT_5 = "{";
  protected final String TEXT_6 = NL + "\t\tpublic void putHeaderVaule_";
  protected final String TEXT_7 = "(java.io.Writer out";
  protected final String TEXT_8 = ",final String OUT_DELIM_";
  protected final String TEXT_9 = ")throws Exception{";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\t\t\t\tout";
  protected final String TEXT_11 = ".write(\"";
  protected final String TEXT_12 = "\");";
  protected final String TEXT_13 = NL + "\t\t\t\t\t\t\t\t\troutines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ", out";
  protected final String TEXT_16 = ", OUT_DELIM_";
  protected final String TEXT_17 = "); ";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\t\t\t\tout";
  protected final String TEXT_19 = ".write(OUT_DELIM_";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\t}";
  protected final String TEXT_22 = NL + "\t\t}";
  protected final String TEXT_23 = NL + "\t\tpublic void putVaule_";
  protected final String TEXT_24 = "(final ";
  protected final String TEXT_25 = "Struct ";
  protected final String TEXT_26 = ",StringBuilder sb_";
  protected final String TEXT_27 = ",final String OUT_DELIM_";
  protected final String TEXT_28 = "){";
  protected final String TEXT_29 = NL + "\t\t\t\t\t\t\tif(";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = " != null) {";
  protected final String TEXT_32 = NL + "    \t\t\t\t    \t\troutines.system.DynamicUtils.writeValuesToStringBuilder(";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = ", sb_";
  protected final String TEXT_35 = ", OUT_DELIM_";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_38 = ".append(";
  protected final String TEXT_39 = NL + "    \t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ")";
  protected final String TEXT_43 = NL + "        \t\t\t\t\t\tFormatterUtils.format_Number(";
  protected final String TEXT_44 = ".toPlainString(), ";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = ")\t\t\t\t\t";
  protected final String TEXT_47 = NL + "        \t\t\t\t\t\tFormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = ")).toPlainString(), ";
  protected final String TEXT_50 = ", ";
  protected final String TEXT_51 = ")\t\t\t\t\t\t";
  protected final String TEXT_52 = NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_53 = ".toPlainString()";
  protected final String TEXT_54 = NL + "    \t\t\t\t\t\t\tjava.nio.charset.Charset.forName(";
  protected final String TEXT_55 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = ")).toString()";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = NL + "    \t\t\t\t\t\t\t);";
  protected final String TEXT_61 = NL + "    \t\t\t\t\t    } ";
  protected final String TEXT_62 = "\t\t\t\t\t" + NL + "    \t\t\t            sb_";
  protected final String TEXT_63 = ".append(OUT_DELIM_";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\t\t}";
  protected final String TEXT_66 = NL + "\t\t}";
  protected final String TEXT_67 = NL + "\t\tpublic void putHeaderVaule_";
  protected final String TEXT_68 = "(String[] headColu";
  protected final String TEXT_69 = ")throws Exception{";
  protected final String TEXT_70 = NL + "\t\t\t\t\t\t\t\t\theadColu";
  protected final String TEXT_71 = "[";
  protected final String TEXT_72 = "]=\"";
  protected final String TEXT_73 = "\";";
  protected final String TEXT_74 = NL + "\t\t\t\t\t\t\t\t\tfor(int mi=0;mi<";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = ".getColumnCount();mi++){" + NL + "        \t    \t\t     \t\t\theadColu";
  protected final String TEXT_77 = "[";
  protected final String TEXT_78 = "+mi]=";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = ".getColumnMetadata(mi).getName();" + NL + "        \t    \t\t     \t\t}";
  protected final String TEXT_81 = NL + "\t\t}";
  protected final String TEXT_82 = NL + "\t\t}";
  protected final String TEXT_83 = NL + "\t\tpublic void putVaule_";
  protected final String TEXT_84 = "(final ";
  protected final String TEXT_85 = "Struct ";
  protected final String TEXT_86 = ",String[] row";
  protected final String TEXT_87 = "){";
  protected final String TEXT_88 = NL + "\t\t\t\t\t\t\tif (";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = " != null) {" + NL + "                            \troutines.system.DynamicUtils.writeValuesToStringArray(";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = ", row";
  protected final String TEXT_93 = ", ";
  protected final String TEXT_94 = ");" + NL + "                            }";
  protected final String TEXT_95 = " " + NL + "                \t\t\trow";
  protected final String TEXT_96 = "[";
  protected final String TEXT_97 = "]=";
  protected final String TEXT_98 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = ";";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_102 = ".";
  protected final String TEXT_103 = ", ";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = "\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = ")).toString();";
  protected final String TEXT_108 = NL + "        \t\t\t\t\tFormatterUtils.format_Number(";
  protected final String TEXT_109 = ".toPlainString(), ";
  protected final String TEXT_110 = ", ";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_113 = ".";
  protected final String TEXT_114 = ")).toPlainString(), ";
  protected final String TEXT_115 = ", ";
  protected final String TEXT_116 = ");\t\t\t\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_118 = ".toPlainString();";
  protected final String TEXT_119 = NL + "\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = ");";
  protected final String TEXT_122 = NL + "\t\t}";
  protected final String TEXT_123 = NL + "\t\t}";
  protected final String TEXT_124 = NL + "\t}" + NL + "\tFileOutputDelimitedUtil_";
  protected final String TEXT_125 = " fileOutputDelimitedUtil_";
  protected final String TEXT_126 = "=new FileOutputDelimitedUtil_";
  protected final String TEXT_127 = "();";
  protected final String TEXT_128 = NL + "fileName_";
  protected final String TEXT_129 = " = (new java.io.File(";
  protected final String TEXT_130 = ")).getAbsolutePath().replace(\"\\\\\",\"/\");" + NL + "String fullName_";
  protected final String TEXT_131 = " = null;" + NL + "String extension_";
  protected final String TEXT_132 = " = null;" + NL + "String directory_";
  protected final String TEXT_133 = " = null;" + NL + "if((fileName_";
  protected final String TEXT_134 = ".indexOf(\"/\") != -1)) {" + NL + "    if(fileName_";
  protected final String TEXT_135 = ".lastIndexOf(\".\") < fileName_";
  protected final String TEXT_136 = ".lastIndexOf(\"/\")) {" + NL + "        fullName_";
  protected final String TEXT_137 = " = fileName_";
  protected final String TEXT_138 = ";" + NL + "        extension_";
  protected final String TEXT_139 = " = \"\";" + NL + "    } else {" + NL + "        fullName_";
  protected final String TEXT_140 = " = fileName_";
  protected final String TEXT_141 = ".substring(0, fileName_";
  protected final String TEXT_142 = ".lastIndexOf(\".\"));" + NL + "        extension_";
  protected final String TEXT_143 = " = fileName_";
  protected final String TEXT_144 = ".substring(fileName_";
  protected final String TEXT_145 = ".lastIndexOf(\".\"));" + NL + "    }           " + NL + "    directory_";
  protected final String TEXT_146 = " = fileName_";
  protected final String TEXT_147 = ".substring(0, fileName_";
  protected final String TEXT_148 = ".lastIndexOf(\"/\"));            " + NL + "} else {" + NL + "    if(fileName_";
  protected final String TEXT_149 = ".lastIndexOf(\".\") != -1) {" + NL + "        fullName_";
  protected final String TEXT_150 = " = fileName_";
  protected final String TEXT_151 = ".substring(0, fileName_";
  protected final String TEXT_152 = ".lastIndexOf(\".\"));" + NL + "        extension_";
  protected final String TEXT_153 = " = fileName_";
  protected final String TEXT_154 = ".substring(fileName_";
  protected final String TEXT_155 = ".lastIndexOf(\".\"));" + NL + "    } else {" + NL + "        fullName_";
  protected final String TEXT_156 = " = fileName_";
  protected final String TEXT_157 = ";" + NL + "        extension_";
  protected final String TEXT_158 = " = \"\";" + NL + "    }" + NL + "    directory_";
  protected final String TEXT_159 = " = \"\";" + NL + "}" + NL + "boolean isFileGenerated_";
  protected final String TEXT_160 = " = true;" + NL + "java.io.File file";
  protected final String TEXT_161 = " = new java.io.File(fileName_";
  protected final String TEXT_162 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_163 = "_FILE_NAME\",fileName_";
  protected final String TEXT_164 = ");";
  protected final String TEXT_165 = NL + "if(file";
  protected final String TEXT_166 = ".exists()){" + NL + "\tisFileGenerated_";
  protected final String TEXT_167 = " = false;" + NL + "}";
  protected final String TEXT_168 = NL;
  protected final String TEXT_169 = NL + "            boolean isFirstCheckDyn_";
  protected final String TEXT_170 = "= true;";
  protected final String TEXT_171 = NL + "    \t\tint nb_line_";
  protected final String TEXT_172 = " = 0;" + NL + "            int splitEvery_";
  protected final String TEXT_173 = " = ";
  protected final String TEXT_174 = ";" + NL + "            int splitedFileNo_";
  protected final String TEXT_175 = " = 0;" + NL + "            int currentRow_";
  protected final String TEXT_176 = " = 0;\t\t" + NL + "    \t\t" + NL + "    \t\tfinal String OUT_DELIM_";
  protected final String TEXT_177 = " = ";
  protected final String TEXT_178 = ";" + NL + "    \t\t" + NL + "    \t\tfinal String OUT_DELIM_ROWSEP_";
  protected final String TEXT_179 = " = ";
  protected final String TEXT_180 = ";" + NL;
  protected final String TEXT_181 = "         " + NL + "                //create directory only if not exists" + NL + "                if(directory_";
  protected final String TEXT_182 = " != null && directory_";
  protected final String TEXT_183 = ".trim().length() != 0) {" + NL + "                    java.io.File dir_";
  protected final String TEXT_184 = " = new java.io.File(directory_";
  protected final String TEXT_185 = ");" + NL + "                    if(!dir_";
  protected final String TEXT_186 = ".exists()) {" + NL + "                        dir_";
  protected final String TEXT_187 = ".mkdirs();" + NL + "                    }" + NL + "                }";
  protected final String TEXT_188 = NL + "    ";
  protected final String TEXT_189 = NL + "\t\t\t\tfile";
  protected final String TEXT_190 = " = new java.io.File(fileName_";
  protected final String TEXT_191 = ");" + NL + "\t\t\t\tString zipName_";
  protected final String TEXT_192 = " = fullName_";
  protected final String TEXT_193 = " + \".zip\";" + NL + "\t\t\t\tjava.io.File file_";
  protected final String TEXT_194 = " = new java.io.File(zipName_";
  protected final String TEXT_195 = ");" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_196 = "= null;    \t\t    " + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_197 = " = null;" + NL + "    \t\t    try {" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_198 = "= new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_199 = ")));" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_200 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_201 = ".getName()));" + NL + "    \t\t    \tout";
  protected final String TEXT_202 = " = new ";
  protected final String TEXT_203 = "(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_204 = ",";
  protected final String TEXT_205 = "));";
  protected final String TEXT_206 = "\t\t" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_207 = " = null;" + NL + "            \ttry {" + NL + "            \t\tout";
  protected final String TEXT_208 = " = new ";
  protected final String TEXT_209 = "(new java.io.OutputStreamWriter(" + NL + "            \t\tnew java.io.FileOutputStream(fileName_";
  protected final String TEXT_210 = ", ";
  protected final String TEXT_211 = "),";
  protected final String TEXT_212 = "));";
  protected final String TEXT_213 = NL + "                java.io.Writer out";
  protected final String TEXT_214 = " = null;" + NL + "                file";
  protected final String TEXT_215 = " = new java.io.File(fullName_";
  protected final String TEXT_216 = " + splitedFileNo_";
  protected final String TEXT_217 = " + extension_";
  protected final String TEXT_218 = ");" + NL + "                try {" + NL + "                \tout";
  protected final String TEXT_219 = " = new ";
  protected final String TEXT_220 = "(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_221 = " + splitedFileNo_";
  protected final String TEXT_222 = " + extension_";
  protected final String TEXT_223 = ", ";
  protected final String TEXT_224 = "),";
  protected final String TEXT_225 = "));";
  protected final String TEXT_226 = NL + "\t\t\t\t";
  protected final String TEXT_227 = NL + "\t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_228 = NL + "\t\t\t\tsynchronized (lockWrite) {" + NL + "\t\t        ";
  protected final String TEXT_229 = NL + "\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_230 = NL + "    \t\t    if(file_";
  protected final String TEXT_231 = ".length()==0)  " + NL + "    \t\t    {" + NL + "    \t\t    ";
  protected final String TEXT_232 = NL + "    \t\t    if(file";
  protected final String TEXT_233 = ".length()==0)  " + NL + "    \t\t    {" + NL + "    \t\t        ";
  protected final String TEXT_234 = NL + "                            \t\tfileOutputDelimitedUtil_";
  protected final String TEXT_235 = ".putHeaderVaule_";
  protected final String TEXT_236 = "(out";
  protected final String TEXT_237 = ",OUT_DELIM_";
  protected final String TEXT_238 = ");";
  protected final String TEXT_239 = NL + "\t    \t\t            out";
  protected final String TEXT_240 = ".write(\"";
  protected final String TEXT_241 = "\");" + NL + "\t    \t\t            ";
  protected final String TEXT_242 = NL + "\t    \t\t                out";
  protected final String TEXT_243 = ".write(OUT_DELIM_";
  protected final String TEXT_244 = ");" + NL + "\t    \t\t                ";
  protected final String TEXT_245 = NL + "    \t\t        out";
  protected final String TEXT_246 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_247 = ");" + NL + "    \t\t        out";
  protected final String TEXT_248 = ".flush();" + NL + "    \t\t    }" + NL + "\t\t        ";
  protected final String TEXT_249 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_250 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_251 = NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_252 = NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_253 = "= null;    \t\t    " + NL + "    \t\t    java.io.OutputStreamWriter writer_";
  protected final String TEXT_254 = " = null;" + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_255 = " = null;" + NL + "    \t\t    try {" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_256 = "=new java.util.zip.ZipOutputStream(new java.io.BufferedOutputStream(";
  protected final String TEXT_257 = "));" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_258 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "    \t\t    \twriter_";
  protected final String TEXT_259 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_260 = ",";
  protected final String TEXT_261 = ");" + NL + "    \t\t    \tout";
  protected final String TEXT_262 = " = new ";
  protected final String TEXT_263 = "(writer_";
  protected final String TEXT_264 = ");";
  protected final String TEXT_265 = "\t\t" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.io.OutputStreamWriter writer_";
  protected final String TEXT_266 = " = null;" + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_267 = " = null;" + NL + "    \t\t    try {" + NL + "    \t\t    \twriter_";
  protected final String TEXT_268 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_269 = ",";
  protected final String TEXT_270 = ");" + NL + "    \t\t    \tout";
  protected final String TEXT_271 = " = new ";
  protected final String TEXT_272 = "(writer_";
  protected final String TEXT_273 = ");";
  protected final String TEXT_274 = NL + "                            \t\tfileOutputDelimitedUtil_";
  protected final String TEXT_275 = ".putHeaderVaule_";
  protected final String TEXT_276 = "(out";
  protected final String TEXT_277 = ",OUT_DELIM_";
  protected final String TEXT_278 = ");";
  protected final String TEXT_279 = NL + "    \t\t            out";
  protected final String TEXT_280 = ".write(\"";
  protected final String TEXT_281 = "\");" + NL + "    \t\t            ";
  protected final String TEXT_282 = NL + "    \t\t                out";
  protected final String TEXT_283 = ".write(OUT_DELIM_";
  protected final String TEXT_284 = ");" + NL + "    \t\t                ";
  protected final String TEXT_285 = NL + "    \t\t        out";
  protected final String TEXT_286 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_287 = ");";
  protected final String TEXT_288 = NL;
  protected final String TEXT_289 = NL;
  protected final String TEXT_290 = NL + "            boolean isFirstCheckDyn_";
  protected final String TEXT_291 = "= true;" + NL + "            String[] headColu";
  protected final String TEXT_292 = " = null;";
  protected final String TEXT_293 = NL + "            String[] headColu";
  protected final String TEXT_294 = "=new String[";
  protected final String TEXT_295 = "];";
  protected final String TEXT_296 = "   \t    \t\t" + NL + "            class CSVBasicSet_";
  protected final String TEXT_297 = "{          \t" + NL + "            \tprivate char field_Delim;            \t" + NL + "            \tprivate char row_Delim;            \t" + NL + "            \tprivate char escape;            \t" + NL + "            \tprivate char textEnclosure;" + NL + "            \tprivate boolean useCRLFRecordDelimiter;" + NL + "            \t" + NL + "            \tpublic boolean isUseCRLFRecordDelimiter() {" + NL + "            \t\treturn useCRLFRecordDelimiter;" + NL + "            \t}" + NL + "            \t          \t" + NL + "            \tpublic void setFieldSeparator(String fieldSep) throws IllegalArgumentException{" + NL + "                    char field_Delim_";
  protected final String TEXT_298 = "[] = null;" + NL + "                    " + NL + "            \t\t//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get(\"fs\")'." + NL + "            \t\tif (fieldSep.length() > 0 ){" + NL + "            \t\t\tfield_Delim_";
  protected final String TEXT_299 = " = fieldSep.toCharArray();" + NL + "            \t\t}else { " + NL + "            \t\t\tthrow new IllegalArgumentException(\"Field Separator must be assigned a char.\");" + NL + "            \t\t}" + NL + "            \t\tthis.field_Delim = field_Delim_";
  protected final String TEXT_300 = "[0];" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getFieldDelim(){" + NL + "            \t\tif(this.field_Delim==0){" + NL + "            \t\t\tsetFieldSeparator(";
  protected final String TEXT_301 = ");" + NL + "            \t\t}" + NL + "            \t\treturn this.field_Delim;" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic void setRowSeparator(String rowSep){" + NL + "            \t\tif(\"\\r\\n\".equals(rowSep)) {" + NL + "            \t\t\tuseCRLFRecordDelimiter = true;" + NL + "            \t\t\treturn;" + NL + "            \t\t}" + NL + "            \t\tchar row_Delim";
  protected final String TEXT_302 = "[] = null;" + NL + "                 " + NL + "            \t\t//support passing value (property: Row Separator) by 'context.rs' or 'globalMap.get(\"rs\")'.  " + NL + "            \t\tif (rowSep.length() > 0 ){ " + NL + "            \t\t\trow_Delim";
  protected final String TEXT_303 = " = rowSep.toCharArray();" + NL + "            \t\t}else {" + NL + "            \t\t\tthrow new IllegalArgumentException(\"Row Separator must be assigned a char.\");" + NL + "            \t\t}" + NL + "            \t\tthis.row_Delim = row_Delim";
  protected final String TEXT_304 = "[0];" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getRowDelim(){" + NL + "            \t\tif(this.row_Delim==0){" + NL + "            \t\t\tsetRowSeparator(";
  protected final String TEXT_305 = ");" + NL + "            \t\t}" + NL + "            \t\treturn this.row_Delim;" + NL + "            \t}" + NL + "            \t       \t        " + NL + "        \t    public void setEscapeAndTextEnclosure(String strEscape, String strTextEnclosure) throws IllegalArgumentException{" + NL + "        \t        if(strEscape.length() <= 0 ){ " + NL + "        \t            throw new IllegalArgumentException(\"Escape Char must be assigned a char.\"); " + NL + "        \t        }" + NL + "        \t        " + NL + "                \tif (\"\".equals(strTextEnclosure)) strTextEnclosure = \"\\0\";" + NL + "        \t\t\tchar textEnclosure_";
  protected final String TEXT_306 = "[] = null;" + NL + "        \t        " + NL + "        \t        if(strTextEnclosure.length() > 0 ){ " + NL + "              \t\t\ttextEnclosure_";
  protected final String TEXT_307 = " = strTextEnclosure.toCharArray(); " + NL + "        \t\t\t}else { " + NL + "        \t            throw new IllegalArgumentException(\"Text Enclosure must be assigned a char.\"); " + NL + "        \t        }" + NL + "" + NL + "\t\t\t\t\tthis.textEnclosure = textEnclosure_";
  protected final String TEXT_308 = "[0];" + NL + "" + NL + "        \t\t\tif((\"\\\\\").equals(strEscape)){" + NL + "        \t\t\t\tthis.escape = '\\\\';" + NL + "        \t\t\t}else if(strEscape.equals(strTextEnclosure)){" + NL + "        \t\t\t\tthis.escape = this.textEnclosure;" + NL + "        \t\t\t} else {" + NL + "        \t\t\t\t//the default escape mode is double escape" + NL + "        \t\t\t\tthis.escape = this.textEnclosure;" + NL + "        \t\t\t}" + NL + "        \t\t\t" + NL + "        \t\t\t" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getEscapeChar(){" + NL + "            \t\treturn (char)this.escape;" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getTextEnclosure(){" + NL + "            \t\treturn this.textEnclosure;" + NL + "            \t}" + NL + "            }" + NL + "" + NL + "            int nb_line_";
  protected final String TEXT_309 = " = 0;" + NL + "            int splitEvery_";
  protected final String TEXT_310 = " = ";
  protected final String TEXT_311 = ";" + NL + "            int splitedFileNo_";
  protected final String TEXT_312 = " =0;" + NL + "            int currentRow_";
  protected final String TEXT_313 = " = 0;" + NL + "            " + NL + "            " + NL + "            CSVBasicSet_";
  protected final String TEXT_314 = " csvSettings_";
  protected final String TEXT_315 = " = new CSVBasicSet_";
  protected final String TEXT_316 = "();" + NL + "            csvSettings_";
  protected final String TEXT_317 = ".setFieldSeparator(";
  protected final String TEXT_318 = ");" + NL + "            csvSettings_";
  protected final String TEXT_319 = ".setRowSeparator(";
  protected final String TEXT_320 = ");" + NL + "\t\t\tcsvSettings_";
  protected final String TEXT_321 = ".setEscapeAndTextEnclosure(";
  protected final String TEXT_322 = ",";
  protected final String TEXT_323 = ");";
  protected final String TEXT_324 = "         " + NL + "                //create directory only if not exists" + NL + "                if(directory_";
  protected final String TEXT_325 = " != null && directory_";
  protected final String TEXT_326 = ".trim().length() != 0) {" + NL + "                    java.io.File dir_";
  protected final String TEXT_327 = " = new java.io.File(directory_";
  protected final String TEXT_328 = ");" + NL + "                    if(!dir_";
  protected final String TEXT_329 = ".exists()) {" + NL + "                        dir_";
  protected final String TEXT_330 = ".mkdirs();" + NL + "                    }" + NL + "                }";
  protected final String TEXT_331 = NL + "\t\t\t\tfile";
  protected final String TEXT_332 = " = new java.io.File(fileName_";
  protected final String TEXT_333 = ");" + NL + "\t\t\t\tString zipName_";
  protected final String TEXT_334 = " = fullName_";
  protected final String TEXT_335 = " + \".zip\";" + NL + "\t\t\t\tjava.io.File file_";
  protected final String TEXT_336 = " = new java.io.File(zipName_";
  protected final String TEXT_337 = ");\t\t\t\t" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_338 = " = null;" + NL + "                java.io.Writer out";
  protected final String TEXT_339 = " = null;" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_340 = " = null; " + NL + "                try {" + NL + "                \tzipOut_";
  protected final String TEXT_341 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_342 = ")));" + NL + "\t    \t\t    zipOut_";
  protected final String TEXT_343 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_344 = ".getName()));" + NL + "\t    \t\t    out";
  protected final String TEXT_345 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_346 = ", ";
  protected final String TEXT_347 = "));" + NL + "\t    \t\t    java.io.StringWriter strWriter";
  protected final String TEXT_348 = " = new java.io.StringWriter();" + NL + "\t    \t\t    CsvWriter";
  protected final String TEXT_349 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_350 = ");" + NL + "\t    \t\t    CsvWriter";
  protected final String TEXT_351 = ".setSeparator(csvSettings_";
  protected final String TEXT_352 = ".getFieldDelim());";
  protected final String TEXT_353 = "\t\t" + NL + "                java.io.Writer out";
  protected final String TEXT_354 = " = null;" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_355 = " = null;" + NL + "                try {" + NL + "                \tout";
  protected final String TEXT_356 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "                    new java.io.FileOutputStream(fileName_";
  protected final String TEXT_357 = ", ";
  protected final String TEXT_358 = "), ";
  protected final String TEXT_359 = "));" + NL + "\t\t\t\t\tjava.io.StringWriter strWriter";
  protected final String TEXT_360 = " = new java.io.StringWriter();" + NL + "\t\t\t\t\tCsvWriter";
  protected final String TEXT_361 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_362 = ");" + NL + "\t\t\t\t\tCsvWriter";
  protected final String TEXT_363 = ".setSeparator(csvSettings_";
  protected final String TEXT_364 = ".getFieldDelim());";
  protected final String TEXT_365 = NL + "\t\t\t\tfile";
  protected final String TEXT_366 = " = new java.io.File(fileName_";
  protected final String TEXT_367 = ");" + NL + "\t\t\t\tString zipName_";
  protected final String TEXT_368 = " = fullName_";
  protected final String TEXT_369 = " + \".zip\";" + NL + "\t\t\t\tjava.io.File file_";
  protected final String TEXT_370 = " = new java.io.File(zipName_";
  protected final String TEXT_371 = ");" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_372 = " = null;" + NL + "\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_373 = " = null;" + NL + "                try {" + NL + "                \tzipOut_";
  protected final String TEXT_374 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_375 = ")));" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_376 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_377 = ".getName()));" + NL + "    \t\t    \tCsvWriter";
  protected final String TEXT_378 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                    zipOut_";
  protected final String TEXT_379 = ", ";
  protected final String TEXT_380 = ")));" + NL + "                    CsvWriter";
  protected final String TEXT_381 = ".setSeparator(csvSettings_";
  protected final String TEXT_382 = ".getFieldDelim());" + NL + "\t\t\t\t";
  protected final String TEXT_383 = NL + "\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_384 = " = null;" + NL + "                try {" + NL + "                \tCsvWriter";
  protected final String TEXT_385 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                    new java.io.FileOutputStream(fileName_";
  protected final String TEXT_386 = ", ";
  protected final String TEXT_387 = "), ";
  protected final String TEXT_388 = ")));" + NL + "                    CsvWriter";
  protected final String TEXT_389 = ".setSeparator(csvSettings_";
  protected final String TEXT_390 = ".getFieldDelim());" + NL + "\t\t\t\t";
  protected final String TEXT_391 = NL + "                file";
  protected final String TEXT_392 = " = new java.io.File(fullName_";
  protected final String TEXT_393 = " + splitedFileNo_";
  protected final String TEXT_394 = " + extension_";
  protected final String TEXT_395 = ");" + NL + "                java.io.Writer out";
  protected final String TEXT_396 = " = null;" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_397 = " = null;" + NL + "                try {" + NL + "                \tout";
  protected final String TEXT_398 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_399 = " + splitedFileNo_";
  protected final String TEXT_400 = " + extension_";
  protected final String TEXT_401 = ", ";
  protected final String TEXT_402 = "),";
  protected final String TEXT_403 = "));" + NL + "                \tjava.io.StringWriter strWriter";
  protected final String TEXT_404 = " = new java.io.StringWriter();" + NL + "                \tCsvWriter";
  protected final String TEXT_405 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_406 = ");" + NL + "                \tCsvWriter";
  protected final String TEXT_407 = ".setSeparator(csvSettings_";
  protected final String TEXT_408 = ".getFieldDelim());";
  protected final String TEXT_409 = NL + "                file";
  protected final String TEXT_410 = " = new java.io.File(fullName_";
  protected final String TEXT_411 = " + splitedFileNo_";
  protected final String TEXT_412 = " + extension_";
  protected final String TEXT_413 = ");" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_414 = " = null; " + NL + "                try {" + NL + "                \tCsvWriter";
  protected final String TEXT_415 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_416 = " + splitedFileNo_";
  protected final String TEXT_417 = " + extension_";
  protected final String TEXT_418 = ", ";
  protected final String TEXT_419 = "),";
  protected final String TEXT_420 = ")));" + NL + "                    CsvWriter";
  protected final String TEXT_421 = ".setSeparator(csvSettings_";
  protected final String TEXT_422 = ".getFieldDelim());";
  protected final String TEXT_423 = NL + "    \t    \tif(csvSettings_";
  protected final String TEXT_424 = ".isUseCRLFRecordDelimiter()) {" + NL + "    \t    \t\tCsvWriter";
  protected final String TEXT_425 = ".setLineEnd(\"\\r\\n\");" + NL + "    \t    \t} else {" + NL + "    \t    \t\tCsvWriter";
  protected final String TEXT_426 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_427 = ".getRowDelim());" + NL + "    \t    \t}" + NL + "\t    \t\t";
  protected final String TEXT_428 = NL + "\t    \t\tif(!csvSettings_";
  protected final String TEXT_429 = ".isUseCRLFRecordDelimiter() && csvSettings_";
  protected final String TEXT_430 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_431 = ".getRowDelim()!='\\n') {" + NL + "\t    \t\t\tCsvWriter";
  protected final String TEXT_432 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_433 = ".getRowDelim());" + NL + "\t    \t\t}" + NL + "\t    \t\t";
  protected final String TEXT_434 = "\t\t   " + NL + "\t\t\t";
  protected final String TEXT_435 = NL + "\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_436 = NL + "\t\t\tsynchronized (lockWrite) {" + NL + "\t        ";
  protected final String TEXT_437 = NL + "\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_438 = NL + "\t        \tif(file_";
  protected final String TEXT_439 = ".length()==0)" + NL + "\t        \t{" + NL + "\t        ";
  protected final String TEXT_440 = NL + "    \t        if(file";
  protected final String TEXT_441 = ".length()==0)  " + NL + "    \t        {" + NL + "    \t            ";
  protected final String TEXT_442 = NL + "                        fileOutputDelimitedUtil_";
  protected final String TEXT_443 = ".putHeaderVaule_";
  protected final String TEXT_444 = "(headColu";
  protected final String TEXT_445 = ");";
  protected final String TEXT_446 = "\t      \t" + NL + "        \t\t\t\theadColu";
  protected final String TEXT_447 = "[";
  protected final String TEXT_448 = "]=\"";
  protected final String TEXT_449 = "\";" + NL + "        \t\t\t\t";
  protected final String TEXT_450 = "\t " + NL + "    \t            CsvWriter";
  protected final String TEXT_451 = ".writeNext(headColu";
  protected final String TEXT_452 = ");" + NL + "    \t            CsvWriter";
  protected final String TEXT_453 = ".flush();" + NL + "    \t            \t";
  protected final String TEXT_454 = NL + "    \t            out";
  protected final String TEXT_455 = ".write(strWriter";
  protected final String TEXT_456 = ".getBuffer().toString());" + NL + "    \t            out";
  protected final String TEXT_457 = ".flush();" + NL + "                \tstrWriter";
  protected final String TEXT_458 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_459 = ".getBuffer().length()); \t" + NL + "                \t\t";
  protected final String TEXT_460 = NL + "                }" + NL + "\t        ";
  protected final String TEXT_461 = NL + "\t\t\t} " + NL + "\t        ";
  protected final String TEXT_462 = NL + "\t\t\t} " + NL + "\t        ";
  protected final String TEXT_463 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_464 = NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_465 = " = null;" + NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_466 = " = null;" + NL + "                java.io.Writer out";
  protected final String TEXT_467 = " = null;\t\t\t\t" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_468 = " = null;" + NL + "                try {" + NL + "                \tzipOut_";
  protected final String TEXT_469 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_470 = "));" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_471 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "    \t\t    \toutWriter_";
  protected final String TEXT_472 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_473 = ", ";
  protected final String TEXT_474 = ");" + NL + "    \t\t    \tout";
  protected final String TEXT_475 = " = new routines.system.BufferedOutput(outWriter_";
  protected final String TEXT_476 = ");" + NL + "    \t\t    \tjava.io.StringWriter strWriter";
  protected final String TEXT_477 = " = new java.io.StringWriter();" + NL + "    \t\t    \tCsvWriter";
  protected final String TEXT_478 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_479 = ");" + NL + "    \t\t    \tCsvWriter";
  protected final String TEXT_480 = ".setSeparator(csvSettings_";
  protected final String TEXT_481 = ".getFieldDelim());";
  protected final String TEXT_482 = NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_483 = " = null;" + NL + "                java.io.Writer out";
  protected final String TEXT_484 = " = null;\t\t\t\t" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_485 = " = null;  " + NL + "                try {" + NL + "                \toutWriter_";
  protected final String TEXT_486 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_487 = ", ";
  protected final String TEXT_488 = ");" + NL + "                \tout";
  protected final String TEXT_489 = " = new routines.system.BufferedOutput(outWriter_";
  protected final String TEXT_490 = ");" + NL + "                \tjava.io.StringWriter strWriter";
  protected final String TEXT_491 = " = new java.io.StringWriter();" + NL + "                \tCsvWriter";
  protected final String TEXT_492 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_493 = ");" + NL + "                \tCsvWriter";
  protected final String TEXT_494 = ".setSeparator(csvSettings_";
  protected final String TEXT_495 = ".getFieldDelim());";
  protected final String TEXT_496 = NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_497 = " = null;" + NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_498 = " = null;" + NL + "\t\t\t\tjava.io.BufferedWriter bufferWriter_";
  protected final String TEXT_499 = " = null;" + NL + "\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_500 = " = null;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tzipOut_";
  protected final String TEXT_501 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_502 = "));" + NL + "    \t\t   \t\tzipOut_";
  protected final String TEXT_503 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "    \t\t   \t\toutWriter_";
  protected final String TEXT_504 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_505 = ", ";
  protected final String TEXT_506 = ");" + NL + "    \t\t   \t\tbufferWriter_";
  protected final String TEXT_507 = " = new java.io.BufferedWriter(outWriter_";
  protected final String TEXT_508 = ");" + NL + "    \t\t   \t\tCsvWriter";
  protected final String TEXT_509 = " = new com.talend.csv.CSVWriter(bufferWriter_";
  protected final String TEXT_510 = ");" + NL + "    \t\t   \t\tCsvWriter";
  protected final String TEXT_511 = ".setSeparator(csvSettings_";
  protected final String TEXT_512 = ".getFieldDelim());";
  protected final String TEXT_513 = NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_514 = " = null;" + NL + "\t\t\t\tjava.io.BufferedWriter bufferWriter_";
  protected final String TEXT_515 = " = null;" + NL + "\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_516 = " = null;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\toutWriter_";
  protected final String TEXT_517 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_518 = ", ";
  protected final String TEXT_519 = ");" + NL + "\t\t\t\t\tbufferWriter_";
  protected final String TEXT_520 = " = new java.io.BufferedWriter(outWriter_";
  protected final String TEXT_521 = ");" + NL + "\t\t\t\t\tCsvWriter";
  protected final String TEXT_522 = " = new com.talend.csv.CSVWriter(bufferWriter_";
  protected final String TEXT_523 = ");" + NL + "\t\t\t\t\tCsvWriter";
  protected final String TEXT_524 = ".setSeparator(csvSettings_";
  protected final String TEXT_525 = ".getFieldDelim());";
  protected final String TEXT_526 = NL + "       \t    \tif(csvSettings_";
  protected final String TEXT_527 = ".isUseCRLFRecordDelimiter()) {" + NL + "    \t    \t\tCsvWriter";
  protected final String TEXT_528 = ".setLineEnd(\"\\r\\n\");" + NL + "    \t    \t} else {" + NL + "    \t    \t\tCsvWriter";
  protected final String TEXT_529 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_530 = ".getRowDelim());   \t    \t" + NL + "    \t    \t}" + NL + "    \t    \t";
  protected final String TEXT_531 = NL + "    \t    \tif(!csvSettings_";
  protected final String TEXT_532 = ".isUseCRLFRecordDelimiter() && csvSettings_";
  protected final String TEXT_533 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_534 = ".getRowDelim()!='\\n') {" + NL + "\t    \t\t\tCsvWriter";
  protected final String TEXT_535 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_536 = ".getRowDelim());" + NL + "\t    \t\t}" + NL + "    \t    \t";
  protected final String TEXT_537 = NL + "                     fileOutputDelimitedUtil_";
  protected final String TEXT_538 = ".putHeaderVaule_";
  protected final String TEXT_539 = "(headColu";
  protected final String TEXT_540 = ");";
  protected final String TEXT_541 = NL + "       \t\t\t\theadColu";
  protected final String TEXT_542 = "[";
  protected final String TEXT_543 = "]=\"";
  protected final String TEXT_544 = "\";" + NL + "       \t\t\t\t";
  protected final String TEXT_545 = NL + "        \t\tCsvWriter";
  protected final String TEXT_546 = ".writeNext(headColu";
  protected final String TEXT_547 = ");\t" + NL + "        \t\t\t";
  protected final String TEXT_548 = NL + "        \t\tout";
  protected final String TEXT_549 = ".write(strWriter";
  protected final String TEXT_550 = ".getBuffer().toString());" + NL + "                strWriter";
  protected final String TEXT_551 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_552 = ".getBuffer().length());" + NL + "        \t\t\t";
  protected final String TEXT_553 = NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_554 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_555 = ".getEscapeChar());" + NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_556 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_557 = ".getTextEnclosure());" + NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_558 = ".setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);";
  protected final String TEXT_559 = NL + NL;
  protected final String TEXT_560 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
String fileName = ElementParameterParser.getValue(node,"__FILENAME__");

boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}
boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));

String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
List<IMetadataTable> metadatas = node.getMetadataList();
List< ? extends IConnection> conns = node.getIncomingConnections();
if ((metadatas!=null)&&(metadatas.size()>0)) {//A1
	IMetadataTable metadata = metadatas.get(0);
	boolean hasDynamic = metadata.isDynamicSchema();
	IMetadataColumn dynamicCol = metadata.getDynamicColumn();
	for (IConnection conn : conns) {//B1
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//C1
	    	List<IMetadataColumn> columns = metadata.getListColumns();
	       	int sizeColumns = columns.size();
			if(sizeColumns> schemaOptNum){//D1

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
				if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {//E1 not use CSV Option
					if(isIncludeHeader && ((!useStream && split)||(hasDynamic))){//F1
						for (int i = 0; i < sizeColumns; i++) {//H1
	                        IMetadataColumn column = columns.get(i);
	                       	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
							}
							if(!("id_Dynamic".equals(column.getTalendType()))) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_12);
    
							}else{

    stringBuffer.append(TEXT_13);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
							}
							if(i != sizeColumns - 1) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    
							}
							if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_21);
    
							}
						}//H1
						if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_22);
    
						}
					}//F1
        			for (int i = 0; i < sizeColumns; i++) {//F2
        				IMetadataColumn column = columns.get(i);
    					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
	                    if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
						}
    					if(!isPrimitive) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_31);
    
    				    } 
    				    if(column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    
    				    }else{

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    
    			        	String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    			        	if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_42);
    	
    						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
								if(javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_44);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_46);
     
        						} else { 

    stringBuffer.append(TEXT_47);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_51);
     
        						}
							} else if(javaType == JavaTypesManager.BIGDECIMAL){

    stringBuffer.append(TEXT_52);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_53);
    
							} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_54);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_57);
    
    			        	} else {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel() );
    				
    			        	}

    stringBuffer.append(TEXT_60);
    
    					}
    					if(!isPrimitive) {

    stringBuffer.append(TEXT_61);
    
    			        } 
    			        if(i != sizeColumns - 1) {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    
    			        }
    			        if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_65);
    
						}
    		        }//F2
					if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_66);
    
					}
				}else{
					//E2 use CSV Option
					if(isIncludeHeader && hasDynamic){//F3
						for (int i = 0; i < sizeColumns; i++) {//H3
	                        IMetadataColumn column = columns.get(i);
	                       	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_67);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
							}
							if(!("id_Dynamic".equals(column.getTalendType()))) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_73);
    
							}else{

    stringBuffer.append(TEXT_74);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_80);
    
							}
							if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_81);
    
							}
						}//H3
						if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_82);
    
						}
					}//F3
        			for (int i = 0; i < sizeColumns; i++) {//F4
        				IMetadataColumn column = columns.get(i);
    					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    					String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
	                    if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_83);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
						}
    					if(("id_Dynamic").equals(column.getTalendType())) {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_94);
    
                		}else{

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ "==null?\"\":");
    					
                			if(javaType == JavaTypesManager.STRING ){

    stringBuffer.append(TEXT_98);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_100);
    
                			}else if(javaType == JavaTypesManager.DATE && pattern != null){

    stringBuffer.append(TEXT_101);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_104);
    
                			}else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_105);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_107);
    
                			} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        						if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_109);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_110);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_111);
      	
								} else { 
    stringBuffer.append(TEXT_112);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_114);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_115);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_116);
    		
								}
        					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_117);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_118);
    
                			} else{

    stringBuffer.append(TEXT_119);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_121);
    
                			}
                		}
    			        if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_122);
    
						}
    		        }//F4
					if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_123);
    
					}
				}

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
			}//D1
		}//C1
	}//B1
}//A1

if(!useStream){

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    
	if(isAppend){

    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    
	}
}
if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_168);
    
    
    
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
            String fullName = null;
            String extensionName = null;
            String directoryName = null;    
            
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
            
    		String fileNewname = ElementParameterParser.getValue(node,"__FILENAME__");
    		
    		boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
    		
            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
            
            boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
            
            boolean hasDynamic = metadata.isDynamicSchema();
				if(hasDynamic){
            
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    	}
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(splitEvery );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_180);
    
			if(!useStream){
			//**************************** the following is the part of file Path***************************************
			
    			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

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
    
    			}

    stringBuffer.append(TEXT_188);
     	
    			String writerClass = null;
    			if(isInRowMode){
    				writerClass = "routines.system.BufferedOutput";
    			}else{
    				writerClass = "java.io.BufferedWriter";
    			}
    			if(!split){
    				if(compress && !isAppend){// compress the dest file

    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_205);
    
    				}else{

    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_212);
     
					}
    			} else {

    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_225);
    
    			}
    			
    			if(isIncludeHeader && !hasDynamic){
    		    
    stringBuffer.append(TEXT_226);
    
					if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_227);
    
					}
					if (codeGenArgument.subTreeContainsParallelIterate()) {
				
    stringBuffer.append(TEXT_228);
     
		        	}
		        	if (isParallelize) {
				
    stringBuffer.append(TEXT_229);
     
					}
					if(!split && compress && !isAppend){
		        
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    
    		    	}else{
    		    	
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    
    		        }		
	    		        List<IMetadataColumn> columns = metadata.getListColumns();
	    		        int sizeColumns = columns.size();
	    		        for (int i = 0; i < sizeColumns; i++) {
	    		            IMetadataColumn column = columns.get(i);
                            if(sizeColumns > schemaOptNum){
                            	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    
                            	}
                            }else{//AA
	    		            
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_241);
    
	    		            if(i != sizeColumns - 1) {
	    		                
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    
	    		            }
	    		            }//AA
	    		        }
    		        
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
     
		        	if (isParallelize) {
				
    stringBuffer.append(TEXT_249);
    
		        	}
					if (codeGenArgument.subTreeContainsParallelIterate()) {
				
    stringBuffer.append(TEXT_250);
    
		        	}
		        	if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_251);
    
					}
		        
    
    			}

    		}else{
    		//***********************the following is the part of output Stream**************************************
    		
    			String writerClass = null;
    			if(isInRowMode){
    				writerClass = "routines.system.BufferedOutput";
    			}else{
    				writerClass = "java.io.BufferedWriter";
    			}
    			if(compress){// compress the dest output stream
 
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    
    			}else{

    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    
				}
    			if(isIncludeHeader && !hasDynamic){
    		        List<IMetadataColumn> columns = metadata.getListColumns();
    		        int sizeColumns = columns.size();
    		        for (int i = 0; i < sizeColumns; i++) {
    		            IMetadataColumn column = columns.get(i);
  						if(sizeColumns > schemaOptNum){
                            if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    
                            }
                        }else{//BB
    		            
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_281);
    
    		            if(i != sizeColumns - 1) {
    		                
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    
    		            }
    		            }//BB
    		        }
    		        
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    
    		    }
    		}// ****************************output Stream end*************************************
        }
    }
    
    stringBuffer.append(TEXT_288);
    
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{// the following is the tFileOutputCSV component
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_289);
    
    
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {                       
        	List<IMetadataColumn> columns = metadata.getListColumns();
	    	int sizeColumns = columns.size(); 
    		String delim = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
    		String rowSeparator = ElementParameterParser.getValue(node, "__CSVROWSEPARATOR__");
    		boolean useOSLineSeparator = ("true").equals(ElementParameterParser.getValue(node,"__OS_LINE_SEPARATOR_AS_ROW_SEPARATOR__"));
    		
        	String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
        	
 			if(escapeChar1.equals("\"\"\"")){
 				escapeChar1 = "\"\\\"\"";
 			}
        	
        	String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
 			if(textEnclosure1.equals("\"\"\"")){
 				textEnclosure1 = "\"\\\"\"";
 			}
 			
        	boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
            
            boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
            
            boolean hasDynamic = metadata.isDynamicSchema();
				if(hasDynamic){
            
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    
            	}else{
            
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_295);
    
            	}
    	    
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(splitEvery );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(delim);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(escapeChar1 );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(textEnclosure1 );
    stringBuffer.append(TEXT_323);
    
			if(!useStream){
			//**************************** the following is the part of file Path***************************************
            	if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){
                
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    
            	}
    	
	            if(!split){
	            	if(isInRowMode){
    					if(compress && !isAppend){// compress the dest file

    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    
    					}else{

    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_364);
    
                		}
                	}else{
                		if(compress && !isAppend){// compress the dest file
				
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_382);
    
						}else{
				
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    
						}
                	}
	            }else{
	            	if(isInRowMode){
                
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    
                	}else{
                
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_422);
    
                	}
	            }
	            
	            if(!useOSLineSeparator) {
	    		
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    
	    		} else {
	    		
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_433);
    
	    		}
	    		
	    	    if(isIncludeHeader && !hasDynamic)
	    	    {
    	        
    stringBuffer.append(TEXT_434);
    
				if(codeGenArgument.getIsRunInMultiThread()){
			
    stringBuffer.append(TEXT_435);
    
				}
				if (codeGenArgument.subTreeContainsParallelIterate()) {
			
    stringBuffer.append(TEXT_436);
     
	        	}
	        	if (isParallelize) {
			
    stringBuffer.append(TEXT_437);
     
				}
				if(!split && compress && !isAppend){
	        
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    
	        	}else{
	        
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    
    	        }			
	         			for(int i = 0 ; i < sizeColumns ; i++)
	        			{
	        				IMetadataColumn column = columns.get(i);
							if(sizeColumns> schemaOptNum){
                            	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    
                            	}
                           	}else{//CC
        				
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_449);
    
        					}//CC
         				}
    	            
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    if(isInRowMode){
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    }
    stringBuffer.append(TEXT_460);
     
	        	if (isParallelize) {
			
    stringBuffer.append(TEXT_461);
    
	        	}
				if (codeGenArgument.subTreeContainsParallelIterate()) {
			
    stringBuffer.append(TEXT_462);
    
	        	}
	        	if(codeGenArgument.getIsRunInMultiThread()){
			
    stringBuffer.append(TEXT_463);
    
				}
	        
    		  
	    	    }
	    	}else{
    		//***********************the following is the part of output Stream**************************************
	            if(isInRowMode){
	            	if(compress){// compress the dest output stream

    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_481);
    
	            	}else{

    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_486);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_495);
    
					}
                }else{
                	if(compress){// compress the dest output stream

    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_505);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_512);
    
                	}else{

    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_518);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_525);
    
					}
                }
                
                if(!useOSLineSeparator) {

    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_530);
    
    	    	} else {
    	    	
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_536);
    
    	    	}
    	    	
	    	    if(isIncludeHeader && !hasDynamic)
	    	    {
	    	        for(int i = 0; i < sizeColumns; i++)
	        		{
	        			IMetadataColumn column = columns.get(i);
						if(sizeColumns> schemaOptNum){
                            if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    
                            }
                       	}else{//DD
        			
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_544);
    
       					}//DD
	        		}
    	        
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    if(isInRowMode){
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    }
	    	    }
	    	}//*****************************csv mode under output stream end********************************************************
	    	
	    	if(!(isIncludeHeader && hasDynamic)){//when there is dynamic schema, it won't be enclosed with "\""

    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_558);
    
			}
	    }
    }
    
    stringBuffer.append(TEXT_559);
    
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

    stringBuffer.append(TEXT_560);
    return stringBuffer.toString();
  }
}
