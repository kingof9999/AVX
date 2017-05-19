package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.CheckData;
import common.CheckDbConnection;
import form.StokForm;
import model.bean.Stok;
import model.bo.StokBO;

/**
 * GetInfoStokAction
 * 
 * Version 1.0
 * 
 * Date: 18/05/2017
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE				AUTHOR			DECRIPTION
 * -------------------------------------------
 * 18/05/2017		TinLQ			Create
 */
public class GetInfoStokAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//call form StokForm to use
		StokForm stokForm = (StokForm) form;
		//call class AcyionErrors to use
		ActionErrors actionErrors = new ActionErrors();
		//check database connection
		if(!CheckDbConnection.checkConnect()){
			//add message error
			actionErrors.add("dbError", new ActionMessage("error.db.connectDatabase"));
			saveErrors(request, actionErrors);
			//return to error page
			return mapping.findForward("loi");
		} else {
			//call class StokBO to use
			StokBO stokBO = new StokBO();
			//call class Stok to use
			Stok stok;
			//call iTEMMSTOK from stokForm
			String iTEMMSTOK = stokForm.getiTEMMSTOK();
			//try catch to get message from throw Exception
			try {
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
			} catch (Exception e) {
				if(e.getMessage() == null){
					//add message error
					actionErrors.add("nullStokError", new ActionMessage("error.getStok.nullValue"));
					saveErrors(request, actionErrors);
					//return updateJ1JR.jsp
					return mapping.findForward("upDate");
				} else {
					//add message error
					actionErrors.add("sqlError", new ActionMessage("error.getStok.sqlError"));
					saveErrors(request, actionErrors);
					//return error page
					System.out.println(e.getMessage());
					return mapping.findForward("loi");
				}
			}
			//try catch to get message from throw Exception
			try {
				//check iTEMMMKCD
				stok = stokBO.checkITEMMMKCD(iTEMMSTOK);
				//set element mAKERDATA from Stok Bean to form
				stokForm.setmAKERDATA(stok.getmAKERDATA());
			} catch (Exception e) {
				return mapping.findForward("loi");
			}
			//try catch to get message from throw Exception
			try {
				//check iTEMMSYCD
				stok = stokBO.checkITEMMSYCD(iTEMMSTOK);
				//set element cARNMNAME from Stok Bean to form
				stokForm.setcARNMNAME(stok.getcARNMNAME());
			} catch (Exception e) {
				return mapping.findForward("loi");
			}
			//return to update jsp
			return mapping.findForward("thanhCong");
		}
	}
}
