package common;

import model.dao.DBConnection;

/**
 * CheckDbConnection
 * 
 * Version 1.0
 * 
 * Date: 06/05/2017
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE				AUTHOR			DECRIPTION
 * -------------------------------------------
 * 06/05/2017		TinLQ			Create
 */
public class CheckDbConnection {
	
	/**
	 * Check connection of database
	 * @return
	 */
	public static boolean checkConnect(){
		return DBConnection.getConnect() != null;
	}
}
