# Memes-Lib

This library provides an easy way to fetch random (DANK) meme(s) from Reddit. It is based on the [D3vd/Meme_Api](https://github.com/D3vd/Meme_Api) , and I thank them for their amazing work.

## Tech Stack

This library is built using [Retrofit](https://square.github.io/retrofit/) for making HTTP requests and [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) for managing asynchronous operations. 


## Usage

Add the following code in your settings.gradle's dependencyResolutionManagement block -

```gradle
allprojects {
  repositories {
   ...
   maven { url 'https://jitpack.io' }
  }
}
```

Add the dependency in your project's build.gradle (app level) file's dependency block - 
```gradle
dependencies {
  implementation 'com.github.Sparsh011:memes-lib:1.2'
}
```

Note - Even though library handles internet permission on its own, it is still recommended to add internet permission in your AndroidManifest file.
```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.myapp">

    <!-- Add the INTERNET permission here -->
    <uses-permission android:name="android.permission.INTERNET" />

    <application
        ...
    </application>

</manifest>
```




### Single Meme

To fetch a single meme, use the following code :

```kotlin
val memesLib = MemesLib()
memesLib.getSingleMeme { response ->
    if (response != null) {
        val meme = response
        // Handle UI here
    } else {
        // Handle null response
    }
}
```

Example Response (you will get an object of class Meme containing the following values) - 
```javascript
{
  "postLink": "https://redd.it/jiovfz",
  "subreddit": "dankmemes",
  "title": "*leaves call*",
  "url": "https://i.redd.it/f7ibqp1dmiv51.gif",
  "nsfw": false,
  "spoiler": false,
  "author": "Spartan-Yeet",
  "ups": 3363,

  // preview images of the meme sorted from lowest to highest quality
  "preview": [
    "https://preview.redd.it/f7ibqp1dmiv51.gif?width=108&crop=smart&format=png8&s=02b12609100c14f55c31fe046f413a9415804d62",
    "https://preview.redd.it/f7ibqp1dmiv51.gif?width=216&crop=smart&format=png8&s=8da35457641a045e88e42a25eca64c14a6759f82",
    "https://preview.redd.it/f7ibqp1dmiv51.gif?width=320&crop=smart&format=png8&s=f2250b007b8252c7063b8580c2aa72c5741766ae",
    "https://preview.redd.it/f7ibqp1dmiv51.gif?width=640&crop=smart&format=png8&s=6cd99df5e58c976bc115bd080a1e6afdbd0d71e7"
  ]
}
```

### Multiple Memes (MAX 50)
To fetch multiple memes, use the following code :

```kotlin
val memesLib = MemesLib()
val count = 5
memesLib.getMultipleMemes(count = count) { response ->
    if (response != null && response.memes != null) {
        val memes = response.memes
        // Handle UI here
    } else {
        // Handle null response
    }
}
```

Example Response (you will get an object of class Memes containing the following values) - 
```javascript
{
  "count": 2,
  "memes": [
    {
      "postLink": "https://redd.it/jictqq",
      "subreddit": "dankmemes",
      "title": "Say sike",
      "url": "https://i.redd.it/j6wu6o9ncfv51.gif",
      "nsfw": false,
      "spoiler": false,
      "author": "n1GG99",
      "ups": 72823,
      "preview": [
        "https://preview.redd.it/j6wu6o9ncfv51.gif?width=108&crop=smart&format=png8&s=3b110a4d83a383b7bfebaf09ea60d89619cddfb3",
        "https://preview.redd.it/j6wu6o9ncfv51.gif?width=216&crop=smart&format=png8&s=ba5808992b3245a6518dfe759cbe4af24e042f2d",
        "https://preview.redd.it/j6wu6o9ncfv51.gif?width=320&crop=smart&format=png8&s=7567bb64e639223e3603236f774eeca149551313"
      ]
    },
    {
      "postLink": "https://redd.it/jilgdw",
      "subreddit": "dankmemes",
      "title": "I forgot how hard it is to think of a title",
      "url": "https://i.redd.it/jk12rq8nrhv51.jpg",
      "nsfw": false,
      "spoiler": false,
      "author": "TheRealKyJoe01",
      "ups": 659,
      "preview": [
        "https://preview.redd.it/jk12rq8nrhv51.jpg?width=108&crop=smart&auto=webp&s=d5d3fe588ccff889e61fca527c2358e429845b80",
        "https://preview.redd.it/jk12rq8nrhv51.jpg?width=216&crop=smart&auto=webp&s=b560b78301afd8c173f8c702fbd791214c1d7f61",
        "https://preview.redd.it/jk12rq8nrhv51.jpg?width=320&crop=smart&auto=webp&s=3cd427240b2185a3691a818774214fd2a0de124d",
        "https://preview.redd.it/jk12rq8nrhv51.jpg?width=640&crop=smart&auto=webp&s=1142cc19a746b8b5d8335679d1d36127f4a677b9"
      ]
    }
  ]
}
```

For more details on API, visit [D3vd/Meme_Api](https://github.com/D3vd/Meme_Api)

## License

This library is released under the MIT License.

---

MIT License

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
