1-it’s an important part of the MVVM that the ViewModel knows nothing about the View so we should never pass the Fragment to functions of ViewModel. (MainFragment: 18)

2- We should use Repository pattern to implement separation of concerns by abstracting the data persistence logic in our application so we can use repository instead of database in our ViewModel.( MainViewModel: 10)

3- Another important part of the MVVM is The Observable design pattern which was not used in this project, for example there was no trace of any liveData and its observer or DataBinding in the code. (MainViewModel:21)

4- We should  use ViewModelProvider  and Factory Design Pattern to instantiate a ViewModel instead of Creating it manually with simple constructor to take advantage of its lifecycle management (MainViewModel: 18)

5- By following the principles of DI, we can provide the following advantages:
(MainViewModel:10,11 SimDB: 12)
* Ease of testing
* Reusability of code
* Ease of refactoring
6- We can improve navigation by using Navigation Components and SafeArgs.
( MainActivity: 21 MainFragment: 24)
