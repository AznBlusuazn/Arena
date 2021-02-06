=======================================
LIMITLESS by Geoff Clark
VERSION ALPHA 0.0.044 / 2021.02.06-1734
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

[CURRENT UPDATE]

ALPHA 0.0.044 / 2021.02.06-1734

- modified the 3d grid to be separated into areas and sections -- "ground" level will be accessible in all areas.  each area can define if space, air, underground, and hell exists for that area.  each area can be scaled by an infinite number with a minimum of 3 units in x.y.z directions as long as the number is odd (this will always guarantee a "center stage" section for each area).
- each section can have its own "environment" effects that can automatically apply status effects to the characters on the field -- e.g. heat, ice, rain, water, etc. can be applied
- for now, the game will only have one arena but over time this frame will allow a "limitless" amount of possiblities.
- created database tables for areas, sections, and environments
- redesigned area tables and created the Areas method to build areas to scale based on the area
- added ceiling value (is there a ceiling) and merged "air" as part of the "ground" level
- added total units per section value
- added total available area count to world text at world start

[PREVIOUS UPDATES]

ALPHA 0.0.043 / 2021.01.30-1721

- created and developed new table in db for a 3d grid for battles -- the grid will be in x (west to east), y (north to south), z (space to ground to hell) coordinates; foundation is designed to be able to scale (up or down, with or without boundaries) any setting or arena for the battles; melee, ranged, magic attacks along with the ability to escape battle will all be determined by the location of those on the field
- added version number in the lower right corner of menu screen - if clicked, the latest version notes are shown (will try local readme first, then web pull)
- added vertical scrollbar as needed when showing version notes

ALPHA 0.0.042 / 2021.01.30-0001

- added save game corruption detection and prompt to delete corrupted save
- added check for game save database version compatiblity
- removed separate time table for game time and put it into the game save table (formerly "lastused")
- fixed issue with game time calculating an extra year, month, week, and day when converting raw time to game time
- added save state update to start game method (updates save on demand)
- added temporary code to simulate time passing for new games and load games (testing time conversion)

ALPHA 0.0.041 / 2021.01.29-1125

- removed all db queries except initial load -- all game queries are from memory now
- removed settings.ini external file and integrated settings into the save file
- added check for default db check and auto upgrade if not up to date
- added check if default db was copied from another pc -- regenerates new settings for new pc
- greatly decreased lag between menu selection
- gutted old save structure for new .save files for saves
- created foundation for custom dbs in the foundation as .limit files in custom folder
- retired .lastused files for new files in the .save that will contain the information
- added feature that if no additional databases exist, samedb will default
- reorganized memory bank and revamped some of the methods for calling the database
- fixed load saved game to display selected toon and stats correctly
- fixed load saved game button update when no saved games are available
- cleaned up old null/empty commands with cleaner method

ALPHA 0.0.040 / 2021.01.27-1900

- optimized the load time more by shifting lookups to memory instead of the database
- removed methods for all temp files that were previously used for placeholders

ALPHA 0.0.039 / 2021.01.26-1955

- revamped how the game generates new games -- improved initial load time by almost 60%
- added method to decode charsets for transfers between memory, files, and the database
- streamlined the assignment of toonids to generated generics and alternative aliases
- fixed rare issue with special characters not allowing certain times of records to form in the database tables

ALPHA 0.0.038 / 2021.01.25-2350

- fixed issue where passive aliases where not being created
- optimized world build time by shortening method paths
- removed older db query method and replaced all references with newer version
- removed older record retrieval and replaced all references with newer version
- cleaned up legacy and nulled out code
- revamped update check with integrated clean up for alpha testers
- added update check button to options menu
- fixed game crash due to no images being in avatars folder
- disabled the ability to start game as a generated generic character

ALPHA 0.0.037 / 2021.01.24-2313

- revamped the alias logic that existed in the game and rewrote it completely
- added checks to define alias type for toons with aliases (the 4 types defined in ALPHA 0.0.035)
- if toon has a secret alias then the alias toon will be added as a passive character to the game
- if the toon has a known alias that does not have a transformation or different set of stats, the alias and alias image can be toggled in character select
- if the toon has a known alias that does have a transformation or different set of stats, the alternative alias will be a separate passive toon that is linked to the original
- the player will be able to toggle between active/passive (main and alias) during game play whether or not the identity is known (this should simulate playing as bruce banner or the hulk with separate stats)
- for hidden identities, the alternative toon (alias) can be toggled for use by the player as well, but the player will need to be careful not to reveal their identity (unless they want to).  (this should simulate playing as bruce wayne or batman with the same stats but different attires/mask on).
- added logic to build alt toons and link the back to the originals
- added passive switch for toons so they cannot be selected by the user
- fixed a potential issue with the generic generations -- there was a rare issue where no generics were being generated at times; now there will always be at least one generic available at start of the world
- fixed a rare issue with the game crashing if a new game was created after cancelling out of a new game that was created but not started.
- added an "ALT" button to appear on character select if the selected character has a KNOWN alias (secret aliases will not have this option).
- added test avatars for "geoff clark" (man of iron passive alt), "adrian dodgers" (the captain passive alt), "sean cadillac" (mr. dream secret passive alt)

ALPHA 0.0.036 / 2021.01.23-2135

- removed temp table for generated stats from main db and now using temp memory
- optimized character selection data generation (part 1)
- added methods to support the above features in a more optimized way

ALPHA 0.0.035 / 2021.01.12-2209

- added specific magic types to ability types (holy/dark/effect/ninja) as well as non magic types (attack/defense/passive) to db
- added ability type fields to race and class to enable magic for group to db
- revamped alias field in toon table to be its own table
- aliases can now be assigned as either "just name" (captain america and steve rogers), "name with alternative job - known identity" (iron man and tony stark), "secret identity with name and fake stats for job" (e.g. superman and clark kent), or "secret identity with alternative look/job with stat change" (e.g. hulk and bruce banner)
- added "civilian" generic class for "jobs" (see below)
- added jobs database for aliases
- aliases will have their own profiles and images
- added generic equipment sets for jobs (e.g. clothes for civilians)
- added destiny stat in toon table -- this will be for ai gameplay focus.  currently, it is Competitive, Passive, Justice, Chaos, Limitless Balance, Death.  each will have its own focus in the game.  more details later.
- nulled out the existing alias code for revamp

ALPHA 0.0.034 / 2021.01.06-2240

- restructured generic toon table
- created method to generate generic toons (e.g. no name characters) as filler for the database when the world is created
- created math to randomized number of total generics created
- added randomizer to append to generic name toon
- added generic "Male Criminal" to the test database

ALPHA 0.0.033 / 2021.01.05-2314

- created time system for new games and saved games
- created converter for player to see time in yr/mo/wk/day/hr/min format
- added time column in database
- added time to save data

ALPHA 0.0.032 / 2021.01.04-2255

- fixed rare issue with default intro music not disabling when custom music not enabled in options
- added date (day, week, month, year) and time to game save
- consolidated some code for pulling save game information

ALPHA 0.0.031 / 2021.01.02-0112

- redesigned new game function
- created loading screen for end user to know to wait for loading
- redesigned new game character selection with new look, compatible w/dark mode
- thinned database query command for quicker response
- removed old MainMenuGUI
- rebuild the New Game function and how stats,equip,abl,and items are displayed
- added checks for removing a new game if not used
- removed old NewGameGUI for new version
- temporarily linked in existing versus and battle gui after newgame is set up

ALPHA 0.0.030 / 2020.12.27-1750

- redesigned options, about, and donate in main menu to be within frame instead of popups.
- added social media icons
- rebuild custom music options and how it works (cleaner)
- added complete dark mode/light mode integration (now working)
- add dark mode option to ini -- dark mode is on by default
- completed new load saved game screen with character preview
- added smoother navigation between save games
- improved deleting saved games from menu and real time updating of screen without reloading game

ALPHA 0.0.029 / 2020.12.26-2316

- restructured main menu with foundation for "dark mode" and "light mode"
- rebuild gui for one window instead of multiple windows
- recreated main menu to look more modern
- added random avatar selection for title screen
- centralized menu functions
- disabled old main menu GUI

ALPHA 0.0.028 / 2020.12.24-1441

- added settings ini options for custom victory and loss music
- added table for custom themes for individuals in battle
- fixed issue with some custom themes for individuals not playing
- fixed rare bug with game crash in some load game scenarios
- added ability to "cancel" out of loading a game
- added ability to delete save games from main menu
- added ability to import and delete avatars from the options menu

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