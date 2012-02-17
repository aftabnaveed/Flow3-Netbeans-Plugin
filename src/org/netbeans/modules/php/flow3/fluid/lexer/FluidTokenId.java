/*
 * FluidTokenId.java
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

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.netbeans.api.lexer.*;
import org.netbeans.spi.lexer.LanguageEmbedding;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 *
 * @author Aftab Naveed <aftabnaveed@gmail.com>
 */
public enum FluidTokenId implements TokenId {

    OTHER(null, "other"),
    ERROR(null, "error"),
    PHP_VARIABLE(null, "php_variable"),
    CONFIG_VARIABLE(null, "config_variable"),
    PIPE("|", "pipe"),
    VARIABLE_MODIFIER(null, "variable_modifier"),
    WHITESPACE(null, "whitepsace"),
    STRING(null, "string"),
    OPERATOR(null, "fluid_operator"),
    FUNCTION(null, "fluid_function"),
    ARGUMENT(null, "argument"),
    ARGUMENT_VALUE(null, "argument_value"),
    CHAR(null, "char");
    
    private final String fieldText;
    private final String primaryCategory;

    FluidTokenId(String fieldText, String primaryCategory) {
        this.fieldText = fieldText;
        this.primaryCategory = primaryCategory;
    }

    public String primaryCategory() {
        return primaryCategory;
    }

    public String fieldText() {
        return fieldText;
    }
    
    private static final Language<FluidTokenId> language = new LanguageHierarchy<FluidTokenId>() {

        @Override
        protected String mimeType() {
            return "text/x-fluid-inner";
        }

        @Override
        protected Collection<FluidTokenId> createTokenIds() {
            return EnumSet.allOf(FluidTokenId.class);
        }

        @Override
        protected Map<String, Collection<FluidTokenId>> createTokenCategories() {
            Map<String, Collection<FluidTokenId>> cats = new HashMap<String, Collection<FluidTokenId>>();
            return cats;
        }

        @Override
        protected Lexer<FluidTokenId> createLexer(LexerRestartInfo<FluidTokenId> info) {
            return new FluidLexer(info);
        }
        /**
         * @Override protected LanguageEmbedding<?> embedding(
         * Token<FluidTokenId> token, LanguagePath languagePath, InputAttributes
         * inputAttributes) { return null;  
        }*
         */
    }.language();

    /**
     * Returns new language for FluidTokenId
     *
     * @return language
     */
    public static Language<FluidTokenId> language() {
        return language;
    }
}
