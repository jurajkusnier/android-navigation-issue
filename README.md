# android-navigation-issue
Sample project triggering issue with androidx navigation library.

The issues appears after updating Androidx Navigation library from 2.3.5 to 2.4.0/2.4.1.

I have an app with `BottomNavigationView` and 3 fragments: A, B, C. Fragment A contains a button that creates a notification navigating user directly to fragment B. After opening the app via notification it's no longer possible to access fragment A. Navigation to fragments B and C works.

I use `NavDeepLinkBuilder` to create pending intent and `NotificationManagerCompat` to create the notification.

### Demo

https://user-images.githubusercontent.com/2919625/161809157-facee60f-7d91-4085-9a97-18ae80813dd3.mp4

