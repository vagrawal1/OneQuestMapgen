OneQuestMapgen
==============

Completed Mapmaker for OneQuest. This will create a map of 27 x 27 tiles which will fill out a 950 x 600 area. This is the same area that is used by the OneQuest game found at this repo: 

*https://github.com/MCKillZone/OneQuest.git*

##Usage

As it stands right now, the program will load a tileset into memory, which can be changed programmatically (we currently don't have more than one tileset, but this option is there in case we decide to make multiple tilesets. The map will still be the same regardless, so it really doesn't matter. The numbers that are printed by the map only signify to the OneQuest program which tiles to load onto the map; the rest of the properties of the tiles are stored in the OneQuest program itself, and the tileset is specified programmatically. I suppose it could be possible to add the tilesets and their links in the map, but I don't feel like it. Maybe later.

So anyway, after the tileset is loaded, you can freely draw on the tiles and have them change as you draw. The little red square in the top left corner is the save button. Dragging horizontally will create horizontal tiles; similarly, dragging vertically will create vertical tiles. You've gotta drag a little quickly (and straight), otherwise the program won't recognize it as a line and it won't draw it. You'll figure it out after you use it for a minute or two. The controls are specified below: 

+ **Left Click:** Increment the tile value by 1

+ **Right Click:** Decrement the tile value by 1

+ **Left Click + Drag:** Depending on direction, tile will become either horizontal or vertical path

+ **Right Click + Drag:** Will clear any tile (back to tile value of 0/background). Use with caution.


##Known Issues

1. The save button will disappear after the first click of the save button. Maybe it's not an issue, but it's something that should be known.

2. Sometimes if you draw over a tile you've drawn over already (in the perpendicular direction), then it'll draw the 4 way cross tile. Other times it won't. I can't get it to reliably do this, so I can't really fix the bug. Oh well.

##Preview
<img src =  "http://gyazo.com/f09aaeb886f2d450c8fd6eed840806ba.png" alt = "Preview goes here. Check your internet"></img>
