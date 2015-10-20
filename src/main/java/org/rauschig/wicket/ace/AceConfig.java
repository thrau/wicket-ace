/**
 *    Copyright 2014 Thomas Rausch
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.rauschig.wicket.ace;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.util.io.IClusterable;
import org.apache.wicket.util.value.IValueMap;
import org.apache.wicket.util.value.ValueMap;

/**
 * Such parameters. Many config. Wow.
 * 
 * See
 * <a href="https://github.com/ajaxorg/ace/wiki/Configuring-Ace">https://github.com/ajaxorg/ace/wiki/Configuring-Ace</a>
 */
public class AceConfig implements IClusterable {

    private static final long serialVersionUID = 1L;

    private IValueMap map;

    public AceConfig() {
        this(new HashMap<String, Object>());
    }

    public AceConfig(String mode, String theme) {
        this();
        mode(mode);
        theme(theme);
    }

    protected AceConfig(Map<String, Object> map) {
        this(new ValueMap(map));
    }

    protected AceConfig(IValueMap map) {
        this.map = map;
    }

    public AceConfig selectionStyle(String selectionStyle) {
        setSelectionStyle(selectionStyle);
        return this;
    }

    public AceConfig highlightActiveLine(Boolean highlightActiveLine) {
        setHighlightActiveLine(highlightActiveLine);
        return this;
    }

    public AceConfig highlightSelectedWord(Boolean highlightSelectedWord) {
        setHighlightSelectedWord(highlightSelectedWord);
        return this;
    }

    public AceConfig readOnly(Boolean readOnly) {
        setReadOnly(readOnly);
        return this;
    }

    public AceConfig cursorStyle(String cursorStyle) {
        setCursorStyle(cursorStyle);
        return this;
    }

    public AceConfig mergeUndoDeltas(String mergeUndoDeltas) {
        setMergeUndoDeltas(mergeUndoDeltas);
        return this;
    }

    public AceConfig behavioursEnabled(Boolean behavioursEnabled) {
        setBehavioursEnabled(behavioursEnabled);
        return this;
    }

    public AceConfig wrapBehavioursEnabled(Boolean wrapBehavioursEnabled) {
        setWrapBehavioursEnabled(wrapBehavioursEnabled);
        return this;
    }

    public AceConfig autoScrollEditorIntoView(Boolean autoScrollEditorIntoView) {
        setAutoScrollEditorIntoView(autoScrollEditorIntoView);
        return this;
    }

    public AceConfig hScrollBarAlwaysVisible(Boolean hScrollBarAlwaysVisible) {
        setHScrollBarAlwaysVisible(hScrollBarAlwaysVisible);
        return this;
    }

    public AceConfig vScrollBarAlwaysVisible(Boolean vScrollBarAlwaysVisible) {
        setVScrollBarAlwaysVisible(vScrollBarAlwaysVisible);
        return this;
    }

    public AceConfig highlightGutterLine(Boolean highlightGutterLine) {
        setHighlightGutterLine(highlightGutterLine);
        return this;
    }

    public AceConfig animatedScroll(Boolean animatedScroll) {
        setAnimatedScroll(animatedScroll);
        return this;
    }

    public AceConfig showInvisibles(Boolean showInvisibles) {
        setShowInvisibles(showInvisibles);
        return this;
    }

    public AceConfig showPrintMargin(Boolean showPrintMargin) {
        setShowPrintMargin(showPrintMargin);
        return this;
    }

    public AceConfig printMarginColumn(Boolean printMarginColumn) {
        setPrintMarginColumn(printMarginColumn);
        return this;
    }

    public AceConfig printMargin(Boolean printMargin) {
        setPrintMargin(printMargin);
        return this;
    }

    public AceConfig fadeFoldWidgets(Boolean fadeFoldWidgets) {
        setFadeFoldWidgets(fadeFoldWidgets);
        return this;
    }

    public AceConfig showFoldWidgets(Boolean showFoldWidgets) {
        setShowFoldWidgets(showFoldWidgets);
        return this;
    }

    public AceConfig showLineNumbers(Boolean showLineNumbers) {
        setShowLineNumbers(showLineNumbers);
        return this;
    }

    public AceConfig showGutter(Boolean showGutter) {
        setShowGutter(showGutter);
        return this;
    }

    public AceConfig displayIndentGuides(Boolean displayIndentGuides) {
        setDisplayIndentGuides(displayIndentGuides);
        return this;
    }

    public AceConfig fontSize(String fontSize) {
        setFontSize(fontSize);
        return this;
    }

    public AceConfig fontFamily(String fontFamily) {
        setFontFamily(fontFamily);
        return this;
    }

    public AceConfig maxLines(Boolean maxLines) {
        setMaxLines(maxLines);
        return this;
    }

    public AceConfig minLines(Boolean minLines) {
        setMinLines(minLines);
        return this;
    }

    public AceConfig scrollPastEnd(Boolean scrollPastEnd) {
        setScrollPastEnd(scrollPastEnd);
        return this;
    }

    public AceConfig fixedWidthGutter(Boolean fixedWidthGutter) {
        setFixedWidthGutter(fixedWidthGutter);
        return this;
    }

    public AceConfig theme(String theme) {
        setTheme(theme);
        return this;
    }

    public AceConfig scrollSpeed(Number scrollSpeed) {
        setScrollSpeed(scrollSpeed);
        return this;
    }

    public AceConfig dragDelay(Number dragDelay) {
        setDragDelay(dragDelay);
        return this;
    }

    public AceConfig dragEnabled(Boolean dragEnabled) {
        setDragEnabled(dragEnabled);
        return this;
    }

    public AceConfig focusTimout(Number focusTimout) {
        setFocusTimout(focusTimout);
        return this;
    }

    public AceConfig tooltipFollowsMouse(Boolean tooltipFollowsMouse) {
        setTooltipFollowsMouse(tooltipFollowsMouse);
        return this;
    }

    public AceConfig firstLineNumber(Number firstLineNumber) {
        setFirstLineNumber(firstLineNumber);
        return this;
    }

    public AceConfig overwrite(Boolean overwrite) {
        setOverwrite(overwrite);
        return this;
    }

    public AceConfig newLineMode(Boolean newLineMode) {
        setNewLineMode(newLineMode);
        return this;
    }

    public AceConfig useWorker(Boolean useWorker) {
        setUseWorker(useWorker);
        return this;
    }

    public AceConfig useSoftTabs(Boolean useSoftTabs) {
        setUseSoftTabs(useSoftTabs);
        return this;
    }

    public AceConfig tabSize(Number tabSize) {
        setTabSize(tabSize);
        return this;
    }

    public AceConfig wrap(Boolean wrap) {
        setWrap(wrap);
        return this;
    }

    public AceConfig foldStyle(Boolean foldStyle) {
        setFoldStyle(foldStyle);
        return this;
    }

    public AceConfig mode(String mode) {
        setMode(mode);
        return this;
    }

    public AceConfig enableMultiselect(Boolean enableMultiselect) {
        setEnableMultiselect(enableMultiselect);
        return this;
    }

    public AceConfig enableEmmet(Boolean enableEmmet) {
        setEnableEmmet(enableEmmet);
        return this;
    }

    public AceConfig enableBasicAutocompletion(Boolean enableBasicAutocompletion) {
        setEnableBasicAutocompletion(enableBasicAutocompletion);
        return this;
    }

    public AceConfig enableSnippets(Boolean enableSnippets) {
        setEnableSnippets(enableSnippets);
        return this;
    }

    public AceConfig spellcheck(Boolean spellcheck) {
        setSpellcheck(spellcheck);
        return this;
    }

    public AceConfig useElasticTabstops(Boolean useElasticTabstops) {
        setUseElasticTabstops(useElasticTabstops);
        return this;
    }

    public void setSelectionStyle(String selectionStyle) {
        set("selectionStyle", selectionStyle);
    }

    public void setHighlightActiveLine(Boolean highlightActiveLine) {
        set("highlightActiveLine", highlightActiveLine);
    }

    public void setHighlightSelectedWord(Boolean highlightSelectedWord) {
        set("highlightSelectedWord", highlightSelectedWord);
    }

    public void setReadOnly(Boolean readOnly) {
        set("readOnly", readOnly);
    }

    public void setCursorStyle(String cursorStyle) {
        set("cursorStyle", cursorStyle);
    }

    public void setMergeUndoDeltas(String mergeUndoDeltas) {
        set("mergeUndoDeltas", mergeUndoDeltas);
    }

    public void setBehavioursEnabled(Boolean behavioursEnabled) {
        set("behavioursEnabled", behavioursEnabled);
    }

    public void setWrapBehavioursEnabled(Boolean wrapBehavioursEnabled) {
        set("wrapBehavioursEnabled", wrapBehavioursEnabled);
    }

    public void setAutoScrollEditorIntoView(Boolean autoScrollEditorIntoView) {
        set("autoScrollEditorIntoView", autoScrollEditorIntoView);
    }

    public void setHScrollBarAlwaysVisible(Boolean hScrollBarAlwaysVisible) {
        set("hScrollBarAlwaysVisible", hScrollBarAlwaysVisible);
    }

    public void setVScrollBarAlwaysVisible(Boolean vScrollBarAlwaysVisible) {
        set("vScrollBarAlwaysVisible", vScrollBarAlwaysVisible);
    }

    public void setHighlightGutterLine(Boolean highlightGutterLine) {
        set("highlightGutterLine", highlightGutterLine);
    }

    public void setAnimatedScroll(Boolean animatedScroll) {
        set("animatedScroll", animatedScroll);
    }

    public void setShowInvisibles(Boolean showInvisibles) {
        set("showInvisibles", showInvisibles);
    }

    public void setShowPrintMargin(Boolean showPrintMargin) {
        set("showPrintMargin", showPrintMargin);
    }

    public void setPrintMarginColumn(Boolean printMarginColumn) {
        set("printMarginColumn", printMarginColumn);
    }

    public void setPrintMargin(Boolean printMargin) {
        set("printMargin", printMargin);
    }

    public void setFadeFoldWidgets(Boolean fadeFoldWidgets) {
        set("fadeFoldWidgets", fadeFoldWidgets);
    }

    public void setShowFoldWidgets(Boolean showFoldWidgets) {
        set("showFoldWidgets", showFoldWidgets);
    }

    public void setShowLineNumbers(Boolean showLineNumbers) {
        set("showLineNumbers", showLineNumbers);
    }

    public void setShowGutter(Boolean showGutter) {
        set("showGutter", showGutter);
    }

    public void setDisplayIndentGuides(Boolean displayIndentGuides) {
        set("displayIndentGuides", displayIndentGuides);
    }

    public void setFontSize(String fontSize) {
        set("fontSize", fontSize);
    }

    public void setFontFamily(String fontFamily) {
        set("fontFamily", fontFamily);
    }

    public void setMaxLines(Boolean maxLines) {
        set("maxLines", maxLines);
    }

    public void setMinLines(Boolean minLines) {
        set("minLines", minLines);
    }

    public void setScrollPastEnd(Boolean scrollPastEnd) {
        set("scrollPastEnd", scrollPastEnd);
    }

    public void setFixedWidthGutter(Boolean fixedWidthGutter) {
        set("fixedWidthGutter", fixedWidthGutter);
    }

    public void setTheme(String theme) {
        set("theme", theme);
    }

    public void setScrollSpeed(Number scrollSpeed) {
        set("scrollSpeed", scrollSpeed);
    }

    public void setDragDelay(Number dragDelay) {
        set("dragDelay", dragDelay);
    }

    public void setDragEnabled(Boolean dragEnabled) {
        set("dragEnabled", dragEnabled);
    }

    public void setFocusTimout(Number focusTimout) {
        set("focusTimout", focusTimout);
    }

    public void setTooltipFollowsMouse(Boolean tooltipFollowsMouse) {
        set("tooltipFollowsMouse", tooltipFollowsMouse);
    }

    public void setFirstLineNumber(Number firstLineNumber) {
        set("firstLineNumber", firstLineNumber);
    }

    public void setOverwrite(Boolean overwrite) {
        set("overwrite", overwrite);
    }

    public void setNewLineMode(Boolean newLineMode) {
        set("newLineMode", newLineMode);
    }

    public void setUseWorker(Boolean useWorker) {
        set("useWorker", useWorker);
    }

    public void setUseSoftTabs(Boolean useSoftTabs) {
        set("useSoftTabs", useSoftTabs);
    }

    public void setTabSize(Number tabSize) {
        set("tabSize", tabSize);
    }

    public void setWrap(Boolean wrap) {
        set("wrap", wrap);
    }

    public void setFoldStyle(Boolean foldStyle) {
        set("foldStyle", foldStyle);
    }

    public void setMode(String mode) {
        set("mode", mode);
    }

    public void setEnableMultiselect(Boolean enableMultiselect) {
        set("enableMultiselect", enableMultiselect);
    }

    public void setEnableEmmet(Boolean enableEmmet) {
        set("enableEmmet", enableEmmet);
    }

    public void setEnableBasicAutocompletion(Boolean enableBasicAutocompletion) {
        set("enableBasicAutocompletion", enableBasicAutocompletion);
    }

    public void setEnableSnippets(Boolean enableSnippets) {
        set("enableSnippets", enableSnippets);
    }

    public void setSpellcheck(Boolean spellcheck) {
        set("spellcheck", spellcheck);
    }

    public void setUseElasticTabstops(Boolean useElasticTabstops) {
        set("useElasticTabstops", useElasticTabstops);
    }

    public String getSelectionStyle() {
        return get("selectionStyle");
    }

    public Boolean getHighlightActiveLine() {
        return get("highlightActiveLine");
    }

    public Boolean getHighlightSelectedWord() {
        return get("highlightSelectedWord");
    }

    public Boolean getReadOnly() {
        return get("readOnly");
    }

    public String getCursorStyle() {
        return get("cursorStyle");
    }

    public String getMergeUndoDeltas() {
        return get("mergeUndoDeltas");
    }

    public Boolean getBehavioursEnabled() {
        return get("behavioursEnabled");
    }

    public Boolean getWrapBehavioursEnabled() {
        return get("wrapBehavioursEnabled");
    }

    public Boolean getAutoScrollEditorIntoView() {
        return get("autoScrollEditorIntoView");
    }

    public Boolean gethScrollBarAlwaysVisible() {
        return get("hScrollBarAlwaysVisible");
    }

    public Boolean getvScrollBarAlwaysVisible() {
        return get("vScrollBarAlwaysVisible");
    }

    public Boolean getHighlightGutterLine() {
        return get("highlightGutterLine");
    }

    public Boolean getAnimatedScroll() {
        return get("animatedScroll");
    }

    public Boolean getShowInvisibles() {
        return get("showInvisibles");
    }

    public Boolean getShowPrintMargin() {
        return get("showPrintMargin");
    }

    public Boolean getPrintMarginColumn() {
        return get("printMarginColumn");
    }

    public Boolean getPrintMargin() {
        return get("printMargin");
    }

    public Boolean getFadeFoldWidgets() {
        return get("fadeFoldWidgets");
    }

    public Boolean getShowFoldWidgets() {
        return get("showFoldWidgets");
    }

    public Boolean getShowLineNumbers() {
        return get("showLineNumbers");
    }

    public Boolean getShowGutter() {
        return get("showGutter");
    }

    public Boolean getDisplayIndentGuides() {
        return get("displayIndentGuides");
    }

    public String getFontSize() {
        return get("fontSize");
    }

    public String getFontFamily() {
        return get("fontFamily");
    }

    public Boolean getMaxLines() {
        return get("maxLines");
    }

    public Boolean getMinLines() {
        return get("minLines");
    }

    public Boolean getScrollPastEnd() {
        return get("scrollPastEnd");
    }

    public Boolean getFixedWidthGutter() {
        return get("fixedWidthGutter");
    }

    public String getTheme() {
        return get("theme");
    }

    public Number getScrollSpeed() {
        return get("scrollSpeed");
    }

    public Number getDragDelay() {
        return get("dragDelay");
    }

    public Boolean getDragEnabled() {
        return get("dragEnabled");
    }

    public Number getFocusTimout() {
        return get("focusTimout");
    }

    public Boolean getTooltipFollowsMouse() {
        return get("tooltipFollowsMouse");
    }

    public Number getFirstLineNumber() {
        return get("firstLineNumber");
    }

    public Boolean getOverwrite() {
        return get("overwrite");
    }

    public Boolean getNewLineMode() {
        return get("newLineMode");
    }

    public Boolean getUseWorker() {
        return get("useWorker");
    }

    public Boolean getUseSoftTabs() {
        return get("useSoftTabs");
    }

    public Number getTabSize() {
        return get("tabSize");
    }

    public Boolean getWrap() {
        return get("wrap");
    }

    public Boolean getFoldStyle() {
        return get("foldStyle");
    }

    public String getMode() {
        return get("mode");
    }

    public Boolean getEnableMultiselect() {
        return get("enableMultiselect");
    }

    public Boolean getEnableEmmet() {
        return get("enableEmmet");
    }

    public Boolean getEnableBasicAutocompletion() {
        return get("enableBasicAutocompletion");
    }

    public Boolean getEnableSnippets() {
        return get("enableSnippets");
    }

    public Boolean getSpellcheck() {
        return get("spellcheck");
    }

    public Boolean getUseElasticTabstops() {
        return get("useElasticTabstops");
    }

    public IValueMap getMap() {
        return map;
    }

    @SuppressWarnings("unchecked")
    protected <T> T get(String key) {
        return (T) map.get(key);
    }

    protected void set(String key, Object value) {
        map.put(key, value);
    }
}
