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

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.rauschig.wicket.ace.AceConfig;
import org.rauschig.wicket.ace.AceEditorField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BasicFormExample.
 */
public class BasicFormExample extends ExamplePage {
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = LoggerFactory.getLogger(BasicFormExample.class);

    public BasicFormExample() {

        Form<Snippet> form = new Form<Snippet>("form", new CompoundPropertyModel<>(new Snippet())) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit() {
                LOG.info("Form submitted");
                LOG.info(getModelObject().getCode());
            }
        };

        form.add(new AceEditorField<>("code", new AceConfig().mode("javascript")));

        add(form);
    }

}
