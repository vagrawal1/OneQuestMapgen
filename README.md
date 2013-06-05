OneQuestMapgen
==============

Completed Mapmaker for OneQuest. This will create a map of 27 x 27 tiles which will fill out a 950 x 600 area. This is the same area that is used by the OneQuest game found at this repo: 

*https://github.com/MCKillZone/OneQuest.git*

##Usage

As it stands right now, the program will load a tileset into memory, which can be changed programmatically (we currently don't have more than one tileset, but this option is there in case we decide to make multiple tilesets. The map will still be the same regardless, so it really doesn't matter. The numbers that are printed by the map only signify to the OneQuest program which tiles to load onto the map; the rest of the properties of the tiles are stored in the OneQuest program itself, and the tileset is specified programmatically. I suppose it could be possible to add the tilesets and their links in the map, but I don't feel like it. Maybe later.

So anyway, after the tileset is loaded, you can freely draw on the tiles and have them change as you draw. The little red square in the top left corner is the save button. Dragging horizontally will create horizontal tiles; similarly, dragging vertically will create vertical tiles. You've gotta drag a little quickly (and straight), otherwise the program won't recognize it as a line and it won't draw it. You'll figure it out after you use it for a minute or two. The controls are specified below: 

+ **Left Click:** Increment the tile value by 1
+ **Right Click:** Decrement the tile value by 1
+ **Center (Mouse Wheel) Click:** If you've got a vertical line and a horizontal line that meet at a corner, you can middle click and the program will automatically put the correct tile in place. That should save you the trouble of having to click through 15 of the tiles.
+ **Left Click + Drag:** Depending on direction, tile will become either horizontal or vertical path
+ **Right Click + Drag:** Will clear any tile (back to tile value of 0/background). Use with caution.


**IMPORTANT:** The program will create a file map.txt in the bin/ folder (or wherever the program is being executed from). If that map file exists already IT WILL BE OVERWRITTEN. If you've got important work saved as the map make sure to move the file after you've saved it. Don't wait until it is too late. Only you can prevent forest fires.

Also, if you want to create maps larger than I've allowed here, you can make multiple maps that are 950x600 (or 36x17 tiles), and then layer them all appropriately in the text file. The game will still support it.

##Known Issues

1. The save button will disappear after the first click of the save button. Maybe it's not an issue, but it's something that should be known.

2. Sometimes if you draw over a tile you've drawn over already (in the perpendicular direction), then it'll draw the 4 way cross tile. Other times it won't. I can't get it to reliably do this, so I can't really fix the bug. Oh well.

##Preview
<img src =  "http://gyazo.com/f09aaeb886f2d450c8fd6eed840806ba.png" alt = "Preview goes here. Check your internet"></img>
