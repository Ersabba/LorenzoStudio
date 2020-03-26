package com.ericsson.communication;

import java.io.Serializable;

public class CommandRequestTypeEnumeration implements Serializable {

    public static CommandRequestTypeEnumeration ALLACCIO_REQUEST_TYPE = new CommandRequestTypeEnumeration(1, "Allaccio");
    public static CommandRequestTypeEnumeration LETTURA_REQUEST_TYPE = new CommandRequestTypeEnumeration(2, "Lettura");
    public static CommandRequestTypeEnumeration DISTACCO_REQUEST_TYPE = new CommandRequestTypeEnumeration(3, "Distacco");
    public static CommandRequestTypeEnumeration ANNULLAMENTO_REQUEST_TYPE = new CommandRequestTypeEnumeration(4, "Annullamento");
    public static CommandRequestTypeEnumeration INSTALLAZIONE_REQUEST_TYPE = new CommandRequestTypeEnumeration(5, "Installazione");

    // Distacco d'ufficio.
    public static CommandRequestTypeEnumeration REQ_06_REQUEST_TYPE = new CommandRequestTypeEnumeration(6, "ReqGCF");

    // Distacco per morosita'.
    public static CommandRequestTypeEnumeration REQ_07_REQUEST_TYPE = new CommandRequestTypeEnumeration(7, "ReqGCF");

    // Disattivazione stagionale.
    public static CommandRequestTypeEnumeration REQ_08_REQUEST_TYPE = new CommandRequestTypeEnumeration(8, "ReqGCF");

    // Riattivazione per LENNT non semidiretti.
    public static CommandRequestTypeEnumeration REQ_09_REQUEST_TYPE = new CommandRequestTypeEnumeration(9, "ReqGCF");

    // Attivazione stagionale a seguito di primo allaccio.
    public static CommandRequestTypeEnumeration REQ_10_REQUEST_TYPE = new CommandRequestTypeEnumeration(10, "ReqGCF");

    // Attivazione stagionale trattata come riattivazione per LENNT non semidiretti.
    public static CommandRequestTypeEnumeration REQ_11_REQUEST_TYPE = new CommandRequestTypeEnumeration(11, "ReqGCF");

    // Modifica contrattuale.
    public static CommandRequestTypeEnumeration REQ_12_REQUEST_TYPE = new CommandRequestTypeEnumeration(12, "ReqGCF");

    // Voltura.
    public static CommandRequestTypeEnumeration REQ_13_REQUEST_TYPE = new CommandRequestTypeEnumeration(13, "ReqGCF");

    // Avviso 2 ad ALINK: notifica morosita' su una specifica fattura.
    public static CommandRequestTypeEnumeration REQ_14_REQUEST_TYPE = new CommandRequestTypeEnumeration(14, "ReqGCF");

    // Avviso 31 ad ALINK: notifica morosita' senza una specifica fattura.
    public static CommandRequestTypeEnumeration REQ_15_REQUEST_TYPE = new CommandRequestTypeEnumeration(15, "ReqGCF");

    // Notifica dati di fatturazione su ALINK.
    public static CommandRequestTypeEnumeration REQ_16_REQUEST_TYPE = new CommandRequestTypeEnumeration(16, "ReqGCF");
    public static CommandRequestTypeEnumeration REQ_17_REQUEST_TYPE = new CommandRequestTypeEnumeration(17, "ReqGCF");
    public static CommandRequestTypeEnumeration REQ_18_REQUEST_TYPE = new CommandRequestTypeEnumeration(18, "ReqGCF");

    public static CommandRequestTypeEnumeration QUALITY_REQUEST_TYPE = new CommandRequestTypeEnumeration(19, "Quality");
    public static CommandRequestTypeEnumeration REQ_20_REQUEST_TYPE = new CommandRequestTypeEnumeration(20, "ReadQuality");
    public static CommandRequestTypeEnumeration REQ_21_REQUEST_TYPE = new CommandRequestTypeEnumeration(21, "ReadQuality1");
    public static CommandRequestTypeEnumeration REQ_22_REQUEST_TYPE = new CommandRequestTypeEnumeration(22, "ReadQuality2");
    public static CommandRequestTypeEnumeration READ_23_REQUEST_TYPE = new CommandRequestTypeEnumeration(23, "ReadGAP");
    public static CommandRequestTypeEnumeration REQ_24_REQUEST_TYPE = new CommandRequestTypeEnumeration(24, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_25_REQUEST_TYPE = new CommandRequestTypeEnumeration(25, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_26_REQUEST_TYPE = new CommandRequestTypeEnumeration(26, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_27_REQUEST_TYPE = new CommandRequestTypeEnumeration(27, "RegGAP");
    public static CommandRequestTypeEnumeration REQ_28_REQUEST_TYPE = new CommandRequestTypeEnumeration(28, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_29_REQUEST_TYPE = new CommandRequestTypeEnumeration(29, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_30_REQUEST_TYPE = new CommandRequestTypeEnumeration(30, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_31_REQUEST_TYPE = new CommandRequestTypeEnumeration(31, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_32_REQUEST_TYPE = new CommandRequestTypeEnumeration(32, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_33_REQUEST_TYPE = new CommandRequestTypeEnumeration(33, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_34_REQUEST_TYPE = new CommandRequestTypeEnumeration(34, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_35_REQUEST_TYPE = new CommandRequestTypeEnumeration(35, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_36_REQUEST_TYPE = new CommandRequestTypeEnumeration(36, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_37_REQUEST_TYPE = new CommandRequestTypeEnumeration(37, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_38_REQUEST_TYPE = new CommandRequestTypeEnumeration(38, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_39_REQUEST_TYPE = new CommandRequestTypeEnumeration(39, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_40_REQUEST_TYPE = new CommandRequestTypeEnumeration(40, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_41_REQUEST_TYPE = new CommandRequestTypeEnumeration(41, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_42_REQUEST_TYPE = new CommandRequestTypeEnumeration(42, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_43_REQUEST_TYPE = new CommandRequestTypeEnumeration(43, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_44_REQUEST_TYPE = new CommandRequestTypeEnumeration(44, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_45_REQUEST_TYPE = new CommandRequestTypeEnumeration(45, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_46_REQUEST_TYPE = new CommandRequestTypeEnumeration(46, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_47_REQUEST_TYPE = new CommandRequestTypeEnumeration(47, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_48_REQUEST_TYPE = new CommandRequestTypeEnumeration(48, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_49_REQUEST_TYPE = new CommandRequestTypeEnumeration(49, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_50_REQUEST_TYPE = new CommandRequestTypeEnumeration(50, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_51_REQUEST_TYPE = new CommandRequestTypeEnumeration(51, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_52_REQUEST_TYPE = new CommandRequestTypeEnumeration(52, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_53_REQUEST_TYPE = new CommandRequestTypeEnumeration(53, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_54_REQUEST_TYPE = new CommandRequestTypeEnumeration(54, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_55_REQUEST_TYPE = new CommandRequestTypeEnumeration(55, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_56_REQUEST_TYPE = new CommandRequestTypeEnumeration(56, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_57_REQUEST_TYPE = new CommandRequestTypeEnumeration(57, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_58_REQUEST_TYPE = new CommandRequestTypeEnumeration(58, "ReqGDQ");
    public static CommandRequestTypeEnumeration REQ_59_REQUEST_TYPE = new CommandRequestTypeEnumeration(59, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_60_REQUEST_TYPE = new CommandRequestTypeEnumeration(60, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_61_REQUEST_TYPE = new CommandRequestTypeEnumeration(61, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_62_REQUEST_TYPE = new CommandRequestTypeEnumeration(62, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_63_REQUEST_TYPE = new CommandRequestTypeEnumeration(63, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_64_REQUEST_TYPE = new CommandRequestTypeEnumeration(64, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_65_REQUEST_TYPE = new CommandRequestTypeEnumeration(65, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_66_REQUEST_TYPE = new CommandRequestTypeEnumeration(66, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_67_REQUEST_TYPE = new CommandRequestTypeEnumeration(67, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_68_REQUEST_TYPE = new CommandRequestTypeEnumeration(68, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_69_REQUEST_TYPE = new CommandRequestTypeEnumeration(69, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_70_REQUEST_TYPE = new CommandRequestTypeEnumeration(70, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_71_REQUEST_TYPE = new CommandRequestTypeEnumeration(71, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_72_REQUEST_TYPE = new CommandRequestTypeEnumeration(72, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_73_REQUEST_TYPE = new CommandRequestTypeEnumeration(73, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_74_REQUEST_TYPE = new CommandRequestTypeEnumeration(74, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_75_REQUEST_TYPE = new CommandRequestTypeEnumeration(75, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_76_REQUEST_TYPE = new CommandRequestTypeEnumeration(76, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_77_REQUEST_TYPE = new CommandRequestTypeEnumeration(77, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_78_REQUEST_TYPE = new CommandRequestTypeEnumeration(78, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_79_REQUEST_TYPE = new CommandRequestTypeEnumeration(79, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_80_REQUEST_TYPE = new CommandRequestTypeEnumeration(80, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_81_REQUEST_TYPE = new CommandRequestTypeEnumeration(81, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_82_REQUEST_TYPE = new CommandRequestTypeEnumeration(82, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_83_REQUEST_TYPE = new CommandRequestTypeEnumeration(83, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_84_REQUEST_TYPE = new CommandRequestTypeEnumeration(84, "ReqGDQ");
    public static CommandRequestTypeEnumeration REQ_85_REQUEST_TYPE = new CommandRequestTypeEnumeration(85, "ReqGDQ");
    public static CommandRequestTypeEnumeration REQ_86_REQUEST_TYPE = new CommandRequestTypeEnumeration(86, "ReqGDQ");
    public static CommandRequestTypeEnumeration REQ_87_REQUEST_TYPE = new CommandRequestTypeEnumeration(87, "ReqGDQ");
    public static CommandRequestTypeEnumeration REQ_88_REQUEST_TYPE = new CommandRequestTypeEnumeration(88, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_89_REQUEST_TYPE = new CommandRequestTypeEnumeration(89, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_90_REQUEST_TYPE = new CommandRequestTypeEnumeration(90, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_91_REQUEST_TYPE = new CommandRequestTypeEnumeration(91, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_92_REQUEST_TYPE = new CommandRequestTypeEnumeration(92, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_93_REQUEST_TYPE = new CommandRequestTypeEnumeration(93, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_94_REQUEST_TYPE = new CommandRequestTypeEnumeration(94, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_95_REQUEST_TYPE = new CommandRequestTypeEnumeration(95, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_96_REQUEST_TYPE = new CommandRequestTypeEnumeration(96, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_97_REQUEST_TYPE = new CommandRequestTypeEnumeration(97, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_98_REQUEST_TYPE = new CommandRequestTypeEnumeration(98, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_99_REQUEST_TYPE = new CommandRequestTypeEnumeration(99, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_100_REQUEST_TYPE = new CommandRequestTypeEnumeration(100, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_101_REQUEST_TYPE = new CommandRequestTypeEnumeration(101, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_102_REQUEST_TYPE = new CommandRequestTypeEnumeration(102, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_103_REQUEST_TYPE = new CommandRequestTypeEnumeration(103, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_104_REQUEST_TYPE = new CommandRequestTypeEnumeration(104, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_105_REQUEST_TYPE = new CommandRequestTypeEnumeration(105, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_106_REQUEST_TYPE = new CommandRequestTypeEnumeration(106, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_107_REQUEST_TYPE = new CommandRequestTypeEnumeration(107, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_108_REQUEST_TYPE = new CommandRequestTypeEnumeration(108, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_109_REQUEST_TYPE = new CommandRequestTypeEnumeration(109, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_110_REQUEST_TYPE = new CommandRequestTypeEnumeration(110, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_111_REQUEST_TYPE = new CommandRequestTypeEnumeration(111, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_112_REQUEST_TYPE = new CommandRequestTypeEnumeration(112, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_113_REQUEST_TYPE = new CommandRequestTypeEnumeration(113, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_114_REQUEST_TYPE = new CommandRequestTypeEnumeration(114, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_115_REQUEST_TYPE = new CommandRequestTypeEnumeration(115, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_116_REQUEST_TYPE = new CommandRequestTypeEnumeration(116, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_117_REQUEST_TYPE = new CommandRequestTypeEnumeration(117, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_118_REQUEST_TYPE = new CommandRequestTypeEnumeration(118, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_119_REQUEST_TYPE = new CommandRequestTypeEnumeration(119, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_120_REQUEST_TYPE = new CommandRequestTypeEnumeration(120, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_121_REQUEST_TYPE = new CommandRequestTypeEnumeration(121, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_122_REQUEST_TYPE = new CommandRequestTypeEnumeration(122, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_123_REQUEST_TYPE = new CommandRequestTypeEnumeration(123, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_124_REQUEST_TYPE = new CommandRequestTypeEnumeration(124, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_125_REQUEST_TYPE = new CommandRequestTypeEnumeration(125, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_126_REQUEST_TYPE = new CommandRequestTypeEnumeration(126, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_127_REQUEST_TYPE = new CommandRequestTypeEnumeration(127, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_128_REQUEST_TYPE = new CommandRequestTypeEnumeration(128, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_129_REQUEST_TYPE = new CommandRequestTypeEnumeration(129, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_130_REQUEST_TYPE = new CommandRequestTypeEnumeration(130, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_131_REQUEST_TYPE = new CommandRequestTypeEnumeration(131, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_132_REQUEST_TYPE = new CommandRequestTypeEnumeration(132, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_133_REQUEST_TYPE = new CommandRequestTypeEnumeration(133, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_134_REQUEST_TYPE = new CommandRequestTypeEnumeration(134, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_135_REQUEST_TYPE = new CommandRequestTypeEnumeration(135, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_136_REQUEST_TYPE = new CommandRequestTypeEnumeration(136, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_137_REQUEST_TYPE = new CommandRequestTypeEnumeration(137, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_138_REQUEST_TYPE = new CommandRequestTypeEnumeration(138, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_139_REQUEST_TYPE = new CommandRequestTypeEnumeration(139, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_140_REQUEST_TYPE = new CommandRequestTypeEnumeration(140, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_141_REQUEST_TYPE = new CommandRequestTypeEnumeration(141, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_142_REQUEST_TYPE = new CommandRequestTypeEnumeration(142, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_143_REQUEST_TYPE = new CommandRequestTypeEnumeration(143, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_144_REQUEST_TYPE = new CommandRequestTypeEnumeration(144, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_145_REQUEST_TYPE = new CommandRequestTypeEnumeration(145, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_146_REQUEST_TYPE = new CommandRequestTypeEnumeration(146, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_147_REQUEST_TYPE = new CommandRequestTypeEnumeration(147, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_148_REQUEST_TYPE = new CommandRequestTypeEnumeration(148, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_149_REQUEST_TYPE = new CommandRequestTypeEnumeration(149, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_150_REQUEST_TYPE = new CommandRequestTypeEnumeration(150, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_151_REQUEST_TYPE = new CommandRequestTypeEnumeration(151, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_152_REQUEST_TYPE = new CommandRequestTypeEnumeration(152, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_153_REQUEST_TYPE = new CommandRequestTypeEnumeration(153, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_154_REQUEST_TYPE = new CommandRequestTypeEnumeration(154, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_155_REQUEST_TYPE = new CommandRequestTypeEnumeration(155, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_156_REQUEST_TYPE = new CommandRequestTypeEnumeration(156, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_157_REQUEST_TYPE = new CommandRequestTypeEnumeration(157, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_158_REQUEST_TYPE = new CommandRequestTypeEnumeration(158, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_159_REQUEST_TYPE = new CommandRequestTypeEnumeration(159, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_160_REQUEST_TYPE = new CommandRequestTypeEnumeration(160, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_161_REQUEST_TYPE = new CommandRequestTypeEnumeration(161, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_162_REQUEST_TYPE = new CommandRequestTypeEnumeration(162, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_163_REQUEST_TYPE = new CommandRequestTypeEnumeration(163, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_164_REQUEST_TYPE = new CommandRequestTypeEnumeration(164, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_165_REQUEST_TYPE = new CommandRequestTypeEnumeration(165, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_166_REQUEST_TYPE = new CommandRequestTypeEnumeration(166, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_167_REQUEST_TYPE = new CommandRequestTypeEnumeration(167, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_168_REQUEST_TYPE = new CommandRequestTypeEnumeration(168, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_169_REQUEST_TYPE = new CommandRequestTypeEnumeration(169, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_170_REQUEST_TYPE = new CommandRequestTypeEnumeration(170, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_171_REQUEST_TYPE = new CommandRequestTypeEnumeration(171, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_172_REQUEST_TYPE = new CommandRequestTypeEnumeration(172, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_173_REQUEST_TYPE = new CommandRequestTypeEnumeration(173, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_174_REQUEST_TYPE = new CommandRequestTypeEnumeration(174, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_175_REQUEST_TYPE = new CommandRequestTypeEnumeration(175, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_176_REQUEST_TYPE = new CommandRequestTypeEnumeration(176, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_177_REQUEST_TYPE = new CommandRequestTypeEnumeration(177, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_178_REQUEST_TYPE = new CommandRequestTypeEnumeration(178, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_179_REQUEST_TYPE = new CommandRequestTypeEnumeration(179, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_180_REQUEST_TYPE = new CommandRequestTypeEnumeration(180, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_181_REQUEST_TYPE = new CommandRequestTypeEnumeration(181, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_182_REQUEST_TYPE = new CommandRequestTypeEnumeration(182, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_183_REQUEST_TYPE = new CommandRequestTypeEnumeration(183, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_184_REQUEST_TYPE = new CommandRequestTypeEnumeration(184, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_185_REQUEST_TYPE = new CommandRequestTypeEnumeration(185, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_186_REQUEST_TYPE = new CommandRequestTypeEnumeration(186, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_187_REQUEST_TYPE = new CommandRequestTypeEnumeration(187, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_188_REQUEST_TYPE = new CommandRequestTypeEnumeration(188, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_189_REQUEST_TYPE = new CommandRequestTypeEnumeration(189, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_190_REQUEST_TYPE = new CommandRequestTypeEnumeration(190, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_191_REQUEST_TYPE = new CommandRequestTypeEnumeration(191, "ReqGAP");
    public static CommandRequestTypeEnumeration REQ_192_REQUEST_TYPE = new CommandRequestTypeEnumeration(192, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_193_REQUEST_TYPE = new CommandRequestTypeEnumeration(193, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_194_REQUEST_TYPE = new CommandRequestTypeEnumeration(194, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_195_REQUEST_TYPE = new CommandRequestTypeEnumeration(195, "ReqGRE");
    public static CommandRequestTypeEnumeration REQ_196_REQUEST_TYPE = new CommandRequestTypeEnumeration(196, "ReqGAP");    
    public static CommandRequestTypeEnumeration DISATTIVAZIONE_PORTA_LENNT_TYPE = new CommandRequestTypeEnumeration(197, "DisattivazionePorta");
    public static CommandRequestTypeEnumeration VARIAZIONE_PIANI_TARIFFARI_REQUEST_TYPE = new CommandRequestTypeEnumeration(198, "VariazionePianiTariffari");
    public static CommandRequestTypeEnumeration DOWNLOAD_PARSING_FILE_DQF = new CommandRequestTypeEnumeration(199, "PrelievoParsingFileDQF");
    public static CommandRequestTypeEnumeration DOWNLOAD_FILE_ADD = new CommandRequestTypeEnumeration(201, "PrelievoParsingFileADD");
    public static CommandRequestTypeEnumeration DOWNLOAD_FILE_DQF = new CommandRequestTypeEnumeration(202, "PrelievoParsingFileDQF");
    public static CommandRequestTypeEnumeration DOWNLOAD_FILE_DQN = new CommandRequestTypeEnumeration(203, "PrelievoParsingFileDQN");
    public static CommandRequestTypeEnumeration DOWNLOAD_FILE_GEN = new CommandRequestTypeEnumeration(204, "PrelievoFileGen");
    public static CommandRequestTypeEnumeration DOWNLOAD_FILE_CC = new CommandRequestTypeEnumeration(205, "PrelievoFileCC");
    public static CommandRequestTypeEnumeration LOADCURVE_READING_SPEC = new CommandRequestTypeEnumeration(206, "LetturaCurveDiCaricoSpecifiche");
    public static CommandRequestTypeEnumeration DOWNLOAD_FILE_DQD = new CommandRequestTypeEnumeration(207, "PrelievoParsingFileDQD");
    public static CommandRequestTypeEnumeration SETTING_PRODUCTION_LOADCURVES = new CommandRequestTypeEnumeration(208, "SettingProductionLoadCurves");
    public static CommandRequestTypeEnumeration RESET_LENNTS_LIST = new CommandRequestTypeEnumeration(209, "ReqGAP");
    

    private final int id;
    private final String name;
    private Class implementingClass;

    private CommandRequestTypeEnumeration(int id, String name) {
        this.id = id;
        this.name = name;
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

    public int getId() {
        return id;
    }
}
