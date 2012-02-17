/*
 * Syntax.java
 * 
 * Copyright (c) 2012 Aftab Naveed <aftabnaveed@gmail.com>. 
 * 
 * This file is part of Flow3 Netbeans Plugin.
 * 
 * Flow3 Netbeans Plugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Flow3 Netbeans Plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Flow3 Netbeans Plugin.  If not, see <http ://www.gnu.org/licenses/>.
 */
package org.netbeans.modules.php.flow3.fluid.lexer.syntax;

import org.netbeans.spi.lexer.LexerInput;

/**
 *
 * @author Aftab Naveed <aftabnaveed@gmail.com>
 */
public abstract class Syntax {
    
    
    abstract public boolean isOpening(LexerInput input);

    abstract public boolean isOpening(String string);

    abstract public boolean isClosing(LexerInput input);

    abstract public boolean whitespaceAllowed();

    abstract public boolean startsWith(String string);

    abstract public String opening();

    abstract public String closing();
}
