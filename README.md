
Have you always wanted a plugin that would allow you to build to the hub without filling it with blocks, possibly, all configurable, to make it the way you want? Well, this is the plugin for you

New HubBlock plugin!

NEW GUIDE FOR BUILD ZONE

Use technoblocks.use for add at the user  a timer of the block been removed, if you don't use this permission a player can place block and block don't be removed, so if you want use WORLDGUARD, you can use the flag for antibuild, to the zone where the player don't can place blocks



[SPOILER="config.yml"]
[code]# By TechnoAde#1350

Version: "${project.version}"

configurationreloaded: "&b&lTechnoBlocks &8» &7Config reloaded" #/technoblocks reload message
noargsselect: "&b&lTechnoBlocks &8» &7No args selected" #No args used message
nopermsmsg: "&b&lTechnoBlocks &8» &cYou don't have permission"
nocreative: "&b&lTechnoBlocks &8» &cYou don't must be in creative"

selector:
  enable: true
  type: CHEST
  name: "&b&lSelector"
  lore:
    - "&7Amazing Selector!"
    - "&7With multiline!"
  amount: 1
  slotonjoin: 7

slotgive: 4 #General slot give
timerforblock: 60 #This is the value MEASURED IN TICK (20 ticks = 1 second) of the time that the block after its placement will take to eliminate itself

#     ____  _   _  ___
#    / ___|| | | ||_ _|
#   | |  _ | | | | | |
#   | |_| || |_| | | |
#    \____| \___/ |___|
#

gui:
  noperms: "&b&lTechnoBlocks &8» &cYou don't have permission to use Block Selector"
  guititle: "&8Block Selector" #Title of the GUI
  guisize: 27 #Size of gui
  firstitempos: 11
  seconditempos: 13
  thirditempos: 15
  missingpermission: "&b&lYou can't select this block!" #technoblocks.gui.use.item3/2
  item1: #First Item
    type: WOOL #Type of item
    name: "&bWool" #Name of item
    lore:
      - "&7Select wool" #Lore of item
    quantitygive: 64 #Quantity of given blocks
  item2: #Second item
    type: WOOD #Type of item
    name: "&bWood" #Name of item
    lore:
      - "&7Select Wood" #Lore of item
    quantitygive: 64 #Quantity of given blocks
    missingpermission: "&b&lYou can't select this block!" #technoblocks.gui.use.item2
  item3: #Third item
    type: OBSIDIAN #Type of item
    name: "&bObsidian" #Name of item
    lore:
      - "&7Select obsidian" #Lore of item
    quantitygive: 64 #Quantity of given blocks[/code]
[/SPOILER]



    Fully configurable plugin
    GUI with which to choose the blocks to be placed
    Blocks are eliminated after a certain time that can be configured via config

     
Here you can see the list of subcommands with their description and permission, which can be changed to your liking from the configuration.
The plugin's main command is /enchantedgangs, it can be configured and changed from the main configuration.


    /technoblocks reload | technoblocks.reload
    /technoblocks list | technoblocks.list
    /blockselector | technoblocks.gui.use

