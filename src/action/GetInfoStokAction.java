package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.StokForm;
import model.bean.Stok;
import model.bo.StokBO;

public class GetInfoStokAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//call form StokForm to use
		StokForm stokForm = (StokForm) form;
		//call class StokBO to use
		StokBO stokBO = new StokBO();
		//call class Stok to use
		Stok stok;
		//call iTEMMSTOK from stokForm
		String iTEMMSTOK = stokForm.getiTEMMSTOK();
		//check iTEMMMKCD
		stok = stokBO.checkITEMMMKCD(iTEMMSTOK);
		//set element mAKERDATA from Stok Bean to form
		stokForm.setmAKERDATA(stok.getmAKERDATA());
		//get information of stok
		stok = stokBO.getInfoStok(iTEMMSTOK);
		//set each element from Stok Bean to form
		stokForm.setiTEMMSTOK(stok.getiTEMMSTOK());
		stokForm.setiTEMMSKCD(stok.getiTEMMSKCD());
		stokForm.setiTEMMTNTO(stok.getiTEMMTNTO());
		stokForm.seteMPFLEMPNM(stok.geteMPFLEMPNM());
		stokForm.setdCCFLNAME(stok.getdCCFLNAME());
		stokForm.setiTEMMHNME(stok.getiTEMMHNME());
		stokForm.setiTEMMMKCD(stok.getiTEMMMKCD());
		stokForm.setiTEMMSYCD(stok.getiTEMMSYCD());
		stokForm.setiTEMMTNKMK(stok.getiTEMMTNKMK());
		stokForm.setiTEMMPART(stok.getiTEMMPART());
		//return to update jsp
		return mapping.findForward("thanhCong");
	}
	
}
