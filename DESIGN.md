# OVERVIEW-

## SERVER

### Requirements -
1. Server to store player data
  - Login info
  - Games
  - Save files
  - Hours played
  - Score
  - Preferences

2. Server to supply the game roms
  - Search by title
  - Search by genre
  - ML recommendation
  
3. Store and manage the postgress database
  - Maybe make a REST API

### Tech Stack -
1. Running Locally on someone's machine
2. Java Spring Boot
3. Kotlin K-Tor


## Android App -

### Requirements -
1. UI : login, save, access server, get roms, play a game
2. Game: C++ module with native game
3. Download 

### Tech Stack -
1. Kotlin and Jetpack compose for UI 


## Web App -

### Requirements-
1. Same as Android App
2. No Download

### Tech Stack - 
1. Kotlin Multiplatform
2. Web Assembly


# USE FLOW- 

## SPLASH / LOGIN-
- Establish connection with server and basic ping pong
- Android : 
  - Load last saved credentials from local database
  - Do file i/o, get read permissions, construct offline game roms scaffolding
  - Send locally cached data to the server, any games updated in local databse, update to the server too
- Login Screen -
  - Option 1 : guest login in android, will login later, lose any connection with server, store no save files 
  - Option 2 : Server login authentication API.


## CATALOGUE-
- Bottom Navigation Bar 
- Show all games, see user info
- The most popular games on the server / featured games on the top row
- The next is your library games (saved / faviorites)
- The rest are featured pinterest styled


## USER INFO-
- Just an image, gamer tag
- Stats from the server/database 
- Hours played


## GAME SCREEN -
- Vertical (Mimics Original Gameboy)
  - main screen at top, expanded to get as big as possible
  - L, R buttons on the very top 
  - movement buttons on the left
  - a, b buttons on the right
  - select and start on the bottom
  - below select and start, we have a interface button - (to pause the game, change settings, read / write save file, quit, reset the game)
  
## RATE US-
- On Android - google play
- On Web     - github stars
- Shown after playing the first game subsequently after every 10~50 uses until rating has been given


# CODE -

## Kotlin
- Packages for each feature 
  - Data Layer (Implementation) 
  - Domain Layer (Abstractions)
  - Presentation Layer (UI)

- Data and Presentation can use Domain, Domain doesnt know that the other two exist.

## JS-
- Move to typescript instead
- Provide wrappers over all C/C++ functions

## C++-
- Doesnt own memory
- Memory is handed to it

- Emulator API -
  - LoadRom(ROM DATA)         : Success or Fail
  - LoadSaveFile(FILE DATA)   : Success or Fail
  - Game Tick 

## SERVER-
- Authentication API - 
  - Register    USER
  - Login       USER 
  - Delete      USER


# REALLY CHALLENGING PARTS-

## APU
- Hard to emulate 
- No idea how cross-platform sound works 
- We want to not play a sound file not a specific frequency for a specific
time
