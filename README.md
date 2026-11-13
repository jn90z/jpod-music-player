# J-Pod Music

An independent Android music player for a self-hosted **Navidrome** server, designed for a familiar dark, artwork-first music experience. This is an original UI, not a Spotify-branded application.

## Status

Early Android scaffold. The initial screens are placeholders; **Navidrome authentication, streaming, offline downloads, and Android Auto are not implemented yet**.

## Planned milestones

1. **Foundation:** Kotlin, Jetpack Compose, Material 3, dark theme, Home/Search/Library navigation and mini-player shell.
2. **Server connection:** Navidrome/Subsonic API configuration, credentials stored securely, connection testing and library browsing.
3. **Playback:** Media3 ExoPlayer, media session, queue, lock-screen and Bluetooth controls.
4. **Library UX:** albums, artists, playlists, search, cover art, favorites, sorting.
5. **Polish:** offline downloads, Android Auto, error handling, accessibility, and release APK workflow.

## Build

Open the project in a recent Android Studio with Android SDK 35 installed. The project uses Gradle 8.11.1, Android Gradle Plugin 8.9.2 and Kotlin 2.1.20. A Gradle wrapper will be added once a local or CI-generated wrapper can be committed.

The Android application ID is `com.jpod.music`. It installs independently from Tempo.

## Privacy

The intended design connects directly to a user-provided Navidrome server (including private Tailscale addresses). No cloud account is required by the app design. Never commit server passwords or API tokens.

## Attribution

This project is a new Android implementation; it does not copy Tempo source code or Spotify branding/assets. If third-party source is incorporated later, its license and attribution requirements must be followed.
