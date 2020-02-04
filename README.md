## Expositions Calendar
7. Система Календарь выставок. Существует список Выставочных залов в каждом из которых есть перечень Экспозиций. Посетитель покупает Билеты оформив Платёж  и выбрав Тему выставки.

### Setup 
* JDK 1.8 or higher
* Apache Maven 3.6.3 or higher
* MySQL 8.0.19 or higher
* Apache Tomcat 8.5.50 or higher

### Installation
* Download project from GitHub
* Unpack .zip
* Specify values of "username" and "password" keys in \src\main\java\com\ronving\dao\DataSourceManager.xml
* Start MySQL server and execute script initdb.sql from \src\main\resources\dbscripts to init database
* Then execute scripts from \src\main\resources\dbscripts\export to import data into database
* cd to root project folder and execute command mvn clean install
* copy artifact calendar.war from \target folder to %TOMCAT%\webapps

### Running
* Start Tomcat server by running the script %TOMCAT%\bin\startup.bat for Windows or .sh for Unix based OS.
* After server start, application will be available by URL http://localhost:8080/calendar
* Use login "user" and password "user" to log in with user rights.  
* Use login "admin" and password "admin" to log in with administrator rights. 
* To stop server run script %TOMCAT%\bin\shutdown.bat for Windows or .sh for Unix based OS.
