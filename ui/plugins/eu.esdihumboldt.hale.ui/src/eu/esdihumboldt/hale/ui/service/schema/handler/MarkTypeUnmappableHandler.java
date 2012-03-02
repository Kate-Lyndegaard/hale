
package eu.esdihumboldt.hale.ui.service.schema.handler;

import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import eu.esdihumboldt.hale.common.align.model.impl.TypeEntityDefinition;
import eu.esdihumboldt.hale.common.schema.SchemaSpaceID;
import eu.esdihumboldt.hale.common.schema.model.TypeDefinition;
import eu.esdihumboldt.hale.ui.service.schema.SchemaService;

/**
 * Handler that removes the mappable flag from a single selected type.
 * 
 * @author Kai Schwierczek
 */
public class MarkTypeUnmappableHandler extends AbstractHandler {
	/**
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection && !selection.isEmpty()) {
			SchemaService schemaService = (SchemaService) PlatformUI.getWorkbench().getService(SchemaService.class);
			TypeDefinition type = ((TypeEntityDefinition) ((IStructuredSelection) selection).getFirstElement()).getDefinition();
			if (schemaService.getSchemas(SchemaSpaceID.SOURCE).getMappingRelevantTypes().contains(type))
				schemaService.toggleMappable(SchemaSpaceID.SOURCE, Collections.singleton(type));
			else
				schemaService.toggleMappable(SchemaSpaceID.TARGET, Collections.singleton(type));
		}

		return null;
	}
}
