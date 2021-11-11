**1. Update the versions of all libraries in the project and its output**

    a. Command for possible updates: mvn versions:display-dependency-updates
[INFO] The following dependencies in Dependencies have newer versions:  
[INFO]   org.seleniumhq.selenium:selenium-java .............. 3.141.59 -> 4.0.0

    b. Command to update: mvn versions:use-latest-versions
[INFO] versions-maven-plugin:2.8.1:use-latest-versions (default-cli) @ SauceDemo    
[INFO] Major version changes allowed    
[INFO] Updated org.seleniumhq.selenium:selenium-java:jar:3.141.59 to version 4.0.0

**2. Run tests using mvn clean test command**   
`Command -  mvn clean test`

_Output_    
[[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 29.296 s - in TestSuite]()

**3. Use parameters to run specific tests and methods**
`Command -  mvn -Dtest=CartTests test, mvn -Dtest=CartTests#removeProductToCartTest test,
mvn -Dtest=CartTests#removeProductToCartTest+checkOutProductToCartTest test`


_Output tests_    
[[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 21.569 s - in tests.CartTests]()    
_Output methods_    
[[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 6.409 s - in tests.CartTests]()     
_Output 2 methods_  
[[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 10.466 s - in tests.CartTests]()

**4. Throw the parameter from mvn command line inside the test**    
`Command - $ mvn -Dtest=CartTests#checkOutProductToCartTest -Dusername="standard_user" -Dpassword="secret_sauce" test`
_Output_    
[[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.935 s - in tests.CartTests]()


    