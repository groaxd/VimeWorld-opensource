package net.minecraft.block;

import com.google.common.collect.UnmodifiableIterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockPurpurSlab.Double;
import net.minecraft.block.BlockPurpurSlab.Half;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraft.util.RegistryNamespacedDefaultedByKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.xtrafrancyz.covered.ObfValue;

public class Block
{
    private static final ObfValue.OInteger OBFVAL_mQryS = ObfValue.create(148);
    private static final ObfValue.OInteger OBFVAL_o6jpm = ObfValue.create(79);
    private static final ObfValue.OInteger OBFVAL_kW5FV = ObfValue.create(193);
    private static final ObfValue.OInteger OBFVAL_kvURx = ObfValue.create(213);
    private static final ObfValue.OInteger OBFVAL_OTDzq = ObfValue.create(70);
    private static final ObfValue.OInteger OBFVAL_2eA85 = ObfValue.create(18);
    private static final ObfValue.OInteger OBFVAL_jo4tY = ObfValue.create(140);
    private static final ObfValue.OInteger OBFVAL_gudaO = ObfValue.create(142);
    private static final ObfValue.OInteger OBFVAL_hsSjj = ObfValue.create(131);
    private static final ObfValue.OInteger OBFVAL_O9zVc = ObfValue.create(181);
    private static final ObfValue.OInteger OBFVAL_8RmF2 = ObfValue.create(209);
    private static final ObfValue.OInteger OBFVAL_wIHx6 = ObfValue.create(136);
    private static final ObfValue.OInteger OBFVAL_nGadT = ObfValue.create(74);
    private static final ObfValue.OInteger OBFVAL_P10fg = ObfValue.create(120);
    private static final ObfValue.OFloat OBFVAL_or8MX = ObfValue.create(3.0F);
    private static final ObfValue.OInteger OBFVAL_Wy2rL = ObfValue.create(188);
    private static final ObfValue.OInteger OBFVAL_o77fs = ObfValue.create(121);
    private static final ObfValue.OInteger OBFVAL_RPwb6 = ObfValue.create(29);
    private static final ObfValue.OFloat OBFVAL_oXdtp = ObfValue.create(6000000.0F);
    private static final ObfValue.OInteger OBFVAL_Sg8fQ = ObfValue.create(108);
    private static final ObfValue.OInteger OBFVAL_NQVUO = ObfValue.create(31);
    private static final ObfValue.OInteger OBFVAL_nYPEX = ObfValue.create(26);
    private static final ObfValue.OInteger OBFVAL_uZF2p = ObfValue.create(156);
    private static final ObfValue.OInteger OBFVAL_DoRta = ObfValue.create(35);
    private static final ObfValue.OInteger OBFVAL_u8woQ = ObfValue.create(197);
    private static final ObfValue.OInteger OBFVAL_oF6Sb = ObfValue.create(73);
    private static final ObfValue.OFloat OBFVAL_q5RFN = ObfValue.create(15.0F);
    private static final ObfValue.OInteger OBFVAL_pHgIr = ObfValue.create(178);
    private static final ObfValue.OInteger OBFVAL_lj9XZ = ObfValue.create(161);
    private static final ObfValue.OFloat OBFVAL_4s7YX = ObfValue.create(1.25F);
    private static final ObfValue.OFloat OBFVAL_RFMBt = ObfValue.create(0.2F);
    private static final ObfValue.OInteger OBFVAL_6DSOO = ObfValue.create(10);
    private static final ObfValue.OInteger OBFVAL_cawGG = ObfValue.create(105);
    private static final ObfValue.OInteger OBFVAL_XGnIS = ObfValue.create(69);
    private static final ObfValue.OInteger OBFVAL_M5wHX = ObfValue.create(215);
    private static final ObfValue.OInteger OBFVAL_iof3K = ObfValue.create(87);
    private static final ObfValue.OInteger OBFVAL_AEuoa = ObfValue.create(150);
    private static final ObfValue.OInteger OBFVAL_o5Wk6 = ObfValue.create(2);
    private static final ObfValue.OInteger OBFVAL_rtLir = ObfValue.create(21);
    private static final ObfValue.OInteger OBFVAL_Wvrlf = ObfValue.create(103);
    private static final ObfValue.OFloat OBFVAL_SoR5h = ObfValue.create(50.0F);
    private static final ObfValue.OInteger OBFVAL_TC27g = ObfValue.create(141);
    private static final ObfValue.OInteger OBFVAL_gIpO9 = ObfValue.create(6);
    private static final ObfValue.OInteger OBFVAL_i5H42 = ObfValue.create(61);
    private static final ObfValue.OInteger OBFVAL_u6uEp = ObfValue.create(98);
    private static final ObfValue.OInteger OBFVAL_94ctO = ObfValue.create(115);
    private static final ObfValue.OInteger OBFVAL_4c9O2 = ObfValue.create(4);
    private static final ObfValue.OInteger OBFVAL_BzSIK = ObfValue.create(205);
    private static final ObfValue.OInteger OBFVAL_dmnrb = ObfValue.create(210);
    private static final ObfValue.OInteger OBFVAL_q7xP0 = ObfValue.create(187);
    private static final ObfValue.OInteger OBFVAL_ke5nm = ObfValue.create(252);
    private static final ObfValue.OInteger OBFVAL_RtCNA = ObfValue.create(195);
    private static final ObfValue.OInteger OBFVAL_APWW3 = ObfValue.create(62);
    private static final ObfValue.OFloat OBFVAL_rXgVE = ObfValue.create(8.0F);
    private static final ObfValue.OInteger OBFVAL_0U97O = ObfValue.create(85);
    private static final ObfValue.OInteger OBFVAL_eek1P = ObfValue.create(89);
    private static final ObfValue.OInteger OBFVAL_diisJ = ObfValue.create(135);
    private static final ObfValue.OInteger OBFVAL_saXcy = ObfValue.create(154);
    private static final ObfValue.OInteger OBFVAL_q4LXA = ObfValue.create(158);
    private static final ObfValue.OInteger OBFVAL_1cjDF = ObfValue.create(184);
    private static final ObfValue.OInteger OBFVAL_vOuyh = ObfValue.create(160);
    private static final ObfValue.OInteger OBFVAL_EU3fZ = ObfValue.create(34);
    private static final ObfValue.OInteger OBFVAL_adJYd = ObfValue.create(84);
    private static final ObfValue.OInteger OBFVAL_NJPb8 = ObfValue.create(40);
    private static final ObfValue.OInteger OBFVAL_r3d9r = ObfValue.create(72);
    private static final ObfValue.OInteger OBFVAL_1yQcY = ObfValue.create(99);
    private static final ObfValue.OInteger OBFVAL_AzSfF = ObfValue.create(49);
    private static final ObfValue.OFloat OBFVAL_rRAWg = ObfValue.create(0.875F);
    private static final ObfValue.OInteger OBFVAL_uvVMq = ObfValue.create(198);
    private static final ObfValue.OFloat OBFVAL_8xbAu = ObfValue.create(5.0F);
    private static final ObfValue.OInteger OBFVAL_IChpP = ObfValue.create(43);
    private static final ObfValue.OInteger OBFVAL_hxDZt = ObfValue.create(182);
    private static final ObfValue.OInteger OBFVAL_E7cLf = ObfValue.create(15);
    private static final ObfValue.OInteger OBFVAL_rjsbR = ObfValue.create(102);
    private static final ObfValue.OInteger OBFVAL_jA1B4 = ObfValue.create(203);
    private static final ObfValue.OInteger OBFVAL_s8DV9 = ObfValue.create(76);
    private static final ObfValue.OInteger OBFVAL_5wfqF = ObfValue.create(44);
    private static final ObfValue.OInteger OBFVAL_AAcos = ObfValue.create(189);
    private static final ObfValue.OInteger OBFVAL_rsNw9 = ObfValue.create(170);
    private static final ObfValue.OFloat OBFVAL_yhHDR = ObfValue.create(22.5F);
    private static final ObfValue.OFloat OBFVAL_zVyA8 = ObfValue.create(0.9375F);
    private static final ObfValue.OInteger OBFVAL_dfnGn = ObfValue.create(58);
    private static final ObfValue.OInteger OBFVAL_NkzVf = ObfValue.create(199);
    private static final ObfValue.OInteger OBFVAL_NZDF8 = ObfValue.create(4095);
    private static final ObfValue.OInteger OBFVAL_VQcij = ObfValue.create(139);
    private static final ObfValue.OFloat OBFVAL_kqOXU = ObfValue.create(1000.0F);
    private static final ObfValue.OInteger OBFVAL_cpCPc = ObfValue.create(20);
    private static final ObfValue.OInteger OBFVAL_AEKbD = ObfValue.create(174);
    private static final ObfValue.OInteger OBFVAL_vf6HI = ObfValue.create(138);
    private static final ObfValue.OInteger OBFVAL_mkX0j = ObfValue.create(129);
    private static final ObfValue.OInteger OBFVAL_XB94V = ObfValue.create(68);
    private static final ObfValue.OInteger OBFVAL_n1Fmm = ObfValue.create(192);
    private static final ObfValue.OInteger OBFVAL_HOBnQ = ObfValue.create(52);
    private static final ObfValue.OInteger OBFVAL_e4aLF = ObfValue.create(180);
    private static final ObfValue.OInteger OBFVAL_VCWXh = ObfValue.create(67);
    private static final ObfValue.OInteger OBFVAL_A4av9 = ObfValue.create(177);
    private static final ObfValue.OInteger OBFVAL_mS7mJ = ObfValue.create(45);
    private static final ObfValue.OInteger OBFVAL_UFqyx = ObfValue.create(47);
    private static final ObfValue.OFloat OBFVAL_C6v4N = ObfValue.create(2000.0F);
    private static final ObfValue.OInteger OBFVAL_aMstD = ObfValue.create(37);
    private static final ObfValue.OInteger OBFVAL_LHgbq = ObfValue.create(75);
    private static final ObfValue.OInteger OBFVAL_cpezq = ObfValue.create(19);
    private static final ObfValue.OInteger OBFVAL_PB8De = ObfValue.create(55);
    private static final ObfValue.OInteger OBFVAL_xGwLQ = ObfValue.create(88);
    private static final ObfValue.OFloat OBFVAL_1gyv4 = ObfValue.create(2.5F);
    private static final ObfValue.OInteger OBFVAL_nMzhU = ObfValue.create(22);
    private static final ObfValue.OInteger OBFVAL_eix3f = ObfValue.create(145);
    private static final ObfValue.OInteger OBFVAL_VeNBX = ObfValue.create(194);
    private static final ObfValue.OFloat OBFVAL_ZDwDf = ObfValue.create(7.0F);
    private static final ObfValue.OInteger OBFVAL_D8Gng = ObfValue.create(81);
    private static final ObfValue.OInteger OBFVAL_k3abz = ObfValue.create(123);
    private static final ObfValue.OInteger OBFVAL_tgr0M = ObfValue.create(151);
    private static final ObfValue.OInteger OBFVAL_u8oq8 = ObfValue.create(42);
    private static final ObfValue.OInteger OBFVAL_kQJFr = ObfValue.create(78);
    private static final ObfValue.OInteger OBFVAL_QHptm = ObfValue.create(36);
    private static final ObfValue.OInteger OBFVAL_1mayK = ObfValue.create(171);
    private static final ObfValue.OInteger OBFVAL_svvZQ = ObfValue.create(153);
    private static final ObfValue.OFloat OBFVAL_yQHSx = ObfValue.create(0.025F);
    private static final ObfValue.OInteger OBFVAL_i3YvG = ObfValue.create(86);
    private static final ObfValue.OInteger OBFVAL_wWGmo = ObfValue.create(13);
    private static final ObfValue.OInteger OBFVAL_0T8Gq = ObfValue.create(59);
    private static final ObfValue.OInteger OBFVAL_FxvPm = ObfValue.create(23);
    private static final ObfValue.OInteger OBFVAL_G0aMT = ObfValue.create(143);
    private static final ObfValue.OInteger OBFVAL_xY1LM = ObfValue.create(7);
    private static final ObfValue.OFloat OBFVAL_zazbG = ObfValue.create(0.4F);
    private static final ObfValue.OInteger OBFVAL_JKO6F = ObfValue.create(165);
    private static final ObfValue.OInteger OBFVAL_pTauQ = ObfValue.create(64);
    private static final ObfValue.OFloat OBFVAL_7bMZQ = ObfValue.create(0.8F);
    private static final ObfValue.OFloat OBFVAL_3FPHx = ObfValue.create(0.7F);
    private static final ObfValue.OInteger OBFVAL_dK2FR = ObfValue.create(11);
    private static final ObfValue.OInteger OBFVAL_4Hsni = ObfValue.create(106);
    private static final ObfValue.OInteger OBFVAL_ddoIU = ObfValue.create(95);
    private static final ObfValue.OInteger OBFVAL_Pqfgp = ObfValue.create(117);
    private static final ObfValue.OInteger OBFVAL_H0F8U = ObfValue.create(28);
    private static final ObfValue.OInteger OBFVAL_MDuNJ = ObfValue.create(57);
    private static final ObfValue.OInteger OBFVAL_rgTA3 = ObfValue.create(41);
    private static final ObfValue.OInteger OBFVAL_MQFZ0 = ObfValue.create(60);
    private static final ObfValue.OInteger OBFVAL_hJwzS = ObfValue.create(109);
    private static final ObfValue.OInteger OBFVAL_22Ica = ObfValue.create(30);
    private static final ObfValue.OInteger OBFVAL_P9s9x = ObfValue.create(206);
    private static final ObfValue.OInteger OBFVAL_zLUn7 = ObfValue.create(65);
    private static final ObfValue.OInteger OBFVAL_jYqZZ = ObfValue.create(48);
    private static final ObfValue.OInteger OBFVAL_6NWbo = ObfValue.create(82);
    private static final ObfValue.OInteger OBFVAL_h5xku = ObfValue.create(14);
    private static final ObfValue.OInteger OBFVAL_sCJ2j = ObfValue.create(16777215);
    private static final ObfValue.OInteger OBFVAL_w7Bnp = ObfValue.create(107);
    private static final ObfValue.OInteger OBFVAL_k2cWJ = ObfValue.create(179);
    private static final ObfValue.OFloat OBFVAL_aCRDC = ObfValue.create(0.125F);
    private static final ObfValue.OInteger OBFVAL_hRvs6 = ObfValue.create(50);
    private static final ObfValue.OInteger OBFVAL_ud4A5 = ObfValue.create(147);
    private static final ObfValue.OInteger OBFVAL_fwgpo = ObfValue.create(172);
    private static final ObfValue.OInteger OBFVAL_i17I5 = ObfValue.create(63);
    private static final ObfValue.OInteger OBFVAL_ca1S4 = ObfValue.create(168);
    private static final ObfValue.OInteger OBFVAL_8JSp0 = ObfValue.create(91);
    private static final ObfValue.OInteger OBFVAL_SQKk2 = ObfValue.create(255);
    private static final ObfValue.OInteger OBFVAL_UdQh1 = ObfValue.create(164);
    private static final ObfValue.OInteger OBFVAL_X5XXK = ObfValue.create(100);
    private static final ObfValue.OInteger OBFVAL_sBy9Q = ObfValue.create(127);
    private static final ObfValue.OInteger OBFVAL_HkJZ0 = ObfValue.create(90);
    private static final ObfValue.OInteger OBFVAL_Jxnr8 = ObfValue.create(122);
    private static final ObfValue.OInteger OBFVAL_u8ATv = ObfValue.create(251);
    private static final ObfValue.OInteger OBFVAL_U08LS = ObfValue.create(204);
    private static final ObfValue.OInteger OBFVAL_60ATn = ObfValue.create(146);
    private static final ObfValue.OInteger OBFVAL_TO3Ig = ObfValue.create(5);
    private static final ObfValue.OInteger OBFVAL_YyRiw = ObfValue.create(130);
    private static final ObfValue.OFloat OBFVAL_r8lga = ObfValue.create(2.0F);
    private static final ObfValue.OInteger OBFVAL_ZeUFn = ObfValue.create(186);
    private static final ObfValue.OInteger OBFVAL_cofeu = ObfValue.create(132);
    private static final ObfValue.OInteger OBFVAL_cN4Xf = ObfValue.create(54);
    private static final ObfValue.OInteger OBFVAL_AnXWS = ObfValue.create(16);
    private static final ObfValue.OInteger OBFVAL_yy0fS = ObfValue.create(202);
    private static final ObfValue.OInteger OBFVAL_yQFOJ = ObfValue.create(173);
    private static final ObfValue.OFloat OBFVAL_4Fwyg = ObfValue.create(0.3F);
    private static final ObfValue.OInteger OBFVAL_2B6SI = ObfValue.create(96);
    private static final ObfValue.OFloat OBFVAL_hvUHW = ObfValue.create(0.625F);
    private static final ObfValue.OInteger OBFVAL_zkQRd = ObfValue.create(167);
    private static final ObfValue.OInteger OBFVAL_NfEhk = ObfValue.create(9);
    private static final ObfValue.OFloat OBFVAL_xQdrf = ObfValue.create(0.6F);
    private static final ObfValue.OInteger OBFVAL_lNHop = ObfValue.create(24);
    private static final ObfValue.OInteger OBFVAL_1VqQ6 = ObfValue.create(46);
    private static final ObfValue.OInteger OBFVAL_WlT0h = ObfValue.create(39);
    private static final ObfValue.OInteger OBFVAL_pGFJt = ObfValue.create(176);
    private static final ObfValue.OInteger OBFVAL_j5mj6 = ObfValue.create(92);
    private static final ObfValue.OInteger OBFVAL_je5Vu = ObfValue.create(254);
    private static final ObfValue.OFloat OBFVAL_XA42p = ObfValue.create(1.8F);
    private static final ObfValue.OInteger OBFVAL_k1I4w = ObfValue.create(93);
    private static final ObfValue.OInteger OBFVAL_rpQaX = ObfValue.create(125);
    private static final ObfValue.OInteger OBFVAL_tCl1J = ObfValue.create(97);
    private static final ObfValue.OInteger OBFVAL_ia7w3 = ObfValue.create(118);
    private static final ObfValue.OInteger OBFVAL_uIJqM = ObfValue.create(66);
    private static final ObfValue.ODouble OBFVAL_73oLW = ObfValue.create(0.5D);
    private static final ObfValue.OInteger OBFVAL_3njA7 = ObfValue.create(80);
    private static final ObfValue.OInteger OBFVAL_hJxDM = ObfValue.create(191);
    private static final ObfValue.OFloat OBFVAL_uJjeM = ObfValue.create(30.0F);
    private static final ObfValue.OInteger OBFVAL_2xO2o = ObfValue.create(38);
    private static final ObfValue.OInteger OBFVAL_yI5DB = ObfValue.create(163);
    private static final ObfValue.OInteger OBFVAL_m7FMy = ObfValue.create(201);
    private static final ObfValue.OFloat OBFVAL_QlfWv = ObfValue.create(3.5F);
    private static final ObfValue.OFloat OBFVAL_Js146 = ObfValue.create(10.0F);
    private static final ObfValue.OInteger OBFVAL_FwmwR = ObfValue.create(32);
    private static final ObfValue.OInteger OBFVAL_V5hPv = ObfValue.create(155);
    private static final ObfValue.OInteger OBFVAL_Rg2Ju = ObfValue.create(133);
    private static final ObfValue.OInteger OBFVAL_Wugct = ObfValue.create(3);
    private static final ObfValue.OInteger OBFVAL_U6m7v = ObfValue.create(111);
    private static final ObfValue.OInteger OBFVAL_x0pTx = ObfValue.create(33);
    private static final ObfValue.OInteger OBFVAL_27z2v = ObfValue.create(169);
    private static final ObfValue.OInteger OBFVAL_EkqaN = ObfValue.create(144);
    private static final ObfValue.OInteger OBFVAL_kslgx = ObfValue.create(207);
    private static final ObfValue.OInteger OBFVAL_kvQVz = ObfValue.create(112);
    private static final ObfValue.OInteger OBFVAL_0H9up = ObfValue.create(116);
    private static final ObfValue.OInteger OBFVAL_MVIKb = ObfValue.create(216);
    private static final ObfValue.OFloat OBFVAL_rzB5C = ObfValue.create(1.5F);
    private static final ObfValue.OFloat OBFVAL_hgPDu = ObfValue.create(0.75F);
    private static final ObfValue.OInteger OBFVAL_W42Ee = ObfValue.create(25);
    private static final ObfValue.OInteger OBFVAL_gzsrP = ObfValue.create(114);
    private static final ObfValue.OFloat OBFVAL_cfaOS = ObfValue.create(100.0F);
    private static final ObfValue.OInteger OBFVAL_ecTvc = ObfValue.create(183);
    private static final ObfValue.OInteger OBFVAL_MxSJ4 = ObfValue.create(110);
    private static final ObfValue.OInteger OBFVAL_7vbRk = ObfValue.create(159);
    private static final ObfValue.OInteger OBFVAL_FpbCQ = ObfValue.create(51);
    private static final ObfValue.OFloat OBFVAL_f3rzJ = ObfValue.create(0.1F);
    private static final ObfValue.OInteger OBFVAL_9DUgn = ObfValue.create(104);
    private static final ObfValue.OInteger OBFVAL_kXlcB = ObfValue.create(119);
    private static final ObfValue.OInteger OBFVAL_Hq4g0 = ObfValue.create(137);
    private static final ObfValue.OInteger OBFVAL_rTGHg = ObfValue.create(162);
    private static final ObfValue.OInteger OBFVAL_1LUyW = ObfValue.create(27);
    private static final ObfValue.OFloat OBFVAL_OnmQT = ObfValue.create(0.5F);
    private static final ObfValue.OInteger OBFVAL_BXxjG = ObfValue.create(71);
    private static final ObfValue.OInteger OBFVAL_fA2PO = ObfValue.create(214);
    private static final ObfValue.OInteger OBFVAL_o3jlP = ObfValue.create(149);
    private static final ObfValue.OFloat OBFVAL_6dz9u = ObfValue.create(-1.0F);
    private static final ObfValue.OInteger OBFVAL_ERWKE = ObfValue.create(208);
    private static final ObfValue.OInteger OBFVAL_sUwhL = ObfValue.create(8);
    private static final ObfValue.OInteger OBFVAL_hZBVK = ObfValue.create(83);
    private static final ObfValue.OInteger OBFVAL_KWv8Y = ObfValue.create(175);
    private static final ObfValue.OInteger OBFVAL_RcVxv = ObfValue.create(53);
    private static final ObfValue.OInteger OBFVAL_zsQUa = ObfValue.create(17);
    private static final ObfValue.OInteger OBFVAL_cba4O = ObfValue.create(166);
    private static final ObfValue.OInteger OBFVAL_zjPhZ = ObfValue.create(190);
    private static final ObfValue.OInteger OBFVAL_vYvEY = ObfValue.create(152);
    private static final ObfValue.OInteger OBFVAL_QBRmQ = ObfValue.create(77);
    private static final ObfValue.OInteger OBFVAL_EDBrb = ObfValue.create(94);
    private static final ObfValue.OInteger OBFVAL_6GKfI = ObfValue.create(126);
    private static final ObfValue.OInteger OBFVAL_HP3hQ = ObfValue.create(128);
    private static final ObfValue.OInteger OBFVAL_W0m1f = ObfValue.create(101);
    private static final ObfValue.OFloat OBFVAL_Ca3Ja = ObfValue.create(4.0F);
    private static final ObfValue.OInteger OBFVAL_V22Sn = ObfValue.create(124);
    private static final ObfValue.OInteger OBFVAL_1LTDR = ObfValue.create(157);
    private static final ObfValue.OInteger OBFVAL_dgAOe = ObfValue.create(12);
    private static final ObfValue.OInteger OBFVAL_nbNgU = ObfValue.create(56);
    private static final ObfValue.OInteger OBFVAL_sjdDY = ObfValue.create(134);
    private static final ObfValue.OInteger OBFVAL_5eJ8l = ObfValue.create(113);
    private static final ObfValue.OInteger OBFVAL_wnNPL = ObfValue.create(196);
    private static final ObfValue.OInteger OBFVAL_UQ9QH = ObfValue.create(185);

    /** ResourceLocation for the Air block */
    private static final ResourceLocation AIR_ID = new ResourceLocation("air");
    public static final RegistryNamespacedDefaultedByKey<ResourceLocation, Block> blockRegistry = new RegistryNamespacedDefaultedByKey(AIR_ID);
    public static final ObjectIntIdentityMap BLOCK_STATE_IDS = new ObjectIntIdentityMap();
    private CreativeTabs displayOnCreativeTab;
    public static final Block.SoundType soundTypeStone = new Block.SoundType("stone", 1.0F, 1.0F);

    /** the wood sound type */
    public static final Block.SoundType soundTypeWood = new Block.SoundType("wood", 1.0F, 1.0F);

    /** the gravel sound type */
    public static final Block.SoundType soundTypeGravel = new Block.SoundType("gravel", 1.0F, 1.0F);
    public static final Block.SoundType soundTypeGrass = new Block.SoundType("grass", 1.0F, 1.0F);
    public static final Block.SoundType soundTypePiston = new Block.SoundType("stone", 1.0F, 1.0F);
    public static final Block.SoundType soundTypeMetal = new Block.SoundType("stone", 1.0F, 1.5F);
    public static final Block.SoundType soundTypeGlass = new Block.SoundType("stone", 1.0F, 1.0F)
    {
        public String getBreakSound()
        {
            return "dig.glass";
        }
        public String getPlaceSound()
        {
            return "step.stone";
        }
    };
    public static final Block.SoundType soundTypeCloth = new Block.SoundType("cloth", 1.0F, 1.0F);
    public static final Block.SoundType soundTypeSand = new Block.SoundType("sand", 1.0F, 1.0F);
    public static final Block.SoundType soundTypeSnow = new Block.SoundType("snow", 1.0F, 1.0F);
    public static final Block.SoundType soundTypeLadder = new Block.SoundType("ladder", 1.0F, 1.0F)
    {
        public String getBreakSound()
        {
            return "dig.wood";
        }
    };
    public static final Block.SoundType soundTypeAnvil = new Block.SoundType("anvil", 0.3F, 1.0F)
    {
        public String getBreakSound()
        {
            return "dig.stone";
        }
        public String getPlaceSound()
        {
            return "random.anvil_land";
        }
    };
    public static final Block.SoundType SLIME_SOUND = new Block.SoundType("slime", 1.0F, 1.0F)
    {
        public String getBreakSound()
        {
            return "mob.slime.big";
        }
        public String getPlaceSound()
        {
            return "mob.slime.big";
        }
        public String getStepSound()
        {
            return "mob.slime.small";
        }
    };
    protected boolean fullBlock;

    /** How much light is subtracted for going through this block */
    protected int lightOpacity;
    protected boolean translucent;

    /** Amount of light emitted */
    protected int lightValue;

    /**
     * Flag if block should use the brightest neighbor light value as its own
     */
    protected boolean useNeighborBrightness;

    /** Indicates how many hits it takes to break a block. */
    protected ObfValue.OFloat blockHardness;

    /** Indicates how much this block can resist explosions */
    protected float blockResistance;
    protected boolean enableStats;

    /**
     * Flags whether or not this block is of a type that needs random ticking. Ref-counted by ExtendedBlockStorage in
     * order to broadly cull a chunk from the random chunk update list for efficiency's sake.
     */
    protected boolean needsRandomTick;

    /** true if the Block contains a Tile Entity */
    protected boolean isBlockContainer;
    protected double minX;
    protected double minY;
    protected double minZ;
    protected double maxX;
    protected double maxY;
    protected double maxZ;

    /** Sound of stepping on the block */
    public Block.SoundType stepSound;
    public float blockParticleGravity;
    protected final Material blockMaterial;
    protected final MapColor field_181083_K;

    /**
     * Determines how much velocity is maintained while moving on top of this block
     */
    public ObfValue.OFloat slipperiness;
    protected final BlockState blockState;
    private IBlockState defaultBlockState;
    private String unlocalizedName;

    public static int getIdFromBlock(Block blockIn)
    {
        return blockRegistry.getIDForObject(blockIn);
    }

    /**
     * Get a unique ID for the given BlockState, containing both BlockID and metadata
     */
    public static int getStateId(IBlockState state)
    {
        Block block = state.getBlock();
        return getIdFromBlock(block) + (block.getMetaFromState(state) << OBFVAL_dgAOe.get());
    }

    public static Block getBlockById(int id)
    {
        return (Block)blockRegistry.getObjectById(id);
    }

    /**
     * Get a BlockState by it's ID (see getStateId)
     */
    public static IBlockState getStateById(int id)
    {
        int i = id & OBFVAL_NZDF8.get();
        int j = id >> OBFVAL_dgAOe.get() & OBFVAL_E7cLf.get();
        return getBlockById(i).getStateFromMeta(j);
    }

    public static Block getBlockFromItem(Item itemIn)
    {
        return itemIn instanceof ItemBlock ? ((ItemBlock)itemIn).getBlock() : null;
    }

    public static Block getBlockFromName(String name)
    {
        ResourceLocation resourcelocation = new ResourceLocation(name);

        if (blockRegistry.containsKey(resourcelocation))
        {
            return (Block)blockRegistry.getObject(resourcelocation);
        }
        else
        {
            try
            {
                return (Block)blockRegistry.getObjectById(Integer.parseInt(name));
            }
            catch (NumberFormatException var3)
            {
                return null;
            }
        }
    }

    public boolean isFullBlock()
    {
        return this.fullBlock;
    }

    public int getLightOpacity()
    {
        return this.lightOpacity;
    }

    /**
     * Used in the renderer to apply ambient occlusion
     */
    public boolean isTranslucent()
    {
        return this.translucent;
    }

    public int getLightValue()
    {
        return this.lightValue;
    }

    /**
     * Should block use the brightest neighbor light value as its own
     */
    public boolean getUseNeighborBrightness()
    {
        return this.useNeighborBrightness;
    }

    /**
     * Get a material of block
     */
    public Material getMaterial()
    {
        return this.blockMaterial;
    }

    /**
     * Get the MapColor for this Block and the given BlockState
     */
    public MapColor getMapColor(IBlockState state)
    {
        return this.field_181083_K;
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState();
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        if (state != null && !state.getPropertyNames().isEmpty())
        {
            throw new IllegalArgumentException("Don\'t know how to convert " + state + " back into data...");
        }
        else
        {
            return 0;
        }
    }

    /**
     * Get the actual Block state of this Block at the given position. This applies properties not visible in the
     * metadata, such as fence connections.
     */
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state;
    }

    public Block(Material p_i46399_1_, MapColor p_i46399_2_)
    {
        this.blockHardness = 0.0F.new OFloat();
        this.slipperiness = 0.0F.new OFloat();
        this.enableStats = true;
        this.stepSound = soundTypeStone;
        this.blockParticleGravity = 1.0F;
        this.slipperiness.set(OBFVAL_xQdrf.get());
        this.blockMaterial = p_i46399_1_;
        this.field_181083_K = p_i46399_2_;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        this.fullBlock = this.isOpaqueCube();
        this.lightOpacity = this.isOpaqueCube() ? OBFVAL_SQKk2.get() : 0;
        this.translucent = !p_i46399_1_.blocksLight();
        this.blockState = this.createBlockState();
        this.setDefaultState(this.blockState.getBaseState());
    }

    protected Block(Material materialIn)
    {
        this(materialIn, materialIn.getMaterialMapColor());
    }

    /**
     * Sets the footstep sound for the block. Returns the object for convenience in constructing.
     */
    protected Block setStepSound(Block.SoundType sound)
    {
        this.stepSound = sound;
        return this;
    }

    /**
     * Sets how much light is blocked going through this block. Returns the object for convenience in constructing.
     */
    protected Block setLightOpacity(int opacity)
    {
        this.lightOpacity = opacity;
        return this;
    }

    /**
     * Sets the light value that the block emits. Returns resulting block instance for constructing convenience. Args:
     * level
     */
    protected Block setLightLevel(float value)
    {
        this.lightValue = (int)(OBFVAL_q5RFN.get() * value);
        return this;
    }

    /**
     * Sets the the blocks resistance to explosions. Returns the object for convenience in constructing.
     */
    protected Block setResistance(float resistance)
    {
        this.blockResistance = resistance * OBFVAL_or8MX.get();
        return this;
    }

    /**
     * Indicate if a material is a normal solid opaque cube
     */
    public boolean isBlockNormalCube()
    {
        return this.blockMaterial.blocksMovement() && this.isFullCube();
    }

    /**
     * Used for nearly all game logic (non-rendering) purposes. Use Forge-provided isNormalCube(IBlockAccess, BlockPos)
     * instead.
     */
    public boolean isNormalCube()
    {
        return this.blockMaterial.isOpaque() && this.isFullCube() && !this.canProvidePower();
    }

    public boolean isVisuallyOpaque()
    {
        return this.blockMaterial.blocksMovement() && this.isFullCube();
    }

    public boolean isFullCube()
    {
        return true;
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return !this.blockMaterial.blocksMovement();
    }

    /**
     * The type of render function called. 3 for standard block models, 2 for TESR's, 1 for liquids, -1 is no render
     */
    public int getRenderType()
    {
        return OBFVAL_Wugct.get();
    }

    /**
     * Whether this Block can be replaced directly by other blocks (true for e.g. tall grass)
     */
    public boolean isReplaceable(World worldIn, BlockPos pos)
    {
        return false;
    }

    /**
     * Sets how many hits it takes to break a block.
     */
    protected Block setHardness(float hardness)
    {
        this.blockHardness.set(hardness);

        if (this.blockResistance < hardness * OBFVAL_8xbAu.get())
        {
            this.blockResistance = hardness * OBFVAL_8xbAu.get();
        }

        return this;
    }

    protected Block setBlockUnbreakable()
    {
        this.setHardness(OBFVAL_6dz9u.get());
        return this;
    }

    public float getBlockHardness(World worldIn, BlockPos pos)
    {
        return this.blockHardness.get();
    }

    /**
     * Sets whether this block type will receive random update ticks
     */
    protected Block setTickRandomly(boolean shouldTick)
    {
        this.needsRandomTick = shouldTick;
        return this;
    }

    /**
     * Returns whether or not this block is of a type that needs random ticking. Called for ref-counting purposes by
     * ExtendedBlockStorage in order to broadly cull a chunk from the random chunk update list for efficiency's sake.
     */
    public boolean getTickRandomly()
    {
        return this.needsRandomTick;
    }

    public boolean hasTileEntity()
    {
        return this.isBlockContainer;
    }

    protected final void setBlockBounds(float minX, float minY, float minZ, float maxX, float maxY, float maxZ)
    {
        this.minX = (double)minX;
        this.minY = (double)minY;
        this.minZ = (double)minZ;
        this.maxX = (double)maxX;
        this.maxY = (double)maxY;
        this.maxZ = (double)maxZ;
    }

    public int getMixedBrightnessForBlock(IBlockAccess worldIn, BlockPos pos)
    {
        Block block = worldIn.getBlockState(pos).getBlock();
        int i = worldIn.getCombinedLight(pos, block.getLightValue());

        if (i == 0 && block instanceof BlockSlab)
        {
            pos = pos.down();
            block = worldIn.getBlockState(pos).getBlock();
            return worldIn.getCombinedLight(pos, block.getLightValue());
        }
        else
        {
            return i;
        }
    }

    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return side == EnumFacing.DOWN && this.minY > 0.0D ? true : (side == EnumFacing.UP && this.maxY < 1.0D ? true : (side == EnumFacing.NORTH && this.minZ > 0.0D ? true : (side == EnumFacing.SOUTH && this.maxZ < 1.0D ? true : (side == EnumFacing.WEST && this.minX > 0.0D ? true : (side == EnumFacing.EAST && this.maxX < 1.0D ? true : !worldIn.getBlockState(pos).getBlock().isOpaqueCube())))));
    }

    /**
     * Whether this Block is solid on the given Side
     */
    public boolean isBlockSolid(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return worldIn.getBlockState(pos).getBlock().getMaterial().isSolid();
    }

    public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos)
    {
        return new AxisAlignedBB((double)pos.getX() + this.minX, (double)pos.getY() + this.minY, (double)pos.getZ() + this.minZ, (double)pos.getX() + this.maxX, (double)pos.getY() + this.maxY, (double)pos.getZ() + this.maxZ);
    }

    /**
     * Add all collision boxes of this Block to the list that intersect with the given mask.
     */
    public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity collidingEntity)
    {
        AxisAlignedBB axisalignedbb = this.getCollisionBoundingBox(worldIn, pos, state);

        if (axisalignedbb != null && mask.intersectsWith(axisalignedbb))
        {
            list.add(axisalignedbb);
        }
    }

    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return new AxisAlignedBB((double)pos.getX() + this.minX, (double)pos.getY() + this.minY, (double)pos.getZ() + this.minZ, (double)pos.getX() + this.maxX, (double)pos.getY() + this.maxY, (double)pos.getZ() + this.maxZ);
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube()
    {
        return true;
    }

    public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid)
    {
        return this.isCollidable();
    }

    /**
     * Returns if this block is collidable (only used by Fire). Args: x, y, z
     */
    public boolean isCollidable()
    {
        return true;
    }

    /**
     * Called randomly when setTickRandomly is set to true (used by e.g. crops to grow, etc.)
     */
    public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random)
    {
        this.updateTick(worldIn, pos, state, random);
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    }

    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    }

    /**
     * Called when a player destroys this Block
     */
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state)
    {
    }

    /**
     * Called when a neighboring block changes.
     */
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
    }

    /**
     * How many world ticks before ticking
     */
    public int tickRate(World worldIn)
    {
        return OBFVAL_6DSOO.get();
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
    }

    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 1;
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    /**
     * Get the hardness of this Block relative to the ability of the given player
     */
    public float getPlayerRelativeBlockHardness(EntityPlayer playerIn, World worldIn, BlockPos pos)
    {
        float f = this.getBlockHardness(worldIn, pos);
        return f < 0.0F ? 0.0F : (!playerIn.canHarvestBlock(this) ? playerIn.getToolDigEfficiency(this) / f / OBFVAL_cfaOS.get() : playerIn.getToolDigEfficiency(this) / f / OBFVAL_uJjeM.get());
    }

    /**
     * Spawn this Block's drops into the World as EntityItems
     */
    public final void dropBlockAsItem(World worldIn, BlockPos pos, IBlockState state, int forture)
    {
        this.dropBlockAsItemWithChance(worldIn, pos, state, 1.0F, forture);
    }

    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        if (!worldIn.isRemote)
        {
            int i = this.quantityDroppedWithBonus(fortune, worldIn.rand);

            for (int j = 0; j < i; ++j)
            {
                if (worldIn.rand.nextFloat() <= chance)
                {
                    Item item = this.getItemDropped(state, worldIn.rand, fortune);

                    if (item != null)
                    {
                        spawnAsEntity(worldIn, pos, new ItemStack(item, 1, this.damageDropped(state)));
                    }
                }
            }
        }
    }

    /**
     * Spawns the given ItemStack as an EntityItem into the World at the given position
     */
    public static void spawnAsEntity(World worldIn, BlockPos pos, ItemStack stack)
    {
        if (!worldIn.isRemote && worldIn.getGameRules().getBoolean("doTileDrops"))
        {
            float f = OBFVAL_OnmQT.get();
            double d0 = (double)(worldIn.rand.nextFloat() * f) + (double)(1.0F - f) * OBFVAL_73oLW.get();
            double d1 = (double)(worldIn.rand.nextFloat() * f) + (double)(1.0F - f) * OBFVAL_73oLW.get();
            double d2 = (double)(worldIn.rand.nextFloat() * f) + (double)(1.0F - f) * OBFVAL_73oLW.get();
            EntityItem entityitem = new EntityItem(worldIn, (double)pos.getX() + d0, (double)pos.getY() + d1, (double)pos.getZ() + d2, stack);
            entityitem.setDefaultPickupDelay();
            worldIn.spawnEntityInWorld(entityitem);
        }
    }

    /**
     * Spawns the given amount of experience into the World as XP orb entities
     */
    protected void dropXpOnBlockBreak(World worldIn, BlockPos pos, int amount)
    {
        if (!worldIn.isRemote)
        {
            while (amount > 0)
            {
                int i = EntityXPOrb.getXPSplit(amount);
                amount -= i;
                worldIn.spawnEntityInWorld(new EntityXPOrb(worldIn, (double)pos.getX() + OBFVAL_73oLW.get(), (double)pos.getY() + OBFVAL_73oLW.get(), (double)pos.getZ() + OBFVAL_73oLW.get(), i));
            }
        }
    }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state)
    {
        return 0;
    }

    /**
     * Returns how much this block can resist explosions from the passed in entity.
     */
    public float getExplosionResistance(Entity exploder)
    {
        return this.blockResistance / OBFVAL_8xbAu.get();
    }

    /**
     * Ray traces through the blocks collision from start vector to end vector returning a ray trace hit.
     */
    public MovingObjectPosition collisionRayTrace(World worldIn, BlockPos pos, Vec3 start, Vec3 end)
    {
        this.setBlockBoundsBasedOnState(worldIn, pos);
        start = start.addVector((double)(-pos.getX()), (double)(-pos.getY()), (double)(-pos.getZ()));
        end = end.addVector((double)(-pos.getX()), (double)(-pos.getY()), (double)(-pos.getZ()));
        Vec3 vec3 = start.getIntermediateWithXValue(end, this.minX);
        Vec3 vec31 = start.getIntermediateWithXValue(end, this.maxX);
        Vec3 vec32 = start.getIntermediateWithYValue(end, this.minY);
        Vec3 vec33 = start.getIntermediateWithYValue(end, this.maxY);
        Vec3 vec34 = start.getIntermediateWithZValue(end, this.minZ);
        Vec3 vec35 = start.getIntermediateWithZValue(end, this.maxZ);

        if (!this.isVecInsideYZBounds(vec3))
        {
            vec3 = null;
        }

        if (!this.isVecInsideYZBounds(vec31))
        {
            vec31 = null;
        }

        if (!this.isVecInsideXZBounds(vec32))
        {
            vec32 = null;
        }

        if (!this.isVecInsideXZBounds(vec33))
        {
            vec33 = null;
        }

        if (!this.isVecInsideXYBounds(vec34))
        {
            vec34 = null;
        }

        if (!this.isVecInsideXYBounds(vec35))
        {
            vec35 = null;
        }

        Vec3 vec36 = null;

        if (vec3 != null && (vec36 == null || start.squareDistanceTo(vec3) < start.squareDistanceTo(vec36)))
        {
            vec36 = vec3;
        }

        if (vec31 != null && (vec36 == null || start.squareDistanceTo(vec31) < start.squareDistanceTo(vec36)))
        {
            vec36 = vec31;
        }

        if (vec32 != null && (vec36 == null || start.squareDistanceTo(vec32) < start.squareDistanceTo(vec36)))
        {
            vec36 = vec32;
        }

        if (vec33 != null && (vec36 == null || start.squareDistanceTo(vec33) < start.squareDistanceTo(vec36)))
        {
            vec36 = vec33;
        }

        if (vec34 != null && (vec36 == null || start.squareDistanceTo(vec34) < start.squareDistanceTo(vec36)))
        {
            vec36 = vec34;
        }

        if (vec35 != null && (vec36 == null || start.squareDistanceTo(vec35) < start.squareDistanceTo(vec36)))
        {
            vec36 = vec35;
        }

        if (vec36 == null)
        {
            return null;
        }
        else
        {
            EnumFacing enumfacing = null;

            if (vec36 == vec3)
            {
                enumfacing = EnumFacing.WEST;
            }

            if (vec36 == vec31)
            {
                enumfacing = EnumFacing.EAST;
            }

            if (vec36 == vec32)
            {
                enumfacing = EnumFacing.DOWN;
            }

            if (vec36 == vec33)
            {
                enumfacing = EnumFacing.UP;
            }

            if (vec36 == vec34)
            {
                enumfacing = EnumFacing.NORTH;
            }

            if (vec36 == vec35)
            {
                enumfacing = EnumFacing.SOUTH;
            }

            return new MovingObjectPosition(vec36.addVector((double)pos.getX(), (double)pos.getY(), (double)pos.getZ()), enumfacing, pos);
        }
    }

    /**
     * Checks if a vector is within the Y and Z bounds of the block.
     */
    private boolean isVecInsideYZBounds(Vec3 point)
    {
        return point == null ? false : point.yCoord >= this.minY && point.yCoord <= this.maxY && point.zCoord >= this.minZ && point.zCoord <= this.maxZ;
    }

    /**
     * Checks if a vector is within the X and Z bounds of the block.
     */
    private boolean isVecInsideXZBounds(Vec3 point)
    {
        return point == null ? false : point.xCoord >= this.minX && point.xCoord <= this.maxX && point.zCoord >= this.minZ && point.zCoord <= this.maxZ;
    }

    /**
     * Checks if a vector is within the X and Y bounds of the block.
     */
    private boolean isVecInsideXYBounds(Vec3 point)
    {
        return point == null ? false : point.xCoord >= this.minX && point.xCoord <= this.maxX && point.yCoord >= this.minY && point.yCoord <= this.maxY;
    }

    /**
     * Called when this Block is destroyed by an Explosion
     */
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn)
    {
    }

    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.SOLID;
    }

    public boolean canReplace(World worldIn, BlockPos pos, EnumFacing side, ItemStack stack)
    {
        return this.canPlaceBlockOnSide(worldIn, pos, side);
    }

    /**
     * Check whether this Block can be placed on the given side
     */
    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side)
    {
        return this.canPlaceBlockAt(worldIn, pos);
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos).getBlock().blockMaterial.isReplaceable();
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        return false;
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block)
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn)
    {
    }

    /**
     * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
     * IBlockstate
     */
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getStateFromMeta(meta);
    }

    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
    }

    public Vec3 modifyAcceleration(World worldIn, BlockPos pos, Entity entityIn, Vec3 motion)
    {
        return motion;
    }

    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
    }

    /**
     * returns the block bounderies minX value
     */
    public final double getBlockBoundsMinX()
    {
        return this.minX;
    }

    /**
     * returns the block bounderies maxX value
     */
    public final double getBlockBoundsMaxX()
    {
        return this.maxX;
    }

    /**
     * returns the block bounderies minY value
     */
    public final double getBlockBoundsMinY()
    {
        return this.minY;
    }

    /**
     * returns the block bounderies maxY value
     */
    public final double getBlockBoundsMaxY()
    {
        return this.maxY;
    }

    /**
     * returns the block bounderies minZ value
     */
    public final double getBlockBoundsMinZ()
    {
        return this.minZ;
    }

    /**
     * returns the block bounderies maxZ value
     */
    public final double getBlockBoundsMaxZ()
    {
        return this.maxZ;
    }

    public int getBlockColor()
    {
        return OBFVAL_sCJ2j.get();
    }

    public int getRenderColor(IBlockState state)
    {
        return OBFVAL_sCJ2j.get();
    }

    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass)
    {
        return OBFVAL_sCJ2j.get();
    }

    public final int colorMultiplier(IBlockAccess worldIn, BlockPos pos)
    {
        return this.colorMultiplier(worldIn, pos, 0);
    }

    public int getWeakPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
    {
        return 0;
    }

    /**
     * Can this block provide power. Only wire currently seems to have this change based on its state.
     */
    public boolean canProvidePower()
    {
        return false;
    }

    /**
     * Called When an Entity Collided with the Block
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
    }

    public int getStrongPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
    {
        return 0;
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
    }

    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te)
    {
        player.triggerAchievement(StatList.mineBlockStatArray[getIdFromBlock(this)]);
        player.addExhaustion(OBFVAL_yQHSx.get());

        if (this.canSilkHarvest() && EnchantmentHelper.getSilkTouchModifier(player))
        {
            ItemStack itemstack = this.createStackedBlock(state);

            if (itemstack != null)
            {
                spawnAsEntity(worldIn, pos, itemstack);
            }
        }
        else
        {
            int i = EnchantmentHelper.getFortuneModifier(player);
            this.dropBlockAsItem(worldIn, pos, state, i);
        }
    }

    protected boolean canSilkHarvest()
    {
        return this.isFullCube() && !this.isBlockContainer;
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        int i = 0;
        Item item = Item.getItemFromBlock(this);

        if (item != null && item.getHasSubtypes())
        {
            i = this.getMetaFromState(state);
        }

        return new ItemStack(item, 1, i);
    }

    /**
     * Get the quantity dropped based on the given fortune level
     */
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return this.quantityDropped(random);
    }

    /**
     * Called by ItemBlocks after a block is set in the world, to allow post-place logic
     */
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
    }

    public boolean func_181623_g()
    {
        return !this.blockMaterial.isSolid() && !this.blockMaterial.isLiquid();
    }

    public Block setUnlocalizedName(String name)
    {
        this.unlocalizedName = name;
        return this;
    }

    /**
     * Gets the localized name of this block. Used for the statistics page.
     */
    public String getLocalizedName()
    {
        return StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
    }

    /**
     * Returns the unlocalized name of the block with "tile." appended to the front.
     */
    public String getUnlocalizedName()
    {
        return "tile." + this.unlocalizedName;
    }

    /**
     * Called on both Client and Server when World#addBlockEvent is called
     */
    public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam)
    {
        return false;
    }

    /**
     * Return the state of blocks statistics flags - if the block is counted for mined and placed.
     */
    public boolean getEnableStats()
    {
        return this.enableStats;
    }

    protected Block disableStats()
    {
        this.enableStats = false;
        return this;
    }

    public int getMobilityFlag()
    {
        return this.blockMaterial.getMaterialMobility();
    }

    /**
     * Returns the default ambient occlusion value based on block opacity
     */
    public float getAmbientOcclusionLightValue()
    {
        return this.isBlockNormalCube() ? OBFVAL_RFMBt.get() : 1.0F;
    }

    /**
     * Block's chance to react to a living entity falling on it.
     */
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance)
    {
        entityIn.fall(fallDistance, 1.0F);
    }

    /**
     * Called when an Entity lands on this Block. This method *must* update motionY because the entity will not do that
     * on its own
     */
    public void onLanded(World worldIn, Entity entityIn)
    {
        entityIn.motionY = 0.0D;
    }

    public Item getItem(World worldIn, BlockPos pos)
    {
        return Item.getItemFromBlock(this);
    }

    public int getDamageValue(World worldIn, BlockPos pos)
    {
        return this.damageDropped(worldIn.getBlockState(pos));
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        list.add(new ItemStack(itemIn, 1, 0));
    }

    /**
     * Returns the CreativeTab to display the given block on.
     */
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return this.displayOnCreativeTab;
    }

    public Block setCreativeTab(CreativeTabs tab)
    {
        this.displayOnCreativeTab = tab;
        return this;
    }

    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
    }

    /**
     * Called similar to random ticks, but only when it is raining.
     */
    public void fillWithRain(World worldIn, BlockPos pos)
    {
    }

    /**
     * Returns true only if block is flowerPot
     */
    public boolean isFlowerPot()
    {
        return false;
    }

    public boolean requiresUpdates()
    {
        return true;
    }

    /**
     * Return whether this block can drop from an explosion.
     */
    public boolean canDropFromExplosion(Explosion explosionIn)
    {
        return true;
    }

    public boolean isAssociatedBlock(Block other)
    {
        return this == other;
    }

    public static boolean isEqualTo(Block blockIn, Block other)
    {
        return blockIn != null && other != null ? (blockIn == other ? true : blockIn.isAssociatedBlock(other)) : false;
    }

    public boolean hasComparatorInputOverride()
    {
        return false;
    }

    public int getComparatorInputOverride(World worldIn, BlockPos pos)
    {
        return 0;
    }

    /**
     * Possibly modify the given BlockState before rendering it on an Entity (Minecarts, Endermen, ...)
     */
    public IBlockState getStateForEntityRender(IBlockState state)
    {
        return state;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[0]);
    }

    public BlockState getBlockState()
    {
        return this.blockState;
    }

    protected final void setDefaultState(IBlockState state)
    {
        this.defaultBlockState = state;
    }

    public final IBlockState getDefaultState()
    {
        return this.defaultBlockState;
    }

    /**
     * Get the OffsetType for this Block. Determines if the model is rendered slightly offset.
     */
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.NONE;
    }

    public String toString()
    {
        return "Block{" + blockRegistry.getNameForObject(this) + "}";
    }

    public static void registerBlocks()
    {
        registerBlock(0, AIR_ID, (new BlockAir()).setUnlocalizedName("air"));
        registerBlock(1, "stone", (new BlockStone()).setHardness(OBFVAL_rzB5C.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setUnlocalizedName("stone"));
        registerBlock(OBFVAL_o5Wk6.get(), "grass", (new BlockGrass()).setHardness(OBFVAL_xQdrf.get()).setStepSound(soundTypeGrass).setUnlocalizedName("grass"));
        registerBlock(OBFVAL_Wugct.get(), "dirt", (new BlockDirt()).setHardness(OBFVAL_OnmQT.get()).setStepSound(soundTypeGravel).setUnlocalizedName("dirt"));
        Block block = (new Block(Material.rock)).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setUnlocalizedName("stonebrick").setCreativeTab(CreativeTabs.tabBlock);
        registerBlock(OBFVAL_4c9O2.get(), "cobblestone", block);
        Block block1 = (new BlockPlanks()).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("wood");
        registerBlock(OBFVAL_TO3Ig.get(), "planks", block1);
        registerBlock(OBFVAL_gIpO9.get(), "sapling", (new BlockSapling()).setHardness(0.0F).setStepSound(soundTypeGrass).setUnlocalizedName("sapling"));
        registerBlock(OBFVAL_xY1LM.get(), "bedrock", (new Block(Material.rock)).setBlockUnbreakable().setResistance(OBFVAL_oXdtp.get()).setStepSound(soundTypePiston).setUnlocalizedName("bedrock").disableStats().setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(OBFVAL_sUwhL.get(), "flowing_water", (new BlockDynamicLiquid(Material.water)).setHardness(OBFVAL_cfaOS.get()).setLightOpacity(OBFVAL_Wugct.get()).setUnlocalizedName("water").disableStats());
        registerBlock(OBFVAL_NfEhk.get(), "water", (new BlockStaticLiquid(Material.water)).setHardness(OBFVAL_cfaOS.get()).setLightOpacity(OBFVAL_Wugct.get()).setUnlocalizedName("water").disableStats());
        registerBlock(OBFVAL_6DSOO.get(), "flowing_lava", (new BlockDynamicLiquid(Material.lava)).setHardness(OBFVAL_cfaOS.get()).setLightLevel(1.0F).setUnlocalizedName("lava").disableStats());
        registerBlock(OBFVAL_dK2FR.get(), "lava", (new BlockStaticLiquid(Material.lava)).setHardness(OBFVAL_cfaOS.get()).setLightLevel(1.0F).setUnlocalizedName("lava").disableStats());
        registerBlock(OBFVAL_dgAOe.get(), "sand", (new BlockSand()).setHardness(OBFVAL_OnmQT.get()).setStepSound(soundTypeSand).setUnlocalizedName("sand"));
        registerBlock(OBFVAL_wWGmo.get(), "gravel", (new BlockGravel()).setHardness(OBFVAL_xQdrf.get()).setStepSound(soundTypeGravel).setUnlocalizedName("gravel"));
        registerBlock(OBFVAL_h5xku.get(), "gold_ore", (new BlockOre()).setHardness(OBFVAL_or8MX.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypePiston).setUnlocalizedName("oreGold"));
        registerBlock(OBFVAL_E7cLf.get(), "iron_ore", (new BlockOre()).setHardness(OBFVAL_or8MX.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypePiston).setUnlocalizedName("oreIron"));
        registerBlock(OBFVAL_AnXWS.get(), "coal_ore", (new BlockOre()).setHardness(OBFVAL_or8MX.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypePiston).setUnlocalizedName("oreCoal"));
        registerBlock(OBFVAL_zsQUa.get(), "log", (new BlockOldLog()).setUnlocalizedName("log"));
        registerBlock(OBFVAL_2eA85.get(), "leaves", (new BlockOldLeaf()).setUnlocalizedName("leaves"));
        registerBlock(OBFVAL_cpezq.get(), "sponge", (new BlockSponge()).setHardness(OBFVAL_xQdrf.get()).setStepSound(soundTypeGrass).setUnlocalizedName("sponge"));
        registerBlock(OBFVAL_cpCPc.get(), "glass", (new BlockGlass(Material.glass, false)).setHardness(OBFVAL_4Fwyg.get()).setStepSound(soundTypeGlass).setUnlocalizedName("glass"));
        registerBlock(OBFVAL_rtLir.get(), "lapis_ore", (new BlockOre()).setHardness(OBFVAL_or8MX.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypePiston).setUnlocalizedName("oreLapis"));
        registerBlock(OBFVAL_nMzhU.get(), "lapis_block", (new Block(Material.iron, MapColor.lapisColor)).setHardness(OBFVAL_or8MX.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypePiston).setUnlocalizedName("blockLapis").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(OBFVAL_FxvPm.get(), "dispenser", (new BlockDispenser()).setHardness(OBFVAL_QlfWv.get()).setStepSound(soundTypePiston).setUnlocalizedName("dispenser"));
        Block block2 = (new BlockSandStone()).setStepSound(soundTypePiston).setHardness(OBFVAL_7bMZQ.get()).setUnlocalizedName("sandStone");
        registerBlock(OBFVAL_lNHop.get(), "sandstone", block2);
        registerBlock(OBFVAL_W42Ee.get(), "noteblock", (new BlockNote()).setHardness(OBFVAL_7bMZQ.get()).setUnlocalizedName("musicBlock"));
        registerBlock(OBFVAL_nYPEX.get(), "bed", (new BlockBed()).setStepSound(soundTypeWood).setHardness(OBFVAL_RFMBt.get()).setUnlocalizedName("bed").disableStats());
        registerBlock(OBFVAL_1LUyW.get(), "golden_rail", (new BlockRailPowered()).setHardness(OBFVAL_3FPHx.get()).setStepSound(soundTypeMetal).setUnlocalizedName("goldenRail"));
        registerBlock(OBFVAL_H0F8U.get(), "detector_rail", (new BlockRailDetector()).setHardness(OBFVAL_3FPHx.get()).setStepSound(soundTypeMetal).setUnlocalizedName("detectorRail"));
        registerBlock(OBFVAL_RPwb6.get(), "sticky_piston", (new BlockPistonBase(true)).setUnlocalizedName("pistonStickyBase"));
        registerBlock(OBFVAL_22Ica.get(), "web", (new BlockWeb()).setLightOpacity(1).setHardness(OBFVAL_Ca3Ja.get()).setUnlocalizedName("web"));
        registerBlock(OBFVAL_NQVUO.get(), "tallgrass", (new BlockTallGrass()).setHardness(0.0F).setStepSound(soundTypeGrass).setUnlocalizedName("tallgrass"));
        registerBlock(OBFVAL_FwmwR.get(), "deadbush", (new BlockDeadBush()).setHardness(0.0F).setStepSound(soundTypeGrass).setUnlocalizedName("deadbush"));
        registerBlock(OBFVAL_x0pTx.get(), "piston", (new BlockPistonBase(false)).setUnlocalizedName("pistonBase"));
        registerBlock(OBFVAL_EU3fZ.get(), "piston_head", (new BlockPistonExtension()).setUnlocalizedName("pistonBase"));
        registerBlock(OBFVAL_DoRta.get(), "wool", (new BlockColored(Material.cloth)).setHardness(OBFVAL_7bMZQ.get()).setStepSound(soundTypeCloth).setUnlocalizedName("cloth"));
        registerBlock(OBFVAL_QHptm.get(), "piston_extension", new BlockPistonMoving());
        registerBlock(OBFVAL_aMstD.get(), "yellow_flower", (new BlockYellowFlower()).setHardness(0.0F).setStepSound(soundTypeGrass).setUnlocalizedName("flower1"));
        registerBlock(OBFVAL_2xO2o.get(), "red_flower", (new BlockRedFlower()).setHardness(0.0F).setStepSound(soundTypeGrass).setUnlocalizedName("flower2"));
        Block block3 = (new BlockMushroom()).setHardness(0.0F).setStepSound(soundTypeGrass).setLightLevel(OBFVAL_aCRDC.get()).setUnlocalizedName("mushroom");
        registerBlock(OBFVAL_WlT0h.get(), "brown_mushroom", block3);
        Block block4 = (new BlockMushroom()).setHardness(0.0F).setStepSound(soundTypeGrass).setUnlocalizedName("mushroom");
        registerBlock(OBFVAL_NJPb8.get(), "red_mushroom", block4);
        registerBlock(OBFVAL_rgTA3.get(), "gold_block", (new Block(Material.iron, MapColor.goldColor)).setHardness(OBFVAL_or8MX.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypeMetal).setUnlocalizedName("blockGold").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(OBFVAL_u8oq8.get(), "iron_block", (new Block(Material.iron, MapColor.ironColor)).setHardness(OBFVAL_8xbAu.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypeMetal).setUnlocalizedName("blockIron").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(OBFVAL_IChpP.get(), "double_stone_slab", (new BlockDoubleStoneSlab()).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setUnlocalizedName("stoneSlab"));
        registerBlock(OBFVAL_5wfqF.get(), "stone_slab", (new BlockHalfStoneSlab()).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setUnlocalizedName("stoneSlab"));
        Block block5 = (new Block(Material.rock, MapColor.redColor)).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setUnlocalizedName("brick").setCreativeTab(CreativeTabs.tabBlock);
        registerBlock(OBFVAL_mS7mJ.get(), "brick_block", block5);
        registerBlock(OBFVAL_1VqQ6.get(), "tnt", (new BlockTNT()).setHardness(0.0F).setStepSound(soundTypeGrass).setUnlocalizedName("tnt"));
        registerBlock(OBFVAL_UFqyx.get(), "bookshelf", (new BlockBookshelf()).setHardness(OBFVAL_rzB5C.get()).setStepSound(soundTypeWood).setUnlocalizedName("bookshelf"));
        registerBlock(OBFVAL_jYqZZ.get(), "mossy_cobblestone", (new Block(Material.rock)).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setUnlocalizedName("stoneMoss").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(OBFVAL_AzSfF.get(), "obsidian", (new BlockObsidian()).setHardness(OBFVAL_SoR5h.get()).setResistance(OBFVAL_C6v4N.get()).setStepSound(soundTypePiston).setUnlocalizedName("obsidian"));
        registerBlock(OBFVAL_hRvs6.get(), "torch", (new BlockTorch()).setHardness(0.0F).setLightLevel(OBFVAL_zVyA8.get()).setStepSound(soundTypeWood).setUnlocalizedName("torch"));
        registerBlock(OBFVAL_FpbCQ.get(), "fire", (new BlockFire()).setHardness(0.0F).setLightLevel(1.0F).setStepSound(soundTypeCloth).setUnlocalizedName("fire").disableStats());
        registerBlock(OBFVAL_HOBnQ.get(), "mob_spawner", (new BlockMobSpawner()).setHardness(OBFVAL_8xbAu.get()).setStepSound(soundTypeMetal).setUnlocalizedName("mobSpawner").disableStats());
        registerBlock(OBFVAL_RcVxv.get(), "oak_stairs", (new BlockStairs(block1.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK))).setUnlocalizedName("stairsWood"));
        registerBlock(OBFVAL_cN4Xf.get(), "chest", (new BlockChest(0)).setHardness(OBFVAL_1gyv4.get()).setStepSound(soundTypeWood).setUnlocalizedName("chest"));
        registerBlock(OBFVAL_PB8De.get(), "redstone_wire", (new BlockRedstoneWire()).setHardness(0.0F).setStepSound(soundTypeStone).setUnlocalizedName("redstoneDust").disableStats());
        registerBlock(OBFVAL_nbNgU.get(), "diamond_ore", (new BlockOre()).setHardness(OBFVAL_or8MX.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypePiston).setUnlocalizedName("oreDiamond"));
        registerBlock(OBFVAL_MDuNJ.get(), "diamond_block", (new Block(Material.iron, MapColor.diamondColor)).setHardness(OBFVAL_8xbAu.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypeMetal).setUnlocalizedName("blockDiamond").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(OBFVAL_dfnGn.get(), "crafting_table", (new BlockWorkbench()).setHardness(OBFVAL_1gyv4.get()).setStepSound(soundTypeWood).setUnlocalizedName("workbench"));
        registerBlock(OBFVAL_0T8Gq.get(), "wheat", (new BlockCrops()).setUnlocalizedName("crops"));
        Block block6 = (new BlockFarmland()).setHardness(OBFVAL_xQdrf.get()).setStepSound(soundTypeGravel).setUnlocalizedName("farmland");
        registerBlock(OBFVAL_MQFZ0.get(), "farmland", block6);
        registerBlock(OBFVAL_i5H42.get(), "furnace", (new BlockFurnace(false)).setHardness(OBFVAL_QlfWv.get()).setStepSound(soundTypePiston).setUnlocalizedName("furnace").setCreativeTab(CreativeTabs.tabDecorations));
        registerBlock(OBFVAL_APWW3.get(), "lit_furnace", (new BlockFurnace(true)).setHardness(OBFVAL_QlfWv.get()).setStepSound(soundTypePiston).setLightLevel(OBFVAL_rRAWg.get()).setUnlocalizedName("furnace"));
        registerBlock(OBFVAL_i17I5.get(), "standing_sign", (new BlockStandingSign()).setHardness(1.0F).setStepSound(soundTypeWood).setUnlocalizedName("sign").disableStats());
        registerBlock(OBFVAL_pTauQ.get(), "wooden_door", (new BlockDoor(Material.wood)).setHardness(OBFVAL_or8MX.get()).setStepSound(soundTypeWood).setUnlocalizedName("doorOak").disableStats());
        registerBlock(OBFVAL_zLUn7.get(), "ladder", (new BlockLadder()).setHardness(OBFVAL_zazbG.get()).setStepSound(soundTypeLadder).setUnlocalizedName("ladder"));
        registerBlock(OBFVAL_uIJqM.get(), "rail", (new BlockRail()).setHardness(OBFVAL_3FPHx.get()).setStepSound(soundTypeMetal).setUnlocalizedName("rail"));
        registerBlock(OBFVAL_VCWXh.get(), "stone_stairs", (new BlockStairs(block.getDefaultState())).setUnlocalizedName("stairsStone"));
        registerBlock(OBFVAL_XB94V.get(), "wall_sign", (new BlockWallSign()).setHardness(1.0F).setStepSound(soundTypeWood).setUnlocalizedName("sign").disableStats());
        registerBlock(OBFVAL_XGnIS.get(), "lever", (new BlockLever()).setHardness(OBFVAL_OnmQT.get()).setStepSound(soundTypeWood).setUnlocalizedName("lever"));
        registerBlock(OBFVAL_OTDzq.get(), "stone_pressure_plate", (new BlockPressurePlate(Material.rock, BlockPressurePlate.Sensitivity.MOBS)).setHardness(OBFVAL_OnmQT.get()).setStepSound(soundTypePiston).setUnlocalizedName("pressurePlateStone"));
        registerBlock(OBFVAL_BXxjG.get(), "iron_door", (new BlockDoor(Material.iron)).setHardness(OBFVAL_8xbAu.get()).setStepSound(soundTypeMetal).setUnlocalizedName("doorIron").disableStats());
        registerBlock(OBFVAL_r3d9r.get(), "wooden_pressure_plate", (new BlockPressurePlate(Material.wood, BlockPressurePlate.Sensitivity.EVERYTHING)).setHardness(OBFVAL_OnmQT.get()).setStepSound(soundTypeWood).setUnlocalizedName("pressurePlateWood"));
        registerBlock(OBFVAL_oF6Sb.get(), "redstone_ore", (new BlockRedstoneOre(false)).setHardness(OBFVAL_or8MX.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypePiston).setUnlocalizedName("oreRedstone").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(OBFVAL_nGadT.get(), "lit_redstone_ore", (new BlockRedstoneOre(true)).setLightLevel(OBFVAL_hvUHW.get()).setHardness(OBFVAL_or8MX.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypePiston).setUnlocalizedName("oreRedstone"));
        registerBlock(OBFVAL_LHgbq.get(), "unlit_redstone_torch", (new BlockRedstoneTorch(false)).setHardness(0.0F).setStepSound(soundTypeWood).setUnlocalizedName("notGate"));
        registerBlock(OBFVAL_s8DV9.get(), "redstone_torch", (new BlockRedstoneTorch(true)).setHardness(0.0F).setLightLevel(OBFVAL_OnmQT.get()).setStepSound(soundTypeWood).setUnlocalizedName("notGate").setCreativeTab(CreativeTabs.tabRedstone));
        registerBlock(OBFVAL_QBRmQ.get(), "stone_button", (new BlockButtonStone()).setHardness(OBFVAL_OnmQT.get()).setStepSound(soundTypePiston).setUnlocalizedName("button"));
        registerBlock(OBFVAL_kQJFr.get(), "snow_layer", (new BlockSnow()).setHardness(OBFVAL_f3rzJ.get()).setStepSound(soundTypeSnow).setUnlocalizedName("snow").setLightOpacity(0));
        registerBlock(OBFVAL_o6jpm.get(), "ice", (new BlockIce()).setHardness(OBFVAL_OnmQT.get()).setLightOpacity(OBFVAL_Wugct.get()).setStepSound(soundTypeGlass).setUnlocalizedName("ice"));
        registerBlock(OBFVAL_3njA7.get(), "snow", (new BlockSnowBlock()).setHardness(OBFVAL_RFMBt.get()).setStepSound(soundTypeSnow).setUnlocalizedName("snow"));
        registerBlock(OBFVAL_D8Gng.get(), "cactus", (new BlockCactus()).setHardness(OBFVAL_zazbG.get()).setStepSound(soundTypeCloth).setUnlocalizedName("cactus"));
        registerBlock(OBFVAL_6NWbo.get(), "clay", (new BlockClay()).setHardness(OBFVAL_xQdrf.get()).setStepSound(soundTypeGravel).setUnlocalizedName("clay"));
        registerBlock(OBFVAL_hZBVK.get(), "reeds", (new BlockReed()).setHardness(0.0F).setStepSound(soundTypeGrass).setUnlocalizedName("reeds").disableStats());
        registerBlock(OBFVAL_adJYd.get(), "jukebox", (new BlockJukebox()).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setUnlocalizedName("jukebox"));
        registerBlock(OBFVAL_0U97O.get(), "fence", (new BlockFence(Material.wood, BlockPlanks.EnumType.OAK.func_181070_c())).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("fence"));
        Block block7 = (new BlockPumpkin()).setHardness(1.0F).setStepSound(soundTypeWood).setUnlocalizedName("pumpkin");
        registerBlock(OBFVAL_i3YvG.get(), "pumpkin", block7);
        registerBlock(OBFVAL_iof3K.get(), "netherrack", (new BlockNetherrack()).setHardness(OBFVAL_zazbG.get()).setStepSound(soundTypePiston).setUnlocalizedName("hellrock"));
        registerBlock(OBFVAL_xGwLQ.get(), "soul_sand", (new BlockSoulSand()).setHardness(OBFVAL_OnmQT.get()).setStepSound(soundTypeSand).setUnlocalizedName("hellsand"));
        registerBlock(OBFVAL_eek1P.get(), "glowstone", (new BlockGlowstone(Material.glass)).setHardness(OBFVAL_4Fwyg.get()).setStepSound(soundTypeGlass).setLightLevel(1.0F).setUnlocalizedName("lightgem"));
        registerBlock(OBFVAL_HkJZ0.get(), "portal", (new BlockPortal()).setHardness(OBFVAL_6dz9u.get()).setStepSound(soundTypeGlass).setLightLevel(OBFVAL_hgPDu.get()).setUnlocalizedName("portal"));
        registerBlock(OBFVAL_8JSp0.get(), "lit_pumpkin", (new BlockPumpkin()).setHardness(1.0F).setStepSound(soundTypeWood).setLightLevel(1.0F).setUnlocalizedName("litpumpkin"));
        registerBlock(OBFVAL_j5mj6.get(), "cake", (new BlockCake()).setHardness(OBFVAL_OnmQT.get()).setStepSound(soundTypeCloth).setUnlocalizedName("cake").disableStats());
        registerBlock(OBFVAL_k1I4w.get(), "unpowered_repeater", (new BlockRedstoneRepeater(false)).setHardness(0.0F).setStepSound(soundTypeWood).setUnlocalizedName("diode").disableStats());
        registerBlock(OBFVAL_EDBrb.get(), "powered_repeater", (new BlockRedstoneRepeater(true)).setHardness(0.0F).setStepSound(soundTypeWood).setUnlocalizedName("diode").disableStats());
        registerBlock(OBFVAL_ddoIU.get(), "stained_glass", (new BlockStainedGlass(Material.glass)).setHardness(OBFVAL_4Fwyg.get()).setStepSound(soundTypeGlass).setUnlocalizedName("stainedGlass"));
        registerBlock(OBFVAL_2B6SI.get(), "trapdoor", (new BlockTrapDoor(Material.wood)).setHardness(OBFVAL_or8MX.get()).setStepSound(soundTypeWood).setUnlocalizedName("trapdoor").disableStats());
        registerBlock(OBFVAL_tCl1J.get(), "monster_egg", (new BlockSilverfish()).setHardness(OBFVAL_hgPDu.get()).setUnlocalizedName("monsterStoneEgg"));
        Block block8 = (new BlockStoneBrick()).setHardness(OBFVAL_rzB5C.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setUnlocalizedName("stonebricksmooth");
        registerBlock(OBFVAL_u6uEp.get(), "stonebrick", block8);
        registerBlock(OBFVAL_1yQcY.get(), "brown_mushroom_block", (new BlockHugeMushroom(Material.wood, MapColor.dirtColor, block3)).setHardness(OBFVAL_RFMBt.get()).setStepSound(soundTypeWood).setUnlocalizedName("mushroom"));
        registerBlock(OBFVAL_X5XXK.get(), "red_mushroom_block", (new BlockHugeMushroom(Material.wood, MapColor.redColor, block4)).setHardness(OBFVAL_RFMBt.get()).setStepSound(soundTypeWood).setUnlocalizedName("mushroom"));
        registerBlock(OBFVAL_W0m1f.get(), "iron_bars", (new BlockPane(Material.iron, true)).setHardness(OBFVAL_8xbAu.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypeMetal).setUnlocalizedName("fenceIron"));
        registerBlock(OBFVAL_rjsbR.get(), "glass_pane", (new BlockPane(Material.glass, false)).setHardness(OBFVAL_4Fwyg.get()).setStepSound(soundTypeGlass).setUnlocalizedName("thinGlass"));
        Block block9 = (new BlockMelon()).setHardness(1.0F).setStepSound(soundTypeWood).setUnlocalizedName("melon");
        registerBlock(OBFVAL_Wvrlf.get(), "melon_block", block9);
        registerBlock(OBFVAL_9DUgn.get(), "pumpkin_stem", (new BlockStem(block7)).setHardness(0.0F).setStepSound(soundTypeWood).setUnlocalizedName("pumpkinStem"));
        registerBlock(OBFVAL_cawGG.get(), "melon_stem", (new BlockStem(block9)).setHardness(0.0F).setStepSound(soundTypeWood).setUnlocalizedName("pumpkinStem"));
        registerBlock(OBFVAL_4Hsni.get(), "vine", (new BlockVine()).setHardness(OBFVAL_RFMBt.get()).setStepSound(soundTypeGrass).setUnlocalizedName("vine"));
        registerBlock(OBFVAL_w7Bnp.get(), "fence_gate", (new BlockFenceGate(BlockPlanks.EnumType.OAK)).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("fenceGate"));
        registerBlock(OBFVAL_Sg8fQ.get(), "brick_stairs", (new BlockStairs(block5.getDefaultState())).setUnlocalizedName("stairsBrick"));
        registerBlock(OBFVAL_hJwzS.get(), "stone_brick_stairs", (new BlockStairs(block8.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.DEFAULT))).setUnlocalizedName("stairsStoneBrickSmooth"));
        registerBlock(OBFVAL_MxSJ4.get(), "mycelium", (new BlockMycelium()).setHardness(OBFVAL_xQdrf.get()).setStepSound(soundTypeGrass).setUnlocalizedName("mycel"));
        registerBlock(OBFVAL_U6m7v.get(), "waterlily", (new BlockLilyPad()).setHardness(0.0F).setStepSound(soundTypeGrass).setUnlocalizedName("waterlily"));
        Block block10 = (new BlockNetherBrick()).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setUnlocalizedName("netherBrick").setCreativeTab(CreativeTabs.tabBlock);
        registerBlock(OBFVAL_kvQVz.get(), "nether_brick", block10);
        registerBlock(OBFVAL_5eJ8l.get(), "nether_brick_fence", (new BlockFence(Material.rock, MapColor.netherrackColor)).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setUnlocalizedName("netherFence"));
        registerBlock(OBFVAL_gzsrP.get(), "nether_brick_stairs", (new BlockStairs(block10.getDefaultState())).setUnlocalizedName("stairsNetherBrick"));
        registerBlock(OBFVAL_94ctO.get(), "nether_wart", (new BlockNetherWart()).setUnlocalizedName("netherStalk"));
        registerBlock(OBFVAL_0H9up.get(), "enchanting_table", (new BlockEnchantmentTable()).setHardness(OBFVAL_8xbAu.get()).setResistance(OBFVAL_C6v4N.get()).setUnlocalizedName("enchantmentTable"));
        registerBlock(OBFVAL_Pqfgp.get(), "brewing_stand", (new BlockBrewingStand()).setHardness(OBFVAL_OnmQT.get()).setLightLevel(OBFVAL_aCRDC.get()).setUnlocalizedName("brewingStand"));
        registerBlock(OBFVAL_ia7w3.get(), "cauldron", (new BlockCauldron()).setHardness(OBFVAL_r8lga.get()).setUnlocalizedName("cauldron"));
        registerBlock(OBFVAL_kXlcB.get(), "end_portal", (new BlockEndPortal(Material.portal)).setHardness(OBFVAL_6dz9u.get()).setResistance(OBFVAL_oXdtp.get()));
        registerBlock(OBFVAL_P10fg.get(), "end_portal_frame", (new BlockEndPortalFrame()).setStepSound(soundTypeGlass).setLightLevel(OBFVAL_aCRDC.get()).setHardness(OBFVAL_6dz9u.get()).setUnlocalizedName("endPortalFrame").setResistance(OBFVAL_oXdtp.get()).setCreativeTab(CreativeTabs.tabDecorations));
        registerBlock(OBFVAL_o77fs.get(), "end_stone", (new Block(Material.rock, MapColor.sandColor)).setHardness(OBFVAL_or8MX.get()).setResistance(OBFVAL_q5RFN.get()).setStepSound(soundTypePiston).setUnlocalizedName("whiteStone").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(OBFVAL_Jxnr8.get(), "dragon_egg", (new BlockDragonEgg()).setHardness(OBFVAL_or8MX.get()).setResistance(OBFVAL_q5RFN.get()).setStepSound(soundTypePiston).setLightLevel(OBFVAL_aCRDC.get()).setUnlocalizedName("dragonEgg"));
        registerBlock(OBFVAL_k3abz.get(), "redstone_lamp", (new BlockRedstoneLight(false)).setHardness(OBFVAL_4Fwyg.get()).setStepSound(soundTypeGlass).setUnlocalizedName("redstoneLight").setCreativeTab(CreativeTabs.tabRedstone));
        registerBlock(OBFVAL_V22Sn.get(), "lit_redstone_lamp", (new BlockRedstoneLight(true)).setHardness(OBFVAL_4Fwyg.get()).setStepSound(soundTypeGlass).setUnlocalizedName("redstoneLight"));
        registerBlock(OBFVAL_rpQaX.get(), "double_wooden_slab", (new BlockDoubleWoodSlab()).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("woodSlab"));
        registerBlock(OBFVAL_6GKfI.get(), "wooden_slab", (new BlockHalfWoodSlab()).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("woodSlab"));
        registerBlock(OBFVAL_sBy9Q.get(), "cocoa", (new BlockCocoa()).setHardness(OBFVAL_RFMBt.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("cocoa"));
        registerBlock(OBFVAL_HP3hQ.get(), "sandstone_stairs", (new BlockStairs(block2.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.SMOOTH))).setUnlocalizedName("stairsSandStone"));
        registerBlock(OBFVAL_mkX0j.get(), "emerald_ore", (new BlockOre()).setHardness(OBFVAL_or8MX.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypePiston).setUnlocalizedName("oreEmerald"));
        registerBlock(OBFVAL_YyRiw.get(), "ender_chest", (new BlockEnderChest()).setHardness(OBFVAL_yhHDR.get()).setResistance(OBFVAL_kqOXU.get()).setStepSound(soundTypePiston).setUnlocalizedName("enderChest").setLightLevel(OBFVAL_OnmQT.get()));
        registerBlock(OBFVAL_hsSjj.get(), "tripwire_hook", (new BlockTripWireHook()).setUnlocalizedName("tripWireSource"));
        registerBlock(OBFVAL_cofeu.get(), "tripwire", (new BlockTripWire()).setUnlocalizedName("tripWire"));
        registerBlock(OBFVAL_Rg2Ju.get(), "emerald_block", (new Block(Material.iron, MapColor.emeraldColor)).setHardness(OBFVAL_8xbAu.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypeMetal).setUnlocalizedName("blockEmerald").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(OBFVAL_sjdDY.get(), "spruce_stairs", (new BlockStairs(block1.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE))).setUnlocalizedName("stairsWoodSpruce"));
        registerBlock(OBFVAL_diisJ.get(), "birch_stairs", (new BlockStairs(block1.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.BIRCH))).setUnlocalizedName("stairsWoodBirch"));
        registerBlock(OBFVAL_wIHx6.get(), "jungle_stairs", (new BlockStairs(block1.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.JUNGLE))).setUnlocalizedName("stairsWoodJungle"));
        registerBlock(OBFVAL_Hq4g0.get(), "command_block", (new BlockCommandBlock()).setBlockUnbreakable().setResistance(OBFVAL_oXdtp.get()).setUnlocalizedName("commandBlock"));
        registerBlock(OBFVAL_vf6HI.get(), "beacon", (new BlockBeacon()).setUnlocalizedName("beacon").setLightLevel(1.0F));
        registerBlock(OBFVAL_VQcij.get(), "cobblestone_wall", (new BlockWall(block)).setUnlocalizedName("cobbleWall"));
        registerBlock(OBFVAL_jo4tY.get(), "flower_pot", (new BlockFlowerPot()).setHardness(0.0F).setStepSound(soundTypeStone).setUnlocalizedName("flowerPot"));
        registerBlock(OBFVAL_TC27g.get(), "carrots", (new BlockCarrot()).setUnlocalizedName("carrots"));
        registerBlock(OBFVAL_gudaO.get(), "potatoes", (new BlockPotato()).setUnlocalizedName("potatoes"));
        registerBlock(OBFVAL_G0aMT.get(), "wooden_button", (new BlockButtonWood()).setHardness(OBFVAL_OnmQT.get()).setStepSound(soundTypeWood).setUnlocalizedName("button"));
        registerBlock(OBFVAL_EkqaN.get(), "skull", (new BlockSkull()).setHardness(1.0F).setStepSound(soundTypePiston).setUnlocalizedName("skull"));
        registerBlock(OBFVAL_eix3f.get(), "anvil", (new BlockAnvil()).setHardness(OBFVAL_8xbAu.get()).setStepSound(soundTypeAnvil).setResistance(OBFVAL_C6v4N.get()).setUnlocalizedName("anvil"));
        registerBlock(OBFVAL_60ATn.get(), "trapped_chest", (new BlockChest(1)).setHardness(OBFVAL_1gyv4.get()).setStepSound(soundTypeWood).setUnlocalizedName("chestTrap"));
        registerBlock(OBFVAL_ud4A5.get(), "light_weighted_pressure_plate", (new BlockPressurePlateWeighted(Material.iron, OBFVAL_E7cLf.get(), MapColor.goldColor)).setHardness(OBFVAL_OnmQT.get()).setStepSound(soundTypeWood).setUnlocalizedName("weightedPlate_light"));
        registerBlock(OBFVAL_mQryS.get(), "heavy_weighted_pressure_plate", (new BlockPressurePlateWeighted(Material.iron, OBFVAL_AEuoa.get())).setHardness(OBFVAL_OnmQT.get()).setStepSound(soundTypeWood).setUnlocalizedName("weightedPlate_heavy"));
        registerBlock(OBFVAL_o3jlP.get(), "unpowered_comparator", (new BlockRedstoneComparator(false)).setHardness(0.0F).setStepSound(soundTypeWood).setUnlocalizedName("comparator").disableStats());
        registerBlock(OBFVAL_AEuoa.get(), "powered_comparator", (new BlockRedstoneComparator(true)).setHardness(0.0F).setLightLevel(OBFVAL_hvUHW.get()).setStepSound(soundTypeWood).setUnlocalizedName("comparator").disableStats());
        registerBlock(OBFVAL_tgr0M.get(), "daylight_detector", new BlockDaylightDetector(false));
        registerBlock(OBFVAL_vYvEY.get(), "redstone_block", (new BlockCompressedPowered(Material.iron, MapColor.tntColor)).setHardness(OBFVAL_8xbAu.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypeMetal).setUnlocalizedName("blockRedstone").setCreativeTab(CreativeTabs.tabRedstone));
        registerBlock(OBFVAL_svvZQ.get(), "quartz_ore", (new BlockOre(MapColor.netherrackColor)).setHardness(OBFVAL_or8MX.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypePiston).setUnlocalizedName("netherquartz"));
        registerBlock(OBFVAL_saXcy.get(), "hopper", (new BlockHopper()).setHardness(OBFVAL_or8MX.get()).setResistance(OBFVAL_rXgVE.get()).setStepSound(soundTypeMetal).setUnlocalizedName("hopper"));
        Block block11 = (new BlockQuartz()).setStepSound(soundTypePiston).setHardness(OBFVAL_7bMZQ.get()).setUnlocalizedName("quartzBlock");
        registerBlock(OBFVAL_V5hPv.get(), "quartz_block", block11);
        registerBlock(OBFVAL_uZF2p.get(), "quartz_stairs", (new BlockStairs(block11.getDefaultState().withProperty(BlockQuartz.VARIANT, BlockQuartz.EnumType.DEFAULT))).setUnlocalizedName("stairsQuartz"));
        registerBlock(OBFVAL_1LTDR.get(), "activator_rail", (new BlockRailPowered()).setHardness(OBFVAL_3FPHx.get()).setStepSound(soundTypeMetal).setUnlocalizedName("activatorRail"));
        registerBlock(OBFVAL_q4LXA.get(), "dropper", (new BlockDropper()).setHardness(OBFVAL_QlfWv.get()).setStepSound(soundTypePiston).setUnlocalizedName("dropper"));
        registerBlock(OBFVAL_7vbRk.get(), "stained_hardened_clay", (new BlockColored(Material.rock)).setHardness(OBFVAL_4s7YX.get()).setResistance(OBFVAL_ZDwDf.get()).setStepSound(soundTypePiston).setUnlocalizedName("clayHardenedStained"));
        registerBlock(OBFVAL_vOuyh.get(), "stained_glass_pane", (new BlockStainedGlassPane()).setHardness(OBFVAL_4Fwyg.get()).setStepSound(soundTypeGlass).setUnlocalizedName("thinStainedGlass"));
        registerBlock(OBFVAL_lj9XZ.get(), "leaves2", (new BlockNewLeaf()).setUnlocalizedName("leaves"));
        registerBlock(OBFVAL_rTGHg.get(), "log2", (new BlockNewLog()).setUnlocalizedName("log"));
        registerBlock(OBFVAL_yI5DB.get(), "acacia_stairs", (new BlockStairs(block1.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA))).setUnlocalizedName("stairsWoodAcacia"));
        registerBlock(OBFVAL_UdQh1.get(), "dark_oak_stairs", (new BlockStairs(block1.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK))).setUnlocalizedName("stairsWoodDarkOak"));
        registerBlock(OBFVAL_JKO6F.get(), "slime", (new BlockSlime()).setUnlocalizedName("slime").setStepSound(SLIME_SOUND));
        registerBlock(OBFVAL_cba4O.get(), "barrier", (new BlockBarrier()).setUnlocalizedName("barrier"));
        registerBlock(OBFVAL_zkQRd.get(), "iron_trapdoor", (new BlockTrapDoor(Material.iron)).setHardness(OBFVAL_8xbAu.get()).setStepSound(soundTypeMetal).setUnlocalizedName("ironTrapdoor").disableStats());
        registerBlock(OBFVAL_ca1S4.get(), "prismarine", (new BlockPrismarine()).setHardness(OBFVAL_rzB5C.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setUnlocalizedName("prismarine"));
        registerBlock(OBFVAL_27z2v.get(), "sea_lantern", (new BlockSeaLantern(Material.glass)).setHardness(OBFVAL_4Fwyg.get()).setStepSound(soundTypeGlass).setLightLevel(1.0F).setUnlocalizedName("seaLantern"));
        registerBlock(OBFVAL_rsNw9.get(), "hay_block", (new BlockHay()).setHardness(OBFVAL_OnmQT.get()).setStepSound(soundTypeGrass).setUnlocalizedName("hayBlock").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(OBFVAL_1mayK.get(), "carpet", (new BlockCarpet()).setHardness(OBFVAL_f3rzJ.get()).setStepSound(soundTypeCloth).setUnlocalizedName("woolCarpet").setLightOpacity(0));
        registerBlock(OBFVAL_fwgpo.get(), "hardened_clay", (new BlockHardenedClay()).setHardness(OBFVAL_4s7YX.get()).setResistance(OBFVAL_ZDwDf.get()).setStepSound(soundTypePiston).setUnlocalizedName("clayHardened"));
        registerBlock(OBFVAL_yQFOJ.get(), "coal_block", (new Block(Material.rock, MapColor.blackColor)).setHardness(OBFVAL_8xbAu.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setUnlocalizedName("blockCoal").setCreativeTab(CreativeTabs.tabBlock));
        registerBlock(OBFVAL_AEKbD.get(), "packed_ice", (new BlockPackedIce()).setHardness(OBFVAL_OnmQT.get()).setStepSound(soundTypeGlass).setUnlocalizedName("icePacked"));
        registerBlock(OBFVAL_KWv8Y.get(), "double_plant", new BlockDoublePlant());
        registerBlock(OBFVAL_pGFJt.get(), "standing_banner", (new BlockBanner.BlockBannerStanding()).setHardness(1.0F).setStepSound(soundTypeWood).setUnlocalizedName("banner").disableStats());
        registerBlock(OBFVAL_A4av9.get(), "wall_banner", (new BlockBanner.BlockBannerHanging()).setHardness(1.0F).setStepSound(soundTypeWood).setUnlocalizedName("banner").disableStats());
        registerBlock(OBFVAL_pHgIr.get(), "daylight_detector_inverted", new BlockDaylightDetector(true));
        Block block12 = (new BlockRedSandstone()).setStepSound(soundTypePiston).setHardness(OBFVAL_7bMZQ.get()).setUnlocalizedName("redSandStone");
        registerBlock(OBFVAL_k2cWJ.get(), "red_sandstone", block12);
        registerBlock(OBFVAL_e4aLF.get(), "red_sandstone_stairs", (new BlockStairs(block12.getDefaultState().withProperty(BlockRedSandstone.TYPE, BlockRedSandstone.EnumType.SMOOTH))).setUnlocalizedName("stairsRedSandStone"));
        registerBlock(OBFVAL_O9zVc.get(), "double_stone_slab2", (new BlockDoubleStoneSlabNew()).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setUnlocalizedName("stoneSlab2"));
        registerBlock(OBFVAL_hxDZt.get(), "stone_slab2", (new BlockHalfStoneSlabNew()).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setUnlocalizedName("stoneSlab2"));
        registerBlock(OBFVAL_ecTvc.get(), "spruce_fence_gate", (new BlockFenceGate(BlockPlanks.EnumType.SPRUCE)).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("spruceFenceGate"));
        registerBlock(OBFVAL_1cjDF.get(), "birch_fence_gate", (new BlockFenceGate(BlockPlanks.EnumType.BIRCH)).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("birchFenceGate"));
        registerBlock(OBFVAL_UQ9QH.get(), "jungle_fence_gate", (new BlockFenceGate(BlockPlanks.EnumType.JUNGLE)).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("jungleFenceGate"));
        registerBlock(OBFVAL_ZeUFn.get(), "dark_oak_fence_gate", (new BlockFenceGate(BlockPlanks.EnumType.DARK_OAK)).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("darkOakFenceGate"));
        registerBlock(OBFVAL_q7xP0.get(), "acacia_fence_gate", (new BlockFenceGate(BlockPlanks.EnumType.ACACIA)).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("acaciaFenceGate"));
        registerBlock(OBFVAL_Wy2rL.get(), "spruce_fence", (new BlockFence(Material.wood, BlockPlanks.EnumType.SPRUCE.func_181070_c())).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("spruceFence"));
        registerBlock(OBFVAL_AAcos.get(), "birch_fence", (new BlockFence(Material.wood, BlockPlanks.EnumType.BIRCH.func_181070_c())).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("birchFence"));
        registerBlock(OBFVAL_zjPhZ.get(), "jungle_fence", (new BlockFence(Material.wood, BlockPlanks.EnumType.JUNGLE.func_181070_c())).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("jungleFence"));
        registerBlock(OBFVAL_hJxDM.get(), "dark_oak_fence", (new BlockFence(Material.wood, BlockPlanks.EnumType.DARK_OAK.func_181070_c())).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("darkOakFence"));
        registerBlock(OBFVAL_n1Fmm.get(), "acacia_fence", (new BlockFence(Material.wood, BlockPlanks.EnumType.ACACIA.func_181070_c())).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_8xbAu.get()).setStepSound(soundTypeWood).setUnlocalizedName("acaciaFence"));
        registerBlock(OBFVAL_kW5FV.get(), "spruce_door", (new BlockDoor(Material.wood)).setHardness(OBFVAL_or8MX.get()).setStepSound(soundTypeWood).setUnlocalizedName("doorSpruce").disableStats());
        registerBlock(OBFVAL_VeNBX.get(), "birch_door", (new BlockDoor(Material.wood)).setHardness(OBFVAL_or8MX.get()).setStepSound(soundTypeWood).setUnlocalizedName("doorBirch").disableStats());
        registerBlock(OBFVAL_RtCNA.get(), "jungle_door", (new BlockDoor(Material.wood)).setHardness(OBFVAL_or8MX.get()).setStepSound(soundTypeWood).setUnlocalizedName("doorJungle").disableStats());
        registerBlock(OBFVAL_wnNPL.get(), "acacia_door", (new BlockDoor(Material.wood)).setHardness(OBFVAL_or8MX.get()).setStepSound(soundTypeWood).setUnlocalizedName("doorAcacia").disableStats());
        registerBlock(OBFVAL_u8woQ.get(), "dark_oak_door", (new BlockDoor(Material.wood)).setHardness(OBFVAL_or8MX.get()).setStepSound(soundTypeWood).setUnlocalizedName("doorDarkOak").disableStats());
        Block block13 = (new Block(Material.rock, MapColor.magentaColor)).setHardness(OBFVAL_rzB5C.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("purpurBlock");
        registerBlock(OBFVAL_m7FMy.get(), "purpur_block", block13);
        registerBlock(OBFVAL_yy0fS.get(), "purpur_pillar", (new BlockCustomPillar(Material.rock, MapColor.magentaColor)).setHardness(OBFVAL_rzB5C.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypePiston).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("purpurPillar"));
        registerBlock(OBFVAL_jA1B4.get(), "purpur_stairs", (new BlockStairs(block13.getDefaultState())).setUnlocalizedName("stairsPurpur"));
        registerBlock(OBFVAL_U08LS.get(), "purpur_double_slab", (new Double()).c(OBFVAL_r8lga.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypeStone).setUnlocalizedName("purpurSlab"));
        registerBlock(OBFVAL_BzSIK.get(), "purpur_slab", (new Half()).c(OBFVAL_r8lga.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypeStone).setUnlocalizedName("purpurSlab"));
        registerBlock(OBFVAL_P9s9x.get(), "end_bricks", (new Block(Material.rock)).setStepSound(soundTypeStone).setHardness(OBFVAL_7bMZQ.get()).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("endBricks"));
        registerBlock(OBFVAL_kvURx.get(), "magma", (new BlockMagma()).c(OBFVAL_OnmQT.get()).setStepSound(soundTypeStone).setUnlocalizedName("magma"));
        registerBlock(OBFVAL_fA2PO.get(), "nether_wart_block", (new Block(Material.grass, MapColor.redColor)).setCreativeTab(CreativeTabs.tabBlock).setHardness(1.0F).setStepSound(soundTypeWood).setUnlocalizedName("netherWartBlock"));
        registerBlock(OBFVAL_M5wHX.get(), "red_nether_brick", (new BlockNetherBrick()).setHardness(OBFVAL_r8lga.get()).setResistance(OBFVAL_Js146.get()).setStepSound(soundTypeStone).setUnlocalizedName("redNetherBrick"));
        registerBlock(OBFVAL_MVIKb.get(), "bone_block", (new BlockBone()).a(soundTypeStone).setUnlocalizedName("boneBlock"));
        registerBlock(OBFVAL_u8ATv.get(), "concrete", (new BlockColored(Material.rock)).setHardness(OBFVAL_XA42p.get()).setStepSound(soundTypePiston).setUnlocalizedName("concrete"));
        registerBlock(OBFVAL_ke5nm.get(), "concrete_powder", (new BlockConcretePowder()).setHardness(OBFVAL_OnmQT.get()).setStepSound(soundTypeSand).setUnlocalizedName("concretePowder"));
        registerBlock(OBFVAL_uvVMq.get(), "crimson_nylium", (new Block(Material.rock, MapColor.netherrackColor)).setHardness(OBFVAL_zazbG.get()).setStepSound(soundTypePiston).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("crimsonNylium"));
        registerBlock(OBFVAL_NkzVf.get(), "warped_nylium", (new Block(Material.rock, MapColor.cyanColor)).setHardness(OBFVAL_zazbG.get()).setStepSound(soundTypePiston).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("warpedNylium"));
        registerBlock(OBFVAL_kslgx.get(), "crimson_stairs", (new BlockStairs(block1.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.CRIMSON))).setUnlocalizedName("stairsWoodCrimson"));
        registerBlock(OBFVAL_ERWKE.get(), "warped_stairs", (new BlockStairs(block1.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.WARPED))).setUnlocalizedName("stairsWoodWarped"));
        registerBlock(OBFVAL_8RmF2.get(), "log_stripped1", (new BlockLogStripped1()).setUnlocalizedName("logStripped"));
        registerBlock(OBFVAL_dmnrb.get(), "log_stripped2", (new BlockLogStripped2()).setUnlocalizedName("logStripped"));
        registerBlock(OBFVAL_je5Vu.get(), "lucky_block", (new Block(Material.sponge)).setHardness(OBFVAL_xQdrf.get()).setStepSound(soundTypeGrass).setUnlocalizedName("luckyBlock").setCreativeTab(CreativeTabs.tabBlock));
        blockRegistry.validateKey();

        for (Block block14 : blockRegistry)
        {
            if (block14.blockMaterial == Material.air)
            {
                block14.useNeighborBrightness = false;
            }
            else
            {
                boolean flag = false;
                boolean flag1 = block14 instanceof BlockStairs;
                boolean flag2 = block14 instanceof BlockSlab;
                boolean flag3 = block14 == block6;
                boolean flag4 = block14.translucent;
                boolean flag5 = block14.lightOpacity == 0;

                if (flag1 || flag2 || flag3 || flag4 || flag5)
                {
                    flag = true;
                }

                block14.useNeighborBrightness = flag;
            }
        }

        for (Block block15 : blockRegistry)
        {
            UnmodifiableIterator unmodifiableiterator = block15.getBlockState().getValidStates().iterator();

            while (unmodifiableiterator.hasNext())
            {
                IBlockState iblockstate = (IBlockState)unmodifiableiterator.next();
                int i = blockRegistry.getIDForObject(block15) << OBFVAL_4c9O2.get() | block15.getMetaFromState(iblockstate);
                BLOCK_STATE_IDS.put(iblockstate, i);
            }
        }
    }

    private static void registerBlock(int id, ResourceLocation textualID, Block block_)
    {
        blockRegistry.register(id, textualID, block_);
    }

    private static void registerBlock(int id, String textualID, Block block_)
    {
        registerBlock(id, new ResourceLocation(textualID), block_);
    }

    static
    {
        ObfValue.beginGeneration();
        ObfValue.endGeneration(new byte[] {(byte) - 20, (byte) - 10, (byte) - 3, (byte) - 69, (byte) - 49, (byte) - 128, (byte)99, (byte) - 30});
    }

    public static enum EnumOffsetType
    {
        NONE,
        XZ,
        XYZ;
    }

    public static class SoundType
    {
        public final String soundName;
        public final float volume;
        public final float frequency;

        public SoundType(String name, float volume, float frequency)
        {
            this.soundName = name;
            this.volume = volume;
            this.frequency = frequency;
        }

        public float getVolume()
        {
            return this.volume;
        }

        public float getFrequency()
        {
            return this.frequency;
        }

        public String getBreakSound()
        {
            return "dig." + this.soundName;
        }

        public String getStepSound()
        {
            return "step." + this.soundName;
        }

        public String getPlaceSound()
        {
            return this.getBreakSound();
        }
    }
}
