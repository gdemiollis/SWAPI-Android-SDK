# SWAPI-Java-SDK
The SWAPI (Star Wars API) SDK for Java

This repository has been forked from [Oleur/SWAPI-Android-SDK](https://github.com/Oleur/SWAPI-Android-SDK)

The main work was to update libs (gradle, sdkVersion, Retrofit)
Some tests were added on the Model et the Api calls
tests can be run with 
```sh
$ ./gradlew clean test
```

###TODOS
- Make sure Retrofit, OkHttpClient and Endpoint are just created once, not for each *Api class
- In model, remove public field and replace by getter (Easyer to Mock in test) 
