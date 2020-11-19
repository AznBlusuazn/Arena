=====================================
SAVE THE WORLD by Geoff Clark
VERSION ALPHA 0.0.3 / 2020.11.18.2210
=====================================

This program was written with JDK 1.8.  It does require a minimum of JRE 52 to run.

Java can be downloaded from:  https://www.java.com/en/

====================================

ABOUT THIS APPLICATION

This is an arena game that will be completely customizable.  It is a homage to the
old school late 80's-90's RPG games, specifically the turn based battle.  This
game will be completely customizable.  Some of the features will include the
ability to "level up" your chosen character, the NPC players to "level up", and
an option for the game world to develop while not in game play.

This is very early development, not playable at this time.

This game was inspired by the author's kids and their love for arena/simulation
games and the author's enjoyment of late 80's-90's RPG games.

See the TODO.txt for developing ideas/features on https://github.com/AznBlusuazn/Arena/

Copy of this code without the content of the Author is prohibited.

Contact the author:  gclark82@gmail.com

====================================

DEVELOPMENT NOTES

ALPHA 0.0.3 / 2020.11.18.2210

- cleaned up interface for character selection dropdown
- renamed dbcheck to filecheck
- added userinput field and enter button
- added import for race, class, and alignment for players
- converted placeholder metadata for player profiles
- added table for toon abilities and statuses
- linked toon abilities to abilities table

ALPHA 0.0.2 / 2020.11.18.0019

- added TODO.txt to GitHub for progress
- added multiple values to abilities, ability types, linked tables
- added more details to playerInfo
- streamlined internal db queries to either specific list or whole record
- made some changes to the list of attributes in the db for toons
- added more to the TODO list
- temporarily changed the default db to be in \db for now
- added an /avatars/ in src folder with test data
- created test methods to populate player 1 and player 2 with db data (success)


ALPHA 0.0.1 / 2020.11.17.0149

- initial build
- got accdb working
- need to manually put db folder with .jar if compiled

=======