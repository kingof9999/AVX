package common;

/**
 * CheckData
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
public class CheckData {
	/**
	 * Checking full-width character is included in string.
	 * If full-width character is included in string,
	 * it will return true.
	 * If is not, it will return false.
	 * @param cmdl
	 * @return
	 */
	public boolean isContainFullSize(String cmdl) {
	    boolean isFullSize = false;
	    for (char c : cmdl.toCharArray()) {
	        if(!isHalfSize(c)) {
	        	isFullSize = true;
	            break;
	        }
	    }

	    return isFullSize;
	}
	
	/**
	 * Checking character is half-width or not.
	 * Unicode value of half-width range:
	 * '\u0000' - '\u00FF'
	 * '\uFF61' - '\uFFDC'
	 * '\uFFE8' - '\uFFEE'
	 * If unicode value of character is within this range,
	 * it will be half-width character.
	 * @param c
	 * @return
	 */
	public static boolean isHalfSize(char c)
	{
	    return '\u0000' <= c && c <= '\u00FF'
	        || '\uFF61' <= c && c <= '\uFFDC'
	        || '\uFFE8' <= c && c <= '\uFFEE' ;
	}
}
