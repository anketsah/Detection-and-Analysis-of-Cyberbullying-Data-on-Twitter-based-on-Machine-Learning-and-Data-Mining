# Detection and Analysis of Cyberbullying Data on Twitter based on Machine Learning & Data-Mining


## What is it?
A Data Analytics project that makes use of Naive Bayes Machine learning model to detect and analyze tweets related to Cyberbullying.

## Technologies Used
Python for Web Scraping and Data Visualiztion.\
Java for pre-processing/cleaning the data and analyzing it using Naive Bayes.


## How it Works

1. The very first step in execution is to crawl data and create the dataset.



2. Open the Web Crawler folder that contains the files:
	- CyberbullyingWebScraper.py
	- NonCyberBullyingWebScraper.py
	  These programs require tweepy library to run. To install tweepy on your system, enter the command: 
	  
	  ```	$  python3 -m pip install tweepy
	  ```


3. After installing tweepy, run these files on the command prompt using the command
	```$ python3 CyberbullyingWebScraper.py
	```
	
	```$ python3 NonCyberBullyingWebScraper.py
	```



4. The first command will scrape for cyberbullying tweets and write them to the output file named ```Cyberbullying_dataset.csv```
  
   The second command will scrape for research related corona virus tweets and write them to the output file named ```Non-Cyberbullying_dataset.csv```



5. Copy the data from non-cyberbullying dataset and paste it into the Cyberbullying_dataset file. The dataset is ready for the next step.



6. The next step is to run the Machine learning model that uses Naive Bayes classifier. This Java project is implemented using Eclipse IDE and Java version 8.



7. Open Eclipse IDE and choose import existing project. Then import the java project (which is the cs267CyberbullyingDetection-master folder), into the running environment. Use the default configuration to run.



8. All the training and test data sets are included in the java project itself. The file paths are defined in the class test.java. If you wish to use some other training and testing files, manually change those file paths as defined in the Main method. 



9. Open test.java file and click on run to execute the program.



10. The output can be viewed on the console!



11. Now, the final step is to visualize this output data using matplot library provided by python.



12. Open the Data Visualization folder that contains the files:
	- CyberbullyingDV.py
	- Non-CyberbullyingDV.py



13. Run these files on the command prompt using the command
	``` $ python3 CyberbullyingDV.py
	```
	``` $ python3 Non-CyberbullyingDV.py
	```



14. Hooray!! The visualized results can now be seen!
