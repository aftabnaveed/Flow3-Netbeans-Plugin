/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.php.flow3.fluid.editor.completion.items;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.text.JTextComponent;
import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.CompletionUtilities;

/**
 *
 * @author aftab
 */
public class BaseCompletionItem implements CompletionItem {
 
    protected Color fieldColor = Color.decode("0x000000");
    
    protected String text;			// text to be inserted instead of that between these two:
    protected int dotOffset;			// start offset where completion will happen
    protected int caretOffset;	
    
    
    @Override
    public void render(Graphics graphics, Font font, Color color, Color color1, int width, int height, boolean selected) {
        String s = text.replace("<", "&lt;").replace("\"", "&quot;");
        CompletionUtilities.renderHtml(null, s, null, graphics, font, (selected ? Color.white : fieldColor), width, height, selected);
    }
    
    @Override
    public void defaultAction(JTextComponent textComponent) {
        
    }

    @Override
    public void processKeyEvent(KeyEvent ke) {
        //nothing special
    }

    @Override
    public int getPreferredWidth(Graphics graphics, Font font) {
        return 0;
    }

    @Override
    public CompletionTask createDocumentationTask() {
        return null;
    }

    @Override
    public CompletionTask createToolTipTask() { 
        return null;
    }

    @Override
    public boolean instantSubstitution(JTextComponent textComponent) {
        this.defaultAction(textComponent);
        return true;
    }

    @Override
    public int getSortPriority() {
        return 0;
    }

    @Override
    public CharSequence getSortText() {
        return null;
    }

    @Override
    public CharSequence getInsertPrefix() {
        return null;
    }
}
