# Java Photo Viewer (On Hiatus)

## Introduction
### Program Status
This program's development is currently on hiatus.   
Much of the program works, but needs to be properly repackaged.   
Feel free to look at the code directly.

### What this program does
This program presents all the imags from a given user directory.   
The user can also:

- Zoom into a image
- Edit the tags of a photo
- Edit the photo itself

The program also remembers the list inbetween sessions.

### Where this repository comes from
This repository is the work from, and for, the cs213 assignment: *"Song Library"*.   
[The course](https://www.cs.rutgers.edu/academics/undergraduate/course-synopses/course-details/01-198-213-software-methodology) was taken during Spring 2021

---
## Installation

### REQUIRMENTS

* JavaFX 17
* JavaSDK 11

### Cloning the repository (via terminal)
`git clone https://github.com/AdamFariello/Java-Photo-Viewer`

### Downloading JavaFx
Download the library [here](https://gluonhq.com/products/javafx/)

### Setting up the project

#### Using eclipse (How I would do it)
1. Download eclipse from [their site](https://www.eclipse.org/downloads/packages/),
2. Go into: File -> Import -> General -> Existing Project into WorkSpace
3. Go into: Java Build Path -> Libraries -> Add External Jars -> Where JavaFX is downloaded
4. Go into: run configurations (for src/songlib.java) -> arguments -> add to VM arguments:
  "`-–module-path –add-modules javafx.controls,javafx.fxml,javafx.media`"

#### Using eclipse (JavaFX creator recomendations) 
Read the documentation [here](https://openjfx.io/openjfx-docs/#IDE-Eclipse).

#### Alternative methods
If some other method is required, or just wanted -- follow the
[tutorial in the documentation](https://openjfx.io/openjfx-docs/#introduction).

---

## EXECUTION
* Run file `main.java` from src/general
