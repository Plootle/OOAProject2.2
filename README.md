# OOAProject2.2
RotLA Game for CSCI 4448
Darian Payan and Gabriel Barratt

java version "18.0.1.1" 2022-04-22
Java(TM) SE Runtime Environment (build 18.0.1.1+2-6)
Java HotSpot(TM) 64-Bit Server VM (build 18.0.1.1+2-6, mixed mode, sharing)

A few things we interpreted:
– Orbiter Creatures circle the outer Rooms of the level they are on, whether connected 
or not – they may go in clockwise or counterclockwise directions.

Here we assumed that due to the orbiter being able to travel to non connected rooms, they can move to any of the 8 other rooms available to them on the floor they spawn on.

We also assumed that the structure of the game is that of adventurers entering and going deeper into a dungeon compared to entering a tower and climbing up it.

Due to there not being strict rules on going back to already visited rooms, theoretically, an adventurer can go between two rooms over and over to get 10 treasures.

The last thing that we changed was that we never actually delete the adventurers. Instead, we have a function that marks them as dead and does not allow them to continue on through the game. This is because each individual adventurer hold onto their own treasure, and deleting them would delete the treasure have already found. It would remove the treasure from the count. Thus we didn't delete them :D
