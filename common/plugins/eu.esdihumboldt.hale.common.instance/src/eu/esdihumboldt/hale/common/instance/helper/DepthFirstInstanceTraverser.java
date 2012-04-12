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

package eu.esdihumboldt.hale.common.instance.helper;

import javax.xml.namespace.QName;

import eu.esdihumboldt.hale.common.instance.model.Group;
import eu.esdihumboldt.hale.common.instance.model.Instance;

/**
 * Instance traverser that traverses the model depth first.
 * @author Simon Templer
 */
public class DepthFirstInstanceTraverser implements InstanceTraverser {
	
	private final boolean cancelChildTraversalOnly;

	/**
	 * Creates a depth first instance traverser.
	 */
	public DepthFirstInstanceTraverser() {
		this(false);
	}

	/**
	 * Creates a depth first instance traverser.
	 * @param cancelChildTraversalOnly if when the callback cancels the traversal,
	 *   only the traversal of the children should be canceled (meaning traversal
	 *   is continued but not down from the current object)
	 */
	public DepthFirstInstanceTraverser(boolean cancelChildTraversalOnly) {
		super();
		this.cancelChildTraversalOnly = cancelChildTraversalOnly;
	}

	/**
	 * @see InstanceTraverser#traverse(Instance, InstanceTraversalCallback)
	 */
	@Override
	public boolean traverse(Instance instance, InstanceTraversalCallback callback) {
		return traverse(instance, callback, null);
	}

	private boolean traverse(Instance instance,
			InstanceTraversalCallback callback, QName name) {
		if (callback.visit(instance, name)) {
			// traverse value (if applicable)
			Object value = instance.getValue();
			if (value != null) {
				 if (!traverse(value, callback, name)) {
					 if (!cancelChildTraversalOnly) {
						 // cancel whole traversal
						 return false;
					 }
					 else {
						 // only skip traversing children
						 return true;
					 }
				 }
			}
			
			// traverse children
			return traverseChildren(instance, callback);
		}
		else if (!cancelChildTraversalOnly) {
			// cancel whole traversal
			return false;
		} else {
			// only skipped traversing the current instance
			return true;
		}
	}

	/**
	 * @see InstanceTraverser#traverse(Group, InstanceTraversalCallback)
	 */
	@Override
	public boolean traverse(Group group, InstanceTraversalCallback callback) {
		return traverse(group, callback, null);
	}

	private boolean traverse(Group group, InstanceTraversalCallback callback,
			QName name) {
		if (callback.visit(group, name)) {
			// traverse children
			return traverseChildren(group, callback);
		}
		else if (!cancelChildTraversalOnly) {
			// cancel whole traversal
			return false;
		} else {
			// only skipped traversing the current group
			return true;
		}
	}

	/**
	 * Traverse the children of a given group.
	 * @param group the group
	 * @param callback the traversal callback
	 * @return if traversal shall be continued
	 */
	protected boolean traverseChildren(Group group, InstanceTraversalCallback callback) {
		for (QName name : group.getPropertyNames()) {
			Object[] values = group.getProperty(name);
			if (values != null) {
				for (Object value : values) {
					if (!traverse(value, callback, name)) {
						if (!cancelChildTraversalOnly) {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}

	/**
	 * @see InstanceTraverser#traverse(Object, InstanceTraversalCallback)
	 */
	@Override
	public boolean traverse(Object value, InstanceTraversalCallback callback) {
		return traverse(value, callback, null);
	}

	private boolean traverse(Object value, InstanceTraversalCallback callback,
			QName name) {
		if (value instanceof Instance) {
			return traverse((Instance) value, callback, name);
		}
		if (value instanceof Group) {
			return traverse((Group) value, callback, name);
		}
		
		return callback.visit(value, name);
	}

}
