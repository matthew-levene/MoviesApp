# MoviesApp
A simple android app that allows a user to search for a movie from https://movies-sample.herokuapp.com/api/movies. WorkManager is used to periodically call the network API every 10 minutes.

# Technologies Used
- Android Architecture Components (LiveData, ViewModel, WorkManager)
- Koin Dependency Injection
- Espresso UI Testing
- Mockk Unit Testing

# Suggested Improvements
- Add a second fragment to app, so that the user can click on RecyclerView items and see more information about the movie
- Provide better error handling for movies that do not have a cover poster.


