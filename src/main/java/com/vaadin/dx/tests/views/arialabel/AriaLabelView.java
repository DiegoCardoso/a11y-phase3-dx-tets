package com.vaadin.dx.tests.views.arialabel;

import com.vaadin.dx.tests.views.MainLayout;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;


@PageTitle("Aria Label")
@Route(value = "aria-label", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class AriaLabelView extends VerticalLayout {

    public AriaLabelView() {
        setSpacing(false);

        // #1   The field below doesn't have a visible label, so we need to assign
        //      a label to make screen reader users be able to understand what the field is about.
        TextField searchField = new TextField();
        searchField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));

        // #2   The field below, however, does have a label, but it's not the one
        //      provided by TextField, so we need to associate this label with the field.
        Label nameLabel = new Label("Name");
        TextField nameField = new TextField();

        VerticalLayout fieldParent = new VerticalLayout();
        fieldParent.setClassName("field-wrapper");
        fieldParent.setSpacing(false);
        fieldParent.setPadding(false);
        fieldParent.add(nameLabel, nameField);


        var instructions = new Html("<p>* To check the results, use the browser's "
            + "devtools to inspect the <code>&lt;input&gt;</code> element and look for the "
            + "<strong>Name</strong> in the <strong>Accessibility</strong> panel.</p>");
        add(
            instructions,
            new Paragraph("The field below doesn't have a visible label, so we need to assign a label to make screen reader users be able to understand what the field is about."),
            searchField,
            new Paragraph("The field below, however, does have a label, but it's not the one provided by TextField, so we need to associate this label with the field."),
            fieldParent);
    }
}
