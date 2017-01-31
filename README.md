# Shopping List
Sample MVP project that allows to create a shopping list with your family or friends. You can create shopping list such as kitchen, library, etc. and you can add people to these lists. Application will send push notification to users that in list if new product is added or existing product removed.

# Libraries
+ **Dagger 2**
+ **RxJava**
+ **OkHttp**
+ **Retfofit**
+ **Retrolamba**
+ **Auto Value**
+ **Gson**
- Espresso
- JUnit 
- Mockito
- DaggerMock
- Timber

# Patterns
+ **<a href="https://github.com/googlesamples/android-architecture/tree/todo-mvp-clean/">Clean MVP Architecture</a>**
+ **<a href="https://martinfowler.com/eaaCatalog/repository.html">Repository Pattern</a>**
+ **<a href="https://martinfowler.com/articles/injection.html">Dependency inversion and dependency injection</a>**
- Continuous integration

# Architectural Design
<img src="https://raw.githubusercontent.com/farukcankaya/shoppinglist/master/art/mvp-clean.png"/>


# Running the project and the tests
Open the project in Android Studio and select the gradle task '**installDebug**' or simply press the Run button.

# Realesing
Project will run when you simply press the Run button in debug mode. But if you want to realease application or export debug release you should configure following files:
- **shoppinglist.appconfig**
```
developmentKeystore=*shoppingListDevelopment.jks*
developmentStorePassword=*store-password*
developmentKeyAlias=*alias*
developmentKeyPassword=*alias-password*

productionKeystore=*shoppingListProduction.jks*
productionStorePassword=*store-password*
productionKeyAlias=*alias*
productionKeyPassword=*alias-password*
```
- **shoppingListDevelopment.jks**
- **shoppingListProduction.jks**

*Note: These files should be in root directory of project.*
