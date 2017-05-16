package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.bean.Stok;

public class StokDAO {
	//call class DBconnection to use
	DBConnection connect = new DBConnection();
	//set method getConnect() from DBconnection class to use Connection
	Connection conn = DBConnection.getConnect();
	Statement stmt;
	
	public Stok getInfoStok(String iTEMMSTOK) throws Exception {
		//select data from table PUBLIC_CALENDAR
		String sql = String
				.format("SELECT AUTITEMM.*, AUTEMPFL.EMPFL_EMPNM, AUTDCCFL.DCCFL_NAME"
						+" FROM AUTITEMM, AUTEMPFL, AUTDCCFL"
						+" WHERE AUTEMPFL.EMPFL_EMPNO = AUTITEMM.ITEMM_STOK"
						+" 	AND AUTDCCFL.DCCFL_DCCD1 = AUTITEMM.ITEMM_STOK"
						+" 	AND ITEMM_STOK LIKE '1'"
						+" 	AND (ITEMM_HNKB = 0 OR ITEMM_HNKB = 1)", iTEMMSTOK);
		ResultSet rs;
		//catch error and throw
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			//throw exception if error
			throw new Exception("Error occur: "+e.getMessage());
		}
		Stok stok = null;
		try {
			//check delete have action
			if(rs.next()){
				stok = new Stok();
				stok.setiTEMMSTOK(iTEMMSTOK);
				stok.setiTEMMSKCD(rs.getString("ITEMM_SKCD"));
				stok.setiTEMMTNTO(rs.getString("ITEMM_TNTO1")+rs.getString("ITEMM_TNTO2"));
				stok.seteMPFLEMPNM(rs.getString("EMPFL_EMPNM"));
				stok.setdCCFLNAME(rs.getString("DCCFL_NAME"));
				stok.setiTEMMHNME(rs.getString("ITEMM_HNME"));		
				stok.setiTEMMMKCD(rs.getString("ITEMM_MKCD"));
				stok.setiTEMMSYCD(rs.getString("ITEMM_SYCD"));
				stok.setiTEMMTNKMK(rs.getString("ITEMM_TNKMK"));
				stok.setiTEMMPART(rs.getInt("ITEMM_PART"));
			}
		} catch (Exception e) {
			throw new Exception("Error occur: "+e.getMessage());
		} finally {
			DBConnection.disConnect();
		}
		return stok;
	}

	public Stok checkITEMMMKCD(String iTEMMSTOK) throws Exception {
		//select data from table PUBLIC_CALENDAR
		String sql = String
				.format("SELECT m.MAKER_DATA"
						+" FROM AUTITEMM i"
						+" INNER JOIN AUTMAKER m ON i.ITEMM_STOK = '%s' AND i.ITEMM_STOK = m.MAKER_ID", iTEMMSTOK);
		ResultSet rs;
		//catch error and throw
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			//throw exception if error
			throw new Exception("Error occur: "+e.getMessage());
		}
		Stok stok = new Stok();
		try {
			//check delete have action
			if(rs.next()){
				//set MAKER_DATA to Stok(mAKERDATA) Bean 
				stok.setmAKERDATA(rs.getString("MAKER_DATA"));
			}else{
				//set "指定無し"  to Stok(mAKERDATA) Bean
				stok.setmAKERDATA("指定無し");
			}
		} catch (Exception e) {
			throw new Exception("Error occur: "+e.getMessage());
		} finally {
			DBConnection.disConnect();
		}
		return stok;
	}
}
