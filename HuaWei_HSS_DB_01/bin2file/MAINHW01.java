package bin2file;

public class MAINHW01 {


	public static void main(String[] args) throws Exception {

		String dir;
		dir="E:/SQL/华为HLR数据库原始文件/HSS DB/DRU/";
//		String []f1={"0_81_101.fdb","0_81_102.fdb","0_81_103.fdb","0_81_104.fdb",
//				"0_81_105.fdb","0_81_106.fdb","0_81_107.fdb","0_81_108.fdb"};
//		StartHW.action(dir, f1[0]);
//		StartHW.action(dir, f1[1]);
//		StartHW.action(dir, f1[2]);
//		StartHW.action(dir, f1[3]);
//		StartHW.action(dir, f1[4]);
//		StartHW.action(dir, f1[5]);
//		StartHW.action(dir, f1[6]);
//		StartHW.action(dir, f1[7]);

		dir="E:/temp/张朝顺/";
		String []f2={"0_81_141.fdb","0_81_142.fdb","0_81_143.fdb","0_81_144.fdb","0_81_145.fdb",
				"0_81_146.fdb","0_81_147.fdb","0_81_148.fdb","0_81_149.fdb","0_81_90.fdb"};
		long []Addr_Begins={0x31000,
							0x31400,
							0x31800,
							0x31c00,
							0x32000,
							0x32400,
							0x32800,
							0x32c00,
							0x33000,
							0x33400,
							0x33800,
							0x33c00,
							0x34000,
							0x34400,
							0x34800,
							0x34c00,
							0x35000,
							0x35400,
							0x35800,
							0x35c00,
							0x36000,
							0x36400,
							0x36800,
							0x36c00,
							0x37000,
							0x37400,
							0x37800,
							0x37c00,
							0x38000,
							0x38400,
							0x38800,
							0x38c00,
							0x39000,
							0x39400,
							0x39800,
							0x39c00,
							0x65000,
							0x65400,
							0x65800,
							0x65c00,
							0x67a00,
							0x67e00,
							0x68000,
							0x68800,
				            0x0016b000,
							0x0016b800,
							0x0016c000,
							0x0016c800,
							0x0016d000,
							0x0016d800,
							0x0016e000,
							0x0016e800,
							0x0016f000,
							0x0016f800,
							0x00170000,
							0x00170800,
							0x00171000,
							0x00171800,
							0x00172000,
							0x00172800,
							0x00173000,
							0x00175000,
							0x0017b000,
							0x0017f000,
							0x00183000,
							0x00184000,
							0x00185000,
							0x00186000,
							0x03988000,
							0x03988800,
							0x03989000,
							0x03989800,
							0x0398a000,
							0x0398a800,
							0x0398b000,
							0x0398b800,
							0x05a63000,
							0x05a63400,
							0x05a63800,
							0x05a63c00,
							0x05a64000,
							0x05a64400,
							0x05a64800,
							0x05a64c00,
							0x05a65000};
//		StartHW.action(dir, f2[0]);
		StartHW01.action(dir, f2[9]);
		
		for(int i=0;i<Addr_Begins.length;i++){
		  StartHW02.action(dir, f2[9],Addr_Begins[i]);//提取表名称、字段、字节数等信息，用于SQL中create table
		}
		
//		int HLR_INDEX;
//		long Begin_Point;
//		int Section_Length;
//		int Number_of_Section;
//		
//		HLR_INDEX=0;
//		Begin_Point=0x713f008;
//		Section_Length=0x50;
//		Number_of_Section=10000;
//		
//		file=dir+"";
//		W_AUC_DATA.action(dir, HLR_INDEX, Begin_Point, Section_Length, Number_of_Section);
	}

}
