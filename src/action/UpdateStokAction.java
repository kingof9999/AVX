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
import model.bo.StokBO;

public class UpdateStokAction extends Action{

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
			//call class common CheckData to use
			CheckData checkData = new CheckData();
			//call iTEMMSTOK from stokForm
			String iTEMMSTOK = stokForm.getiTEMMSTOK();
			//call iTEMMSKCD from stokForm
			String iTEMMSKCD = stokForm.getiTEMMSKCD();
			boolean checkSize = false;
			//try catch to catch exception from checkData
			try {
				//check iTEMMSKCD is half-size or not
				checkSize = checkData.isContainFullSize(iTEMMSKCD);
			} catch (Exception e) {
				//add message error
				actionErrors.add("reloadPageError", new ActionMessage("error.update.reloadPageError"));
				saveErrors(request, actionErrors);
				//return to updateJ1JR.jsp
				return mapping.findForward("upDate");
			}
			//if else for checkSize
			if(checkSize){
				//add message error
				actionErrors.add("updateHalfSizeError", new ActionMessage("error.update.halfsize"));
				saveErrors(request, actionErrors);
				//return to updateJ1JR.jsp
				return mapping.findForward("upDate");
			} else {
				//call class StokBO to use
				StokBO stokBO = new StokBO();
				boolean checkExist;
				//try catch to catch error exception
				try {
					//check exist in database
					checkExist = stokBO.isExistITEMMSKCD(iTEMMSTOK,iTEMMSKCD);
				} catch (Exception e) {
					//add message error
					actionErrors.add("sqlUpdateError", new ActionMessage("error.update.sqlError"));
					saveErrors(request, actionErrors);
					//return to error page
					return mapping.findForward("loi");
				}
				//check exist iTEMMSKCD to update
				if(checkExist){
					//add message error
					actionErrors.add("existError", new ActionMessage("error.update.existError"));
					saveErrors(request, actionErrors);
					//return to updateJ1JR.jsp
					return mapping.findForward("upDate");
				} else {
					//add message
					actionErrors.add("updateSuccess", new ActionMessage("message.update.successUpdate"));
					saveErrors(request, actionErrors);
					//try catch to catch error exception
					try {
						//update method (update iTEMMSKCD to server)
						stokBO.updateInfoStok(iTEMMSTOK,iTEMMSKCD);
					} catch (Exception e) {
						//add message error
						actionErrors.add("sqlUpdateError", new ActionMessage("error.update.sqlError"));
						saveErrors(request, actionErrors);
						//return to error page
						return mapping.findForward("loi");
					}
					//return to update page
					return mapping.findForward("thanhCong");
				}
			}
		}
	}
	
}
