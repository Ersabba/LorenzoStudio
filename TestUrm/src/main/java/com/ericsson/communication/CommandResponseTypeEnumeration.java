package com.ericsson.communication;

import java.io.Serializable;

public class CommandResponseTypeEnumeration implements Serializable {

    private static int initialArraySize = 148;
    private static CommandResponseTypeEnumeration[] allResponseType = new CommandResponseTypeEnumeration[initialArraySize];

    public static CommandResponseTypeEnumeration GENERIC_RESPONSE_TYPE = new CommandResponseTypeEnumeration(1, "Generico");
    public static CommandResponseTypeEnumeration LETTURA_RESPONSE_TYPE = new CommandResponseTypeEnumeration(2, "Lettura");
    public static CommandResponseTypeEnumeration ERROR_RESPONSE_TYPE = new CommandResponseTypeEnumeration(3, "Errore");
    public static CommandResponseTypeEnumeration RES_20_RESPONSE_TYPE = new CommandResponseTypeEnumeration(4, "Res20");
    public static CommandResponseTypeEnumeration RES_21_RESPONSE_TYPE = new CommandResponseTypeEnumeration(5, "Res21");
    public static CommandResponseTypeEnumeration RES_23_RESPONSE_TYPE = new CommandResponseTypeEnumeration(6, "Res23");
    public static CommandResponseTypeEnumeration RES_24_RESPONSE_TYPE = new CommandResponseTypeEnumeration(7, "Res24");
    public static CommandResponseTypeEnumeration RES_25_RESPONSE_TYPE = new CommandResponseTypeEnumeration(8, "Res25");
    public static CommandResponseTypeEnumeration RES_26_RESPONSE_TYPE = new CommandResponseTypeEnumeration(9, "Res26");
    public static CommandResponseTypeEnumeration RES_27_RESPONSE_TYPE = new CommandResponseTypeEnumeration(10, "Res27");
    public static CommandResponseTypeEnumeration RES_28_RESPONSE_TYPE = new CommandResponseTypeEnumeration(11, "Res28");
    public static CommandResponseTypeEnumeration RES_32_RESPONSE_TYPE = new CommandResponseTypeEnumeration(12, "Res32");
    public static CommandResponseTypeEnumeration RES_33_RESPONSE_TYPE = new CommandResponseTypeEnumeration(13, "Res33");
    public static CommandResponseTypeEnumeration RES_34_RESPONSE_TYPE = new CommandResponseTypeEnumeration(14, "Res34");
    public static CommandResponseTypeEnumeration PARSER_39_FILE = new CommandResponseTypeEnumeration(15, "Res39");
    public static CommandResponseTypeEnumeration PARSER_40_FILE = new CommandResponseTypeEnumeration(16, "Res40");
    public static CommandResponseTypeEnumeration PARSER_41_FILE = new CommandResponseTypeEnumeration(17, "Res41");
    public static CommandResponseTypeEnumeration RES_42_RESPONSE_TYPE = new CommandResponseTypeEnumeration(18, "Res42");
    public static CommandResponseTypeEnumeration RES_22_RESPONSE_TYPE = new CommandResponseTypeEnumeration(19, "Res22");
    public static CommandResponseTypeEnumeration GENERIC_RES_MTR_TYPE = new CommandResponseTypeEnumeration(20, "GenericoMtr");
    public static CommandResponseTypeEnumeration RES_44_RESPONSE_TYPE = new CommandResponseTypeEnumeration(21, "Res44");
    public static CommandResponseTypeEnumeration PARSER_48_FILE = new CommandResponseTypeEnumeration(22, "Res48");
    public static CommandResponseTypeEnumeration PARSER_49_FILE = new CommandResponseTypeEnumeration(23, "Res49");
    public static CommandResponseTypeEnumeration RES_50_RESPONSE_TYPE = new CommandResponseTypeEnumeration(24, "Res50");
    public static CommandResponseTypeEnumeration RES_51_RESPONSE_TYPE = new CommandResponseTypeEnumeration(25, "Res51");
    public static CommandResponseTypeEnumeration RES_52_RESPONSE_TYPE = new CommandResponseTypeEnumeration(26, "Res52");
    public static CommandResponseTypeEnumeration RES_53_RESPONSE_TYPE = new CommandResponseTypeEnumeration(27, "Res53");
    public static CommandResponseTypeEnumeration RES_54_RESPONSE_TYPE = new CommandResponseTypeEnumeration(28, "Res54");
    public static CommandResponseTypeEnumeration RES_56_RESPONSE_TYPE = new CommandResponseTypeEnumeration(29, "Res56");
    public static CommandResponseTypeEnumeration PARSER_57_FILE = new CommandResponseTypeEnumeration(30, "Res57");
    public static CommandResponseTypeEnumeration RES_59_RESPONSE_TYPE = new CommandResponseTypeEnumeration(31, "Res59");
    public static CommandResponseTypeEnumeration RES_61_RESPONSE_TYPE = new CommandResponseTypeEnumeration(32, "Res61");
    public static CommandResponseTypeEnumeration RES_64_RESPONSE_TYPE = new CommandResponseTypeEnumeration(33, "Res64");
    public static CommandResponseTypeEnumeration RES_69_RESPONSE_TYPE = new CommandResponseTypeEnumeration(34, "Res69");
    public static CommandResponseTypeEnumeration RES_71_RESPONSE_TYPE = new CommandResponseTypeEnumeration(35, "Res71");
    public static CommandResponseTypeEnumeration PARSER_72_FILE = new CommandResponseTypeEnumeration(36, "Res72");
    public static CommandResponseTypeEnumeration PARSER_74_FILE = new CommandResponseTypeEnumeration(37, "Res74");
    public static CommandResponseTypeEnumeration PARSER_84_FILE = new CommandResponseTypeEnumeration(38, "Res84");
    public static CommandResponseTypeEnumeration PARSER_85_FILE = new CommandResponseTypeEnumeration(39, "Res85");
    public static CommandResponseTypeEnumeration PARSER_86_FILE = new CommandResponseTypeEnumeration(40, "Res86");
    public static CommandResponseTypeEnumeration PARSER_87_FILE = new CommandResponseTypeEnumeration(41, "Res87");
    public static CommandResponseTypeEnumeration PARSER_88_FILE = new CommandResponseTypeEnumeration(42, "Res88");
    public static CommandResponseTypeEnumeration PARSER_89_FILE = new CommandResponseTypeEnumeration(43, "Res89");
    public static CommandResponseTypeEnumeration RES_90_RESPONSE_TYPE = new CommandResponseTypeEnumeration(44, "Res90");
    public static CommandResponseTypeEnumeration RES_96_RESPONSE_TYPE = new CommandResponseTypeEnumeration(45, "Res96");
    public static CommandResponseTypeEnumeration RES_97_RESPONSE_TYPE = new CommandResponseTypeEnumeration(46, "Res97");
    public static CommandResponseTypeEnumeration RES_98_RESPONSE_TYPE = new CommandResponseTypeEnumeration(47, "Res98");
    public static CommandResponseTypeEnumeration RES_99_RESPONSE_TYPE = new CommandResponseTypeEnumeration(48, "Res99");
    public static CommandResponseTypeEnumeration RES_100_RESPONSE_TYPE = new CommandResponseTypeEnumeration(49, "Res100");
    public static CommandResponseTypeEnumeration GENERIC_RESPONSE_AL = new CommandResponseTypeEnumeration(50, "Res101");
    public static CommandResponseTypeEnumeration PARSER_102_FILE = new CommandResponseTypeEnumeration(51, "Res102");
    public static CommandResponseTypeEnumeration PARSER_103_FILE = new CommandResponseTypeEnumeration(52, "Res103");
    public static CommandResponseTypeEnumeration PARSER_104_FILE = new CommandResponseTypeEnumeration(53, "Res104");
    public static CommandResponseTypeEnumeration PARSER_105_FILE = new CommandResponseTypeEnumeration(54, "Res105");
    public static CommandResponseTypeEnumeration PARSER_73_FILE = new CommandResponseTypeEnumeration(55, "Res73");
    public static CommandResponseTypeEnumeration PARSER_106_FILE = new CommandResponseTypeEnumeration(56, "Res106");
    public static CommandResponseTypeEnumeration PARSER_107_FILE = new CommandResponseTypeEnumeration(57, "Res107");
    public static CommandResponseTypeEnumeration PARSER_75_FILE = new CommandResponseTypeEnumeration(58, "Res75");
    public static CommandResponseTypeEnumeration PARSER_108_FILE = new CommandResponseTypeEnumeration(59, "Res108");
    public static CommandResponseTypeEnumeration PARSER_76_FILE = new CommandResponseTypeEnumeration(60, "Res76");
    public static CommandResponseTypeEnumeration PARSER_109_FILE = new CommandResponseTypeEnumeration(61, "Res109");
    public static CommandResponseTypeEnumeration PARSER_77_FILE = new CommandResponseTypeEnumeration(62, "Res77");
    public static CommandResponseTypeEnumeration PARSER_110_FILE = new CommandResponseTypeEnumeration(63, "Res110");
    public static CommandResponseTypeEnumeration PARSER_78_FILE = new CommandResponseTypeEnumeration(64, "Res78");
    public static CommandResponseTypeEnumeration PARSER_111_FILE = new CommandResponseTypeEnumeration(65, "Res111");
    public static CommandResponseTypeEnumeration PARSER_79_FILE = new CommandResponseTypeEnumeration(66, "Res79");
    public static CommandResponseTypeEnumeration PARSER_112_FILE = new CommandResponseTypeEnumeration(67, "Res112");
    public static CommandResponseTypeEnumeration PARSER_80_FILE = new CommandResponseTypeEnumeration(68, "Res80");
    public static CommandResponseTypeEnumeration PARSER_113_FILE = new CommandResponseTypeEnumeration(69, "Res113");
    public static CommandResponseTypeEnumeration PARSER_81_FILE = new CommandResponseTypeEnumeration(70, "Res81");
    public static CommandResponseTypeEnumeration PARSER_114_FILE = new CommandResponseTypeEnumeration(71, "Res114");
    public static CommandResponseTypeEnumeration PARSER_82_FILE = new CommandResponseTypeEnumeration(72, "Res82");
    public static CommandResponseTypeEnumeration PARSER_115_FILE = new CommandResponseTypeEnumeration(73, "Res115");
    public static CommandResponseTypeEnumeration PARSER_83_FILE = new CommandResponseTypeEnumeration(74, "Res83");
    public static CommandResponseTypeEnumeration PARSER_116_FILE = new CommandResponseTypeEnumeration(75, "Res116");
    public static CommandResponseTypeEnumeration RES_117_RESPONSE_TYPE = new CommandResponseTypeEnumeration(76, "Res117");
    public static CommandResponseTypeEnumeration PARSER_120_FILE = new CommandResponseTypeEnumeration(77, "Res120");
    public static CommandResponseTypeEnumeration PARSER_121_FILE = new CommandResponseTypeEnumeration(78, "Res121");
   
    public static CommandResponseTypeEnumeration RES_123_RESPONSE_TYPE = new CommandResponseTypeEnumeration(79, "Res123");
    public static CommandResponseTypeEnumeration RES_124_RESPONSE_TYPE = new CommandResponseTypeEnumeration(80, "Res124");
    public static CommandResponseTypeEnumeration RES_125_RESPONSE_TYPE = new CommandResponseTypeEnumeration(81, "Res125");
    public static CommandResponseTypeEnumeration RES_126_RESPONSE_TYPE = new CommandResponseTypeEnumeration(82, "Res126");
    public static CommandResponseTypeEnumeration RES_127_RESPONSE_TYPE = new CommandResponseTypeEnumeration(83, "Res127");
    public static CommandResponseTypeEnumeration RES_128_RESPONSE_TYPE = new CommandResponseTypeEnumeration(84, "Res128");
    public static CommandResponseTypeEnumeration RES_129_RESPONSE_TYPE = new CommandResponseTypeEnumeration(85, "Res129");
    public static CommandResponseTypeEnumeration RES_130_RESPONSE_TYPE = new CommandResponseTypeEnumeration(86, "Res130");
    public static CommandResponseTypeEnumeration RES_131_RESPONSE_TYPE = new CommandResponseTypeEnumeration(87, "Res131");
    public static CommandResponseTypeEnumeration RES_132_RESPONSE_TYPE = new CommandResponseTypeEnumeration(88, "Res132");
    public static CommandResponseTypeEnumeration RES_133_RESPONSE_TYPE = new CommandResponseTypeEnumeration(89, "Res133");
    public static CommandResponseTypeEnumeration RES_134_RESPONSE_TYPE = new CommandResponseTypeEnumeration(90, "Res134");
    public static CommandResponseTypeEnumeration RES_135_RESPONSE_TYPE = new CommandResponseTypeEnumeration(91, "Res135");
    public static CommandResponseTypeEnumeration RES_136_RESPONSE_TYPE = new CommandResponseTypeEnumeration(92, "Res136");
    public static CommandResponseTypeEnumeration RES_137_RESPONSE_TYPE = new CommandResponseTypeEnumeration(93, "Res137");
    public static CommandResponseTypeEnumeration RES_138_RESPONSE_TYPE = new CommandResponseTypeEnumeration(94, "Res138");
    public static CommandResponseTypeEnumeration RES_139_RESPONSE_TYPE = new CommandResponseTypeEnumeration(95, "Res139");
    public static CommandResponseTypeEnumeration RES_140_RESPONSE_TYPE = new CommandResponseTypeEnumeration(96, "Res140");
    public static CommandResponseTypeEnumeration RES_141_RESPONSE_TYPE = new CommandResponseTypeEnumeration(97, "Res141");
    public static CommandResponseTypeEnumeration RES_142_RESPONSE_TYPE = new CommandResponseTypeEnumeration(98, "Res142");
    public static CommandResponseTypeEnumeration RES_143_RESPONSE_TYPE = new CommandResponseTypeEnumeration(99, "Res143");
    public static CommandResponseTypeEnumeration RES_144_RESPONSE_TYPE = new CommandResponseTypeEnumeration(100, "Res144");
    public static CommandResponseTypeEnumeration RES_145_RESPONSE_TYPE = new CommandResponseTypeEnumeration(101, "Res145");
    public static CommandResponseTypeEnumeration RES_146_RESPONSE_TYPE = new CommandResponseTypeEnumeration(102, "Res146");
    public static CommandResponseTypeEnumeration RES_147_RESPONSE_TYPE = new CommandResponseTypeEnumeration(103, "Res147");
    public static CommandResponseTypeEnumeration RES_148_RESPONSE_TYPE = new CommandResponseTypeEnumeration(104, "Res148");
    public static CommandResponseTypeEnumeration RES_149_RESPONSE_TYPE = new CommandResponseTypeEnumeration(105, "Res149");
    public static CommandResponseTypeEnumeration RES_153_RESPONSE_TYPE = new CommandResponseTypeEnumeration(106, "Res153");
    public static CommandResponseTypeEnumeration RES_154_RESPONSE_TYPE = new CommandResponseTypeEnumeration(107, "Res154");
    public static CommandResponseTypeEnumeration RES_155_RESPONSE_TYPE = new CommandResponseTypeEnumeration(108, "Res155");
    public static CommandResponseTypeEnumeration RES_156_RESPONSE_TYPE = new CommandResponseTypeEnumeration(109, "Res156");
    public static CommandResponseTypeEnumeration RES_157_RESPONSE_TYPE = new CommandResponseTypeEnumeration(110, "Res157");
    public static CommandResponseTypeEnumeration RES_158_RESPONSE_TYPE = new CommandResponseTypeEnumeration(111, "Res158");
    public static CommandResponseTypeEnumeration RES_159_RESPONSE_TYPE = new CommandResponseTypeEnumeration(112, "Res159");
    public static CommandResponseTypeEnumeration RES_160_RESPONSE_TYPE = new CommandResponseTypeEnumeration(113, "Res160");
    public static CommandResponseTypeEnumeration RES_161_RESPONSE_TYPE = new CommandResponseTypeEnumeration(114, "Res161");
    public static CommandResponseTypeEnumeration RES_162_RESPONSE_TYPE = new CommandResponseTypeEnumeration(115, "Res162");
    public static CommandResponseTypeEnumeration RES_163_RESPONSE_TYPE = new CommandResponseTypeEnumeration(116, "Res163");
    public static CommandResponseTypeEnumeration RES_164_RESPONSE_TYPE = new CommandResponseTypeEnumeration(117, "Res164");
    public static CommandResponseTypeEnumeration RES_165_RESPONSE_TYPE = new CommandResponseTypeEnumeration(118, "Res165");
    public static CommandResponseTypeEnumeration RES_166_RESPONSE_TYPE = new CommandResponseTypeEnumeration(119, "Res166");
    public static CommandResponseTypeEnumeration RES_167_RESPONSE_TYPE = new CommandResponseTypeEnumeration(120, "Res167");
    public static CommandResponseTypeEnumeration PARSER_168_FILE = new CommandResponseTypeEnumeration(121, "Res168");
    public static CommandResponseTypeEnumeration PARSER_169_FILE = new CommandResponseTypeEnumeration(122, "Res169");
    public static CommandResponseTypeEnumeration PARSER_170_FILE = new CommandResponseTypeEnumeration(123, "Res170");
    public static CommandResponseTypeEnumeration RES_172_RESPONSE_TYPE = new CommandResponseTypeEnumeration(124, "Res172");
    public static CommandResponseTypeEnumeration RES_173_RESPONSE_TYPE = new CommandResponseTypeEnumeration(125, "Res173");
    public static CommandResponseTypeEnumeration RES_174_RESPONSE_TYPE = new CommandResponseTypeEnumeration(126, "Res174");
    public static CommandResponseTypeEnumeration RES_175_RESPONSE_TYPE = new CommandResponseTypeEnumeration(127, "Res175");
    public static CommandResponseTypeEnumeration RES_176_RESPONSE_TYPE = new CommandResponseTypeEnumeration(128, "Res176");
    public static CommandResponseTypeEnumeration RES_177_RESPONSE_TYPE = new CommandResponseTypeEnumeration(129, "Res177");
    public static CommandResponseTypeEnumeration RES_179_RESPONSE_TYPE = new CommandResponseTypeEnumeration(130, "Res179");
    public static CommandResponseTypeEnumeration RES_180_RESPONSE_TYPE = new CommandResponseTypeEnumeration(131, "Res180");
    public static CommandResponseTypeEnumeration RES_181_RESPONSE_TYPE = new CommandResponseTypeEnumeration(132, "Res181");
    public static CommandResponseTypeEnumeration RES_182_RESPONSE_TYPE = new CommandResponseTypeEnumeration(133, "Res182");
    public static CommandResponseTypeEnumeration RES_183_RESPONSE_TYPE = new CommandResponseTypeEnumeration(134, "Res183");
    public static CommandResponseTypeEnumeration RES_184_RESPONSE_TYPE = new CommandResponseTypeEnumeration(135, "Res183");
    public static CommandResponseTypeEnumeration RES_185_RESPONSE_TYPE = new CommandResponseTypeEnumeration(136, "Res183");
    public static CommandResponseTypeEnumeration RES_186_RESPONSE_TYPE = new CommandResponseTypeEnumeration(137, "Res183");
    public static CommandResponseTypeEnumeration RES_178_RESPONSE_TYPE = new CommandResponseTypeEnumeration(138, "Res178");
    public static CommandResponseTypeEnumeration ERROR_RESPONSEDWL = new CommandResponseTypeEnumeration(139, "Generic");
    public static CommandResponseTypeEnumeration RES_187_RESPONSE_TYPE = new CommandResponseTypeEnumeration(140, "Res187");
    public static CommandResponseTypeEnumeration RES_188_RESPONSE_TYPE = new CommandResponseTypeEnumeration(141, "Res188");
    public static CommandResponseTypeEnumeration RES_189_RESPONSE_TYPE = new CommandResponseTypeEnumeration(142, "Res189");
    public static CommandResponseTypeEnumeration RES_190_RESPONSE_TYPE = new CommandResponseTypeEnumeration(143, "Res190");
    public static CommandResponseTypeEnumeration RES_191_RESPONSE_TYPE = new CommandResponseTypeEnumeration(144, "Res191");    
    public static CommandResponseTypeEnumeration PARSER_192_FILE = new CommandResponseTypeEnumeration(145, "Res192");
    public static CommandResponseTypeEnumeration PARSER_193_FILE = new CommandResponseTypeEnumeration(146, "Res193");
    public static CommandResponseTypeEnumeration PARSER_195_FILE = new CommandResponseTypeEnumeration(147, "Res195");
    public static CommandResponseTypeEnumeration PARSER_DQF_FILE = new CommandResponseTypeEnumeration(148, "ResDQF");
    public static CommandResponseTypeEnumeration GET_FILE = new CommandResponseTypeEnumeration(149, "GetFile");
    public static CommandResponseTypeEnumeration ACQ_RESPONSE_TYPE = new CommandResponseTypeEnumeration(150, "ResAcqFile");
    public static CommandResponseTypeEnumeration PROC_FETCHED_FILE_RESPONSE_TYPE = new CommandResponseTypeEnumeration(151, "ProcessFetchedFileResponseType");
    public static CommandResponseTypeEnumeration ACK_NACK_RESPONSE_TYPE = new CommandResponseTypeEnumeration(152, "AckNackResponseType");
	public static CommandResponseTypeEnumeration PROC_RESPONSE_TYPE = new CommandResponseTypeEnumeration(153, "ProcessResponseType");
	public static CommandResponseTypeEnumeration RES_CCS_STATUS = new CommandResponseTypeEnumeration(154, "CcsStatusResponseType");
    public static CommandResponseTypeEnumeration RES_RESET_LENNTS_LIST = new CommandResponseTypeEnumeration(155, "ResResetLenntsList");


    private final int id;
    private final String name;
    private Class implementingClass;


    private CommandResponseTypeEnumeration(int id, String name) {
        this.id = id;
        this.name = name;

        if (id >= allResponseType.length) {
            CommandResponseTypeEnumeration[] newArray = new CommandResponseTypeEnumeration[id+1];
            System.arraycopy(allResponseType, 0, newArray, 0, allResponseType.length);
            allResponseType = newArray;
        }

        allResponseType[id] = this;
    }

    public static CommandResponseTypeEnumeration getType(int id) {
        if (id >= allResponseType.length) {
            return null;
        }
        return allResponseType[id];
    }

    protected void setImplementingClass(Class theClass) {
        this.implementingClass = theClass;
    }

    protected Class getImplementingClass() {
        return this.implementingClass;
    }

    public String toString() {
        return name;
    }
}
