package decoder;

public class Utils {

	public static String getSTATUS(byte data) {
		switch (data) {
		case 0:
			return "A";
		case 1:
			return "D";
		case 2:
			return "Lte";
		default:
			return "ErrSTATUS" + data;
		}
	}

	public static String getSAM(byte data) {
		switch (data) {
		case 0:
			return "ALL";
		case 1:
			return "OWN";
		case 2:
			return "NAT";
		case 3:
			return "INT";
		default:
			return "ErrSAM" + data;

		}
	}

	public static String getCAT(byte data) {
		switch (data) {
		case 4:
			return "PNS";
		case 10:
			return "OR";
		case 11:
			return "PR";
		case 13:
			return "TP";
		case 15:
			return "CB";
		case (byte) 0xf0:
			return "ONC";
		case (byte) 0xf4:
			return "PNC";
		default:
			return "ErrCAT" + data;
		}
	}

	public static String getRP(byte data) {
		return "" + data;

	}

	public static String getCLIP(byte data) {
		if ((data & 0x01) == 1) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getCLIR(byte data) {
		if ((data & 0x02) == 2) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getCFU(byte data) {
		if ((data & 0x01) == 1) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getCFB(byte data) {
		if ((data & 0x02) == 2) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getCFNA(byte data) {
		if ((data & 0x04) == 4) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getCFNR(byte data) {
		if ((data & 0x08) == 8) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getOCCF(byte data) {
		if ((data & 0x40) == 0x40) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getCW(byte data) {
		if ((data & 0x01) == 1) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getHOLD(byte data) {
		if ((data & 0x02) == 2) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getMPTY(byte data) {
		if ((data & 0x01) == 1) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getBAOC(byte data) {
		if ((data & 0x01) == 1) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getBOIC(byte data) {
		if ((data & 0x02) == 2) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getBOIH(byte data) {
		if ((data & 0x04) == 4) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getBORO(byte data) {
		if ((data & 0x08) == 8) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getBAIC(byte data) {
		if ((data & 0x10) == 0x10) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getBIRO(byte data) {
		if ((data & 0x20) == 0x20) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getUSSD(byte data) {
		if ((data & 0x40) == 0x40) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getODB_CBO(byte data) {
		switch (data) {
		case 0x00:
			return "N";
		case 0x01:
			return "BAOC";
		case 0x02:
			return "BOIC";
		case 0x04:
			return "BOIH";
		case 0x08:
			return "BORO";
		case 0x10:
			return "BOZ";
		case 0x20:
			return "BOZH";
		case 0x40:
			return "BOZIH";
		default:
			return "ErrCBO" + data;
		}
	}

	public static String getODB_BAPR(byte data) {
		switch (data) {
		case 0x00:
			return "N";
		case 0x01:
			return "BAPRE";
		case 0x02:
			return "BAPRI";
		default:
			return "ErrBAPR" + data;
		}
	}

	public static String getODB_CBI(byte data) {
		switch (data) {
		case 0x00:
			return "N";
		case 0x02:
			return "BAIC";
		default:
			return "ErrCBI" + data;
		}
	}

	public static String getODB_BOS(byte data) {
		switch (data) {
		case 0x00:
			return "N";
		case 0x01:
			return "BOS1";
		case 0x02:
			return "BOS2";
		case 0x04:
			return "BOS3";
		case 0x08:
			return "BOS4";
		default:
			return "ErrBOS" + data;
		}
	}

	public static String getODB_BASS(byte data) {
		if ((data & 0x01) == 0x01) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getODB_BREG(byte data) {
		switch (data) {
		case 0x00:
			return "N";
		case 0x01:
			return "BR";
		case 0x02:
			return "BRI";
		case 0x04:
			return "BRIH";
		case 0x08:
			return "BRZ";
		case 0x10:
			return "BRZH";
		default:
			return "ErrBRE" + data;
		}
	}

	public static String getODB_BICT(byte data) {
		switch (data) {
		case 0x00:
			return "N";
		case 0x01:
			return "BI";
		case 0x02:
			return "BIC";
		case 0x04:
			return "BICI";
		case 0x08:
			return "BICZ";
		case 0x10:
			return "BICB";
		case 0x20:
			return "BIM";
		default:
			return "ErrBIC" + data;
		}
	}

	public static String getODB_BOSCF(byte data) {
		switch (data) {
		case 0x00:
			return "N";
		case 0x01:
			return "BIRZ";
		case 0x02:
			return "BOSCF1";
		case 0x04:
			return "BOSCF2";
		case 0x08:
			return "BOSCF3";
		case 0x10:
			return "BOSCF4";
		case 0x20:
			return "BPSR";
		case 0x40:
			return "BCCF";
			/*
			 * case 0x80: return "BOSCF4";
			 */
		default:
			return "ErrBOS" + data;
		}
	}

	public static String getODB_BMSP(byte data) {
		switch (data) {
		case 0x00:
			return "N";
		case 0x04:
			return "BAPS";
		case 0x08:
			return "BPSH";
		case 0x10:
			return "BPSV";
		case 0x20:
			return "BPSR";
		default:
			return "ErrBMSP" + data;
		}
	}

	public static String getODB_BCCF(byte data) {
		if ((data & 0x01) == 0x01) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getCLIR_VALUE(byte data) {
		switch (data) {
		case 0x00:
			return "N";
		case 0x01:
			return "PERM";
		case 0x02:
			return "PCB";
		case 0x03:
			return "PCBN";
		default:
			return "ErrCLI" + data;
		}
	}

	public static String getIN_FLAG_1(byte data) {
		return "" + data;
	}

	public static String getNWACC(byte data) {

		return "" + data;
	}

	public static String getOCCF_1(byte data) {
		if ((data & 0x01) == 0x01) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getSRBT(byte data) {
		if ((data & 0x80) == 0x80) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getIN_FLAG_2(byte data) {
		return "" + data;
	}

	public static String getCLIP_OVERRIDE(byte data) {
		if ((data & 0x01) == 0x01) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getUREST(byte data) {
		if ((data & 0x01) == 0x01) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static String getGREST(byte data) {
		if ((data & 0x02) == 0x02) {
			return "Y";
		} else {
			return "N";
		}
	}

	public static long getPOINTER(byte[] data) {
		long d = 0;
		d = (data[3] & 0xff) * 16777216 + (data[2] & 0xff) * 65536
				+ (data[1] & 0xff) * 256 + (data[0] & 0xff);
		return d;
	}

	public static String getBASIC_SERV(byte[] data) {
		if ((data[0] & 0xff) == 0x00 && (data[1] & 0xff) == 0x10) {
			return "B10";
		} else if ((data[0] & 0xff) == 0x00 && (data[1] & 0xff) == 0x18) {
			return "B1F";
		} else if ((data[0] & 0xff) == 0x01 && (data[1] & 0xff) == 0x10) {
			return "T11";
		} else if ((data[0] & 0xff) == 0x01 && (data[1] & 0xff) == 0x20) {
			return "T20";
		} else if ((data[0] & 0xff) == 0x01 && (data[1] & 0xff) == 0x60) {
			return "T60";
		}
		return "ErrSERV";

	}

	public static String getBASIC_SERVICE(byte[] data) {
		StringBuilder s0 = new StringBuilder();
		if ((data[11] & 0xff) == 0x00 && (data[12] & 0xff) == 0x00) {
			s0.append("B");
		} else if ((data[11] & 0xff) == 0x00 && (data[12] & 0xff) == 0x01) {
			s0.append("T");
		} else {
			return "ErrSERV";
		}
		s0.append(Integer.toHexString(data[13]));
		return s0.toString();
	}

	public static String getSSERV(byte[] data) {
		StringBuilder s0 = new StringBuilder();
		if ((data[0] & 0xff) == 0x21) {
			s0.append("CFU");
			switch (data[1]) {
			case 0x04:
				s0.append("_Y_D");
				break;
			case 0x06:
				s0.append("_Y_R");
				break;
			case 0x07:
				s0.append("_Y_A");
				break;
			case 0x0f:
				s0.append("_Y_AQ");
				break;
			default:
				return "ErrSSERV";
			}
			if ((data[3] & 0xff) != 0xff) {
				s0.append("_");
				s0.append(data[5] & 0x0f);
				s0.append((int) (data[5] & 0xf0) >> 4);
				s0.append(data[6] & 0x0f);
				s0.append((int) (data[6] & 0xf0) >> 4);
				s0.append(data[7] & 0x0f);
				s0.append((int) (data[7] & 0xf0) >> 4);
				if ((data[8] & 0x0f) != 0x0f) {
					s0.append(data[8] & 0x0f);
				}
				if ((data[8] & 0xf0) != 0xf0) {
					s0.append((int) (data[8] & 0xf0) >> 4);
				}
				if ((data[9] & 0x0f) != 0x0f) {
					s0.append(data[9] & 0x0f);
				}
				if ((data[9] & 0xf0) != 0xf0) {
					s0.append((int) (data[9] & 0xf0) >> 4);
				}
				if ((data[10] & 0x0f) != 0x0f) {
					s0.append(data[10] & 0x0f);
				}
				if ((data[10] & 0xf0) != 0xf0) {
					s0.append((int) (data[10] & 0xf0) >> 4);
				}
				if ((data[11] & 0x0f) != 0x0f) {
					s0.append(data[11] & 0x0f);
				}
				if ((data[11] & 0xf0) != 0xf0) {
					s0.append((int) (data[11] & 0xf0) >> 4);
				}
				if ((data[12] & 0x0f) != 0x0f) {
					s0.append(data[12] & 0x0f);
				}
				if ((data[12] & 0xf0) != 0xf0) {
					s0.append((int) (data[12] & 0xf0) >> 4);
				}
				if ((data[13] & 0x0f) != 0x0f) {
					s0.append(data[13] & 0x0f);
				}
				if ((data[13] & 0xf0) != 0xf0) {
					s0.append((int) (data[13] & 0xf0) >> 4);
				}
			}
		}
		if ((data[0] & 0xff) == 0x29) {
			s0.append("CFB");
			switch (data[1]) {
			case 0x04:
				s0.append("_Y_D");
				break;
			case 0x06:
				s0.append("_Y_R");
				break;
			case 0x07:
				s0.append("_Y_A");
				break;
			case 0x0f:
				s0.append("_Y_AQ");
				break;
			default:
				return "ErrCFB";
			}
			if ((data[3] & 0xff) != 0xff) {
				s0.append("_");
				s0.append(data[5] & 0x0f);
				s0.append((int) (data[5] & 0xf0) >> 4);
				s0.append(data[6] & 0x0f);
				s0.append((int) (data[6] & 0xf0) >> 4);
				s0.append(data[7] & 0x0f);
				s0.append((int) (data[7] & 0xf0) >> 4);
				if ((data[8] & 0x0f) != 0x0f) {
					s0.append(data[8] & 0x0f);
				}
				if ((data[8] & 0xf0) != 0xf0) {
					s0.append((int) (data[8] & 0xf0) >> 4);
				}
				if ((data[9] & 0x0f) != 0x0f) {
					s0.append(data[9] & 0x0f);
				}
				if ((data[9] & 0xf0) != 0xf0) {
					s0.append((int) (data[9] & 0xf0) >> 4);
				}
				if ((data[10] & 0x0f) != 0x0f) {
					s0.append(data[10] & 0x0f);
				}
				if ((data[10] & 0xf0) != 0xf0) {
					s0.append((int) (data[10] & 0xf0) >> 4);
				}
				if ((data[11] & 0x0f) != 0x0f) {
					s0.append(data[11] & 0x0f);
				}
				if ((data[11] & 0xf0) != 0xf0) {
					s0.append((int) (data[11] & 0xf0) >> 4);
				}
				if ((data[12] & 0x0f) != 0x0f) {
					s0.append(data[12] & 0x0f);
				}
				if ((data[12] & 0xf0) != 0xf0) {
					s0.append((int) (data[12] & 0xf0) >> 4);
				}
				if ((data[13] & 0x0f) != 0x0f) {
					s0.append(data[13] & 0x0f);
				}
				if ((data[13] & 0xf0) != 0xf0) {
					s0.append((int) (data[13] & 0xf0) >> 4);
				}
				if ((data[15] & 0xff) != 0xff) {
					s0.append("_");
					s0.append((int) (data[15] & 0xff));
				}
			}
		}
		if ((data[0] & 0xff) == 0x2a) {
			s0.append("CFNA");
			switch (data[1]) {
			case 0x04:
				s0.append("_Y_D");
				break;
			case 0x06:
				s0.append("_Y_R");
				break;
			case 0x07:
				s0.append("_Y_A");
				break;
			case 0x0f:
				s0.append("_Y_AQ");
				break;
			default:
				return "ErrCFNA";
			}
			if ((data[3] & 0xff) != 0xff) {
				s0.append("_");
				s0.append(data[5] & 0x0f);
				s0.append((int) (data[5] & 0xf0) >> 4);
				s0.append(data[6] & 0x0f);
				s0.append((int) (data[6] & 0xf0) >> 4);
				s0.append(data[7] & 0x0f);
				s0.append((int) (data[7] & 0xf0) >> 4);
				if ((data[8] & 0x0f) != 0x0f) {
					s0.append(data[8] & 0x0f);
				}
				if ((data[8] & 0xf0) != 0xf0) {
					s0.append((int) (data[8] & 0xf0) >> 4);
				}
				if ((data[9] & 0x0f) != 0x0f) {
					s0.append(data[9] & 0x0f);
				}
				if ((data[9] & 0xf0) != 0xf0) {
					s0.append((int) (data[9] & 0xf0) >> 4);
				}
				if ((data[10] & 0x0f) != 0x0f) {
					s0.append(data[10] & 0x0f);
				}
				if ((data[10] & 0xf0) != 0xf0) {
					s0.append((int) (data[10] & 0xf0) >> 4);
				}
				if ((data[11] & 0x0f) != 0x0f) {
					s0.append(data[11] & 0x0f);
				}
				if ((data[11] & 0xf0) != 0xf0) {
					s0.append((int) (data[11] & 0xf0) >> 4);
				}
				if ((data[12] & 0x0f) != 0x0f) {
					s0.append(data[12] & 0x0f);
				}
				if ((data[12] & 0xf0) != 0xf0) {
					s0.append((int) (data[12] & 0xf0) >> 4);
				}
				if ((data[13] & 0x0f) != 0x0f) {
					s0.append(data[13] & 0x0f);
				}
				if ((data[13] & 0xf0) != 0xf0) {
					s0.append((int) (data[13] & 0xf0) >> 4);
				}
				if ((data[15] & 0xff) != 0xff) {
					s0.append("_");
					s0.append((int) (data[15] & 0xff));
				}
			}
		}
		if ((data[0] & 0xff) == 0x2b) {
			s0.append("CFNR");
			switch (data[1]) {
			case 0x04:
				s0.append("_Y_D");
				break;
			case 0x06:
				s0.append("_Y_R");
				break;
			case 0x07:
				s0.append("_Y_A");
				break;
			case 0x0f:
				s0.append("_Y_AQ");
				break;
			default:
				return "ErrCFNR";
			}
			if ((data[3] & 0xff) != 0xff) {
				s0.append("_");
				s0.append(data[5] & 0x0f);
				s0.append((int) (data[5] & 0xf0) >> 4);
				s0.append(data[6] & 0x0f);
				s0.append((int) (data[6] & 0xf0) >> 4);
				s0.append(data[7] & 0x0f);
				s0.append((int) (data[7] & 0xf0) >> 4);
				if ((data[8] & 0x0f) != 0x0f) {
					s0.append(data[8] & 0x0f);
				}
				if ((data[8] & 0xf0) != 0xf0) {
					s0.append((int) (data[8] & 0xf0) >> 4);
				}
				if ((data[9] & 0x0f) != 0x0f) {
					s0.append(data[9] & 0x0f);
				}
				if ((data[9] & 0xf0) != 0xf0) {
					s0.append((int) (data[9] & 0xf0) >> 4);
				}
				if ((data[10] & 0x0f) != 0x0f) {
					s0.append(data[10] & 0x0f);
				}
				if ((data[10] & 0xf0) != 0xf0) {
					s0.append((int) (data[10] & 0xf0) >> 4);
				}
				if ((data[11] & 0x0f) != 0x0f) {
					s0.append(data[11] & 0x0f);
				}
				if ((data[11] & 0xf0) != 0xf0) {
					s0.append((int) (data[11] & 0xf0) >> 4);
				}
				if ((data[12] & 0x0f) != 0x0f) {
					s0.append(data[12] & 0x0f);
				}
				if ((data[12] & 0xf0) != 0xf0) {
					s0.append((int) (data[12] & 0xf0) >> 4);
				}
				if ((data[13] & 0x0f) != 0x0f) {
					s0.append(data[13] & 0x0f);
				}
				if ((data[13] & 0xf0) != 0xf0) {
					s0.append((int) (data[13] & 0xf0) >> 4);
				}
			}
		}
		if ((data[0] & 0xff) == 0x2c) {
			s0.append("OCCF");
			switch (data[1]) {
			case 0x04:
				s0.append("_Y_D");
				break;
			case 0x06:
				s0.append("_Y_R");
				break;
			case 0x07:
				s0.append("_Y_A");
				break;
			case 0x0f:
				s0.append("_Y_AQ");
				break;
			default:
				return "ErrOCCF";
			}
			if ((data[3] & 0xff) != 0xff) {
				s0.append("_");
				s0.append(data[5] & 0x0f);
				s0.append((int) (data[5] & 0xf0) >> 4);
				s0.append(data[6] & 0x0f);
				s0.append((int) (data[6] & 0xf0) >> 4);
				s0.append(data[7] & 0x0f);
				s0.append((int) (data[7] & 0xf0) >> 4);
				if ((data[8] & 0x0f) != 0x0f) {
					s0.append(data[8] & 0x0f);
				}
				if ((data[8] & 0xf0) != 0xf0) {
					s0.append((int) (data[8] & 0xf0) >> 4);
				}
				if ((data[9] & 0x0f) != 0x0f) {
					s0.append(data[9] & 0x0f);
				}
				if ((data[9] & 0xf0) != 0xf0) {
					s0.append((int) (data[9] & 0xf0) >> 4);
				}
				if ((data[10] & 0x0f) != 0x0f) {
					s0.append(data[10] & 0x0f);
				}
				if ((data[10] & 0xf0) != 0xf0) {
					s0.append((int) (data[10] & 0xf0) >> 4);
				}
				if ((data[11] & 0x0f) != 0x0f) {
					s0.append(data[11] & 0x0f);
				}
				if ((data[11] & 0xf0) != 0xf0) {
					s0.append((int) (data[11] & 0xf0) >> 4);
				}
				if ((data[12] & 0x0f) != 0x0f) {
					s0.append(data[12] & 0x0f);
				}
				if ((data[12] & 0xf0) != 0xf0) {
					s0.append((int) (data[12] & 0xf0) >> 4);
				}
				if ((data[13] & 0x0f) != 0x0f) {
					s0.append(data[13] & 0x0f);
				}
				if ((data[13] & 0xf0) != 0xf0) {
					s0.append((int) (data[13] & 0xf0) >> 4);
				}
				if ((data[15] & 0xff) != 0xff) {
					s0.append("_");
					s0.append((int) (data[15] & 0xff));
				}
			}
		}
		if (s0.length() > 0) {
			return s0.toString();
		}

		for (int i = 0; i < 14; i += 2) {
			switch (data[i] & 0xff) {
			case 0x41:
				s0.append("_CW");
				break;
			case 0x92:
				s0.append("_BAOC");
				break;
			case 0x93:
				s0.append("_BOIC");
				break;
			case 0x94:
				s0.append("_BOIH");
				break;
			case 0x95:
				s0.append("_BORO");
				break;
			case 0x9a:
				s0.append("_BAIC");
				break;
			case 0x9b:
				s0.append("_BIRO");
				break;
			case 0xff:
				break;
			default:
				return "ErrBAOC";
			}
			switch (data[i + 1] & 0xff) {
			case 0x04:
				s0.append("_Y_D");
				break;
			case 0x05:
				s0.append("_Y_A");
				break;
			case 0x00:
				break;
			default:
				return "ErrBAOC";
			}
		}

		return s0.toString();
	}

	public static String getISDN(byte[] data, int begin) {
		StringBuilder s0 = new StringBuilder();
		if ((data[0] & 0x0f) == 0x00)
			return "-";
		s0.append(data[begin] & 0x0f);
		if ((data[begin] & 0xf0) != 0xf0) {
			s0.append((int) (data[begin] & 0xf0) >> 4);
		} else
			return s0.toString();

		if ((data[begin + 1] & 0x0f) != 0x0f) {
			s0.append(data[begin + 1] & 0x0f);
		} else
			return s0.toString();

		if ((data[begin + 1] & 0xf0) != 0xf0) {
			s0.append((int) (data[begin + 1] & 0xf0) >> 4);
		} else
			return s0.toString();

		if ((data[begin + 2] & 0x0f) != 0x0f) {
			s0.append(data[begin + 2] & 0x0f);
		} else
			return s0.toString();

		if ((data[begin + 2] & 0xf0) != 0xf0) {
			s0.append((int) (data[begin + 2] & 0xf0) >> 4);
		} else
			return s0.toString();

		if ((data[begin + 3] & 0x0f) != 0x0f) {
			s0.append(data[begin + 3] & 0x0f);
		} else
			return s0.toString();

		if ((data[begin + 3] & 0xf0) != 0xf0) {
			s0.append((int) (data[begin + 3] & 0xf0) >> 4);
		} else
			return s0.toString();
		if ((data[begin + 4] & 0x0f) != 0x0f) {
			s0.append(data[begin + 4] & 0x0f);
		} else
			return s0.toString();
		if ((data[begin + 4] & 0xf0) != 0xf0) {
			s0.append((int) (data[begin + 4] & 0xf0) >> 4);
		} else
			return s0.toString();
		if ((data[begin + 5] & 0x0f) != 0x0f) {
			s0.append(data[begin + 5] & 0x0f);
		} else
			return s0.toString();
		if ((data[begin + 5] & 0xf0) != 0xf0) {
			s0.append((int) (data[begin + 5] & 0xf0) >> 4);
		} else
			return s0.toString();
		if ((data[begin + 6] & 0x0f) != 0x0f) {
			s0.append(data[begin + 6] & 0x0f);
		} else
			return s0.toString();
		if ((data[begin + 6] & 0xf0) != 0xf0) {
			s0.append((int) (data[begin + 6] & 0xf0) >> 4);
		} else
			return s0.toString();
		if ((data[begin + 7] & 0x0f) != 0x0f) {
			s0.append(data[begin + 7] & 0x0f);
		} else
			return s0.toString();
		if ((data[begin + 7] & 0xf0) != 0xf0) {
			s0.append((int) (data[begin + 7] & 0xf0) >> 4);
		} else
			return s0.toString();
		if ((data[begin + 8] & 0x0f) != 0x0f) {
			s0.append(data[begin + 8] & 0x0f);
		} else
			return s0.toString();
		if ((data[begin + 8] & 0xf0) != 0xf0) {
			s0.append((int) (data[begin + 8] & 0xf0) >> 4);
		}

		return s0.toString();
	}

	public static String getPDP_TYPE(byte[] data) {
		StringBuilder s0 = new StringBuilder();
		if ((data[1] & 0xff) == 0x21 && (data[2] & 0xff) == 0xf1) {
			s0.append("IPV4_");
		} else if ((data[1] & 0xff) == 0x57 && (data[2] & 0xff) == 0xf1) {
			s0.append("IPV6_");
		} else if ((data[1] & 0xff) == 0x00 && (data[2] & 0xff) == 0xf0) {
			s0.append("X25_");
		} else {
			return "ErrPDP";
		}
		return s0.toString();
	}

	public static String getPDP_ADDRESS(byte[] data) {
		StringBuilder s0 = new StringBuilder();
		s0.append(StringUtil.toString(data[4]));
		s0.append(".");
		s0.append(StringUtil.toString(data[5]));
		s0.append(".");
		s0.append(StringUtil.toString(data[6]));
		s0.append(".");
		s0.append(StringUtil.toString(data[7]));
		return s0.toString();
	}

	public static String getQOSP(byte[] data) {
		StringBuilder s0 = new StringBuilder();
		s0.append(StringUtil.toString(data[24]));
		return s0.toString();
	}

	public static String getALLOCATION_CLASS(byte[] data) {
		StringBuilder s0 = new StringBuilder();
		s0.append(StringUtil.toString(data[25]));
		return s0.toString();
	}

	public static String get03B_OTHERS(byte[] data) {
		StringBuilder s0 = new StringBuilder();
		s0.append(StringUtil.toString(data[26]));
		s0.append("_");
		s0.append(StringUtil.toString(data[27]));
		return s0.toString();
	}

	public static String getAPN(byte[] data) {
		StringBuilder s0 = new StringBuilder();
		for (int i = 1; i < 63; i++) {
			if ((data[i] & 0xff) != 0x00) {
				if (i != 1) {
					s0.append(".");
				}
				int length = data[i] & 0xff;
				i += length;
				while (length > 0) {
					s0.append((char) data[i - length + 1]);
					length--;
				}
			} else
				break;
		}
		return s0.toString();
	}

	public static String getDP(byte b) {
		if ((b & 0xff) == 0x02) {
			return "OCI";
		} else if ((b & 0xff) == 0x0c) {
			return "TTTAA";
		}
		return "ErrDP";
	}

	public static String getSERVICE_KEY(byte b) {
		return "" + (b & 0xff);
	}

	public static String getDEFCH(byte b) {
		if ((b & 0xff) == 0x00) {
			return "CONTINUE";
		} else if ((b & 0xff) == 0x01) {
			return "RELEASE";
		}
		return "ErrDEFCH";
	}

	public static String getTIME(byte[] data, int begin) {
		StringBuilder s0 = new StringBuilder();
		s0.append(StringUtil.leftPad(Integer
				.toHexString(data[begin + 7] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer
				.toHexString(data[begin + 6] & 0xff), 2, '0'));
		s0.append("-");
		s0.append(StringUtil.leftPad(Integer
				.toHexString(data[begin + 5] & 0xff), 2, '0'));
		s0.append("-");
		s0.append(StringUtil.leftPad(Integer
				.toHexString(data[begin + 4] & 0xff), 2, '0'));
		s0.append(" ");
		s0.append(StringUtil.leftPad(Integer
				.toHexString(data[begin + 3] & 0xff), 2, '0'));
		s0.append(":");
		s0.append(StringUtil.leftPad(Integer
				.toHexString(data[begin + 2] & 0xff), 2, '0'));
		s0.append(":");
		s0.append(StringUtil.leftPad(Integer
				.toHexString(data[begin + 1] & 0xff), 2, '0'));
		s0.append(".");
		s0.append(StringUtil.leftPad(Integer.toHexString(data[begin] & 0xff),
				2, '0'));
		if (s0.length() > 0) {
			return s0.toString();
		} else {
			return "ErrTIME";
		}
	}

	public static String getT002(byte data[]) {
		StringBuilder s0 = new StringBuilder();

		s0.append(StringUtil.leftPad(Integer.toHexString(data[0] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[1] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[2] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[3] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[4] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[5] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[6] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[7] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[8] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[9] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[10] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[11] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[12] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[13] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[14] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[15] & 0xff), 2, '0'));
		s0.append(" CFU");
		if((data[16]&0x0f)!=0x0f){s0.append(data[16] & 0x0f);}else s0.append("f");
		if((data[16]&0xf0)!=0xf0){s0.append((data[16]&0xf0)>>4);}else s0.append("f");
		if((data[17]&0x0f)!=0x0f){s0.append(data[17] & 0x0f);}else s0.append("f");
		if((data[17]&0xf0)!=0xf0){s0.append((data[17]&0xf0)>>4);}else s0.append("f");
		if((data[18]&0x0f)!=0x0f){s0.append(data[18] & 0x0f);}else s0.append("f");
		if((data[18]&0xf0)!=0xf0){s0.append((data[18]&0xf0)>>4);}else s0.append("f");
		if((data[19]&0x0f)!=0x0f){s0.append(data[19] & 0x0f);}else s0.append("f");
		if((data[19]&0xf0)!=0xf0){s0.append((data[19]&0xf0)>>4);}else s0.append("f");
		if((data[20]&0x0f)!=0x0f){s0.append(data[20] & 0x0f);}else s0.append("f");
		if((data[20]&0xf0)!=0xf0){s0.append((data[20]&0xf0)>>4);}else s0.append("f");
		if((data[21]&0x0f)!=0x0f){s0.append(data[21] & 0x0f);}else s0.append("f");
		if((data[21]&0xf0)!=0xf0){s0.append((data[21]&0xf0)>>4);}else s0.append("f");
		if((data[22]&0x0f)!=0x0f){s0.append(data[22] & 0x0f);}else s0.append("f");
		if((data[22]&0xf0)!=0xf0){s0.append((data[22]&0xf0)>>4);}else s0.append("f");
		if((data[23]&0x0f)!=0x0f){s0.append(data[23] & 0x0f);}else s0.append("f");
		if((data[23]&0xf0)!=0xf0){s0.append((data[23]&0xf0)>>4);}else s0.append("f");
		if((data[24]&0x0f)!=0x0f){s0.append(data[24] & 0x0f);}else s0.append("f");
		if((data[24]&0xf0)!=0xf0){s0.append((data[24]&0xf0)>>4);}else s0.append("f");
		
		s0.append(StringUtil.leftPad(Integer.toHexString(data[25] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[26] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[27] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[28] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[29] & 0xff), 2, '0'));
		s0.append("CFB");
		if((data[30]&0x0f)!=0x0f){s0.append(data[30] & 0x0f);}else s0.append("f");
		if((data[30]&0xf0)!=0xf0){s0.append((data[30]&0xf0)>>4);}else s0.append("f");
		if((data[31]&0x0f)!=0x0f){s0.append(data[31] & 0x0f);}else s0.append("f");
		if((data[31]&0xf0)!=0xf0){s0.append((data[31]&0xf0)>>4);}else s0.append("f");
		if((data[32]&0x0f)!=0x0f){s0.append(data[32] & 0x0f);}else s0.append("f");
		if((data[32]&0xf0)!=0xf0){s0.append((data[32]&0xf0)>>4);}else s0.append("f");
		if((data[33]&0x0f)!=0x0f){s0.append(data[33] & 0x0f);}else s0.append("f");
		if((data[33]&0xf0)!=0xf0){s0.append((data[33]&0xf0)>>4);}else s0.append("f");
		if((data[34]&0x0f)!=0x0f){s0.append(data[34] & 0x0f);}else s0.append("f");
		if((data[34]&0xf0)!=0xf0){s0.append((data[34]&0xf0)>>4);}else s0.append("f");
		if((data[35]&0x0f)!=0x0f){s0.append(data[35] & 0x0f);}else s0.append("f");
		if((data[35]&0xf0)!=0xf0){s0.append((data[35]&0xf0)>>4);}else s0.append("f");
		if((data[36]&0x0f)!=0x0f){s0.append(data[36] & 0x0f);}else s0.append("f");
		if((data[36]&0xf0)!=0xf0){s0.append((data[36]&0xf0)>>4);}else s0.append("f");
		if((data[37]&0x0f)!=0x0f){s0.append(data[37] & 0x0f);}else s0.append("f");
		if((data[37]&0xf0)!=0xf0){s0.append((data[37]&0xf0)>>4);}else s0.append("f");
		if((data[38]&0x0f)!=0x0f){s0.append(data[38] & 0x0f);}else s0.append("f");
		if((data[38]&0xf0)!=0xf0){s0.append((data[38]&0xf0)>>4);}else s0.append("f");
		
		s0.append(StringUtil.leftPad(Integer.toHexString(data[39] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[40] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[41] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[42] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[43] & 0xff), 2, '0'));
		s0.append("CFNA");
		if((data[44]&0x0f)!=0x0f){s0.append(data[44] & 0x0f);}else s0.append("f");
		if((data[44]&0xf0)!=0xf0){s0.append((data[44]&0xf0)>>4);}else s0.append("f");
		if((data[45]&0x0f)!=0x0f){s0.append(data[45] & 0x0f);}else s0.append("f");
		if((data[45]&0xf0)!=0xf0){s0.append((data[45]&0xf0)>>4);}else s0.append("f");
		if((data[46]&0x0f)!=0x0f){s0.append(data[46] & 0x0f);}else s0.append("f");
		if((data[46]&0xf0)!=0xf0){s0.append((data[46]&0xf0)>>4);}else s0.append("f");
		if((data[47]&0x0f)!=0x0f){s0.append(data[47] & 0x0f);}else s0.append("f");
		if((data[47]&0xf0)!=0xf0){s0.append((data[47]&0xf0)>>4);}else s0.append("f");
		if((data[48]&0x0f)!=0x0f){s0.append(data[48] & 0x0f);}else s0.append("f");
		if((data[48]&0xf0)!=0xf0){s0.append((data[48]&0xf0)>>4);}else s0.append("f");
		if((data[49]&0x0f)!=0x0f){s0.append(data[49] & 0x0f);}else s0.append("f");
		if((data[49]&0xf0)!=0xf0){s0.append((data[49]&0xf0)>>4);}else s0.append("f");
		if((data[50]&0x0f)!=0x0f){s0.append(data[50] & 0x0f);}else s0.append("f");
		if((data[50]&0xf0)!=0xf0){s0.append((data[50]&0xf0)>>4);}else s0.append("f");
		if((data[51]&0x0f)!=0x0f){s0.append(data[51] & 0x0f);}else s0.append("f");
		if((data[51]&0xf0)!=0xf0){s0.append((data[51]&0xf0)>>4);}else s0.append("f");
		if((data[52]&0x0f)!=0x0f){s0.append(data[52] & 0x0f);}else s0.append("f");
		if((data[52]&0xf0)!=0xf0){s0.append((data[52]&0xf0)>>4);}else s0.append("f");
		
		s0.append(StringUtil.leftPad(Integer.toHexString(data[53] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[54] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[55] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[56] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[57] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[58] & 0xff), 2, '0'));
		s0.append("CFNR");
		if((data[59]&0x0f)!=0x0f){s0.append(data[59] & 0x0f);}else s0.append("f");
		if((data[59]&0xf0)!=0xf0){s0.append((data[59]&0xf0)>>4);}else s0.append("f");
		if((data[60]&0x0f)!=0x0f){s0.append(data[60] & 0x0f);}else s0.append("f");
		if((data[60]&0xf0)!=0xf0){s0.append((data[60]&0xf0)>>4);}else s0.append("f");
		if((data[61]&0x0f)!=0x0f){s0.append(data[61] & 0x0f);}else s0.append("f");
		if((data[61]&0xf0)!=0xf0){s0.append((data[61]&0xf0)>>4);}else s0.append("f");
		if((data[62]&0x0f)!=0x0f){s0.append(data[62] & 0x0f);}else s0.append("f");
		if((data[62]&0xf0)!=0xf0){s0.append((data[62]&0xf0)>>4);}else s0.append("f");
		if((data[63]&0x0f)!=0x0f){s0.append(data[63] & 0x0f);}else s0.append("f");
		if((data[63]&0xf0)!=0xf0){s0.append((data[63]&0xf0)>>4);}else s0.append("f");
		if((data[64]&0x0f)!=0x0f){s0.append(data[64] & 0x0f);}else s0.append("f");
		if((data[64]&0xf0)!=0xf0){s0.append((data[64]&0xf0)>>4);}else s0.append("f");
		if((data[65]&0x0f)!=0x0f){s0.append(data[65] & 0x0f);}else s0.append("f");
		if((data[65]&0xf0)!=0xf0){s0.append((data[65]&0xf0)>>4);}else s0.append("f");
		if((data[66]&0x0f)!=0x0f){s0.append(data[66] & 0x0f);}else s0.append("f");
		if((data[66]&0xf0)!=0xf0){s0.append((data[66]&0xf0)>>4);}else s0.append("f");
		if((data[67]&0x0f)!=0x0f){s0.append(data[67] & 0x0f);}else s0.append("f");
		if((data[67]&0xf0)!=0xf0){s0.append((data[67]&0xf0)>>4);}else s0.append("f");
		
		s0.append(StringUtil.leftPad(Integer.toHexString(data[68] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[69] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[70] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[71] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[72] & 0xff), 2, '0'));
		s0.append("OCCF");
		if((data[73]&0x0f)!=0x0f){s0.append(data[73] & 0x0f);}else s0.append("f");
		if((data[73]&0xf0)!=0xf0){s0.append((data[73]&0xf0)>>4);}else s0.append("f");
		if((data[74]&0x0f)!=0x0f){s0.append(data[74] & 0x0f);}else s0.append("f");
		if((data[74]&0xf0)!=0xf0){s0.append((data[74]&0xf0)>>4);}else s0.append("f");
		if((data[75]&0x0f)!=0x0f){s0.append(data[75] & 0x0f);}else s0.append("f");
		if((data[75]&0xf0)!=0xf0){s0.append((data[75]&0xf0)>>4);}else s0.append("f");
		if((data[76]&0x0f)!=0x0f){s0.append(data[76] & 0x0f);}else s0.append("f");
		if((data[76]&0xf0)!=0xf0){s0.append((data[76]&0xf0)>>4);}else s0.append("f");
		if((data[77]&0x0f)!=0x0f){s0.append(data[77] & 0x0f);}else s0.append("f");
		if((data[77]&0xf0)!=0xf0){s0.append((data[77]&0xf0)>>4);}else s0.append("f");
		if((data[78]&0x0f)!=0x0f){s0.append(data[78] & 0x0f);}else s0.append("f");
		if((data[78]&0xf0)!=0xf0){s0.append((data[78]&0xf0)>>4);}else s0.append("f");
		if((data[79]&0x0f)!=0x0f){s0.append(data[79] & 0x0f);}else s0.append("f");
		if((data[79]&0xf0)!=0xf0){s0.append((data[79]&0xf0)>>4);}else s0.append("f");
		if((data[80]&0x0f)!=0x0f){s0.append(data[80] & 0x0f);}else s0.append("f");
		if((data[80]&0xf0)!=0xf0){s0.append((data[80]&0xf0)>>4);}else s0.append("f");
		if((data[81]&0x0f)!=0x0f){s0.append(data[81] & 0x0f);}else s0.append("f");
		if((data[81]&0xf0)!=0xf0){s0.append((data[81]&0xf0)>>4);}else s0.append("f");
		
		s0.append(StringUtil.leftPad(Integer.toHexString(data[82] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[83] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[84] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[85] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[86] & 0xff), 2, '0'));
		s0.append(StringUtil.leftPad(Integer.toHexString(data[87] & 0xff), 2, '0'));
		return s0.toString();
	}

}
