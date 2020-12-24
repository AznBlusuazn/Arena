=======================================
LIMITLESS by Geoff Clark
VERSION ALPHA 0.0.027 / 2020.12.23-2300
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

Music in this game is provided by BenSound.com -- Please check out their site for
awesome free music! -- https://www.bensound.com

See the TODO.txt for developing ideas/features on https://github.com/AznBlusuazn/Arena/

Copy of this code without the content of the Author is prohibited.

Contact the author:  info@clarktribegames.com

====================================

DEVELOPMENT NOTES


ALPHA 0.0.027 / 2020.12.23-2300

- continued improvements on music player utilizing multithreading
- implemented custom music option for intro and battle music (other areas of music to follow)
- added settings ini options for custom intro music and battle music

ALPHA 0.0.026 / 2020.12.22-2249

- improved music player with some fixes to prevent overlapping music
- added a new track from BenSound "Epic" for the battle theme
- set up foundation for generic characters to be generated
- create table for phrase blank for unique experiences during battle
- created who's first and turn counter along with math to figured out turn meters
- created text that types in for battle gui battle happenings
- created holds for the confirm button in between the battle text typewriter
- created loop with simulated battle damage between the two opponents for testing

ALPHA 0.0.025 / 2020.12.21-1855

- corrected miscalculated stats in the battle screen
- restructured the way teams and their stats are ported into the battle engine
- recoded the battle gui to display the toon stats, items, abls, and effs correctly
- added new sample character "Giovanni"

ALPHA 0.0.024 / 2020.12.20-2329

- fixed issue with game crash if toon has no equipment
- restructured abilities table with ablitiy cost, target, impact, and base stat, along with additions if it is an element attach and if it applies and effect or not
- added element field for items
- restructured effects to have stat impact, increment rates, condensed elements, options to change team, alignment, gender, race, size
- added coding similiar to stats for effect impact
- coded ability cost, target, impact, base, element type decoders
- realigned the stats for the battle screen to reflect the changes from 0.0.023

ALPHA 0.0.023 / 2020.12.19-2344

- simplified encryption of db and reduced db size
- designed more efficient way to communication abilities/effects between tables
- created new algorithm to determine math needed for ablities and effects
- designed targeting system -- need to code this
- redesigned the method to gather stats from items and attributes
- redesigned select character screen to be cleaner
- added new sample character "Helios"

ALPHA 0.0.022 / 2020.12.16-1632

- further built out battle gui
- completed stat imports for main stats
- enabled "quick look" buttons for items, effects, and abilities of active toons
- set up mechanics for future "team" battles
- streamlined stat loading for future optimization

ALPHA 0.0.021 / 2020.12.16-0043

- enabled load save option at main menu
- added detect for if save games exist or not
- created mechanism to load save game with correct character and correct database
- completed randomized exhibition selection
- added check to make sure you can't face yourself!
- added versus screen before the battle
- added addition copy of save game db called max for max stats (post battle reset)
- created the battle gui screen with:  "team 0" and "team 1" sides (right and left, respectively)
- each team will have a team list, active team member avatar, active team member name, active team member stats, with options (buttons) to see the active team members items/abilities/effects as well
- created the user interface for the communication between the user and the game
- added "type writer" effect so that it will "feel" like an old school text game
- added input text box with a confirm button to "submit" commands to the game

ALPHA 0.0.020 / 2020.12.15-0850

- recoded character select stats to cache prior to load to help with load times
- added some wording for db generating
- revisited calculations of stats
- added "alias", "alias known", "alias image" fields for future use
- added new sample character "Mr. Dream"
- added millisecond delay to prevent an potential error when build save games

ALPHA 0.0.019 / 2020.12.13-2216

- created a new sample character "The Prankster"
- added a handful of inventory items to the db
- equipped those items to the 3 test characters
- added in logic to exact buffs/debuffs for stats from items equipped
- added items to appear as equipped or in inventory
- added item type to db with possible restricts based on class,race,align
- added abilities and effects to import from items for character select
- added starting game world info on the character select
- math to figure out who the top character is in the game -- text appears in the game world box
- added some testing numbers for development purposes
- condensed several lookups into universal variables to help with data times
- removed unused code
- successfully create new save data within db

ALPHA 0.0.018 / 2020.12.11-2353

- corrected potential db error with autonumbers, changed all to numbers and rebuild db
- revamped how colors were assigned for alignments and the alignment values
- added missing lawful neutral color of dark brown
- rebuilt effects and abilities for toons, races, classes, genders to calculate at once
- implemented sizes for races -- micro, mini, tiny, small, average, large, huge, enormous, ginormous
- added more descriptions to "tooltip" hover overs in the character selection
- for sizes took baby, child, and teen into account for smaller versions until they grow
- revised db again for attributes for various areas
- changed items to 4 categories : held, wearable, charms, and items


ALPHA 0.0.017 / 2020.12.10-1741 (in progress)

- created algorithm for toon stat generation based on character race, class, age, gender, and starting exp(level) - the game will generate the rest
- items and status effects will impact this number as well
- added queries for starting abilities and starting effects
- placeholders added for equipment and starting inventory
- added status collector based on effects, returns color coded status based on status db
- alignment detects type of alignment and returns color for it

ALPHA 0.0.016 / 2020.12.09-2312

- separated media player into its own thread to eliminate conflicts with memory
- added player stats to character select gui
- centralized old runquery code to new calculator method
- removed OG GUI
- added new GetData method
- created future ability to define/edit age groups and an age definition decoder
- created age modifier definer
- added variables for alignment, age modifier, race, and class to character select
- created option for custom avatars in toon profiles - if custom does not exist, use default name, if default name does not exists, use generic blank avatar
- changed wording of first time launch to reflect alpha testing
- removed test avatars from the main package
- added method to create avatar folder and place default blank avatar in it

ALPHA 0.0.015 / 2020.12.08-2019

- centralized paths as variables in MainControls class
- added the ability to change databases from new game
- merged some old classes into the newer versions (clean up)
- simplified some calling to the db
- fixed rare issue with game not exiting from character select screen
- added limitless game logo banner
- added limitless game icon
- removed switch db in new game character selection
- added check if more than one db exist, prompt user to select at new game button
- cleaned up current db text in new game window
- nulled old save switch code for later use
- added ini option for always use same db at new game
- added ini option to select which db if always use same
- added check if always use same db doesn't exist to switch to default
- added check if always use same db is checked to skip pre new game db select

ALPHA 0.0.014 / 2020.12.07-2239

- added backend controller class to handle directing of other classes
- restructured start up processes to the controller
- added media player to control music using zoom modules
- combined popup methods into one class, imported some converter and checksandbalances methods from other CTG apps into classes for this one
- added intro music for the game
- added settings.ini and activated "options" button in the main menu -- ini updates as user changes options
- added music option in settings (on/off)
- added placeholder sound option in settings (on/off)
- added various popups notices in the main menu options
- added xp/level math to calculate infinite number of levels

ALPHA 0.0.013 / 2020.12.01-1953

- built new game GUI, porting modifeid items over from the OG GUI
- added optimization to start up process
- added are you sure messages for exiting in any window created so far
- added feature to switch databases/save games from the character selection
- added "last used" db/save feature -- if none, will select default db
- worked on skeleton for character selection screen

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