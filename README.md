Wicket ACE
==========

wicket-ace provides Wicket components for the easy use of the [Ace code editor](https://ace.c9.io) in Wicket
applications.

Usage
-----

You can use the AceEditorField as you would use a textarea in a form.

```java
add(new AceEditorField<String>("code", new Model<>()));
```

```html
<textarea wicket:id="code"></textarea>
```

### More examples

You can run the examples by importing the wicket-ace maven project into your IDE and running the `Start` class. 
      
            
Download
--------

wicket-ace is hosted on maven central

```xml
<dependency>
  <groupId>org.rauschig</groupId>
  <artifactId>wicket-ace</artifactId>
  <version>${wicket-ace.version}</version>
</dependency>
```

Notice
------

wicket-ace is in alpha phase and subject to rapid development and change
