# TheWord Security Word Generator

TheWord is a simple yet effective Android application that generates a synchronized, offline, hourly security word. It's designed for scenarios where a shared, time-based, and easily memorable secret is needed without relying on network connectivity.

## Project Overview

The core functionality of the app revolves around generating a unique word every hour based on a user-defined "salt" (a master password). This word is derived by hashing the current time (formatted as `yyyy-MM-dd-HH`) combined with the salt using a hashing algorithm. The resulting hash is then used to select a word from a predefined list, ensuring that the same word is generated across all devices using the same salt.

## Features

- **Offline Operation**: The app works entirely offline, making it ideal for secure environments with no internet access.
- **Time-Synchronized**: A new security word is generated every hour, ensuring that the secret is regularly refreshed.
- **Customizable Salt**: Users can set their own salt, which acts as a master password to ensure the generated words are unique to their group.
- **Persistent Storage**: The user-defined salt is stored securely on the device using SharedPreferences.
- **Adaptive UI**: The app supports both portrait and landscape orientations and adapts to the system's light and dark themes.

## Technical Details

### SDK and Tooling Versions

- **Compile SDK Version**: 35
- **Target SDK Version**: 35
- **Minimum SDK Version**: 21
- **Build Tools Version**: "35.0.0"

### Gradle Version

- **Android Gradle Plugin**: 8.4.1
- **Kotlin Gradle Plugin**: 2.0.0

### Library Versions

- **Kotlin**: `org.jetbrains.kotlin:kotlin-stdlib:2.0.0`
- **Core KTX**: `androidx.core:core-ktx:1.13.1`
- **AppCompat**: `androidx.appcompat:appcompat:1.7.0`
- **Material Components**: `com.google.android.material:material:1.12.0`
- **ConstraintLayout**: `androidx.constraintlayout:constraintlayout:2.1.4`
- **JUnit**: `junit:junit:4.13.2`
- **AndroidX Test JUnit**: `androidx.test.ext:junit:1.2.1`
- **Espresso Core**: `androidx.test.espresso:espresso-core:3.6.1`

## Build Instructions (Linux)

To compile the project under Linux, follow these steps:

1.  **Clone the Repository**:
    ```bash
    git clone https://github.com/your-username/the-word.git
    cd the-word
    ```

2.  **Set Up Android SDK**:
    - Make sure you have the Android SDK installed. You can download it from the [official Android developer website](https://developer.android.com/studio).
    - Ensure the `ANDROID_HOME` environment variable is set to the path of your Android SDK installation.
    ```bash
    export ANDROID_HOME=/path/to/your/android/sdk
    ```

3.  **Grant Execution Permissions**:
    - The Gradle wrapper script (`gradlew`) needs execution permissions.
    ```bash
    chmod +x gradlew
    ```

4.  **Build the Project**:
    - Use the Gradle wrapper to build the project. The following command will assemble the debug version of the app.
    ```bash
    ./gradlew assembleDebug
    ```
    - The resulting APK will be located in the `app/build/outputs/apk/debug/` directory.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
