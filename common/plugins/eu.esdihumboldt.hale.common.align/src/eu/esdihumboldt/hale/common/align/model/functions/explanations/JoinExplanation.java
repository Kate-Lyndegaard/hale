/*
 * HUMBOLDT: A Framework for Data Harmonisation and Service Integration.
 * EU Integrated Project #030962                 01.10.2006 - 30.09.2010
 * 
 * For more information on the project, please refer to the this web site:
 * http://www.esdi-humboldt.eu
 * 
 * LICENSE: For information on the license under which this program is 
 * available, please refer to http:/www.esdi-humboldt.eu/license.html#core
 * (c) the HUMBOLDT Consortium, 2007 to 2011.
 */

package eu.esdihumboldt.hale.common.align.model.functions.explanations;

import eu.esdihumboldt.hale.common.align.model.Cell;
import eu.esdihumboldt.hale.common.align.model.functions.JoinFunction;
import eu.esdihumboldt.hale.common.align.model.impl.AbstractCellExplanation;

/**
 * Explanation for join function cells.
 * 
 * @author Kai Schwierczek
 */
public class JoinExplanation extends AbstractCellExplanation implements JoinFunction {
	/**
	 * @see eu.esdihumboldt.hale.common.align.model.impl.AbstractCellExplanation#getExplanation(eu.esdihumboldt.hale.common.align.model.Cell, boolean)
	 */
	@Override
	protected String getExplanation(Cell cell, boolean html) {
		return null;
	}
}