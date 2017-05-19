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

	public Stok checkITEMMSYCD(String iTEMMSTOK) throws Exception {
		return stokDAO.checkITEMMSYCD(iTEMMSTOK);
	}

	public boolean isExistITEMMSKCD(String iTEMMSTOK, String iTEMMSKCD) throws Exception {
		return stokDAO.isExistITEMMSKCD(iTEMMSTOK,iTEMMSKCD);
	}

	public void updateInfoStok(String iTEMMSTOK, String iTEMMSKCD) throws Exception {
		stokDAO.updateInfoStok(iTEMMSTOK,iTEMMSKCD);
	}

}
