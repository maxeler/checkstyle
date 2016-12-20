package com.puppycrawl.tools.checkstyle.checks;

import com.puppycrawl.tools.checkstyle.api.*;

public class CommaAtEndCheck extends AbstractCheck {

	@Override
	public int[] getDefaultTokens() {		
		//On what nodes to run check
		return new int[]{TokenTypes.METHOD_DEF};
	}
	
	@Override
    public void visitToken(DetailAST ast) {
        // find the PARAMETERS node below the METHOD_DEF
        DetailAST methodBlock = ast.findFirstToken( TokenTypes.PARAMETERS);
        // Check if last node is COMMA type
        if (methodBlock == null) {
        	return;
        }
        
        if (methodBlock.getLastChild() != null && methodBlock.getLastChild().getType() == TokenTypes.COMMA) {
        	String message = "There should be no comma at the end of function parameters ";
            log(ast.getLineNo(), message);
        }
    }        
}
