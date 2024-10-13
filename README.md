Berlin Clock
==============

# Rules

The Berlin Clock (Mengenlehreclock or Berlin Uhr) is a clock that tells the time using a series of illuminated coloured blocks, as you can see in the picture for this project.

The top lamp blinks to show seconds- it is illuminated on even seconds and off on odd seconds.

The next two rows represent hours. The upper row represents 5 hour blocks and is made up of 4 red lamps. The lower row represents 1 hour blocks and is also made up of 4 red lamps.

The final two rows represent the minutes. The upper row represents 5 minute blocks, and is made up of 11 lamps- every third lamp is red, the rest are yellow. The bottom row represents 1 minute blocks, and is made up of 4 yellow lamps.

# TDD

Just wanted to point out that it's the first time I used TDD. Glad to have learn it and ready to deepen my learning. 

# How to install
Prerequisites

Before you can install and run the app, you need the following software installed:

	•	Android Studio
	•	Android SDK: Installed and configured in Android Studio.
	•	Java Development Kit (JDK)

Installation

Follow these steps to install and run the project locally:

1.	Clone the repository:

```sh
$ git clone https://github.com/2024-DEV2-016/technical_test/
$ cd technical_test
```

2.	Open the project in Android Studio:
	•	Open Android Studio.
	•	Click on File -> Open.
	•	Navigate to the cloned technical_test folder and select it.
3.	Sync Gradle:
	•	Once the project is opened, Android Studio should automatically sync the Gradle files. If it doesn’t, go to File -> Sync Project with Gradle Files.
	•	Ensure that all dependencies are correctly downloaded.
4.	Run the application:
	•	Connect an Android device via USB or set up an Android Emulator.
	•	Click on the Run button or press ^R to build and run the app.

# Run the tests

This project includes both unit tests and UI tests. You can run them via Android Studio or the command line.

Running Unit Tests

	1.	Unit tests are located in the src/test directory.
	2.	In Android Studio:
	  •	Right-click on the test directory.
	  •	Select Run Tests.

Running UI Tests

	1.	UI tests are located in the src/androidTest directory.
	2.	In Android Studio:
	  •	Right-click on the androidTest directory.
	  •	Select Run Tests.

Alternatively, run the tests from the command line:
```sh
./gradlew test              # Run unit tests
./gradlew connectedAndroidTest  # Run UI tests on connected devices/emulators
```

# Preview result

https://github.com/user-attachments/assets/4490d215-6d40-42c2-91f4-b946c7af7613

# Quick install (APK)

https://drive.google.com/file/d/1pjAvmxMj9MFkLBn_67abhH3cu-MoTDst/view?usp=drive_link

# Sources
Clean code book
[Clean architecture kotlin](https://medium.com/codex/from-junior-to-senior-the-real-way-to-implement-clean-architecture-in-android-8514005e85e1)
[Droidcon](https://www.droidcon.com/2023/07/26/building-high-quality-android-ui-embracing-test-driven-development-with-jetpack-compose/)
[butunclebob](http://butunclebob.com/ArticleS.UncleBob.TheThreeRulesOfTdd)
