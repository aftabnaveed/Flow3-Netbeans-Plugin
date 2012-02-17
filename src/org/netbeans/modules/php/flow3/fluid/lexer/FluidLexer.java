/*
 * FluidLexer.java
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
package org.netbeans.modules.php.flow3.fluid.lexer;

import java.util.ArrayList;
import java.util.List;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerInput;
import org.netbeans.spi.lexer.LexerRestartInfo;
import org.netbeans.spi.lexer.TokenFactory;

/**
 * Lexical Analyzer for Fluid templates
 * 
 * @author Aftab Naveed <aftabnaveed@gmail.com>
 */
class FluidLexer implements Lexer<FluidTokenId> {


    
    enum State {
        OUTER, // out of macro
        AFTER_LD, // after left delimiter {
        AFTER_MACRO, // after macro name {macroName
        IN_FIRST_PARAM, // in the first parameter of macro {macroName first_param
        IN_VAR, // after $ character
        IN_INDEX, // between [] for array index/key
        IN_HELPER, // after helper delimiter |
        IN_HELPER_PARAM, // after |helper:
        IN_PARAMS, // macro parameters (except the first one)
        AFTER_INNER_LD,
        BEFORE_INNER_BRACKETS
    }
    
    private static final int EOF = LexerInput.EOF;
    private final LexerInput input;
 
    private boolean argValue;
    private boolean endTag;
    
    private FluidScanningLexer scanner;
    private TokenFactory<FluidTokenId> tokenFactory;
    
    /**
     * Lexer state once it has recognized and returned token
     */
    private State lexerState; 
    
    /**
     * keyword similar to keywords used in php
     */
    protected static final List<String> keywords = new ArrayList<String>();
    static {
        keywords.add("true");
        keywords.add("false");
        keywords.add("if");
        keywords.add("else");
        keywords.add("foreach");
    };
    
    public FluidLexer(LexerRestartInfo<FluidTokenId> info) {
        this.input = info.input();
        this.scanner = new FluidScanningLexer(info, lexerState);
        this.tokenFactory = info.tokenFactory();
    }
    
    @Override
    public Token<FluidTokenId> nextToken() {
        FluidTokenId tokenId = this.scanner.nextToken();
        if(tokenId == null) {
            return null;
        }
        return (tokenId.fieldText() != null)
                ? tokenFactory.getFlyweightToken(tokenId, tokenId.fieldText())
                : tokenFactory.createToken(tokenId);
    }
    
    @Override
    public Object state() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void release() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    private class FluidScanningLexer {
        
        private LexerInput input;
        private State lexerState;
        
        public FluidScanningLexer(LexerRestartInfo<FluidTokenId> info, State state) {
            this.input = info.input();
            this.lexerState = state;
        }
        
        public FluidTokenId nextToken() {

            int ch;
            while(true) {
                ch = this.input.read();

                if(ch == EOF) {
                    if(this.input.readLengthEOF() == 1) {
                        return null;
                    } else {
                        if(this.lexerState == State.OUTER) {
                            return FluidTokenId.OTHER;
                        }
                    }
                }
                
                switch(this.lexerState) {
                    case OUTER:
                        
                    break;
                }
            }//end while
            
        }
        
    }
    
}
