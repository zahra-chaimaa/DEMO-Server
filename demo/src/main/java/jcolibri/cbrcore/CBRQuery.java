/**
 * CBRQuery.java
 * jCOLIBRI2 framework. 
 * @author Juan A. Recio-Garc�a.
 * GAIA - Group for Artificial Intelligence Applications
 * http://gaia.fdi.ucm.es
 * 05/01/2007
 */
package jcolibri.cbrcore;

import javax.swing.JOptionPane;

import jcolibri.exception.AttributeAccessException;


/**
 * Represents a CBR query defining it as a description of the problem/case. 
 * Cases are composed by description, solution, justification of solution and result,
 *  so a query is only the description part of a case.
 * This is: a case without solution or result.
 * 
 * @see CBRCase
 */
public class CBRQuery{
	
	CaseComponent description;

	/**
	 * Returns the description component.
	 */
	public CaseComponent getDescription() {
		return description;
	}

	/**
	 * Sets the description component.
	 */
	public void setDescription(CaseComponent description) {
		this.description = description;
	}
	
	/**
	 * Returns the ID value of the Query/Case that is the ID attribute of its description component.
	 */
	public Object getID()
	{
		
		
		if(this.description==null) return null;
			
		else
			try {
				//JOptionPane.showConfirmDialog(null, "valeur : "+description.getIdAttribute().getValue(description).toString());
				return description.getIdAttribute().getValue(description);
				
			} catch (AttributeAccessException e) {
				return null;
			}
	}
	
    public String toString()
    {
    	return "[Description: "+description+"]";
    }
}
