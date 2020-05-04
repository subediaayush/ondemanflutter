<h1>Run in device</h1>

<h4>Release Build</h4>
Go into root folder of your project
```
adb uninstall com.ondemandflutter ; ./gradlew bundleRelease && bundletool build-apks --overwrite --local-testing --bundle app/build/outputs/bundle/release/app-release.aab --output apks/apks.apks && bundletool install-apks --apks apks/apks.apks && adb shell monkey -p com.hamropatro -c android.intent.category.LAUNCHER 1
```

<h4>Debug Build</h4>
Go into root folder of your project
```
adb uninstall com.ondemandflutter ; ./gradlew bundleDebug && bundletool build-apks --overwrite --local-testing --bundle app/build/outputs/bundle/debug/app-debug.aab --output apks/apks.apks && bundletool install-apks --apks apks/apks.apks && adb shell monkey -p com.hamropatro -c android.intent.category.LAUNCHER 1
```
