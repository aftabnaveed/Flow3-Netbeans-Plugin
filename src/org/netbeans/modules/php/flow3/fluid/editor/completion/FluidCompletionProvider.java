/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.php.flow3.fluid.editor.completion;

import javax.swing.text.JTextComponent;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.spi.editor.completion.CompletionProvider;
import org.netbeans.spi.editor.completion.CompletionTask;

/**
 * We need to provide completion support for every HTML mime type
 * @author aftab
 */
@MimeRegistration(mimeType = "text/html", service = CompletionProvider.class)
public class FluidCompletionProvider implements CompletionProvider {
    
    /**
     * 
     * @param queryType
     * @param component
     * @return 
     */
    @Override
    public CompletionTask createTask(int queryType, JTextComponent component) {
        return null;
    }
    
    /**
     * Open code completion window as soon as user starts typing and a match is found
     * @param component
     * @param typeText
     * @return 
     */
    @Override
    public int getAutoQueryTypes(JTextComponent component, String typeText) {
        return 0;
    }
    
}
