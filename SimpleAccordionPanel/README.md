# SimpleAccordionPanel
This project provides an accordion panel.

the panel extends a Jpanel, and contains 3 components -
1) a title 
2) an icon
3) a content panel

while the panel is shrinked the title and the icon are being shown and the content panel is hidden
if the title is pressed then the icon changes and the content panel is shown as well.

# Classes:

1) AccordionPanelOptions - an interface used to twik the look and feel of the panel , its config method is called by the accordion panel.

2) IconSet - a class that contains 2 images one which represents open content panel state and one for closed state.

3) AccordionPanel - the accordion panel itself

# usage:
<b>creating the panel:</b>

creating the panel is simple, just call the AccordionPanel class constructor and pass the desired title and a content Jpanel.

it is also possible to send an optional AccordionPanelOptions instance and an iconset. 
if those are not supplied the default ones are used.

accordionPanel=new AccordionPanel("title", contentPanel,[optional] accordionPanelOptions,[optional] iconSet);

# License:
GNU LGPLv3 

https://choosealicense.com/licenses/lgpl-3.0/


