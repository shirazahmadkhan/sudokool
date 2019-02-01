# Sudokool

Sudokool is Java based implementation of the popular Sudoku game.

## Features

* Play unlimited puzzles in 4 difficulty levels : Simple, Easy, Medium and Hard.
* Option to play with Hints : view all the possibilities on the puzzle grid.
* Option to play with warnings in case of wrong entries.
* User can input puzzle (from newspapers) directly on the grid. Then puzzle is validated and if solution is unique, it can be played.
* User can save and load Games.
* 3 lowest timings in each difficulty level are recorded and updated on each puzzle submission.
* Game can be paused and resumed during gameplay.
* Platform independent : Based on Java, Sudokool works flawlessly on all the platforms
* Puzzle window can be resized and the window is loaded to this size next time automatically.
* Fully controllable through keyboard
* Fastest timings stored with username
* Warning made dynamic and stored as a preference
* Storing user statistics
* Cool looks to provide the best GUI experience.

![Sudokool](https://github.com/shirazahmadkhan/sudokool/blob/master/screenshot.jpg)

## Build
```sh
$ ant jar
```

## Run
``` sh
$ ant run
```
or 
```sh
$ java -jar Sudokool.jar
```
