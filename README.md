# Demo Threads and Processes

## About

This project is intended to demo the concepts of Threads and Processes in Android. The wrong and right ways of coding computationally intensive or latency heavy tasks.

## Concepts

Andoid UI toolkit is not thread-safe. So, you must not manipulate your UI from a worker thread—you must do all manipulation to your user interface from the UI thread. Thus, there are simply two rules to Android's single thread model:
1. Do not block the UI thread
2. Do not access the Android UI toolkit from outside the UI thread

### Alternatives

## Inspiration, References and Sources
* [Develop > API Guides > Processes and Threads](http://developer.android.com/guide/components/processes-and-threads.html)