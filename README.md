Resourceful
===========

Android resource binding for Kotlin

```kotlin
class TestView(context: Context) : View(context) {
    private val color: Int by bindColor(R.color.test_color)
    private val dimen: Float by bindDimen(R.dimen.test_dimen)
    private val dimenPx: Int by bindDimenPixelSize(R.dimen.test_dimen)
    private val string: String by bindString(R.string.test_string)
}
```

These methods are available on subclasses of `Activity`, `View`, `Dialog`, `DialogFragment`, `Fragment`, the support library `Fragment`, the support library `DialogFragment`, and recycler view's `ViewHolder`

```kotlin
class TestResourceable(private val context: Context) : Resourceable {
    private val color: Int by bindColor(R.color.test_color)
    private val dimen: Float by bindDimen(R.dimen.test_dimen)
    private val dimenPx: Int by bindDimenPixelSize(R.dimen.test_dimen)
    private val string: String by bindString(R.string.test_string)

    override fun getContext(): Context = context
}
```

Classes that implement `Resourceable` can also use bind methods

Download
--------

In root build.gradle at the end of repositories
```gradle
allprojects {
  repositories {
    ..
    maven { url 'https://jitpack.io' }
    }
}
```
Add the dependency in app build.gradle
```gradle
dependencies {
  compile 'com.github.rstanic12:Resourceful:1.1.1'
}
```