package model.bo;

import model.bean.Stok;
import model.dao.StokDAO;

public class StokBO {
	StokDAO stokDAO = new StokDAO();

	public Stok getInfoStok(String iTEMMSTOK) throws Exception {
		return stokDAO.getInfoStok(iTEMMSTOK);
	}

	public Stok checkITEMMMKCD(String iTEMMSTOK) throws Exception {
		return stokDAO.checkITEMMMKCD(iTEMMSTOK);
	}

}
