# TestCases4OMDb
This is a maven project written in Java language using the Rest Assured library. The project is an API Test assignment prepared by Trendyol team for Test Automation Engineers.

Using the public api at http://www.omdbapi.com/, the following case was created and tested. 

- Searching for "Harry Potter" with the parameters under the heading "By Search", the id of the movie "Harry Potter and the Sorcerer's Stone" was obtained from the results.
- With this id, movies were searched in the methods under "By ID or Title".
- In the incoming response, the title, year, released fields of the data are checked and the http status is checked.
