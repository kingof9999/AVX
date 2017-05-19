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
		//select data from table AUTITEMM, AUTEMPFL, AUTDCCFL
		String sql = String
				.format("SELECT AUTITEMM.*, AUTEMPFL.EMPFL_EMPNM, AUTDCCFL.DCCFL_NAME"
						+" FROM AUTITEMM, AUTEMPFL, AUTDCCFL"
						+" WHERE AUTEMPFL.EMPFL_EMPNO = AUTITEMM.ITEMM_EMPNO"
						+" 	AND AUTDCCFL.DCCFL_DCCD1 = AUTITEMM.ITEMM_DCCD1"
						+" 	AND ITEMM_STOK LIKE '%s'"
						+" 	AND (ITEMM_HNKB = 0 OR ITEMM_HNKB = 1)", iTEMMSTOK);
		ResultSet rs;
		Statement stmt = null;
		//catch error and throw
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			//throw exception if error
			throw new Exception("Error occur: "+e.getMessage());
		}
		Stok stok = null;
		try {
			//check exist in database
			if(rs.next()){
				stok = new Stok();
				//set all element to Stok Bean
				stok.setiTEMMSTOK(rs.getString("ITEMM_STOK"));
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
			//close all connect
			rs.close();
			stmt.close();
			DBConnection.disConnect();
		}
		return stok;
	}

	public Stok checkITEMMMKCD(String iTEMMSTOK) throws Exception {
		//select data from table AUTITEMM
		String sql = String
				.format("SELECT m.MAKER_DATA"
						+" FROM AUTITEMM i"
						+" INNER JOIN AUTMAKER m ON i.ITEMM_STOK = '%s' AND i.ITEMM_MKCD = m.MAKER_ID", iTEMMSTOK);
		ResultSet rs;
		Statement stmt = null;
		//catch error and throw
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			//throw exception if error
			throw new Exception("Error occur: "+e.getMessage());
		}
		Stok stok = new Stok();
		try {
			//check exist in database
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
			//close all connect
			rs.close();	
			stmt.close();
			DBConnection.disConnect();
		}
		return stok;
	}

	public Stok checkITEMMSYCD(String iTEMMSTOK) throws Exception {
		//select data from table AUTITEMM
		String sql = String
				.format("SELECT c.CARNM_NAME"
						+" FROM AUTITEMM i"
						+" INNER JOIN AUTCARNM c ON i.ITEMM_STOK = '%s' AND i.ITEMM_SYCD = c.CARNM_SHSYCD", iTEMMSTOK);
		ResultSet rs;
		Statement stmt = null;
		//catch error and throw
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			//throw exception if error
			throw new Exception("Error occur: "+e.getMessage());
		}
		Stok stok = new Stok();
		try {
			//check exist in database
			if(rs.next()){
				//set MAKER_DATA to Stok(mAKERDATA) Bean 
				stok.setcARNMNAME(rs.getString("CARNM_NAME"));
			}else{
				//set "指定無し"  to Stok(mAKERDATA) Bean
				stok.setcARNMNAME("指定無し");
			}
		} catch (Exception e) {
			throw new Exception("Error occur: "+e.getMessage());
		} finally {
			//close all connect
			rs.close();
			stmt.close();
			DBConnection.disConnect();
		}
		return stok;
	}

	public boolean isExistITEMMSKCD(String iTEMMSTOK, String iTEMMSKCD) throws Exception {
		//select data from table AUTITEMM
		String sql = String
				.format("SELECT ITEMM_STOK"
						+" FROM AUTITEMM"
						+" WHERE ITEMM_STOK LIKE '%s' AND ITEMM_SKCD = '%s'", iTEMMSTOK, iTEMMSKCD);
		ResultSet rs;
		Statement stmt = null;
		//catch error and throw
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			//throw exception if error
			throw new Exception("Error occur: "+e.getMessage());
		}
		try {
			//check exist in database
			return rs.next();
		} catch (Exception e) {
			throw new Exception("Error occur: "+e.getMessage());
		} finally {
			//close all connect
			rs.close();
			stmt.close();
			DBConnection.disConnect();
		}
	}

	public void updateInfoStok(String iTEMMSTOK, String iTEMMSKCD) throws Exception {
		//insert data to table
		String sql = String.format("UPDATE AUTITEMM SET ITEMM_SKCD = '%s' WHERE ITEMM_STOK = '%s'", iTEMMSKCD,iTEMMSTOK);
		Statement stmt = null;
		//catch error and throw
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			//throw exception if error
			throw new Exception("Error occur: "+e.getMessage());
		}
		finally {
			//close all connect
			stmt.close();
			DBConnection.disConnect();
		}
	}
}
