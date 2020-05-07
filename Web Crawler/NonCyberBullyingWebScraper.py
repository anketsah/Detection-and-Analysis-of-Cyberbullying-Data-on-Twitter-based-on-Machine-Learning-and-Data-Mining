"""
This is a web scraper that extracts tweets related to Corona virus and writes them to an output CSV file 

"""

import sys
import requests
import csv
import tweepy
from csv import writer

#Enter the consumer API key, API secret, access token and access token secret as provided by Twitter developer account
consumerAPI_key = 'p39Yv5Qqwpbt5V4oEP6sVw5C4'
consumerAPI_secret = 'cWsbwZvwiJhcWmj2BqVuLmMvDcvzhj444Zktz0Wn22TcQ3vnD7'
access_token = '1007607527758917632-IPGuLuOCZVxhL8ExUBsULj8E8L6Ak5'
access_token_secret = 'wv2PTogEFN0DdR2N9d50XkVLSc7SGaU9vWPZXi4yBekrp'

# Pass the API key and API secret as parameters to the authentication handler provided by Tweepy
# Pass the access_token and access_token_secret as parameters to SET_ACCESS_TOKEN 
# Pack these two together into the tweepy API and set the wait on rate limit to True 
auth = tweepy.OAuthHandler(consumerAPI_key, consumerAPI_secret)
auth.set_access_token(access_token, access_token_secret)
api = tweepy.API(auth,wait_on_rate_limit=True)

# Create a CSV file to write the output data to this file and label the header as Cyberbullying
csvFile = open('Non-Cyberbullying_dataset.csv', 'a')
csvWriter = csv.writer(csvFile)
header=['Non-Cyberbullying Data']
csvWriter.writerow(header)

# Iterate through the tweets containing the Cyberbullying hashtags and write each line to the output CSV file
# param @q:      The hashtag that we wish to scrape through to create our dataset
# param @count:  Specifies the number of Tweets to try and retrieve
# param @lang:   The language of the tweets i.e., English
# param @since:  The date until which we want to scrape our data
for i in tweepy.Cursor(api.search,q="#coronavirus", count=60,lang="en", since="2018-04-01").items():
    csvWriter.writerow([i.text.encode('utf-8')])
    
    #If we want to view the output on the terminal along with the date when it was created, un-comment the below line.
    # It retrieves the tweet along with the date when it was tweeted.
    #print (i.created_at, i.text)

