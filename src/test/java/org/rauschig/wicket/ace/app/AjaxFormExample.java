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
package org.rauschig.wicket.ace.app;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.rauschig.wicket.ace.AceEditorField;

/**
 * AjaxFormExample.
 */
public class AjaxFormExample extends ExamplePage {
    private static final long serialVersionUID = 1L;

    public AjaxFormExample() {
        final Form<Snippet> form = new Form<>("form", new CompoundPropertyModel<>(new Snippet()));

        form.add(new MultiLineLabel("codeLabel", new Model<>()).setOutputMarkupId(true));
        form.add(new AceEditorField<>("code"));

        form.add(new AjaxSubmitLink("submit", form) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                Snippet snippet = (Snippet) form.getDefaultModelObject();

                Component label = getForm().get("codeLabel");
                label.setDefaultModelObject(snippet.getCode());

                target.add(label);
            }
        });

        add(form);
    }

}
