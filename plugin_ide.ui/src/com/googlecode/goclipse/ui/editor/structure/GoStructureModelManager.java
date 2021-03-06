/*******************************************************************************
 * Copyright (c) 2015, 2015 Bruno Medeiros and other Contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package com.googlecode.goclipse.ui.editor.structure;

import melnorme.lang.ide.ui.editor.structure.StructureModelManager;
import melnorme.lang.tooling.ElementAttributes;
import melnorme.lang.tooling.ast.SourceRange;
import melnorme.lang.tooling.structure.IStructureElement;
import melnorme.lang.tooling.structure.SourceFileStructure;
import melnorme.lang.tooling.structure.StructureElement;
import melnorme.lang.tooling.structure.StructureElementKind;
import melnorme.utilbox.collections.ArrayList2;
import melnorme.utilbox.misc.Location;

public class GoStructureModelManager extends StructureModelManager {
	
	public GoStructureModelManager() {
	}
	
	@Override
	protected StructureUpdateTask createStructureUpdateTask(Location location, String source) {
		return new StructureUpdateTask(location, source) {
			@Override
			protected SourceFileStructure createSourceFileStructure() {
				SourceRange sr = new SourceRange(0, source.length());
				StructureElement element = new StructureElement("NOT_IMPLEMENTED", sr, sr, 
					StructureElementKind.MODULEDEC, new ElementAttributes(null), null, null);
				return new SourceFileStructure(location, new ArrayList2<IStructureElement>(element));
			}
		};
	}
	
}