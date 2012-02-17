/*
 * FluidSyntax.java
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
public class FluidSyntax extends Syntax {

    private static FluidSyntax instance = new FluidSyntax();

    private FluidSyntax() {
    }

    public static FluidSyntax getInstance() {
        return instance;
    }

    @Override
    public boolean isOpening(LexerInput input) {

        input.backup(1);
        String del = "";
        del += (char) input.read();
        del += (char) input.read();
        input.backup(1);
        return isOpening(del);
    }

    @Override
    public boolean isOpening(String string) {
        boolean res = string.startsWith("{");

        if (string.length() != 2) {
            return res;
        }

        char c = string.charAt(1);
        if (c != ' ' && c != '\r' && c != '\n' && c != '\'' && c != '"' && c != '{' && c != '}') {
            return res;
        }
        return false;
    }

    @Override
    public boolean isClosing(LexerInput input) {
        input.backup(1);
        if (input.read() == '}') {
            return true;
        }
        return false;
    }

    @Override
    public boolean whitespaceAllowed() {
        return false;
    }

    @Override
    public boolean startsWith(String string) {
        return string.startsWith("{");
    }

    @Override
    public String opening() {
        return "{";
    }

    @Override
    public String closing() {
        return "}";
    }
}
