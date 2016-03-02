# Demo Threads and Processes

## About

This project is intended to demo the concepts of Threads and Processes in Android. The wrong and right ways of coding computationally intensive or latency heavy tasks.

## Concepts

Andoid UI toolkit is not thread-safe. So, you must not manipulate your UI from a worker thread—you must do all manipulation to your user interface from the UI thread. Thus, there are simply two rules to Android's single thread model:
  1. Do not block the UI thread
  2. Do not access the Android UI toolkit from outside the UI thread

### Alternatives

* View.post(Runnable) or View.postDelayed(Runnable, long) [see Alternative1Activity.java, Line 48]
* Activity.runOnUiThread(Runnable) [see Alternative2Activity.java, Line 48]
* Handler [see Alternative3Activity.java, Line 52]
* AsyncTask (This one is ideal)  [see BetterAlternativeActivity.java, Line 48]

## Inspiration, References and Sources
* [Develop > API Guides > Processes and Threads](http://developer.android.com/guide/components/processes-and-threads.html)
* The following services can be used to fetch Random Pictures (They are called as Placeholder Image Sites, primarily for help to Designers :)
    - [LoremPixel](http://lorempixel.com/)
    - [LoremFlickr](http://loremflickr.com/150/150/dog)
    - [PlaceKitten](http://placekitten.com/)
    - [PlaceDog](http://placedog.com/)
    - [Placehold.it](http://placehold.it/)
    - [DummyImage](http://dummyimage.com/)
    - [SheenHolders](http://sheenholders.com/)
    - [FlickHoldr](http://flickholdr.com/)
    - [Griddle.it](http://griddle.it/)

