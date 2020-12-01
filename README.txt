=======================================
LIMITLESS by Geoff Clark
VERSION ALPHA 0.0.012 / 2020.11.27.1803
=======================================

SUPPORT THE DEVELOPMENT OF THIS GAME @ 

 https://www.patreon.com/clarktribegames
 https://paypal.me/aznblusuazn

JOIN THE COMMUNITY ON FACEBOOK OR DISCORD

  https://facebook.com/clarktribe.games
  https://discord.gg/6kW4der

=======================================

This program was written with JDK 1.8.  It does require a minimum of JRE 52 to run.

Java can be downloaded from:  https://www.java.com/en/

======================================

ABOUT THIS APPLICATION

LIMITLESS is an arena game that will be completely customizable.  It is a homage to the
old school late 80's-90's RPG games, specifically the turn based battle.  This
game will be completely customizable.  Some of the features will include the
ability to "level up" your chosen character, the NPC players to "level up", and
an option for the game world to develop while not in game play.

This is very early development, not playable at this time.

This game was inspired by the author's kids and their love for arena/simulation
games and the author's enjoyment of late 80's-90's RPG games.

See the TODO.txt for developing ideas/features on https://github.com/AznBlusuazn/Arena/

Copy of this code without the content of the Author is prohibited.

Contact the author:  info@clarktribegames.com

====================================

DEVELOPMENT NOTES

ALPHA 0.0.012 / 2020.11.30.2345

- added main menu with options - new game, load game, editor, options, about, donate, and exit
- load, edit, and options not functional
- new game currently just launches ALPHA 0.0.011 and earlier GUI (as placeholder)
- added about info -- fb, yt, and discord
- added donate info - patreon, paypal
- exit button functional with checks
- added error log feature for troubleshooting
- added update checker to see if user has latest version
- encrypted db to proprietary .limit file type
- default db now copies from within the exe to the local machine if it doesn't exist
- required libs copy to local machine into folder if it doesn't exist

ALPHA 0.0.011 / 2020.11.26.2212

- happy thanksgiving!
- added menu bar with options
- added donate, about (not functional), and exit options in menu

ALPHA 0.0.010 / 2020.11.25.2146

- separated bio box into its own text box
- adjusted package name
- created baseline randomizer method

ALPHA 0.0.009 / 2020.11.24.1719

- fixed method for comparing statuses to determine which status is primary
- separated active stats from OG stats
- updated some of the query coding for optimization
- redid effects fields with add +(Absorb) ±(Strong) and -(Weak)
- added about 50 effects to the effect table
- added "OG" status for toons as baseline/max points -- temporarily added in text box for testing

ALPHA 0.0.008 / 2020.11.23.2205

- named the game "LIMITLESS" -- from the idea that there are no limits to the game
- converted many "numbered" fields to actually descriptors in the db.
- created bio builder -- still need to add status and effects into bio builder, but framework is there
- updated readme.txt and todo.txt -- included patreon, paypal, discord, and facebook info

ALPHA 0.0.007 / 2020.11.23.0034

- added several baseline statuses to db
- planned out additions to effects
- added more ideas to TODO

ALPHA 0.0.006 / 2020.11.21.2255

- coded logic to extract toons race/class/unique effects and combine them into a unique "code"
- effects code then translates to status, every status will have a unique identifier
- split bio off into its own window -- prep for auto generated bios
- moved status out of text box and coded in colors for statuses
- added Array Sorter method
- test statuses are Normal, Knocked Out, Dead

ALPHA 0.0.005 / 2020.11.20.2342

- corrected the title of the readme.txt
- added Fatigue, Soul, Decay, Weight Modifier, Size, and Gender to Toon, Race, Class, Abilities
- added unique field for Toon, Race, Class, and Abilities
- added Genders
- added importing of Gender to profile, moved around display for Gender box
- added Status (names) and Effects tables
- added tables for Abls and Effs for Align, Race, Class, and Toons
- created a way to collect Toon Effect Code -- to be replicated for Align/Reace/Class Effect
- developed text coding for strong(+), neutral(±) and weak(-) in relation to statuses

ALPHA 0.0.004 / 2020.11.19.2304

- added statuses table
- started brainstorming various baseline statuses for game -- see STATUS_IDEAS.txt
- more ideas added to TODO.txt

ALPHA 0.0.003 / 2020.11.18.2210

- cleaned up interface for character selection dropdown
- renamed dbcheck to filecheck
- added userinput field and enter button
- added import for race, class, and alignment for players
- converted placeholder metadata for player profiles
- added table for toon abilities and statuses
- linked toon abilities to abilities table

ALPHA 0.0.002 / 2020.11.18.0019

- added TODO.txt to GitHub for progress
- added multiple values to abilities, ability types, linked tables
- added more details to playerInfo
- streamlined internal db queries to either specific list or whole record
- made some changes to the list of attributes in the db for toons
- added more to the TODO list
- temporarily changed the default db to be in \db for now
- added an /avatars/ in src folder with test data
- created test methods to populate player 1 and player 2 with db data (success)


ALPHA 0.0.001 / 2020.11.17.0149

- initial build
- got accdb working
- need to manually put db folder with .jar if compiled

=======